// Generated from .../FAXE-Feature_Annotation_eXtraction_Engine/src/main/antlr4/se/gu/faxe\fileAnnotations.g4 by ANTLR 4.8
package se.gu.faxe.grammar;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

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
			null, "'\n'", "':'", "' '", "','", "'\"'", "'.'", "'::'"
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
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4 || _la==STRING) {
				{
				{
				{
				setState(14);
				fileAnnotation();
				}
				setState(18);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(15);
					match(T__0);
					}
					}
					setState(20);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(25);
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
			setState(26);
			fileReferences();
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(27);
				match(T__1);
				}
			}

			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				match(T__0);
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(35);
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
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(37);
				fileReference();
				setState(47);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(41);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(38);
							match(T__2);
							}
							}
							setState(43);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(44);
						fileReference();
						}
						} 
					}
					setState(49);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
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
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(56);
				fileReference();
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(60);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(57);
							match(T__2);
							}
							}
							setState(62);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(63);
						match(T__3);
						setState(67);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(64);
							match(T__2);
							}
							}
							setState(69);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(70);
						fileReference();
						}
						} 
					}
					setState(75);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(76);
					match(T__2);
					}
					}
					setState(81);
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
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(84);
				match(T__4);
				setState(85);
				fileName();
				setState(86);
				match(T__4);
				}
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(88);
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
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(92);
				match(STRING);
				setState(93);
				match(T__5);
				setState(94);
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
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(97);
				lpq();
				setState(107);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(101);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(98);
							match(T__2);
							}
							}
							setState(103);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(104);
						lpq();
						}
						} 
					}
					setState(109);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
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
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(116);
				lpq();
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(120);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(117);
							match(T__2);
							}
							}
							setState(122);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(123);
						match(T__3);
						setState(127);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(124);
							match(T__2);
							}
							}
							setState(129);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(130);
						lpq();
						}
						} 
					}
					setState(135);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(136);
					match(T__2);
					}
					}
					setState(141);
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
			setState(144);
			match(STRING);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(145);
				match(T__6);
				setState(146);
				match(STRING);
				}
				}
				setState(151);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\f\u009b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\7\2\23\n\2\f\2"+
		"\16\2\26\13\2\7\2\30\n\2\f\2\16\2\33\13\2\3\3\3\3\5\3\37\n\3\3\3\6\3\""+
		"\n\3\r\3\16\3#\3\3\3\3\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\4\7\4\60\n\4"+
		"\f\4\16\4\63\13\4\3\4\7\4\66\n\4\f\4\16\49\13\4\3\4\3\4\7\4=\n\4\f\4\16"+
		"\4@\13\4\3\4\3\4\7\4D\n\4\f\4\16\4G\13\4\3\4\7\4J\n\4\f\4\16\4M\13\4\3"+
		"\4\7\4P\n\4\f\4\16\4S\13\4\5\4U\n\4\3\5\3\5\3\5\3\5\3\5\5\5\\\n\5\3\6"+
		"\3\6\3\6\3\6\5\6b\n\6\3\7\3\7\7\7f\n\7\f\7\16\7i\13\7\3\7\7\7l\n\7\f\7"+
		"\16\7o\13\7\3\7\7\7r\n\7\f\7\16\7u\13\7\3\7\3\7\7\7y\n\7\f\7\16\7|\13"+
		"\7\3\7\3\7\7\7\u0080\n\7\f\7\16\7\u0083\13\7\3\7\7\7\u0086\n\7\f\7\16"+
		"\7\u0089\13\7\3\7\7\7\u008c\n\7\f\7\16\7\u008f\13\7\5\7\u0091\n\7\3\b"+
		"\3\b\3\b\7\b\u0096\n\b\f\b\16\b\u0099\13\b\3\b\2\2\t\2\4\6\b\n\f\16\2"+
		"\2\2\u00aa\2\31\3\2\2\2\4\34\3\2\2\2\6T\3\2\2\2\b[\3\2\2\2\na\3\2\2\2"+
		"\f\u0090\3\2\2\2\16\u0092\3\2\2\2\20\24\5\4\3\2\21\23\7\3\2\2\22\21\3"+
		"\2\2\2\23\26\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\30\3\2\2\2\26\24\3"+
		"\2\2\2\27\20\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\3\3"+
		"\2\2\2\33\31\3\2\2\2\34\36\5\6\4\2\35\37\7\4\2\2\36\35\3\2\2\2\36\37\3"+
		"\2\2\2\37!\3\2\2\2 \"\7\3\2\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2"+
		"$%\3\2\2\2%&\5\f\7\2&\5\3\2\2\2\'\61\5\b\5\2(*\7\5\2\2)(\3\2\2\2*-\3\2"+
		"\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2.\60\5\b\5\2/+\3\2\2\2\60"+
		"\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\67\3\2\2\2\63\61\3\2\2\2\64\66"+
		"\7\5\2\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28U\3\2\2\2"+
		"9\67\3\2\2\2:K\5\b\5\2;=\7\5\2\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2"+
		"\2?A\3\2\2\2@>\3\2\2\2AE\7\6\2\2BD\7\5\2\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2"+
		"\2EF\3\2\2\2FH\3\2\2\2GE\3\2\2\2HJ\5\b\5\2I>\3\2\2\2JM\3\2\2\2KI\3\2\2"+
		"\2KL\3\2\2\2LQ\3\2\2\2MK\3\2\2\2NP\7\5\2\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2"+
		"\2QR\3\2\2\2RU\3\2\2\2SQ\3\2\2\2T\'\3\2\2\2T:\3\2\2\2U\7\3\2\2\2VW\7\7"+
		"\2\2WX\5\n\6\2XY\7\7\2\2Y\\\3\2\2\2Z\\\5\n\6\2[V\3\2\2\2[Z\3\2\2\2\\\t"+
		"\3\2\2\2]b\7\f\2\2^_\7\f\2\2_`\7\b\2\2`b\7\f\2\2a]\3\2\2\2a^\3\2\2\2b"+
		"\13\3\2\2\2cm\5\16\b\2df\7\5\2\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2"+
		"\2hj\3\2\2\2ig\3\2\2\2jl\5\16\b\2kg\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2"+
		"\2\2ns\3\2\2\2om\3\2\2\2pr\7\5\2\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2"+
		"\2\2t\u0091\3\2\2\2us\3\2\2\2v\u0087\5\16\b\2wy\7\5\2\2xw\3\2\2\2y|\3"+
		"\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}\u0081\7\6\2\2~\u0080\7"+
		"\5\2\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0086\5\16\b\2"+
		"\u0085z\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3"+
		"\2\2\2\u0088\u008d\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008c\7\5\2\2\u008b"+
		"\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u0090c\3\2\2\2\u0090v\3\2"+
		"\2\2\u0091\r\3\2\2\2\u0092\u0097\7\f\2\2\u0093\u0094\7\t\2\2\u0094\u0096"+
		"\7\f\2\2\u0095\u0093\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\17\3\2\2\2\u0099\u0097\3\2\2\2\31\24\31\36#+\61\67"+
		">EKQT[agmsz\u0081\u0087\u008d\u0090\u0097";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}