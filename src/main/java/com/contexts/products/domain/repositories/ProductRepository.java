package com.contexts.products.domain.repositories;

import com.contexts.products.domain.entities.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * ProductRepository
 * <p>
 * ProductRepository
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public interface ProductRepository {
    Boolean nameExists(String productName) throws Exception;

    Integer saveProduct(Product product) throws SQLException;

    Boolean isExists(int productId) throws Exception;

    void updateProduct(Product product) throws SQLException;

    Optional<Product> findProduct(int productId) throws Exception;

    List<Product> getProduct() throws Exception;

    void deleteProduct(int productId) throws SQLException;

}
