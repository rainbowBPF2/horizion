package designPattern.visitor;



/**
 * Created by pengfei on 2017/9/10.
 */
public interface Visitor {

    public void visit(Mouse mouse);
    public void visit(Monitor monitor);
    public void visit(KeyBoard keyBoard);
    public void visit(Computer Computer);
}
