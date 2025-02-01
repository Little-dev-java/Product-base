package org.example.project.controller;


import org.example.project.exceptions.ProductAlreadyExistException;
import org.example.project.exceptions.ProductNotFoundEsception;
import org.example.project.exceptions.QuantityException;
import org.example.project.exceptions.UserAlreadyExistException;
import org.example.project.model.Product;
import org.example.project.model.User;
import org.example.project.service.ProductService;
import org.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    public ProductService service;

    @Autowired
    public UserService userService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) throws ProductNotFoundEsception {
        return service.getProduct(id);
    }
    @PostMapping("/products")
    public String addProduct(@RequestBody Product product) throws ProductAlreadyExistException {
        service.addProduct(product);
        return "Product added";
    }
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable int id) throws ProductAlreadyExistException {
        service.delete(id);
        return "Product deleted";
    }
    @PutMapping("products/buy/{id}")
    public String buyProduct(@PathVariable int id, @RequestParam int quantity) throws ProductNotFoundEsception, QuantityException {
        service.buyProduct(id, quantity);
        return "Product bought";
    }
    @PutMapping("products/{id}")
    public String updateProduct(@RequestBody Product product, @PathVariable int id) throws ProductNotFoundEsception {
        service.updateProduct(product, id);
        return "Product updated";
    }
    @PostMapping("/register")
    public String register(@RequestBody User user) throws UserAlreadyExistException {
        userService.register(user);
        return "User registered";
    }
}
