package rainbow;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReviewJava {

    public static void main(String[] args) {
        testForLoop();
    }

    private static void testMapContain() {
        Map map = new HashMap<String, String>();

        map.put("a", "b");
        map.put("aa", "b");

        boolean foundTarget = map.containsKey("aa");

        System.out.println(foundTarget);
    }


    public static void testForLoop() {

        int[] array = new int[]{0, 1, 2, 3};

        for (int i : array) {
            System.out.println(i);
            System.out.println();

            ReadWriteLock lock = new ReentrantReadWriteLock();
            lock.readLock().lock();
            try {

            } finally {
                lock.readLock().unlock();
            }


        }


        StringBuffer buffer=new StringBuffer("Hello ");

        buffer.append("hello boy!");

        System.out.println(buffer.toString());

        StringBuffer buffer2=new StringBuffer("hello boy2!");


    }

    private String name2 ="linda";
    private int age;


    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public static final int num=0;


    public static final String name="USER";




}
