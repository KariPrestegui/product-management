package com.contexts.products.infrastructure.repositories;

import com.contexts.products.domain.constants.ProductStatus;
import com.contexts.products.domain.entities.Product;
import com.contexts.products.domain.repositories.ProductRepository;
import com.contexts.products.infrastructure.connection.MySqlConnectionFactory;
import com.upax.core.application.Ctx;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
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
public class MySQLProductRepository implements ProductRepository {
    private final MySqlConnectionFactory connection;

    public MySQLProductRepository(MySqlConnectionFactory connection) {
        this.connection = connection;
    }

    @Override
    public Boolean nameExists(String productName) throws Exception {
        var conn = connection.getConnection();
        var st = conn.prepareCall("{CALL PRODUCT.GDP_SP_PRODUCT_NAME_EXISTS(?,?)}");
        st.setString(1, productName);
        st.registerOutParameter(2, Types.BOOLEAN);
        st.execute();

        return st.getBoolean(2);
    }

    @Override
    public Integer saveProduct(Product product) throws SQLException {
        var conn = connection.getConnection();
        var st = conn.prepareCall("{CALL PRODUCT.GDP_SP_INSERT_PRODUCT(?,?,?,?,?,?)}");
        st.setString(1, product.name());
        st.setDouble(2, product.price());
        st.setInt(3, product.stock());
        st.setInt(4, ProductStatus.CREATED.getValue());
        st.setString(5, Ctx.setup().appName());
        st.registerOutParameter(6, Types.INTEGER);
        st.execute();

        return st.getInt(6);

    }

    @Override
    public Boolean isExists(int productId) throws Exception {
        var conn = connection.getConnection();
        var st = conn.prepareCall("{CALL PRODUCT.GDP_SP_PRODUCT_EXISTS(?,?)}");
        st.setInt(1, productId);
        st.registerOutParameter(2, Types.BOOLEAN);
        st.execute();

        return st.getBoolean(2);

    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        var conn = connection.getConnection();
        var st = conn.prepareCall("{CALL PRODUCT.GDP_SP_UPDATE_PRODUCT(?,?,?,?,?,?)}");
        st.setInt(1, product.id());
        st.setString(2, product.name());
        st.setDouble(3, product.price());
        st.setInt(4, product.stock());
        st.setInt(5, ProductStatus.UPDATED.getValue());
        st.setString(6, Ctx.setup().appName());
        st.execute();

    }

    @Override
    public Optional<Product> findProduct(int productId) throws Exception {
        var conn = connection.getConnection();
        var st = conn.prepareCall("{CALL PRODUCT.GDP_SP_FIND_PRODUCT_BY_ID(?)}");

        try (ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                return Optional.of(new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getDouble("product_price"),
                        rs.getInt("product_stock")
                ));
            }
            return Optional.empty();
        }

    }

    @Override
    public List<Product> getProduct() throws Exception {
        var conn = connection.getConnection();
        var st = conn.prepareCall("{CALL SIDI_CMS_MONITORING.GDP_SP_GET_PRODUCT()}");

        List<Product> products = new ArrayList<>();
        try (ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getDouble("product_price"),
                        rs.getInt("product_stock")
                ));
            }
            return products;
        }
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        var conn = connection.getConnection();
        var st = conn.prepareCall("{CALL PRODUCT.GDP_SP_DELETE_PRODUCT(?)}");
        st.setInt(1, productId);
        st.execute();
    }
}
