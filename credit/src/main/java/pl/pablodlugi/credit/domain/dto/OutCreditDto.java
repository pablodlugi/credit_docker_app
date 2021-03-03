package pl.pablodlugi.credit.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pablodlugi.api.create.CreditDto;
import pl.pablodlugi.api.create.CustomerDto;
import pl.pablodlugi.api.create.ProductDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OutCreditDto {
    private CustomerDto customer;
    private ProductDto product;
    private CreditDto credit;
}
