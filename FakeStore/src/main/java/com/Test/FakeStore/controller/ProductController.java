package com.Test.FakeStore.controller;


import com.Test.FakeStore.dto.Product;
import com.Test.FakeStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getProducts() {
        return service.getAllProduct();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category){
        return service.getProductByCategory(category);
    }

    @GetMapping("/categories")
    public List<String> getCategories(){
        return service.getAllCategories();
    }

    @GetMapping("/limit")
    public List<Product> getLimitedProducts(@RequestParam int limit){
        return service.getLimitedProducts(limit);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }
}
