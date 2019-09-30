package com.bank.manager.dao;

import com.bank.manager.domain.sys.Device;

import java.util.List;

public interface DeviceDao {

    long saveDevice(Device device);

    long updateDevice(Device device);

    List<Device> getDeviceList(long deviceType);

    void deleteDevice(List<Long> deviceIds);

    int checkRepeat(Device device);
    Device getDeviceById(long id);

}
