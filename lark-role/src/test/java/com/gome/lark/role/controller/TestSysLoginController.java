package com.gome.lark.role.controller;

import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

/**
 * Created by liuhui-ds9 on 2017/11/28.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml","classpath:spring-jdbc.xml","classpath:spring-redis.xml","classpath:spring-scheduler.xml"})
public class TestSysLoginController {

    private RestTemplate template = new TestRestTemplate();

    @Test
    public void testPostCaptcha(){
        try {
            String url = "http://localhost:"+8081+"/v1/masterdata/0501080060000116";
            ArrayList<String> result = template.getForObject(url, ArrayList.class);
            Assert.assertTrue("通过主数据的标准化编码进行查询=>测试失败", result.size() > 0);
            System.err.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCaptcha(){

    }

    @Test
    public void testLogin(){

    }

    @Test
    public void testLogout(){

    }

}
