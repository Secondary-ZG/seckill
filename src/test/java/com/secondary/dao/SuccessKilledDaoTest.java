package com.secondary.dao;

import com.secondary.entity.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Secondary on 2017/8/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        long id = 1L;
        long phone = 18716302547L;
        int insertCount = successKilledDao.insertSuccessKilled(id,phone);
        System.out.println("insetCount = " + insertCount);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long id = 1L;
        long phone = 17764540313L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id,phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }

}