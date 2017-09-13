package designPattern.visitor;

/**
 * Created by pengfei on 2017/9/10.
 */
public class VisitorImpl implements Visitor {
    @Override
    public void visit(Mouse mouse) {
        System.out.println("Visit Mouse");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Visit monitor");
    }

    @Override
    public void visit(KeyBoard keyBoard) {
        System.out.println("Visit keyboard");
    }

    @Override
    public void visit(Computer Computer) {
        System.out.println("Visit computer");
    }
}
