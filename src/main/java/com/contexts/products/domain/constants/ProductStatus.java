package com.contexts.products.domain.constants;

import lombok.Getter;

/**
 * ProductStatus
 * <p>
 * ProductStatus
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
@Getter
public enum ProductStatus {
    CREATED(1),
    UPDATED(2);

    private final int value;

    ProductStatus(int value) {
        this.value = value;
    }

}
