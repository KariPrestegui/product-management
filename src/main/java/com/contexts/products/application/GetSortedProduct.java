package com.contexts.products.application;

import com.contexts.products.domain.entities.Product;
import com.contexts.products.infrastructure.sort.FileAssetsProvider;
import com.contexts.products.infrastructure.sort.SortFileNumbers;
import com.upax.core.application.Case;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * SortFileProduct
 * <p>
 * SortFileProduct
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public class GetSortedProduct extends Case<Void, List<Product>> {
    private final FileAssetsProvider fileAssetsProvider;

    public GetSortedProduct(FileAssetsProvider fileAssetsProvider) {
        this.fileAssetsProvider = fileAssetsProvider;
    }

    @Override
    public List<Product> execute(Void v) {

        try (var pool = Executors.newFixedThreadPool(3)) {
            var result = pool.invokeAll(List.of(
                    new SortFileNumbers("products-1.json", fileAssetsProvider),
                    new SortFileNumbers("products-2.json", fileAssetsProvider),
                    new SortFileNumbers("products-3.json", fileAssetsProvider)
            ));

            List<Product> products = new ArrayList<>();
            for (var f : result) {
                products.addAll(f.get());
            }

            SortFileNumbers.sortByPriceDescending(products);

            if (products.size() >= 10)
                return products.subList(0, 10);

            return products;
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}