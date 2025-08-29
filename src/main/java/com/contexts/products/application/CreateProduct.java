package com.contexts.products.application;

import com.contexts.products.domain.errors.PriceNotValidException;
import com.contexts.products.domain.errors.ProductNameAlreadyExistException;
import com.contexts.products.domain.repositories.ProductRepository;
import com.contexts.products.infrastructure.handler.request.CreateProductRequest;
import com.upax.core.application.Case;
import com.upax.core.application.Ctx;

/**
 * CreateProduct
 * <p>
 * CreateProduct
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public class CreateProduct extends Case<CreateProductRequest, Integer> {
    private final ProductRepository productRepository;

    public CreateProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Integer execute(CreateProductRequest request) throws Throwable {
        Ctx.logger().info("Request data for create product: " + request);
        var productNameExist = productRepository.nameExists(request.getName());

        if (productNameExist)
            throw new ProductNameAlreadyExistException();

        if (request.getPrice() < 1)
            throw new PriceNotValidException();

        return productRepository.saveProduct(request.toEntity());
    }
}
