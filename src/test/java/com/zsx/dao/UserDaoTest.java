package com.zsx.dao;

import com.zsx.bean.User;
import com.zsx.bean.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-dao.xml"})
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @org.junit.Test
    public void queryUserByName() {
        UserDto user=new UserDto();
        user.setPassword("");
        user.setName("");
        System.out.println("==============userresult"+userDao.queryUser(user));
    }

    @org.junit.Test
    public void insertUser() {
    }
}