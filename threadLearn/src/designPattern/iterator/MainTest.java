package designPattern.iterator;

/**
 * Created by pengfei on 2017/9/10.
 */
public class MainTest {

    public static void main(String[] args) {
        NameRepo repo = new NameRepo();
        for (Iterator iter = repo.getIter(); iter.hasNext(); ) {
            String s = (String) iter.next();
            System.out.println("Result:" + s);

        }
    }
}
