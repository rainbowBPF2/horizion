package threadSea;

/**
 * Created by pengfei on 2017/8/21.
 */
public class YieldLearn {
    public static void main(String[] args) {
        YieldObject obj=new YieldObject();
        obj.start();
    }
}

class YieldObject extends Thread{
    private long COUNT=1000000L;

    @Override
    public void run() {
        long  start=System.currentTimeMillis();
        for(int i=0;i<COUNT;i++){
//            Thread.yield();
        }
        long end=System.currentTimeMillis();

        System.out.println("During time:"+ (end-start));

    }
}
