// Generated from C:/Users/Tobias/IdeaProjects/ANTLR4_EmbeddedAnnotations\folderAnnotations.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class folderAnnotationsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, SPACE=5, FEATURENAME=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "SPACE", "FEATURENAME"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "','", "'\n'", "'::'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "SPACE", "FEATURENAME"
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


	public folderAnnotationsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "folderAnnotations.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\b=\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5"+
		"\3\5\3\6\7\6\32\n\6\f\6\16\6\35\13\6\3\6\3\6\3\7\6\7\"\n\7\r\7\16\7#\3"+
		"\7\6\7\'\n\7\r\7\16\7(\3\7\6\7,\n\7\r\7\16\7-\3\7\6\7\61\n\7\r\7\16\7"+
		"\62\3\7\6\7\66\n\7\r\7\16\7\67\6\7:\n\7\r\7\16\7;\2\2\b\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\3\2\5\3\2C\\\3\2c|\3\2\62;\2G\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\17\3\2\2\2\5\21\3\2\2"+
		"\2\7\23\3\2\2\2\t\25\3\2\2\2\13\33\3\2\2\2\r9\3\2\2\2\17\20\7\"\2\2\20"+
		"\4\3\2\2\2\21\22\7.\2\2\22\6\3\2\2\2\23\24\7\f\2\2\24\b\3\2\2\2\25\26"+
		"\7<\2\2\26\27\7<\2\2\27\n\3\2\2\2\30\32\7\"\2\2\31\30\3\2\2\2\32\35\3"+
		"\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35\33\3\2\2\2\36\37\b"+
		"\6\2\2\37\f\3\2\2\2 \"\t\2\2\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2"+
		"\2$:\3\2\2\2%\'\t\3\2\2&%\3\2\2\2\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2):\3\2"+
		"\2\2*,\t\4\2\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2.:\3\2\2\2/\61\7"+
		"a\2\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63:\3\2\2"+
		"\2\64\66\7)\2\2\65\64\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\2"+
		"8:\3\2\2\29!\3\2\2\29&\3\2\2\29+\3\2\2\29\60\3\2\2\29\65\3\2\2\2:;\3\2"+
		"\2\2;9\3\2\2\2;<\3\2\2\2<\16\3\2\2\2\13\2\33#(-\62\679;\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}