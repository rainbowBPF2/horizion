package jvm;

import com.sun.glass.ui.Size;

/**
 * Created by pengfei on 2017/9/6.
 */
public class GCTest{

    private final int SIZE=1024*1024;

    private byte[] bytes=new byte[2*SIZE];

    public Object instance=null;

    public static void main(String[] args) {
        GCTest obj1=new GCTest();
        GCTest obj2=new GCTest();

        obj1.instance=obj2;
        obj2.instance=obj1;

        obj1=null;
        obj2=null;

        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
