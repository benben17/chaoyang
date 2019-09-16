package com.bank.manager.domain.log;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class DeviceLog {
    private long id;
    private Date deviceReportedTime;
    private long facility;
    // 0表示紧急；1表示警报；2表示严重；3表示错误；4表示警告；5表示通告；6表示信息 99 所有
    private long priority;
    private String fromHost;
    private String message;
    private String syslogTag;

}
