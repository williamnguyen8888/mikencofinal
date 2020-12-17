package com.controllers.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeAdminController {
    @GetMapping("/admin")
    public ModelAndView homeAdmin(){
        ModelAndView modelAndView = new ModelAndView("admin/html/index");
        return modelAndView;
    }
}
