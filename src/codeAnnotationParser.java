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
		T__9=10, T__10=11, ANNOSEPARATOR=12, STRING=13;
	public static final int
		RULE_marker = 0, RULE_beginmarker = 1, RULE_endmarker = 2, RULE_linemarker = 3, 
		RULE_parameter = 4, RULE_comment = 5, RULE_lpq = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"marker", "beginmarker", "endmarker", "linemarker", "parameter", "comment", 
			"lpq"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "'&begin'", "'&end'", "'&line'", "'('", "')'", "'['", "']'", 
			"'{'", "'}'", "'::'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"ANNOSEPARATOR", "STRING"
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
		public BeginmarkerContext beginmarker() {
			return getRuleContext(BeginmarkerContext.class,0);
		}
		public EndmarkerContext endmarker() {
			return getRuleContext(EndmarkerContext.class,0);
		}
		public LinemarkerContext linemarker() {
			return getRuleContext(LinemarkerContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(14);
				match(T__0);
				}
				}
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRING) {
				{
				{
				setState(20);
				comment();
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(26);
				beginmarker();
				}
				break;
			case T__2:
				{
				setState(27);
				endmarker();
				}
				break;
			case T__3:
				{
				setState(28);
				linemarker();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
			setState(31);
			match(T__1);
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(32);
				match(T__0);
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
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
			setState(40);
			match(T__2);
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(41);
				match(T__0);
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47);
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
			setState(49);
			match(T__3);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(50);
				match(T__0);
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
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
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
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
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(T__4);
				setState(59);
				lpq();
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ANNOSEPARATOR || _la==STRING) {
					{
					{
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ANNOSEPARATOR) {
						{
						setState(60);
						match(ANNOSEPARATOR);
						}
					}

					setState(63);
					lpq();
					}
					}
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(69);
					match(T__0);
					}
					}
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(75);
				match(T__5);
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(76);
					match(T__0);
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==STRING) {
					{
					{
					setState(82);
					comment();
					}
					}
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(T__6);
				setState(89);
				lpq();
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ANNOSEPARATOR || _la==STRING) {
					{
					{
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ANNOSEPARATOR) {
						{
						setState(90);
						match(ANNOSEPARATOR);
						}
					}

					setState(93);
					lpq();
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(99);
					match(T__0);
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(105);
				match(T__7);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(106);
					match(T__0);
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==STRING) {
					{
					{
					setState(112);
					comment();
					}
					}
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				match(T__8);
				setState(119);
				lpq();
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ANNOSEPARATOR || _la==STRING) {
					{
					{
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ANNOSEPARATOR) {
						{
						setState(120);
						match(ANNOSEPARATOR);
						}
					}

					setState(123);
					lpq();
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(129);
					match(T__0);
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(135);
				match(T__9);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(136);
					match(T__0);
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==STRING) {
					{
					{
					setState(142);
					comment();
					}
					}
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(148);
				lpq();
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ANNOSEPARATOR || _la==STRING) {
					{
					{
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ANNOSEPARATOR) {
						{
						setState(149);
						match(ANNOSEPARATOR);
						}
					}

					setState(152);
					lpq();
					}
					}
					setState(157);
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

	public static class CommentContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(codeAnnotationParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(codeAnnotationParser.STRING, i);
		}
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeAnnotationListener ) ((codeAnnotationListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeAnnotationListener ) ((codeAnnotationListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof codeAnnotationVisitor ) return ((codeAnnotationVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_comment);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(STRING);
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(162); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(161);
						match(T__0);
						}
						}
						setState(164); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==T__0 );
					setState(166);
					match(STRING);
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(172);
				match(T__0);
				}
				}
				setState(177);
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
		enterRule(_localctx, 12, RULE_lpq);
		int _la;
		try {
			_localctx = new FeatureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(STRING);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(179);
				match(T__10);
				setState(180);
				match(STRING);
				}
				}
				setState(185);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\17\u00bd\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\7\2\22\n\2\f\2\16"+
		"\2\25\13\2\3\2\7\2\30\n\2\f\2\16\2\33\13\2\3\2\3\2\3\2\5\2 \n\2\3\3\3"+
		"\3\7\3$\n\3\f\3\16\3\'\13\3\3\3\3\3\3\4\3\4\7\4-\n\4\f\4\16\4\60\13\4"+
		"\3\4\3\4\3\5\3\5\7\5\66\n\5\f\5\16\59\13\5\3\5\3\5\3\6\3\6\3\6\5\6@\n"+
		"\6\3\6\7\6C\n\6\f\6\16\6F\13\6\3\6\7\6I\n\6\f\6\16\6L\13\6\3\6\3\6\7\6"+
		"P\n\6\f\6\16\6S\13\6\3\6\7\6V\n\6\f\6\16\6Y\13\6\3\6\3\6\3\6\5\6^\n\6"+
		"\3\6\7\6a\n\6\f\6\16\6d\13\6\3\6\7\6g\n\6\f\6\16\6j\13\6\3\6\3\6\7\6n"+
		"\n\6\f\6\16\6q\13\6\3\6\7\6t\n\6\f\6\16\6w\13\6\3\6\3\6\3\6\5\6|\n\6\3"+
		"\6\7\6\177\n\6\f\6\16\6\u0082\13\6\3\6\7\6\u0085\n\6\f\6\16\6\u0088\13"+
		"\6\3\6\3\6\7\6\u008c\n\6\f\6\16\6\u008f\13\6\3\6\7\6\u0092\n\6\f\6\16"+
		"\6\u0095\13\6\3\6\3\6\5\6\u0099\n\6\3\6\7\6\u009c\n\6\f\6\16\6\u009f\13"+
		"\6\5\6\u00a1\n\6\3\7\3\7\6\7\u00a5\n\7\r\7\16\7\u00a6\3\7\7\7\u00aa\n"+
		"\7\f\7\16\7\u00ad\13\7\3\7\7\7\u00b0\n\7\f\7\16\7\u00b3\13\7\3\b\3\b\3"+
		"\b\7\b\u00b8\n\b\f\b\16\b\u00bb\13\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2\u00d4"+
		"\2\23\3\2\2\2\4!\3\2\2\2\6*\3\2\2\2\b\63\3\2\2\2\n\u00a0\3\2\2\2\f\u00a2"+
		"\3\2\2\2\16\u00b4\3\2\2\2\20\22\7\3\2\2\21\20\3\2\2\2\22\25\3\2\2\2\23"+
		"\21\3\2\2\2\23\24\3\2\2\2\24\31\3\2\2\2\25\23\3\2\2\2\26\30\5\f\7\2\27"+
		"\26\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\37\3\2\2\2\33"+
		"\31\3\2\2\2\34 \5\4\3\2\35 \5\6\4\2\36 \5\b\5\2\37\34\3\2\2\2\37\35\3"+
		"\2\2\2\37\36\3\2\2\2 \3\3\2\2\2!%\7\4\2\2\"$\7\3\2\2#\"\3\2\2\2$\'\3\2"+
		"\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'%\3\2\2\2()\5\n\6\2)\5\3\2\2\2*.\7"+
		"\5\2\2+-\7\3\2\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2"+
		"\60.\3\2\2\2\61\62\5\n\6\2\62\7\3\2\2\2\63\67\7\6\2\2\64\66\7\3\2\2\65"+
		"\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28:\3\2\2\29\67\3\2\2"+
		"\2:;\5\n\6\2;\t\3\2\2\2<=\7\7\2\2=D\5\16\b\2>@\7\16\2\2?>\3\2\2\2?@\3"+
		"\2\2\2@A\3\2\2\2AC\5\16\b\2B?\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EJ"+
		"\3\2\2\2FD\3\2\2\2GI\7\3\2\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K"+
		"M\3\2\2\2LJ\3\2\2\2MQ\7\b\2\2NP\7\3\2\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2"+
		"QR\3\2\2\2RW\3\2\2\2SQ\3\2\2\2TV\5\f\7\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2"+
		"WX\3\2\2\2X\u00a1\3\2\2\2YW\3\2\2\2Z[\7\t\2\2[b\5\16\b\2\\^\7\16\2\2]"+
		"\\\3\2\2\2]^\3\2\2\2^_\3\2\2\2_a\5\16\b\2`]\3\2\2\2ad\3\2\2\2b`\3\2\2"+
		"\2bc\3\2\2\2ch\3\2\2\2db\3\2\2\2eg\7\3\2\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2"+
		"\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2ko\7\n\2\2ln\7\3\2\2ml\3\2\2\2nq\3\2\2"+
		"\2om\3\2\2\2op\3\2\2\2pu\3\2\2\2qo\3\2\2\2rt\5\f\7\2sr\3\2\2\2tw\3\2\2"+
		"\2us\3\2\2\2uv\3\2\2\2v\u00a1\3\2\2\2wu\3\2\2\2xy\7\13\2\2y\u0080\5\16"+
		"\b\2z|\7\16\2\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2}\177\5\16\b\2~{\3\2\2\2"+
		"\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0086\3\2"+
		"\2\2\u0082\u0080\3\2\2\2\u0083\u0085\7\3\2\2\u0084\u0083\3\2\2\2\u0085"+
		"\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2"+
		"\2\2\u0088\u0086\3\2\2\2\u0089\u008d\7\f\2\2\u008a\u008c\7\3\2\2\u008b"+
		"\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u0093\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0092\5\f\7\2\u0091"+
		"\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\u00a1\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u009d\5\16\b\2\u0097"+
		"\u0099\7\16\2\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3"+
		"\2\2\2\u009a\u009c\5\16\b\2\u009b\u0098\3\2\2\2\u009c\u009f\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u00a0<\3\2\2\2\u00a0Z\3\2\2\2\u00a0x\3\2\2\2\u00a0\u0096\3\2\2\2"+
		"\u00a1\13\3\2\2\2\u00a2\u00ab\7\17\2\2\u00a3\u00a5\7\3\2\2\u00a4\u00a3"+
		"\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00aa\7\17\2\2\u00a9\u00a4\3\2\2\2\u00aa\u00ad\3"+
		"\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00b1\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ae\u00b0\7\3\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3\2"+
		"\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\r\3\2\2\2\u00b3\u00b1"+
		"\3\2\2\2\u00b4\u00b9\7\17\2\2\u00b5\u00b6\7\r\2\2\u00b6\u00b8\7\17\2\2"+
		"\u00b7\u00b5\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba"+
		"\3\2\2\2\u00ba\17\3\2\2\2\u00bb\u00b9\3\2\2\2\36\23\31\37%.\67?DJQW]b"+
		"hou{\u0080\u0086\u008d\u0093\u0098\u009d\u00a0\u00a6\u00ab\u00b1\u00b9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}