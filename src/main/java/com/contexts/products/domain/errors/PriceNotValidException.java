package com.contexts.products.domain.errors;

import com.upax.core.api.http.StatusCodes;
import com.upax.core.api.http.exceptions.HttpException;

/**
 * PriceNotValidException
 * <p>
 * PriceNotValidException
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public class PriceNotValidException extends HttpException {

    public PriceNotValidException() {
        super("Price not valid", "Price must be greater than 1 dollar", StatusCodes.UNPROCESSABLE.code(), "P-02");
    }

}
