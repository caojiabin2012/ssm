package cn.nanjiabin.service.impl;

import cn.nanjiabin.dao.AccountDao;
import cn.nanjiabin.entity.Account;
import cn.nanjiabin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AccountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> getList(Account account) {
        System.out.println("这是业务层——查询所有账户方法");
        return accountDao.getList(account);
    }

    @Override
    public int addAccount(Account account) {

        System.out.println("这是业务层——添加账户方法");
        return accountDao.addAccount(account);
    }

    @Override
    public int addBatchAccount(List<Account> accounts) {
        System.out.println("这是业务层——添加账户方法");
        return accountDao.addBatchAccount(accounts);
    }

    @Override
    public int editAccount(Account account) {
        System.out.println("这是业务层——editAccount账户方法");
        return accountDao.editAccount(account);
    }

    @Override
    public int deleteAccount(Account account) {
        System.out.println("这是业务层——deleteAccount账户方法");
        return accountDao.deleteAccount(account);
    }
}
