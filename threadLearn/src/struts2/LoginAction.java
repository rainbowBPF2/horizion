package struts2;

/**
 * Created by pengfei on 2017/9/15.
 */
public class LoginAction extends ActionSupport {

    private static final long serialVersionUID=1L;
    private String name;
    private String pwd;

    public String getName() {
        return name;

    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String execute(){
        if(getName().equals("linda")&&getPwd().equals("linda"))
            return "success";
        else
            return "error";
    }
}

 abstract class ActionSupport{
    public abstract String execute();
}
