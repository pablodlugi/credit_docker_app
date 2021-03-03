package pl.pablodlugi.credit.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.pablodlugi.credit.domain.dao.Credit;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CreditRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Credit> creditRowMapper = ((resultSet, i) -> new Credit(
            resultSet.getLong("id"),
            resultSet.getString("credit_name"),
            resultSet.getString("credit_number")

    ));

    public void save(Credit credit) {
        jdbcTemplate.update("INSERT INTO credit (credit_name, credit_number) VALUES (?, ?)", credit.getCreditName(), credit.getCreditNumber());
    }

    public List<Credit> getCredits(){
        return jdbcTemplate.query("SELECT * FROM credit", creditRowMapper);
    }

}
