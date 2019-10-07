package com.bank.manager.dao.device;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface F5Dao {

    List<Map<String, String>> getVsInfo(@Param("deviceIp") String deviceIp);

    List<Map<String, String>> getVsStatus(String startTime, String deviceIp,String vsName);

    List<Map<String, String>> getRequestFail(String startTime);

    List<Map<String, String>> getRequestSuccess(String startTime,String vsName);

    List<Map<String, String>> getRequestRate(String startTime, String vsName);

    List<Map<String, String>> getVsRate(String startTime, String deviceIp);
}
