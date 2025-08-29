package com.contexts.products.application;

import com.contexts.products.domain.entities.Product;
import com.contexts.products.domain.repositories.ProductRepository;
import com.upax.core.application.Case;

import java.util.List;

/**
 * GetProduct
 * <p>
 * GetProduct
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public class GetProduct extends Case<Void, List<Product>> {
    private final ProductRepository productRepository;

    public GetProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> execute(Void v) throws Throwable {

        return productRepository.getProduct();
    }
}
