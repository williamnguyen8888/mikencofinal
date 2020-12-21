package com.controllers;

import com.models.ProductEntity;
import com.services.ICartService;
import com.services.ICategoryService;
import com.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Controller
public class CartController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ICartService iCartService;

    @GetMapping("cart")
    public ModelAndView cart(HttpServletRequest request){
        HttpSession session = request.getSession(); // create session
        ModelAndView modelAndView = new ModelAndView("cart");
        ArrayList<ProductEntity> productListCart = (ArrayList<ProductEntity>) session.getAttribute("productListCart");
        if (productListCart == null){
            modelAndView.setViewName("redirect:/");
        }else {
            modelAndView.addObject("productListCart",productListCart);
        }
        return modelAndView;
    }

    @ResponseBody
    @GetMapping("/addToCart")
    public ProductEntity addProductToCart(@RequestParam(required = false) int idProduct, HttpServletRequest request) {
        HttpSession session = request.getSession(); // create session
        ProductEntity productCart = iProductService.finById(idProduct);
        ArrayList<ProductEntity> productListCart = (ArrayList<ProductEntity>) session.getAttribute("productListCart");

        if (productListCart == null) {
            productListCart = new ArrayList<>();
            productListCart.add(productCart);
            session.setAttribute("productListCart", productListCart);
        } else {
            productListCart.add(productCart);
            session.setAttribute("productListCart", productListCart);
        }
//        response.setStatus(200);
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
        System.out.println(productListCart.size());
        return productCart;
    }

    @GetMapping("/addCartDB")
    public String addCartDB( HttpServletRequest request){
        HttpSession session = request.getSession(); // create session
        ArrayList<ProductEntity> productListCart = (ArrayList<ProductEntity>) session.getAttribute("productListCart");
        if (productListCart == null){
            return "redirect:/";
        }else {
            String idCustomer= String.valueOf(session.getAttribute("idCustomer")) ;
            if (idCustomer== null){
                return "redirect:/";
            }else {
                iCartService.cartAddToDB(productListCart,idCustomer);
                return "checkoutDone";
            }
        }

    }

    @ResponseBody
    @GetMapping("/cart-api")
    public ArrayList<ProductEntity> cartAPI(HttpServletRequest request) {
        HttpSession session = request.getSession(); // create session
        ArrayList<ProductEntity> products = (ArrayList<ProductEntity>) session.getAttribute("productListCart");
        if (products == null){
            return null;
        }
        return products;
    }

}
