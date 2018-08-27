package com.zsx.service.impl;

import com.zsx.bean.User;
import com.zsx.bean.UserDto;
import com.zsx.dao.UserDao;
import com.zsx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int doLogin(UserDto userDto) {
        int result=userDao.queryUser(userDto);
        return result;
    }
}
