/*
 * Copyright (2021) The Delta Lake Project Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql.delta

import org.apache.spark.sql.delta.DeltaOperations.ManualUpdate
import org.apache.spark.sql.delta.actions.{Action, AddFile, CommitInfo, Metadata, Protocol, RemoveFile, SetTransaction}
import org.apache.spark.sql.delta.sources.DeltaSQLConf
import org.apache.spark.sql.delta.util.FileNames
import org.apache.hadoop.fs.Path

import org.apache.spark.sql.catalyst.dsl.expressions._
import org.apache.spark.sql.catalyst.expressions.{EqualTo, Literal}
import org.apache.spark.sql.types.{IntegerType, StructType}
import org.apache.spark.util.ManualClock


class OptimisticTransactionSuite
  extends OptimisticTransactionLegacyTests
  with OptimisticTransactionSuiteBase {

  // scalastyle:off: removeFile
  private val addA = AddFile("a", Map.empty, 1, 1, dataChange = true)
  private val addB = AddFile("b", Map.empty, 1, 1, dataChange = true)

  /* ************************** *
   * Allowed concurrent actions *
   * ************************** */

  check(
    "append / append",
    conflicts = false,
    reads = Seq(
      t => t.metadata
    ),
    concurrentWrites = Seq(
      addA),
    actions = Seq(
      addB))

  check(
    "disjoint txns",
    conflicts = false,
    reads = Seq(
      t => t.txnVersion("t1")
    ),
    concurrentWrites = Seq(
      SetTransaction("t2", 0, Some(1234L))),
    actions = Nil)

  check(
    "disjoint delete / read",
    conflicts = false,
    setup = Seq(
      Metadata(
        schemaString = new StructType().add("x", IntegerType).json,
        partitionColumns = Seq("x")),
      AddFile("a", Map("x" -> "2"), 1, 1, dataChange = true)
    ),
    reads = Seq(
      t => t.filterFiles(EqualTo('x, Literal(1)) :: Nil)
    ),
    concurrentWrites = Seq(
      RemoveFile("a", Some(4))),
    actions = Seq())

  check(
    "disjoint add / read",
    conflicts = false,
    setup = Seq(
      Metadata(
        schemaString = new StructType().add("x", IntegerType).json,
        partitionColumns = Seq("x"))
    ),
    reads = Seq(
      t => t.filterFiles(EqualTo('x, Literal(1)) :: Nil)
    ),
    concurrentWrites = Seq(
      AddFile("a", Map("x" -> "2"), 1, 1, dataChange = true)),
    actions = Seq())

  /* ***************************** *
   * Disallowed concurrent actions *
   * ***************************** */

  check(
    "delete / delete",
    conflicts = true,
    reads = Nil,
    concurrentWrites = Seq(
      RemoveFile("a", Some(4))),
    actions = Seq(
      RemoveFile("a", Some(5))))

  check(
    "add / read + write",
    conflicts = true,
    setup = Seq(
      Metadata(
        schemaString = new StructType().add("x", IntegerType).json,
        partitionColumns = Seq("x"))
    ),
    reads = Seq(
      t => t.filterFiles(EqualTo('x, Literal(1)) :: Nil)
    ),
    concurrentWrites = Seq(
      AddFile("a", Map("x" -> "1"), 1, 1, dataChange = true)),
    actions = Seq(AddFile("b", Map("x" -> "1"), 1, 1, dataChange = true)),
    // commit info should show operation as truncate, because that's the operation used by the
    // harness
    errorMessageHint = Some("[x=1]" :: "TRUNCATE" :: Nil))

  check(
    "add / read + no write",  // no write = no real conflicting change even though data was added
    conflicts = false,        // so this should not conflict
    setup = Seq(
      Metadata(
        schemaString = new StructType().add("x", IntegerType).json,
        partitionColumns = Seq("x"))
    ),
    reads = Seq(
      t => t.filterFiles(EqualTo('x, Literal(1)) :: Nil)
    ),
    concurrentWrites = Seq(
      AddFile("a", Map("x" -> "1"), 1, 1, dataChange = true)),
    actions = Seq())

  check(
    "add in part=2 / read from part=1,2 and write to part=1",
    conflicts = true,
    setup = Seq(
      Metadata(
        schemaString = new StructType().add("x", IntegerType).json,
        partitionColumns = Seq("x"))
    ),
    reads = Seq(
      t => {
        // Filter files twice - once for x=1 and again for x=2
        t.filterFiles(Seq(EqualTo('x, Literal(1))))
        t.filterFiles(Seq(EqualTo('x, Literal(2))))
      }
    ),
    concurrentWrites = Seq(
      AddFile(
        path = "a",
        partitionValues = Map("x" -> "1"),
        size = 1,
        modificationTime = 1,
        dataChange = true)
    ),
    actions = Seq(
      AddFile(
        path = "b",
        partitionValues = Map("x" -> "2"),
        size = 1,
        modificationTime = 1,
        dataChange = true)
    ))

  check(
    "delete / read",
    conflicts = true,
    setup = Seq(
      Metadata(
        schemaString = new StructType().add("x", IntegerType).json,
        partitionColumns = Seq("x")),
      AddFile("a", Map("x" -> "1"), 1, 1, dataChange = true)
    ),
    reads = Seq(
      t => t.filterFiles(EqualTo('x, Literal(1)) :: Nil)
    ),
    concurrentWrites = Seq(
      RemoveFile("a", Some(4))),
    actions = Seq(),
    errorMessageHint = Some("a in partition [x=1]" :: "TRUNCATE" :: Nil))

  check(
    "schema change",
    conflicts = true,
    reads = Seq(
      t => t.metadata
    ),
    concurrentWrites = Seq(
      Metadata()),
    actions = Nil)

  check(
    "conflicting txns",
    conflicts = true,
    reads = Seq(
      t => t.txnVersion("t1")
    ),
    concurrentWrites = Seq(
      SetTransaction("t1", 0, Some(1234L))),
    actions = Nil)

  check(
    "upgrade / upgrade",
    conflicts = true,
    reads = Seq(
      t => t.metadata
    ),
    concurrentWrites = Seq(
      Protocol()),
    actions = Seq(
      Protocol()))

  check(
    "taint whole table",
    conflicts = true,
    setup = Seq(
      Metadata(
        schemaString = new StructType().add("x", IntegerType).json,
        partitionColumns = Seq("x")),
      AddFile("a", Map("x" -> "2"), 1, 1, dataChange = true)
    ),
    reads = Seq(
      t => t.filterFiles(EqualTo('x, Literal(1)) :: Nil),
      // `readWholeTable` should disallow any concurrent change, even if the change
      // is disjoint with the earlier filter
      t => t.readWholeTable()
    ),
    concurrentWrites = Seq(
      AddFile("b", Map("x" -> "3"), 1, 1, dataChange = true)),
    actions = Seq(
      AddFile("c", Map("x" -> "4"), 1, 1, dataChange = true)))

  check(
    "taint whole table + concurrent remove",
    conflicts = true,
    setup = Seq(
      Metadata(schemaString = new StructType().add("x", IntegerType).json),
      AddFile("a", Map.empty, 1, 1, dataChange = true)
    ),
    reads = Seq(
      // `readWholeTable` should disallow any concurrent `RemoveFile`s.
      t => t.readWholeTable()
    ),
    concurrentWrites = Seq(
      RemoveFile("a", Some(4L))),
    actions = Seq(
      AddFile("b", Map.empty, 1, 1, dataChange = true)))

  test("initial commit without metadata should fail") {
    withTempDir { tempDir =>
      val log = DeltaLog.forTable(spark, new Path(tempDir.getCanonicalPath))
      val txn = log.startTransaction()
      withSQLConf(DeltaSQLConf.DELTA_COMMIT_VALIDATION_ENABLED.key -> "true") {
        val e = intercept[DeltaIllegalStateException] {
          txn.commit(Nil, ManualUpdate)
        }
        assert(e.getMessage == DeltaErrors.metadataAbsentException().getMessage)
      }
    }
  }

  test("initial commit with multiple metadata actions should fail") {
    withTempDir { tempDir =>
      val log = DeltaLog.forTable(spark, new Path(tempDir.getAbsolutePath))
      val txn = log.startTransaction()
      val e = intercept[AssertionError] {
        txn.commit(Seq(Metadata(), Metadata()), ManualUpdate)
      }
      assert(e.getMessage.contains("Cannot change the metadata more than once in a transaction."))
    }
  }

  test("AddFile with different partition schema compared to metadata should fail") {
    withTempDir { tempDir =>
      val log = DeltaLog.forTable(spark, new Path(tempDir.getAbsolutePath))
      log.startTransaction().commit(Seq(Metadata(
        schemaString = StructType.fromDDL("col2 string, a int").json,
        partitionColumns = Seq("col2"))), ManualUpdate)
      withSQLConf(DeltaSQLConf.DELTA_COMMIT_VALIDATION_ENABLED.key -> "true") {
        val e = intercept[IllegalStateException] {
          log.startTransaction().commit(Seq(AddFile(
            log.dataPath.toString, Map("col3" -> "1"), 12322, 0L, true, null, null)), ManualUpdate)
        }
        assert(e.getMessage == DeltaErrors.addFilePartitioningMismatchException(
          Seq("col3"), Seq("col2")).getMessage)
      }
    }
  }

  test("isolation level shouldn't be null") {
    withTempDir { tempDir =>
      val log = DeltaLog.forTable(spark, new Path(tempDir.getCanonicalPath))

      log.startTransaction().commit(Seq(Metadata()), ManualUpdate)

      val txn = log.startTransaction()
      txn.commit(addA :: Nil, ManualUpdate)

      val isolationLevels = log.history.getHistory(Some(10)).map(_.isolationLevel)
      assert(isolationLevels.size == 2)
      assert(isolationLevels(0).exists(_.contains("Serializable")))
      assert(isolationLevels(0).exists(_.contains("Serializable")))
    }
  }

  test("every transaction should use a unique identifier in the commit") {
    withTempDir { tempDir =>
      // Initialize delta table.
      val log = DeltaLog.forTable(spark, new Path(tempDir.getCanonicalPath))
      log.startTransaction().commit(Seq(Metadata()), ManualUpdate)

      // Start two transactions which commits at same time with same content.
      val clock = new ManualClock()
      val txn1 = new OptimisticTransaction(log)(clock)
      val txn2 = new OptimisticTransaction(log)(clock)
      clock.advance(100)
      val version1 = txn1.commit(Seq(), ManualUpdate)
      val version2 = txn2.commit(Seq(), ManualUpdate)

      // Validate that actions in both transactions are not exactly same.
      def readActions(version: Long): Seq[Action] = {
        log.store.read(FileNames.deltaFile(log.logPath, version), log.newDeltaHadoopConf())
          .map(Action.fromJson)
      }
      def removeTxnIdFromActions(actions: Seq[Action]): Seq[Action] = actions.map {
        case c: CommitInfo => c.copy(txnId = None)
        case other => other
      }
      val actions1 = readActions(version1)
      val actions2 = readActions(version2)
      val actionsWithoutTxnId1 = removeTxnIdFromActions(actions1)
      val actionsWithoutTxnId2 = removeTxnIdFromActions(actions2)
      assert(actions1 !== actions2)
      // Without the txn id, the actions are same as of today but they need not be in future. In
      // future we might have other fields which may make these actions from two different
      // transactions different. In that case, the below assertion can be removed.
      assert(actionsWithoutTxnId1 === actionsWithoutTxnId2)
    }
  }

  test("pre-command actions committed") {
    withTempDir { tempDir =>
      // Initialize delta table.
      val log = DeltaLog.forTable(spark, new Path(tempDir.getCanonicalPath))
      log.startTransaction().commit(Seq(Metadata()), ManualUpdate)

      val clock = new ManualClock()
      val txn = new OptimisticTransaction(log)(clock)
      txn.updateSetTransaction("TestAppId", 1L, None)
      val version = txn.commit(Seq(), ManualUpdate)

      def readActions(version: Long): Seq[Action] = {
        log.store.read(FileNames.deltaFile(log.logPath, version), log.newDeltaHadoopConf())
          .map(Action.fromJson)
      }
      val actions = readActions(version)
      assert(actions.collectFirst {
        case SetTransaction("TestAppId", 1L, _) =>
      }.isDefined)
    }
  }

  test("has SetTransaction version conflicts") {
    withTempDir { tempDir =>
      // Initialize delta table.
      val log = DeltaLog.forTable(spark, new Path(tempDir.getCanonicalPath))
      log.startTransaction().commit(Seq(Metadata()), ManualUpdate)

      val clock = new ManualClock()
      val txn = new OptimisticTransaction(log)(clock)
      txn.updateSetTransaction("TestAppId", 1L, None)
      val e = intercept[IllegalArgumentException] {
        txn.commit(Seq(SetTransaction("TestAppId", 2L, None)), ManualUpdate)
      }
      assert(e.getMessage == DeltaErrors.setTransactionVersionConflict("TestAppId", 2L, 1L)
        .getMessage)
    }
  }

  test("removes duplicate SetTransactions") {
    withTempDir { tempDir =>
      // Initialize delta table.
      val log = DeltaLog.forTable(spark, new Path(tempDir.getCanonicalPath))
      log.startTransaction().commit(Seq(Metadata()), ManualUpdate)

      val clock = new ManualClock()
      val txn = new OptimisticTransaction(log)(clock)
      txn.updateSetTransaction("TestAppId", 1L, None)
      val version = txn.commit(Seq(SetTransaction("TestAppId", 1L, None)), ManualUpdate)
      def readActions(version: Long): Seq[Action] = {
        log.store.read(FileNames.deltaFile(log.logPath, version), log.newDeltaHadoopConf())
          .map(Action.fromJson)
      }
      assert(readActions(version).collectFirst {
        case SetTransaction("TestAppId", 1L, _) =>
      }.isDefined)
    }
  }

  test("preCommitLogSegment is updated during conflict checking") {
    withTempDir { tempDir =>
      val log = DeltaLog.forTable(spark, new Path(tempDir.getCanonicalPath))
      log.startTransaction().commit(Seq(Metadata()), ManualUpdate)
      val testTxn = log.startTransaction()
      val testTxnStartTs = System.currentTimeMillis()
      for (_ <- 1 to 11) {
        log.startTransaction().commit(Seq.empty, ManualUpdate)
      }
      val testTxnEndTs = System.currentTimeMillis()

      // preCommitLogSegment should not get updated until a commit is triggered
      assert(testTxn.preCommitLogSegment.version == 0)
      assert(testTxn.preCommitLogSegment.lastCommitTimestamp < testTxnStartTs)
      assert(testTxn.preCommitLogSegment.deltas.size == 1)
      assert(testTxn.preCommitLogSegment.checkpointVersionOpt == None)

      testTxn.commit(Seq.empty, ManualUpdate)

      // preCommitLogSegment should get updated to the version right before the txn commits
      assert(testTxn.preCommitLogSegment.version == 11)
      assert(testTxn.preCommitLogSegment.lastCommitTimestamp < testTxnEndTs)
      assert(testTxn.preCommitLogSegment.deltas.size == 1)
      assert(testTxn.preCommitLogSegment.checkpointVersionOpt == Some(10))
    }
  }
}
