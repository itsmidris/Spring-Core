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
}
