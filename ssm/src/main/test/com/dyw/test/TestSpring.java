package com.dyw.test;

import com.dyw.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void run1() {
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        //获取对象
        AccountService as = (AccountService) ac.getBean("accountService");

        as.findAll();
    }
}
