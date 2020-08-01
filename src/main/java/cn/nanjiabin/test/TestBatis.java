package cn.nanjiabin.test;


import cn.nanjiabin.entity.Account;
import cn.nanjiabin.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    public void testFindAll() {

        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            logger.info("姓名={}", account.getName());
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
    public void testDeleteAccount() {
        Account account = new Account();
        account.setId(16);
        int count = accountService.deleteAccount(account);
        logger.info("删除行数={}", count);
    }
}
