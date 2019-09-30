package com.bank.manager.controller;

import com.bank.manager.common.ErrorCodeEnum;
import com.bank.manager.domain.sys.Device;
import com.bank.manager.domain.user.Role;
import com.bank.manager.domain.user.User;
import com.bank.manager.result.JsonResult;

import com.bank.manager.service.RoleService;


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
public class RoleController {
    final static Logger log = LoggerFactory.getLogger(RoleController.class);
    @Resource
    private RoleService roleService;


    @RequestMapping(value = "/api/role", method = RequestMethod.GET)
    public JsonResult getRoleLists() {
        log.info("aaaa");
        return JsonResult.success(roleService.getRoleList());
    }

    @RequestMapping(value = "/api/role", method = RequestMethod.POST)
    public JsonResult saveDevice(@RequestBody Role role) {
        JsonResult validateResult = addValidate(role);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }

        //判断重复
        if (roleService.checkRoleName(role)) {
            return JsonResult.fail(ErrorCodeEnum.DATA_ERROR);
        }
        boolean res = roleService.insertRole(role);
        if (res) {
            return JsonResult.success(null);
        } else {
            return JsonResult.fail(ErrorCodeEnum.INSERT_FAIL);
        }
    }

    @RequestMapping(value = "/api/role", method = RequestMethod.DELETE)
    public JsonResult deleteRoles(@RequestBody List<Long> ids) {
        roleService.deleteRoles(ids);
        return JsonResult.success(null);
    }

    @RequestMapping(value = "/api/role", method = RequestMethod.PUT)
    public JsonResult updateDevice(@RequestBody Role role) {
        JsonResult validateResult = validateRoleId(role);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }
        if (roleService.checkRoleName(role)) {
            return JsonResult.fail(ErrorCodeEnum.DATA_ERROR);
        }
        boolean res = roleService.updateRole(role);
        if (res) {
            return JsonResult.success(null);
        } else {
            return JsonResult.fail(ErrorCodeEnum.UPDATE_FAIL);
        }
    }
    private JsonResult addValidate(Role role) {
        Map<String, String> errorMap = new HashMap<>();

        String roleName = role.getRoleName();
        if (StringUtils.isEmpty(roleName)) {
            errorMap.put("roleName", "用户名必填");
        }

        String access = role.getAccess();
        if (StringUtils.isEmpty(access)) {
            errorMap.put("access", "密码必填");
        }

        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }
        return JsonResult.fail(errorMap);
    }
    private JsonResult validateRoleId(Role role) {
        Map<String, String> errorMap = new HashMap<>();

        long roleId = role.getId();
        if (StringUtils.isEmpty(roleId) || roleId == 0) {
            errorMap.put("roleId", "ID 必填");
        }

        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }
        return JsonResult.fail(errorMap);
    }
}
