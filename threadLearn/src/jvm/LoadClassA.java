package jvm;

/**
 * Created by pengfei on 2017/9/7.
 */
public class LoadClassA {

    public static void main(String[] args) throws ClassNotFoundException {


        Class<?> obj=Class.forName("jvm.Example");
        System.out.println(obj.getName());
    }

}

class Example{
    static {
        System.out.println("Init Example");
    }
}
