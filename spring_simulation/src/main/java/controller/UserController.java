package controller;

import bean.User;
import factory.BeansFactory;
import service.UserService;

/*模拟controller
 */
public class UserController {

//    UserService userService = new UserService();

    UserService userService = (UserService) BeansFactory.getObject("userService");

    public void addUser(User user) {
        System.out.println(userService);
        userService.saveUser(user);
    }

    public static void main(String[] args) {
        User user = new User();
        user.setId(1).setName("zhangsan").setGender("male");
        for (int i=0; i<5; i++) {
            new UserController().addUser(user);
        }

    }
}
