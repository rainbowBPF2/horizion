package threadInteraction;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by pengfei on 2017/9/5.
 */
public class PC_MQ {
    public static void main(String[] args) {
        MessageQueue mq = new MessageQueue();

        Thread th1 = new ThProducer(mq);
        Thread th2 = new ThConsumer(mq);

        th1.start();
        th2.start();

    }
}

class ThProducer extends Thread {
    private MessageQueue messageQueue;

    public ThProducer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        messageQueue.setMessage("Producer");
    }
}

class ThConsumer extends Thread {
    private MessageQueue messageQueue;

    public ThConsumer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        messageQueue.getMessage();
    }
}


class MessageQueue {
    private LinkedList<String> list = new LinkedList<String>();
    private final int QUEUE_SIZE = 5;

    public void setMessage(String message) {
        while (true) {
            synchronized (list) {
                try {
                    if (list.size() >= QUEUE_SIZE)
                        list.wait();

                    list.add(new Date().toString());
                    System.out.println("Setting message" + Thread.currentThread().getName());
                    Thread.sleep(1000);
                    if (list.size() == QUEUE_SIZE)
                        list.notifyAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void getMessage() {
        while (true) {
            synchronized (list) {
                try {
                    if (list.size() == 0)
                        list.wait();

                    String message = list.remove();
                    System.out.println("Getting message:" + message + Thread.currentThread().getName());
                    Thread.sleep(1000);
                    if (list.size() == 0)
                        list.notifyAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

