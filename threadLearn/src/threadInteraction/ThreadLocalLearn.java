package threadInteraction;

import java.text.SimpleDateFormat;

/**
 * Created by pengfei on 2017/8/25.
 */
public class ThreadLocalLearn {
    public static void main(String[] args) {
        ThreadLocal obj = new ThreadLocal();
        obj.set("linda");
        System.out.println(obj.get());
    }

}

class DateTool {
    private static ThreadLocal<SimpleDateFormat> map = new ThreadLocal<SimpleDateFormat>();

    public static SimpleDateFormat getSDF(String dataPattern) {
        SimpleDateFormat sdf = null;

        sdf = map.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat(dataPattern);
            map.set(sdf);
        }
        return sdf;
    }
}
