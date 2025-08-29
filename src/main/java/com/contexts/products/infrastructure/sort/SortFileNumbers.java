package com.contexts.products.infrastructure.sort;

import com.contexts.products.domain.entities.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * SortFileNumbers
 * <p>
 * SortFileNumbers
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public class SortFileNumbers implements Callable<List<Product>> {
    private final String fileName;
    private final FileAssetsProvider fileAssetsProvider;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public SortFileNumbers(String fileName,
                           FileAssetsProvider fileAssetsProvider) {
        this.fileName = fileName;
        this.fileAssetsProvider = fileAssetsProvider;
    }

    @Override
    public List<Product> call() {
        final var content =
                fileAssetsProvider.getFileContent(fileName);
        return convertJsonToProductList(content);
    }


    public List<Product> convertJsonToProductList(String jsonContent) {
        try {
            return objectMapper.readValue(jsonContent,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON to Product list", e);
        }
    }

    public static void sortByPriceDescending(List<Product> products) {
        products.sort(Comparator.comparingDouble(Product::price).reversed());
    }
}
