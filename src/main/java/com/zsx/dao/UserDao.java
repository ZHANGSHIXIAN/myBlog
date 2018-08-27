package com.zsx.dao;

import com.zsx.bean.UserDto;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    /**
     * 根据用户名查询  用户名是唯一的
     * @param userDto
     */
    int queryUser(@Param("userDto") UserDto userDto);

    /**
     * 增加一个用户 插入的行数0代表失败
     * @param name
     * @param password
     * @return
     */
    int insertUser(String name,String password);


}
