package com.controllers;

import com.exeptionhandler.TestExep;
import com.exeptionhandler.UnauthorizedException;
import com.models.AccountEntity;
import com.models.CategoryEntity;
import com.models.LoginEntity;
import com.models.ProductEntity;
import com.services.IAccountService;
import com.services.ICategoryService;
import com.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private IAccountService iAccountServices;
    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IProductService iProductService;
    @GetMapping()
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        ///load category
        Iterable<CategoryEntity> categorys = iCategoryService.findAll();
        //load category limit
        Iterable<CategoryEntity> categoryLimit = iCategoryService.findLimit();
        //load product random
        Iterable<ProductEntity> productEntitieRandom = iProductService.findByRandomLimit5();
        modelAndView.addObject("loginEntity", new LoginEntity());
        modelAndView.addObject("category", categorys);
        modelAndView.addObject("categoryLimit", categoryLimit);
        modelAndView.addObject("productEntitieRandom", productEntitieRandom);
        return modelAndView;
    }

    @PostMapping()
    public String login(@ModelAttribute("loginEntity") LoginEntity loginEntity, HttpSession session, Model model) {
        ///load category
        Iterable<CategoryEntity> categorys = iCategoryService.findAll();
        //load category limit
        Iterable<CategoryEntity> categoryLimit = iCategoryService.findLimit();
        model.addAttribute("category", categorys);
        model.addAttribute("categoryLimit", categoryLimit);

        AccountEntity accountEntity = iAccountServices.checkLogin(loginEntity);
        if (accountEntity == null) {
            return "khongloginduoc";
        }
        session.setAttribute("username", accountEntity.getUsername());
        return "index";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status, WebRequest request) {
        status.setComplete();
        request.removeAttribute("username", WebRequest.SCOPE_SESSION);
        return "redirect:/";
    }
    @GetMapping("/testex")
    public String testex() throws TestExep {
        throw new TestExep();
    }

}
