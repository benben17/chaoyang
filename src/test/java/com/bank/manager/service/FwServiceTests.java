package com.bank.manager.service;

import com.bank.manager.utils.UrlUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FwServiceTests {

    @Resource
    FwService fwService;

    @Test
    public void fw() throws IOException {

        System.out.println(fwService.getDeviceLoad("2019-09-30 00:00:00","192.168.0.182"));


    }
}
