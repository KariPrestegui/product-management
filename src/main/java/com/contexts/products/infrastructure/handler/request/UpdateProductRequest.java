package com.contexts.products.infrastructure.handler.request;

import com.contexts.products.domain.entities.Product;
import com.upax.core.api.http.request.annotations.Aggregate;
import com.upax.core.api.http.request.annotations.NotNull;
import com.upax.core.api.http.request.annotations.RequestAggregation;
import com.upax.core.api.http.request.fields.Origins;
import lombok.Data;

/**
 * UpdateProductRequest
 * <p>
 * UpdateProductRequest
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
@RequestAggregation
public @Data class UpdateProductRequest {
    @NotNull
    @Aggregate(origin = Origins.PATH, name = "product-id")
    private Integer productId;
    @NotNull
    private String name;
    @NotNull
    private Double price;
    @NotNull
    private Integer stock;

    public Product toEntity() {
        return new Product(
                getProductId(),
                getName(),
                getPrice(),
                getStock()
        );
    }

}
