package jvm;

/**
 * Created by pengfei on 2017/9/6.
 */
public class StackOverflow {
    public static void main(String[] args) {
        Test obj=new Test();
        try {
            obj.deeper();
        } catch (Exception e) {
            System.out.println(obj.depth);
            throw e;
        }
    }
}

class Test{
    public int depth=0;

    public void deeper(){
        depth++;
        deeper();
    }
}
