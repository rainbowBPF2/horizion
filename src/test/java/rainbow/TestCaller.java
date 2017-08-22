package rainbow;

/**
 * Created by pengfei on 2017/8/21.
 */
public class TestCaller {

    public static void main(String[] args) {
        TestBase obj=new TestBase();
        junit.textui.TestRunner.run(obj.getClass());
    }
}
