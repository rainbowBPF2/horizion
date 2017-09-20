package algorithm;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by pengfei on 2017/9/19.
 */
public class Test {
    public static void main(String[] args) {
        BitSet set = new BitSet();
        set.set(8);
        int cnt = set.cardinality();


        System.out.println("count:" + cnt);
        System.out.println(set.size());
        System.out.println(set);
    }
}
