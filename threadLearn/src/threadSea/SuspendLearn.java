package threadSea;

/**
 * Created by pengfei on 2017/8/21.
 */
public class SuspendLearn {

    public static void main(String[] args) {
        try {
            final BaseObject obj = new BaseObject();

            Thread threadA = new Thread() {
                @Override
                public void run() {
                    obj.printString();
                }
            };

            threadA.setName("A");
            threadA.start();
            Thread.sleep(1000);

            Thread threadB=new Thread(){
                @Override
                public void run() {
                    System.out.println("ThreadB start");
                    obj.printString();
                    System.out.println("ThreadB end");

                }
            };


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}

class BaseObject {

    public synchronized void printString() {

        System.out.println("Base object begin");

        if (Thread.currentThread().getName().equalsIgnoreCase("A")) {
            System.out.println("Begin suspend");
            Thread.currentThread().suspend();
        }
        System.out.println("End suspend");
    }

}
