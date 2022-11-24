// Generated from /Users/sharadsingh/Dev/spark-lab/delta/core/src/main/antlr4/io/delta/sql/parser/DeltaSqlBase.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DeltaSqlBaseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, ADD=5, ALTER=6, BY=7, CHECK=8, COMMENT=9, 
		CONSTRAINT=10, CONVERT=11, DELTA=12, DESC=13, DESCRIBE=14, DETAIL=15, 
		DROP=16, EXISTS=17, GENERATE=18, DRY=19, HISTORY=20, HOURS=21, IF=22, 
		LIMIT=23, MINUS=24, NOT=25, NULL=26, FOR=27, TABLE=28, PARTITIONED=29, 
		RETAIN=30, RUN=31, TO=32, VACUUM=33, EQ=34, NSEQ=35, NEQ=36, NEQJ=37, 
		LTE=38, GTE=39, CONCAT_PIPE=40, STRING=41, BIGINT_LITERAL=42, SMALLINT_LITERAL=43, 
		TINYINT_LITERAL=44, INTEGER_VALUE=45, DECIMAL_VALUE=46, DOUBLE_LITERAL=47, 
		BIGDECIMAL_LITERAL=48, IDENTIFIER=49, BACKQUOTED_IDENTIFIER=50, SIMPLE_COMMENT=51, 
		BRACKETED_COMMENT=52, WS=53, UNRECOGNIZED=54, DELIMITER=55;
	public static final int
		RULE_singleStatement = 0, RULE_statement = 1, RULE_qualifiedName = 2, 
		RULE_identifier = 3, RULE_quotedIdentifier = 4, RULE_colTypeList = 5, 
		RULE_colType = 6, RULE_dataType = 7, RULE_number = 8, RULE_constraint = 9, 
		RULE_checkExprToken = 10, RULE_nonReserved = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"singleStatement", "statement", "qualifiedName", "identifier", "quotedIdentifier", 
			"colTypeList", "colType", "dataType", "number", "constraint", "checkExprToken", 
			"nonReserved"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'.'", "','", "'ADD'", "'ALTER'", "'BY'", "'CHECK'", 
			"'COMMENT'", "'CONSTRAINT'", "'CONVERT'", "'DELTA'", "'DESC'", "'DESCRIBE'", 
			"'DETAIL'", "'DROP'", "'EXISTS'", "'GENERATE'", "'DRY'", "'HISTORY'", 
			"'HOURS'", "'IF'", "'LIMIT'", "'-'", null, "'NULL'", "'FOR'", "'TABLE'", 
			"'PARTITIONED'", "'RETAIN'", "'RUN'", "'TO'", "'VACUUM'", null, "'<=>'", 
			"'<>'", "'!='", null, null, "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "ADD", "ALTER", "BY", "CHECK", "COMMENT", 
			"CONSTRAINT", "CONVERT", "DELTA", "DESC", "DESCRIBE", "DETAIL", "DROP", 
			"EXISTS", "GENERATE", "DRY", "HISTORY", "HOURS", "IF", "LIMIT", "MINUS", 
			"NOT", "NULL", "FOR", "TABLE", "PARTITIONED", "RETAIN", "RUN", "TO", 
			"VACUUM", "EQ", "NSEQ", "NEQ", "NEQJ", "LTE", "GTE", "CONCAT_PIPE", "STRING", 
			"BIGINT_LITERAL", "SMALLINT_LITERAL", "TINYINT_LITERAL", "INTEGER_VALUE", 
			"DECIMAL_VALUE", "DOUBLE_LITERAL", "BIGDECIMAL_LITERAL", "IDENTIFIER", 
			"BACKQUOTED_IDENTIFIER", "SIMPLE_COMMENT", "BRACKETED_COMMENT", "WS", 
			"UNRECOGNIZED", "DELIMITER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "DeltaSqlBase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	  /**
	   * Verify whether current token is a valid decimal token (which contains dot).
	   * Returns true if the character that follows the token is not a digit or letter or underscore.
	   *
	   * For example:
	   * For char stream "2.3", "2." is not a valid decimal token, because it is followed by digit '3'.
	   * For char stream "2.3_", "2.3" is not a valid decimal token, because it is followed by '_'.
	   * For char stream "2.3W", "2.3" is not a valid decimal token, because it is followed by 'W'.
	   * For char stream "12.0D 34.E2+0.12 "  12.0D is a valid decimal token because it is folllowed
	   * by a space. 34.E2 is a valid decimal token because it is followed by symbol '+'
	   * which is not a digit or letter or underscore.
	   */
	  public boolean isValidDecimal() {
	    int nextChar = _input.LA(1);
	    if (nextChar >= 'A' && nextChar <= 'Z' || nextChar >= '0' && nextChar <= '9' ||
	      nextChar == '_') {
	      return false;
	    } else {
	      return true;
	    }
	  }

	public DeltaSqlBaseParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SingleStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(DeltaSqlBaseParser.EOF, 0); }
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_singleStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			statement();
			setState(25);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PassThroughContext extends StatementContext {
		public PassThroughContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterPassThrough(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitPassThrough(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitPassThrough(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DescribeDeltaDetailContext extends StatementContext {
		public Token path;
		public QualifiedNameContext table;
		public TerminalNode DETAIL() { return getToken(DeltaSqlBaseParser.DETAIL, 0); }
		public TerminalNode DESC() { return getToken(DeltaSqlBaseParser.DESC, 0); }
		public TerminalNode DESCRIBE() { return getToken(DeltaSqlBaseParser.DESCRIBE, 0); }
		public TerminalNode STRING() { return getToken(DeltaSqlBaseParser.STRING, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public DescribeDeltaDetailContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterDescribeDeltaDetail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitDescribeDeltaDetail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitDescribeDeltaDetail(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddTableConstraintContext extends StatementContext {
		public QualifiedNameContext table;
		public IdentifierContext name;
		public TerminalNode ALTER() { return getToken(DeltaSqlBaseParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(DeltaSqlBaseParser.TABLE, 0); }
		public TerminalNode ADD() { return getToken(DeltaSqlBaseParser.ADD, 0); }
		public TerminalNode CONSTRAINT() { return getToken(DeltaSqlBaseParser.CONSTRAINT, 0); }
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AddTableConstraintContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterAddTableConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitAddTableConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitAddTableConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConvertContext extends StatementContext {
		public QualifiedNameContext table;
		public TerminalNode CONVERT() { return getToken(DeltaSqlBaseParser.CONVERT, 0); }
		public TerminalNode TO() { return getToken(DeltaSqlBaseParser.TO, 0); }
		public TerminalNode DELTA() { return getToken(DeltaSqlBaseParser.DELTA, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode PARTITIONED() { return getToken(DeltaSqlBaseParser.PARTITIONED, 0); }
		public TerminalNode BY() { return getToken(DeltaSqlBaseParser.BY, 0); }
		public ColTypeListContext colTypeList() {
			return getRuleContext(ColTypeListContext.class,0);
		}
		public ConvertContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterConvert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitConvert(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitConvert(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VacuumTableContext extends StatementContext {
		public Token path;
		public QualifiedNameContext table;
		public TerminalNode VACUUM() { return getToken(DeltaSqlBaseParser.VACUUM, 0); }
		public TerminalNode STRING() { return getToken(DeltaSqlBaseParser.STRING, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode RETAIN() { return getToken(DeltaSqlBaseParser.RETAIN, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode HOURS() { return getToken(DeltaSqlBaseParser.HOURS, 0); }
		public TerminalNode DRY() { return getToken(DeltaSqlBaseParser.DRY, 0); }
		public TerminalNode RUN() { return getToken(DeltaSqlBaseParser.RUN, 0); }
		public VacuumTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterVacuumTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitVacuumTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitVacuumTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GenerateContext extends StatementContext {
		public IdentifierContext modeName;
		public QualifiedNameContext table;
		public TerminalNode GENERATE() { return getToken(DeltaSqlBaseParser.GENERATE, 0); }
		public TerminalNode FOR() { return getToken(DeltaSqlBaseParser.FOR, 0); }
		public TerminalNode TABLE() { return getToken(DeltaSqlBaseParser.TABLE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public GenerateContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterGenerate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitGenerate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitGenerate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DescribeDeltaHistoryContext extends StatementContext {
		public Token path;
		public QualifiedNameContext table;
		public Token limit;
		public TerminalNode HISTORY() { return getToken(DeltaSqlBaseParser.HISTORY, 0); }
		public TerminalNode DESC() { return getToken(DeltaSqlBaseParser.DESC, 0); }
		public TerminalNode DESCRIBE() { return getToken(DeltaSqlBaseParser.DESCRIBE, 0); }
		public TerminalNode STRING() { return getToken(DeltaSqlBaseParser.STRING, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode LIMIT() { return getToken(DeltaSqlBaseParser.LIMIT, 0); }
		public TerminalNode INTEGER_VALUE() { return getToken(DeltaSqlBaseParser.INTEGER_VALUE, 0); }
		public DescribeDeltaHistoryContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterDescribeDeltaHistory(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitDescribeDeltaHistory(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitDescribeDeltaHistory(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropTableConstraintContext extends StatementContext {
		public QualifiedNameContext table;
		public IdentifierContext name;
		public TerminalNode ALTER() { return getToken(DeltaSqlBaseParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(DeltaSqlBaseParser.TABLE, 0); }
		public TerminalNode DROP() { return getToken(DeltaSqlBaseParser.DROP, 0); }
		public TerminalNode CONSTRAINT() { return getToken(DeltaSqlBaseParser.CONSTRAINT, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode IF() { return getToken(DeltaSqlBaseParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(DeltaSqlBaseParser.EXISTS, 0); }
		public DropTableConstraintContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterDropTableConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitDropTableConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitDropTableConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new VacuumTableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				match(VACUUM);
				setState(30);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
					{
					setState(28);
					((VacuumTableContext)_localctx).path = match(STRING);
					}
					break;
				case BY:
				case CHECK:
				case CONVERT:
				case DELTA:
				case DESC:
				case DESCRIBE:
				case DETAIL:
				case EXISTS:
				case GENERATE:
				case DRY:
				case HOURS:
				case LIMIT:
				case FOR:
				case TABLE:
				case PARTITIONED:
				case RETAIN:
				case RUN:
				case TO:
				case VACUUM:
				case IDENTIFIER:
				case BACKQUOTED_IDENTIFIER:
					{
					setState(29);
					((VacuumTableContext)_localctx).table = qualifiedName();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RETAIN) {
					{
					setState(32);
					match(RETAIN);
					setState(33);
					number();
					setState(34);
					match(HOURS);
					}
				}

				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DRY) {
					{
					setState(38);
					match(DRY);
					setState(39);
					match(RUN);
					}
				}

				}
				break;
			case 2:
				_localctx = new DescribeDeltaDetailContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				_la = _input.LA(1);
				if ( !(_la==DESC || _la==DESCRIBE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(43);
				match(DETAIL);
				setState(46);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
					{
					setState(44);
					((DescribeDeltaDetailContext)_localctx).path = match(STRING);
					}
					break;
				case BY:
				case CHECK:
				case CONVERT:
				case DELTA:
				case DESC:
				case DESCRIBE:
				case DETAIL:
				case EXISTS:
				case GENERATE:
				case DRY:
				case HOURS:
				case LIMIT:
				case FOR:
				case TABLE:
				case PARTITIONED:
				case RETAIN:
				case RUN:
				case TO:
				case VACUUM:
				case IDENTIFIER:
				case BACKQUOTED_IDENTIFIER:
					{
					setState(45);
					((DescribeDeltaDetailContext)_localctx).table = qualifiedName();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				_localctx = new GenerateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				match(GENERATE);
				setState(49);
				((GenerateContext)_localctx).modeName = identifier();
				setState(50);
				match(FOR);
				setState(51);
				match(TABLE);
				setState(52);
				((GenerateContext)_localctx).table = qualifiedName();
				}
				break;
			case 4:
				_localctx = new DescribeDeltaHistoryContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(54);
				_la = _input.LA(1);
				if ( !(_la==DESC || _la==DESCRIBE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(55);
				match(HISTORY);
				setState(58);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
					{
					setState(56);
					((DescribeDeltaHistoryContext)_localctx).path = match(STRING);
					}
					break;
				case BY:
				case CHECK:
				case CONVERT:
				case DELTA:
				case DESC:
				case DESCRIBE:
				case DETAIL:
				case EXISTS:
				case GENERATE:
				case DRY:
				case HOURS:
				case LIMIT:
				case FOR:
				case TABLE:
				case PARTITIONED:
				case RETAIN:
				case RUN:
				case TO:
				case VACUUM:
				case IDENTIFIER:
				case BACKQUOTED_IDENTIFIER:
					{
					setState(57);
					((DescribeDeltaHistoryContext)_localctx).table = qualifiedName();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LIMIT) {
					{
					setState(60);
					match(LIMIT);
					setState(61);
					((DescribeDeltaHistoryContext)_localctx).limit = match(INTEGER_VALUE);
					}
				}

				}
				break;
			case 5:
				_localctx = new ConvertContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(64);
				match(CONVERT);
				setState(65);
				match(TO);
				setState(66);
				match(DELTA);
				setState(67);
				((ConvertContext)_localctx).table = qualifiedName();
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITIONED) {
					{
					setState(68);
					match(PARTITIONED);
					setState(69);
					match(BY);
					setState(70);
					match(T__0);
					setState(71);
					colTypeList();
					setState(72);
					match(T__1);
					}
				}

				}
				break;
			case 6:
				_localctx = new AddTableConstraintContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				match(ALTER);
				setState(77);
				match(TABLE);
				setState(78);
				((AddTableConstraintContext)_localctx).table = qualifiedName();
				setState(79);
				match(ADD);
				setState(80);
				match(CONSTRAINT);
				setState(81);
				((AddTableConstraintContext)_localctx).name = identifier();
				setState(82);
				constraint();
				}
				break;
			case 7:
				_localctx = new DropTableConstraintContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(84);
				match(ALTER);
				setState(85);
				match(TABLE);
				setState(86);
				((DropTableConstraintContext)_localctx).table = qualifiedName();
				setState(87);
				match(DROP);
				setState(88);
				match(CONSTRAINT);
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(89);
					match(IF);
					setState(90);
					match(EXISTS);
					}
				}

				setState(93);
				((DropTableConstraintContext)_localctx).name = identifier();
				}
				break;
			case 8:
				_localctx = new PassThroughContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(95);
						matchWildcard();
						}
						} 
					}
					setState(100);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			identifier();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(104);
				match(T__2);
				setState(105);
				identifier();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	 
		public IdentifierContext() { }
		public void copyFrom(IdentifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QuotedIdentifierAlternativeContext extends IdentifierContext {
		public QuotedIdentifierContext quotedIdentifier() {
			return getRuleContext(QuotedIdentifierContext.class,0);
		}
		public QuotedIdentifierAlternativeContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterQuotedIdentifierAlternative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitQuotedIdentifierAlternative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitQuotedIdentifierAlternative(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnquotedIdentifierContext extends IdentifierContext {
		public TerminalNode IDENTIFIER() { return getToken(DeltaSqlBaseParser.IDENTIFIER, 0); }
		public NonReservedContext nonReserved() {
			return getRuleContext(NonReservedContext.class,0);
		}
		public UnquotedIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterUnquotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitUnquotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitUnquotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_identifier);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new UnquotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				match(IDENTIFIER);
				}
				break;
			case BACKQUOTED_IDENTIFIER:
				_localctx = new QuotedIdentifierAlternativeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				quotedIdentifier();
				}
				break;
			case BY:
			case CHECK:
			case CONVERT:
			case DELTA:
			case DESC:
			case DESCRIBE:
			case DETAIL:
			case EXISTS:
			case GENERATE:
			case DRY:
			case HOURS:
			case LIMIT:
			case FOR:
			case TABLE:
			case PARTITIONED:
			case RETAIN:
			case RUN:
			case TO:
			case VACUUM:
				_localctx = new UnquotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				nonReserved();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuotedIdentifierContext extends ParserRuleContext {
		public TerminalNode BACKQUOTED_IDENTIFIER() { return getToken(DeltaSqlBaseParser.BACKQUOTED_IDENTIFIER, 0); }
		public QuotedIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quotedIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterQuotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitQuotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitQuotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuotedIdentifierContext quotedIdentifier() throws RecognitionException {
		QuotedIdentifierContext _localctx = new QuotedIdentifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_quotedIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(BACKQUOTED_IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColTypeListContext extends ParserRuleContext {
		public List<ColTypeContext> colType() {
			return getRuleContexts(ColTypeContext.class);
		}
		public ColTypeContext colType(int i) {
			return getRuleContext(ColTypeContext.class,i);
		}
		public ColTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterColTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitColTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitColTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColTypeListContext colTypeList() throws RecognitionException {
		ColTypeListContext _localctx = new ColTypeListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_colTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			colType();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(119);
				match(T__3);
				setState(120);
				colType();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColTypeContext extends ParserRuleContext {
		public IdentifierContext colName;
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode NOT() { return getToken(DeltaSqlBaseParser.NOT, 0); }
		public TerminalNode NULL() { return getToken(DeltaSqlBaseParser.NULL, 0); }
		public TerminalNode COMMENT() { return getToken(DeltaSqlBaseParser.COMMENT, 0); }
		public TerminalNode STRING() { return getToken(DeltaSqlBaseParser.STRING, 0); }
		public ColTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterColType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitColType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitColType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColTypeContext colType() throws RecognitionException {
		ColTypeContext _localctx = new ColTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_colType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			((ColTypeContext)_localctx).colName = identifier();
			setState(127);
			dataType();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(128);
				match(NOT);
				setState(129);
				match(NULL);
				}
			}

			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(132);
				match(COMMENT);
				setState(133);
				match(STRING);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataTypeContext extends ParserRuleContext {
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
	 
		public DataTypeContext() { }
		public void copyFrom(DataTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrimitiveDataTypeContext extends DataTypeContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> INTEGER_VALUE() { return getTokens(DeltaSqlBaseParser.INTEGER_VALUE); }
		public TerminalNode INTEGER_VALUE(int i) {
			return getToken(DeltaSqlBaseParser.INTEGER_VALUE, i);
		}
		public PrimitiveDataTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterPrimitiveDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitPrimitiveDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitPrimitiveDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dataType);
		int _la;
		try {
			_localctx = new PrimitiveDataTypeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			identifier();
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(137);
				match(T__0);
				setState(138);
				match(INTEGER_VALUE);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(139);
					match(T__3);
					setState(140);
					match(INTEGER_VALUE);
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(146);
				match(T__1);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	 
		public NumberContext() { }
		public void copyFrom(NumberContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DecimalLiteralContext extends NumberContext {
		public TerminalNode DECIMAL_VALUE() { return getToken(DeltaSqlBaseParser.DECIMAL_VALUE, 0); }
		public TerminalNode MINUS() { return getToken(DeltaSqlBaseParser.MINUS, 0); }
		public DecimalLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterDecimalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitDecimalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitDecimalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BigIntLiteralContext extends NumberContext {
		public TerminalNode BIGINT_LITERAL() { return getToken(DeltaSqlBaseParser.BIGINT_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(DeltaSqlBaseParser.MINUS, 0); }
		public BigIntLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterBigIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitBigIntLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitBigIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TinyIntLiteralContext extends NumberContext {
		public TerminalNode TINYINT_LITERAL() { return getToken(DeltaSqlBaseParser.TINYINT_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(DeltaSqlBaseParser.MINUS, 0); }
		public TinyIntLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterTinyIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitTinyIntLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitTinyIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BigDecimalLiteralContext extends NumberContext {
		public TerminalNode BIGDECIMAL_LITERAL() { return getToken(DeltaSqlBaseParser.BIGDECIMAL_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(DeltaSqlBaseParser.MINUS, 0); }
		public BigDecimalLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterBigDecimalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitBigDecimalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitBigDecimalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleLiteralContext extends NumberContext {
		public TerminalNode DOUBLE_LITERAL() { return getToken(DeltaSqlBaseParser.DOUBLE_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(DeltaSqlBaseParser.MINUS, 0); }
		public DoubleLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterDoubleLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitDoubleLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitDoubleLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerLiteralContext extends NumberContext {
		public TerminalNode INTEGER_VALUE() { return getToken(DeltaSqlBaseParser.INTEGER_VALUE, 0); }
		public TerminalNode MINUS() { return getToken(DeltaSqlBaseParser.MINUS, 0); }
		public IntegerLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitIntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SmallIntLiteralContext extends NumberContext {
		public TerminalNode SMALLINT_LITERAL() { return getToken(DeltaSqlBaseParser.SMALLINT_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(DeltaSqlBaseParser.MINUS, 0); }
		public SmallIntLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterSmallIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitSmallIntLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitSmallIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_number);
		int _la;
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new DecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(149);
					match(MINUS);
					}
				}

				setState(152);
				match(DECIMAL_VALUE);
				}
				break;
			case 2:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(153);
					match(MINUS);
					}
				}

				setState(156);
				match(INTEGER_VALUE);
				}
				break;
			case 3:
				_localctx = new BigIntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(157);
					match(MINUS);
					}
				}

				setState(160);
				match(BIGINT_LITERAL);
				}
				break;
			case 4:
				_localctx = new SmallIntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(161);
					match(MINUS);
					}
				}

				setState(164);
				match(SMALLINT_LITERAL);
				}
				break;
			case 5:
				_localctx = new TinyIntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(165);
					match(MINUS);
					}
				}

				setState(168);
				match(TINYINT_LITERAL);
				}
				break;
			case 6:
				_localctx = new DoubleLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(169);
					match(MINUS);
					}
				}

				setState(172);
				match(DOUBLE_LITERAL);
				}
				break;
			case 7:
				_localctx = new BigDecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(173);
					match(MINUS);
					}
				}

				setState(176);
				match(BIGDECIMAL_LITERAL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintContext extends ParserRuleContext {
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
	 
		public ConstraintContext() { }
		public void copyFrom(ConstraintContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CheckConstraintContext extends ConstraintContext {
		public TerminalNode CHECK() { return getToken(DeltaSqlBaseParser.CHECK, 0); }
		public List<CheckExprTokenContext> checkExprToken() {
			return getRuleContexts(CheckExprTokenContext.class);
		}
		public CheckExprTokenContext checkExprToken(int i) {
			return getRuleContext(CheckExprTokenContext.class,i);
		}
		public CheckConstraintContext(ConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterCheckConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitCheckConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitCheckConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_constraint);
		try {
			int _alt;
			_localctx = new CheckConstraintContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(CHECK);
			setState(180);
			match(T__0);
			setState(182); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(181);
					checkExprToken();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(184); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(186);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckExprTokenContext extends ParserRuleContext {
		public CheckExprTokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkExprToken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterCheckExprToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitCheckExprToken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitCheckExprToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckExprTokenContext checkExprToken() throws RecognitionException {
		CheckExprTokenContext _localctx = new CheckExprTokenContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_checkExprToken);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(189); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(188);
					matchWildcard();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(191); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonReservedContext extends ParserRuleContext {
		public TerminalNode VACUUM() { return getToken(DeltaSqlBaseParser.VACUUM, 0); }
		public TerminalNode RETAIN() { return getToken(DeltaSqlBaseParser.RETAIN, 0); }
		public TerminalNode HOURS() { return getToken(DeltaSqlBaseParser.HOURS, 0); }
		public TerminalNode DRY() { return getToken(DeltaSqlBaseParser.DRY, 0); }
		public TerminalNode RUN() { return getToken(DeltaSqlBaseParser.RUN, 0); }
		public TerminalNode CONVERT() { return getToken(DeltaSqlBaseParser.CONVERT, 0); }
		public TerminalNode TO() { return getToken(DeltaSqlBaseParser.TO, 0); }
		public TerminalNode DELTA() { return getToken(DeltaSqlBaseParser.DELTA, 0); }
		public TerminalNode PARTITIONED() { return getToken(DeltaSqlBaseParser.PARTITIONED, 0); }
		public TerminalNode BY() { return getToken(DeltaSqlBaseParser.BY, 0); }
		public TerminalNode DESC() { return getToken(DeltaSqlBaseParser.DESC, 0); }
		public TerminalNode DESCRIBE() { return getToken(DeltaSqlBaseParser.DESCRIBE, 0); }
		public TerminalNode LIMIT() { return getToken(DeltaSqlBaseParser.LIMIT, 0); }
		public TerminalNode DETAIL() { return getToken(DeltaSqlBaseParser.DETAIL, 0); }
		public TerminalNode GENERATE() { return getToken(DeltaSqlBaseParser.GENERATE, 0); }
		public TerminalNode FOR() { return getToken(DeltaSqlBaseParser.FOR, 0); }
		public TerminalNode TABLE() { return getToken(DeltaSqlBaseParser.TABLE, 0); }
		public TerminalNode CHECK() { return getToken(DeltaSqlBaseParser.CHECK, 0); }
		public TerminalNode EXISTS() { return getToken(DeltaSqlBaseParser.EXISTS, 0); }
		public NonReservedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonReserved; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).enterNonReserved(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeltaSqlBaseListener ) ((DeltaSqlBaseListener)listener).exitNonReserved(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeltaSqlBaseVisitor ) return ((DeltaSqlBaseVisitor<? extends T>)visitor).visitNonReserved(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonReservedContext nonReserved() throws RecognitionException {
		NonReservedContext _localctx = new NonReservedContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_nonReserved);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BY) | (1L << CHECK) | (1L << CONVERT) | (1L << DELTA) | (1L << DESC) | (1L << DESCRIBE) | (1L << DETAIL) | (1L << EXISTS) | (1L << GENERATE) | (1L << DRY) | (1L << HOURS) | (1L << LIMIT) | (1L << FOR) | (1L << TABLE) | (1L << PARTITIONED) | (1L << RETAIN) | (1L << RUN) | (1L << TO) | (1L << VACUUM))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\39\u00c6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\5\3!\n\3\3\3\3\3\3\3\3\3\5"+
		"\3\'\n\3\3\3\3\3\5\3+\n\3\3\3\3\3\3\3\3\3\5\3\61\n\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3=\n\3\3\3\3\3\5\3A\n\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3M\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3^\n\3\3\3\3\3\3\3\7\3c\n\3\f\3\16\3f\13\3\5\3h\n"+
		"\3\3\4\3\4\3\4\7\4m\n\4\f\4\16\4p\13\4\3\5\3\5\3\5\5\5u\n\5\3\6\3\6\3"+
		"\7\3\7\3\7\7\7|\n\7\f\7\16\7\177\13\7\3\b\3\b\3\b\3\b\5\b\u0085\n\b\3"+
		"\b\3\b\5\b\u0089\n\b\3\t\3\t\3\t\3\t\3\t\7\t\u0090\n\t\f\t\16\t\u0093"+
		"\13\t\3\t\5\t\u0096\n\t\3\n\5\n\u0099\n\n\3\n\3\n\5\n\u009d\n\n\3\n\3"+
		"\n\5\n\u00a1\n\n\3\n\3\n\5\n\u00a5\n\n\3\n\3\n\5\n\u00a9\n\n\3\n\3\n\5"+
		"\n\u00ad\n\n\3\n\3\n\5\n\u00b1\n\n\3\n\5\n\u00b4\n\n\3\13\3\13\3\13\6"+
		"\13\u00b9\n\13\r\13\16\13\u00ba\3\13\3\13\3\f\6\f\u00c0\n\f\r\f\16\f\u00c1"+
		"\3\r\3\r\3\r\4d\u00c1\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\4\3\2\17\20"+
		"\b\2\t\n\r\21\23\25\27\27\31\31\35#\2\u00e0\2\32\3\2\2\2\4g\3\2\2\2\6"+
		"i\3\2\2\2\bt\3\2\2\2\nv\3\2\2\2\fx\3\2\2\2\16\u0080\3\2\2\2\20\u008a\3"+
		"\2\2\2\22\u00b3\3\2\2\2\24\u00b5\3\2\2\2\26\u00bf\3\2\2\2\30\u00c3\3\2"+
		"\2\2\32\33\5\4\3\2\33\34\7\2\2\3\34\3\3\2\2\2\35 \7#\2\2\36!\7+\2\2\37"+
		"!\5\6\4\2 \36\3\2\2\2 \37\3\2\2\2!&\3\2\2\2\"#\7 \2\2#$\5\22\n\2$%\7\27"+
		"\2\2%\'\3\2\2\2&\"\3\2\2\2&\'\3\2\2\2\'*\3\2\2\2()\7\25\2\2)+\7!\2\2*"+
		"(\3\2\2\2*+\3\2\2\2+h\3\2\2\2,-\t\2\2\2-\60\7\21\2\2.\61\7+\2\2/\61\5"+
		"\6\4\2\60.\3\2\2\2\60/\3\2\2\2\61h\3\2\2\2\62\63\7\24\2\2\63\64\5\b\5"+
		"\2\64\65\7\35\2\2\65\66\7\36\2\2\66\67\5\6\4\2\67h\3\2\2\289\t\2\2\29"+
		"<\7\26\2\2:=\7+\2\2;=\5\6\4\2<:\3\2\2\2<;\3\2\2\2=@\3\2\2\2>?\7\31\2\2"+
		"?A\7/\2\2@>\3\2\2\2@A\3\2\2\2Ah\3\2\2\2BC\7\r\2\2CD\7\"\2\2DE\7\16\2\2"+
		"EL\5\6\4\2FG\7\37\2\2GH\7\t\2\2HI\7\3\2\2IJ\5\f\7\2JK\7\4\2\2KM\3\2\2"+
		"\2LF\3\2\2\2LM\3\2\2\2Mh\3\2\2\2NO\7\b\2\2OP\7\36\2\2PQ\5\6\4\2QR\7\7"+
		"\2\2RS\7\f\2\2ST\5\b\5\2TU\5\24\13\2Uh\3\2\2\2VW\7\b\2\2WX\7\36\2\2XY"+
		"\5\6\4\2YZ\7\22\2\2Z]\7\f\2\2[\\\7\30\2\2\\^\7\23\2\2][\3\2\2\2]^\3\2"+
		"\2\2^_\3\2\2\2_`\5\b\5\2`h\3\2\2\2ac\13\2\2\2ba\3\2\2\2cf\3\2\2\2de\3"+
		"\2\2\2db\3\2\2\2eh\3\2\2\2fd\3\2\2\2g\35\3\2\2\2g,\3\2\2\2g\62\3\2\2\2"+
		"g8\3\2\2\2gB\3\2\2\2gN\3\2\2\2gV\3\2\2\2gd\3\2\2\2h\5\3\2\2\2in\5\b\5"+
		"\2jk\7\5\2\2km\5\b\5\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\7\3\2"+
		"\2\2pn\3\2\2\2qu\7\63\2\2ru\5\n\6\2su\5\30\r\2tq\3\2\2\2tr\3\2\2\2ts\3"+
		"\2\2\2u\t\3\2\2\2vw\7\64\2\2w\13\3\2\2\2x}\5\16\b\2yz\7\6\2\2z|\5\16\b"+
		"\2{y\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\r\3\2\2\2\177}\3\2\2\2"+
		"\u0080\u0081\5\b\5\2\u0081\u0084\5\20\t\2\u0082\u0083\7\33\2\2\u0083\u0085"+
		"\7\34\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0088\3\2\2\2"+
		"\u0086\u0087\7\13\2\2\u0087\u0089\7+\2\2\u0088\u0086\3\2\2\2\u0088\u0089"+
		"\3\2\2\2\u0089\17\3\2\2\2\u008a\u0095\5\b\5\2\u008b\u008c\7\3\2\2\u008c"+
		"\u0091\7/\2\2\u008d\u008e\7\6\2\2\u008e\u0090\7/\2\2\u008f\u008d\3\2\2"+
		"\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094"+
		"\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0096\7\4\2\2\u0095\u008b\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\21\3\2\2\2\u0097\u0099\7\32\2\2\u0098\u0097\3\2\2"+
		"\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u00b4\7\60\2\2\u009b"+
		"\u009d\7\32\2\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3"+
		"\2\2\2\u009e\u00b4\7/\2\2\u009f\u00a1\7\32\2\2\u00a0\u009f\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00b4\7,\2\2\u00a3\u00a5\7\32"+
		"\2\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00b4\7-\2\2\u00a7\u00a9\7\32\2\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2"+
		"\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00b4\7.\2\2\u00ab\u00ad\7\32\2\2\u00ac"+
		"\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b4\7\61"+
		"\2\2\u00af\u00b1\7\32\2\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b4\7\62\2\2\u00b3\u0098\3\2\2\2\u00b3\u009c\3"+
		"\2\2\2\u00b3\u00a0\3\2\2\2\u00b3\u00a4\3\2\2\2\u00b3\u00a8\3\2\2\2\u00b3"+
		"\u00ac\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b4\23\3\2\2\2\u00b5\u00b6\7\n\2"+
		"\2\u00b6\u00b8\7\3\2\2\u00b7\u00b9\5\26\f\2\u00b8\u00b7\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\3\2"+
		"\2\2\u00bc\u00bd\7\4\2\2\u00bd\25\3\2\2\2\u00be\u00c0\13\2\2\2\u00bf\u00be"+
		"\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2"+
		"\27\3\2\2\2\u00c3\u00c4\t\3\2\2\u00c4\31\3\2\2\2\35 &*\60<@L]dgnt}\u0084"+
		"\u0088\u0091\u0095\u0098\u009c\u00a0\u00a4\u00a8\u00ac\u00b0\u00b3\u00ba"+
		"\u00c1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}