package com.practice.security.services;

import com.practice.security.Repository.ProductRepository;
import com.practice.security.dtos.ProductRequestDto;
import com.practice.security.models.products;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Only users with ADMIN role can create products.
     */
    @PreAuthorize("hasRole('USER')")
    public ProductRequestDto createProduct(ProductRequestDto request) {
        // Map DTO -> entity
        products product = products.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

        // Save entity
        products savedProduct = productRepository.save(product);

        // Map entity -> DTO
        return new ProductRequestDto(
                savedProduct.getName(),
                savedProduct.getDescription(),
                savedProduct.getPrice()
        );
    }
}