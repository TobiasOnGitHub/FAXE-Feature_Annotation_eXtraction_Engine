// Generated from C:/Users/Tobias/IdeaProjects/FAXE-Feature_Annotation_eXtraction_Engine/src/main/antlr4/se/gu/faxe\featureModel.g4 by ANTLR 4.8
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
public class featureModelLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, SPACE=3, KEYWORDS=4, FEATURENAME=5;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "SPACE", "KEYWORDS", "FEATURENAME"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\n'", "'\t'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "SPACE", "KEYWORDS", "FEATURENAME"
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


	public featureModelLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "featureModel.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\7@\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\3\3\3\4\7\4\23\n\4\f\4\16\4"+
		"\26\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5 \n\5\3\5\3\5\3\6\6\6%\n\6"+
		"\r\6\16\6&\3\6\6\6*\n\6\r\6\16\6+\3\6\6\6/\n\6\r\6\16\6\60\3\6\6\6\64"+
		"\n\6\r\6\16\6\65\3\6\6\69\n\6\r\6\16\6:\6\6=\n\6\r\6\16\6>\2\2\7\3\3\5"+
		"\4\7\5\t\6\13\7\3\2\5\3\2C\\\3\2c|\3\2\62;\2L\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\3\r\3\2\2\2\5\17\3\2\2\2\7\24\3"+
		"\2\2\2\t\37\3\2\2\2\13<\3\2\2\2\r\16\7\f\2\2\16\4\3\2\2\2\17\20\7\13\2"+
		"\2\20\6\3\2\2\2\21\23\7\"\2\2\22\21\3\2\2\2\23\26\3\2\2\2\24\22\3\2\2"+
		"\2\24\25\3\2\2\2\25\27\3\2\2\2\26\24\3\2\2\2\27\30\b\4\2\2\30\b\3\2\2"+
		"\2\31\32\7q\2\2\32 \7t\2\2\33\34\7z\2\2\34\35\7q\2\2\35 \7t\2\2\36 \7"+
		"A\2\2\37\31\3\2\2\2\37\33\3\2\2\2\37\36\3\2\2\2 !\3\2\2\2!\"\b\5\2\2\""+
		"\n\3\2\2\2#%\t\2\2\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'=\3\2\2"+
		"\2(*\t\3\2\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,=\3\2\2\2-/\t\4\2"+
		"\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61=\3\2\2\2\62\64\7"+
		"a\2\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66=\3\2"+
		"\2\2\679\7)\2\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<$"+
		"\3\2\2\2<)\3\2\2\2<.\3\2\2\2<\63\3\2\2\2<8\3\2\2\2=>\3\2\2\2><\3\2\2\2"+
		">?\3\2\2\2?\f\3\2\2\2\f\2\24\37&+\60\65:<>\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}