package com.zsx.service;

import com.zsx.bean.Blog;
import com.zsx.bean.UserDto;

import java.util.Map;

public interface BlogService {


    /**
     * 获取博客列表
     * @param userId
     * @param type
     * @return
     */
    public Map<String, Object> getBlogList(long userId, int type, String currentPage,String like);

    /**
     * 获取单条博客信息
     * @param blogId
     * @return
     */
    public Blog getBlogById(long blogId);


    public void insertBlog(Blog blog) throws Exception;

    public void deleteBlog(String blogId) throws Exception;




}
