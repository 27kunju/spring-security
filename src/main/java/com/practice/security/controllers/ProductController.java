package com.practice.security.controllers;

import com.practice.security.dtos.ProductRequestDto;
import com.practice.security.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * Only ADMIN role can create products (secured in ProductService with @PreAuthorize)
     */
    @PostMapping
    public ResponseEntity<ProductRequestDto> createProduct(@RequestBody ProductRequestDto requestDto) {

        ProductRequestDto product = productService.createProduct(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}