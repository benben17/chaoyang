package com.bank.manager.service.impl;

import com.bank.manager.dao.device.F5Dao;
import com.bank.manager.service.F5Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class F5ServiceImpl implements F5Service {
    @Resource
    private F5Dao f5Dao;

    @Override
    public List<Map<String, String>> getVsInfo(String deviceIp) {
        return f5Dao.getVsInfo(deviceIp);
    }

    @Override
    public List<Map<String, String>> getVsStatus(String startTime,String deviceIp,String vsName) {
        return f5Dao.getVsStatus(startTime,deviceIp,vsName);
    }

    @Override
    public List<Map<String, String>> getRequestFail(String startTime) {
        return f5Dao.getRequestFail(startTime);
    }

    @Override
    public List<Map<String, String>> getRequestSuccess(String startTime,String vsName) {
        return f5Dao.getRequestSuccess(startTime,vsName);
    }
    @Override
    public List<Map<String, String>> getRequestRate(String startTime, String vsName) {
        return f5Dao.getRequestRate(startTime,vsName);
    }

    @Override
    public List<Map<String, String>> getVsRate(String startTime, String deviceIp) {
        return f5Dao.getVsRate(startTime,deviceIp);
    }
}
