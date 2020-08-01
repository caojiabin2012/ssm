package cn.nanjiabin.dao;

import cn.nanjiabin.entity.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {

    /**
     * 查询所有
     * @return
     */
//    @Select("SELECT * FROM account")
    List<Account> getList(Account account);


    /**
     * 添加账户
     * @param account
     */
//    @Select("INSERT INTO account (name,balance) VALUES (#{name},#{balance})")
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
