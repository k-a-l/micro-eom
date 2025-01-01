package com.kalyan.productservice.service;

import com.kalyan.productservice.dto.ProductRequest;
import com.kalyan.productservice.dto.ProductResponse;
import com.kalyan.productservice.model.Product;
import com.kalyan.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }

    public ProductRequest addProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product added successfully");
        return new ProductRequest(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }



}

