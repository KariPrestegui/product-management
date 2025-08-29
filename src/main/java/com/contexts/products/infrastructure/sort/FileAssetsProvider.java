package com.contexts.products.infrastructure.sort;

/**
 * FileAssetsProvider
 * <p>
 * FileAssetsProvider
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public class FileAssetsProvider {

    public String getFileContent(String fileName) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            try (var inputStream = classLoader.getResourceAsStream(fileName)) {
                if (inputStream == null) {
                    throw new IllegalArgumentException("File not found: " + fileName);
                }
                return new String(inputStream.readAllBytes());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading file " + fileName, e);
        }
    }
}