// Generated from C:/Users/Tobias/IdeaProjects/FAXE-Feature_Annotation_eXtraction_Engine\fileAnnotations.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class fileAnnotationsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, SPACE=8, WS=9, 
		STRING=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "SPACE", "WS", 
			"STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'\n'", "' '", "','", "'\"'", "'.'", "'::'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "SPACE", "WS", "STRING"
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


	public fileAnnotationsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "fileAnnotations.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\fR\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\7"+
		"\t(\n\t\f\t\16\t+\13\t\3\t\3\t\3\n\6\n\60\n\n\r\n\16\n\61\3\n\3\n\3\13"+
		"\6\13\67\n\13\r\13\16\138\3\13\6\13<\n\13\r\13\16\13=\3\13\6\13A\n\13"+
		"\r\13\16\13B\3\13\6\13F\n\13\r\13\16\13G\3\13\6\13K\n\13\r\13\16\13L\6"+
		"\13O\n\13\r\13\16\13P\2\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\3\2\6\3\2\17\17\3\2C\\\3\2c|\3\2\62;\2]\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5\31\3\2\2\2\7\33\3\2\2\2\t"+
		"\35\3\2\2\2\13\37\3\2\2\2\r!\3\2\2\2\17#\3\2\2\2\21)\3\2\2\2\23/\3\2\2"+
		"\2\25N\3\2\2\2\27\30\7<\2\2\30\4\3\2\2\2\31\32\7\f\2\2\32\6\3\2\2\2\33"+
		"\34\7\"\2\2\34\b\3\2\2\2\35\36\7.\2\2\36\n\3\2\2\2\37 \7$\2\2 \f\3\2\2"+
		"\2!\"\7\60\2\2\"\16\3\2\2\2#$\7<\2\2$%\7<\2\2%\20\3\2\2\2&(\7\"\2\2\'"+
		"&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,-\b\t\2\2"+
		"-\22\3\2\2\2.\60\t\2\2\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2"+
		"\2\2\62\63\3\2\2\2\63\64\b\n\2\2\64\24\3\2\2\2\65\67\t\3\2\2\66\65\3\2"+
		"\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29O\3\2\2\2:<\t\4\2\2;:\3\2\2\2<"+
		"=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>O\3\2\2\2?A\t\5\2\2@?\3\2\2\2AB\3\2\2\2"+
		"B@\3\2\2\2BC\3\2\2\2CO\3\2\2\2DF\7a\2\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2"+
		"GH\3\2\2\2HO\3\2\2\2IK\7)\2\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2"+
		"MO\3\2\2\2N\66\3\2\2\2N;\3\2\2\2N@\3\2\2\2NE\3\2\2\2NJ\3\2\2\2OP\3\2\2"+
		"\2PN\3\2\2\2PQ\3\2\2\2Q\26\3\2\2\2\f\2)\618=BGLNP\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}