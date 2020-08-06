// Generated from C:/Users/Tobias/IdeaProjects/FAXE-Feature_Annotation_eXtraction_Engine\codeAnnotation.g4 by ANTLR 4.8
package se.gu.faxe.Grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class codeAnnotationParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, SPACE=13, FEATURENAME=14, OTHER=15;
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
			null, "'&begin'", "' '", "'&end'", "'&line'", "'('", "')'", "','", "'['", 
			"']'", "'{'", "'}'", "'::'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "SPACE", "FEATURENAME", "OTHER"
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__0);
			setState(30);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(27);
					match(T__1);
					}
					} 
				}
				setState(32);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__2);
			setState(39);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(36);
					match(T__1);
					}
					} 
				}
				setState(41);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__3);
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(45);
					match(T__1);
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
			setState(319);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				match(T__4);
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(54);
					match(T__1);
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(60);
				lpq();
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(62); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(61);
							match(T__1);
							}
							}
							setState(64); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==T__1 );
						setState(66);
						lpq();
						}
						} 
					}
					setState(71);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(72);
					match(T__1);
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(78);
				match(T__5);
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(79);
						matchWildcard();
						}
						} 
					}
					setState(84);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(T__4);
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(86);
					match(T__1);
					}
					}
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(92);
				lpq();
				setState(109);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(96);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__1) {
							{
							{
							setState(93);
							match(T__1);
							}
							}
							setState(98);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(99);
						match(T__6);
						setState(103);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__1) {
							{
							{
							setState(100);
							match(T__1);
							}
							}
							setState(105);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(106);
						lpq();
						}
						} 
					}
					setState(111);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(112);
					match(T__1);
					}
					}
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(118);
				match(T__5);
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(119);
						matchWildcard();
						}
						} 
					}
					setState(124);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				match(T__7);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(126);
					match(T__1);
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(132);
				lpq();
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(134); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(133);
							match(T__1);
							}
							}
							setState(136); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==T__1 );
						setState(138);
						lpq();
						}
						} 
					}
					setState(143);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(144);
					match(T__1);
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(150);
				match(T__8);
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(151);
						matchWildcard();
						}
						} 
					}
					setState(156);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				match(T__7);
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(158);
					match(T__1);
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(164);
				lpq();
				setState(181);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(168);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__1) {
							{
							{
							setState(165);
							match(T__1);
							}
							}
							setState(170);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(171);
						match(T__6);
						setState(175);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__1) {
							{
							{
							setState(172);
							match(T__1);
							}
							}
							setState(177);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(178);
						lpq();
						}
						} 
					}
					setState(183);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(184);
					match(T__1);
					}
					}
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(190);
				match(T__8);
				setState(194);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(191);
						matchWildcard();
						}
						} 
					}
					setState(196);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(197);
				match(T__9);
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(198);
					match(T__1);
					}
					}
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(204);
				lpq();
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(206); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(205);
							match(T__1);
							}
							}
							setState(208); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==T__1 );
						setState(210);
						lpq();
						}
						} 
					}
					setState(215);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(216);
					match(T__1);
					}
					}
					setState(221);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(222);
				match(T__10);
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(223);
						matchWildcard();
						}
						} 
					}
					setState(228);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(229);
				match(T__9);
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(230);
					match(T__1);
					}
					}
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(236);
				lpq();
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(240);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__1) {
							{
							{
							setState(237);
							match(T__1);
							}
							}
							setState(242);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(243);
						match(T__6);
						setState(247);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__1) {
							{
							{
							setState(244);
							match(T__1);
							}
							}
							setState(249);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(250);
						lpq();
						}
						} 
					}
					setState(255);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				}
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(256);
					match(T__1);
					}
					}
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(262);
				match(T__10);
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(263);
						matchWildcard();
						}
						} 
					}
					setState(268);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(269);
					match(T__1);
					}
					}
					setState(274);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(275);
				lpq();
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(277); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(276);
						match(T__1);
						}
						}
						setState(279); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==T__1 );
					setState(281);
					lpq();
					}
					}
					setState(286);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(287);
					match(T__1);
					}
					}
					setState(292);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(293);
				lpq();
				setState(310);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(297);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__1) {
							{
							{
							setState(294);
							match(T__1);
							}
							}
							setState(299);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(300);
						match(T__6);
						setState(304);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__1) {
							{
							{
							setState(301);
							match(T__1);
							}
							}
							setState(306);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(307);
						lpq();
						}
						} 
					}
					setState(312);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(313);
					match(T__1);
					}
					}
					setState(318);
					_errHandler.sync(this);
					_la = _input.LA(1);
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
		public List<TerminalNode> FEATURENAME() { return getTokens(codeAnnotationParser.FEATURENAME); }
		public TerminalNode FEATURENAME(int i) {
			return getToken(codeAnnotationParser.FEATURENAME, i);
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
			setState(321);
			match(FEATURENAME);
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(322);
				match(T__11);
				setState(323);
				match(FEATURENAME);
				}
				}
				setState(328);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21\u014c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\7\2\20\n\2\f\2\16\2\23\13"+
		"\2\3\2\3\2\3\2\7\2\30\n\2\f\2\16\2\33\13\2\3\3\3\3\7\3\37\n\3\f\3\16\3"+
		"\"\13\3\3\3\3\3\3\4\3\4\7\4(\n\4\f\4\16\4+\13\4\3\4\3\4\3\5\3\5\7\5\61"+
		"\n\5\f\5\16\5\64\13\5\3\5\3\5\3\6\3\6\7\6:\n\6\f\6\16\6=\13\6\3\6\3\6"+
		"\6\6A\n\6\r\6\16\6B\3\6\7\6F\n\6\f\6\16\6I\13\6\3\6\7\6L\n\6\f\6\16\6"+
		"O\13\6\3\6\3\6\7\6S\n\6\f\6\16\6V\13\6\3\6\3\6\7\6Z\n\6\f\6\16\6]\13\6"+
		"\3\6\3\6\7\6a\n\6\f\6\16\6d\13\6\3\6\3\6\7\6h\n\6\f\6\16\6k\13\6\3\6\7"+
		"\6n\n\6\f\6\16\6q\13\6\3\6\7\6t\n\6\f\6\16\6w\13\6\3\6\3\6\7\6{\n\6\f"+
		"\6\16\6~\13\6\3\6\3\6\7\6\u0082\n\6\f\6\16\6\u0085\13\6\3\6\3\6\6\6\u0089"+
		"\n\6\r\6\16\6\u008a\3\6\7\6\u008e\n\6\f\6\16\6\u0091\13\6\3\6\7\6\u0094"+
		"\n\6\f\6\16\6\u0097\13\6\3\6\3\6\7\6\u009b\n\6\f\6\16\6\u009e\13\6\3\6"+
		"\3\6\7\6\u00a2\n\6\f\6\16\6\u00a5\13\6\3\6\3\6\7\6\u00a9\n\6\f\6\16\6"+
		"\u00ac\13\6\3\6\3\6\7\6\u00b0\n\6\f\6\16\6\u00b3\13\6\3\6\7\6\u00b6\n"+
		"\6\f\6\16\6\u00b9\13\6\3\6\7\6\u00bc\n\6\f\6\16\6\u00bf\13\6\3\6\3\6\7"+
		"\6\u00c3\n\6\f\6\16\6\u00c6\13\6\3\6\3\6\7\6\u00ca\n\6\f\6\16\6\u00cd"+
		"\13\6\3\6\3\6\6\6\u00d1\n\6\r\6\16\6\u00d2\3\6\7\6\u00d6\n\6\f\6\16\6"+
		"\u00d9\13\6\3\6\7\6\u00dc\n\6\f\6\16\6\u00df\13\6\3\6\3\6\7\6\u00e3\n"+
		"\6\f\6\16\6\u00e6\13\6\3\6\3\6\7\6\u00ea\n\6\f\6\16\6\u00ed\13\6\3\6\3"+
		"\6\7\6\u00f1\n\6\f\6\16\6\u00f4\13\6\3\6\3\6\7\6\u00f8\n\6\f\6\16\6\u00fb"+
		"\13\6\3\6\7\6\u00fe\n\6\f\6\16\6\u0101\13\6\3\6\7\6\u0104\n\6\f\6\16\6"+
		"\u0107\13\6\3\6\3\6\7\6\u010b\n\6\f\6\16\6\u010e\13\6\3\6\7\6\u0111\n"+
		"\6\f\6\16\6\u0114\13\6\3\6\3\6\6\6\u0118\n\6\r\6\16\6\u0119\3\6\7\6\u011d"+
		"\n\6\f\6\16\6\u0120\13\6\3\6\7\6\u0123\n\6\f\6\16\6\u0126\13\6\3\6\3\6"+
		"\7\6\u012a\n\6\f\6\16\6\u012d\13\6\3\6\3\6\7\6\u0131\n\6\f\6\16\6\u0134"+
		"\13\6\3\6\7\6\u0137\n\6\f\6\16\6\u013a\13\6\3\6\7\6\u013d\n\6\f\6\16\6"+
		"\u0140\13\6\5\6\u0142\n\6\3\7\3\7\3\7\7\7\u0147\n\7\f\7\16\7\u014a\13"+
		"\7\3\7\t\21T|\u009c\u00c4\u00e4\u010c\2\b\2\4\6\b\n\f\2\2\2\u017d\2\21"+
		"\3\2\2\2\4\34\3\2\2\2\6%\3\2\2\2\b.\3\2\2\2\n\u0141\3\2\2\2\f\u0143\3"+
		"\2\2\2\16\20\13\2\2\2\17\16\3\2\2\2\20\23\3\2\2\2\21\22\3\2\2\2\21\17"+
		"\3\2\2\2\22\31\3\2\2\2\23\21\3\2\2\2\24\30\5\4\3\2\25\30\5\6\4\2\26\30"+
		"\5\b\5\2\27\24\3\2\2\2\27\25\3\2\2\2\27\26\3\2\2\2\30\33\3\2\2\2\31\27"+
		"\3\2\2\2\31\32\3\2\2\2\32\3\3\2\2\2\33\31\3\2\2\2\34 \7\3\2\2\35\37\7"+
		"\4\2\2\36\35\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!#\3\2\2\2\" \3"+
		"\2\2\2#$\5\n\6\2$\5\3\2\2\2%)\7\5\2\2&(\7\4\2\2\'&\3\2\2\2(+\3\2\2\2)"+
		"\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,-\5\n\6\2-\7\3\2\2\2.\62\7\6"+
		"\2\2/\61\7\4\2\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2"+
		"\63\65\3\2\2\2\64\62\3\2\2\2\65\66\5\n\6\2\66\t\3\2\2\2\67;\7\7\2\28:"+
		"\7\4\2\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>"+
		"G\5\f\7\2?A\7\4\2\2@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2CD\3\2\2\2"+
		"DF\5\f\7\2E@\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HM\3\2\2\2IG\3\2\2\2"+
		"JL\7\4\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2"+
		"PT\7\b\2\2QS\13\2\2\2RQ\3\2\2\2SV\3\2\2\2TU\3\2\2\2TR\3\2\2\2U\u0142\3"+
		"\2\2\2VT\3\2\2\2W[\7\7\2\2XZ\7\4\2\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\"+
		"\3\2\2\2\\^\3\2\2\2][\3\2\2\2^o\5\f\7\2_a\7\4\2\2`_\3\2\2\2ad\3\2\2\2"+
		"b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2ei\7\t\2\2fh\7\4\2\2gf\3\2\2\2"+
		"hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2ki\3\2\2\2ln\5\f\7\2mb\3\2\2\2"+
		"nq\3\2\2\2om\3\2\2\2op\3\2\2\2pu\3\2\2\2qo\3\2\2\2rt\7\4\2\2sr\3\2\2\2"+
		"tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2x|\7\b\2\2y{\13\2\2"+
		"\2zy\3\2\2\2{~\3\2\2\2|}\3\2\2\2|z\3\2\2\2}\u0142\3\2\2\2~|\3\2\2\2\177"+
		"\u0083\7\n\2\2\u0080\u0082\7\4\2\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2"+
		"\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086\u008f\5\f\7\2\u0087\u0089\7\4\2\2\u0088\u0087\3\2"+
		"\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008e\5\f\7\2\u008d\u0088\3\2\2\2\u008e\u0091\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0095\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0094\7\4\2\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0098\u009c\7\13\2\2\u0099\u009b\13\2\2\2\u009a\u0099\3"+
		"\2\2\2\u009b\u009e\3\2\2\2\u009c\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d"+
		"\u0142\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a3\7\n\2\2\u00a0\u00a2\7\4"+
		"\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00b7\5\f"+
		"\7\2\u00a7\u00a9\7\4\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ad\u00b1\7\t\2\2\u00ae\u00b0\7\4\2\2\u00af\u00ae\3\2\2\2\u00b0"+
		"\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2"+
		"\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b6\5\f\7\2\u00b5\u00aa\3\2\2\2\u00b6"+
		"\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bd\3\2"+
		"\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bc\7\4\2\2\u00bb\u00ba\3\2\2\2\u00bc"+
		"\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2"+
		"\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c4\7\13\2\2\u00c1\u00c3\13\2\2\2\u00c2"+
		"\u00c1\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c4\u00c2\3\2"+
		"\2\2\u00c5\u0142\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00cb\7\f\2\2\u00c8"+
		"\u00ca\7\4\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2"+
		"\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce"+
		"\u00d7\5\f\7\2\u00cf\u00d1\7\4\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d2\3\2"+
		"\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d6\5\f\7\2\u00d5\u00d0\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2"+
		"\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00dd\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da"+
		"\u00dc\7\4\2\2\u00db\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2"+
		"\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0"+
		"\u00e4\7\r\2\2\u00e1\u00e3\13\2\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3"+
		"\2\2\2\u00e4\u00e5\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u0142\3\2\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e7\u00eb\7\f\2\2\u00e8\u00ea\7\4\2\2\u00e9\u00e8\3\2"+
		"\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ff\5\f\7\2\u00ef\u00f1\7\4"+
		"\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f9\7\t"+
		"\2\2\u00f6\u00f8\7\4\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9"+
		"\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f9\3\2"+
		"\2\2\u00fc\u00fe\5\f\7\2\u00fd\u00f2\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0105\3\2\2\2\u0101\u00ff\3\2"+
		"\2\2\u0102\u0104\7\4\2\2\u0103\u0102\3\2\2\2\u0104\u0107\3\2\2\2\u0105"+
		"\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\3\2\2\2\u0107\u0105\3\2"+
		"\2\2\u0108\u010c\7\r\2\2\u0109\u010b\13\2\2\2\u010a\u0109\3\2\2\2\u010b"+
		"\u010e\3\2\2\2\u010c\u010d\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u0142\3\2"+
		"\2\2\u010e\u010c\3\2\2\2\u010f\u0111\7\4\2\2\u0110\u010f\3\2\2\2\u0111"+
		"\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0115\3\2"+
		"\2\2\u0114\u0112\3\2\2\2\u0115\u011e\5\f\7\2\u0116\u0118\7\4\2\2\u0117"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2"+
		"\2\2\u011a\u011b\3\2\2\2\u011b\u011d\5\f\7\2\u011c\u0117\3\2\2\2\u011d"+
		"\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0142\3\2"+
		"\2\2\u0120\u011e\3\2\2\2\u0121\u0123\7\4\2\2\u0122\u0121\3\2\2\2\u0123"+
		"\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2"+
		"\2\2\u0126\u0124\3\2\2\2\u0127\u0138\5\f\7\2\u0128\u012a\7\4\2\2\u0129"+
		"\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2"+
		"\2\2\u012c\u012e\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u0132\7\t\2\2\u012f"+
		"\u0131\7\4\2\2\u0130\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2"+
		"\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135"+
		"\u0137\5\f\7\2\u0136\u012b\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2"+
		"\2\2\u0138\u0139\3\2\2\2\u0139\u013e\3\2\2\2\u013a\u0138\3\2\2\2\u013b"+
		"\u013d\7\4\2\2\u013c\u013b\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2"+
		"\2\2\u013e\u013f\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0141"+
		"\67\3\2\2\2\u0141W\3\2\2\2\u0141\177\3\2\2\2\u0141\u009f\3\2\2\2\u0141"+
		"\u00c7\3\2\2\2\u0141\u00e7\3\2\2\2\u0141\u0112\3\2\2\2\u0141\u0124\3\2"+
		"\2\2\u0142\13\3\2\2\2\u0143\u0148\7\20\2\2\u0144\u0145\7\16\2\2\u0145"+
		"\u0147\7\20\2\2\u0146\u0144\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3"+
		"\2\2\2\u0148\u0149\3\2\2\2\u0149\r\3\2\2\2\u014a\u0148\3\2\2\2\63\21\27"+
		"\31 )\62;BGMT[biou|\u0083\u008a\u008f\u0095\u009c\u00a3\u00aa\u00b1\u00b7"+
		"\u00bd\u00c4\u00cb\u00d2\u00d7\u00dd\u00e4\u00eb\u00f2\u00f9\u00ff\u0105"+
		"\u010c\u0112\u0119\u011e\u0124\u012b\u0132\u0138\u013e\u0141\u0148";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}