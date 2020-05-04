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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, SPACE=8, STRING=9;
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
			null, "':'", "'\n'", "' '", "','", "'\"'", "'.'", "'::'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "SPACE", "STRING"
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
			int _alt;
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(23);
				fileReference();
				setState(33);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(27);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(24);
							match(T__2);
							}
							}
							setState(29);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(30);
						fileReference();
						}
						} 
					}
					setState(35);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(36);
					match(T__2);
					}
					}
					setState(41);
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
				setState(42);
				fileReference();
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(46);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(43);
							match(T__2);
							}
							}
							setState(48);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(49);
						match(T__3);
						setState(53);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(50);
							match(T__2);
							}
							}
							setState(55);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(56);
						fileReference();
						}
						} 
					}
					setState(61);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(62);
					match(T__2);
					}
					}
					setState(67);
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
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(70);
				match(T__4);
				setState(71);
				fileName();
				setState(72);
				match(T__4);
				}
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(74);
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
		public List<TerminalNode> STRING() { return getTokens(fileAnnotationsParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(fileAnnotationsParser.STRING, i);
		}
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
		try {
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(78);
				match(STRING);
				setState(79);
				match(T__5);
				setState(80);
				match(STRING);
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
			int _alt;
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(83);
				lpq();
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(87);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(84);
							match(T__2);
							}
							}
							setState(89);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(90);
						lpq();
						}
						} 
					}
					setState(95);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(96);
					match(T__2);
					}
					}
					setState(101);
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
				setState(102);
				lpq();
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(106);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(103);
							match(T__2);
							}
							}
							setState(108);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(109);
						match(T__3);
						setState(113);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(110);
							match(T__2);
							}
							}
							setState(115);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(116);
						lpq();
						}
						} 
					}
					setState(121);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(122);
					match(T__2);
					}
					}
					setState(127);
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
			setState(130);
			match(STRING);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(131);
				match(T__6);
				setState(132);
				match(STRING);
				}
				}
				setState(137);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13\u008d\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\5\2\21\n\2\3\2\6\2\24"+
		"\n\2\r\2\16\2\25\3\2\3\2\3\3\3\3\7\3\34\n\3\f\3\16\3\37\13\3\3\3\7\3\""+
		"\n\3\f\3\16\3%\13\3\3\3\7\3(\n\3\f\3\16\3+\13\3\3\3\3\3\7\3/\n\3\f\3\16"+
		"\3\62\13\3\3\3\3\3\7\3\66\n\3\f\3\16\39\13\3\3\3\7\3<\n\3\f\3\16\3?\13"+
		"\3\3\3\7\3B\n\3\f\3\16\3E\13\3\5\3G\n\3\3\4\3\4\3\4\3\4\3\4\5\4N\n\4\3"+
		"\5\3\5\3\5\3\5\5\5T\n\5\3\6\3\6\7\6X\n\6\f\6\16\6[\13\6\3\6\7\6^\n\6\f"+
		"\6\16\6a\13\6\3\6\7\6d\n\6\f\6\16\6g\13\6\3\6\3\6\7\6k\n\6\f\6\16\6n\13"+
		"\6\3\6\3\6\7\6r\n\6\f\6\16\6u\13\6\3\6\7\6x\n\6\f\6\16\6{\13\6\3\6\7\6"+
		"~\n\6\f\6\16\6\u0081\13\6\5\6\u0083\n\6\3\7\3\7\3\7\7\7\u0088\n\7\f\7"+
		"\16\7\u008b\13\7\3\7\2\2\b\2\4\6\b\n\f\2\2\2\u009b\2\16\3\2\2\2\4F\3\2"+
		"\2\2\6M\3\2\2\2\bS\3\2\2\2\n\u0082\3\2\2\2\f\u0084\3\2\2\2\16\20\5\4\3"+
		"\2\17\21\7\3\2\2\20\17\3\2\2\2\20\21\3\2\2\2\21\23\3\2\2\2\22\24\7\4\2"+
		"\2\23\22\3\2\2\2\24\25\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\27\3\2\2"+
		"\2\27\30\5\n\6\2\30\3\3\2\2\2\31#\5\6\4\2\32\34\7\5\2\2\33\32\3\2\2\2"+
		"\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36 \3\2\2\2\37\35\3\2\2\2 "+
		"\"\5\6\4\2!\35\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$)\3\2\2\2%#\3\2"+
		"\2\2&(\7\5\2\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*G\3\2\2\2+)\3"+
		"\2\2\2,=\5\6\4\2-/\7\5\2\2.-\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2"+
		"\2\2\61\63\3\2\2\2\62\60\3\2\2\2\63\67\7\6\2\2\64\66\7\5\2\2\65\64\3\2"+
		"\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28:\3\2\2\29\67\3\2\2\2:<\5\6"+
		"\4\2;\60\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>C\3\2\2\2?=\3\2\2\2@B\7"+
		"\5\2\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DG\3\2\2\2EC\3\2\2\2F\31"+
		"\3\2\2\2F,\3\2\2\2G\5\3\2\2\2HI\7\7\2\2IJ\5\b\5\2JK\7\7\2\2KN\3\2\2\2"+
		"LN\5\b\5\2MH\3\2\2\2ML\3\2\2\2N\7\3\2\2\2OT\7\13\2\2PQ\7\13\2\2QR\7\b"+
		"\2\2RT\7\13\2\2SO\3\2\2\2SP\3\2\2\2T\t\3\2\2\2U_\5\f\7\2VX\7\5\2\2WV\3"+
		"\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[Y\3\2\2\2\\^\5\f\7\2]"+
		"Y\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`e\3\2\2\2a_\3\2\2\2bd\7\5\2\2"+
		"cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\u0083\3\2\2\2ge\3\2\2\2hy\5"+
		"\f\7\2ik\7\5\2\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3"+
		"\2\2\2os\7\6\2\2pr\7\5\2\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3"+
		"\2\2\2us\3\2\2\2vx\5\f\7\2wl\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\177"+
		"\3\2\2\2{y\3\2\2\2|~\7\5\2\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177"+
		"\u0080\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0082U\3\2\2\2\u0082"+
		"h\3\2\2\2\u0083\13\3\2\2\2\u0084\u0089\7\13\2\2\u0085\u0086\7\t\2\2\u0086"+
		"\u0088\7\13\2\2\u0087\u0085\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u008a\r\3\2\2\2\u008b\u0089\3\2\2\2\27\20\25"+
		"\35#)\60\67=CFMSY_elsy\177\u0082\u0089";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}