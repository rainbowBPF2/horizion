package rainbow;

import org.springframework.context.annotation.Bean;

/**
 * Created by pengfei on 2017/9/15.
 */


public class UserBean {

    public void add(){

    }

    @Bean
    public UserBean userBean(){
        return new UserBean();
    }
}
