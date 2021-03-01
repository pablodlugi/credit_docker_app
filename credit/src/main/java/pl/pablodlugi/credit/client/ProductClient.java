package pl.pablodlugi.credit.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.pablodlugi.api.ProductDto;
import pl.pablodlugi.credit.config.EndpointConfig;

@RequiredArgsConstructor
@Repository
public class ProductClient {
    private final RestTemplate restTemplate;
    private final EndpointConfig endpointConfig;

    public void saveProduct(ProductDto productDto) {
        restTemplate.postForObject(endpointConfig.getProduct(), productDto, ProductDto.class);
    }

}
