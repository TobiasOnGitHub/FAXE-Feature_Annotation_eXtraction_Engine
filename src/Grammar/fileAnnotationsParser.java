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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, FILESEPARATOR=14, STRING=15;
	public static final int
		RULE_fileAnnotation = 0, RULE_fileReferences = 1, RULE_fileReference = 2, 
		RULE_fileName = 3, RULE_lpqReferences = 4, RULE_lpq = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"fileAnnotation", "fileReferences", "fileReference", "fileName", "lpqReferences", 
			"lpq"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'\n'", "' '", "','", "'\"'", "'<'", "'>'", "'/'", "'\\'", 
			"'|'", "'?'", "'*'", "'::'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "FILESEPARATOR", "STRING"
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
		public FileReferencesContext fileReferences() {
			return getRuleContext(FileReferencesContext.class,0);
		}
		public LpqReferencesContext lpqReferences() {
			return getRuleContext(LpqReferencesContext.class,0);
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
			setState(12);
			fileReferences();
			setState(14);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(13);
				match(T__0);
				}
			}

			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16);
				match(T__1);
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			setState(21);
			lpqReferences();
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

	public static class FileReferencesContext extends ParserRuleContext {
		public List<FileReferenceContext> fileReference() {
			return getRuleContexts(FileReferenceContext.class);
		}
		public FileReferenceContext fileReference(int i) {
			return getRuleContext(FileReferenceContext.class,i);
		}
		public FileReferencesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileReferences; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fileAnnotationsListener ) ((fileAnnotationsListener)listener).enterFileReferences(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fileAnnotationsListener ) ((fileAnnotationsListener)listener).exitFileReferences(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fileAnnotationsVisitor ) return ((fileAnnotationsVisitor<? extends T>)visitor).visitFileReferences(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileReferencesContext fileReferences() throws RecognitionException {
		FileReferencesContext _localctx = new FileReferencesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_fileReferences);
		int _la;
		try {
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(23);
				fileReference();
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(24);
					match(T__2);
					setState(25);
					fileReference();
					}
					}
					setState(30);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(31);
				fileReference();
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(32);
					match(T__3);
					setState(33);
					fileReference();
					}
					}
					setState(38);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class FileReferenceContext extends ParserRuleContext {
		public FileNameContext fileName() {
			return getRuleContext(FileNameContext.class,0);
		}
		public FileReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fileAnnotationsListener ) ((fileAnnotationsListener)listener).enterFileReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fileAnnotationsListener ) ((fileAnnotationsListener)listener).exitFileReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fileAnnotationsVisitor ) return ((fileAnnotationsVisitor<? extends T>)visitor).visitFileReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileReferenceContext fileReference() throws RecognitionException {
		FileReferenceContext _localctx = new FileReferenceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fileReference);
		try {
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(41);
				match(T__4);
				setState(42);
				fileName();
				setState(43);
				match(T__4);
				}
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case T__12:
			case FILESEPARATOR:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(45);
				fileName();
				}
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

	public static class FileNameContext extends ParserRuleContext {
		public FileNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fileAnnotationsListener ) ((fileAnnotationsListener)listener).enterFileName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fileAnnotationsListener ) ((fileAnnotationsListener)listener).exitFileName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fileAnnotationsVisitor ) return ((fileAnnotationsVisitor<? extends T>)visitor).visitFileName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileNameContext fileName() throws RecognitionException {
		FileNameContext _localctx = new FileNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fileName);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(48);
					_la = _input.LA(1);
					if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class LpqReferencesContext extends ParserRuleContext {
		public List<LpqContext> lpq() {
			return getRuleContexts(LpqContext.class);
		}
		public LpqContext lpq(int i) {
			return getRuleContext(LpqContext.class,i);
		}
		public LpqReferencesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lpqReferences; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fileAnnotationsListener ) ((fileAnnotationsListener)listener).enterLpqReferences(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fileAnnotationsListener ) ((fileAnnotationsListener)listener).exitLpqReferences(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fileAnnotationsVisitor ) return ((fileAnnotationsVisitor<? extends T>)visitor).visitLpqReferences(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LpqReferencesContext lpqReferences() throws RecognitionException {
		LpqReferencesContext _localctx = new LpqReferencesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_lpqReferences);
		int _la;
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(54);
				lpq();
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(55);
					match(T__2);
					setState(56);
					lpq();
					}
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(62);
				lpq();
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(63);
					match(T__3);
					setState(64);
					lpq();
					}
					}
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class LpqContext extends ParserRuleContext {
		public LpqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lpq; }
	 
		public LpqContext() { }
		public void copyFrom(LpqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FeatureContext extends LpqContext {
		public List<TerminalNode> STRING() { return getTokens(fileAnnotationsParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(fileAnnotationsParser.STRING, i);
		}
		public FeatureContext(LpqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fileAnnotationsListener ) ((fileAnnotationsListener)listener).enterFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fileAnnotationsListener ) ((fileAnnotationsListener)listener).exitFeature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fileAnnotationsVisitor ) return ((fileAnnotationsVisitor<? extends T>)visitor).visitFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LpqContext lpq() throws RecognitionException {
		LpqContext _localctx = new LpqContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_lpq);
		int _la;
		try {
			_localctx = new FeatureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(STRING);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(73);
				match(T__12);
				setState(74);
				match(STRING);
				}
				}
				setState(79);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21S\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\5\2\21\n\2\3\2\6\2\24\n\2\r"+
		"\2\16\2\25\3\2\3\2\3\3\3\3\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\3\3\3\3\3\7"+
		"\3%\n\3\f\3\16\3(\13\3\5\3*\n\3\3\4\3\4\3\4\3\4\3\4\5\4\61\n\4\3\5\7\5"+
		"\64\n\5\f\5\16\5\67\13\5\3\6\3\6\3\6\7\6<\n\6\f\6\16\6?\13\6\3\6\3\6\3"+
		"\6\7\6D\n\6\f\6\16\6G\13\6\5\6I\n\6\3\7\3\7\3\7\7\7N\n\7\f\7\16\7Q\13"+
		"\7\3\7\2\2\b\2\4\6\b\n\f\2\3\4\2\3\3\7\16\2W\2\16\3\2\2\2\4)\3\2\2\2\6"+
		"\60\3\2\2\2\b\65\3\2\2\2\nH\3\2\2\2\fJ\3\2\2\2\16\20\5\4\3\2\17\21\7\3"+
		"\2\2\20\17\3\2\2\2\20\21\3\2\2\2\21\23\3\2\2\2\22\24\7\4\2\2\23\22\3\2"+
		"\2\2\24\25\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\27\3\2\2\2\27\30\5\n"+
		"\6\2\30\3\3\2\2\2\31\36\5\6\4\2\32\33\7\5\2\2\33\35\5\6\4\2\34\32\3\2"+
		"\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37*\3\2\2\2 \36\3\2\2\2!"+
		"&\5\6\4\2\"#\7\6\2\2#%\5\6\4\2$\"\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2"+
		"\2\'*\3\2\2\2(&\3\2\2\2)\31\3\2\2\2)!\3\2\2\2*\5\3\2\2\2+,\7\7\2\2,-\5"+
		"\b\5\2-.\7\7\2\2.\61\3\2\2\2/\61\5\b\5\2\60+\3\2\2\2\60/\3\2\2\2\61\7"+
		"\3\2\2\2\62\64\n\2\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66"+
		"\3\2\2\2\66\t\3\2\2\2\67\65\3\2\2\28=\5\f\7\29:\7\5\2\2:<\5\f\7\2;9\3"+
		"\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>I\3\2\2\2?=\3\2\2\2@E\5\f\7\2AB\7"+
		"\6\2\2BD\5\f\7\2CA\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FI\3\2\2\2GE\3"+
		"\2\2\2H8\3\2\2\2H@\3\2\2\2I\13\3\2\2\2JO\7\21\2\2KL\7\17\2\2LN\7\21\2"+
		"\2MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\r\3\2\2\2QO\3\2\2\2\r\20\25"+
		"\36&)\60\65=EHO";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}