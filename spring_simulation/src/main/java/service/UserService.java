package service;

import bean.User;
import factory.BeansFactory;
import mapper.UserMapper;

/*
模拟service
 */
public class UserService {

//    UserMapper userMapper = new UserMapper();
    UserMapper userMapper = (UserMapper) BeansFactory.getObject("userMapper");

    public void saveUser(User user) {
        System.out.println("========saveUser***开始保存user==========");
        userMapper.saveUser(user);
        System.out.println("========saveUser***保存user结束==========");
    }
}
