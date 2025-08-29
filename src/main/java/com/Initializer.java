package com;

import com.api.Routes;
import com.contexts.products.application.*;
import com.contexts.products.infrastructure.sort.FileAssetsProvider;
import com.contexts.products.infrastructure.connection.DbConfig;
import com.contexts.products.infrastructure.connection.MySqlConnectionFactory;
import com.contexts.products.infrastructure.repositories.MySQLProductRepository;
import com.upax.core.api.cloud.aws.lambda.EventPipe;
import com.upax.core.application.Ctx;
import com.upax.core.containers.Initializable;
import com.upax.core.containers.ZDContainer;
import com.upax.core.logger.LoggerConfig;

/**
 * Initializer
 * <p>
 * Dependency Initializer
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public class Initializer implements Initializable {

    @Override
    public void load(ZDContainer di) throws Throwable {

        Ctx.setup(app -> app.configureLogger(LoggerConfig.fromEnv()));

        final var connectionFactory = new MySqlConnectionFactory(DbConfig.fromEnv());
        final var playlistRepository = new MySQLProductRepository(connectionFactory);

        di.register(() -> new CreateProduct(playlistRepository));
        di.register(() -> new UpdateProduct(playlistRepository));
        di.register(() -> new FindProduct(playlistRepository));
        di.register(() -> new GetProduct(playlistRepository));
        di.register(() -> new DeleteProduct(playlistRepository));
        di.register(() -> new GetSortedProduct(new FileAssetsProvider()));

        di.register(() -> connectionFactory);
        di.register(() -> EventPipe.create(Routes.router));
    }
}


