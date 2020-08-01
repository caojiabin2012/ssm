package cn.nanjiabin.service;

import cn.nanjiabin.entity.Account;

import java.util.List;

public interface AccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();


    /**
     * 添加账户
     * @param account
     */
    int addAccount(Account account);

    /**
     * 修改
     * @param account
     * @return
     */
    int editAccount(Account account);

    /**
     * 删除
     * @param account
     * @return
     */
    int deleteAccount(Account account);
}
