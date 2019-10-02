package com.bank.manager.dao.device;

import java.util.List;
import java.util.Map;

public interface F5Dao {

    List<Map<String ,String>> getVsInfo(String deviceIp);
    List<Map<String ,String>> getVsStatus(String startTime,String deviceIp);

    List<Map<String ,String>> getRequestFail(String startTime);

    List<Map<String ,String>> getRequestSuccess(String startTime);

    List<Map<String ,String>> getRequestRate(String startTime);
}
