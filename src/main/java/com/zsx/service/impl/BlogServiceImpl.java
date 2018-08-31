package com.zsx.service.impl;

import com.zsx.bean.Blog;
import com.zsx.bean.Page;
import com.zsx.bean.UserDto;
import com.zsx.dao.BlogDao;
import com.zsx.enums.ResultEnum;
import com.zsx.exception.MyBlogException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * blogService接口实现类
 */
@Service
public class BlogServiceImpl implements com.zsx.service.BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public Map<String, Object> getBlogList(long userId, int type, String currentPage,String like) {
        //获得查询总条数
        int count=blogDao.queryBlogCount(userId, type,like);
        //page对象去计算分页信息
        Page page=new Page(count);
        page.setCurrentPage(Integer.parseInt(currentPage));
        page.count();

        List<Blog> list=new ArrayList<Blog>();
        list = blogDao.queryAllblogByUserId(userId, type,like ,page);
        for (Blog blog : list){
            //截取博文前60个字符作为摘要 用于首页博客列表展示
            blog.setContentHtml(stripHT(blog.getContentHtml()));
        }
        Map<String,Object> objectMap=new HashMap<String,Object>();
        objectMap.put("list", list);
        objectMap.put("page", page);

        return objectMap;
    }

    /**
     * 通过博客id获得blog
     * @param blogId
     * @return
     */
    @Override
    public Blog getBlogById(long blogId) {
        //mybatis直接映射返回的是blog对象
        return blogDao.queryBlogById(blogId);
    }

    /**
     * 插入一篇博客
     * @param blog
     * @throws Exception
     */
    @Override
    public void insertBlog(Blog blog) throws Exception{
        //result代表影响了多少条数据
        int result=blogDao.insertBlog(1001, blog);
        if (result>0){
            //插入成功or失败 通过自定义的异常返回resultenum
            throw new MyBlogException(ResultEnum.SUBMIT_SUCCESS);
        }else {
            throw new MyBlogException(ResultEnum.SUBMIT_FAIL);
        }
    }

    /**
     * 通过id删除一篇博客
     * @param blogId
     * @throws Exception
     */
    @Override
    public void deleteBlog(String blogId) throws Exception {
        if (null != blogId && "" != blogId) {
            //result代表影响了多少条数据
            int result = blogDao.deleteBlogById(Long.parseLong(blogId));
            if (result > 0) {
                //删除成功or失败 通过自定义的异常返回resultenum
                throw new MyBlogException(ResultEnum.DELETE_SUCCESS);
            } else {
                throw new MyBlogException(ResultEnum.DELETE_FAIL);
            }
        }
    }

    //截取前60个字符当作博客列表的摘要
    public static String stripHT(String strHtml) {
        String txtcontent = strHtml.replaceAll("</?[^>]+>", ""); //剔出<html>的标签
        txtcontent = txtcontent.replaceAll("<a>\\s*|\t|\r|\n</a>", "");//去除字符串中的空格,回车,换行符,制表符
        if (txtcontent.length()>60){
            txtcontent=txtcontent.substring(0, 60);
        }
        return txtcontent;
    }

}
