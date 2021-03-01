package pl.pablodlugi.product.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.pablodlugi.product.domain.Product;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Product> productRowMapper = ((resultSet, i) -> new Product(
            resultSet.getLong("id"),
            resultSet.getString("product_name"),
            new Long(resultSet.getLong("product_value")).intValue(),
            resultSet.getString("credit_number")
    ));

    public void save(Product product) {
        jdbcTemplate.update("INSERT INTO product (product_Name, product_Value, credit_number) VALUES (?, ?, ?)",
                product.getProductName(), product.getProductValue(), product.getCreditNumber());
    }

    public List<Product> getProducts() {
        return jdbcTemplate.query("SELECT * FROM product", productRowMapper);
    }

}
