package com.bank.manager.domain.log;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class LoginLog {
    private long id;
    private String logType;
    private Long userId;
    private Date createTime;
    private String message;
    private String ipAddress;

}
