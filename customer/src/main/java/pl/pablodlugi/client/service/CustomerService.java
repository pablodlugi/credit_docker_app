package pl.pablodlugi.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pablodlugi.client.domain.Customer;
import pl.pablodlugi.client.repository.CustomerRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void createCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
    }

    public List<Customer> getCustomers(List<String> numbers) {
        return customerRepository.getCustomers(numbers);
    }

}
