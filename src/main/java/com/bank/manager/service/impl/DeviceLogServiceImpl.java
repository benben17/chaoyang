package com.bank.manager.service.impl;

import com.bank.manager.dao.device.DeviceLogDao;
import com.bank.manager.service.DeviceLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DeviceLogServiceImpl implements DeviceLogService {

    @Resource
    private DeviceLogDao deviceLogDao;

    @Override
    public List<DeviceLogDao> getDeviceLogList(Date startTime, Date endTime, String fromHost, long priority) {
        return deviceLogDao.getDeviceLogList(startTime,endTime,fromHost,priority);
    }
}
