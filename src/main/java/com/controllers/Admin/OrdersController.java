package com.controllers.Admin;

import com.models.OrdersEntity;
import com.services.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrdersController {
    @Autowired
    private IOrdersService iOrdersService;

    @GetMapping("admin/orders")
    public ModelAndView ordersList() {
        ModelAndView modelAndView = new ModelAndView("/admin/html/listOrders");
        Iterable<OrdersEntity> ordersList = iOrdersService.findAll();
        modelAndView.addObject("ordersList", ordersList);
        return modelAndView;
    }

    @ResponseBody
    @GetMapping("admin/orders/delete")
    public Iterable<OrdersEntity> delete(@RequestParam(value = "idOrders", required = false) int idOrders) {
        iOrdersService.delete(idOrders);
        Iterable<OrdersEntity> ordersListDelete = iOrdersService.findAll();
        return ordersListDelete;
    }
}
