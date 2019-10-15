package com.bank.manager.controller;

import com.bank.manager.common.ErrorCodeEnum;
import com.bank.manager.domain.sys.Bank;
import com.bank.manager.result.JsonResult;
import com.bank.manager.service.BankService;
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
public class BankController {
    final static Logger log = LoggerFactory.getLogger(BankController.class);
    @Resource
    private BankService bankService;

    @RequestMapping(value = "/api/sys/bank", method = RequestMethod.GET)
    public JsonResult getBankList() {
        return JsonResult.success(bankService.getBankList());
    }
    @RequestMapping(value = "/api/sys/bank", method = RequestMethod.POST)
    public JsonResult saveBank(@RequestBody Bank bank) {
        //判断重复
        if (bankService.checkBankRepeat(bank)) {
            return JsonResult.fail(ErrorCodeEnum.DATA_ERROR);
        }
        long res = bankService.insertBank(bank);
        if (res > 0) {
            return JsonResult.success(null);
        } else {
            return JsonResult.fail(ErrorCodeEnum.INSERT_FAIL);
        }
    }

    @RequestMapping(value = "/api/sys/bank", method = RequestMethod.DELETE)
    public JsonResult deleteBank(@RequestBody List<Long> ids) {
        bankService.deleteDevice(ids);
        return JsonResult.success(null);
    }


    @RequestMapping(value = "/api/sys/bank", method = RequestMethod.PUT)
    public JsonResult updateBank(@RequestBody Bank bank) {
        JsonResult validateResult = validateId(bank);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }
        long res = bankService.updateBank(bank);
        if (res > 0) {
            return JsonResult.success(null);
        } else {
            return JsonResult.fail(ErrorCodeEnum.UPDATE_FAIL);
        }
    }



    private JsonResult validateId(Bank bank) {
        Map<String, String> errorMap = new HashMap<>();
        long bankId = bank.getId();
        if (StringUtils.isEmpty(bankId) || bankId == 0) {
            errorMap.put("id", "ID必填");
        }

        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }
        return JsonResult.fail(errorMap);
    }
}
