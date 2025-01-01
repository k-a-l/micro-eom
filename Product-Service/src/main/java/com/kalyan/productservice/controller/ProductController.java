package com.kalyan.productservice.controller;

import com.kalyan.productservice.dto.ProductRequest;
import com.kalyan.productservice.dto.ProductResponse;
import com.kalyan.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")

public class ProductController {
    private ProductService productService;

        public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping(path = "/")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();

    }

    @PostMapping(path = "/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductRequest addProduct(@RequestBody ProductRequest productRequest) {
        return productService.addProduct(productRequest);

    }
}
