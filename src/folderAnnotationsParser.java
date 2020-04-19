// Generated from C:/Users/Tobias/IdeaProjects/ANTLR4_EmbeddedAnnotations\folderAnnotations.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class folderAnnotationsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ANNOSEPARATOR=1, LPQ=2, STRING=3;
	public static final int
		RULE_folderAnnotation = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"folderAnnotation"
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
			null, "ANNOSEPARATOR", "LPQ", "STRING"
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
	public String getGrammarFileName() { return "folderAnnotations.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public folderAnnotationsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FolderAnnotationContext extends ParserRuleContext {
		public List<TerminalNode> LPQ() { return getTokens(folderAnnotationsParser.LPQ); }
		public TerminalNode LPQ(int i) {
			return getToken(folderAnnotationsParser.LPQ, i);
		}
		public List<TerminalNode> ANNOSEPARATOR() { return getTokens(folderAnnotationsParser.ANNOSEPARATOR); }
		public TerminalNode ANNOSEPARATOR(int i) {
			return getToken(folderAnnotationsParser.ANNOSEPARATOR, i);
		}
		public FolderAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_folderAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof folderAnnotationsListener ) ((folderAnnotationsListener)listener).enterFolderAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof folderAnnotationsListener ) ((folderAnnotationsListener)listener).exitFolderAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof folderAnnotationsVisitor ) return ((folderAnnotationsVisitor<? extends T>)visitor).visitFolderAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FolderAnnotationContext folderAnnotation() throws RecognitionException {
		FolderAnnotationContext _localctx = new FolderAnnotationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_folderAnnotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2);
			match(LPQ);
			setState(7);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ANNOSEPARATOR) {
				{
				{
				setState(3);
				match(ANNOSEPARATOR);
				setState(4);
				match(LPQ);
				}
				}
				setState(9);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\5\r\4\2\t\2\3\2\3"+
		"\2\3\2\7\2\b\n\2\f\2\16\2\13\13\2\3\2\2\2\3\2\2\2\2\f\2\4\3\2\2\2\4\t"+
		"\7\4\2\2\5\6\7\3\2\2\6\b\7\4\2\2\7\5\3\2\2\2\b\13\3\2\2\2\t\7\3\2\2\2"+
		"\t\n\3\2\2\2\n\3\3\2\2\2\13\t\3\2\2\2\3\t";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}