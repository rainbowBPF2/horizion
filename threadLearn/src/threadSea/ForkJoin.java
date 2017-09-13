package threadSea;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by pengfei on 2017/9/8.
 */
public class ForkJoin {

    public static void main(String[] args) {
        double[] values = new double[1000000];

        for (int i = 0; i < values.length; i++)
            values[i] = Math.random();

        Filter filter = new Filter() {
            @Override
            public boolean accept(double d) {
                return d > 0.5 ? true : false;
            }
        };

        Counter counter = new Counter(values, 0, values.length, filter);
        int result = counter.invoke();
        System.out.println("Count:" + result);

//        ForkJoinPool pool = new ForkJoinPool();
//        pool.invoke(counter);
//        System.out.println(counter.join());

    }
}

interface Filter {
    boolean accept(double d);
}

class Counter extends RecursiveTask<Integer> {
    private Filter filter;
    private int from;
    private int to;
    private double[] values;
    private final int SIZE = 1000;

    public Counter(double[] values, int from, int to, Filter filter) {
        this.values = values;
        this.from = from;
        this.to = to;
        this.filter = filter;
    }


    @Override
    protected Integer compute() {
        if (to - from < SIZE) {
            int count = 0;
            for (int i = from; i < to; i++) {
                if (filter.accept(values[i]))
                    count++;
            }
            return count;
        } else {
            int mid = (from + to) / 2;
            Counter c1 = new Counter(values, from, mid, filter);
            Counter c2 = new Counter(values, mid, to, filter);
            invokeAll(c1, c2);
            return c1.join() + c2.join();
        }
    }
}
