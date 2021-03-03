package pl.pablodlugi.client.mapper;

import org.springframework.stereotype.Component;
import pl.pablodlugi.api.create.CustomerDto;
import pl.pablodlugi.client.domain.Customer;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public Customer mapToCustomer(CustomerDto customerDto) {
        return Customer.builder()
                .firstName(customerDto.getFirstName())
                .surname(customerDto.getSurname())
                .pesel(customerDto.getPesel())
                .creditNumber(customerDto.getCreditNumber())
                .build();
    }

    public CustomerDto mapToCustomerDto(Customer customer){
        return CustomerDto.builder()
                .firstName(customer.getFirstName())
                .surname(customer.getSurname())
                .pesel(customer.getPesel())
                .build();
    }

    public List<CustomerDto> mapToCustomerListDto(List<Customer> customers) {
        return customers.stream()
                .map(this::mapToCustomerDto)
                .collect(Collectors.toList());
    }
}
