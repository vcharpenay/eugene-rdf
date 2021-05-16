// Generated from Dot.g4 by ANTLR 4.9.2

package fr.emse.dot.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DotParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, ID=15, WS=16;
	public static final int
		RULE_graph = 0, RULE_stmtList = 1, RULE_stmt = 2, RULE_attrStmt = 3, RULE_attrList = 4, 
		RULE_aList = 5, RULE_edgeStmt = 6, RULE_edgeRHS = 7, RULE_edgeOp = 8, 
		RULE_nodeStmt = 9, RULE_nodeID = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"graph", "stmtList", "stmt", "attrStmt", "attrList", "aList", "edgeStmt", 
			"edgeRHS", "edgeOp", "nodeStmt", "nodeID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'strict'", "'graph'", "'digraph'", "'{'", "'}'", "';'", "'node'", 
			"'edge'", "'['", "']'", "'='", "','", "'->'", "'--'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "ID", "WS"
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
	public String getGrammarFileName() { return "Dot.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DotParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class GraphContext extends ParserRuleContext {
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public GraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graph; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).enterGraph(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).exitGraph(this);
		}
	}

	public final GraphContext graph() throws RecognitionException {
		GraphContext _localctx = new GraphContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_graph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(22);
				match(T__0);
				}
			}

			setState(25);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==T__2) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(26);
			match(T__3);
			setState(27);
			stmtList();
			setState(28);
			match(T__4);
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

	public static class StmtListContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public StmtListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).enterStmtList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).exitStmtList(this);
		}
	}

	public final StmtListContext stmtList() throws RecognitionException {
		StmtListContext _localctx = new StmtListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmtList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << ID))) != 0)) {
				{
				setState(30);
				stmt();
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(31);
					match(T__5);
					}
				}

				setState(34);
				stmtList();
				}
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

	public static class StmtContext extends ParserRuleContext {
		public NodeStmtContext nodeStmt() {
			return getRuleContext(NodeStmtContext.class,0);
		}
		public EdgeStmtContext edgeStmt() {
			return getRuleContext(EdgeStmtContext.class,0);
		}
		public AttrStmtContext attrStmt() {
			return getRuleContext(AttrStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt);
		try {
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				nodeStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				edgeStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				attrStmt();
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

	public static class AttrStmtContext extends ParserRuleContext {
		public AttrListContext attrList() {
			return getRuleContext(AttrListContext.class,0);
		}
		public AttrStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).enterAttrStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).exitAttrStmt(this);
		}
	}

	public final AttrStmtContext attrStmt() throws RecognitionException {
		AttrStmtContext _localctx = new AttrStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attrStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(44);
			attrList();
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

	public static class AttrListContext extends ParserRuleContext {
		public AListContext aList() {
			return getRuleContext(AListContext.class,0);
		}
		public AttrListContext attrList() {
			return getRuleContext(AttrListContext.class,0);
		}
		public AttrListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).enterAttrList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).exitAttrList(this);
		}
	}

	public final AttrListContext attrList() throws RecognitionException {
		AttrListContext _localctx = new AttrListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attrList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__8);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(47);
				aList();
				}
			}

			setState(50);
			match(T__9);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(51);
				attrList();
				}
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

	public static class AListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(DotParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DotParser.ID, i);
		}
		public AListContext aList() {
			return getRuleContext(AListContext.class,0);
		}
		public AListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).enterAList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).exitAList(this);
		}
	}

	public final AListContext aList() throws RecognitionException {
		AListContext _localctx = new AListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_aList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(ID);
			setState(55);
			match(T__10);
			setState(56);
			match(ID);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5 || _la==T__11) {
				{
				setState(57);
				_la = _input.LA(1);
				if ( !(_la==T__5 || _la==T__11) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(60);
				aList();
				}
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

	public static class EdgeStmtContext extends ParserRuleContext {
		public NodeIDContext nodeID() {
			return getRuleContext(NodeIDContext.class,0);
		}
		public EdgeRHSContext edgeRHS() {
			return getRuleContext(EdgeRHSContext.class,0);
		}
		public AttrListContext attrList() {
			return getRuleContext(AttrListContext.class,0);
		}
		public EdgeStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).enterEdgeStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).exitEdgeStmt(this);
		}
	}

	public final EdgeStmtContext edgeStmt() throws RecognitionException {
		EdgeStmtContext _localctx = new EdgeStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_edgeStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			nodeID();
			setState(64);
			edgeRHS();
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(65);
				attrList();
				}
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

	public static class EdgeRHSContext extends ParserRuleContext {
		public EdgeOpContext edgeOp() {
			return getRuleContext(EdgeOpContext.class,0);
		}
		public NodeIDContext nodeID() {
			return getRuleContext(NodeIDContext.class,0);
		}
		public EdgeRHSContext edgeRHS() {
			return getRuleContext(EdgeRHSContext.class,0);
		}
		public EdgeRHSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeRHS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).enterEdgeRHS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).exitEdgeRHS(this);
		}
	}

	public final EdgeRHSContext edgeRHS() throws RecognitionException {
		EdgeRHSContext _localctx = new EdgeRHSContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_edgeRHS);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			edgeOp();
			setState(69);
			nodeID();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12 || _la==T__13) {
				{
				setState(70);
				edgeRHS();
				}
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

	public static class EdgeOpContext extends ParserRuleContext {
		public EdgeOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).enterEdgeOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).exitEdgeOp(this);
		}
	}

	public final EdgeOpContext edgeOp() throws RecognitionException {
		EdgeOpContext _localctx = new EdgeOpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_edgeOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_la = _input.LA(1);
			if ( !(_la==T__12 || _la==T__13) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class NodeStmtContext extends ParserRuleContext {
		public NodeIDContext nodeID() {
			return getRuleContext(NodeIDContext.class,0);
		}
		public AttrListContext attrList() {
			return getRuleContext(AttrListContext.class,0);
		}
		public NodeStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodeStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).enterNodeStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).exitNodeStmt(this);
		}
	}

	public final NodeStmtContext nodeStmt() throws RecognitionException {
		NodeStmtContext _localctx = new NodeStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nodeStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			nodeID();
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(76);
				attrList();
				}
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

	public static class NodeIDContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DotParser.ID, 0); }
		public NodeIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodeID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).enterNodeID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotListener ) ((DotListener)listener).exitNodeID(this);
		}
	}

	public final NodeIDContext nodeID() throws RecognitionException {
		NodeIDContext _localctx = new NodeIDContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_nodeID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(ID);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22T\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\5\2\32\n\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\5\3#\n\3\3\3\3\3\5\3"+
		"\'\n\3\3\4\3\4\3\4\5\4,\n\4\3\5\3\5\3\5\3\6\3\6\5\6\63\n\6\3\6\3\6\5\6"+
		"\67\n\6\3\7\3\7\3\7\3\7\5\7=\n\7\3\7\5\7@\n\7\3\b\3\b\3\b\5\bE\n\b\3\t"+
		"\3\t\3\t\5\tJ\n\t\3\n\3\n\3\13\3\13\5\13P\n\13\3\f\3\f\3\f\2\2\r\2\4\6"+
		"\b\n\f\16\20\22\24\26\2\6\3\2\4\5\4\2\4\4\t\n\4\2\b\b\16\16\3\2\17\20"+
		"\2T\2\31\3\2\2\2\4&\3\2\2\2\6+\3\2\2\2\b-\3\2\2\2\n\60\3\2\2\2\f8\3\2"+
		"\2\2\16A\3\2\2\2\20F\3\2\2\2\22K\3\2\2\2\24M\3\2\2\2\26Q\3\2\2\2\30\32"+
		"\7\3\2\2\31\30\3\2\2\2\31\32\3\2\2\2\32\33\3\2\2\2\33\34\t\2\2\2\34\35"+
		"\7\6\2\2\35\36\5\4\3\2\36\37\7\7\2\2\37\3\3\2\2\2 \"\5\6\4\2!#\7\b\2\2"+
		"\"!\3\2\2\2\"#\3\2\2\2#$\3\2\2\2$%\5\4\3\2%\'\3\2\2\2& \3\2\2\2&\'\3\2"+
		"\2\2\'\5\3\2\2\2(,\5\24\13\2),\5\16\b\2*,\5\b\5\2+(\3\2\2\2+)\3\2\2\2"+
		"+*\3\2\2\2,\7\3\2\2\2-.\t\3\2\2./\5\n\6\2/\t\3\2\2\2\60\62\7\13\2\2\61"+
		"\63\5\f\7\2\62\61\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\66\7\f\2\2\65"+
		"\67\5\n\6\2\66\65\3\2\2\2\66\67\3\2\2\2\67\13\3\2\2\289\7\21\2\29:\7\r"+
		"\2\2:<\7\21\2\2;=\t\4\2\2<;\3\2\2\2<=\3\2\2\2=?\3\2\2\2>@\5\f\7\2?>\3"+
		"\2\2\2?@\3\2\2\2@\r\3\2\2\2AB\5\26\f\2BD\5\20\t\2CE\5\n\6\2DC\3\2\2\2"+
		"DE\3\2\2\2E\17\3\2\2\2FG\5\22\n\2GI\5\26\f\2HJ\5\20\t\2IH\3\2\2\2IJ\3"+
		"\2\2\2J\21\3\2\2\2KL\t\5\2\2L\23\3\2\2\2MO\5\26\f\2NP\5\n\6\2ON\3\2\2"+
		"\2OP\3\2\2\2P\25\3\2\2\2QR\7\21\2\2R\27\3\2\2\2\r\31\"&+\62\66<?DIO";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}