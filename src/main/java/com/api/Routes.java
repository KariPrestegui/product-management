package com.api;

import com.contexts.products.infrastructure.handler.ProductHandlers;
import com.upax.core.api.handlers.RouteHandler;
import com.upax.core.api.handlers.Router;

/**
 * Routes
 * <p>
 * Routes
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public record Routes() {
    public static final Router router = RouteHandler.create("/gdp", true)
            .with()
            .cors()
            .use(ProductHandlers.class)
            .router;
}


