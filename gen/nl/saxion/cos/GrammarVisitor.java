// Generated from C:/Users/yang/Desktop/c4/73/src\Grammar.g4 by ANTLR 4.9.2
package nl.saxion.cos;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(GrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(GrammarParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(GrammarParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#scanner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScanner(GrammarParser.ScannerContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(GrammarParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(GrammarParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#falseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseStatement(GrammarParser.FalseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(GrammarParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(GrammarParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(GrammarParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_call(GrammarParser.Method_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScope(GrammarParser.ScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_list(GrammarParser.Expression_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpDou}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpDou(GrammarParser.ExpDouContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpScanner}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpScanner(GrammarParser.ExpScannerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpAdd}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpAdd(GrammarParser.ExpAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpMul}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpMul(GrammarParser.ExpMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpEqual}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpEqual(GrammarParser.ExpEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpCompare}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpCompare(GrammarParser.ExpCompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpNegate}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpNegate(GrammarParser.ExpNegateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpParentheses}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpParentheses(GrammarParser.ExpParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpIdentifier}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpIdentifier(GrammarParser.ExpIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpStr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpStr(GrammarParser.ExpStrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpBool}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpBool(GrammarParser.ExpBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Expmethod_call}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpmethod_call(GrammarParser.Expmethod_callContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpLogic}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpLogic(GrammarParser.ExpLogicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpInt}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpInt(GrammarParser.ExpIntContext ctx);
}