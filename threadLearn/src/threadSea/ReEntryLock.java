package threadSea;

/**
 * Created by pengfei on 2017/8/21.
 */
public class ReEntryLock {
    public static void main(String[] args) {
        ThreadHere thread = new ThreadHere();
        thread.start();// synchronized, reentry lock.
    }
}

class ThreadHere extends Thread {
    @Override
    public void run() {
        TestObject obj = new TestObject();
        obj.serviceA();
    }
}

class TestObject {

    public synchronized void serviceA() {
        System.out.println("Service A ");
        serviceB();
    }

    public synchronized void serviceB() {
        System.out.println("Service B");
        serviceC();
    }

    public synchronized void serviceC() {
        System.out.println("Service C");
    }
}
