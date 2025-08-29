package com.contexts.products.infrastructure.connection;

import com.upax.core.mappers.jackson.JsonTransformer;
import com.upax.core.utils.Env;

/**
 * DbConfig
 * <p>
 * DbConfig
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public record DbConfig
        (String host,
         String port,
         String database,
         String user,
         String password) {

    public static DbConfig fromEnv() throws Exception {
        String secret = Env.varOrThrow("SECRET_DB");
        return JsonTransformer.toModel(secret, DbConfig.class);
    }


}