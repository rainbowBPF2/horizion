package threadSea;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by pengfei on 2017/9/8.
 */
public class BlockingQueueLearn {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Object> queue=new BlockingQueue<>(10);

        Thread th1=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    String str=new Date().toString();
                    queue.put(str);
                    System.out.println("put "+str);
                }
            }
        });


        Thread th2=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    String str=(String)queue.get();
                    System.out.println("get "+str);
                }
            }
        });

        th1.start();
        th2.start();

    }

    private static void mockProduction() throws InterruptedException {
        BlockingQueue<Integer> queue = new BlockingQueue<>(100);

        ExecutorService service = Executors.newFixedThreadPool(15);


        for (int i = 0; i < 500; i++) {

            final int data = i;
            Thread th1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    queue.put(data);
                    System.out.println("Put data:" + data + " " + Thread.currentThread().getName());

                }
            });

            Thread th2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        int result = queue.get();
                        System.out.println("Get result:" + result + " " + Thread.currentThread().getName());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            service.submit(th1);
            if (i % 100 == 0)
                service.submit(th2);

        }

        service.shutdown();
        service.awaitTermination(10, TimeUnit.SECONDS);
    }

    private static void testGeneric() {
        Generic<Integer> ge = new Generic<>();
        ge.put(3);
        System.out.println(ge.get());
    }
}

class BlockingQueue<T> {

    private LinkedList<T> list = new LinkedList<T>();
    private int size = 0;

    public BlockingQueue(int size) {
        this.size = size;
    }

    public void put(T obj) {
        synchronized (list) {
            try {
                while (list.size() >= size)
                    list.wait();

                list.add(obj);
                Thread.sleep(1000);
                list.notifyAll();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public T get() {
        synchronized (list) {
            try {
                while (list.size() <= 0)
                    list.wait();
                T obj = list.pop();
                Thread.sleep(1000);
                list.notifyAll();
                return obj;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

class Generic<T> {

    private List<T> list = new ArrayList<T>();

    public void put(T obj) {
        list.add(obj);
    }

    public T get() {

        T obj = list.get(0);
        System.out.println("Get result:" + obj);
        return obj;
    }
}


