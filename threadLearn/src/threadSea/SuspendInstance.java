package threadSea;

/**
 * Created by pengfei on 2017/8/21.
 */
public class SuspendInstance {
    public static void main(String[] args) {

        try {
            final Instance obj=new Instance();

            Thread A=new Thread(){
                @Override
                public void run() {
                    obj.setValue("A","AA");
                }
            };

            A.setName("InstanceA");
            A.start();
            Thread.sleep(500);


            Thread instanceB=new Thread(){
                @Override
                public void run() {
                    obj.printUserInfo();
                }
            };
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Instance {
    private String userName = "jack";
    private String password = "jack";

    public void setValue(String userName, String password) {

        this.userName = userName;
        if (Thread.currentThread().getName().equals("InstanceA")) {
            Thread.currentThread().suspend();
        }
        this.password = password;
    }

    public void printUserInfo() {
        System.out.println(this.userName+" \t"+this.password);
    }


}
