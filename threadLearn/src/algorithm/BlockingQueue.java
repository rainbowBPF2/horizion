package algorithm;

import java.util.LinkedList;

/**
 * Created by pengfei on 2017/9/19.
 */
public class BlockingQueue {

    private LinkedList list;
    private final int limit;

    public BlockingQueue(int limit){
        this.limit=limit;
        list=new LinkedList();
    }

    public void set(int data) throws InterruptedException {
        synchronized (list){
            while(list.size()==limit)
                list.wait();

            list.add(data);

            list.notifyAll();

        }
    }

    public int get() throws InterruptedException {
        synchronized (list){
            while(list.size()==0)
                list.wait();

            int result= (int) list.pop();

            list.notifyAll();

            return result;

        }
    }

}
