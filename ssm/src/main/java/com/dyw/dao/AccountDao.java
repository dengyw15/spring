package com.dyw.dao;

import com.dyw.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface AccountDao {

    @Select("select * from account")
    List<Account> findAll();

    @Insert("insert into account(name, money) values (#{name}, #{money})")
    void saveAccount(Account account);
}
