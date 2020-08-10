// Generated from C:/Users/Tobias/IdeaProjects/FAXE-Feature_Annotation_eXtraction_Engine\folderAnnotations.g4 by ANTLR 4.8
package se.gu.faxe.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class folderAnnotationsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, SPACE=5, FEATURENAME=6;
	public static final int
		RULE_folderAnnotation = 0, RULE_lpq = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"folderAnnotation", "lpq"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "','", "'\n'", "'::'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "SPACE", "FEATURENAME"
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
		public List<LpqContext> lpq() {
			return getRuleContexts(LpqContext.class);
		}
		public LpqContext lpq(int i) {
			return getRuleContext(LpqContext.class,i);
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
			int _alt;
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(7);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(4);
					match(T__0);
					}
					}
					setState(9);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(10);
				lpq();
				setState(20);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(14);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__0) {
							{
							{
							setState(11);
							match(T__0);
							}
							}
							setState(16);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(17);
						lpq();
						}
						} 
					}
					setState(22);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(23);
					match(T__0);
					}
					}
					setState(28);
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
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(29);
					match(T__0);
					}
					}
					setState(34);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(35);
				lpq();
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(39);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__0) {
							{
							{
							setState(36);
							match(T__0);
							}
							}
							setState(41);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(42);
						match(T__1);
						setState(46);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__0) {
							{
							{
							setState(43);
							match(T__0);
							}
							}
							setState(48);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(49);
						lpq();
						}
						} 
					}
					setState(54);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(55);
					match(T__0);
					}
					}
					setState(60);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(61);
					match(T__0);
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(67);
				lpq();
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(68);
					match(T__2);
					setState(69);
					lpq();
					}
					}
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(75);
					match(T__0);
					}
					}
					setState(80);
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
		public List<TerminalNode> FEATURENAME() { return getTokens(folderAnnotationsParser.FEATURENAME); }
		public TerminalNode FEATURENAME(int i) {
			return getToken(folderAnnotationsParser.FEATURENAME, i);
		}
		public FeatureContext(LpqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof folderAnnotationsListener ) ((folderAnnotationsListener)listener).enterFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof folderAnnotationsListener ) ((folderAnnotationsListener)listener).exitFeature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof folderAnnotationsVisitor ) return ((folderAnnotationsVisitor<? extends T>)visitor).visitFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LpqContext lpq() throws RecognitionException {
		LpqContext _localctx = new LpqContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_lpq);
		int _la;
		try {
			_localctx = new FeatureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(FEATURENAME);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(84);
				match(T__3);
				setState(85);
				match(FEATURENAME);
				}
				}
				setState(90);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b^\4\2\t\2\4\3\t"+
		"\3\3\2\7\2\b\n\2\f\2\16\2\13\13\2\3\2\3\2\7\2\17\n\2\f\2\16\2\22\13\2"+
		"\3\2\7\2\25\n\2\f\2\16\2\30\13\2\3\2\7\2\33\n\2\f\2\16\2\36\13\2\3\2\7"+
		"\2!\n\2\f\2\16\2$\13\2\3\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\7\2/\n"+
		"\2\f\2\16\2\62\13\2\3\2\7\2\65\n\2\f\2\16\28\13\2\3\2\7\2;\n\2\f\2\16"+
		"\2>\13\2\3\2\7\2A\n\2\f\2\16\2D\13\2\3\2\3\2\3\2\7\2I\n\2\f\2\16\2L\13"+
		"\2\3\2\7\2O\n\2\f\2\16\2R\13\2\5\2T\n\2\3\3\3\3\3\3\7\3Y\n\3\f\3\16\3"+
		"\\\13\3\3\3\2\2\4\2\4\2\2\2j\2S\3\2\2\2\4U\3\2\2\2\6\b\7\3\2\2\7\6\3\2"+
		"\2\2\b\13\3\2\2\2\t\7\3\2\2\2\t\n\3\2\2\2\n\f\3\2\2\2\13\t\3\2\2\2\f\26"+
		"\5\4\3\2\r\17\7\3\2\2\16\r\3\2\2\2\17\22\3\2\2\2\20\16\3\2\2\2\20\21\3"+
		"\2\2\2\21\23\3\2\2\2\22\20\3\2\2\2\23\25\5\4\3\2\24\20\3\2\2\2\25\30\3"+
		"\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\34\3\2\2\2\30\26\3\2\2\2\31\33\7"+
		"\3\2\2\32\31\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35T\3\2"+
		"\2\2\36\34\3\2\2\2\37!\7\3\2\2 \37\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2"+
		"\2\2#%\3\2\2\2$\"\3\2\2\2%\66\5\4\3\2&(\7\3\2\2\'&\3\2\2\2(+\3\2\2\2)"+
		"\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,\60\7\4\2\2-/\7\3\2\2.-\3\2\2"+
		"\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62\60\3\2\2\2\63"+
		"\65\5\4\3\2\64)\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67<\3"+
		"\2\2\28\66\3\2\2\29;\7\3\2\2:9\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2="+
		"T\3\2\2\2><\3\2\2\2?A\7\3\2\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2"+
		"CE\3\2\2\2DB\3\2\2\2EJ\5\4\3\2FG\7\5\2\2GI\5\4\3\2HF\3\2\2\2IL\3\2\2\2"+
		"JH\3\2\2\2JK\3\2\2\2KP\3\2\2\2LJ\3\2\2\2MO\7\3\2\2NM\3\2\2\2OR\3\2\2\2"+
		"PN\3\2\2\2PQ\3\2\2\2QT\3\2\2\2RP\3\2\2\2S\t\3\2\2\2S\"\3\2\2\2SB\3\2\2"+
		"\2T\3\3\2\2\2UZ\7\b\2\2VW\7\6\2\2WY\7\b\2\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2"+
		"\2\2Z[\3\2\2\2[\5\3\2\2\2\\Z\3\2\2\2\20\t\20\26\34\")\60\66<BJPSZ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}