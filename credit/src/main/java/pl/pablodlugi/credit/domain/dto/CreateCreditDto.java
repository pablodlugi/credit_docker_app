package pl.pablodlugi.credit.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pablodlugi.api.CreditDto;
import pl.pablodlugi.api.CustomerDto;
import pl.pablodlugi.api.ProductDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCreditDto {
    private CreditDto credit;
    private CustomerDto customer;
    private ProductDto product;
}
