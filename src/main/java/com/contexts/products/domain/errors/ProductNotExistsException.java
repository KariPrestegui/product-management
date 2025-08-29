package com.contexts.products.domain.errors;

import com.upax.core.api.http.exceptions.NotFound;

/**
 * ProductNotExistsException
 * <p>
 * ProductNotExistsException
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public class ProductNotExistsException extends NotFound {

    public ProductNotExistsException() {
        super("P-03", "Try to find the existent product", "Product not exists");

    }
}
