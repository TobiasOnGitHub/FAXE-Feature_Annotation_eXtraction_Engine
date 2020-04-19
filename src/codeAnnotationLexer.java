// Generated from C:/Users/Tobias/IdeaProjects/ANTLR4_EmbeddedAnnotations\codeAnnotation.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class codeAnnotationLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BEGINMARKER=1, ENDMARKER=2, LINEMARKER=3, PARAMETER=4, ANNOSEPARATOR=5, 
		COMMENT=6, LPQ=7, STRING=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"BEGINMARKER", "ENDMARKER", "LINEMARKER", "PARAMETER", "ANNOSEPARATOR", 
			"COMMENT", "LPQ", "STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BEGINMARKER", "ENDMARKER", "LINEMARKER", "PARAMETER", "ANNOSEPARATOR", 
			"COMMENT", "LPQ", "STRING"
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


	public codeAnnotationLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "codeAnnotation.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\n\u00c2\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\7\3)\n\3\f\3\16\3,\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\7\4\67\n\4\f\4\16\4:\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\7\5C\n\5\f\5\16"+
		"\5F\13\5\3\5\7\5I\n\5\f\5\16\5L\13\5\3\5\3\5\7\5P\n\5\f\5\16\5S\13\5\3"+
		"\5\3\5\3\5\3\5\3\5\7\5Z\n\5\f\5\16\5]\13\5\3\5\7\5`\n\5\f\5\16\5c\13\5"+
		"\3\5\3\5\7\5g\n\5\f\5\16\5j\13\5\3\5\3\5\3\5\3\5\3\5\7\5q\n\5\f\5\16\5"+
		"t\13\5\3\5\7\5w\n\5\f\5\16\5z\13\5\3\5\3\5\7\5~\n\5\f\5\16\5\u0081\13"+
		"\5\3\5\3\5\3\5\3\5\7\5\u0087\n\5\f\5\16\5\u008a\13\5\5\5\u008c\n\5\3\6"+
		"\3\6\6\6\u0090\n\6\r\6\16\6\u0091\5\6\u0094\n\6\3\7\6\7\u0097\n\7\r\7"+
		"\16\7\u0098\3\7\6\7\u009c\n\7\r\7\16\7\u009d\3\7\7\7\u00a1\n\7\f\7\16"+
		"\7\u00a4\13\7\3\b\3\b\3\b\3\b\3\b\7\b\u00ab\n\b\f\b\16\b\u00ae\13\b\3"+
		"\t\6\t\u00b1\n\t\r\t\16\t\u00b2\3\t\6\t\u00b6\n\t\r\t\16\t\u00b7\3\t\6"+
		"\t\u00bb\n\t\r\t\16\t\u00bc\6\t\u00bf\n\t\r\t\16\t\u00c0\2\2\n\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\3\2\5\3\2C\\\3\2c|\3\2\62;\2\u00dd\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2\2\5\"\3\2\2\2\7/\3\2\2\2\t\u008b\3\2"+
		"\2\2\13\u0093\3\2\2\2\r\u0096\3\2\2\2\17\u00a5\3\2\2\2\21\u00be\3\2\2"+
		"\2\23\24\7(\2\2\24\25\7d\2\2\25\26\7g\2\2\26\27\7i\2\2\27\30\7k\2\2\30"+
		"\31\7p\2\2\31\35\3\2\2\2\32\34\7\"\2\2\33\32\3\2\2\2\34\37\3\2\2\2\35"+
		"\33\3\2\2\2\35\36\3\2\2\2\36 \3\2\2\2\37\35\3\2\2\2 !\5\t\5\2!\4\3\2\2"+
		"\2\"#\7(\2\2#$\7g\2\2$%\7p\2\2%&\7f\2\2&*\3\2\2\2\')\7\"\2\2(\'\3\2\2"+
		"\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\5\t\5\2.\6\3\2"+
		"\2\2/\60\7(\2\2\60\61\7n\2\2\61\62\7k\2\2\62\63\7p\2\2\63\64\7g\2\2\64"+
		"8\3\2\2\2\65\67\7\"\2\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2"+
		"\29;\3\2\2\2:8\3\2\2\2;<\5\t\5\2<\b\3\2\2\2=>\7*\2\2>D\5\17\b\2?@\5\13"+
		"\6\2@A\5\17\b\2AC\3\2\2\2B?\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EJ\3"+
		"\2\2\2FD\3\2\2\2GI\7\"\2\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3"+
		"\2\2\2LJ\3\2\2\2MQ\7+\2\2NP\5\r\7\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3"+
		"\2\2\2R\u008c\3\2\2\2SQ\3\2\2\2TU\7]\2\2U[\5\17\b\2VW\5\13\6\2WX\5\17"+
		"\b\2XZ\3\2\2\2YV\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\a\3\2\2\2][\3"+
		"\2\2\2^`\7\"\2\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ca\3"+
		"\2\2\2dh\7_\2\2eg\5\r\7\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\u008c"+
		"\3\2\2\2jh\3\2\2\2kl\7}\2\2lr\5\17\b\2mn\5\13\6\2no\5\17\b\2oq\3\2\2\2"+
		"pm\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2sx\3\2\2\2tr\3\2\2\2uw\7\"\2\2"+
		"vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{\177\7\177"+
		"\2\2|~\5\r\7\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2"+
		"\u0080\u008c\3\2\2\2\u0081\177\3\2\2\2\u0082\u0088\5\17\b\2\u0083\u0084"+
		"\5\13\6\2\u0084\u0085\5\17\b\2\u0085\u0087\3\2\2\2\u0086\u0083\3\2\2\2"+
		"\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008c"+
		"\3\2\2\2\u008a\u0088\3\2\2\2\u008b=\3\2\2\2\u008bT\3\2\2\2\u008bk\3\2"+
		"\2\2\u008b\u0082\3\2\2\2\u008c\n\3\2\2\2\u008d\u0094\7.\2\2\u008e\u0090"+
		"\7\"\2\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u008d\3\2\2\2\u0093\u008f\3\2"+
		"\2\2\u0094\f\3\2\2\2\u0095\u0097\5\21\t\2\u0096\u0095\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u00a2\3\2\2\2\u009a"+
		"\u009c\7\"\2\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2"+
		"\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\5\21\t\2\u00a0"+
		"\u009b\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2"+
		"\2\2\u00a3\16\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00ac\5\21\t\2\u00a6\u00a7"+
		"\7<\2\2\u00a7\u00a8\7<\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\5\21\t\2\u00aa"+
		"\u00a6\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\20\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1\t\2\2\2\u00b0\u00af"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00bf\3\2\2\2\u00b4\u00b6\t\3\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bf\3\2\2\2\u00b9"+
		"\u00bb\t\4\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00ba\3\2"+
		"\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00b0\3\2\2\2\u00be"+
		"\u00b5\3\2\2\2\u00be\u00ba\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00be\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\22\3\2\2\2\34\2\35*8DJQ[ahrx\177\u0088"+
		"\u008b\u0091\u0093\u0098\u009d\u00a2\u00ac\u00b2\u00b7\u00bc\u00be\u00c0"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}