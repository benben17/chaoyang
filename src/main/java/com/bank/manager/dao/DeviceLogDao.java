package com.bank.manager.dao;

import java.util.Date;
import java.util.List;

public interface DeviceLogDao {
    List<DeviceLogDao> getDeviceLogList(Date startTime, Date endTime,String fromHost, long priority);
}
