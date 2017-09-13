package threadSea;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pengfei on 2017/8/22.
 */
public class AtomicLearn {
    public static void main(String[] args) {

        AtomicClass base = new AtomicClass();

        for (int i = 0; i < 5; i++) {
            Thread a = new Thread(base);
            a.start();
        }
    }
}

class AtomicClass extends Thread {

    private volatile int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++)
            System.out.println(Thread.currentThread().getName() + "\t" + (count++));
    }
}

class AtomicClass2 extends Thread {

    private AtomicInteger integer = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++)
            System.out.println(Thread.currentThread().getName() + "\t" + integer.addAndGet(1));
    }
}
