// Generated from C:/Users/Tobias/IdeaProjects/FAXE-Feature_Annotation_eXtraction_Engine/src/main/antlr4/se/gu/faxe\fileAnnotations.g4 by ANTLR 4.8
package se.gu.faxe.grammar;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, SPACE=8, WS=9, 
		STRING=10;
	public static final int
		RULE_fileAnnotations = 0, RULE_fileAnnotation = 1, RULE_fileReferences = 2, 
		RULE_fileReference = 3, RULE_fileName = 4, RULE_lpqReferences = 5, RULE_lpq = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"fileAnnotations", "fileAnnotation", "fileReferences", "fileReference", 
			"fileName", "lpqReferences", "lpq"
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

	public static class FileAnnotationsContext extends ParserRuleContext {
		public List<FileAnnotationContext> fileAnnotation() {
			return getRuleContexts(FileAnnotationContext.class);
		}
		public FileAnnotationContext fileAnnotation(int i) {
			return getRuleContext(FileAnnotationContext.class,i);
		}
		public FileAnnotationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileAnnotations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fileAnnotationsListener ) ((fileAnnotationsListener)listener).enterFileAnnotations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fileAnnotationsListener ) ((fileAnnotationsListener)listener).exitFileAnnotations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fileAnnotationsVisitor ) return ((fileAnnotationsVisitor<? extends T>)visitor).visitFileAnnotations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileAnnotationsContext fileAnnotations() throws RecognitionException {
		FileAnnotationsContext _localctx = new FileAnnotationsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_fileAnnotations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4 || _la==STRING) {
				{
				{
				setState(14);
				fileAnnotation();
				}
				}
				setState(19);
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
		enterRule(_localctx, 2, RULE_fileAnnotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			fileReferences();
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(21);
				match(T__0);
				}
			}

			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24);
				match(T__1);
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			setState(29);
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
		enterRule(_localctx, 4, RULE_fileReferences);
		int _la;
		try {
			int _alt;
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(31);
				fileReference();
				setState(41);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(35);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(32);
							match(T__2);
							}
							}
							setState(37);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(38);
						fileReference();
						}
						} 
					}
					setState(43);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(44);
					match(T__2);
					}
					}
					setState(49);
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
				setState(50);
				fileReference();
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(54);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(51);
							match(T__2);
							}
							}
							setState(56);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(57);
						match(T__3);
						setState(61);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(58);
							match(T__2);
							}
							}
							setState(63);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(64);
						fileReference();
						}
						} 
					}
					setState(69);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(70);
					match(T__2);
					}
					}
					setState(75);
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
		enterRule(_localctx, 6, RULE_fileReference);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(78);
				match(T__4);
				setState(79);
				fileName();
				setState(80);
				match(T__4);
				}
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(82);
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
		enterRule(_localctx, 8, RULE_fileName);
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(86);
				match(STRING);
				setState(87);
				match(T__5);
				setState(88);
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
		enterRule(_localctx, 10, RULE_lpqReferences);
		int _la;
		try {
			int _alt;
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(91);
				lpq();
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(95);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(92);
							match(T__2);
							}
							}
							setState(97);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(98);
						lpq();
						}
						} 
					}
					setState(103);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(104);
					match(T__2);
					}
					}
					setState(109);
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
				setState(110);
				lpq();
				setState(127);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(114);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(111);
							match(T__2);
							}
							}
							setState(116);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(117);
						match(T__3);
						setState(121);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(118);
							match(T__2);
							}
							}
							setState(123);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(124);
						lpq();
						}
						} 
					}
					setState(129);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(130);
					match(T__2);
					}
					}
					setState(135);
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
		enterRule(_localctx, 12, RULE_lpq);
		int _la;
		try {
			_localctx = new FeatureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(STRING);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(139);
				match(T__6);
				setState(140);
				match(STRING);
				}
				}
				setState(145);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\f\u0095\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\7\2\22\n\2\f\2\16\2"+
		"\25\13\2\3\3\3\3\5\3\31\n\3\3\3\6\3\34\n\3\r\3\16\3\35\3\3\3\3\3\4\3\4"+
		"\7\4$\n\4\f\4\16\4\'\13\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\4\7\4\60\n\4\f"+
		"\4\16\4\63\13\4\3\4\3\4\7\4\67\n\4\f\4\16\4:\13\4\3\4\3\4\7\4>\n\4\f\4"+
		"\16\4A\13\4\3\4\7\4D\n\4\f\4\16\4G\13\4\3\4\7\4J\n\4\f\4\16\4M\13\4\5"+
		"\4O\n\4\3\5\3\5\3\5\3\5\3\5\5\5V\n\5\3\6\3\6\3\6\3\6\5\6\\\n\6\3\7\3\7"+
		"\7\7`\n\7\f\7\16\7c\13\7\3\7\7\7f\n\7\f\7\16\7i\13\7\3\7\7\7l\n\7\f\7"+
		"\16\7o\13\7\3\7\3\7\7\7s\n\7\f\7\16\7v\13\7\3\7\3\7\7\7z\n\7\f\7\16\7"+
		"}\13\7\3\7\7\7\u0080\n\7\f\7\16\7\u0083\13\7\3\7\7\7\u0086\n\7\f\7\16"+
		"\7\u0089\13\7\5\7\u008b\n\7\3\b\3\b\3\b\7\b\u0090\n\b\f\b\16\b\u0093\13"+
		"\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2\u00a3\2\23\3\2\2\2\4\26\3\2\2\2\6N\3"+
		"\2\2\2\bU\3\2\2\2\n[\3\2\2\2\f\u008a\3\2\2\2\16\u008c\3\2\2\2\20\22\5"+
		"\4\3\2\21\20\3\2\2\2\22\25\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\3\3"+
		"\2\2\2\25\23\3\2\2\2\26\30\5\6\4\2\27\31\7\3\2\2\30\27\3\2\2\2\30\31\3"+
		"\2\2\2\31\33\3\2\2\2\32\34\7\4\2\2\33\32\3\2\2\2\34\35\3\2\2\2\35\33\3"+
		"\2\2\2\35\36\3\2\2\2\36\37\3\2\2\2\37 \5\f\7\2 \5\3\2\2\2!+\5\b\5\2\""+
		"$\7\5\2\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'%\3\2\2"+
		"\2(*\5\b\5\2)%\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\61\3\2\2\2-+\3\2"+
		"\2\2.\60\7\5\2\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62"+
		"O\3\2\2\2\63\61\3\2\2\2\64E\5\b\5\2\65\67\7\5\2\2\66\65\3\2\2\2\67:\3"+
		"\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;?\7\6\2\2<>\7\5\2\2="+
		"<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BD\5\b\5\2"+
		"C8\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FK\3\2\2\2GE\3\2\2\2HJ\7\5\2\2"+
		"IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LO\3\2\2\2MK\3\2\2\2N!\3\2\2\2"+
		"N\64\3\2\2\2O\7\3\2\2\2PQ\7\7\2\2QR\5\n\6\2RS\7\7\2\2SV\3\2\2\2TV\5\n"+
		"\6\2UP\3\2\2\2UT\3\2\2\2V\t\3\2\2\2W\\\7\f\2\2XY\7\f\2\2YZ\7\b\2\2Z\\"+
		"\7\f\2\2[W\3\2\2\2[X\3\2\2\2\\\13\3\2\2\2]g\5\16\b\2^`\7\5\2\2_^\3\2\2"+
		"\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ca\3\2\2\2df\5\16\b\2ea\3\2"+
		"\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hm\3\2\2\2ig\3\2\2\2jl\7\5\2\2kj\3\2"+
		"\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\u008b\3\2\2\2om\3\2\2\2p\u0081\5\16"+
		"\b\2qs\7\5\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2"+
		"\2\2w{\7\6\2\2xz\7\5\2\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2"+
		"\2\2}{\3\2\2\2~\u0080\5\16\b\2\177t\3\2\2\2\u0080\u0083\3\2\2\2\u0081"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0087\3\2\2\2\u0083\u0081\3\2\2"+
		"\2\u0084\u0086\7\5\2\2\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u008a"+
		"]\3\2\2\2\u008ap\3\2\2\2\u008b\r\3\2\2\2\u008c\u0091\7\f\2\2\u008d\u008e"+
		"\7\t\2\2\u008e\u0090\7\f\2\2\u008f\u008d\3\2\2\2\u0090\u0093\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\17\3\2\2\2\u0093\u0091\3\2\2"+
		"\2\30\23\30\35%+\618?EKNU[agmt{\u0081\u0087\u008a\u0091";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}