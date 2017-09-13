package algorithm;

/**
 * Created by pengfei on 2017/9/9.
 */
public class Update {
    public static void main(String[] args) {
        LazyLoad obj = new LazyLoad();
        System.out.println(obj.hashCode());
    }
}

class Base {
    public void draw() {

        System.out.println("Base draw");
    }
}

class Child extends Base {
    public void draw() {

        System.out.println("Child draw");
    }
}

class LazyLoad {

    Base base;

    static {
        System.out.println("init");
    }

    public LazyLoad() {
        System.out.println("Construct");
    }

}
