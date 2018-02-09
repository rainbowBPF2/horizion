package rainbow;

import org.junit.*;

/**
 * Created by pengfei on 2017/9/13.
 */
public class TestJunit {

    @BeforeClass
    public static void testBeforeClass() {
        System.out.println("before class");
    }

    @Before
    public void init() {
        System.out.println("init here");
    }

    @Test
    public void testAandB() {
        int a = 3;
        int b = 4;
        Assert.assertEquals(7, (a + b));
    }

    @Test(expected=AssertionError.class)
    public void testAsubB() {
        int a = 3;
        assert a > 5;
        int b = 5;
        Assert.assertEquals(-1, (a - b));
    }

    @Ignore
    public void testIgnore() {
        System.out.println("ignore");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");

    }
}
