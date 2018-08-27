package com.zsx.service.impl;

import com.zsx.bean.Blog;
import com.zsx.bean.Page;
import com.zsx.dao.BlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements com.zsx.service.BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public Map<String, Object> getBlogList(long userId, int type, String currentPage,String like) {
        //获得查询总条数
        int count=blogDao.queryBlogCount(userId, type,like);
        Page page=new Page(count);
        page.setCurrentPage(Integer.parseInt(currentPage));
        page.count();

        List<Blog> list=new ArrayList<Blog>();
        list = blogDao.queryAllblogByUserId(userId, type,like ,page);
        for (Blog blog : list){
            blog.setContentHtml(stripHT(blog.getContentHtml()));
        }
        Map<String,Object> objectMap=new HashMap<String,Object>();
        objectMap.put("list", list);
        objectMap.put("page", page);

        return objectMap;
    }

    @Override
    public Blog getBlogById(long blogId) {
        return blogDao.queryBlogById(blogId);
    }

    @Override
    public int insertBlog(Blog blog) {
        int result=blogDao.insertBlog(1001, blog);
        return result;
    }

    @Override
    public int deleteBlog(String blogId) {
        int result=blogDao.deleteBlogById(Long.parseLong(blogId));
        return result;
    }

    public static String stripHT(String strHtml) {
        String txtcontent = strHtml.replaceAll("</?[^>]+>", ""); //剔出<html>的标签
        txtcontent = txtcontent.replaceAll("<a>\\s*|\t|\r|\n</a>", "");//去除字符串中的空格,回车,换行符,制表符
        if (txtcontent.length()>60){
            txtcontent=txtcontent.substring(0, 60);
        }
        return txtcontent;
    }

}
