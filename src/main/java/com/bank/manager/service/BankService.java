package com.bank.manager.service;

import com.bank.manager.domain.sys.Bank;

import java.util.List;

public interface BankService {
    List<Bank> getBankList();
    long insertBank(Bank bank);
    long updateBank(Bank bank);
    void deleteDevice(List<Long> ids);

    boolean checkBankRepeat(Bank bank);
}
