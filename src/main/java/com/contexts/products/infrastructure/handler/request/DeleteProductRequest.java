package com.contexts.products.infrastructure.handler.request;

import com.upax.core.api.http.request.annotations.Aggregate;
import com.upax.core.api.http.request.annotations.NotNull;
import com.upax.core.api.http.request.annotations.RequestAggregation;
import com.upax.core.api.http.request.fields.Origins;
import lombok.Data;

/**
 * DeleteProductRequest
 * <p>
 * DeleteProductRequest
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
@RequestAggregation
public @Data class DeleteProductRequest {
    @NotNull
    @Aggregate(origin = Origins.PATH, name = "product-id")
    private Integer productId;
}
