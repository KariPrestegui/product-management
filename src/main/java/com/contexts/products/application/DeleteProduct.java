package com.contexts.products.application;

import com.contexts.products.domain.errors.ProductNotExistsException;
import com.contexts.products.domain.repositories.ProductRepository;
import com.contexts.products.infrastructure.handler.request.DeleteProductRequest;
import com.upax.core.application.Case;
import com.upax.core.application.Ctx;

/**
 * DeleteProduct
 * <p>
 * DeleteProduct
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public class DeleteProduct extends Case<DeleteProductRequest, Integer> {
    private final ProductRepository productRepository;

    public DeleteProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Integer execute(DeleteProductRequest request) throws Throwable {
        Ctx.logger().info("Request data for update product: " + request);
        var productIdExist = productRepository.isExists(request.getProductId());
        if (!productIdExist)
            throw new ProductNotExistsException();

        productRepository.deleteProduct(request.getProductId());

        return request.getProductId();
    }
}
