package com.dyw.controller;

import com.dyw.domain.Account;
import com.dyw.service.AccountService;
import org.apache.ibatis.annotations.ResultMap;
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

    @Autowired
    AccountService accountService;
    
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("AccountController findAll...");
        List<Account> allAccount = accountService.findAll();
        model.addAttribute("list", allAccount);
        return "list";
    }

    @RequestMapping("/saveAccount")
    public void saveAccount(Account account,
                            HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("AccountController saveAccount...");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath() + "/account/findAll");
        return;
    }
}
