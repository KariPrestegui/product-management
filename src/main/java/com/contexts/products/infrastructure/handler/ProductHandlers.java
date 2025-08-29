package com.contexts.products.infrastructure.handler;

import com.contexts.products.application.*;
import com.contexts.products.infrastructure.handler.request.*;
import com.contexts.products.infrastructure.handler.response.*;
import com.upax.core.api.http.annotations.HttpMethod;
import com.upax.core.api.http.annotations.ResponseBuilder;
import com.upax.core.api.http.annotations.RouteHandler;
import com.upax.core.application.Ctx;

import static com.upax.core.api.handlers.HttpMethods.*;


/**
 * ProductHandlers
 * <p>
 * ProductHandlers
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
@RouteHandler("/products")
public record ProductHandlers() {

    @ResponseBuilder
    @HttpMethod(type = POST)
    CreateProductResponse createProduct(CreateProductRequest request) throws Throwable {
        var result = Ctx.execute(CreateProduct.class, request);
        return CreateProductResponse.of(result);
    }

    @ResponseBuilder
    @HttpMethod(type = PUT, value = "/{product-id}")
    UpdateProductResponse updateProduct(UpdateProductRequest request) throws Throwable {
        var result = Ctx.execute(UpdateProduct.class, request);
        return UpdateProductResponse.of(result);
    }

    @ResponseBuilder
    @HttpMethod(type = GET)
    GetProductResponse getProducts() throws Throwable {
        var result = Ctx.execute(GetProduct.class);
        return GetProductResponse.of(result);
    }

    @ResponseBuilder
    @HttpMethod(type = GET, value = "{product-id}")
    FindProductResponse findProduct(FindProductRequest request) throws Throwable {
        var result = Ctx.execute(FindProduct.class, request);
        return FindProductResponse.of(result);
    }

    @ResponseBuilder
    @HttpMethod(type = DELETE, value = "/{product-id}")
    DeleteProductResponse deleteProduct(DeleteProductRequest request) throws Throwable {
        var result = Ctx.execute(DeleteProduct.class, request);
        return DeleteProductResponse.of(result);
    }

    @ResponseBuilder
    @HttpMethod(type = GET, value = "/sorted")
    GetProductResponse getSortedProduct() throws Throwable {
        var result = Ctx.execute(GetSortedProduct.class);
        return GetProductResponse.of(result);
    }

}


