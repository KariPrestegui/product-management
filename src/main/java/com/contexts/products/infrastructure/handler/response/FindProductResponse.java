package com.contexts.products.infrastructure.handler.response;

import com.contexts.products.domain.entities.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.upax.core.api.http.StatusCodes;
import com.upax.core.api.http.annotations.SuccessResponse;

/**
 * FindProductResponse
 * <p>
 * FindProductResponse
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
@SuccessResponse(status = StatusCodes.SUCCESS)
public record FindProductResponse(
        @JsonProperty("product")
        Product product
) {

    public static FindProductResponse of(Product product) {
        return new FindProductResponse(product);
    }

}
