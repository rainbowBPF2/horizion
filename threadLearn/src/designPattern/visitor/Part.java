package designPattern.visitor;

/**
 * Created by pengfei on 2017/9/10.
 */
public interface Part {
    public void accept(Visitor visitor);
}

class Mouse implements Part {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Monitor implements Part {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class KeyBoard implements Part {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Computer implements Part {
    private Part[] parts = new Part[]{new Mouse(), new KeyBoard(), new Monitor()};


    @Override
    public void accept(Visitor visitor) {
        for (int i = 0; i < parts.length; i++)
            parts[i].accept(visitor);
        visitor.visit(this);
    }
}
