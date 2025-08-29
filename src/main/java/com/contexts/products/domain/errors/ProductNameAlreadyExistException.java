package com.contexts.products.domain.errors;

import com.upax.core.api.http.StatusCodes;
import com.upax.core.api.http.exceptions.HttpException;

/**
 * ProductAlreadyExistException
 * <p>
 * ProductAlreadyExistException
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public class ProductNameAlreadyExistException extends HttpException {

    public ProductNameAlreadyExistException() {
        super("Product already exists", "Product duplicate", StatusCodes.CONFLICT.code(), "P-01");
    }

}
