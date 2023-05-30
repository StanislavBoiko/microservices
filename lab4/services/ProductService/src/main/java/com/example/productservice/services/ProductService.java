package com.example.productservice.services;

import com.example.productservice.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public void addProduct(Product product);

    public Iterable<Product> getAllProducts();

    public Product getProductById(Long productId);

    public void deleteProduct(Long productId);
    public List<Long> getAllIds();
}
