package threadInteraction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by pengfei on 2017/8/26.
 */
public class TimerLearn {
    private static Timer timer = new Timer(true);

    public static void main(String[] args) {
        try {

            MyTask task = new MyTask();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse("2017-8-26 19:03:30");
            timer.schedule(task, date,1000);
            System.out.println("Main end");

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

class MyTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("Task running here");
    }
}