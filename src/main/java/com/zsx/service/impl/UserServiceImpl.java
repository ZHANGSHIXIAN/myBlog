package com.zsx.service.impl;

import com.zsx.bean.UserDto;
import com.zsx.dao.UserDao;
import com.zsx.enums.ResultEnum;
import com.zsx.exception.MyBlogException;
import com.zsx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * userservice接口的实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 登陆操作
     * @param userDto  页面传递过来的name、password
     * @throws Exception
     */
    @Override
    public void doLogin(UserDto userDto) throws Exception{
        int result=userDao.queryUser(userDto);
        if (result>0){
            throw new MyBlogException(ResultEnum.LOGIN_SUCCESS);
        }else {
            throw new MyBlogException(ResultEnum.LOGIN_FAIL);
        }

    }
}
