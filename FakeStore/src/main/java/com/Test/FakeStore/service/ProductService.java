package com.Test.FakeStore.service;

import com.Test.FakeStore.dto.Product;
import com.Test.FakeStore.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    private RestTemplate template = new RestTemplate();

    private final String URL = "https://fakestoreapi.com/products";

    public List<Product> getAllProduct() {
        log.info("Fetching all products");

        Product[] products = template.getForObject(URL, Product[].class);

        return Arrays.asList(products);
    }

    public Product getProductById(int id){
        log.info("Fetching product with id: {}",id);

        String url = URL + "/" + id;
        Product product = template.getForObject(url, Product.class);

        if (product == null) {
            log.warn("Product not found with id: {}",id);
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        log.info("Product fetched Successfully: {}",product.getTitle());

        return product;
    }

//    When should we use Product.class vs Product[].class?
//    Answer:
//    JSON Object  -> Product.class
//    JSON Array   -> Product[].class

    public List<Product> getProductByCategory(String category){
        String url = URL + "/category/" + category;
        Product[] products = template.getForObject(url, Product[].class);

        if (products == null){
            return List.of();
        }

        return Arrays.asList(products);
    }

    public List<String> getAllCategories(){
        String url = URL + "/categories";
        String[] categories = template.getForObject(url, String[].class);

        if (categories == null){
            return List.of();
        }

        return Arrays.asList(categories);
    }

    public List<Product> getLimitedProducts(int limit){
        String url = URL + "?limit=" + limit;
        Product[] products = template.getForObject(url, Product[].class);

        if (products == null){
            return List.of();
        }
        return Arrays.asList(products);
    }

    public Product addProduct(Product product){
        Product response = template.postForObject(URL,product,Product.class);
        return response;
    }

    public Product updateProduct(int id, Product product){
        String url = URL + "/" + id;

        HttpEntity<Product> entity = new HttpEntity<>(product);

        ResponseEntity<Product> response = template.exchange(url, HttpMethod.PUT,entity,Product.class);

        return response.getBody();
    }

    public void deleteProduct(int id){
        String url = URL + "/" + id;
        template.delete(url);
    }
}
