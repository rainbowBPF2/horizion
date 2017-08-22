package threadSea;

/**
 * Created by pengfei on 2017/8/21.
 */
public class ExtendPriority {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getPriority());
//        Thread.currentThread().setPriority(6);
        System.out.println(Thread.currentThread().getPriority());

        ThreadA threadA = new ThreadA();
        threadA.start();
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getPriority());
        ThreadB obj = new ThreadB();
        obj.start();
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getPriority());
    }
}
