package com.controllers.Admin;

import com.models.CategoryEntity;
import com.models.ProductEntity;
import com.services.ICategoryService;
import com.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Controller
public class ProductAdminController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ICategoryService iCategoryService;
    @PersistenceContext
    private EntityManager entityManager;
    @GetMapping("/admin/product")
    public ModelAndView productAdmin(){
        ModelAndView modelAndView = new ModelAndView("admin/html/resultListProduct");
        Iterable<ProductEntity> products = iProductService.findAll();
        modelAndView.addObject("products",products);
        //load category
        Iterable<CategoryEntity> categorys = iCategoryService.findAll();
        modelAndView.addObject("categorys", categorys);
        modelAndView.addObject("productNew",new ProductEntity());
        return modelAndView;
    }
    @PostMapping("/admin/addproduct")
    public String addProduct(@ModelAttribute("productNew") ProductEntity productEntity){
         iProductService.save(productEntity);
        return "redirect:/admin/product";
    }
    @GetMapping("/admin/deleteProduct")
    public String deleteProduct(@RequestParam int idProductDelete){
        iProductService.delete(idProductDelete);
        return "redirect:/admin/product";
    }
    @PostMapping("/admin/editProduct")
    public String updateProduct(@ModelAttribute("productNew") ProductEntity productEntity){
        entityManager.merge(productEntity);
        return "redirect:/admin/product";
    }
}
