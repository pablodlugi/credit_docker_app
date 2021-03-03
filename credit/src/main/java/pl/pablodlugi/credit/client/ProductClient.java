package pl.pablodlugi.credit.client;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.pablodlugi.api.create.ProductDto;
import pl.pablodlugi.credit.config.EndpointConfig;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class ProductClient {
    private final RestTemplate restTemplate;
    private final EndpointConfig endpointConfig;

    public void saveProduct(ProductDto productDto) {
        restTemplate.postForObject(endpointConfig.getProduct(), productDto, ProductDto.class);
    }

    public List<ProductDto> getProducts(List<String> numbers) {
        URI uri = UriComponentsBuilder.fromUriString(endpointConfig.getProduct()).queryParam("numbers", numbers).build().toUri();
        return restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductDto>>() {
        }).getBody();
    }

}
