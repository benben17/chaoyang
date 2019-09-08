package com.bank.manager.domain.log;

import lombok.*;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class OperationLog {
    private Long id;
    private String logType;
    private String logName;
    private Long userId;
    private String moduleName;
    private Date createTime;
    private String message;


}
