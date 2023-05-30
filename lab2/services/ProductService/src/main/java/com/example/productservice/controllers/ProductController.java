package com.example.productservice.controllers;

import com.example.productservice.entities.Product;
import com.example.productservice.services.ProductService;
import com.example.productservice.services.ProductServiceImpl;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;


    @PostMapping("product")
    public ResponseEntity createProduct(@RequestBody JSONObject jsonReq){
        var product = new Product();
        product.setName(jsonReq.getAsString("Name"));
        product.setPrice((long)jsonReq.getAsNumber("Price"));
        productService.addProduct(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping("product")
    public ResponseEntity getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("product/{productId}")
    public ResponseEntity getProductById(@PathVariable Long productId){
        return ResponseEntity.ok(productService.getProductById(productId));
    }

}
