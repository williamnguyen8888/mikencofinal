package com.controllers;

import com.models.CategoryEntity;
import com.models.ProductEntity;
import com.services.ICategoryService;
import com.services.IProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.json.Json;
import java.time.LocalDate;

@Controller
@RequestMapping("/productdetail")
public class ProductDetailController {
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IProductDetailService productDetailService;

    @GetMapping()
    public ModelAndView product(@RequestParam int idproduct) {
        ModelAndView modelAndView = new ModelAndView("product-detail");
        ///load category
        Iterable<CategoryEntity> categorys = iCategoryService.findAll();
        modelAndView.addObject("category", categorys);
        ///load now time
        modelAndView.addObject("nowtime", LocalDate.now());
        ///load product detail
        ProductEntity productEntity = productDetailService.findById(idproduct);
        modelAndView.addObject("productDetail", productEntity);
        return modelAndView;
    }
    @GetMapping("/productDetailApi")
    @ResponseBody
    public ProductEntity productdetail(@RequestParam int idproduct){
        ProductEntity productEntity = productDetailService.findById(idproduct);
        return productEntity;
    }
}
