package cn.nanjiabin.test;


import cn.nanjiabin.service.AccountService;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class TestSpring {

    @Test
    public void testFindAll() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        AccountService as = (AccountService) ac.getBean("accountService");
//        as.findAll();
//        System.out.println(800);
    }

    @Test
    public void test5() throws IOException {
        JsonFactory factory = new JsonFactory();
        try (JsonGenerator jg = factory.createGenerator(System.err, JsonEncoding.UTF8)) {
            // jg.disable(QUOTE_FIELD_NAMES);

            jg.writeStartObject();
            jg.writeStringField("name","A哥");
            jg.writeEndObject();
        }
    }
}
