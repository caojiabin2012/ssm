package cn.nanjiabin.controller;

import cn.nanjiabin.entity.Account;
import cn.nanjiabin.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    private final Logger log =  LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService AccountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("这是控制层——查询所有账户的方法");
        Account account = new Account();
        List<Account> list = AccountService.getList(account);
        model.addAttribute("accounts",list);
        return "list_account";
    }

    @RequestMapping("/add")
    public void add(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        AccountService.addAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
}
