package com.contexts.products.infrastructure.handler.request;

import com.contexts.products.domain.entities.Product;
import com.upax.core.api.http.request.annotations.Max;
import com.upax.core.api.http.request.annotations.NotNull;
import com.upax.core.api.http.request.annotations.RequestAggregation;
import lombok.Data;

/**
 * CreateProductRequest
 * <p>
 * CreateProductRequest
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
@RequestAggregation
public @Data class CreateProductRequest {
    @NotNull
    @Max(100)
    private String name;
    @NotNull
    private Double price;
    @NotNull
    private Integer stock;


    public Product toEntity() {
        return new Product(
                0,
                getName(),
                getPrice(),
                getStock()
        );
    }

}
