package algorithm;

import java.util.Arrays;

/**
 * Created by pengfei on 2017/9/18.
 */
public class PathCount {
    private static int count = 0;

    public static void main(String[] args) {
        int[] array = {8, 1, 9, 3, 2, 4,9,10,11,19,23,32};

        Arrays.sort(array);
        int start = 0, end = 0, max = 0;

        if (array.length <= 1)
            System.out.println("max:"+1);

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1] + 1 || array[i] == array[i - 1]) {
                end++;
                max = Math.max(max, end - start+1);
            } else {
                System.out.println("start: "+start+"end :"+end);
                start = i;
                end = i;
            }
        }

        System.out.println("max:"+max);
    }

    private static void testFindPath() {
        int[][] array = {{0, 2, 1, 0, 5}, {0, 0, 0, 0, 2}, {0, 0, 0, 3, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 2, 0}};

        String s = "0";

        findPath(array, 0, 4, s);

        System.out.println("find path:" + count);
    }

    //Deep first search.
    private static void findPath(int[][] array, int start, int end, String s) {

        if (s.contains(end + "")) {
            System.out.println(s);
            count++;
            return;
        }

        for (int j = 0; j < array.length; j++) {
//            if(s.contains(j+""))
//                continue;

            if (array[start][j] > 0) {
                findPath(array, j, end, s + j);
            }
        }
    }
}
