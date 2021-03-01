package pl.pablodlugi.credit.client;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.pablodlugi.api.CreditDto;
import pl.pablodlugi.credit.config.EndpointConfig;

@RequiredArgsConstructor
@Repository
public class CustomerClient {
    private final RestTemplate restTemplate;
    private final EndpointConfig endpointConfig;

    public void saveCustomer(CreditDto creditDto) {
        restTemplate.postForObject(endpointConfig.getCustomer(), creditDto, CreditDto.class);
    }
}
