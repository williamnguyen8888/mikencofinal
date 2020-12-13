package com.controllers;

import com.models.CategoryEntity;
import com.models.ProductEntity;
import com.services.ICategoryService;
import com.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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