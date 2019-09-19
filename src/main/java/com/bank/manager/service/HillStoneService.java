package com.bank.manager.service;

import java.util.Map;

public interface HillStoneService {
    Map<String,String> renewHillStoneToken(String userName, String password, String host);
}
