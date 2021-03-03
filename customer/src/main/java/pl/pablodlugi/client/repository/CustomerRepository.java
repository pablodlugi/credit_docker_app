package pl.pablodlugi.client.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.pablodlugi.client.domain.Customer;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CustomerRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Customer> customerRowMapper = ((resultSet, i) -> new Customer(
            resultSet.getLong("id"),
            resultSet.getString("first_name"),
            resultSet.getString("surname"),
            resultSet.getString("pesel"),
            resultSet.getString("credit_number")
    ));

    public void saveCustomer(Customer customer) {
        jdbcTemplate.update("INSERT INTO customer (first_name, surname, pesel, credit_number) VALUES (?, ?, ?, ?)",
                customer.getFirstName(), customer.getSurname(), customer.getPesel(), customer.getCreditNumber());
    }

    public List<Customer> getCustomers(List<String> numbers) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("numbers", numbers);
        //mapSqlParameterSource.addValue("numbers", numbers);
        return namedParameterJdbcTemplate.query("SELECT * FROM customer WHERE credit_number in (:numbers)", mapSqlParameterSource ,customerRowMapper);
        //return jdbcTemplate.query("SELECT * FROM customer WHERE credit_number in (:numbers)", mapSqlParameterSource ,customerRowMapper);
    }
}
