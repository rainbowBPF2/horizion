package threadInteraction;

/**
 * Created by pengfei on 2017/8/25.
 */
public class PCThread {

    public static void main(String[] args) {
        Object lock = new Object();
        Producer th1 = new Producer(lock);
        Consumer th2 = new Consumer(lock);

        th1.start();
        th2.start();

    }
}

class Common {
    public static String value = "";
}

class Producer extends Thread {
    private Object lock;

    public Producer(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock) {
            while (true) {
                try {
                    if (!Common.value.equals("")) {
                        lock.wait();
                    }
                    Common.value = System.currentTimeMillis()+"";
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " \t" + Common.value);
                    lock.notifyAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

class Consumer extends Thread {

    private Object lock;

    public Consumer(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock) {
            while (true) {
                try {
                    if (Common.value.equals("")) {
                        lock.wait();
                    }
                    System.out.println(Thread.currentThread().getName() + " \t" + Common.value);
                    Common.value = "";
                    Thread.sleep(1000);
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}