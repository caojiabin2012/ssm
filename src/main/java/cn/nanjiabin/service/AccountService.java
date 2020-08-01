package cn.nanjiabin.service;

import cn.nanjiabin.entity.Account;

import java.util.List;

public interface AccountService {

    /**
     * 查询列表
     * @return
     */
    List<Account> getList(Account account);

    /**
     * 添加账户
     * @param account
     */
    int addAccount(Account account);

    /**
     * 批量添加账户
     * @param accounts
     */
    int addBatchAccount(List<Account> accounts);

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
