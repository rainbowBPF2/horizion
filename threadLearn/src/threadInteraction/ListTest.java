package threadInteraction;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by pengfei on 2017/8/24.
 */
public class ListTest {
    public static void main(String[] args) {

        System.out.println("Main start");

        List<Integer> list = new ArrayList<Integer>();
        Executor pool = Executors.newFixedThreadPool(3);

        Runnable obj = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running here");
            }
        };
        Thread th = new Thread(obj);
        th.start();

        System.out.println("Main end;");
    }
}
