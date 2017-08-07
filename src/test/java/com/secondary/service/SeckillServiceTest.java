package com.secondary.service;import com.secondary.dto.Exposer;import com.secondary.dto.SeckillExecution;import com.secondary.entity.Seckill;import com.secondary.exception.RepeatKillException;import com.secondary.exception.SeckillCloseException;import org.junit.Test;import org.junit.runner.RunWith;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.test.context.ContextConfiguration;import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;import java.util.List;import static org.junit.Assert.*;/** 业务层测试类 * Created by Secondary on 2017/8/7. */@RunWith(SpringJUnit4ClassRunner.class)@ContextConfiguration({"classpath:spring/spring-dao.xml",                       "classpath:spring/spring-service.xml"})public class SeckillServiceTest {    //日志    private final Logger logger = LoggerFactory.getLogger(this.getClass());    @Autowired    private SeckillService seckillService;    @Test    public void getSeckillList() throws Exception {        List<Seckill> list = seckillService.getSeckillList();        logger.info("list={}", list);    }    @Test    public void getById() throws Exception {        long id = 1;        Seckill seckill = seckillService.getById(id);        logger.info("seckill = {}", seckill);    }    @Test    public void SeckillLogic() throws Exception {        long id = 2;        Exposer exposer = seckillService.exportSeckillUrl(id);        if (exposer.isExposed()) {            logger.info("exposer = {}", exposer);            long phone = 17764540317L;            String md5 = "10675e38f20b94c4c3ac044042ff4413";            try {                SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);                logger.info("result = {}", seckillExecution);            }catch (RepeatKillException e){                logger.info(e.getMessage());            }catch (SeckillCloseException e){                logger.info(e.getMessage());            }        }else{            //秒杀未开启            logger.warn("exposer = {}", exposer);        }    }}