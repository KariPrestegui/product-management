package com.contexts.products.infrastructure.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * MySqlConnectionFactory
 * <p>
 * MySqlConnectionFactory
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public class MySqlConnectionFactory implements AutoCloseable {
    private final DbConfig config;
    private Connection connection;

    public MySqlConnectionFactory(DbConfig config) {
        this.config = config;
    }

    public Connection getConnection() throws SQLException {
        if (connection != null && !connection.isClosed())
            return connection;

        String url = "jdbc:mysql://" + config.host() + ":" + config.port() + "/" + config.database()
                + "?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC"
                + "&useSSL=false&allowPublicKeyRetrieval=true";

        connection = DriverManager.getConnection(url, config.user(), config.password());
        return connection;
    }

    @Override
    public void close() throws Exception {
        if (connection != null && !connection.isClosed())
            connection.close();
        connection = null;
    }
}
