package designPattern;

/**
 * Created by pengfei on 2017/8/26.
 */
public class SingleTest {
    public static void main(String[] args) {

    }
}

class SingleObject3 {
    private static SingleObject3 instance = new SingleObject3();

    private SingleObject3() {

    }

    public static SingleObject3 getInstance() {
        return instance;
    }
}

class SingleObject1 {
    private static SingleObject1 instance = null;

    private SingleObject1() {

    }

    static {
        instance = new SingleObject1();
    }

    public static SingleObject1 getInstance() {
        return instance;
    }
}

class SingleObject2 {
    private SingleObject2() {
    }

    private static class InnerClass {
        private static SingleObject2 instance = new SingleObject2();
    }

    public static SingleObject2 getInstance() {
        return InnerClass.instance;
    }
}

