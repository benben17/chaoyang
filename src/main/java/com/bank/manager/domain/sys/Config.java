package com.bank.manager.domain.sys;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Config {
    private String configKey;
    private String configValue;
    private long editUid;
    private Date editTime;
    private String description;
}
