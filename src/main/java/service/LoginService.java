package service;

import domain.UserInfo;

import java.util.Map;

/**
 * Created by pengfei on 2017/9/12.
 */
public interface LoginService {

    public void addUser(UserInfo info);

    public void deleteUser(UserInfo info);

    public UserInfo queryUser(UserInfo info);

    public boolean checkUserAccess(String userName, String pwd);
}
