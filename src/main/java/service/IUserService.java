package service;

import domain.UserInfo;

import java.util.Map;

/**
 * Created by pengfei on 2017/9/12.
 */
public interface IUserService {

    public void addUser(UserInfo info);

    public void deleteUser(UserInfo info);

    public UserInfo queryUser(UserInfo info);
}
