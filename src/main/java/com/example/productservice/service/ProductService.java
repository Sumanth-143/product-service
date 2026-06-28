package com.example.productservice.service;

import com.example.productservice.dto.Product;
import com.example.productservice.dto.ProductRequest;
import com.example.productservice.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public Product createProduct(ProductRequest product) {
        Product product1=new Product();
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setQuantity(product.getQuantity());
        productRepo.save(product1);
        return product1;

    }

    public Optional<Product> getProductBtId(Integer id) {
        return productRepo.findById(id);
    }

    public List<Product> findAllProducts() {
        List<Product> list=new ArrayList<>();
        list=productRepo.findAll();
        return list;
    }

    public Page<Product> getProductsByPage(int page, int size, String sortBy) {
        int maxSize = Math.min(size, 20);

        // Create the Pageable configuration instance
        Pageable pageable = PageRequest.of(page, maxSize, Sort.by(sortBy).ascending());
        return productRepo.findAll(pageable);
    }
}
