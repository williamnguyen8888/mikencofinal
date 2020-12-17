package com.controllers;

import com.models.AccountEntity;
import com.models.LoginEntity;
import com.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private IAccountService iAccountServices;
    @PostMapping()
    public String login(@ModelAttribute("loginEntity") LoginEntity loginEntity, HttpSession session, Model model){
        AccountEntity accountEntity = iAccountServices.checkLogin(loginEntity);
        if (accountEntity == null) {
            return "khongloginduoc";
        }
        session.setAttribute("username", accountEntity.getUsername());
        session.setAttribute("idCustomer", accountEntity.getCustomerId());
        return "redirect:/";
    }
}
