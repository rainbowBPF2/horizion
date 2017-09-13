package jvm;

/**
 * Created by pengfei on 2017/9/6.
 */
public class TestVm {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception{
        byte[] all1, all2, all3;
        all1 = new byte[_1MB / 4];

        all2 = new byte[4 * _1MB];
        all3 = new byte[4 * _1MB];
        all3 = null;

        all3 = new byte[4 * _1MB];

        for(int i=0;i<200;i++)
            Thread.sleep(1000);

    }
}
