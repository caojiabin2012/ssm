package cn.nanjiabin.test;


import cn.nanjiabin.dao.AccountDao;
import cn.nanjiabin.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestBatis {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private AccountDao accountDao;
    /**
       单独测试Mybatis时所用，整合后 SqlMapConfig.xml文件就不再使用了
       配置到 applicationContext.xml
    */
    @Before
    public void init() throws IOException {
        //加载配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建 SqlSessionFactory 对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建 SqlSession 对象
        sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(AccountDao.class);
    }

    @After
    public void destroy() throws IOException {
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("------------");
            System.out.println(account.getName());
        }
    }

    @Test
    public void testAddAccount() {
        Account account = new Account();
        account.setName("test");
        account.setBalance(800d);

        accountDao.addAccount(account);
    }



}
