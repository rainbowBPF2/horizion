package jvm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by pengfei on 2017/9/7.
 */
public class LoadClassB {

    public static void main(String[] args) {
        try {
            ClassLoader loader = ExampleB.class.getClassLoader();
            Class obj = loader.loadClass("jvm.ExampleB");

            System.out.println(obj.getName());
            Method main = obj.getMethod("main", new Class[]{String[].class});
            main.invoke(null, new String[]{null});

            Method privateMethod = obj.getMethod("getSum", int.class);
            privateMethod.setAccessible(true);
            privateMethod.invoke(null, 3);

            Method[] methods = obj.getDeclaredMethods();
            for (Method m : methods) {
                System.out.print("Line:" + m.getName() + " ");
                System.out.print(m.getReturnType() + " ");
                System.out.print(m.getModifiers() + " ");
                System.out.println(m.getParameterCount());
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}

class ExampleB {
    static {
        System.out.println("Init ExampleB");
    }

    public static void main(String[] args) {
        System.out.println("main running");
    }

    private void getSum(int a) {
        System.out.println("Sum is:"+a);
        //TODO

    }

    private int getStatus() {
        return 0;
    }

    protected Object findParent() {
        return null;
    }


}
