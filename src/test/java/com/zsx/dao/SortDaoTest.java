package com.zsx.dao;

import com.zsx.bean.Sort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-dao.xml"})
public class SortDaoTest {

    @Autowired
    private SortDao sortDao;

    @Test
    public void insertSort() {
        sortDao.insertSort("c++", 1001);

    }

    @Test
    public void querySortByName() {
        System.out.println("=============="+sortDao.querySortByName("c++", 1002));
    }

    @Test
    public void deleteSort() {
        int i=sortDao.deleteSort("c++", 1001);
        System.out.println("===========影响了"+i+"条数据");
    }

}