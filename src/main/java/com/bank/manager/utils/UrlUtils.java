package com.bank.manager.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bank.manager.service.HillStoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;
import sun.net.www.http.HttpClient;

import javax.annotation.Resource;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class UrlUtils {

    private static Logger log = LoggerFactory.getLogger(UrlUtils.class);

    public static String urlPost(String jsonParam, String urls) {
        String res = null;
        try {
            // 创建url资源
            URL url = new URL(urls);
            // 建立http连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置允许输出
            conn.setDoOutput(true);
            // 设置允许输入
            conn.setDoInput(true);
            // 设置不用缓存
            conn.setUseCaches(false);
            // 设置传递方式
            conn.setRequestMethod("POST");
            // 设置维持长连接
            conn.setRequestProperty("Connection", "Keep-Alive");
            // 设置文件字符集:
            conn.setRequestProperty("Charset", "UTF-8");
            // 转换为字节数组
            byte[] data = jsonParam.getBytes();
            // 设置文件长度
            conn.setRequestProperty("Content-Length", String.valueOf(data.length));
            // 设置文件类型:
            conn.setRequestProperty("contentType", "application/json");
            // 开始连接请求
            conn.connect();
            OutputStream out = new DataOutputStream(conn.getOutputStream());
            // 写入请求的字符串
            out.write(jsonParam.getBytes());
            out.flush();
            out.close();
            // 请求返回的状态
            if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
                // 请求返回的数据
                res = returnResult(conn.getInputStream());
            }
        } catch (Exception e) {
            log.error(e.getMessage());

        }
        return res;
    }

    @Resource
    HillStoneService hillStoneService;

    public static String urlGet(String urls, String cookie) {
        String res = null;
        int num = 0;
        try {
            URL realUrl = new URL(urls);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            //设置超时时间
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(15000);
            // 设置通用的请求属性
            connection.setRequestProperty("Cookie", cookie);
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            System.out.println(connection.getResponseCode());
            if (connection.getResponseCode() == 200) {
                res = returnResult(connection.getInputStream());
                System.out.println(res);
            }else{
                return String.valueOf(connection.getResponseCode());
            }

        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return res;
    }

    private static String returnResult(InputStream in) {
        StringBuffer sb = new StringBuffer();
        try {
            String readLine = new String();
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            while ((readLine = responseReader.readLine()) != null) {
                sb.append(readLine).append("\n");
            }
            responseReader.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
