package rainbow;

import dao.UserDao;
import dao.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * Created by pengfei on 2017/9/14.
 */

@Configuration
@Import({Annotation1.class,MapLearn.class,JedisTest.class})
public class AnnotationB {

    @Bean(initMethod = "")
    @Scope("singleton")
    public UserDao userDao() {
        return new UserDaoImpl();
    }


    public void test(){

    }
}
