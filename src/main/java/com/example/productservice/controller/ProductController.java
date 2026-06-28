package com.example.productservice.controller;

import com.example.productservice.dto.ErrorResponse;
import com.example.productservice.dto.Product;
import com.example.productservice.dto.ProductRequest;
import com.example.productservice.exception.dto.ProductNotFoundException;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getProducts(@PathVariable Integer id) throws ProductNotFoundException {
            Product product=productService.getProductBtId(id).
                    orElseThrow(()->new ProductNotFoundException("Product Not Found"));
            return ResponseEntity.ok().body(product);

    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest product){
        Product product1=productService.createProduct(product);
        return ResponseEntity.status(201).body(product1);
    }

    @GetMapping("/allproducts")
    public ResponseEntity<List<Product>> createProduct(){
        List<Product> products=productService.findAllProducts();
        return ResponseEntity.status(201).body(products);
    }

    //using pagination
    @GetMapping("/getProducts")
    public ResponseEntity<?> getProductsPerPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy) {

        Page<Product> productPage = productService.getProductsByPage(page, size, sortBy);
        return ResponseEntity.ok(productPage);
    }



}
