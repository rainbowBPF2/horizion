package algorithm;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;

/**
 * Created by pengfei on 2017/9/18.
 */
public class A002 {

    public static void main(String[] args) {

        int array[]=new int []{3,6,18,23, 9,8,9,3};
        BitSet set = new BitSet();
        int count=0;

        for (int i = 0; i < array.length; i++) {
            if (set.get(array[i]) == false)
                set.set(array[i]);
            else
                count++;
        }

        System.out.println("duplicate:"+count);

    }

    public static void getUniqueArray(int[] array) {
        int i = 0;

        if (array.length <= 1) return;

        for (int j = i + 1; j < array.length; j++) {
            if (array[i] != array[j])
                array[++i] = array[j];
        }

        System.out.println(i + 1);

    }

    public static String strMul(String s1, String s2) {
        int a = Integer.valueOf(s1);
        int b = Integer.valueOf(s2);

        long result = a * b * 1L;
        System.out.println(result);

        return null;
    }

    public static void printInfo(String s1, String s2, String base) {

        if (isEmpty(s1) && isEmpty(s2))
            return;

        if (isEmpty(s1)) {
            System.out.println(base + s2);
            return;
        }
        if (isEmpty(s2)) {
            System.out.println(base + s1);
            return;
        }


        printInfo(s1.substring(1), s2, base + s1.charAt(0));

        printInfo(s1, s2.substring(1), base + s2.charAt(0));


    }

    private static boolean isEmpty(String s) {
        if (s == null || s.length() == 0)
            return true;
        return false;
    }

    private static void storeCode() {
        String s = "lilian";
        s.substring(1);

        boolean[] check = new boolean[256];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);

            if (check[index]) {
                System.out.println("false");
                break;
            } else
                check[index] = true;
        }
    }

    private static void yihuo() {
        int arr[] = {3, 3, 5, 6, 6, 7, 8, 7, 8};

        int temp = arr[0];
        for (int i = 1; i < arr.length; i++)
            temp = temp ^ arr[i];
        System.out.println(temp);
    }

    public static boolean checkPac(int[] array, int k) {
        if (k <= 0)
            return false;

        int[] mod = new int[k];
        for (int num : array)
            mod[num % k]++;

        if (mod[0] % 2 != 0)
            return false;

        if (k % 2 == 0) {
            if (mod[k / 2] % 2 != 0)
                return false;
        }

        for (int i = 1; i < k / 2; i++) {
            if (mod[i] != mod[k - i])
                return false;
        }

        return true;
    }

    public static int findRandom(int[] array, int max, int min) {
        Arrays.sort(array);
        int range = max - min + 1;

        Random random = new Random();
        int result = random.nextInt(range) + min;
        while (Arrays.binarySearch(array, result) >= 0)
            result = random.nextInt(range) + min;

        return result;
    }

    public int binarySearch(int[] array, int key) {
        Arrays.sort(array);

        int start = 0, end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (array[mid] == key)
                return mid;
            else if (array[mid] > key) {
                end = mid - 1;
            } else
                start = mid + 1;
        }

        return -1;
    }

    public void mergeArray(int[] arrayA, int[] arrayB) {
        int m = arrayA.length;
        int n = arrayB.length;

        while (n > 0) {
            if (arrayA[m - 1] < arrayB[n - 1] || m < 0) {
                arrayA[m + n - 1] = arrayB[n - 1];
                n--;
            } else {
                arrayA[m + n - 1] = arrayA[m - 1];
                m--;
            }
        }

    }

    public static int[] findArray(int[][] matrix, int m, int n) {
        int left = 0, right = n - 1, up = 0, down = m - 1;
        int count = m * n;
        int result[] = new int[count];
        while (count > 0) {
            for (int j = left; j <= right; j++) {
                System.out.print(matrix[up][j] + " ");
                if (--count == 0) break;
            }
            up++;

            for (int j = up; j <= down; j++) {
                System.out.print(matrix[j][right] + " ");
                if (--count == 0) break;
            }
            right--;

            for (int j = right; j >= left; j--) {
                System.out.print(matrix[down][j] + " ");
                if (--count == 0) break;
            }
            down--;

            for (int j = down; j >= up; j--) {
                System.out.print(matrix[j][left] + " ");
                if (--count == 0) break;
            }
            left++;
        }

        return null;
    }

    public static void parseInt(int num) {
        while (num > 0) {
            int mod = num % 10;
            System.out.println(mod);

            num = (num - mod) / 10;
        }

    }

    public static void preOrder(BiTree root) {
        if (root != null) {
            visit(root);
            preOrder(root.left);
            preOrder(root.right);
        }

    }

    public static void midOrder(BiTree root) {
        if (root != null) {
            midOrder(root.left);
            visit(root);
            midOrder(root.right);
        }
    }

    public static void afterOrder(BiTree root) {
        if (root != null) {
            afterOrder(root.left);
            afterOrder(root.right);
            visit(root);
        }
    }


    public static void visit(BiTree node) {
        if (node != null)
            System.out.println(node.data);
    }

    public static int getDeep(BiTree root) {
        if (root == null)
            return 0;
        else {
            int d1 = getDeep(root.left);
            int d2 = getDeep(root.right);
            int max = Math.max(d1, d2) + 1;
            return max;
        }

    }

//    public static int getPathSum(BiTree root){
//        if(root.left==null&&root.right==null)
//            return 0;
//        else{
//            int d1=getPathSum(root.left)+1;
//            int d2=getPathSum(root.right)+1;
//        }
//
//
//        return 0;
//    }

}

class BiTree {
    public int data;
    public BiTree left;
    public BiTree right;

    public BiTree(int data){
        this.data=data;
    }
}
