package algorithm;

import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

/**
 * Created by pengfei on 2017/9/19.
 */
public class BitSetLearn {

    public static void main(String[] args) throws InterruptedException, NoSuchAlgorithmException {
        BitSet set = new BitSet(1000);

        int dupNum = 0;
        for (int i = 0; i < 1000; i++) {
            int index = (int) (Math.random()*1000);

            if (set.get(index)) {
                dupNum++;
            } else {
                set.set(index,true);
            }
        }
        System.out.println("duplicate:" + dupNum);
        System.out.println(set);
    }
}
