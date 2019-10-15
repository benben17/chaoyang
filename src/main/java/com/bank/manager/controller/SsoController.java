package com.bank.manager.controller;

import com.bank.manager.common.ErrorCodeEnum;
import com.bank.manager.domain.user.Sso;
import com.bank.manager.domain.user.User;
import com.bank.manager.result.JsonResult;
import com.bank.manager.service.SsoService;
import com.bank.manager.utils.NetworkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@ResponseBody
public class SsoController {
    @Resource
    private SsoService ssoService;
    @Autowired
    private HttpServletRequest request;


    @RequestMapping(value = "/api/sso", method = RequestMethod.POST)
    public JsonResult saveSso(@RequestBody Sso sso) {

        String ipAddress = NetworkUtils.getIpAddress(request);
        if (ipAddress == null) {
            return JsonResult.fail(200000, "获取地址失败");
        }
        sso.setIpAddress(ipAddress);
        long res = ssoService.insertUserInfo(sso);
        if (res > 0) {
            return JsonResult.success(null);
        } else {
            return JsonResult.fail(ErrorCodeEnum.INSERT_FAIL);
        }

    }

    @RequestMapping(value = "/api/sso", method = RequestMethod.GET)
    public JsonResult getSso() {
        String ipAddress = NetworkUtils.getIpAddress(request);

        Sso ssoUserInfo = ssoService.getUserInfo(ipAddress);
        ssoService.deleteUserInfo(ipAddress);
        return JsonResult.success(ssoUserInfo);


    }
}
