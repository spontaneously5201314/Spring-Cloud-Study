package com.cmcm.study;

import com.cmcm.study.sender.MySender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudBusApplicationTests {

    @Autowired
    private MySender sender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void hello() {
        sender.send();
    }

}
