package com.example.productservice.services;

import com.example.productservice.entities.Product;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.getReferenceById(productId);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Long> getAllIds() {
        List<Product> products = productRepository.findAll();
        List<Long> ids = new ArrayList<Long>();
        products.forEach(product -> ids.add(product.getId()));
        return ids;
    }
}
