package com.bank.manager.common;

/**
 * 错误码
 *
 * @author Chunfu.Dong
 * @date 2019-08-03 11:07
 */
public enum ErrorCodeEnum {
    SYSTEM_ERROR(100000, "系统错误"),
    TOKEN_ERROR(100001, "Token错误"),
    LOGIN_ERROR(100002, "用户名或密码错误"),
    PARAM_ERROR(100003, "参数错误"),
    DATA_ERROR(100004, "数据重复"),
    DEPLOY_ERROR(100005, "部署失败"),
    UPLOAD_ERROR(100006, "上传文件失败"),
    UPLOAD_FILE_EMPTY(1000061, "上传文件为空"),
    FORMAT_ERROR(100007, "文件格式化错误"),
    TRANS_ERROR(100008, "转换文件失败"),
    READ_ERROR(100009, "无此文件"),
    SCAN_ERROR(100010, "扫描失败"),
    JSON_TEMPLATE_ERROR(1000020,"JSON模版错误"),
    INSERT_FAIL(4001, "插入失败"),
    DELETE_FAIL(4002, "删除失败"),
    DELETE_ERROR(40002, "实体有关系存在存在，或者有子实体"),
    UPDATE_FAIL(4003, "更新失败"),
    SELECT_FAIL(4004, "查询失败");


    private int code;

    private String msg;

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}