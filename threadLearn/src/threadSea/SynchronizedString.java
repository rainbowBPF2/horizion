package threadSea;

/**
 * Created by pengfei on 2017/8/22.
 */
public class SynchronizedString {

    public static void main(String[] args) {

        UserObject obj = new UserObject();

        for (int i = 0; i < 100; i++) {
            UserObjectThread thA = new UserObjectThread(obj);
            if (i%3==0)
                thA.setPriority(Thread.NORM_PRIORITY+3);

            thA.start();
        }


    }
}

class UserObjectThread extends Thread {

    private UserObject obj;

    public UserObjectThread(UserObject obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.setUserInfo("A", "AA");
    }
}


class UserObject {
    private String str = "obj";// CANNOT BE NULL
    private String userName = null;
    private String pwd = null;

    public void setUserInfo(String userName, String pwd) {
        try {
            synchronized (str) {
                System.out.println("Current Thread enter:" + Thread.currentThread().getName());

                this.userName = userName;
                Thread.sleep(1000);
                this.pwd = pwd;
                System.out.println("Current Thread leave:" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}