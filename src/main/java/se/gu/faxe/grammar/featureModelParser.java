// Generated from C:/Users/Tobias/IdeaProjects/FAXE-Feature_Annotation_eXtraction_Engine/src/main/antlr4/se/gu/faxe\featureModel.g4 by ANTLR 4.8
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
public class featureModelParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, SPACE=4, KEYWORDS=5, FEATURENAME=6;
	public static final int
		RULE_featureModel = 0, RULE_projectname = 1, RULE_feature = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"featureModel", "projectname", "feature"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\n'", "'\r\n'", "'\t'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "SPACE", "KEYWORDS", "FEATURENAME"
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
	public String getGrammarFileName() { return "featureModel.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public featureModelParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FeatureModelContext extends ParserRuleContext {
		public ProjectnameContext projectname() {
			return getRuleContext(ProjectnameContext.class,0);
		}
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public FeatureModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureModel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof featureModelListener ) ((featureModelListener)listener).enterFeatureModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof featureModelListener ) ((featureModelListener)listener).exitFeatureModel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof featureModelVisitor ) return ((featureModelVisitor<? extends T>)visitor).visitFeatureModel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureModelContext featureModel() throws RecognitionException {
		FeatureModelContext _localctx = new FeatureModelContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_featureModel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			projectname();
			setState(11);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__1) {
				{
				{
				setState(7);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==T__1) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(8);
				feature();
				}
				}
				setState(13);
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

	public static class ProjectnameContext extends ParserRuleContext {
		public TerminalNode FEATURENAME() { return getToken(featureModelParser.FEATURENAME, 0); }
		public ProjectnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projectname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof featureModelListener ) ((featureModelListener)listener).enterProjectname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof featureModelListener ) ((featureModelListener)listener).exitProjectname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof featureModelVisitor ) return ((featureModelVisitor<? extends T>)visitor).visitProjectname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectnameContext projectname() throws RecognitionException {
		ProjectnameContext _localctx = new ProjectnameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_projectname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(FEATURENAME);
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

	public static class FeatureContext extends ParserRuleContext {
		public TerminalNode FEATURENAME() { return getToken(featureModelParser.FEATURENAME, 0); }
		public FeatureContext feature() {
			return getRuleContext(FeatureContext.class,0);
		}
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof featureModelListener ) ((featureModelListener)listener).enterFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof featureModelListener ) ((featureModelListener)listener).exitFeature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof featureModelVisitor ) return ((featureModelVisitor<? extends T>)visitor).visitFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_feature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FEATURENAME:
				{
				setState(16);
				match(FEATURENAME);
				}
				break;
			case T__2:
				{
				setState(17);
				match(T__2);
				setState(18);
				feature();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b\30\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\2\7\2\f\n\2\f\2\16\2\17\13\2\3\3\3\3\3\4\3\4\3"+
		"\4\5\4\26\n\4\3\4\2\2\5\2\4\6\2\3\3\2\3\4\2\26\2\b\3\2\2\2\4\20\3\2\2"+
		"\2\6\25\3\2\2\2\b\r\5\4\3\2\t\n\t\2\2\2\n\f\5\6\4\2\13\t\3\2\2\2\f\17"+
		"\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\3\3\2\2\2\17\r\3\2\2\2\20\21\7\b"+
		"\2\2\21\5\3\2\2\2\22\26\7\b\2\2\23\24\7\5\2\2\24\26\5\6\4\2\25\22\3\2"+
		"\2\2\25\23\3\2\2\2\26\7\3\2\2\2\4\r\25";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}