package com.bank.manager.controller;

import com.bank.manager.common.ErrorCodeEnum;
import com.bank.manager.domain.sys.Device;
import com.bank.manager.domain.sys.User;
import com.bank.manager.result.JsonResult;
import com.bank.manager.service.DeviceService;
import com.bank.manager.service.HillStoneService;
import com.bank.manager.service.UserService;
import com.bank.manager.utils.UrlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
public class DeviceController {

    final static Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private DeviceService deviceService;

    @Resource
    private HillStoneService hillStoneService;

    @RequestMapping(value = "/api/device/{deviceType}", method = RequestMethod.GET)
    public JsonResult getDeviceList(@PathVariable("deviceType") long deviceType) {
        return JsonResult.success(deviceService.getDeviceList(deviceType));
    }

    @RequestMapping(value = "/api/device/test/{id}", method = RequestMethod.GET)
    public JsonResult getDeviceById(@PathVariable("id") long id) {
        Device device = deviceService.getDeviceById(id);
        if (device.getDeviceType() == 1) {
            String host = device.getDeviceIp() + ":" + device.getDevicePort();
            Map<String, String> loginMap = hillStoneService.renewHillStoneToken(device.getUserName(), device.getPassword(), host);
            if (loginMap.isEmpty()) {
                return JsonResult.fail(200001, "连接失败");
            }

            device.setToken(loginMap.get("token"));
            device.setCookie(loginMap.get("cookie"));
            deviceService.updateDevice(device);
            return JsonResult.success(null);
        }
        return JsonResult.success(null);
    }

    @RequestMapping(value = "/api/device", method = RequestMethod.POST)
    public JsonResult saveDevice(@RequestBody Device device) {
        //判断重复
        if (deviceService.checkDeviceRepeat(device)) {
            return JsonResult.fail(ErrorCodeEnum.DATA_ERROR);
        }
        long res = deviceService.insertDevice(device);
        if (res > 0) {
            return JsonResult.success(null);
        } else {
            return JsonResult.fail(ErrorCodeEnum.INSERT_FAIL);
        }
    }

    @RequestMapping(value = "/api/device", method = RequestMethod.DELETE)
    public JsonResult deleteDevice(@RequestBody List<Long> ids) {
        deviceService.deleteDevice(ids);
        return JsonResult.success(null);
    }

    @RequestMapping(value = "/api/device", method = RequestMethod.PUT)
    public JsonResult updateDevice(@RequestBody Device device) {
        JsonResult validateResult = validateId(device);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }
        long res = deviceService.updateDevice(device);
        if (res > 0) {
            return JsonResult.success(null);
        } else {
            return JsonResult.fail(ErrorCodeEnum.UPDATE_FAIL);
        }
    }

    @RequestMapping(value = "/api/device/info", method = RequestMethod.GET)
    public JsonResult getDeviceInfo() {
//      String urls = "http://192.168.0.129/rest/doc/policy";
        Device device = deviceService.getDeviceById(12);
//        String query = "/rest/api/devicemonitor?query={\"extraParams\":{\"monitorType\":\"status:cpu\"}}";
        String query = "/rest/api/devicemonitor?query={\"extraParams\":{\"monitorType\":\"status:memory\"}}";
        String urls = "http://" + device.getDeviceIp() + ":" + device.getDevicePort() + query;



        return JsonResult.success(UrlUtils.urlGet(urls, device.getCookie()));


    }

    private JsonResult validateId(Device device) {
        Map<String, String> errorMap = new HashMap<>();
        long deviceId = device.getId();
        if (StringUtils.isEmpty(deviceId) || deviceId == 0) {
            errorMap.put("id", "ID必填");
        }

        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }
        return JsonResult.fail(errorMap);
    }

}
