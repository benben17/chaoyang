package com.bank.manager.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liangguorong
 *
 */
public class JsonUtils {

    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);

    // can reuse, share globally
    private static final ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 
     * @param pojo 支持JavaBean/Map/List/Array等
     * @return JSON字符串
     * @throws IOException
     */
    public static String object2Json(Object pojo) {
        if (pojo == null) {
            return null;
        }

        String json = null;
        JsonGenerator jsonGenerator = null;
        try {
            StringWriter sw = new StringWriter();
            jsonGenerator = MAPPER.getFactory().createGenerator(sw);
            jsonGenerator.writeObject(pojo);
            json = sw.toString();
        } catch (IOException e) {
            log.error("Convert to json failure.", e);
        } finally {
            if (jsonGenerator != null) {
                try {
                    jsonGenerator.close();
                } catch (IOException e) {
                }
            }
        }

        return json;
    }

    public static String object2JsonIgnoreNull(Object pojo) {
        if (pojo == null) {
            return null;
        }

        String json = null;
        JsonGenerator jsonGenerator = null;
        try {
            StringWriter sw = new StringWriter();
            jsonGenerator = MAPPER.getFactory().createGenerator(sw);
            MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            jsonGenerator.writeObject(pojo);
            json = sw.toString();
        } catch (IOException e) {
            log.error("Convert to json failure.", e);
        } finally {
            if (jsonGenerator != null) {
                try {
                    jsonGenerator.close();
                } catch (IOException e) {
                }
            }
        }

        return json;
    }

    /**
     * 说明：
     * 
     * @param json
     * @param cls
     * @return
     * @throws Exception
     */
    public static <T> T json2Object(String json, Class<T> cls) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }

        T obj = null;
        try {
            obj = MAPPER.readValue(json, cls);
        } catch (Exception e) {
            if (!JsonUtils.isJson(json)) {
                log.error("content is not json: " + json + " --> " + e.getMessage());
            } else {
                log.error("Convert to object failure: " + json, e);
            }
        }

        return obj;
    }

    public static <T> T json2Object(String json, TypeReference<T> typeReference) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }

        T obj = null;
        try {
            obj = MAPPER.readValue(json, typeReference);
        } catch (Exception e) {
            if (!JsonUtils.isJson(json)) {
                log.error("content is not json: " + json + " --> " + e.getMessage());
            } else {
                log.error("Convert to object failure: " + json, e);
            }
        }

        return obj;
    }

    public static <T> List<T> json2List(String json, Class<T[]> cls) {
        T[] objArr = JsonUtils.json2Object(json, cls);
        if (objArr == null || objArr.length == 0) {
            return new ArrayList<T>();
        }

        return Arrays.asList(objArr);
    }

    public static JsonNode json2Tree(String json) {
        if (StringUtils.isEmpty(json)) {
            return null;
        } else if (!JsonUtils.isJson(json)) {
            log.error("content is not json: " + json);
            return null;
        }

        JsonNode jsonTree = null;
        try {
            jsonTree = MAPPER.readTree(json);
        } catch (Exception e) {
            log.error("Convert to JsonNode failure: " + json, e);
        }

        return jsonTree;
    }

    public static boolean isJson(String json) {
        return (json.trim().startsWith("{") || json.trim().startsWith("["));
    }

}
