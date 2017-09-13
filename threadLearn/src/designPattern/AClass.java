package designPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pengfei on 2017/9/4.
 */
public abstract class AClass {

    public static void test() {
        System.out.println("hello abstract class");
        List<Integer> list=new ArrayList<>();

        List list2= Collections.synchronizedList(list);
        String str="";

        try {
            Object obj=Class.forName("String").newInstance();

            System.out.println(obj.getClass());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        test();
    }
}
