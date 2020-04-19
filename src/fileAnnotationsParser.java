// Generated from C:/Users/Tobias/IdeaProjects/ANTLR4_EmbeddedAnnotations\fileAnnotations.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class fileAnnotationsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, FILE=3, FILESEPARATOR=4, LPQ=5, STRING=6;
	public static final int
		RULE_fileAnnotation = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"fileAnnotation"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "FILE", "FILESEPARATOR", "LPQ", "STRING"
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
	public String getGrammarFileName() { return "fileAnnotations.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public fileAnnotationsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileAnnotationContext extends ParserRuleContext {
		public List<TerminalNode> FILE() { return getTokens(fileAnnotationsParser.FILE); }
		public TerminalNode FILE(int i) {
			return getToken(fileAnnotationsParser.FILE, i);
		}
		public List<TerminalNode> LPQ() { return getTokens(fileAnnotationsParser.LPQ); }
		public TerminalNode LPQ(int i) {
			return getToken(fileAnnotationsParser.LPQ, i);
		}
		public List<TerminalNode> FILESEPARATOR() { return getTokens(fileAnnotationsParser.FILESEPARATOR); }
		public TerminalNode FILESEPARATOR(int i) {
			return getToken(fileAnnotationsParser.FILESEPARATOR, i);
		}
		public FileAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fileAnnotationsListener ) ((fileAnnotationsListener)listener).enterFileAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fileAnnotationsListener ) ((fileAnnotationsListener)listener).exitFileAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fileAnnotationsVisitor ) return ((fileAnnotationsVisitor<? extends T>)visitor).visitFileAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileAnnotationContext fileAnnotation() throws RecognitionException {
		FileAnnotationContext _localctx = new FileAnnotationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_fileAnnotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2);
			match(FILE);
			setState(7);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FILESEPARATOR) {
				{
				{
				setState(3);
				match(FILESEPARATOR);
				setState(4);
				match(FILE);
				}
				}
				setState(9);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(11);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(10);
				match(T__0);
				}
			}

			setState(13);
			match(T__1);
			{
			setState(14);
			match(LPQ);
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FILESEPARATOR) {
				{
				{
				setState(15);
				match(FILESEPARATOR);
				setState(16);
				match(LPQ);
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b\31\4\2\t\2\3\2"+
		"\3\2\3\2\7\2\b\n\2\f\2\16\2\13\13\2\3\2\5\2\16\n\2\3\2\3\2\3\2\3\2\7\2"+
		"\24\n\2\f\2\16\2\27\13\2\3\2\2\2\3\2\2\2\2\32\2\4\3\2\2\2\4\t\7\5\2\2"+
		"\5\6\7\6\2\2\6\b\7\5\2\2\7\5\3\2\2\2\b\13\3\2\2\2\t\7\3\2\2\2\t\n\3\2"+
		"\2\2\n\r\3\2\2\2\13\t\3\2\2\2\f\16\7\3\2\2\r\f\3\2\2\2\r\16\3\2\2\2\16"+
		"\17\3\2\2\2\17\20\7\4\2\2\20\25\7\7\2\2\21\22\7\6\2\2\22\24\7\7\2\2\23"+
		"\21\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\3\3\2\2\2\27"+
		"\25\3\2\2\2\5\t\r\25";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}