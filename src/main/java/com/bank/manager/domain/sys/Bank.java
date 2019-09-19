package com.bank.manager.domain.sys;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class Bank {
    private long id;
    private String bankName;
    private long level;
    private String address;
    private  String ipAddress;
    private String lng;
    private  String lat;
    private long createUid;
    private long editUid;
    private Date createTime;
    private Date editTime;
}
