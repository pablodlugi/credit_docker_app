package pl.pablodlugi.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.pablodlugi.api.create.CustomerDto;
import pl.pablodlugi.client.mapper.CustomerMapper;
import pl.pablodlugi.client.service.CustomerService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @PostMapping
    public void createCustomer(@RequestBody CustomerDto customerDto) {
        customerService.createCustomer(customerMapper.mapToCustomer(customerDto));
    }

    @GetMapping
    public List<CustomerDto> getCustomers(@RequestParam List<String> numbers) {
        return customerMapper.mapToCustomerListDto(customerService.getCustomers(numbers));
    }

}
