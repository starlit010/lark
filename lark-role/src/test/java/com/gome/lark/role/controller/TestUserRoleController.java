package com.gome.lark.role.controller;

import com.gome.lark.common.utils.R;
import com.gome.lark.role.entity.SysRoleEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuhui-ds9 on 2017/11/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml", "classpath:spring-jdbc.xml", "classpath:spring-redis.xml", "classpath:spring-scheduler.xml"})
public class TestUserRoleController {

    private RestTemplate template = new TestRestTemplate();

    /**
     * 信息
     */
    public void TestInfo() {
        try {
            String url = "http://localhost:" + 8081 + "/v1/masterdata/0501080060000116";
            ArrayList<String> result = template.getForObject(url, ArrayList.class);
            Assert.assertTrue("通过主数据的标准化编码进行查询=>测试失败", result.size() > 0);
            System.err.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存
     */
    public void testSave() {
        try {
            String url = "http://localhost:" + 8081 + "/v1/masterdata";
            Map<String, String> tBasicMasterData = new HashMap<String, String>();
            tBasicMasterData.put("category", "100");
            tBasicMasterData.put("code", "100");
            int forObject = template.postForObject(url, tBasicMasterData, Integer.class);
            Assert.assertNotNull("创建一条主数据记录失败", forObject);
            Assert.assertTrue("创建一条主数据记录=>测试失败", forObject > 0);
            System.err.println(forObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改
     */
    public void testUpdate() {
        try {
            String reqJsonStr = "{\"category\":200,\"code\":\"200\", \"englishname\":\"200\",\"name\":\"200\"}";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(reqJsonStr, headers);
            String url = "http://localhost:" + 8081 + "/v1/masterdata/100";
            ResponseEntity<String> exchange = template.exchange(url, HttpMethod.PUT, entity, String.class);
            String body = exchange.getBody();
            Assert.assertNotNull("更改一条主数据记录失败", body);
            Assert.assertTrue("更改一条主数据记录=>测试失败", Integer.valueOf(body) > 0);
            System.err.println(exchange);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * 删除
     */
    public void testDelete() {
        try {
            String url = "http://localhost:" + 8081 + "/v1/masterdata/200";
            ResponseEntity<String> exchange = template.exchange(url, HttpMethod.DELETE, null, String.class);
            String body = exchange.getBody();
            Assert.assertNotNull("删除一条主数据记录失败", body);
            Assert.assertTrue("删除一条主数据记录=>测试失败", Integer.valueOf(body) > 0);
            System.err.println(exchange);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
