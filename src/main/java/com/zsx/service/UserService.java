package com.zsx.service;

import com.zsx.bean.User;
import com.zsx.bean.UserDto;

import javax.print.attribute.standard.JobOriginatingUserName;

public interface UserService {

    public int doLogin(UserDto userDto);

}
