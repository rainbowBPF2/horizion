package threadInteraction;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pengfei on 2017/8/26.
 */
public class FairLockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        System.out.println(lock.isFair());
    }
}


class FairLockLearn {
    private ReentrantLock lock;

    public FairLockLearn(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void doJob() {
        lock.lock();
        System.out.println("Job running");
        System.out.println(lock.getHoldCount());
        doJobB();
        lock.unlock();
    }


    public void doJobB() {
        lock.lock();
        System.out.println("Inner lock");
        System.out.println(lock.getHoldCount());
        lock.unlock();
    }
}
