package service;

import Utility.BasicTool;
import Utility.RedisCache;
import com.alibaba.fastjson.JSON;
import dao.UserDao;
import domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by pengfei on 2017/9/12.
 */

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private UserDao userDao;

    public void addUser(UserInfo info) {
        this.userDao.saveUserData(info);
        System.out.println("Service:add user");
    }

    public void deleteUser(UserInfo info) {
        this.userDao.delUser(info);
        System.out.println("Service:delete user");
    }

    public UserInfo queryUser(UserInfo info) {

        //First check Redis redisCache.
        String userJsonValue = (String) this.redisCache.get("user:" + info.getId());
        if (!StringUtils.isEmpty(userJsonValue)) {
            UserInfo result = JSON.parseObject(userJsonValue, UserInfo.class);
            System.out.println("Cache got");
            return result;
        }

        //If redis not found, check Database.
        UserInfo user = (UserInfo) this.userDao.findUser(info.getId());

        //Save in Redis.
        this.redisCache.set("user:" + info.getId(), user);
        System.out.println("DB got");
        return user;
    }

    public boolean checkUserAccess(String userName, String pwd){
        UserInfo user=(UserInfo) userDao.findUser(userName);

        String expectedMd5= BasicTool.getMd5Info(pwd);

        if (user ==null ||!user.getPassword().equals(expectedMd5)){
            return false;
        }else{
            return true;
        }
    }
}
