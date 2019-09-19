package com.bank.manager.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bank.manager.service.HillStoneService;
import com.bank.manager.utils.UrlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class HillStoneServiceImpl implements HillStoneService {
    private static Logger log = LoggerFactory.getLogger(UrlUtils.class);

    /**
     * @param userName username
     * @param password password
     * @param host hostIp
     * @return Map{token:token,cookie:cookie}
     */
    public Map<String,String> renewHillStoneToken(String userName, String password, String host) {
        final BASE64Encoder encoder = new BASE64Encoder();
        Map<String,String> resultMap = new HashMap<>();
        try {
            final byte[] textByte = password.getBytes("UTF-8");
            final String encodedText = encoder.encode(textByte);
            Map<String,String> loginMap= new HashMap<>();
            loginMap.put("lang","zh_CN");
            loginMap.put("password",encodedText);
            loginMap.put("userName",userName);
//            JSONObject data =JSON.parseObject(String.valueOf(loginMap));
            String url = "http://"+host+"/rest/doc/login";
            JSONObject res =  JSON.parseObject(UrlUtils.urlPost(JSONUtils.toJSONString(loginMap), url));
            if(res.getBoolean("success")){
                JSONObject result = res.getJSONObject("result");
                resultMap.put("token",result.getString("token"));

                String cookie = String.format("token=%s;fromrootvsys=%s;username=%s;role=%s;vsysId=%s",
                        result.getString("token"),
                        result.getString("fromrootvsys"),
                        result.getString("username"),
                        result.getString("role"),
                        result.getString("vsysId")
                );
                resultMap.put("cookie",cookie);
            }else{
                log.error("msg"+res.getString("exception"));
            }

        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return resultMap;
    }


}
