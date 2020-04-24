// Generated from C:/Users/Tobias/IdeaProjects/ANTLR4_EmbeddedAnnotations\codeAnnotation.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class codeAnnotationParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, ANNOSEPARATOR=12, STRING=13, OTHER=14;
	public static final int
		RULE_marker = 0, RULE_beginmarker = 1, RULE_endmarker = 2, RULE_linemarker = 3, 
		RULE_parameter = 4, RULE_lpq = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"marker", "beginmarker", "endmarker", "linemarker", "parameter", "lpq"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'&begin'", "' '", "'&end'", "'&line'", "'('", "')'", "'['", "']'", 
			"'{'", "'}'", "'::'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"ANNOSEPARATOR", "STRING", "OTHER"
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
	public String getGrammarFileName() { return "codeAnnotation.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public codeAnnotationParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class MarkerContext extends ParserRuleContext {
		public List<BeginmarkerContext> beginmarker() {
			return getRuleContexts(BeginmarkerContext.class);
		}
		public BeginmarkerContext beginmarker(int i) {
			return getRuleContext(BeginmarkerContext.class,i);
		}
		public List<EndmarkerContext> endmarker() {
			return getRuleContexts(EndmarkerContext.class);
		}
		public EndmarkerContext endmarker(int i) {
			return getRuleContext(EndmarkerContext.class,i);
		}
		public List<LinemarkerContext> linemarker() {
			return getRuleContexts(LinemarkerContext.class);
		}
		public LinemarkerContext linemarker(int i) {
			return getRuleContext(LinemarkerContext.class,i);
		}
		public MarkerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_marker; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeAnnotationListener ) ((codeAnnotationListener)listener).enterMarker(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeAnnotationListener ) ((codeAnnotationListener)listener).exitMarker(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof codeAnnotationVisitor ) return ((codeAnnotationVisitor<? extends T>)visitor).visitMarker(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MarkerContext marker() throws RecognitionException {
		MarkerContext _localctx = new MarkerContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_marker);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(12);
					matchWildcard();
					}
					} 
				}
				setState(17);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3))) != 0)) {
				{
				setState(21);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(18);
					beginmarker();
					}
					break;
				case T__2:
					{
					setState(19);
					endmarker();
					}
					break;
				case T__3:
					{
					setState(20);
					linemarker();
					}
					break;
				default:
					throw new NoViableAltException(this);
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

	public static class BeginmarkerContext extends ParserRuleContext {
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public BeginmarkerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beginmarker; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeAnnotationListener ) ((codeAnnotationListener)listener).enterBeginmarker(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeAnnotationListener ) ((codeAnnotationListener)listener).exitBeginmarker(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof codeAnnotationVisitor ) return ((codeAnnotationVisitor<? extends T>)visitor).visitBeginmarker(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeginmarkerContext beginmarker() throws RecognitionException {
		BeginmarkerContext _localctx = new BeginmarkerContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_beginmarker);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__0);
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(27);
				match(T__1);
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(33);
			parameter();
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

	public static class EndmarkerContext extends ParserRuleContext {
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public EndmarkerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endmarker; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeAnnotationListener ) ((codeAnnotationListener)listener).enterEndmarker(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeAnnotationListener ) ((codeAnnotationListener)listener).exitEndmarker(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof codeAnnotationVisitor ) return ((codeAnnotationVisitor<? extends T>)visitor).visitEndmarker(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndmarkerContext endmarker() throws RecognitionException {
		EndmarkerContext _localctx = new EndmarkerContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_endmarker);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__2);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(36);
				match(T__1);
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
			parameter();
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

	public static class LinemarkerContext extends ParserRuleContext {
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public LinemarkerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linemarker; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeAnnotationListener ) ((codeAnnotationListener)listener).enterLinemarker(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeAnnotationListener ) ((codeAnnotationListener)listener).exitLinemarker(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof codeAnnotationVisitor ) return ((codeAnnotationVisitor<? extends T>)visitor).visitLinemarker(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinemarkerContext linemarker() throws RecognitionException {
		LinemarkerContext _localctx = new LinemarkerContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_linemarker);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__3);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(45);
				match(T__1);
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
			parameter();
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

	public static class ParameterContext extends ParserRuleContext {
		public List<LpqContext> lpq() {
			return getRuleContexts(LpqContext.class);
		}
		public LpqContext lpq(int i) {
			return getRuleContext(LpqContext.class,i);
		}
		public List<TerminalNode> ANNOSEPARATOR() { return getTokens(codeAnnotationParser.ANNOSEPARATOR); }
		public TerminalNode ANNOSEPARATOR(int i) {
			return getToken(codeAnnotationParser.ANNOSEPARATOR, i);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeAnnotationListener ) ((codeAnnotationListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeAnnotationListener ) ((codeAnnotationListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof codeAnnotationVisitor ) return ((codeAnnotationVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameter);
		int _la;
		try {
			int _alt;
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				match(T__4);
				setState(54);
				lpq();
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ANNOSEPARATOR) {
					{
					{
					setState(55);
					match(ANNOSEPARATOR);
					setState(56);
					lpq();
					}
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(62);
					match(T__1);
					}
					}
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(68);
				match(T__5);
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(69);
						matchWildcard();
						}
						} 
					}
					setState(74);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(T__6);
				setState(76);
				lpq();
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ANNOSEPARATOR) {
					{
					{
					setState(77);
					match(ANNOSEPARATOR);
					setState(78);
					lpq();
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(84);
					match(T__1);
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(90);
				match(T__7);
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(91);
						matchWildcard();
						}
						} 
					}
					setState(96);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(T__8);
				setState(98);
				lpq();
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ANNOSEPARATOR) {
					{
					{
					setState(99);
					match(ANNOSEPARATOR);
					setState(100);
					lpq();
					}
					}
					setState(105);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(106);
					match(T__1);
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(112);
				match(T__9);
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(113);
						matchWildcard();
						}
						} 
					}
					setState(118);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				lpq();
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ANNOSEPARATOR) {
					{
					{
					setState(120);
					match(ANNOSEPARATOR);
					setState(121);
					lpq();
					}
					}
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
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
		public List<TerminalNode> STRING() { return getTokens(codeAnnotationParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(codeAnnotationParser.STRING, i);
		}
		public FeatureContext(LpqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeAnnotationListener ) ((codeAnnotationListener)listener).enterFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeAnnotationListener ) ((codeAnnotationListener)listener).exitFeature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof codeAnnotationVisitor ) return ((codeAnnotationVisitor<? extends T>)visitor).visitFeature(this);
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
			setState(129);
			match(STRING);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(130);
				match(T__10);
				setState(131);
				match(STRING);
				}
				}
				setState(136);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20\u008c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\7\2\20\n\2\f\2\16\2\23\13"+
		"\2\3\2\3\2\3\2\7\2\30\n\2\f\2\16\2\33\13\2\3\3\3\3\7\3\37\n\3\f\3\16\3"+
		"\"\13\3\3\3\3\3\3\4\3\4\7\4(\n\4\f\4\16\4+\13\4\3\4\3\4\3\5\3\5\7\5\61"+
		"\n\5\f\5\16\5\64\13\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6<\n\6\f\6\16\6?\13\6"+
		"\3\6\7\6B\n\6\f\6\16\6E\13\6\3\6\3\6\7\6I\n\6\f\6\16\6L\13\6\3\6\3\6\3"+
		"\6\3\6\7\6R\n\6\f\6\16\6U\13\6\3\6\7\6X\n\6\f\6\16\6[\13\6\3\6\3\6\7\6"+
		"_\n\6\f\6\16\6b\13\6\3\6\3\6\3\6\3\6\7\6h\n\6\f\6\16\6k\13\6\3\6\7\6n"+
		"\n\6\f\6\16\6q\13\6\3\6\3\6\7\6u\n\6\f\6\16\6x\13\6\3\6\3\6\3\6\7\6}\n"+
		"\6\f\6\16\6\u0080\13\6\5\6\u0082\n\6\3\7\3\7\3\7\7\7\u0087\n\7\f\7\16"+
		"\7\u008a\13\7\3\7\6\21J`v\2\b\2\4\6\b\n\f\2\2\2\u009a\2\21\3\2\2\2\4\34"+
		"\3\2\2\2\6%\3\2\2\2\b.\3\2\2\2\n\u0081\3\2\2\2\f\u0083\3\2\2\2\16\20\13"+
		"\2\2\2\17\16\3\2\2\2\20\23\3\2\2\2\21\22\3\2\2\2\21\17\3\2\2\2\22\31\3"+
		"\2\2\2\23\21\3\2\2\2\24\30\5\4\3\2\25\30\5\6\4\2\26\30\5\b\5\2\27\24\3"+
		"\2\2\2\27\25\3\2\2\2\27\26\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3"+
		"\2\2\2\32\3\3\2\2\2\33\31\3\2\2\2\34 \7\3\2\2\35\37\7\4\2\2\36\35\3\2"+
		"\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!#\3\2\2\2\" \3\2\2\2#$\5\n\6\2"+
		"$\5\3\2\2\2%)\7\5\2\2&(\7\4\2\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2"+
		"\2\2*,\3\2\2\2+)\3\2\2\2,-\5\n\6\2-\7\3\2\2\2.\62\7\6\2\2/\61\7\4\2\2"+
		"\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64"+
		"\62\3\2\2\2\65\66\5\n\6\2\66\t\3\2\2\2\678\7\7\2\28=\5\f\7\29:\7\16\2"+
		"\2:<\5\f\7\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>C\3\2\2\2?=\3\2\2"+
		"\2@B\7\4\2\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2"+
		"\2FJ\7\b\2\2GI\13\2\2\2HG\3\2\2\2IL\3\2\2\2JK\3\2\2\2JH\3\2\2\2K\u0082"+
		"\3\2\2\2LJ\3\2\2\2MN\7\t\2\2NS\5\f\7\2OP\7\16\2\2PR\5\f\7\2QO\3\2\2\2"+
		"RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TY\3\2\2\2US\3\2\2\2VX\7\4\2\2WV\3\2\2\2"+
		"X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[Y\3\2\2\2\\`\7\n\2\2]_\13\2"+
		"\2\2^]\3\2\2\2_b\3\2\2\2`a\3\2\2\2`^\3\2\2\2a\u0082\3\2\2\2b`\3\2\2\2"+
		"cd\7\13\2\2di\5\f\7\2ef\7\16\2\2fh\5\f\7\2ge\3\2\2\2hk\3\2\2\2ig\3\2\2"+
		"\2ij\3\2\2\2jo\3\2\2\2ki\3\2\2\2ln\7\4\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2"+
		"\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rv\7\f\2\2su\13\2\2\2ts\3\2\2\2ux\3\2"+
		"\2\2vw\3\2\2\2vt\3\2\2\2w\u0082\3\2\2\2xv\3\2\2\2y~\5\f\7\2z{\7\16\2\2"+
		"{}\5\f\7\2|z\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0082\3"+
		"\2\2\2\u0080~\3\2\2\2\u0081\67\3\2\2\2\u0081M\3\2\2\2\u0081c\3\2\2\2\u0081"+
		"y\3\2\2\2\u0082\13\3\2\2\2\u0083\u0088\7\17\2\2\u0084\u0085\7\r\2\2\u0085"+
		"\u0087\7\17\2\2\u0086\u0084\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3"+
		"\2\2\2\u0088\u0089\3\2\2\2\u0089\r\3\2\2\2\u008a\u0088\3\2\2\2\24\21\27"+
		"\31 )\62=CJSY`iov~\u0081\u0088";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}