package com.controllers;

import com.models.AccountEntity;
import com.models.CategoryEntity;
import com.models.LoginEntity;
import com.models.ProductEntity;
import com.services.ICategoryService;
import com.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IProductService iProductService;


    @GetMapping()
    public ModelAndView product(@RequestParam(required = false) String categoryid) {
        ModelAndView modelAndView = new ModelAndView("product");
        modelAndView.addObject("loginEntity", new LoginEntity());
        ///load category
        Iterable<CategoryEntity> categorys = iCategoryService.findAll();
        modelAndView.addObject("category", categorys);

        if (categoryid != null) {
            Iterable<ProductEntity> products = iProductService.findByCategoryid(Integer.parseInt(categoryid));
            modelAndView.addObject("products", products);
            return modelAndView;
        }
        ///load product
        Iterable<ProductEntity> products = iProductService.findAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }


    @RequestMapping("/list-product-api")
    @ResponseBody
    public Iterable<ProductEntity> listprouct() {
        Iterable<ProductEntity> products = iProductService.findAll();
        return products;
    }
}