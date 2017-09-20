package algorithm;

/**
 * Created by pengfei on 2017/9/19.
 */
public class TreeLearn {

    public static void main(String[] args) {

        System.out.println(calcPower(2,4));

        int n=3;
        System.out.println(n&n-1);


    }

    public static int calcPower(int base, int n) {
        if (n == 0)
            return 1;

        int half = calcPower(base, n / 2);
        if (n % 2 == 0)
            return half * half;
        if (n > 0)
            return half * half * base;
        else
            return half * half / base;

    }


    private static int findFiboN(int n) {
        if (n <= 2)
            return 1;

        int cnt = 2;
        int a = 1, b = 1, result = 0;

        while (cnt < n) {
            result = a + b;
            a = b;
            b = result;
            cnt++;
        }

        return result;
    }

    private static void testTreeOrder() {
        String s = "";
        BiTree root = new BiTree(0);
        BiTree l1 = new BiTree(1);
        BiTree l2 = new BiTree(2);
        BiTree l3 = new BiTree(3);
        BiTree l4 = new BiTree(4);
        BiTree l5 = new BiTree(5);
        BiTree l6 = new BiTree(6);
        BiTree l7 = new BiTree(7);

        l4.left = l5;
        l4.right = l6;

        l1.left = l4;
        l1.right = l3;
        l3.right = l2;

        root.left = l1;
        root.right = l7;
        preOrder(root, s);
    }

    private static void preOrder(BiTree root, String s) {
        if (root != null) {
            visit(root, s);
            preOrder(root.left, s + " " + root.data);
            preOrder(root.right, s + " " + root.data);
        }

    }

    private static void visit(BiTree node, String s) {
        if (node != null) {
            System.out.println(node.data);
            if (node.left == null && node.right == null)
                System.out.println(s + " " + node.data);
        }
    }

}


