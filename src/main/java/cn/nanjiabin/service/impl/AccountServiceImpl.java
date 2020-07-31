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
    public List<Account> findAll() {
        System.out.println("这是业务层——查询所有账户方法");
        return accountDao.findAll();
    }

    @Override
    public void addAccount(Account account) {

        System.out.println("这是业务层——添加账户方法");
        accountDao.addAccount(account);
    }
}
