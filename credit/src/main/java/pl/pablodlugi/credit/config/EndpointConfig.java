package pl.pablodlugi.credit.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
@ConfigurationProperties(prefix = "endpoints")
public class EndpointConfig {
    private String product;
    private String customer;
}
