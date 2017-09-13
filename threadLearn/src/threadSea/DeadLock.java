package threadSea;

/**
 * Created by pengfei on 2017/8/22.
 */
public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        DealLock dealLock = new DealLock();

        dealLock.setThName("AA");
        Thread th1 = new Thread(dealLock);
        th1.start();

        Thread.sleep(100);

        dealLock.setThName("BB");
        Thread th2 = new Thread(dealLock);
        th2.start();
    }
}

class DealLock implements Runnable {

    private String thName;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void setThName(String thName) {
        this.thName = thName;
    }

    @Override
    public void run() {
        try {
            if ("AA".equals(thName)) {
                synchronized (lock1) {
                    System.out.println("thName:" + this.thName);
                    Thread.sleep(3000);

                    synchronized (lock2) {
                        System.out.println("lock1 ->lock2");
                    }
                }

            } else {
                synchronized (lock2) {
                    System.out.println("thName:" + this.thName);
                    Thread.sleep(3000);

                    synchronized (lock1) {
                        System.out.println("lock2 ->lock1");
                    }
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}