package threadInteraction;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by pengfei on 2017/8/26.
 */
public class ReadWriteLock {
    public static void main(String[] args) {
        MyLock lock = new MyLock();

        WriteTh write = new WriteTh(lock);
        write.start();

        for (int i = 0; i < 10; i++) {
            ReadTh read = new ReadTh(lock);
            read.start();
        }
    }
}

class ReadTh extends Thread {

    private MyLock lock;

    public ReadTh(MyLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.read();
    }
}

class WriteTh extends Thread {
    private MyLock lock;

    public WriteTh(MyLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.write();
    }
}

class MyLock {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            lock.readLock().lock();
            System.out.println("Read here:" + Thread.currentThread().getName());
            Thread.sleep(10000);
            System.out.println("Read Over:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println("Write here:" + Thread.currentThread().getName());
            Thread.sleep(10000);
            System.out.println("Write Over:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
