package com.dyw.test;

import com.dyw.dao.AccountDao;
import com.dyw.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    SqlSession sqlSession;

    @Before
    public void load() throws IOException {
        System.out.println("Before");
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

//        创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 创建SQLSession对象
        sqlSession = factory.openSession();
    }

    @Test
    public void testFindAll() throws IOException {

        // 获取到代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        List<Account> all = accountDao.findAll();

        all.stream().forEach(System.out::println);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("娜娜").setMoney(1000d);

        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        accountDao.saveAccount(account);
        sqlSession.commit(); //提交事务
    }

    @After
    public void close() {
        System.out.println("After");
        sqlSession.close();
    }
}
