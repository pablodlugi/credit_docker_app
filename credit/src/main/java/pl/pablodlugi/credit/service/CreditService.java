package pl.pablodlugi.credit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pablodlugi.api.create.CustomerDto;
import pl.pablodlugi.api.create.ProductDto;
import pl.pablodlugi.credit.client.CustomerClient;
import pl.pablodlugi.credit.client.ProductClient;
import pl.pablodlugi.credit.domain.dao.Credit;
import pl.pablodlugi.credit.domain.dto.OutCreditDto;
import pl.pablodlugi.credit.mapper.CreditMapper;
import pl.pablodlugi.credit.repository.CreditRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditService {

    private final CreditMapper creditMapper;
    private final CreditRepository creditRepository;
    private final ProductClient productClient;
    private final CustomerClient customerClient;

    public String saveCredit(Credit credit, ProductDto productDto, CustomerDto customerDto) {
        credit.setCreditNumber(UUID.randomUUID().toString());
        productDto.setCreditNumber(credit.getCreditNumber());
        productClient.saveProduct(productDto);
        customerDto.setCreditNumber(credit.getCreditNumber());
        customerClient.saveCustomer(customerDto);
        creditRepository.save(credit);
        return credit.getCreditNumber();
    }

    public List<OutCreditDto> getCredits() {
        List<Credit> credits = creditRepository.getCredits();
        List<String> collect = credits.stream()
                .map(Credit::getCreditNumber)
                .collect(Collectors.toList());

        List<CustomerDto> customers = customerClient.getCustomers(collect);
        List<ProductDto> products = productClient.getProducts(collect);
        List<OutCreditDto> getCreditDtos = new ArrayList<>();

        for (int i=0; i<credits.size(); i++) {
            OutCreditDto outCreditDto = creditMapper.mapToCreateCreditDto(credits.get(i), products.get(i), customers.get(i));
            getCreditDtos.add(outCreditDto);
        }
        return getCreditDtos;
    }
}
