package threadInteraction;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pengfei on 2017/8/25.
 */
public class ConditionNotify {
    public static void main(String[] args) throws InterruptedException {
        ConditionObject obj = new ConditionObject();
        ThA tha = new ThA(obj);
        ThB thb = new ThB(obj);
        tha.start();
        thb.start();
        Thread.sleep(3000);
        obj.signalAll_A();
    }
}

class ThA extends Thread {

    private ConditionObject obj;

    public ThA(ConditionObject obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        this.obj.awaitA();
    }
}

class ThB extends Thread {

    private ConditionObject obj;

    public ThB(ConditionObject obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        this.obj.awaitB();
    }
}


class ConditionObject {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("A wait begin");
            conditionA.await();

            System.out.println("A wait end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println("B wait begin");
            conditionB.await();
            System.out.println("B wait end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_A() {
        try {
            lock.lock();
            System.out.println("A signal all begin");
            conditionA.signalAll();
            System.out.println("A signal all end");
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_B() {
        try {
            lock.lock();
            System.out.println("B signal all begin");
            conditionB.signalAll();
            System.out.println("B signal all end");
        } finally {
            lock.unlock();
        }
    }
}