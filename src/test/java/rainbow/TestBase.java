package rainbow;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by pengfei on 2017/8/21.
 */
public class TestBase extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }


    public void testAdd(){
        int a =3;
        int b=4;
        Assert.assertEquals("Message",7,a+b);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
