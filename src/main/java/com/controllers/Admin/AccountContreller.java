package com.controllers.Admin;

import com.models.AccountEntity;
import com.models.TypeofaccountEntity;
import com.repositorys.IAccountRepository;
import com.repositorys.ITypeOfAccountRepository;
import com.services.IAccountService;
import com.services.ITypeOfAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AccountContreller {

    @Autowired
    private ITypeOfAccountService typeOfAccountService;
    @Autowired
    private IAccountService accountService;
    @GetMapping("/account")
    public ModelAndView accountAdmin() {
        ModelAndView modelAndView = new ModelAndView("/admin/html/resultListAccount");
        Iterable<AccountEntity> accountListAdmin = accountService.findAll();
        modelAndView.addObject("accountListAdmin", accountListAdmin);
        //load list roles
        ArrayList<TypeofaccountEntity> typeofaccountList = (ArrayList<TypeofaccountEntity>) typeOfAccountService.findAll();
        modelAndView.addObject("typeofaccountList",typeofaccountList);
        modelAndView.addObject("account",new AccountEntity());
        return modelAndView;
    }
    @GetMapping("/deleteaccount")
    public String deleteAcount(@RequestParam int idaccount){
        accountService.delete(idaccount);
        return "redirect:/admin/account";
    }
    @PostMapping("/CreateAccount")
    public String createAccount(@ModelAttribute("account") AccountEntity accountEntity){
        accountService.save(accountEntity);
        return "redirect:/admin/account";
    }
}
