/*
package jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

*/
/**
 * Created by pengfei on 2017/9/6.
 *//*

public class UnSafeMem {
    private static final int _1M=1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField=Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);

        Unsafe unsafe=(Unsafe) unsafeField.get(null);
        while(true){
            unsafe.allocateMemory(_1M);
        }//本地内存，直接溢出。

    }
}
*/
