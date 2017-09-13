package threadInteraction;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pengfei on 2017/8/25.
 */
public class ReentrantWaitNotify {
    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA tha = new ThreadA(service);
        ThreadB thb = new ThreadB(service);
        tha.start();
        thb.start();

        ReentrantLock lock=new ReentrantLock();
        lock.hasQueuedThreads();
    }
}

class ThreadA extends Thread {
    private MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        this.service.get();

    }
}

class ThreadB extends Thread {
    private MyService service;

    public ThreadB(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        this.service.set();

    }
}

class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private volatile String value = "";

    public void get() {
        while (true) {
            try {
                lock.lock();
                while (value.equals(""))
                    condition.await();

                System.out.println(Thread.currentThread().getName() + " get" + value);
                this.value = "";
                Thread.sleep(1000);
                condition.signalAll();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void set() {
        while (true) {
            try {
                lock.lock();
                while (!value.equals(""))
                    condition.await();
                this.value = System.currentTimeMillis() + "";

                System.out.println(Thread.currentThread().getName() + " set " + this.value);
                Thread.sleep(1000);
                condition.signal();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


}