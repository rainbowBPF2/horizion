package threadSea;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by pengfei on 2017/9/8.
 */
public class CallableExecutor {
    public static void main(String[] args) {
        try {

            FutureTask<Object> task = new FutureTask<Object>(new CallTask());
            task.run();
            while (task.isDone()) {
                Object obj = task.get();
                System.out.println(obj);
                break;
            }

            Thread th = new Thread(task);
            th.run();

            List<Callable<Object>> list = new ArrayList<Callable<Object>>();
            ExecutorService service = Executors.newFixedThreadPool(10);

            for (int i = 0; i < 10; i++) {

                Callable<Object> cbj = new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        return null;
                    }
                };

                list.add(cbj);

            }

            List<Future<Object>> resultList = service.invokeAll(list);

            for (Future f : resultList) {
                if (f.isDone())
                    System.out.println(f.get());
            }


            service.shutdown();
            service.awaitTermination(300, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CallTask implements Callable {

    @Override
    public Object call() throws Exception {
        int a = 3 + 5;
        System.out.println("a=" + a);
        return a;
    }



}
