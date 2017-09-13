package designPattern.proxyPattern;

/**
 * Created by pengfei on 2017/9/4.
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Display:" + this.fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading file:" + fileName);
    }
}
