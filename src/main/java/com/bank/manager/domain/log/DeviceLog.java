package com.bank.manager.domain.log;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class DeviceLog {
    private long ID;
    private Date DeviceRportedTime;
    private long Facility;
    // 0表示紧急；1表示警报；2表示严重；3表示错误；4表示警告；5表示通告；6表示信息 99 所有
    /**
     * 0 Emergency
     * 1 Alert
     * 2 Critical
     * 3 Error
     * 4 Warning
     * 5 Notice
     * 6 Informational
     **/
    private long Priority;
    private String FromHost;
    private String Message;
    private String SyslogTag;

}
