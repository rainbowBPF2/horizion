package threadInteraction;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pengfei on 2017/8/26.
 */
public class ConditionOrder {
    private static volatile int next = 1;
    private static ReentrantLock lock = new ReentrantLock();
    private final static Condition conB = lock.newCondition();
    private final static Condition conA = lock.newCondition();
    private final static Condition conC = lock.newCondition();

    public static void main(String[] args) {

        Thread thA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (next != 1)
                        conA.await();
                    System.out.println("Running A");

                    next = 2;
                    conB.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        });


        Thread thB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (next != 2)
                        conB.await();
                    System.out.println("Running B");

                    next = 3;
                    conC.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread thC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (next != 3)
                        conC.await();
                    System.out.println("Running C");

                    next = 1;
                    conA.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread[] groupA = new Thread[5];
        Thread[] groupB = new Thread[5];
        Thread[] groupC = new Thread[5];

        for (int i = 0; i < 5; i++) {
            groupA[i] = new Thread(thA);
            groupB[i] = new Thread(thB);
            groupC[i] = new Thread(thC);

            groupA[i].start();
            groupB[i].start();
            groupC[i].start();

        }
        System.out.println("Main end");

    }

}
