// Generated from C:/Users/Tobias/IdeaProjects/FAXE-Feature_Annotation_eXtraction_Engine\featureHierarchy.g4 by ANTLR 4.8
package se.gu.faxe.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class featureHierarchyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, SPACE=9, 
		KEYWORDS=10, FEATURENAME=11;
	public static final int
		RULE_projectHierarchy = 0, RULE_subfeature = 1, RULE_subsubfeature = 2, 
		RULE_subsubsubfeature = 3, RULE_subsubsubsubfeature = 4, RULE_subsubsubsubsubfeature = 5, 
		RULE_subsubsubsubsubsubfeature = 6, RULE_subsubsubsubsubsubsubfeature = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"projectHierarchy", "subfeature", "subsubfeature", "subsubsubfeature", 
			"subsubsubsubfeature", "subsubsubsubsubfeature", "subsubsubsubsubsubfeature", 
			"subsubsubsubsubsubsubfeature"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\n'", "'\t'", "'\t\t'", "'\t\t\t'", "'\t\t\t\t'", "'\t\t\t\t\t'", 
			"'\t\t\t\t\t\t'", "'\t\t\t\t\t\t\t'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "SPACE", "KEYWORDS", 
			"FEATURENAME"
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
	public String getGrammarFileName() { return "featureHierarchy.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public featureHierarchyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProjectHierarchyContext extends ParserRuleContext {
		public TerminalNode FEATURENAME() { return getToken(featureHierarchyParser.FEATURENAME, 0); }
		public List<SubfeatureContext> subfeature() {
			return getRuleContexts(SubfeatureContext.class);
		}
		public SubfeatureContext subfeature(int i) {
			return getRuleContext(SubfeatureContext.class,i);
		}
		public ProjectHierarchyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projectHierarchy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof featureHierarchyListener ) ((featureHierarchyListener)listener).enterProjectHierarchy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof featureHierarchyListener ) ((featureHierarchyListener)listener).exitProjectHierarchy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof featureHierarchyVisitor ) return ((featureHierarchyVisitor<? extends T>)visitor).visitProjectHierarchy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectHierarchyContext projectHierarchy() throws RecognitionException {
		ProjectHierarchyContext _localctx = new ProjectHierarchyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_projectHierarchy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(FEATURENAME);
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(17);
				subfeature();
				}
				}
				setState(22);
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

	public static class SubfeatureContext extends ParserRuleContext {
		public SubfeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subfeature; }
	 
		public SubfeatureContext() { }
		public void copyFrom(SubfeatureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubLevel1Context extends SubfeatureContext {
		public TerminalNode FEATURENAME() { return getToken(featureHierarchyParser.FEATURENAME, 0); }
		public List<SubsubfeatureContext> subsubfeature() {
			return getRuleContexts(SubsubfeatureContext.class);
		}
		public SubsubfeatureContext subsubfeature(int i) {
			return getRuleContext(SubsubfeatureContext.class,i);
		}
		public SubLevel1Context(SubfeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof featureHierarchyListener ) ((featureHierarchyListener)listener).enterSubLevel1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof featureHierarchyListener ) ((featureHierarchyListener)listener).exitSubLevel1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof featureHierarchyVisitor ) return ((featureHierarchyVisitor<? extends T>)visitor).visitSubLevel1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubfeatureContext subfeature() throws RecognitionException {
		SubfeatureContext _localctx = new SubfeatureContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_subfeature);
		try {
			int _alt;
			_localctx = new SubLevel1Context(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(23);
			match(T__0);
			setState(24);
			match(T__1);
			setState(25);
			match(FEATURENAME);
			}
			setState(30);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(27);
					subsubfeature();
					}
					} 
				}
				setState(32);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class SubsubfeatureContext extends ParserRuleContext {
		public SubsubfeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subsubfeature; }
	 
		public SubsubfeatureContext() { }
		public void copyFrom(SubsubfeatureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubLevel2Context extends SubsubfeatureContext {
		public TerminalNode FEATURENAME() { return getToken(featureHierarchyParser.FEATURENAME, 0); }
		public List<SubsubsubfeatureContext> subsubsubfeature() {
			return getRuleContexts(SubsubsubfeatureContext.class);
		}
		public SubsubsubfeatureContext subsubsubfeature(int i) {
			return getRuleContext(SubsubsubfeatureContext.class,i);
		}
		public SubLevel2Context(SubsubfeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof featureHierarchyListener ) ((featureHierarchyListener)listener).enterSubLevel2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof featureHierarchyListener ) ((featureHierarchyListener)listener).exitSubLevel2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof featureHierarchyVisitor ) return ((featureHierarchyVisitor<? extends T>)visitor).visitSubLevel2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubsubfeatureContext subsubfeature() throws RecognitionException {
		SubsubfeatureContext _localctx = new SubsubfeatureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_subsubfeature);
		try {
			int _alt;
			_localctx = new SubLevel2Context(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(33);
			match(T__0);
			setState(34);
			match(T__2);
			setState(35);
			match(FEATURENAME);
			}
			setState(40);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(37);
					subsubsubfeature();
					}
					} 
				}
				setState(42);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class SubsubsubfeatureContext extends ParserRuleContext {
		public SubsubsubfeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subsubsubfeature; }
	 
		public SubsubsubfeatureContext() { }
		public void copyFrom(SubsubsubfeatureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubLevel3Context extends SubsubsubfeatureContext {
		public TerminalNode FEATURENAME() { return getToken(featureHierarchyParser.FEATURENAME, 0); }
		public List<SubsubsubsubfeatureContext> subsubsubsubfeature() {
			return getRuleContexts(SubsubsubsubfeatureContext.class);
		}
		public SubsubsubsubfeatureContext subsubsubsubfeature(int i) {
			return getRuleContext(SubsubsubsubfeatureContext.class,i);
		}
		public SubLevel3Context(SubsubsubfeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof featureHierarchyListener ) ((featureHierarchyListener)listener).enterSubLevel3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof featureHierarchyListener ) ((featureHierarchyListener)listener).exitSubLevel3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof featureHierarchyVisitor ) return ((featureHierarchyVisitor<? extends T>)visitor).visitSubLevel3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubsubsubfeatureContext subsubsubfeature() throws RecognitionException {
		SubsubsubfeatureContext _localctx = new SubsubsubfeatureContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_subsubsubfeature);
		try {
			int _alt;
			_localctx = new SubLevel3Context(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(43);
			match(T__0);
			setState(44);
			match(T__3);
			setState(45);
			match(FEATURENAME);
			}
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(47);
					subsubsubsubfeature();
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class SubsubsubsubfeatureContext extends ParserRuleContext {
		public SubsubsubsubfeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subsubsubsubfeature; }
	 
		public SubsubsubsubfeatureContext() { }
		public void copyFrom(SubsubsubsubfeatureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubLevel4Context extends SubsubsubsubfeatureContext {
		public TerminalNode FEATURENAME() { return getToken(featureHierarchyParser.FEATURENAME, 0); }
		public List<SubsubsubsubsubfeatureContext> subsubsubsubsubfeature() {
			return getRuleContexts(SubsubsubsubsubfeatureContext.class);
		}
		public SubsubsubsubsubfeatureContext subsubsubsubsubfeature(int i) {
			return getRuleContext(SubsubsubsubsubfeatureContext.class,i);
		}
		public SubLevel4Context(SubsubsubsubfeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof featureHierarchyListener ) ((featureHierarchyListener)listener).enterSubLevel4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof featureHierarchyListener ) ((featureHierarchyListener)listener).exitSubLevel4(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof featureHierarchyVisitor ) return ((featureHierarchyVisitor<? extends T>)visitor).visitSubLevel4(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubsubsubsubfeatureContext subsubsubsubfeature() throws RecognitionException {
		SubsubsubsubfeatureContext _localctx = new SubsubsubsubfeatureContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_subsubsubsubfeature);
		try {
			int _alt;
			_localctx = new SubLevel4Context(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(53);
			match(T__0);
			setState(54);
			match(T__4);
			setState(55);
			match(FEATURENAME);
			}
			setState(60);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(57);
					subsubsubsubsubfeature();
					}
					} 
				}
				setState(62);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class SubsubsubsubsubfeatureContext extends ParserRuleContext {
		public SubsubsubsubsubfeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subsubsubsubsubfeature; }
	 
		public SubsubsubsubsubfeatureContext() { }
		public void copyFrom(SubsubsubsubsubfeatureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubLevel5Context extends SubsubsubsubsubfeatureContext {
		public TerminalNode FEATURENAME() { return getToken(featureHierarchyParser.FEATURENAME, 0); }
		public List<SubsubsubsubsubsubfeatureContext> subsubsubsubsubsubfeature() {
			return getRuleContexts(SubsubsubsubsubsubfeatureContext.class);
		}
		public SubsubsubsubsubsubfeatureContext subsubsubsubsubsubfeature(int i) {
			return getRuleContext(SubsubsubsubsubsubfeatureContext.class,i);
		}
		public SubLevel5Context(SubsubsubsubsubfeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof featureHierarchyListener ) ((featureHierarchyListener)listener).enterSubLevel5(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof featureHierarchyListener ) ((featureHierarchyListener)listener).exitSubLevel5(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof featureHierarchyVisitor ) return ((featureHierarchyVisitor<? extends T>)visitor).visitSubLevel5(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubsubsubsubsubfeatureContext subsubsubsubsubfeature() throws RecognitionException {
		SubsubsubsubsubfeatureContext _localctx = new SubsubsubsubsubfeatureContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_subsubsubsubsubfeature);
		try {
			int _alt;
			_localctx = new SubLevel5Context(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(63);
			match(T__0);
			setState(64);
			match(T__5);
			setState(65);
			match(FEATURENAME);
			}
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(67);
					subsubsubsubsubsubfeature();
					}
					} 
				}
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class SubsubsubsubsubsubfeatureContext extends ParserRuleContext {
		public SubsubsubsubsubsubfeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subsubsubsubsubsubfeature; }
	 
		public SubsubsubsubsubsubfeatureContext() { }
		public void copyFrom(SubsubsubsubsubsubfeatureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubLevel6Context extends SubsubsubsubsubsubfeatureContext {
		public TerminalNode FEATURENAME() { return getToken(featureHierarchyParser.FEATURENAME, 0); }
		public List<SubsubsubsubsubsubsubfeatureContext> subsubsubsubsubsubsubfeature() {
			return getRuleContexts(SubsubsubsubsubsubsubfeatureContext.class);
		}
		public SubsubsubsubsubsubsubfeatureContext subsubsubsubsubsubsubfeature(int i) {
			return getRuleContext(SubsubsubsubsubsubsubfeatureContext.class,i);
		}
		public SubLevel6Context(SubsubsubsubsubsubfeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof featureHierarchyListener ) ((featureHierarchyListener)listener).enterSubLevel6(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof featureHierarchyListener ) ((featureHierarchyListener)listener).exitSubLevel6(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof featureHierarchyVisitor ) return ((featureHierarchyVisitor<? extends T>)visitor).visitSubLevel6(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubsubsubsubsubsubfeatureContext subsubsubsubsubsubfeature() throws RecognitionException {
		SubsubsubsubsubsubfeatureContext _localctx = new SubsubsubsubsubsubfeatureContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_subsubsubsubsubsubfeature);
		try {
			int _alt;
			_localctx = new SubLevel6Context(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(73);
			match(T__0);
			setState(74);
			match(T__6);
			setState(75);
			match(FEATURENAME);
			}
			setState(80);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(77);
					subsubsubsubsubsubsubfeature();
					}
					} 
				}
				setState(82);
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

	public static class SubsubsubsubsubsubsubfeatureContext extends ParserRuleContext {
		public SubsubsubsubsubsubsubfeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subsubsubsubsubsubsubfeature; }
	 
		public SubsubsubsubsubsubsubfeatureContext() { }
		public void copyFrom(SubsubsubsubsubsubsubfeatureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubLevel7Context extends SubsubsubsubsubsubsubfeatureContext {
		public TerminalNode FEATURENAME() { return getToken(featureHierarchyParser.FEATURENAME, 0); }
		public SubLevel7Context(SubsubsubsubsubsubsubfeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof featureHierarchyListener ) ((featureHierarchyListener)listener).enterSubLevel7(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof featureHierarchyListener ) ((featureHierarchyListener)listener).exitSubLevel7(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof featureHierarchyVisitor ) return ((featureHierarchyVisitor<? extends T>)visitor).visitSubLevel7(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubsubsubsubsubsubsubfeatureContext subsubsubsubsubsubsubfeature() throws RecognitionException {
		SubsubsubsubsubsubsubfeatureContext _localctx = new SubsubsubsubsubsubsubfeatureContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_subsubsubsubsubsubsubfeature);
		try {
			_localctx = new SubLevel7Context(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(83);
			match(T__0);
			setState(84);
			match(T__7);
			setState(85);
			match(FEATURENAME);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\rZ\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\7\2\25\n\2"+
		"\f\2\16\2\30\13\2\3\3\3\3\3\3\3\3\3\3\7\3\37\n\3\f\3\16\3\"\13\3\3\4\3"+
		"\4\3\4\3\4\3\4\7\4)\n\4\f\4\16\4,\13\4\3\5\3\5\3\5\3\5\3\5\7\5\63\n\5"+
		"\f\5\16\5\66\13\5\3\6\3\6\3\6\3\6\3\6\7\6=\n\6\f\6\16\6@\13\6\3\7\3\7"+
		"\3\7\3\7\3\7\7\7G\n\7\f\7\16\7J\13\7\3\b\3\b\3\b\3\b\3\b\7\bQ\n\b\f\b"+
		"\16\bT\13\b\3\t\3\t\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2\2X\2\22\3"+
		"\2\2\2\4\31\3\2\2\2\6#\3\2\2\2\b-\3\2\2\2\n\67\3\2\2\2\fA\3\2\2\2\16K"+
		"\3\2\2\2\20U\3\2\2\2\22\26\7\r\2\2\23\25\5\4\3\2\24\23\3\2\2\2\25\30\3"+
		"\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\3\3\2\2\2\30\26\3\2\2\2\31\32\7"+
		"\3\2\2\32\33\7\4\2\2\33\34\7\r\2\2\34 \3\2\2\2\35\37\5\6\4\2\36\35\3\2"+
		"\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\5\3\2\2\2\" \3\2\2\2#$\7\3\2"+
		"\2$%\7\5\2\2%&\7\r\2\2&*\3\2\2\2\')\5\b\5\2(\'\3\2\2\2),\3\2\2\2*(\3\2"+
		"\2\2*+\3\2\2\2+\7\3\2\2\2,*\3\2\2\2-.\7\3\2\2./\7\6\2\2/\60\7\r\2\2\60"+
		"\64\3\2\2\2\61\63\5\n\6\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64"+
		"\65\3\2\2\2\65\t\3\2\2\2\66\64\3\2\2\2\678\7\3\2\289\7\7\2\29:\7\r\2\2"+
		":>\3\2\2\2;=\5\f\7\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?\13\3\2\2"+
		"\2@>\3\2\2\2AB\7\3\2\2BC\7\b\2\2CD\7\r\2\2DH\3\2\2\2EG\5\16\b\2FE\3\2"+
		"\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\r\3\2\2\2JH\3\2\2\2KL\7\3\2\2LM\7"+
		"\t\2\2MN\7\r\2\2NR\3\2\2\2OQ\5\20\t\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS"+
		"\3\2\2\2S\17\3\2\2\2TR\3\2\2\2UV\7\3\2\2VW\7\n\2\2WX\7\r\2\2X\21\3\2\2"+
		"\2\t\26 *\64>HR";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}