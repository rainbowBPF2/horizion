package designPattern.ResponChain;

/**
 * Created by pengfei on 2017/9/4.
 */
public abstract class AbstractLogger {
    public final int DEBUG = 1;
    public final int INFO = 2;
    public final int ERROR = 3;

    protected int level;

    private AbstractLogger next;

    public void setNext(AbstractLogger next) {
        this.next = next;
    }

    abstract void write(String message);

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (next != null) {
            next.logMessage(level, message);
        }
    }

}
