package threadSea;

/**
 * Created by pengfei on 2017/8/21.
 */
public class RunFast {

    public static void main(String[] args) throws InterruptedException {
        ThreadA1 obj = new ThreadA1();
        obj.setDaemon(true);
        obj.start();

        Thread.sleep(10000);
        System.out.println("Main thread end!");

        Object group=Thread.currentThread().getThreadGroup();
        System.out.println(group.toString());
    }

}

class ThreadA1 extends Thread {

    private int count = 1;

    public int getCount() {
        return this.count;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!isInterrupted()) {
                    count++;
                    System.out.println(count);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class ThreadA2 extends Thread {

    private int count = 1;

    public int getCount() {
        return this.count;
    }

    @Override
    public void run() {
        while (true) {
            if (!isInterrupted())
                count++;
        }
    }
}

