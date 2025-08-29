package com.contexts.products.infrastructure.handler.response;

import com.contexts.products.domain.entities.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.upax.core.api.http.StatusCodes;
import com.upax.core.api.http.annotations.SuccessResponse;

import java.util.List;

/**
 * GetProductResponse
 * <p>
 * GetProductResponse
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
@SuccessResponse(status = StatusCodes.SUCCESS)
public record GetProductResponse(@JsonProperty("products")
                                 List<Product> products) {

    public static GetProductResponse of(List<Product> products) {
        return new GetProductResponse(products);
    }


}
