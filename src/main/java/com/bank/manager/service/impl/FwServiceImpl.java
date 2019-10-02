package com.bank.manager.service.impl;

import com.bank.manager.dao.device.FwDao;
import com.bank.manager.service.FwService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class FwServiceImpl  implements FwService {

    @Resource
    FwDao fwDao;

    @Override
    public Map<String,String> getAttackNum(String startTime,String deviceIp){
        return fwDao.getAttackNum(startTime,deviceIp);
    }

    @Override
    public Map<String,String> getDeviceLoad(String startTime,String deviceIp){
        return fwDao.getDeviceLoad(startTime,deviceIp);
    }

    @Override
    public List<Map<String, String>> getThreat(String startTime, String deviceIp) {
        return fwDao.getThreat(startTime,deviceIp);
    }

    @Override
    public List<Map<String, String>> getNetwork(String startTime, String deviceIp) {
        return fwDao.getNetwork(startTime,deviceIp);
    }

    @Override
    public List<Map<String, String>> getTop10Threat(String startTime, String deviceIp) {
        return fwDao.getTop10Threat(startTime,deviceIp);
    }

    @Override
    public List<Map<String, String>> getTop10App(String startTime, String deviceIp) {
        return fwDao.getTop10App(startTime,deviceIp);
    }
}
