package nl.saxion.cos;

import java.util.HashMap;

/**
 * @author YangCheng
 * @date 3/13/2022 2:47 AM
 */
public class SymbolTable {
    private int nextIndex = 1;
    private static int counter = 0;
    private  int methodCounter;
    private SymbolTable parentScope;
    private final HashMap<String,VariableSymbol> symbols;
    public SymbolTable(int offset){
        this.nextIndex = offset;
        this.methodCounter=counter;
        this.symbols = new HashMap<>();
    }
    public void add(String name,DataType type,boolean assign){
        symbols.put(name,new VariableSymbol(name,type,nextIndex,assign));

        if (type == DataType.DOUBLE ) {
            nextIndex += 2;
        } else {
            nextIndex++;
        }
        if(nextIndex>=Visitor.lcounter){
            throw new CompilerException("stack out of limit! ");
        }
    }
    public VariableSymbol lookUp(String name){
        VariableSymbol symbol = symbols.get(name);
        if(symbol ==null && parentScope !=null && methodCounter==parentScope.methodCounter){
            symbol = parentScope.lookUp(name);
        }
        return symbol;
    }
    public VariableSymbol lookUpLocal(String name) {
        return symbols.get(name);
    }

    public SymbolTable openScope(){
        return createScope(nextIndex);
    }

    public SymbolTable openMethodScope() {
        counter++;
        return createScope(0);
    }
    public SymbolTable closeMethodScope(){
        counter--;
        return parentScope;
    }
    public SymbolTable getParentScope(){
        return parentScope;
    }


    private SymbolTable createScope(int offset) {
        SymbolTable childScope = new SymbolTable(offset);
        childScope.parentScope = this;

        return childScope;


    }


    public char getTypeLetter(String type) {
        switch (type) {
            case "Floor":
                return 'i';
            case "Finish":
                return 'b';
            case "Name":
                return 's';
            case "Room":
                return 'd';
            default:
                return '?';
        }
    }

    public char getTypeLetter(DataType type) {
        switch (type) {
            case INT:
                return 'i';
            case BOOLEAN:
                return 'b';
            case STRING:
                return 's';
            case DOUBLE:
                return 'd';
            default:
                return '?';
        }
    }

    public DataType getTypeEnum(String type) {
        switch (type) {
            case "Floor":
                return DataType.INT;
            case "Finish":
                return DataType.BOOLEAN;
            case "Name":
                return DataType.STRING;
            case "Room":
                return DataType.DOUBLE;
            default:
                return DataType.UNKNOWN;
        }
    }

    public String getTypeName(char c) {
        switch (c) {
            case 'i':
                return "Floor";
            case 'b':
                return "Finish";
            case 's':
                return "Name";
            case 'd':
                return "Room";
            default:
                return "unknown";
        }
    }
}
