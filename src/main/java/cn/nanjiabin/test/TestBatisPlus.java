package cn.nanjiabin.test;


import java.util.List;

import cn.nanjiabin.entity.User;
import cn.nanjiabin.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring.xml"})
public class TestBatisPlus {
    private static final Logger logger = LoggerFactory.getLogger(TestBatisPlus.class);

    @Autowired
    private UserMapper userMapper;

//    private ApplicationContext applicationContext;

    /**
     * 初始化
     * @throws Exception
     */
    @Before
    public void init() throws Exception {
//        applicationContext  = new ClassPathXmlApplicationContext("classpath:spring/spring-*.xml");
//        accountService      = (AccountService) applicationContext.getBean("AccountService");
    }
    @Test
    public void testSelect() {
        logger.info("infoinfoinfoinfoinfoinfo");
        logger.warn("warnwarnwarnwarnwarnwarn");
        logger.debug("debugdebugdebugdebugdebugdebug");
        logger.error("errorerrorerrorerrorerrorerrorerror");



        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(7, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testAdd() {
        // 如果不设置id自增，mp会为id生成一个uuid的16进制值，就需要将id类型设置为long，如果要使用表自增id，需要在实体类中列名上加注解：@TableId(type = IdType.AUTO)
        User u = new User();
        u.setName("Tomcat");
        u.setAge(18);
        u.setEmail("kellylake@qq.com");
        userMapper.insert(u);

    }

    @Test
    public void testCustomizedSql() {
        System.out.println("maxAge=" + userMapper.selectMaxAge());
    }

    @Test
    public void testPagination() {
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPage(page, null);
        Assert.assertTrue("total should not be 0", page.getTotal() != 0);
        for (User u : page.getRecords()) {
            System.out.println(u);
        }
        Assert.assertEquals("pagination should be 3 per page", 3, page.getRecords().size());
    }

}
