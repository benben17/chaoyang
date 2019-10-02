package com.bank.manager.utils;

import com.bank.manager.common.CommonUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlUtilsTest {

    @Autowired
    UrlUtils urlUtils;

    @Test
    public void getUrlUtils() throws IOException {
//        final BASE64Encoder encoder = new BASE64Encoder();
//        final String text = "hillstone";
//        final byte[] textByte = text.getBytes("UTF-8");
//        final String encodedText = encoder.encode(textByte);
//
//        String json = "{\"lang\":\"zh_CN\",password:\"" + encodedText + "\",userName:\"hillstone\"}";
//        JSONObject object = new JSONObject();
//        object = JSON.parseObject(json);
//
//        String url = "http://192.168.0.129/rest/doc/login";
//        String result = urlUtils.urlPost(object.toString(), url);
//
//        JSONObject jsons = JSON.parseObject(result);
//        JSONObject res = jsons.getJSONObject("result");
//
//
//        String cookie = "token="+res.getString("token")+";fromrootvsys=true;username=hillstone;role=admin;vsysId=0";
////        Map<String,String> headerMap = new HashMap<>();
////        headerMap.put("Cookie",cookie);
//        System.out.println(cookie);
//        String urls = "http://192.168.0.129/rest/doc/policy";
//        urlUtils.urlGet(urls,cookie);

        System.out.println(CommonUtils.getBeforeTime(-20));


    }
}
