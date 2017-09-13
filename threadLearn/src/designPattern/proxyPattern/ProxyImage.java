package designPattern.proxyPattern;

/**
 * Created by pengfei on 2017/9/4.
 */
public class ProxyImage implements Image {
    private RealImage image;
    private String fileName;

    public ProxyImage(String fileName){
       this.fileName=fileName;
    }

    @Override
    public void display() {
        if(image==null){
            image=new RealImage(fileName);
        }

        image.display();
    }
}
