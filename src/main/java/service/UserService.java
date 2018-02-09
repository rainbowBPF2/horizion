package service;

import dao.UserDao;
import domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pengfei on 2017/9/2.
 */
@Service("UserService")
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserInfo getUserInfo(int id) {
        UserInfo obj = (UserInfo) userDao.findUser(id);
        return obj;
    }


    public List<UserInfo> getUserList() {
        List<UserInfo> list = userDao.findAllUser();
        return list;
    }
}
