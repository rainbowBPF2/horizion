package rainbow;

/**
 * Created by pengfei on 2017/8/26.
 */
public class TestStatic {
    public static void main(String[] args) {
        User u1 = new User();
        u1.name = "linda";
        User u2 = new User();
        u2.name = "jack";

        System.out.println(u1.name);
        System.out.println(u2.name);
    }
}

class User {
    public static String name = null;
}
