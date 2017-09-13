package designPattern;

import java.io.*;

/**
 * Created by pengfei on 2017/8/27.
 */
public class SerializableLearn {


    public static void main(String[] args) {
        SeriObject obj = SeriObject.getInstance();

        seriMethod(obj, "d:\\save.txt");
        deSeriMethod("d:\\save.txt");


    }

    private static void seriMethod(SeriObject obj, String fileName) {
        try {
            FileOutputStream output = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(output);

            out.writeObject(obj);


            out.close();
            output.close();

            System.out.println(obj.hashCode());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deSeriMethod(String fileName) {
        try {
            FileInputStream input = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(input);
            SeriObject obj = (SeriObject) in.readObject();

            in.close();
            input.close();
            System.out.println(obj.hashCode());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class SeriObject implements Serializable {
    private static final long serialVersionUID = 888L;
    private String userName="linda";
    private SeriObject() {
    }

    private static class InnerClass {
        private static SeriObject instance = new SeriObject();
    }

    public static SeriObject getInstance() {
        return InnerClass.instance;
    }

    protected Object readResolve() {
        return InnerClass.instance;
    }
}
