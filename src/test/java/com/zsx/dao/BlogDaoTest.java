package com.zsx.dao;

import com.zsx.bean.Blog;
import com.zsx.bean.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-dao.xml"})
public class BlogDaoTest {
    @Autowired
    private BlogDao dao;

    @Test
    public void insertBlog() {
//        Blog blog=new Blog();
//        blog.setContent("newcontent3");
//        blog.setTitle("newTitle3");
//        blog.setType(1);
//        blog.setSortId(1);
//        blog.setUserId(1001);
//        dao.insertBlog(1001,blog);
    }

    @Test
    public void deleteBlogById() {
        dao.deleteBlogById(1);
    }

    @Test
    public void updateBlog() {
//        Blog blog=dao.queryBlogById(5);
//        blog.setType(1);
//        blog.setContent("c");
//        int i=dao.updateBlog(blog);
//        if (i>0) {
//            System.out.println("==============更新成功");
//        }

    }

    @Test
    public void queryAllblogByUserId() {
//        Page page=new Page();
//        page.setTotleNumber(dao.queryBlogCount(1001, 0));
//        page.count();
//        List<Blog> list=dao.queryAllblogByUserId(1001,0,page);
//        for (Blog blog : list){
//            System.out.println("=====blog====="+blog);
//        }
    }

    @Test
    public void queryBlogById() {
        System.out.println(dao.queryBlogById(2));
    }
}