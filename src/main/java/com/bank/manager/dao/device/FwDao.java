package com.bank.manager.dao.device;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface FwDao {
    List<Map<String, String>> getAttackNum(String startTime, String deviceIp);

    Map<String, String> getDeviceLoad(String startTime, String deviceIp);

    List<Map<String, String>> getThreat(String startTime, java.lang.String deviceIp);

    List<Map<String, String>> getNetwork(String startTime, java.lang.String deviceIp);

    List<Map<String, String>> getTop10User(String startTime, java.lang.String deviceIp);

    List<Map<String, String>> getTop10App(String startTime, java.lang.String deviceIp);

}
