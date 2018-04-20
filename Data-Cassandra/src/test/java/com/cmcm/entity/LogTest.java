package com.cmcm.entity;

import com.cmcm.repository.LogRepository;
import com.cmcm.service.impl.LogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author hongfei
 * @create 2018-04-20 下午3:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {

    @Autowired
    private LogService logService;

    @Autowired
    private LogRepository logRepository;

    @Test
    public void testSelectAll() {
        List<Log> allLog = logService.findAllLog();
        for (Log log : allLog) {
            System.out.println(log);
        }
    }

    @Test
    public void testFindAll() {
        List<Log> list = logRepository.findAll();
        for (Log log : list) {
            System.out.println(log);
        }
    }
}
