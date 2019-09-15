package com.bank.manager.service.impl;

import com.bank.manager.dao.DeviceDao;
import com.bank.manager.domain.sys.Device;
import com.bank.manager.service.DeviceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Resource
    private DeviceDao deviceDao;

    /**
     * 添加设备
     *
     * @param device
     * @return long
     */
    @Override
    public long insertDevice(Device device) {
        device.setCreateTime(new Date());
        return deviceDao.saveDevice(device);
    }

    @Override
    public void deleteDevice(List<Long> ids) {
        deviceDao.deleteDevice(ids);
    }

    @Override
    public long updateDevice(Device device) {
        device.setEditTime(new Date());
        return deviceDao.updateDevice(device);
    }

    @Override
    public List<Device> getDeviceList(long deviceType) {
        return deviceDao.getDeviceList(deviceType);
    }

    @Override
    public boolean checkDeviceRepeat(Device device) {
        int res = deviceDao.checkRepeat(device);
        return res != 0;
    }
}
