package mapper;

import bean.User;

/*
模拟持久层mapper
 */
public class UserMapper {

    public void saveUser(User user) {
        System.out.println("========UserMapper***保存user==========");
        System.out.println(user);
    }
}
