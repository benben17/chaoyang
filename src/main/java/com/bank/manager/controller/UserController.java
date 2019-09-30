package com.bank.manager.controller;


import com.bank.manager.common.ErrorCodeEnum;
import com.bank.manager.domain.user.User;
import com.bank.manager.result.JsonResult;
import com.bank.manager.service.UserService;
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
public class UserController {

    final static Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    /**
     * 用户登陆
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public JsonResult login(@RequestBody User user) {
        User loginUser = userService.login(user);
        if (loginUser == null) {
            return JsonResult.fail(ErrorCodeEnum.LOGIN_ERROR);
        }
        return JsonResult.success(loginUser);


    }

    /**
     * 根据用户查找用户信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    public JsonResult findOneUser(@PathVariable("id") long id) {

        User userInfo = userService.findUserById(id);
        if (userInfo == null) {
            return JsonResult.success(null);
        }
        return JsonResult.success(userInfo);
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public JsonResult createUser(@RequestBody User user) {
        // 参数校验
        JsonResult validateResult = addValidate(user);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }
        boolean result = userService.checkUserName(user.getUserName());
        if (!result) {
            userService.saveUser(user);
            return JsonResult.success(null);
        } else {
            return JsonResult.fail(ErrorCodeEnum.DATA_ERROR);
        }
    }

    private JsonResult addValidate(User user) {
        Map<String, String> errorMap = new HashMap<>();

        String userName = user.getUserName();
        if (StringUtils.isEmpty(userName)) {
            errorMap.put("userName", "用户名必填");
        }

        String passWord = user.getPassword();
        if (StringUtils.isEmpty(passWord)) {
            errorMap.put("passWord", "密码必填");
        }

        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }

        return JsonResult.fail(errorMap);
    }

    /**
     * 根据ID删除用户
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/api/user", method = RequestMethod.DELETE)
    public JsonResult delUser(@RequestBody Long[] ids) {
        userService.deleteUser(ids);
        return JsonResult.success(null);
    }

    /**
     * 获取用户列表
     *
     * @return list
     */
    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public JsonResult findAllUser() {
        List<User> users = userService.getAllUser();
        return JsonResult.success(users);
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/api/user", method = RequestMethod.PUT)
    public JsonResult modifyUser(@RequestBody User user) {
        long updateUserInfo = userService.updateUser(user);
        if (updateUserInfo == 0) {
            return JsonResult.fail(ErrorCodeEnum.UPDATE_FAIL);
        }
        return JsonResult.success(null);
    }
}
