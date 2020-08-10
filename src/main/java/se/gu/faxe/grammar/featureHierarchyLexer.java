// Generated from C:/Users/Tobias/IdeaProjects/FAXE-Feature_Annotation_eXtraction_Engine/src/main/antlr4/se/gu/faxe\featureHierarchy.g4 by ANTLR 4.8
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
public class featureHierarchyLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, SPACE=9, 
		KEYWORDS=10, FEATURENAME=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "SPACE", 
			"KEYWORDS", "FEATURENAME"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\n'", "'\t'", "'\t\t'", "'\t\t\t'", "'\t\t\t\t'", "'\t\t\t\t\t'", 
			"'\t\t\t\t\t\t'", "'\t\t\t\t\t\t\t'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "SPACE", "KEYWORDS", 
			"FEATURENAME"
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


	public featureHierarchyLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "featureHierarchy.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\rm\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\7\n@\n\n\f\n\16\nC\13\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13M\n\13\3\13\3\13\3\f\6\fR\n\f\r\f\16\fS\3\f\6\fW\n"+
		"\f\r\f\16\fX\3\f\6\f\\\n\f\r\f\16\f]\3\f\6\fa\n\f\r\f\16\fb\3\f\6\ff\n"+
		"\f\r\f\16\fg\6\fj\n\f\r\f\16\fk\2\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\3\2\5\3\2C\\\3\2c|\3\2\62;\2y\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5\33\3\2"+
		"\2\2\7\35\3\2\2\2\t \3\2\2\2\13$\3\2\2\2\r)\3\2\2\2\17/\3\2\2\2\21\66"+
		"\3\2\2\2\23A\3\2\2\2\25L\3\2\2\2\27i\3\2\2\2\31\32\7\f\2\2\32\4\3\2\2"+
		"\2\33\34\7\13\2\2\34\6\3\2\2\2\35\36\7\13\2\2\36\37\7\13\2\2\37\b\3\2"+
		"\2\2 !\7\13\2\2!\"\7\13\2\2\"#\7\13\2\2#\n\3\2\2\2$%\7\13\2\2%&\7\13\2"+
		"\2&\'\7\13\2\2\'(\7\13\2\2(\f\3\2\2\2)*\7\13\2\2*+\7\13\2\2+,\7\13\2\2"+
		",-\7\13\2\2-.\7\13\2\2.\16\3\2\2\2/\60\7\13\2\2\60\61\7\13\2\2\61\62\7"+
		"\13\2\2\62\63\7\13\2\2\63\64\7\13\2\2\64\65\7\13\2\2\65\20\3\2\2\2\66"+
		"\67\7\13\2\2\678\7\13\2\289\7\13\2\29:\7\13\2\2:;\7\13\2\2;<\7\13\2\2"+
		"<=\7\13\2\2=\22\3\2\2\2>@\7\"\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2"+
		"\2\2BD\3\2\2\2CA\3\2\2\2DE\b\n\2\2E\24\3\2\2\2FG\7q\2\2GM\7t\2\2HI\7z"+
		"\2\2IJ\7q\2\2JM\7t\2\2KM\7A\2\2LF\3\2\2\2LH\3\2\2\2LK\3\2\2\2MN\3\2\2"+
		"\2NO\b\13\2\2O\26\3\2\2\2PR\t\2\2\2QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3"+
		"\2\2\2Tj\3\2\2\2UW\t\3\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2Yj\3"+
		"\2\2\2Z\\\t\4\2\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^j\3\2\2\2_"+
		"a\7a\2\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2cj\3\2\2\2df\7)\2\2ed"+
		"\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hj\3\2\2\2iQ\3\2\2\2iV\3\2\2\2i"+
		"[\3\2\2\2i`\3\2\2\2ie\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\30\3\2\2"+
		"\2\f\2ALSX]bgik\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}