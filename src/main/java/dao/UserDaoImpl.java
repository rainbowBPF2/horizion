package dao;

import domain.UserInfo;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by pengfei on 2017/9/1.
 */
@Component("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    public void saveUserData(Object obj) {
        UserInfo user = (UserInfo) obj;
        int userID = this.getSqlSession().insert("USER.insertUser", user);
        System.out.println("Insert user:" + userID);
    }

    public void delUser(Object obj) {
        UserInfo user = (UserInfo) obj;
        this.getSqlSession().delete("USER.deleteUser", user);

        System.out.println("delete user, id:" + ((UserInfo) obj).getId());
    }

    public Object findUser(int userID) {
        UserInfo user = this.getSqlSession().selectOne("USER.findUser", userID);
        return user;

    }

    public Object findUser(String userName) {
        UserInfo user = this.getSqlSession().selectOne("USER.findUserByName", userName);
        return user;

    }

    public List findAllUser() {
        int cnt = this.getSqlSession().selectOne("USER.count");

        System.out.println("User count:" + cnt);

        return this.getSqlSession().selectList("USER.findAll");
    }
}
