package dao;

import java.util.List;

/**
 * Created by pengfei on 2017/9/2.
 */
public interface UserDao {
    public int saveUserData(Object obj);

    public void delUser(Object obj);

    public Object findUser(int userID);

    public Object findUser(String userName);

    public List findAllUser();
}
