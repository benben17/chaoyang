package com.bank.manager.dao.sys;

import com.bank.manager.domain.sys.Bank;
import com.bank.manager.domain.sys.Device;

import java.util.List;

public interface BankDao {

    long saveBank(Bank bank);

    long updateBank(Bank bank);

    List<Device> getBankList();

    void deleteBank(List<Long> bankIds);

    int checkRepeat(Bank bank);

}
