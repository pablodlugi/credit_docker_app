package pl.pablodlugi.credit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pablodlugi.api.CustomerDto;
import pl.pablodlugi.api.ProductDto;
import pl.pablodlugi.credit.client.ProductClient;
import pl.pablodlugi.credit.domain.dao.Credit;
import pl.pablodlugi.credit.repository.CreditRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreditService {

    private final CreditRepository creditRepository;
    private final ProductClient productClient;

    public String saveCredit(Credit credit, ProductDto product, CustomerDto customer) {
        credit.setCreditNumber(UUID.randomUUID().toString());
        product.setCreditNumber(credit.getCreditNumber());
        productClient.saveProduct(product);
        customer.setCreditNumber(credit.getCreditNumber());
        creditRepository.save(credit);
        return credit.getCreditNumber();
    }

    public List<Credit> getCredits() {
        return creditRepository.getCredits();
    }

}
