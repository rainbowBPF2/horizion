package threadSea;

/**
 * Created by pengfei on 2017/8/22.
 */
public class SynchronizedObject {
    public static void main(String[] args) {
        ThreadA01 th1 = new ThreadA01();
        ThreadA02 th2 = new ThreadA02();
        th1.start();
        th2.start();
    }
}

class ThreadA01 extends Thread {
    @Override
    public void run() {
        MyService.print(new Object());
    }
}


class ThreadA02 extends Thread {
    @Override
    public void run() {
        MyService.print(new Object());
    }
}

class MyService {
    public static void print(Object obj) {
        try {
            synchronized (obj) {
                while (true) {
                    System.out.println("Current Thread:" + Thread.currentThread().getName());
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}