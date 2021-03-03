//package pl.pablodlugi.credit.client;
//
//import com.sun.jndi.toolkit.url.Uri;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.invocation.InvocationOnMock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.web.client.RestTemplate;
//import pl.pablodlugi.api.get.CustomerOutDto;
//import pl.pablodlugi.credit.config.EndpointConfig;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//import static org.mockito.Mockito.when;
//import static org.junit.Assert.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CustomerClientTests {
//
//    @InjectMocks
//    private CustomerClient customerClient;
//
//    @Mock
//    private RestTemplate restTemplate;
//
//    @Mock
//    private EndpointConfig endpointConfig;
//
//    @Test
//    public void shouldReturnCustomerList() throws URISyntaxException {
//        //Given
//        when(endpointConfig.getCustomer()).thenReturn("http://test.com");
//
//        List<CustomerOutDto> customerOutDtos = new ArrayList<>();
//        customerOutDtos.add(new CustomerOutDto("testName", "testSurname", "123456789"));
//
//        URI uri = new URI("http://test.com?numbers=testNumber");
//
//        when(restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<CustomerOutDto>>() {
//        }).getBody()).thenReturn(customerOutDtos);
//
//        List<String> numbers = new ArrayList<>();
//        numbers.add("testNumber");
//
//        //When
//        List<CustomerOutDto> customerOutDtoList = customerClient.getCustomers(numbers);
//
//        //Then
//        assertEquals(1, customerOutDtoList.size());
//        assertEquals("testName", customerOutDtoList.get(0).getFirstName());
//        assertEquals("testSurname", customerOutDtoList.get(0).getSurname());
//        assertEquals("123456789", customerOutDtoList.get(0).getPesel());
//    }
//}
