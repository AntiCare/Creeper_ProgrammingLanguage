package nl.saxion.cos;

/**
 * @author YangCheng
 * @date 3/13/2022 2:52 AM
 */
public class VariableSymbol {
    private final String name;
    private final DataType type;
    private final int index;
    private boolean assign;
    public VariableSymbol(String name, DataType type,int index,boolean assign){
        this.name = name;
        this.type = type;
        this.index = index;
        this.assign =assign;
    }

    public DataType getType(){
        return type;
    }
    public String getName(){
        return  name;
    }
    public int getIndex(){
        return index;
    }
    public boolean getAssign(){
        return assign;
    }
    public void setAssign(boolean a){
        assign=a;
    }
}
