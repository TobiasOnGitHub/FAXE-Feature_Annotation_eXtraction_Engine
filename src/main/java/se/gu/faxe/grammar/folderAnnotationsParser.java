// Generated from C:/Users/Tobias/IdeaProjects/FAXE-Feature_Annotation_eXtraction_Engine/src/main/antlr4/se/gu/faxe\folderAnnotations.g4 by ANTLR 4.8
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
		public TerminalNode EOF() { return getToken(folderAnnotationsParser.EOF, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
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
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(23);
						match(T__0);
						}
						} 
					}
					setState(28);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				}
				setState(32);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(29);
						matchWildcard();
						}
						} 
					}
					setState(34);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				}
				break;
			case 2:
				{
				{
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(35);
					match(T__0);
					}
					}
					setState(40);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(41);
				lpq();
				setState(58);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(45);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__0) {
							{
							{
							setState(42);
							match(T__0);
							}
							}
							setState(47);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(48);
						match(T__1);
						setState(52);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__0) {
							{
							{
							setState(49);
							match(T__0);
							}
							}
							setState(54);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(55);
						lpq();
						}
						} 
					}
					setState(60);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(61);
						match(T__0);
						}
						} 
					}
					setState(66);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				}
				setState(70);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(67);
						matchWildcard();
						}
						} 
					}
					setState(72);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				}
				break;
			case 3:
				{
				{
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(73);
					match(T__0);
					}
					}
					setState(78);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(79);
				lpq();
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(80);
						match(T__2);
						setState(81);
						lpq();
						}
						} 
					}
					setState(86);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(87);
						match(T__0);
						}
						} 
					}
					setState(92);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(93);
						matchWildcard();
						}
						} 
					}
					setState(98);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				}
				break;
			case 4:
				{
				setState(99);
				match(T__2);
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(100);
						matchWildcard();
						}
						} 
					}
					setState(105);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				}
				break;
			}
			setState(108);
			match(EOF);
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
		try {
			int _alt;
			_localctx = new FeatureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(FEATURENAME);
			setState(115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(111);
					match(T__3);
					setState(112);
					match(FEATURENAME);
					}
					} 
				}
				setState(117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\by\4\2\t\2\4\3\t"+
		"\3\3\2\7\2\b\n\2\f\2\16\2\13\13\2\3\2\3\2\7\2\17\n\2\f\2\16\2\22\13\2"+
		"\3\2\7\2\25\n\2\f\2\16\2\30\13\2\3\2\7\2\33\n\2\f\2\16\2\36\13\2\3\2\7"+
		"\2!\n\2\f\2\16\2$\13\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\7\2.\n\2\f"+
		"\2\16\2\61\13\2\3\2\3\2\7\2\65\n\2\f\2\16\28\13\2\3\2\7\2;\n\2\f\2\16"+
		"\2>\13\2\3\2\7\2A\n\2\f\2\16\2D\13\2\3\2\7\2G\n\2\f\2\16\2J\13\2\3\2\7"+
		"\2M\n\2\f\2\16\2P\13\2\3\2\3\2\3\2\7\2U\n\2\f\2\16\2X\13\2\3\2\7\2[\n"+
		"\2\f\2\16\2^\13\2\3\2\7\2a\n\2\f\2\16\2d\13\2\3\2\3\2\7\2h\n\2\f\2\16"+
		"\2k\13\2\5\2m\n\2\3\2\3\2\3\3\3\3\3\3\7\3t\n\3\f\3\16\3w\13\3\3\3\6\""+
		"Hbi\2\4\2\4\2\2\2\u008a\2l\3\2\2\2\4p\3\2\2\2\6\b\7\3\2\2\7\6\3\2\2\2"+
		"\b\13\3\2\2\2\t\7\3\2\2\2\t\n\3\2\2\2\n\f\3\2\2\2\13\t\3\2\2\2\f\26\5"+
		"\4\3\2\r\17\7\3\2\2\16\r\3\2\2\2\17\22\3\2\2\2\20\16\3\2\2\2\20\21\3\2"+
		"\2\2\21\23\3\2\2\2\22\20\3\2\2\2\23\25\5\4\3\2\24\20\3\2\2\2\25\30\3\2"+
		"\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\34\3\2\2\2\30\26\3\2\2\2\31\33\7\3"+
		"\2\2\32\31\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\"\3\2"+
		"\2\2\36\34\3\2\2\2\37!\13\2\2\2 \37\3\2\2\2!$\3\2\2\2\"#\3\2\2\2\" \3"+
		"\2\2\2#m\3\2\2\2$\"\3\2\2\2%\'\7\3\2\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2"+
		"()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+<\5\4\3\2,.\7\3\2\2-,\3\2\2\2.\61\3\2\2"+
		"\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\66\7\4\2\2\63\65"+
		"\7\3\2\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2"+
		"\2\28\66\3\2\2\29;\5\4\3\2:/\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=B\3"+
		"\2\2\2><\3\2\2\2?A\7\3\2\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CH\3"+
		"\2\2\2DB\3\2\2\2EG\13\2\2\2FE\3\2\2\2GJ\3\2\2\2HI\3\2\2\2HF\3\2\2\2Im"+
		"\3\2\2\2JH\3\2\2\2KM\7\3\2\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2O"+
		"Q\3\2\2\2PN\3\2\2\2QV\5\4\3\2RS\7\5\2\2SU\5\4\3\2TR\3\2\2\2UX\3\2\2\2"+
		"VT\3\2\2\2VW\3\2\2\2W\\\3\2\2\2XV\3\2\2\2Y[\7\3\2\2ZY\3\2\2\2[^\3\2\2"+
		"\2\\Z\3\2\2\2\\]\3\2\2\2]b\3\2\2\2^\\\3\2\2\2_a\13\2\2\2`_\3\2\2\2ad\3"+
		"\2\2\2bc\3\2\2\2b`\3\2\2\2cm\3\2\2\2db\3\2\2\2ei\7\5\2\2fh\13\2\2\2gf"+
		"\3\2\2\2hk\3\2\2\2ij\3\2\2\2ig\3\2\2\2jm\3\2\2\2ki\3\2\2\2l\t\3\2\2\2"+
		"l(\3\2\2\2lN\3\2\2\2le\3\2\2\2mn\3\2\2\2no\7\2\2\3o\3\3\2\2\2pu\7\b\2"+
		"\2qr\7\6\2\2rt\7\b\2\2sq\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v\5\3\2"+
		"\2\2wu\3\2\2\2\24\t\20\26\34\"(/\66<BHNV\\bilu";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}