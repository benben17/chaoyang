package com.bank.manager.service;

import com.bank.manager.domain.sys.Device;

import java.util.List;

public interface DeviceService {
    long insertDevice(Device device);
    void deleteDevice(List<Long> ids);
    long updateDevice(Device device);
    List<Device> getDeviceList(long deviceType);
    boolean checkDeviceRepeat(Device device);

}
