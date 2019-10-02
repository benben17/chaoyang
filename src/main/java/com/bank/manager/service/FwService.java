package com.bank.manager.service;

import java.util.List;
import java.util.Map;

public interface FwService {

    Map<String,String> getAttackNum(String startTime,String deviceIp);
    Map<String,String> getDeviceLoad(String startTime,String deviceIp);
    List<Map<String,String>> getThreat(String startTime, String deviceIp);
    List<Map<String,String>> getNetwork(String startTime, String deviceIp);
    List<Map<String,String>> getTop10Threat(String startTime, String deviceIp);
    List<Map<String,String>> getTop10App(String startTime, String deviceIp);
}
