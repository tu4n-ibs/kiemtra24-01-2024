package org.example.kiemtrabackend.controller;

import org.example.kiemtrabackend.model.Product;
import org.example.kiemtrabackend.service.ProductImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private ProductImpl productimpl;

    @GetMapping("/home")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("homeF");
        modelAndView.addObject("productList", productimpl.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createF() {
        ModelAndView modelAndView = new ModelAndView("createF");
        modelAndView.addObject("newProduct", new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(Product product) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        productimpl.save(product);
        return modelAndView;
    }

    @GetMapping("/{id}/info")
    public ModelAndView showInfo(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("productView", productimpl.findById(id).get());
        return modelAndView;
    }

    @GetMapping("/{id}/update")
    public ModelAndView updateF(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("updateF");
        modelAndView.addObject("updateProduct", productimpl.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateProduct(Product product) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        productimpl.update(product);
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView deleteProduct(Product product) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        productimpl.delete(product);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchProduct(String keyword) {
        ModelAndView modelAndView = new ModelAndView("homeF");
        modelAndView.addObject("productList", productimpl.findAllByName(keyword));
        return modelAndView;
    }
}
