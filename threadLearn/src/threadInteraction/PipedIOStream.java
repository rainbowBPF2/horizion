package threadInteraction;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by pengfei on 2017/8/25.
 */
public class PipedIOStream {
    public static void main(String[] args) {

        IOBase ioObj = new IOTool();
        PipedInputStream input = new PipedInputStream();
        PipedOutputStream output = new PipedOutputStream();

        try {
            output.connect(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ReadThread read = new ReadThread(ioObj, input);
        WriteThread write = new WriteThread(ioObj, output);
        read.start();
        write.start();

    }

}

interface IOBase {
    public void readData(PipedInputStream input);

    public void writeData(PipedOutputStream output);
}

class IOTool implements IOBase {
    public void readData(PipedInputStream input) {

        try {
            System.out.println("Read begin");
            byte[] btArry = new byte[20];
            int readLen = input.read(btArry);

            while (readLen != -1) {
                String temp = new String(btArry, 0, readLen);
                System.out.print(temp);
                readLen = input.read(btArry);
            }

            System.out.println();
            input.close();
            System.out.println("Read end");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeData(PipedOutputStream output) {
        System.out.println("Write begin");
        String name = Thread.currentThread().getName();
        try {
            for (int i = 0; i < 100; i++) {
                String tempData = i+" ";
                output.write(tempData.getBytes());

                System.out.print(tempData);
            }
            output.close();
            System.out.println();
            System.out.println("Write end");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReadThread extends Thread {
    private IOBase ioObj;
    private PipedInputStream input;

    public ReadThread(IOBase ioObj, PipedInputStream input) {
        this.ioObj = ioObj;
        this.input = input;
    }

    @Override
    public void run() {
        ioObj.readData(input);
    }
}

class WriteThread extends Thread {

    private IOBase ioObj;
    private PipedOutputStream output;

    public WriteThread(IOBase ioObj, PipedOutputStream output) {
        this.ioObj = ioObj;
        this.output = output;
    }

    @Override
    public void run() {
        ioObj.writeData(output);
    }
}
