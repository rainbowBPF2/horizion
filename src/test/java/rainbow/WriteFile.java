package rainbow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by pengfei on 2017/9/24.
 */
public class WriteFile {
    private static WriteFile instance=new WriteFile();

    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir")+"/temp/temp.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(new File("").getAbsolutePath());

        FileOutputStream out = new FileOutputStream(file);

        out.write("new file".getBytes());

        out.close();

    }
}
