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
    private String type;
    //1软墙 2 硬墙
    private long deviceType;
    // 集群热备
    private long deviceStat;

    //1启用 、2禁用
    private long deviceStatus;
    private String userName;
    private String password;
    private long createUid;
    private Date createTime;
    private long editUid;
    private Date editTime;
}
