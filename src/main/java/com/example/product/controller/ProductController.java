package com.example.product.controller;

import com.example.product.model.Category;
import com.example.product.model.Product;
import com.example.product.repository.IProductRepository;
import com.example.product.service.ICategoryService;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    private List<Category> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping
    public String findAll(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("product", products);
        return "list";
    }

    @GetMapping("/price")
    public ModelAndView findByPrice(@RequestParam("price") Double price,
                                 @RequestParam("price1") Double price1) {
        List<Product> products = productService.findByPrice(price, price1);
        ModelAndView a = new ModelAndView("list");
        a.addObject("product", products);
        return a;
    }

    @GetMapping("/search")
    public ModelAndView findByName(@RequestParam("name") String name) {
        List<Product> products = productService.findByName(name);
        ModelAndView a = new ModelAndView("list");
        a.addObject("product", products);
        return a;
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product) {
        productService.create(product);
        return "redirect:/products";
    }

    @GetMapping("/update/{id}")
    public String updateForm(Model model,
                             @PathVariable Long id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "create";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute Product product) {
        productService.update(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return "redirect:/products";
    }
}
