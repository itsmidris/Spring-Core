package com.Test.FakeStore.service;


import com.Test.FakeStore.dto.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private RestTemplate template = new RestTemplate();

    private final String URL = "https://fakestoreapi.com/products";

    public List<Product> getAllProduct() {
        Product[] products = template.getForObject(URL, Product[].class);

        return Arrays.asList(products);
    }

    public Product getProductById(int id){
        String url = URL + "/" + id;
        Product product = template.getForObject(url, Product.class);

        return product;
    }

//    When should we use Product.class vs Product[].class?
//    Answer:
//    JSON Object  -> Product.class
//    JSON Array   -> Product[].class
}
