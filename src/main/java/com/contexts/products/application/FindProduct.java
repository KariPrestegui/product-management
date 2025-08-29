package com.contexts.products.application;

import com.contexts.products.domain.entities.Product;
import com.contexts.products.domain.errors.ProductNotExistsException;
import com.contexts.products.domain.repositories.ProductRepository;
import com.contexts.products.infrastructure.handler.request.FindProductRequest;
import com.upax.core.application.Case;
import com.upax.core.application.Ctx;

/**
 * FindProduct
 * <p>
 * FindProduct
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public class FindProduct extends Case<FindProductRequest, Product> {
    private final ProductRepository productRepository;

    public FindProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product execute(FindProductRequest request) throws Throwable {
        Ctx.logger().info("Request data for find product: " + request);

        var productIdExist = productRepository.isExists(request.getProductId());
        if (!productIdExist)
            throw new ProductNotExistsException();

        return productRepository.findProduct(request.getProductId())
                .orElse(null);
    }
}
