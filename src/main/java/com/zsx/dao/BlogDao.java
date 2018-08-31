package com.zsx.dao;

import com.zsx.bean.Blog;
import com.zsx.bean.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.weaving.DefaultContextLoadTimeWeaver;

import java.util.List;

//Blog接口
public interface BlogDao {

    /**
     * 新增一篇文章
     * @param blog
     */
    int insertBlog(@Param("userId") long userId, @Param("blog") Blog blog);

    /**
     * 删除一篇博客
     * @param blogId
     */
    int deleteBlogById(long blogId);

    /**
     * 更改博客
     */
    int updateBlog(@Param("blog")Blog blog);

    /**
     * 查询某用户的所有博客
     * @param userId
     * @param type 过滤私有博客 1为公开 0私有 null都查询
     */
    List<Blog> queryAllblogByUserId(@Param("userId") long userId,@Param("type")int type,@Param("like") String like,@Param("page")Page page);

    /**
     * 根据博客ID查询
     * @param blogId
     */
    Blog queryBlogById(long blogId);

    /**
     * 查询博客记录数
     * @param userId
     * @param type 过滤私有博客 1为公开 0私有 null都查询
     * @return
     */
    int queryBlogCount(@Param("userId") long userId,@Param("type") int type,@Param("like") String like);

}
