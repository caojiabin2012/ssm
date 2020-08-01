package cn.nanjiabin.test;

import cn.nanjiabin.entity.Account;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cn.nanjiabin.common.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestHttp {
    private static final Logger logger = LoggerFactory.getLogger(TestHttp.class);


    @Test
    public void testGet() {
        HttpClientUtils httpClient = new HttpClientUtils();
        // 0.test get
        String url = "http://www.baidu.com";
        System.out.println(httpClient.get(url));

        // 1.test get
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "a");
        map.put("2", "b");
        System.out.println(httpClient.get(url, map));

        // 2.test json
        String json = "{\"id\":11,\"name\":\"\\u5f20\\u4e09\",\"balance\":9908.1, ,\"balance111\":9908.1}";
        Account account = JSONUtils.parseObject(json, Account.class);
        System.out.println(account.getId());
        System.out.println(account.getName());
        System.out.println(account.getBalance());

        String accountJson = JSONUtils.toJSONString(account);
        System.out.println(accountJson);


        // 3.post json
        System.out.println("3.post json");

        json = "{\"service_type\":\"WECHAT_ORDERQUERY\",\"out_trade_no\":\"BC714420191128124430C4H6V\",\"nonce_str\":\"20200730135139C662D\",\"sign\":\"304402202F2A33D9321941C8CB681566699745326ED85F063216B1A6AC78DE75FA2065150220684EE57F3C498A5939D4D26DEE2F3EA60C541CA9CFB6C6952DDFF0334D213B20\",\"agent_num\":\"A154875078201110043\",\"mch_id\":\"C159314790182010669\"}";
        url  = "https://dzsd.klb.cn/dzsd/pay/gateway";
        String orderJson = httpClient.postJson(url, json);
        System.out.println(orderJson);

        logger.info("请求地址 : info");
        logger.debug("请求地址 : debug");
        logger.warn("warn");


    }



}
