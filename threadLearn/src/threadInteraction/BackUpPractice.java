package threadInteraction;

/**
 * Created by pengfei on 2017/8/25.
 */
public class BackUpPractice {
    public static void main(String[] args) {
        DBTool tool = new DBTool();

        for (int i = 0; i < 10; i++) {
            BackUpA thA = new BackUpA(tool);
            BackUpB thB = new BackUpB(tool);
            thA.start();
            thB.start();
        }
    }
}

class BackUpA extends Thread {
    private DBTool tool;

    public BackUpA(DBTool tool) {
        this.tool = tool;
    }

    @Override
    public void run() {
        this.tool.backA();
    }
}

class BackUpB extends Thread {
    private DBTool tool;

    public BackUpB(DBTool tool) {
        this.tool = tool;
    }

    @Override
    public void run() {
        this.tool.backB();
    }
}


class DBTool {
    private volatile boolean isBackA = false;

    public synchronized void backA() {
        try {
            while (!isBackA) {
                wait();
            }

            for (int j = 0; j < 5; j++) {
                System.out.println("******");
            }
            isBackA = false;
            notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void backB() {
        try {
            while (isBackA) {
                wait();
            }

            for (int i = 0; i < 5; i++)
                System.out.println("------");
            isBackA = true;
            notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

