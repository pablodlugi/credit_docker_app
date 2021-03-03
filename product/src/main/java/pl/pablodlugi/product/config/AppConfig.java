package pl.pablodlugi.product.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AppConfig {

    @Bean
    public CommandLineRunner commandLineRunner(JdbcTemplate jdbcTemplate) {
        return args -> {
            jdbcTemplate.execute("ALTER TABLE `product` " +
                    "CHANGE COLUMN id " +
                    "id BIGINT NOT NULL AUTO_INCREMENT ;");
        };
    }
}
