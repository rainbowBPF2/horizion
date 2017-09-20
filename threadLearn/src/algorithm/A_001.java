package algorithm;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by pengfei on 2017/9/18.
 */
public class A_001 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = in.nextInt();
        for (int i : array)
            System.out.print(i+" ");

        System.in.read();

    }
}
