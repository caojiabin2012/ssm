package cn.nanjiabin.test;


import cn.nanjiabin.entity.Account;
import cn.nanjiabin.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.List;

public class TestBatis {

    private static final Logger logger = LoggerFactory.getLogger(TestBatis.class);

    private ApplicationContext applicationContext;
    private AccountService accountService;

    /**
     * 初始化
     * @throws Exception
     */
    @Before
    public void init() throws Exception {
        applicationContext  = new ClassPathXmlApplicationContext("classpath:spring/spring-*.xml");
        accountService      = (AccountService) applicationContext.getBean("AccountService");
    }

    /**
     * 查询-全部数据
     */
    @Test
    public void testGetList() {

        Account user = new Account();
        user.setName("account1");
        List<Account> accounts = accountService.getList(user);
        for (Account account : accounts) {
            logger.info("ID={},姓名={}", account.getId(), account.getName());
        }
    }

    /**
     * 增加-单条数据
     */
    @Test
    public void testAddAccount() {
        Account account = new Account();
        account.setName("test11");
        account.setBalance(800d);

        int count = accountService.addAccount(account);

        logger.info("增加行数={}", count);
        logger.info("account id={}", account.getId());

    }

    /**
     * 增加-多条数据
     */
    @Test
    public void testAddBatchAccount() {
        Account account1 = new Account();
        account1.setName("account1");
        account1.setBalance(800d);

        Account account2 = new Account();
        account2.setName("account2");
        account2.setBalance(800d);

        List<Account> list = new ArrayList<Account>();
        list.add(account1);
        list.add(account2);

        int count = accountService.addBatchAccount(list);

        logger.info("增加行数={}", count);

        // 变量list
        for (Account account : list) {
            logger.info(account.getId().toString());
            logger.info(account.getName());
            logger.info(account.getBalance().toString());
        }
    }

    /**
     * 修改-by id
     */
    @Test
    public void testEditAccount() {
        Account account = new Account();
        account.setId(14);
        account.setName("14name");
        account.setBalance(900d);

        int count = accountService.editAccount(account);
        logger.info("受影响行数={}", count);
    }

    /**
     * 删除-by id
     */
    @Test
    public void testDeleteAccount() throws Exception {
        Account account = new Account();
        account.setId(16);
        int count = accountService.deleteAccount(account);
        int a = 0/0;
        logger.info("删除行数={}", count);
    }

    @Test
    public void testDelete() throws Exception {
        // 1.获取事务控制管理器
        DataSourceTransactionManager transactionManager = applicationContext.getBean(
                "transactionManager", DataSourceTransactionManager.class);

        // 2.获取事务定义
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();

        // 3.设置事务隔离级别，开启新事务
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);

        // 4.获得事务状态
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            // 5.具体的数据库操作（多个）
            testAddAccount();
            testAddBatchAccount();
//            testDeleteAccount();
            testGetList();
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
        }
    }
}
