package com.dyw.test;


import com.dyw.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void aopTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = (UserService) ac.getBean("userService");
//        String user = userService.getUser();
//        System.out.println(user);

        userService.saveUser("test");
    }
}
