package com.contexts.products.application;

import com.contexts.products.domain.errors.PriceNotValidException;
import com.contexts.products.domain.errors.ProductNameAlreadyExistException;
import com.contexts.products.domain.errors.ProductNotExistsException;
import com.contexts.products.domain.repositories.ProductRepository;
import com.contexts.products.infrastructure.handler.request.UpdateProductRequest;
import com.upax.core.application.Case;
import com.upax.core.application.Ctx;

/**
 * UpdateProduct
 * <p>
 * UpdateProduct
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public class UpdateProduct extends Case<UpdateProductRequest, Integer> {
    private final ProductRepository productRepository;

    public UpdateProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Integer execute(UpdateProductRequest request) throws Throwable {
        Ctx.logger().info("Request data for update product: " + request);
        var productIdExist = productRepository.isExists(request.getProductId());
        if (!productIdExist)
            throw new ProductNotExistsException();

        var productNameExist = productRepository.nameExists(request.getName());
        if (productNameExist)
            throw new ProductNameAlreadyExistException();

        if (request.getPrice() < 1)
            throw new PriceNotValidException();

        productRepository.updateProduct(request.toEntity());

        return request.getProductId();
    }
}
