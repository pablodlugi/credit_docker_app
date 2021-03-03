package pl.pablodlugi.credit.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner commandLineRunner(JdbcTemplate jdbcTemplate) {
        return args -> {
            jdbcTemplate.execute("ALTER TABLE `credit` " +
                    "CHANGE COLUMN id " +
                    "id BIGINT NOT NULL AUTO_INCREMENT ;");
        };
    }
}
