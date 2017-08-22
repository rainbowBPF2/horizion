package threadSea;

/**
 * Created by pengfei on 2017/8/21.
 */
public class SynchronizedBlock {

    public static void main(String[] args) {
        Task task = new Task();
        for (int i = 0; i < 100; i++) {
            BasicThread thA = new BasicThread(task);
            thA.start();
        }
    }
}

class BasicThread extends Thread {

    private Task task;

    public BasicThread(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        Task task = new Task();
        task.doLongTimeTask();
    }
}

class Task {

    private String str1;
    private String str2;

    public void doLongTimeTask() {
        try {
            System.out.println("long time task begin");
            Thread.sleep(3000);
            String s1 = Thread.currentThread().getName();
            String s2 = Thread.currentThread().getName();

            synchronized (this){
                str1 = s1;
                str2 = s2;
            }
            System.out.println(str1);
            System.out.println(str2);
            System.out.println("task end");

        }catch(Exception e){

        }
    }
}
