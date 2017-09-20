package algorithm;

/**
 * Created by pengfei on 2017/9/20.
 */
public class FindTreeDepth {

    public static void main(String[] args) {
        BiTree root = new BiTree(0);
        BiTree l1 = new BiTree(1);
        BiTree l2 = new BiTree(2);
        BiTree l3 = new BiTree(3);
        BiTree l4 = new BiTree(4);
        BiTree l5 = new BiTree(5);
        BiTree l6 = new BiTree(6);
        BiTree l7 = new BiTree(7);

//        l4.left = l5;
//        l4.right = l6;
//
//        l1.left = l4;
//        l1.right = l3;
//        l3.right = l2;
//
//        root.left = l1;
//        root.right = l7;
        root.left=l1;
        l1.left=l2;
        l2.left=l3;
        l3.left=l4;
        l4.left=l5;

        int deep = findDeep(root);
        System.out.println("deep:" + deep);
    }

    private static int findDeep(BiTree root) {
        if (root != null) {
            if (root.left == null && root.right == null)
                return 1;
            else {
                int leftDeep = findDeep(root.left);
                int rightDeep = findDeep(root.right);
                int max = Math.max(leftDeep, rightDeep) + 1;
                return max;
            }
        }
        return 0;
    }
}
