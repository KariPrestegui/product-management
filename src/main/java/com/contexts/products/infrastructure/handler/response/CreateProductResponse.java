package com.contexts.products.infrastructure.handler.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.upax.core.api.http.StatusCodes;
import com.upax.core.api.http.annotations.SuccessResponse;

/**
 * CreateProductResponse
 * <p>
 * CreateProductResponse
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
@SuccessResponse(status = StatusCodes.CREATED)
public record CreateProductResponse(
        @JsonProperty("product_id")
        int productId) {

    public static CreateProductResponse of(int productId) {
        return new CreateProductResponse(productId);
    }
}
