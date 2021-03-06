package com.bank.manager.domain.log;



/**
 * 日志类型
 *
 * @author fengshuonan
 */
public enum LogType {

    LOGIN("登录日志"),
    EXIT("退出日志"),
    EXCEPTION("异常日志"),
    OPERATION("业务日志");

    String message;

    LogType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
