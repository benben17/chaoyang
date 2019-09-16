package com.bank.manager.service;

import com.bank.manager.dao.device.DeviceLogDao;

import java.util.Date;
import java.util.List;

public interface DeviceLogService {
    List<DeviceLogDao> getDeviceLogList(Date startTime, Date endTime, String fromHost, long priority);
}
