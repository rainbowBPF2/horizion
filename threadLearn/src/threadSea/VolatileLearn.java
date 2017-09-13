package threadSea;

/**
 * Created by pengfei on 2017/8/22.
 */
public class VolatileLearn {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main begin");
        ThA tha = new ThA();
        tha.start();

        Thread.sleep(3000);
        tha.setStatus(false);
        System.out.println("Main end");

    }
}

class ThA extends Thread {

    private volatile boolean toRun = true; // read data from main system memory, not thread stack.

    public void setStatus(boolean newStatus) {
        this.toRun = newStatus;
    }

    @Override
    public void run() {
        System.out.println("Thread Begin:");

        try {
            while (toRun) {
            }
            System.out.println("Thread end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
