package com.bank.manager.service.impl;

import com.bank.manager.dao.sys.BankDao;
import com.bank.manager.domain.sys.Bank;
import com.bank.manager.service.BankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 支行管理
 */
@Service
public class BankServiceImpl implements BankService {

    @Resource
    private BankDao bankDao;

    @Override
    public List<Bank> getBankList() {
        return bankDao.getBankList();
    }

    @Override
    public long insertBank(Bank bank) {
        return  bankDao.saveBank(bank);
    }

    @Override
    public long updateBank(Bank bank) {
        return bankDao.updateBank(bank);
    }

    @Override
    public void deleteDevice(List<Long> ids) {
        bankDao.deleteBank(ids);
    }

    @Override
    public boolean checkBankRepeat(Bank bank) {
        long res = bankDao.checkRepeat(bank);
        return  res == 0;
    }
}
