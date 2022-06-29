// Generated from C:/Users/yang/Desktop/c4/73/src\Grammar.g4 by ANTLR 4.9.2
package nl.saxion.cos;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, INT_TYPE=29, DOUBLE_TYPE=30, STRING_TYPE=31, 
		BOOLEAN_TYPE=32, INT=33, DOUBLE=34, STRING=35, BOOLEAN=36, IDENTIFIER=37, 
		WS=38, COMMENT=39;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_declaration = 2, RULE_assignment = 3, 
		RULE_scanner = 4, RULE_print = 5, RULE_ifStatement = 6, RULE_falseStatement = 7, 
		RULE_loop = 8, RULE_method = 9, RULE_methodDeclaration = 10, RULE_method_call = 11, 
		RULE_scope = 12, RULE_expression_list = 13, RULE_expression = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "declaration", "assignment", "scanner", "print", 
			"ifStatement", "falseStatement", "loop", "method", "methodDeclaration", 
			"method_call", "scope", "expression_list", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'Enter<<'", "'Show>>'", "'if'", "'('", "')'", "'{'", 
			"'}'", "'else'", "'Loop'", "'Times'", "'#Construct'", "'<'", "','", "'>'", 
			"'return'", "'-'", "'*'", "'/'", "'+'", "'&&'", "'||'", "'eq'", "'>='", 
			"'<='", "'=='", "'!='", "'Floor'", "'Room'", "'Name'", "'Finish'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "INT_TYPE", "DOUBLE_TYPE", "STRING_TYPE", 
			"BOOLEAN_TYPE", "INT", "DOUBLE", "STRING", "BOOLEAN", "IDENTIFIER", "WS", 
			"COMMENT"
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
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__7) | (1L << T__10) | (1L << T__12) | (1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << STRING_TYPE) | (1L << BOOLEAN_TYPE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(30);
				statement();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
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

	public static class StatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				print();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				ifStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(42);
				loop();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(43);
				method();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(44);
				method_call();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(45);
				scope();
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

	public static class DeclarationContext extends ParserRuleContext {
		public Token type;
		public TerminalNode IDENTIFIER() { return getToken(GrammarParser.IDENTIFIER, 0); }
		public TerminalNode INT_TYPE() { return getToken(GrammarParser.INT_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(GrammarParser.STRING_TYPE, 0); }
		public TerminalNode DOUBLE_TYPE() { return getToken(GrammarParser.DOUBLE_TYPE, 0); }
		public TerminalNode BOOLEAN_TYPE() { return getToken(GrammarParser.BOOLEAN_TYPE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			((DeclarationContext)_localctx).type = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << STRING_TYPE) | (1L << BOOLEAN_TYPE))) != 0)) ) {
				((DeclarationContext)_localctx).type = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(49);
			match(IDENTIFIER);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(50);
				match(T__0);
				setState(51);
				expression(0);
				}
			}

			setState(54);
			match(T__1);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GrammarParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(IDENTIFIER);
			setState(57);
			match(T__0);
			setState(58);
			expression(0);
			setState(59);
			match(T__1);
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

	public static class ScannerContext extends ParserRuleContext {
		public ScannerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scanner; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitScanner(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScannerContext scanner() throws RecognitionException {
		ScannerContext _localctx = new ScannerContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_scanner);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(T__2);
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

	public static class PrintContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__3);
			setState(64);
			expression(0);
			setState(65);
			match(T__1);
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

	public static class IfStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FalseStatementContext falseStatement() {
			return getRuleContext(FalseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__4);
			setState(68);
			match(T__5);
			setState(69);
			expression(0);
			setState(70);
			match(T__6);
			setState(71);
			match(T__7);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__7) | (1L << T__10) | (1L << T__12) | (1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << STRING_TYPE) | (1L << BOOLEAN_TYPE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(72);
				statement();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			match(T__8);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(79);
				match(T__9);
				setState(80);
				match(T__7);
				setState(81);
				falseStatement();
				setState(82);
				match(T__8);
				}
			}

			setState(86);
			match(T__1);
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

	public static class FalseStatementContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FalseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_falseStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitFalseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FalseStatementContext falseStatement() throws RecognitionException {
		FalseStatementContext _localctx = new FalseStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_falseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__7) | (1L << T__10) | (1L << T__12) | (1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << STRING_TYPE) | (1L << BOOLEAN_TYPE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(88);
				statement();
				}
				}
				setState(93);
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

	public static class LoopContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__10);
			setState(95);
			match(T__7);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__7) | (1L << T__10) | (1L << T__12) | (1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << STRING_TYPE) | (1L << BOOLEAN_TYPE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(96);
				statement();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(T__8);
			setState(103);
			match(T__11);
			setState(104);
			match(T__5);
			setState(105);
			match(INT);
			setState(106);
			match(T__6);
			setState(107);
			match(T__1);
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

	public static class MethodContext extends ParserRuleContext {
		public Token name;
		public ExpressionContext return_value;
		public TerminalNode IDENTIFIER() { return getToken(GrammarParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<MethodDeclarationContext> methodDeclaration() {
			return getRuleContexts(MethodDeclarationContext.class);
		}
		public MethodDeclarationContext methodDeclaration(int i) {
			return getRuleContext(MethodDeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(T__12);
			setState(110);
			((MethodContext)_localctx).name = match(IDENTIFIER);
			setState(111);
			match(T__13);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << STRING_TYPE) | (1L << BOOLEAN_TYPE))) != 0)) {
				{
				setState(112);
				methodDeclaration();
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(113);
					match(T__14);
					setState(114);
					methodDeclaration();
					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(122);
			match(T__15);
			setState(123);
			match(T__7);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__7) | (1L << T__10) | (1L << T__12) | (1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << STRING_TYPE) | (1L << BOOLEAN_TYPE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(124);
				statement();
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130);
			match(T__8);
			setState(131);
			match(T__16);
			setState(132);
			match(T__5);
			setState(133);
			((MethodContext)_localctx).return_value = expression(0);
			setState(134);
			match(T__6);
			setState(135);
			match(T__1);
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

	public static class MethodDeclarationContext extends ParserRuleContext {
		public Token type;
		public TerminalNode IDENTIFIER() { return getToken(GrammarParser.IDENTIFIER, 0); }
		public TerminalNode INT_TYPE() { return getToken(GrammarParser.INT_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(GrammarParser.STRING_TYPE, 0); }
		public TerminalNode DOUBLE_TYPE() { return getToken(GrammarParser.DOUBLE_TYPE, 0); }
		public TerminalNode BOOLEAN_TYPE() { return getToken(GrammarParser.BOOLEAN_TYPE, 0); }
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			((MethodDeclarationContext)_localctx).type = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << STRING_TYPE) | (1L << BOOLEAN_TYPE))) != 0)) ) {
				((MethodDeclarationContext)_localctx).type = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(138);
			match(IDENTIFIER);
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

	public static class Method_callContext extends ParserRuleContext {
		public Token name;
		public TerminalNode IDENTIFIER() { return getToken(GrammarParser.IDENTIFIER, 0); }
		public Expression_listContext expression_list() {
			return getRuleContext(Expression_listContext.class,0);
		}
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitMethod_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_method_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			((Method_callContext)_localctx).name = match(IDENTIFIER);
			setState(141);
			match(T__5);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__17) | (1L << INT) | (1L << DOUBLE) | (1L << STRING) | (1L << BOOLEAN) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(142);
				expression_list();
				}
			}

			setState(145);
			match(T__6);
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

	public static class ScopeContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_scope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__7);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__7) | (1L << T__10) | (1L << T__12) | (1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << STRING_TYPE) | (1L << BOOLEAN_TYPE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(148);
				statement();
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
			match(T__8);
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

	public static class Expression_listContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Expression_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpression_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression_listContext expression_list() throws RecognitionException {
		Expression_listContext _localctx = new Expression_listContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expression_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			expression(0);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(157);
				match(T__14);
				setState(158);
				expression(0);
				}
				}
				setState(163);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpDouContext extends ExpressionContext {
		public TerminalNode DOUBLE() { return getToken(GrammarParser.DOUBLE, 0); }
		public ExpDouContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpDou(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpScannerContext extends ExpressionContext {
		public ScannerContext scanner() {
			return getRuleContext(ScannerContext.class,0);
		}
		public ExpScannerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpScanner(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpAddContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpAddContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpMulContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpMulContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpMul(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpEqualContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpEqualContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpCompareContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpCompareContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpCompare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpNegateContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpNegateContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpNegate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpParenthesesContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpParenthesesContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpParentheses(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpIdentifierContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(GrammarParser.IDENTIFIER, 0); }
		public ExpIdentifierContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpStrContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(GrammarParser.STRING, 0); }
		public ExpStrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpStr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpBoolContext extends ExpressionContext {
		public TerminalNode BOOLEAN() { return getToken(GrammarParser.BOOLEAN, 0); }
		public ExpBoolContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expmethod_callContext extends ExpressionContext {
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public Expmethod_callContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpmethod_call(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpLogicContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpLogicContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpLogic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpIntContext extends ExpressionContext {
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public ExpIntContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new ExpParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(165);
				match(T__5);
				setState(166);
				expression(0);
				setState(167);
				match(T__6);
				}
				break;
			case 2:
				{
				_localctx = new ExpNegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(T__17);
				setState(170);
				expression(13);
				}
				break;
			case 3:
				{
				_localctx = new ExpLogicContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171);
				match(T__5);
				setState(172);
				((ExpLogicContext)_localctx).left = expression(0);
				setState(173);
				match(T__6);
				setState(174);
				((ExpLogicContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__22) ) {
					((ExpLogicContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(175);
				match(T__5);
				setState(176);
				((ExpLogicContext)_localctx).right = expression(0);
				setState(177);
				match(T__6);
				}
				break;
			case 4:
				{
				_localctx = new ExpIdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179);
				match(IDENTIFIER);
				}
				break;
			case 5:
				{
				_localctx = new ExpIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				match(INT);
				}
				break;
			case 6:
				{
				_localctx = new ExpDouContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				match(DOUBLE);
				}
				break;
			case 7:
				{
				_localctx = new ExpStrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new ExpBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				match(BOOLEAN);
				}
				break;
			case 9:
				{
				_localctx = new ExpScannerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				scanner();
				}
				break;
			case 10:
				{
				_localctx = new Expmethod_callContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				method_call();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(202);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(200);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExpMulContext(new ExpressionContext(_parentctx, _parentState));
						((ExpMulContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(188);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(189);
						((ExpMulContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__18 || _la==T__19) ) {
							((ExpMulContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(190);
						((ExpMulContext)_localctx).right = expression(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpAddContext(new ExpressionContext(_parentctx, _parentState));
						((ExpAddContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(191);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(192);
						((ExpAddContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__20) ) {
							((ExpAddContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(193);
						((ExpAddContext)_localctx).right = expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpEqualContext(new ExpressionContext(_parentctx, _parentState));
						((ExpEqualContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(194);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(195);
						match(T__23);
						setState(196);
						((ExpEqualContext)_localctx).right = expression(10);
						}
						break;
					case 4:
						{
						_localctx = new ExpCompareContext(new ExpressionContext(_parentctx, _parentState));
						((ExpCompareContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(197);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(198);
						((ExpCompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__15) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27))) != 0)) ) {
							((ExpCompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(199);
						((ExpCompareContext)_localctx).right = expression(9);
						}
						break;
					}
					} 
				}
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00d0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\7\2\"\n\2\f\2\16"+
		"\2%\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\61\n\3\3\4\3\4\3"+
		"\4\3\4\5\4\67\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\7\bL\n\b\f\b\16\bO\13\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\bW\n\b\3\b\3\b\3\t\7\t\\\n\t\f\t\16\t_\13\t\3\n\3\n\3\n\7\nd\n\n"+
		"\f\n\16\ng\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\7\13v\n\13\f\13\16\13y\13\13\5\13{\n\13\3\13\3\13\3\13\7\13\u0080"+
		"\n\13\f\13\16\13\u0083\13\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\5\r\u0092\n\r\3\r\3\r\3\16\3\16\7\16\u0098\n\16\f\16"+
		"\16\16\u009b\13\16\3\16\3\16\3\17\3\17\3\17\7\17\u00a2\n\17\f\17\16\17"+
		"\u00a5\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00bd\n\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00cb"+
		"\n\20\f\20\16\20\u00ce\13\20\3\20\2\3\36\21\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36\2\7\3\2\37\"\3\2\30\31\3\2\25\26\4\2\24\24\27\27\5\2\20\20"+
		"\22\22\33\36\2\u00e0\2#\3\2\2\2\4\60\3\2\2\2\6\62\3\2\2\2\b:\3\2\2\2\n"+
		"?\3\2\2\2\fA\3\2\2\2\16E\3\2\2\2\20]\3\2\2\2\22`\3\2\2\2\24o\3\2\2\2\26"+
		"\u008b\3\2\2\2\30\u008e\3\2\2\2\32\u0095\3\2\2\2\34\u009e\3\2\2\2\36\u00bc"+
		"\3\2\2\2 \"\5\4\3\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2"+
		"%#\3\2\2\2&\'\7\2\2\3\'\3\3\2\2\2(\61\5\6\4\2)\61\5\b\5\2*\61\5\f\7\2"+
		"+\61\5\16\b\2,\61\5\22\n\2-\61\5\24\13\2.\61\5\30\r\2/\61\5\32\16\2\60"+
		"(\3\2\2\2\60)\3\2\2\2\60*\3\2\2\2\60+\3\2\2\2\60,\3\2\2\2\60-\3\2\2\2"+
		"\60.\3\2\2\2\60/\3\2\2\2\61\5\3\2\2\2\62\63\t\2\2\2\63\66\7\'\2\2\64\65"+
		"\7\3\2\2\65\67\5\36\20\2\66\64\3\2\2\2\66\67\3\2\2\2\678\3\2\2\289\7\4"+
		"\2\29\7\3\2\2\2:;\7\'\2\2;<\7\3\2\2<=\5\36\20\2=>\7\4\2\2>\t\3\2\2\2?"+
		"@\7\5\2\2@\13\3\2\2\2AB\7\6\2\2BC\5\36\20\2CD\7\4\2\2D\r\3\2\2\2EF\7\7"+
		"\2\2FG\7\b\2\2GH\5\36\20\2HI\7\t\2\2IM\7\n\2\2JL\5\4\3\2KJ\3\2\2\2LO\3"+
		"\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PV\7\13\2\2QR\7\f\2\2RS"+
		"\7\n\2\2ST\5\20\t\2TU\7\13\2\2UW\3\2\2\2VQ\3\2\2\2VW\3\2\2\2WX\3\2\2\2"+
		"XY\7\4\2\2Y\17\3\2\2\2Z\\\5\4\3\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2"+
		"\2\2^\21\3\2\2\2_]\3\2\2\2`a\7\r\2\2ae\7\n\2\2bd\5\4\3\2cb\3\2\2\2dg\3"+
		"\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hi\7\13\2\2ij\7\16\2\2j"+
		"k\7\b\2\2kl\7#\2\2lm\7\t\2\2mn\7\4\2\2n\23\3\2\2\2op\7\17\2\2pq\7\'\2"+
		"\2qz\7\20\2\2rw\5\26\f\2st\7\21\2\2tv\5\26\f\2us\3\2\2\2vy\3\2\2\2wu\3"+
		"\2\2\2wx\3\2\2\2x{\3\2\2\2yw\3\2\2\2zr\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\7"+
		"\22\2\2}\u0081\7\n\2\2~\u0080\5\4\3\2\177~\3\2\2\2\u0080\u0083\3\2\2\2"+
		"\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0084\u0085\7\13\2\2\u0085\u0086\7\23\2\2\u0086\u0087\7\b\2\2"+
		"\u0087\u0088\5\36\20\2\u0088\u0089\7\t\2\2\u0089\u008a\7\4\2\2\u008a\25"+
		"\3\2\2\2\u008b\u008c\t\2\2\2\u008c\u008d\7\'\2\2\u008d\27\3\2\2\2\u008e"+
		"\u008f\7\'\2\2\u008f\u0091\7\b\2\2\u0090\u0092\5\34\17\2\u0091\u0090\3"+
		"\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7\t\2\2\u0094"+
		"\31\3\2\2\2\u0095\u0099\7\n\2\2\u0096\u0098\5\4\3\2\u0097\u0096\3\2\2"+
		"\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c"+
		"\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7\13\2\2\u009d\33\3\2\2\2\u009e"+
		"\u00a3\5\36\20\2\u009f\u00a0\7\21\2\2\u00a0\u00a2\5\36\20\2\u00a1\u009f"+
		"\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\35\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\b\20\1\2\u00a7\u00a8\7\b\2"+
		"\2\u00a8\u00a9\5\36\20\2\u00a9\u00aa\7\t\2\2\u00aa\u00bd\3\2\2\2\u00ab"+
		"\u00ac\7\24\2\2\u00ac\u00bd\5\36\20\17\u00ad\u00ae\7\b\2\2\u00ae\u00af"+
		"\5\36\20\2\u00af\u00b0\7\t\2\2\u00b0\u00b1\t\3\2\2\u00b1\u00b2\7\b\2\2"+
		"\u00b2\u00b3\5\36\20\2\u00b3\u00b4\7\t\2\2\u00b4\u00bd\3\2\2\2\u00b5\u00bd"+
		"\7\'\2\2\u00b6\u00bd\7#\2\2\u00b7\u00bd\7$\2\2\u00b8\u00bd\7%\2\2\u00b9"+
		"\u00bd\7&\2\2\u00ba\u00bd\5\n\6\2\u00bb\u00bd\5\30\r\2\u00bc\u00a6\3\2"+
		"\2\2\u00bc\u00ab\3\2\2\2\u00bc\u00ad\3\2\2\2\u00bc\u00b5\3\2\2\2\u00bc"+
		"\u00b6\3\2\2\2\u00bc\u00b7\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bc\u00b9\3\2"+
		"\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00cc\3\2\2\2\u00be"+
		"\u00bf\f\16\2\2\u00bf\u00c0\t\4\2\2\u00c0\u00cb\5\36\20\17\u00c1\u00c2"+
		"\f\r\2\2\u00c2\u00c3\t\5\2\2\u00c3\u00cb\5\36\20\16\u00c4\u00c5\f\13\2"+
		"\2\u00c5\u00c6\7\32\2\2\u00c6\u00cb\5\36\20\f\u00c7\u00c8\f\n\2\2\u00c8"+
		"\u00c9\t\6\2\2\u00c9\u00cb\5\36\20\13\u00ca\u00be\3\2\2\2\u00ca\u00c1"+
		"\3\2\2\2\u00ca\u00c4\3\2\2\2\u00ca\u00c7\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\37\3\2\2\2\u00ce\u00cc\3\2\2"+
		"\2\22#\60\66MV]ewz\u0081\u0091\u0099\u00a3\u00bc\u00ca\u00cc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}