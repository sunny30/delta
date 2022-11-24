// Generated from /Users/sharadsingh/Dev/spark-lab/delta/core/src/main/antlr4/io/delta/sql/parser/DeltaSqlBase.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DeltaSqlBaseLexer extends Lexer {
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
		BRACKETED_COMMENT=52, WS=53, UNRECOGNIZED=54;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "ADD", "ALTER", "BY", "CHECK", "COMMENT", 
			"CONSTRAINT", "CONVERT", "DELTA", "DESC", "DESCRIBE", "DETAIL", "DROP", 
			"EXISTS", "GENERATE", "DRY", "HISTORY", "HOURS", "IF", "LIMIT", "MINUS", 
			"NOT", "NULL", "FOR", "TABLE", "PARTITIONED", "RETAIN", "RUN", "TO", 
			"VACUUM", "EQ", "NSEQ", "NEQ", "NEQJ", "LTE", "GTE", "CONCAT_PIPE", "STRING", 
			"BIGINT_LITERAL", "SMALLINT_LITERAL", "TINYINT_LITERAL", "INTEGER_VALUE", 
			"DECIMAL_VALUE", "DOUBLE_LITERAL", "BIGDECIMAL_LITERAL", "IDENTIFIER", 
			"BACKQUOTED_IDENTIFIER", "DECIMAL_DIGITS", "EXPONENT", "DIGIT", "LETTER", 
			"SIMPLE_COMMENT", "BRACKETED_COMMENT", "WS", "UNRECOGNIZED"
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
			"UNRECOGNIZED"
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


	public DeltaSqlBaseLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DeltaSqlBase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 45:
			return DECIMAL_VALUE_sempred((RuleContext)_localctx, predIndex);
		case 46:
			return DOUBLE_LITERAL_sempred((RuleContext)_localctx, predIndex);
		case 47:
			return BIGDECIMAL_LITERAL_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean DECIMAL_VALUE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return isValidDecimal();
		}
		return true;
	}
	private boolean DOUBLE_LITERAL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return isValidDecimal();
		}
		return true;
	}
	private boolean BIGDECIMAL_LITERAL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return isValidDecimal();
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\28\u0211\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\5\32\u00ff\n\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3#\3#\3#\5#\u0134\n#\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'"+
		"\3\'\3\'\5\'\u0144\n\'\3(\3(\3(\3(\5(\u014a\n(\3)\3)\3)\3*\3*\3*\3*\7"+
		"*\u0153\n*\f*\16*\u0156\13*\3*\3*\3*\3*\3*\7*\u015d\n*\f*\16*\u0160\13"+
		"*\3*\5*\u0163\n*\3+\6+\u0166\n+\r+\16+\u0167\3+\3+\3,\6,\u016d\n,\r,\16"+
		",\u016e\3,\3,\3-\6-\u0174\n-\r-\16-\u0175\3-\3-\3.\6.\u017b\n.\r.\16."+
		"\u017c\3/\6/\u0180\n/\r/\16/\u0181\3/\3/\3/\3/\5/\u0188\n/\3/\3/\5/\u018c"+
		"\n/\3\60\6\60\u018f\n\60\r\60\16\60\u0190\3\60\5\60\u0194\n\60\3\60\3"+
		"\60\3\60\3\60\5\60\u019a\n\60\3\60\3\60\3\60\5\60\u019f\n\60\3\61\6\61"+
		"\u01a2\n\61\r\61\16\61\u01a3\3\61\5\61\u01a7\n\61\3\61\3\61\3\61\3\61"+
		"\3\61\5\61\u01ae\n\61\3\61\3\61\3\61\3\61\3\61\5\61\u01b5\n\61\3\62\3"+
		"\62\3\62\6\62\u01ba\n\62\r\62\16\62\u01bb\3\63\3\63\3\63\3\63\7\63\u01c2"+
		"\n\63\f\63\16\63\u01c5\13\63\3\63\3\63\3\64\6\64\u01ca\n\64\r\64\16\64"+
		"\u01cb\3\64\3\64\7\64\u01d0\n\64\f\64\16\64\u01d3\13\64\3\64\3\64\6\64"+
		"\u01d7\n\64\r\64\16\64\u01d8\5\64\u01db\n\64\3\65\3\65\5\65\u01df\n\65"+
		"\3\65\6\65\u01e2\n\65\r\65\16\65\u01e3\3\66\3\66\3\67\3\67\38\38\38\3"+
		"8\78\u01ee\n8\f8\168\u01f1\138\38\58\u01f4\n8\38\58\u01f7\n8\38\38\39"+
		"\39\39\39\79\u01ff\n9\f9\169\u0202\139\39\39\39\39\39\3:\6:\u020a\n:\r"+
		":\16:\u020b\3:\3:\3;\3;\3\u0200\2<\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\2i\2k\2m\2o\65q\66s\67u8\3\2\n\4\2))^^\4\2$$^^"+
		"\3\2bb\4\2--//\3\2\62;\3\2C\\\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0234"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2"+
		"\2\3w\3\2\2\2\5y\3\2\2\2\7{\3\2\2\2\t}\3\2\2\2\13\177\3\2\2\2\r\u0083"+
		"\3\2\2\2\17\u0089\3\2\2\2\21\u008c\3\2\2\2\23\u0092\3\2\2\2\25\u009a\3"+
		"\2\2\2\27\u00a5\3\2\2\2\31\u00ad\3\2\2\2\33\u00b3\3\2\2\2\35\u00b8\3\2"+
		"\2\2\37\u00c1\3\2\2\2!\u00c8\3\2\2\2#\u00cd\3\2\2\2%\u00d4\3\2\2\2\'\u00dd"+
		"\3\2\2\2)\u00e1\3\2\2\2+\u00e9\3\2\2\2-\u00ef\3\2\2\2/\u00f2\3\2\2\2\61"+
		"\u00f8\3\2\2\2\63\u00fe\3\2\2\2\65\u0100\3\2\2\2\67\u0105\3\2\2\29\u0109"+
		"\3\2\2\2;\u010f\3\2\2\2=\u011b\3\2\2\2?\u0122\3\2\2\2A\u0126\3\2\2\2C"+
		"\u0129\3\2\2\2E\u0133\3\2\2\2G\u0135\3\2\2\2I\u0139\3\2\2\2K\u013c\3\2"+
		"\2\2M\u0143\3\2\2\2O\u0149\3\2\2\2Q\u014b\3\2\2\2S\u0162\3\2\2\2U\u0165"+
		"\3\2\2\2W\u016c\3\2\2\2Y\u0173\3\2\2\2[\u017a\3\2\2\2]\u018b\3\2\2\2_"+
		"\u019e\3\2\2\2a\u01b4\3\2\2\2c\u01b9\3\2\2\2e\u01bd\3\2\2\2g\u01da\3\2"+
		"\2\2i\u01dc\3\2\2\2k\u01e5\3\2\2\2m\u01e7\3\2\2\2o\u01e9\3\2\2\2q\u01fa"+
		"\3\2\2\2s\u0209\3\2\2\2u\u020f\3\2\2\2wx\7*\2\2x\4\3\2\2\2yz\7+\2\2z\6"+
		"\3\2\2\2{|\7\60\2\2|\b\3\2\2\2}~\7.\2\2~\n\3\2\2\2\177\u0080\7C\2\2\u0080"+
		"\u0081\7F\2\2\u0081\u0082\7F\2\2\u0082\f\3\2\2\2\u0083\u0084\7C\2\2\u0084"+
		"\u0085\7N\2\2\u0085\u0086\7V\2\2\u0086\u0087\7G\2\2\u0087\u0088\7T\2\2"+
		"\u0088\16\3\2\2\2\u0089\u008a\7D\2\2\u008a\u008b\7[\2\2\u008b\20\3\2\2"+
		"\2\u008c\u008d\7E\2\2\u008d\u008e\7J\2\2\u008e\u008f\7G\2\2\u008f\u0090"+
		"\7E\2\2\u0090\u0091\7M\2\2\u0091\22\3\2\2\2\u0092\u0093\7E\2\2\u0093\u0094"+
		"\7Q\2\2\u0094\u0095\7O\2\2\u0095\u0096\7O\2\2\u0096\u0097\7G\2\2\u0097"+
		"\u0098\7P\2\2\u0098\u0099\7V\2\2\u0099\24\3\2\2\2\u009a\u009b\7E\2\2\u009b"+
		"\u009c\7Q\2\2\u009c\u009d\7P\2\2\u009d\u009e\7U\2\2\u009e\u009f\7V\2\2"+
		"\u009f\u00a0\7T\2\2\u00a0\u00a1\7C\2\2\u00a1\u00a2\7K\2\2\u00a2\u00a3"+
		"\7P\2\2\u00a3\u00a4\7V\2\2\u00a4\26\3\2\2\2\u00a5\u00a6\7E\2\2\u00a6\u00a7"+
		"\7Q\2\2\u00a7\u00a8\7P\2\2\u00a8\u00a9\7X\2\2\u00a9\u00aa\7G\2\2\u00aa"+
		"\u00ab\7T\2\2\u00ab\u00ac\7V\2\2\u00ac\30\3\2\2\2\u00ad\u00ae\7F\2\2\u00ae"+
		"\u00af\7G\2\2\u00af\u00b0\7N\2\2\u00b0\u00b1\7V\2\2\u00b1\u00b2\7C\2\2"+
		"\u00b2\32\3\2\2\2\u00b3\u00b4\7F\2\2\u00b4\u00b5\7G\2\2\u00b5\u00b6\7"+
		"U\2\2\u00b6\u00b7\7E\2\2\u00b7\34\3\2\2\2\u00b8\u00b9\7F\2\2\u00b9\u00ba"+
		"\7G\2\2\u00ba\u00bb\7U\2\2\u00bb\u00bc\7E\2\2\u00bc\u00bd\7T\2\2\u00bd"+
		"\u00be\7K\2\2\u00be\u00bf\7D\2\2\u00bf\u00c0\7G\2\2\u00c0\36\3\2\2\2\u00c1"+
		"\u00c2\7F\2\2\u00c2\u00c3\7G\2\2\u00c3\u00c4\7V\2\2\u00c4\u00c5\7C\2\2"+
		"\u00c5\u00c6\7K\2\2\u00c6\u00c7\7N\2\2\u00c7 \3\2\2\2\u00c8\u00c9\7F\2"+
		"\2\u00c9\u00ca\7T\2\2\u00ca\u00cb\7Q\2\2\u00cb\u00cc\7R\2\2\u00cc\"\3"+
		"\2\2\2\u00cd\u00ce\7G\2\2\u00ce\u00cf\7Z\2\2\u00cf\u00d0\7K\2\2\u00d0"+
		"\u00d1\7U\2\2\u00d1\u00d2\7V\2\2\u00d2\u00d3\7U\2\2\u00d3$\3\2\2\2\u00d4"+
		"\u00d5\7I\2\2\u00d5\u00d6\7G\2\2\u00d6\u00d7\7P\2\2\u00d7\u00d8\7G\2\2"+
		"\u00d8\u00d9\7T\2\2\u00d9\u00da\7C\2\2\u00da\u00db\7V\2\2\u00db\u00dc"+
		"\7G\2\2\u00dc&\3\2\2\2\u00dd\u00de\7F\2\2\u00de\u00df\7T\2\2\u00df\u00e0"+
		"\7[\2\2\u00e0(\3\2\2\2\u00e1\u00e2\7J\2\2\u00e2\u00e3\7K\2\2\u00e3\u00e4"+
		"\7U\2\2\u00e4\u00e5\7V\2\2\u00e5\u00e6\7Q\2\2\u00e6\u00e7\7T\2\2\u00e7"+
		"\u00e8\7[\2\2\u00e8*\3\2\2\2\u00e9\u00ea\7J\2\2\u00ea\u00eb\7Q\2\2\u00eb"+
		"\u00ec\7W\2\2\u00ec\u00ed\7T\2\2\u00ed\u00ee\7U\2\2\u00ee,\3\2\2\2\u00ef"+
		"\u00f0\7K\2\2\u00f0\u00f1\7H\2\2\u00f1.\3\2\2\2\u00f2\u00f3\7N\2\2\u00f3"+
		"\u00f4\7K\2\2\u00f4\u00f5\7O\2\2\u00f5\u00f6\7K\2\2\u00f6\u00f7\7V\2\2"+
		"\u00f7\60\3\2\2\2\u00f8\u00f9\7/\2\2\u00f9\62\3\2\2\2\u00fa\u00fb\7P\2"+
		"\2\u00fb\u00fc\7Q\2\2\u00fc\u00ff\7V\2\2\u00fd\u00ff\7#\2\2\u00fe\u00fa"+
		"\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\64\3\2\2\2\u0100\u0101\7P\2\2\u0101"+
		"\u0102\7W\2\2\u0102\u0103\7N\2\2\u0103\u0104\7N\2\2\u0104\66\3\2\2\2\u0105"+
		"\u0106\7H\2\2\u0106\u0107\7Q\2\2\u0107\u0108\7T\2\2\u01088\3\2\2\2\u0109"+
		"\u010a\7V\2\2\u010a\u010b\7C\2\2\u010b\u010c\7D\2\2\u010c\u010d\7N\2\2"+
		"\u010d\u010e\7G\2\2\u010e:\3\2\2\2\u010f\u0110\7R\2\2\u0110\u0111\7C\2"+
		"\2\u0111\u0112\7T\2\2\u0112\u0113\7V\2\2\u0113\u0114\7K\2\2\u0114\u0115"+
		"\7V\2\2\u0115\u0116\7K\2\2\u0116\u0117\7Q\2\2\u0117\u0118\7P\2\2\u0118"+
		"\u0119\7G\2\2\u0119\u011a\7F\2\2\u011a<\3\2\2\2\u011b\u011c\7T\2\2\u011c"+
		"\u011d\7G\2\2\u011d\u011e\7V\2\2\u011e\u011f\7C\2\2\u011f\u0120\7K\2\2"+
		"\u0120\u0121\7P\2\2\u0121>\3\2\2\2\u0122\u0123\7T\2\2\u0123\u0124\7W\2"+
		"\2\u0124\u0125\7P\2\2\u0125@\3\2\2\2\u0126\u0127\7V\2\2\u0127\u0128\7"+
		"Q\2\2\u0128B\3\2\2\2\u0129\u012a\7X\2\2\u012a\u012b\7C\2\2\u012b\u012c"+
		"\7E\2\2\u012c\u012d\7W\2\2\u012d\u012e\7W\2\2\u012e\u012f\7O\2\2\u012f"+
		"D\3\2\2\2\u0130\u0134\7?\2\2\u0131\u0132\7?\2\2\u0132\u0134\7?\2\2\u0133"+
		"\u0130\3\2\2\2\u0133\u0131\3\2\2\2\u0134F\3\2\2\2\u0135\u0136\7>\2\2\u0136"+
		"\u0137\7?\2\2\u0137\u0138\7@\2\2\u0138H\3\2\2\2\u0139\u013a\7>\2\2\u013a"+
		"\u013b\7@\2\2\u013bJ\3\2\2\2\u013c\u013d\7#\2\2\u013d\u013e\7?\2\2\u013e"+
		"L\3\2\2\2\u013f\u0140\7>\2\2\u0140\u0144\7?\2\2\u0141\u0142\7#\2\2\u0142"+
		"\u0144\7@\2\2\u0143\u013f\3\2\2\2\u0143\u0141\3\2\2\2\u0144N\3\2\2\2\u0145"+
		"\u0146\7@\2\2\u0146\u014a\7?\2\2\u0147\u0148\7#\2\2\u0148\u014a\7>\2\2"+
		"\u0149\u0145\3\2\2\2\u0149\u0147\3\2\2\2\u014aP\3\2\2\2\u014b\u014c\7"+
		"~\2\2\u014c\u014d\7~\2\2\u014dR\3\2\2\2\u014e\u0154\7)\2\2\u014f\u0153"+
		"\n\2\2\2\u0150\u0151\7^\2\2\u0151\u0153\13\2\2\2\u0152\u014f\3\2\2\2\u0152"+
		"\u0150\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2"+
		"\2\2\u0155\u0157\3\2\2\2\u0156\u0154\3\2\2\2\u0157\u0163\7)\2\2\u0158"+
		"\u015e\7$\2\2\u0159\u015d\n\3\2\2\u015a\u015b\7^\2\2\u015b\u015d\13\2"+
		"\2\2\u015c\u0159\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u0160\3\2\2\2\u015e"+
		"\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0161\3\2\2\2\u0160\u015e\3\2"+
		"\2\2\u0161\u0163\7$\2\2\u0162\u014e\3\2\2\2\u0162\u0158\3\2\2\2\u0163"+
		"T\3\2\2\2\u0164\u0166\5k\66\2\u0165\u0164\3\2\2\2\u0166\u0167\3\2\2\2"+
		"\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a"+
		"\7N\2\2\u016aV\3\2\2\2\u016b\u016d\5k\66\2\u016c\u016b\3\2\2\2\u016d\u016e"+
		"\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0170\3\2\2\2\u0170"+
		"\u0171\7U\2\2\u0171X\3\2\2\2\u0172\u0174\5k\66\2\u0173\u0172\3\2\2\2\u0174"+
		"\u0175\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\3\2"+
		"\2\2\u0177\u0178\7[\2\2\u0178Z\3\2\2\2\u0179\u017b\5k\66\2\u017a\u0179"+
		"\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d"+
		"\\\3\2\2\2\u017e\u0180\5k\66\2\u017f\u017e\3\2\2\2\u0180\u0181\3\2\2\2"+
		"\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0184"+
		"\5i\65\2\u0184\u018c\3\2\2\2\u0185\u0187\5g\64\2\u0186\u0188\5i\65\2\u0187"+
		"\u0186\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a\6/"+
		"\2\2\u018a\u018c\3\2\2\2\u018b\u017f\3\2\2\2\u018b\u0185\3\2\2\2\u018c"+
		"^\3\2\2\2\u018d\u018f\5k\66\2\u018e\u018d\3\2\2\2\u018f\u0190\3\2\2\2"+
		"\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0193\3\2\2\2\u0192\u0194"+
		"\5i\65\2\u0193\u0192\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195\3\2\2\2\u0195"+
		"\u0196\7F\2\2\u0196\u019f\3\2\2\2\u0197\u0199\5g\64\2\u0198\u019a\5i\65"+
		"\2\u0199\u0198\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c"+
		"\7F\2\2\u019c\u019d\6\60\3\2\u019d\u019f\3\2\2\2\u019e\u018e\3\2\2\2\u019e"+
		"\u0197\3\2\2\2\u019f`\3\2\2\2\u01a0\u01a2\5k\66\2\u01a1\u01a0\3\2\2\2"+
		"\u01a2\u01a3\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a6"+
		"\3\2\2\2\u01a5\u01a7\5i\65\2\u01a6\u01a5\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7"+
		"\u01a8\3\2\2\2\u01a8\u01a9\7D\2\2\u01a9\u01aa\7F\2\2\u01aa\u01b5\3\2\2"+
		"\2\u01ab\u01ad\5g\64\2\u01ac\u01ae\5i\65\2\u01ad\u01ac\3\2\2\2\u01ad\u01ae"+
		"\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\7D\2\2\u01b0\u01b1\7F\2\2\u01b1"+
		"\u01b2\3\2\2\2\u01b2\u01b3\6\61\4\2\u01b3\u01b5\3\2\2\2\u01b4\u01a1\3"+
		"\2\2\2\u01b4\u01ab\3\2\2\2\u01b5b\3\2\2\2\u01b6\u01ba\5m\67\2\u01b7\u01ba"+
		"\5k\66\2\u01b8\u01ba\7a\2\2\u01b9\u01b6\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9"+
		"\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2"+
		"\2\2\u01bcd\3\2\2\2\u01bd\u01c3\7b\2\2\u01be\u01c2\n\4\2\2\u01bf\u01c0"+
		"\7b\2\2\u01c0\u01c2\7b\2\2\u01c1\u01be\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2"+
		"\u01c5\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c6\3\2"+
		"\2\2\u01c5\u01c3\3\2\2\2\u01c6\u01c7\7b\2\2\u01c7f\3\2\2\2\u01c8\u01ca"+
		"\5k\66\2\u01c9\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb"+
		"\u01cc\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01d1\7\60\2\2\u01ce\u01d0\5"+
		"k\66\2\u01cf\u01ce\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d1"+
		"\u01d2\3\2\2\2\u01d2\u01db\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d4\u01d6\7\60"+
		"\2\2\u01d5\u01d7\5k\66\2\u01d6\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8"+
		"\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01db\3\2\2\2\u01da\u01c9\3\2"+
		"\2\2\u01da\u01d4\3\2\2\2\u01dbh\3\2\2\2\u01dc\u01de\7G\2\2\u01dd\u01df"+
		"\t\5\2\2\u01de\u01dd\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e1\3\2\2\2\u01e0"+
		"\u01e2\5k\66\2\u01e1\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e1\3\2"+
		"\2\2\u01e3\u01e4\3\2\2\2\u01e4j\3\2\2\2\u01e5\u01e6\t\6\2\2\u01e6l\3\2"+
		"\2\2\u01e7\u01e8\t\7\2\2\u01e8n\3\2\2\2\u01e9\u01ea\7/\2\2\u01ea\u01eb"+
		"\7/\2\2\u01eb\u01ef\3\2\2\2\u01ec\u01ee\n\b\2\2\u01ed\u01ec\3\2\2\2\u01ee"+
		"\u01f1\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f3\3\2"+
		"\2\2\u01f1\u01ef\3\2\2\2\u01f2\u01f4\7\17\2\2\u01f3\u01f2\3\2\2\2\u01f3"+
		"\u01f4\3\2\2\2\u01f4\u01f6\3\2\2\2\u01f5\u01f7\7\f\2\2\u01f6\u01f5\3\2"+
		"\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f9\b8\2\2\u01f9"+
		"p\3\2\2\2\u01fa\u01fb\7\61\2\2\u01fb\u01fc\7,\2\2\u01fc\u0200\3\2\2\2"+
		"\u01fd\u01ff\13\2\2\2\u01fe\u01fd\3\2\2\2\u01ff\u0202\3\2\2\2\u0200\u0201"+
		"\3\2\2\2\u0200\u01fe\3\2\2\2\u0201\u0203\3\2\2\2\u0202\u0200\3\2\2\2\u0203"+
		"\u0204\7,\2\2\u0204\u0205\7\61\2\2\u0205\u0206\3\2\2\2\u0206\u0207\b9"+
		"\2\2\u0207r\3\2\2\2\u0208\u020a\t\t\2\2\u0209\u0208\3\2\2\2\u020a\u020b"+
		"\3\2\2\2\u020b\u0209\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020d\3\2\2\2\u020d"+
		"\u020e\b:\2\2\u020et\3\2\2\2\u020f\u0210\13\2\2\2\u0210v\3\2\2\2*\2\u00fe"+
		"\u0133\u0143\u0149\u0152\u0154\u015c\u015e\u0162\u0167\u016e\u0175\u017c"+
		"\u0181\u0187\u018b\u0190\u0193\u0199\u019e\u01a3\u01a6\u01ad\u01b4\u01b9"+
		"\u01bb\u01c1\u01c3\u01cb\u01d1\u01d8\u01da\u01de\u01e3\u01ef\u01f3\u01f6"+
		"\u0200\u020b\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}