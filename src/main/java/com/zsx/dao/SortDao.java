package com.zsx.dao;

import com.zsx.bean.Sort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SortDao {

    /**
     * 新增一个分类
     * @param name
     * @param userId
     */
    int insertSort(@Param("name") String name, @Param("userId") long userId);

    /**
     * 查询一个分类
     * @param name
     * @param userId
     * @return
     */
    Sort querySortByName(@Param("name") String name, @Param("userId") long userId);

    /**
     * 删除一个分类
     * @param name
     * @param userId
     */
    int deleteSort(@Param("name") String name,@Param("userId") long userId);

    List<Sort> querySortList(@Param("userId") long userId);
}
