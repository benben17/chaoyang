package com.bank.manager.domain.sys;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Device {
    private long id;
    private String name;

    private String deviceIp;
    private long devicePort;

    //0zstack 1 防火墙 ,2:负载均衡
    private long deviceType;

    // 集群热备
    private String deviceStat;

    //启用 、禁用
    private String deviceStatus;
    private String userName;
    private String password;
    private String token;
    private String cookie;
    private long createUid;
    private Date createTime;
    private long editUid;

    private Date editTime;
}
