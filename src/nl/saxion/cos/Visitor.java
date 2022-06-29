package nl.saxion.cos;

import java.util.ArrayList;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import javax.lang.model.element.VariableElement;

/**
 * @author YangCheng
 * @date 3/2/2022 2:19 AM
 */

//3/4/2022
public class Visitor extends GrammarBaseVisitor<ArrayList<String>>{

    private final ParseTreeProperty<DataType> dataTypes;
    private final ParseTreeProperty<SymbolTable> scope;
    private int sign = 0;
    public static int lcounter = 998;

    //if have method
    public static Boolean haveMethod = false;
    public static ArrayList<ArrayList<String>> method = new ArrayList<>();

    //if argument contains "||" or "&&".
    public static Boolean haveLogic = false;
    public Visitor(ParseTreeProperty<DataType> dataTypes, ParseTreeProperty<SymbolTable> scope){
        this.dataTypes = dataTypes;
        this.scope = scope;
    }

    public String uniqueSign() {
        return "L" + sign++;
    }

    public int loopCounter(){
        if (lcounter<0){
            throw new CompilerException("stack out of limit! ");
        }
        return lcounter--;
    }

    @Override
    public ArrayList<String> visitProgram(GrammarParser.ProgramContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        for (ParseTree child : ctx.children) {
            ArrayList<String> result = visit(child);
            if(result!=null){
                data.addAll(visit(child));
            }
        }
        return data;
    }


    @Override
    public ArrayList<String> visitStatement(GrammarParser.StatementContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        for(ParseTree child : ctx.children) {
            ArrayList<String> result = visit(child);
            if (result != null){
                data.addAll(visit(child));
            }
        }
        return data;
    }

    @Override
    public ArrayList<String> visitExpInt(GrammarParser.ExpIntContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        data.add("ldc "+ctx.getText());
        return data;
    }

    @Override
    public ArrayList<String> visitExpAdd(GrammarParser.ExpAddContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        if(ctx.expression()!=null){
            data.addAll(visit(ctx.left));
            data.addAll(visit(ctx.right));
            if(dataTypes.get(ctx)==DataType.INT && ctx.op.getText().equals("+")){
                data.add("iadd ");
            }else if(dataTypes.get(ctx)==DataType.DOUBLE && ctx.op.getText().equals("+")){
                data.add("dadd");
            }else if(dataTypes.get(ctx)==DataType.INT && ctx.op.getText().equals("-")){
                data.add("isub");
            }else if(dataTypes.get(ctx)==DataType.DOUBLE && ctx.op.getText().equals("-")){
                data.add("dsub");
            }
        }
        return data;
    }

    @Override
    public ArrayList<String> visitExpMul(GrammarParser.ExpMulContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        if(ctx.expression()!=null){
            data.addAll(visit(ctx.left));
            data.addAll(visit(ctx.right));
            if(dataTypes.get(ctx)==DataType.INT && ctx.op.getText().equals("*")){
                data.add("imul ");
            }else if(dataTypes.get(ctx)==DataType.DOUBLE && ctx.op.getText().equals("*")){
                data.add("dmul");
            }else if(dataTypes.get(ctx)==DataType.INT && ctx.op.getText().equals("/")){
                data.add("idiv");
            }else if(dataTypes.get(ctx)==DataType.DOUBLE && ctx.op.getText().equals("/")){
                data.add("ddiv");
            }
        }
        return data;
    }


    @Override
    public ArrayList<String> visitExpParentheses(GrammarParser.ExpParenthesesContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        data.addAll(visit(ctx.expression()));
        return data;
    }

    @Override
    public ArrayList<String> visitExpDou(GrammarParser.ExpDouContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        data.add("ldc2_w "+ctx.getText());
        return data;
    }

    @Override
    public ArrayList<String> visitExpStr(GrammarParser.ExpStrContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        data.add("ldc "+ctx.getText());
        return data;
    }

    @Override
    public ArrayList<String> visitExpBool(GrammarParser.ExpBoolContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        data.add("ldc " + (ctx.BOOLEAN().getText().equals("yes") ? "1" : "0"));
        return data;
    }

    @Override
    public ArrayList<String> visitPrint(GrammarParser.PrintContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        data.add("getstatic java/lang/System/out Ljava/io/PrintStream;");
        data.addAll(visit(ctx.expression()));
        if(dataTypes.get(ctx.expression())==DataType.BOOLEAN){
            data.add("invokevirtual java/io/PrintStream/println(Z)V");
        }else if(dataTypes.get(ctx.expression())==DataType.DOUBLE){
            data.add("invokevirtual java/io/PrintStream/println(D)V");
        }else if (dataTypes.get(ctx.expression())==DataType.STRING){
            data.add("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
        }else if(dataTypes.get(ctx.expression())==DataType.INT){
            data.add("invokevirtual java/io/PrintStream/println(I)V");
        }
        return data;
    }

    @Override
    public ArrayList<String> visitExpNegate(GrammarParser.ExpNegateContext ctx) {
        ArrayList<String> data = new ArrayList<>();
       data.addAll(visit(ctx.expression())) ;
        if(dataTypes.get(ctx)==DataType.INT){
            data.add("ineg");
        }else if(dataTypes.get(ctx)==DataType.DOUBLE){
            data.add("dneg");
        }

        return data;
    }



    @Override
    public ArrayList<String> visitIfStatement(GrammarParser.IfStatementContext ctx) {
        boolean haveElse= false;
        //t = true
        String t = uniqueSign();
        String end = uniqueSign();
        //check if have "else"
        for (ParseTree child : ctx.children) {
            if(child.getText().equals("else")){
                haveElse = true;
            }
        }
        ArrayList<String> data = new ArrayList<>();
        data.addAll(visit(ctx.expression()));
        data.add("ldc 1");
        //if false && hav else, goto else
        data.add("if_icmpne "+t);
        for (var statement: ctx.statement()) {
                data.addAll(visit(statement));
        }
        data.add("goto "+end);
        data.add(t+":");
        if(haveElse){
            data.addAll(visit(ctx.falseStatement()));
        }
        data.add(end+":");

        return data;
    }

    @Override
    public ArrayList<String> visitFalseStatement(GrammarParser.FalseStatementContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        for (var statement: ctx.statement()) {
            data.addAll(visit(statement));
        }
        return data;
    }

    @Override
    public ArrayList<String> visitExpCompare(GrammarParser.ExpCompareContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        String a = uniqueSign();
        String end = uniqueSign();
        if(ctx.expression()!=null){
            data.addAll(visit(ctx.left));
            data.addAll(visit(ctx.right));
            //compare Double/Int/Boolean value
            if(dataTypes.get(ctx)!=DataType.STRING ){
                //Double
                if(dataTypes.get(ctx)==DataType.DOUBLE){
                    data.add("dcmpl ");
                    data.add("ldc 0");
                }
                //Int/Boolean
                if(ctx.op.getText().equals(">")){
                    data.add("if_icmple "+a);
                }else if(ctx.op.getText().equals("<")){
                    data.add("if_icmpge "+a);
                }else if(ctx.op.getText().equals("==")){
                    data.add("if_icmpne "+a);
                }else if(ctx.op.getText().equals("!=")){
                    data.add("if_icmpeq "+a);
                }else if(ctx.op.getText().equals(">=")){
                    data.add("if_icmplt "+a);
                }else if(ctx.op.getText().equals("<=")){
                    data.add("if_icmpgt "+a);
                }
            }
            //String
            else if(dataTypes.get(ctx)==DataType.STRING){
                if(ctx.op.getText().equals("==")){
                    data.add("if_acmpne "+a);
                }else if(ctx.op.getText().equals("!=")){
                    data.add("if_acmpeq "+a);
                }
            }
            //return true
            data.add("ldc 1");
            data.add("goto "+end);
            data.add(a+":");
            //a: return false
            data.add("ldc 0");
            //end
            data.add(end+":");
        }
        return data;
    }

    @Override
    public ArrayList<String> visitExpEqual(GrammarParser.ExpEqualContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        String a = uniqueSign();
        String end = uniqueSign();
        if(ctx.expression()!=null){
            data.addAll(visit(ctx.left));
            data.addAll(visit(ctx.right));

            data.add("invokevirtual java/lang/String.equals(Ljava/lang/Object;)Z");
            data.add("ifeq " +a);
            //return true
            data.add("ldc 1");
            data.add("goto "+end);
            data.add(a+":");
            //a: return false
            data.add("ldc 0");
            //end
            data.add(end+":");
        }

        return  data;
    }



    @Override
    public ArrayList<String> visitExpLogic(GrammarParser.ExpLogicContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        haveLogic = true;
            if(ctx.op.getText().equals("||")) {
                String F1 = uniqueSign();
                String F2= uniqueSign();
                String end = uniqueSign();
                //check left
                data.addAll(visit(ctx.left));
                data.add("ldc 1");
                data.add("if_icmpne " + F1);
                data.add("ldc 1");
                //if left == true , return true.
                data.add("goto "+end);
                //if left == false,check right.
                data.add(F1+":");
                data.addAll(visit(ctx.right));
                data.add("ldc 1");
                data.add("if_icmpne " + F2);
                data.add("ldc 1");
                //return true if right== true.
                data.add("goto "+end);
                //return false if right also == false.
                data.add(F2+": ");
                data.add("ldc 0");
                data.add(end + ":");
            }else if(ctx.op.getText().equals("&&")){
                String F1 = uniqueSign();
                String end = uniqueSign();
                //check left.
                data.addAll(visit(ctx.left));
                data.add("ldc 1");
                //if left ==false ,return false.
                data.add("if_icmpne " + F1);
                //check right.
                data.addAll(visit(ctx.right));
                data.add("ldc 1");
                //if right ==false, return false.
                data.add("if_icmpne " + F1);
                //if left==true right==true, return true.
                data.add("ldc 1");
                data.add("goto "+end);
                data.add(F1+": ");
                data.add("ldc 0");
                data.add(end + ":");
            }

        return data;
    }

    @Override
    public ArrayList<String> visitLoop(GrammarParser.LoopContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        //init unique number & sign
        String x = uniqueSign();
        String y = uniqueSign();
        int counter = loopCounter();
        data.add("ldc 0");
        data.add("istore "+counter);
        data.add(x+": ");
        data.add("iload "+counter);
        data.add("ldc "+ctx.INT());
        data.add("if_icmpge "+y);
        //statement
        for (ParseTree child : ctx.children) {
            ArrayList<String> result = visit(child);
            if(result!=null){
                data.addAll(visit(child));
            }
        }
        data.add("iinc "+counter+" 1");
        data.add("goto "+x);
        data.add(y+":");

        return data;
    }


    @Override
    public ArrayList<String> visitAssignment(GrammarParser.AssignmentContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        VariableSymbol symbol = scope.get(ctx).lookUp(name);
        ArrayList<String> data = new ArrayList<>();
        data.addAll(visit(ctx.expression()));
        //int & boolean
        if(dataTypes.get(ctx)==DataType.INT ||dataTypes.get(ctx)==DataType.BOOLEAN){
            data.add("istore " + symbol.getIndex());
        }
        //double
        else if(dataTypes.get(ctx)==DataType.DOUBLE){
            data.add("dstore " + symbol.getIndex());
        }
        //String
        else if(dataTypes.get(ctx)==DataType.STRING){
            data.add("astore " + symbol.getIndex());
        }
        return data;
    }

    @Override
    public ArrayList<String> visitDeclaration(GrammarParser.DeclarationContext ctx) {
        Boolean Assign = false ;
        String name = ctx.IDENTIFIER().getText();
        VariableSymbol symbol = scope.get(ctx).lookUp(name);
        ArrayList<String> data = new ArrayList<>();
        for (ParseTree child : ctx.children) {
            if(child.getText().equals("=")){
               Assign = true;
            }
        }
        if(Assign){
            data.addAll(visit(ctx.expression()));
            //int & boolean
            if(dataTypes.get(ctx)==DataType.INT ||dataTypes.get(ctx)==DataType.BOOLEAN){
                data.add("istore " + symbol.getIndex());
            }
            //double
            else if(dataTypes.get(ctx)==DataType.DOUBLE){
                data.add("dstore " + symbol.getIndex());
            }
            //String
            else if(dataTypes.get(ctx)==DataType.STRING){
                data.add("astore " + symbol.getIndex());
            }
        }
        return data;
    }


    @Override
    public ArrayList<String> visitExpIdentifier(GrammarParser.ExpIdentifierContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        VariableSymbol symbol = scope.get(ctx).lookUp(name);
        ArrayList<String> data = new ArrayList<>();
        if(dataTypes.get(ctx)==DataType.INT || dataTypes.get(ctx)==DataType.BOOLEAN){
            data.add("iload "+symbol.getIndex());
        }else if(dataTypes.get(ctx)==DataType.STRING){
            data.add("aload "+symbol.getIndex());
        }else if(dataTypes.get(ctx)==DataType.DOUBLE){
            data.add("dload "+symbol.getIndex());
        }
        return data;
    }

    @Override
    public ArrayList<String> visitExpScanner(GrammarParser.ExpScannerContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        data.addAll(visit(ctx.scanner()));
        return data;
    }

    @Override
    public ArrayList<String> visitScanner(GrammarParser.ScannerContext ctx) {
        ArrayList<String> data = new ArrayList<>();

        data.add("new java/util/Scanner");
        data.add("dup");
        data.add("getstatic java/lang/System/in Ljava/io/InputStream;");
        data.add("invokenonvirtual java/util/Scanner/<init>(Ljava/io/InputStream;)V");
        data.add("invokevirtual java/util/Scanner/nextLine()Ljava/lang/String;");
        return data;
    }

    @Override
    public ArrayList<String> visitScope(GrammarParser.ScopeContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        for (ParseTree child:ctx.children) {
            ArrayList<String> childData = visit(child);
            if(childData != null){
                data.addAll(childData);
            }
        }
        return  data;
    }

    @Override
    public ArrayList<String> visitMethod(GrammarParser.MethodContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        haveMethod = true;
        String declType = "";
        //declaration type
        for (var decl:ctx.methodDeclaration()) {
            if(dataTypes.get(decl)==DataType.BOOLEAN){
                declType+="Z";
            }
            if(dataTypes.get(decl)==DataType.INT){
                declType+="I";
            }
            if(dataTypes.get(decl)==DataType.STRING){
                declType+="Ljava/lang/String;";
            }
            if(dataTypes.get(decl)==DataType.DOUBLE){
                declType+="D";
            }
        }
        data.add(".method public static "+ ctx.name.getText()+"("+declType+")"+"Z" );
        data.add(".limit stack 999");
        data.add(".limit locals 999");

        //statement
        if(ctx.statement()!=null){
            for (var statement: ctx.statement()) {
                data.addAll(visit(statement));
            }
        }

        data.addAll(visit(ctx.return_value));


        //end method
        data.add("ireturn");
        data.add(".end method");
        method.add(data);
        return null;
    }

    @Override
    public ArrayList<String> visitMethod_call(GrammarParser.Method_callContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        ArrayList<String> data = new ArrayList<>();
        String type = "";
        if(ctx.expression_list()!=null){
            for (var expr:ctx.expression_list().children) {
                ArrayList<String> result = visit(expr);
                if(result!=null){
                    data.addAll(visit(expr));
                }

                if(dataTypes.get(expr)==DataType.BOOLEAN){
                    type+="Z";
                }
                if(dataTypes.get(expr)==DataType.INT){
                    type+="I";
                }
                if(dataTypes.get(expr)==DataType.STRING){
                    type+="Ljava/lang/String;";
                }
                if(dataTypes.get(expr)==DataType.DOUBLE){
                    type+="D";
                }
            }
        }

        data.add("invokestatic hello/"+ctx.name.getText()+"("+type+")"+"Z" );
        return data;
    }

    @Override
    public ArrayList<String> visitExpmethod_call(GrammarParser.Expmethod_callContext ctx) {
        ArrayList<String> data = new ArrayList<>();
        data.addAll(visit(ctx.method_call()));
        return data;
    }


}
