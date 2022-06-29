package nl.saxion.cos;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * @author YangCheng
 * @date 3/4/2022 1:09 AM
 */
public class Checker extends GrammarBaseVisitor<DataType>{

    private boolean failed = false;
    private final ParseTreeProperty<DataType> dataTypes;
    private final ParseTreeProperty<SymbolTable> scope;
    private SymbolTable symbolTable;

    public Checker(ParseTreeProperty<DataType> dataTypes,ParseTreeProperty<SymbolTable> scope, SymbolTable symbolTable){
        this.dataTypes = dataTypes;
        this.symbolTable = symbolTable;
        this.scope = scope;
    }

    public boolean isFailed(){
        return failed;
    }

    @Override
    public DataType visitScope(GrammarParser.ScopeContext ctx) {
        scope.put(ctx,symbolTable);
        symbolTable = symbolTable.openScope();
        visitChildren(ctx);
        symbolTable = symbolTable.getParentScope();
        return null;
    }

    @Override
    public DataType visitExpAdd(GrammarParser.ExpAddContext ctx) {
        //Left and right type are different.
        if(!visit(ctx.left).equals(visit(ctx.right))){
            failed = true;
            throw new CompilerException("add or sub error! Left and right type are not the same! at: "+ctx.left.getText()+ctx.op.getText()+ctx.right.getText());
        }
        // left or right not int || double type.
        if(visit(ctx.left)!=DataType.INT && visit(ctx.left)!=DataType.DOUBLE){
            failed = true;
            throw new CompilerException("add or sub error! not valid data type: "+dataTypes.get(ctx.left)+ ". Required type: int or double! at: "+ctx.left.getText()+ctx.op.getText()+ctx.right.getText());
        }

        dataTypes.put(ctx,visit(ctx.left));
        return visit(ctx.left);
    }

    @Override
    public DataType visitExpParentheses(GrammarParser.ExpParenthesesContext ctx) {
        dataTypes.put(ctx,visit(ctx.expression()));
        return visit(ctx.expression());
    }


    @Override
    public DataType visitExpMul(GrammarParser.ExpMulContext ctx) {
        if(!visit(ctx.left).equals(visit(ctx.right))){
            failed = true;
            throw new CompilerException("multiplication or division error! Left and right type are not the same! at: "+ctx.left.getText()+ctx.op.getText()+ctx.right.getText());
        }
        // left or right not int, double type.
        if(visit(ctx.left)!=DataType.INT && visit(ctx.left)!=DataType.DOUBLE){
            failed = true;
            throw new CompilerException("multiplication or division error! not valid data type: "+dataTypes.get(ctx.left)+ ". Required type: int or double! at: "+ctx.left.getText()+ctx.op.getText()+ctx.right.getText());
        }
        dataTypes.put(ctx,visit(ctx.left));
        return visit(ctx.left);
    }

    @Override
    public DataType visitExpNegate(GrammarParser.ExpNegateContext ctx) {
        //  not int, double type.
        if(visit(ctx.expression())!=DataType.INT && visit(ctx.expression())!=DataType.DOUBLE){
            failed = true;
            throw new CompilerException("negate error! "+"at: "+ctx.expression().getText()+". Provided type is: "+dataTypes.get(ctx.expression())+". Required type: int or double.");
        }
        dataTypes.put(ctx,visit(ctx.expression()));
        return visit(ctx.expression());
    }

    @Override
    public DataType visitExpInt(GrammarParser.ExpIntContext ctx) {
        dataTypes.put(ctx,DataType.INT);
       return DataType.INT;
    }

    @Override
    public DataType visitExpDou(GrammarParser.ExpDouContext ctx) {
        dataTypes.put(ctx,DataType.DOUBLE);
        return DataType.DOUBLE;
    }

    @Override
    public DataType visitExpStr(GrammarParser.ExpStrContext ctx) {
        dataTypes.put(ctx,DataType.STRING);
        return DataType.STRING;
    }

    @Override
    public DataType visitExpBool(GrammarParser.ExpBoolContext ctx) {
        dataTypes.put(ctx,DataType.BOOLEAN);
        return DataType.BOOLEAN;
    }

    @Override
    public DataType visitExpCompare(GrammarParser.ExpCompareContext ctx) {
        if(!visit(ctx.left).equals(visit(ctx.right))){
            failed = true;
            throw new CompilerException("Compare error! at: ("+ctx.left.getText()+ctx.op.getText()+ctx.right.getText()+"). Diff datatype.");
        }
        dataTypes.put(ctx,visit(ctx.left));
        return DataType.BOOLEAN;
    }

    @Override
    public DataType visitExpEqual(GrammarParser.ExpEqualContext ctx) {
        if(!visit(ctx.left).equals(visit(ctx.right))){
            failed = true;
            throw new CompilerException("eq error! at: ("+ctx.left.getText()+" eq "+ctx.right.getText()+"). Diff datatype.");
        }
        if(visit(ctx.left)!=DataType.STRING){
            failed = true;
            throw new CompilerException("eq error! not valid data type: "+dataTypes.get(ctx.left)+ ". Required type: String! at: "+ctx.left.getText()+" eq "+ctx.right.getText());
        }
        dataTypes.put(ctx,visit(ctx.left));
        return DataType.BOOLEAN;
    }

    @Override
    public DataType visitPrint(GrammarParser.PrintContext ctx) {
        dataTypes.put(ctx,visit(ctx.expression()));
        return visit(ctx.expression());
    }

    @Override
    public DataType visitExpLogic(GrammarParser.ExpLogicContext ctx) {
        if(visit(ctx.left)!=DataType.BOOLEAN || visit(ctx.right)!=DataType.BOOLEAN){
            failed = true;
            throw new CompilerException("logic error! not valid data type at: ("+ctx.left.getText()+ctx.op.getText()+ctx.right.getText()+"). Required type: boolean");
        }
        if(!visit(ctx.left).equals(visit(ctx.right))){
            failed = true;
            throw new CompilerException("diff datatype at: ("+ctx.left.getText()+ctx.op.getText()+ctx.right.getText()+").");
        }
        dataTypes.put(ctx,visit(ctx.left));
        return DataType.BOOLEAN;
    }

    @Override
    public DataType visitLoop(GrammarParser.LoopContext ctx) {

        if(ctx.INT() != null){
            scope.put(ctx,symbolTable);
            symbolTable = symbolTable.openScope();
            for (var statement: ctx.statement()) {
                visit(statement);
            }
            symbolTable = symbolTable.getParentScope();
        } else {
            failed = true;
            throw new CompilerException( "Error, Missing number of loops!");
        }

        return null;
    }

    @Override
    public DataType visitIfStatement(GrammarParser.IfStatementContext ctx) {

        boolean haveElse= false;
        //check if have "else"
        for (ParseTree child : ctx.children) {
            if(child.getText().equals("else")){
                haveElse = true;
            }
        }
        if(visit(ctx.expression()) != DataType.BOOLEAN){
           failed = true;
            throw new CompilerException("if statement arg is not a Boolean data type");
        }
        scope.put(ctx,symbolTable);
        symbolTable = symbolTable.openScope();
        for (var statement: ctx.statement()) {
                visit(statement);
        }
        symbolTable = symbolTable.getParentScope();
        if(haveElse){
            symbolTable = symbolTable.openScope();
            visit(ctx.falseStatement());
            symbolTable = symbolTable.getParentScope();
        }
        return null;
    }

    @Override
    public DataType visitDeclaration(GrammarParser.DeclarationContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        DataType type = symbolTable.getTypeEnum(ctx.type.getText());
        if(symbolTable.lookUpLocal(name)!=null){
            throw new CompilerException("Variable "+name+" already exist");
        }
            symbolTable.add(name, type ,false);
        Boolean Assign = false ;
        for (ParseTree child : ctx.children) {
            if(child.getText().equals("=")){
                Assign = true;
            }
        }
        //check if the declared type matches the assignment type.
        if(Assign){
            VariableSymbol symbol = symbolTable.lookUpLocal(name);
            if(!symbol.getType().equals(visit(ctx.expression()))){
                throw new CompilerException("Declaration error! Incompatible datatypes. At Variable "+name+".");
            }
            symbol.setAssign(true);
        }
        dataTypes.put(ctx,symbolTable.lookUp(name).getType());
        scope.put(ctx,symbolTable);
        return symbolTable.lookUp(name).getType();
    }


    @Override
    public DataType visitExpIdentifier(GrammarParser.ExpIdentifierContext ctx) {

        String name = ctx.IDENTIFIER().getText();
        VariableSymbol symbol = symbolTable.lookUp(name);
        if(symbol == null){
            throw new CompilerException("Undefined variable: " + name);
        }
       if(!symbol.getAssign()){
           throw new CompilerException("Unassigned variable: " + name);
       };
        dataTypes.put(ctx,symbol.getType());
        scope.put(ctx,symbolTable);
        return symbol.getType();
    }

    @Override
    public DataType visitAssignment(GrammarParser.AssignmentContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        VariableSymbol symbol = symbolTable.lookUp(name);
        if(symbol==null){
            throw new CompilerException("Undefined variable in assignment: " + name);
        }else{
            symbol.setAssign(true);
        }
        if(!symbol.getType().equals(visit(ctx.expression()))){
            throw new CompilerException("Incompatible datatypes. At variable: "+name);
        }
        dataTypes.put(ctx,symbol.getType());
        scope.put(ctx,symbolTable);
        return symbol.getType();
    }

    @Override
    public DataType visitExpScanner(GrammarParser.ExpScannerContext ctx) {
        if(visit(ctx.scanner())!=DataType.STRING){
            throw new CompilerException("Scanner error! Required type:string!");
        }
        dataTypes.put(ctx,visit(ctx.scanner()));
        return visit(ctx.scanner());
    }

    @Override
    public DataType visitScanner(GrammarParser.ScannerContext ctx) {
        dataTypes.put(ctx,DataType.STRING);
        return DataType.STRING;
    }


    @Override
    public DataType visitMethod(GrammarParser.MethodContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        name += '@';
        if (ctx.methodDeclaration() != null) {
            for (ParseTree decl : ctx.methodDeclaration()) {
                // Skip the comma that separates argument declarations.
                if (!(";".equals(decl.getText()))) {
                    name += symbolTable.getTypeLetter(decl.getChild(0).getText());
                }
            }
        }
        // Store the method name in the current scope.
        symbolTable.add(name, DataType.BOOLEAN ,true);
        // Associate the node with the current scope.
        scope.put(ctx,symbolTable);

        // Visit the arguments and body in the new scope and restore the current scope afterwards.
        symbolTable = symbolTable.openMethodScope();
        visitChildren(ctx);
        if (visit(ctx.return_value)!=DataType.BOOLEAN){
            throw new CompilerException("Method return error! Required type:boolean! At method name: "+name);
        }
        symbolTable = symbolTable.closeMethodScope();
        return DataType.BOOLEAN;
    }


    @Override
    public DataType visitMethodDeclaration(GrammarParser.MethodDeclarationContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        VariableSymbol symbol = symbolTable.lookUpLocal(name);
        DataType type = symbolTable.getTypeEnum(ctx.type.getText());
        if (symbol != null) {
            throw  new CompilerException("Variable " + name + " already defined.");
        }
        symbolTable.add(name, type ,true);
        dataTypes.put(ctx,symbolTable.lookUp(name).getType());
        scope.put(ctx,symbolTable);
        return symbolTable.lookUp(name).getType();
    }

    @Override
    public DataType visitExpmethod_call(GrammarParser.Expmethod_callContext ctx) {
        dataTypes.put(ctx,visit(ctx.method_call()));
        return DataType.BOOLEAN;
    }

    @Override
    public DataType visitMethod_call(GrammarParser.Method_callContext ctx) {
        String identifier = ctx.IDENTIFIER().getText();
        String name = identifier + '@';
        if (ctx.expression_list() != null) {
            // Evaluate the arguments in the call first.
            visitChildren(ctx.expression_list());

            // Now that each of the expression types is known, check them against the method signature.
            for (ParseTree expr : ctx.expression_list().children) {
                // Skip the comma that separates expressions.
                if (!(",".equals(expr.getText()))) {
                    name += symbolTable.getTypeLetter(dataTypes.get(expr));
                }
            }
        }
        VariableSymbol symbol = symbolTable.lookUp(name);

        if (symbol == null) {
            String typeDescritors = name.substring(name.indexOf('@')+1);
            String message = "Method " + identifier + "(";
            boolean firstArg = true;
            for(char c : typeDescritors.toCharArray()) {
                if (firstArg) {
                    firstArg = false;
                } else {
                    message += ',';
                }

                message += symbolTable.getTypeName(c);
            }

            message += ") is undefined.";
            throw new CompilerException(message);
        }
        scope.put(ctx, symbolTable);
        return symbol.getType();
    }

}
