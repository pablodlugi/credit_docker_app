package pl.pablodlugi.credit.client;


import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.pablodlugi.api.create.CustomerDto;
import pl.pablodlugi.credit.config.EndpointConfig;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class CustomerClient {
    private final RestTemplate restTemplate;
    private final EndpointConfig endpointConfig;

    public void saveCustomer(CustomerDto customerDto) {
        restTemplate.postForObject(endpointConfig.getCustomer(), customerDto, CustomerDto.class);
    }

    public List<CustomerDto> getCustomers(List<String> numbers) {
        return restTemplate.exchange(getUri(numbers), HttpMethod.GET, null, new ParameterizedTypeReference<List<CustomerDto>>() {
        }).getBody();
    }

    private URI getUri(List<String> numbers) {
        URI uri = UriComponentsBuilder.fromHttpUrl(endpointConfig.getCustomer())
                .queryParam("numbers", numbers).build().encode().toUri();
        System.out.println(uri);
        return uri;
    }

}
