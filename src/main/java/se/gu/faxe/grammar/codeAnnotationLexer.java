// Generated from .../FAXE-Feature_Annotation_eXtraction_Engine/src/main/antlr4/se/gu/faxe\codeAnnotation.g4 by ANTLR 4.8
package se.gu.faxe.grammar;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, SPACE=13, FEATURENAME=14, OTHER=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "SPACE", "FEATURENAME", "OTHER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'&begin'", "' '", "'&end'", "'&line'", "'('", "')'", "','", "'['", 
			"']'", "'{'", "'}'", "'::'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "SPACE", "FEATURENAME", "OTHER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21o\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\7\16"+
		"H\n\16\f\16\16\16K\13\16\3\16\3\16\3\17\6\17P\n\17\r\17\16\17Q\3\17\6"+
		"\17U\n\17\r\17\16\17V\3\17\6\17Z\n\17\r\17\16\17[\3\17\6\17_\n\17\r\17"+
		"\16\17`\3\17\6\17d\n\17\r\17\16\17e\6\17h\n\17\r\17\16\17i\3\20\3\20\3"+
		"\20\3\20\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21\3\2\5\3\2C\\\3\2c|\3\2\62;\2y\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2\2\2\5(\3\2\2\2\7*\3\2\2\2\t/\3"+
		"\2\2\2\13\65\3\2\2\2\r\67\3\2\2\2\179\3\2\2\2\21;\3\2\2\2\23=\3\2\2\2"+
		"\25?\3\2\2\2\27A\3\2\2\2\31C\3\2\2\2\33I\3\2\2\2\35g\3\2\2\2\37k\3\2\2"+
		"\2!\"\7(\2\2\"#\7d\2\2#$\7g\2\2$%\7i\2\2%&\7k\2\2&\'\7p\2\2\'\4\3\2\2"+
		"\2()\7\"\2\2)\6\3\2\2\2*+\7(\2\2+,\7g\2\2,-\7p\2\2-.\7f\2\2.\b\3\2\2\2"+
		"/\60\7(\2\2\60\61\7n\2\2\61\62\7k\2\2\62\63\7p\2\2\63\64\7g\2\2\64\n\3"+
		"\2\2\2\65\66\7*\2\2\66\f\3\2\2\2\678\7+\2\28\16\3\2\2\29:\7.\2\2:\20\3"+
		"\2\2\2;<\7]\2\2<\22\3\2\2\2=>\7_\2\2>\24\3\2\2\2?@\7}\2\2@\26\3\2\2\2"+
		"AB\7\177\2\2B\30\3\2\2\2CD\7<\2\2DE\7<\2\2E\32\3\2\2\2FH\7\"\2\2GF\3\2"+
		"\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\b\16\2\2M\34"+
		"\3\2\2\2NP\t\2\2\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2\2QR\3\2\2\2Rh\3\2\2\2S"+
		"U\t\3\2\2TS\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2Wh\3\2\2\2XZ\t\4\2\2"+
		"YX\3\2\2\2Z[\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\h\3\2\2\2]_\7a\2\2^]\3\2\2"+
		"\2_`\3\2\2\2`^\3\2\2\2`a\3\2\2\2ah\3\2\2\2bd\7)\2\2cb\3\2\2\2de\3\2\2"+
		"\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2gO\3\2\2\2gT\3\2\2\2gY\3\2\2\2g^\3\2\2"+
		"\2gc\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\36\3\2\2\2kl\13\2\2\2lm\3"+
		"\2\2\2mn\b\20\2\2n \3\2\2\2\13\2IQV[`egi\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}