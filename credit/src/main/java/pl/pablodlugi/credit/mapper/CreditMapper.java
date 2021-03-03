package pl.pablodlugi.credit.mapper;

import org.springframework.stereotype.Component;
import pl.pablodlugi.api.create.CreditDto;
import pl.pablodlugi.api.create.CustomerDto;
import pl.pablodlugi.api.create.ProductDto;
import pl.pablodlugi.credit.domain.dao.Credit;
import pl.pablodlugi.credit.domain.dto.OutCreditDto;

@Component
public class CreditMapper {

    public Credit mapToCredit(final CreditDto creditDto) {
        return Credit.builder()
                .creditName(creditDto.getCreditName())
                .creditNumber(creditDto.getCreditNumber())
                .build();
    }

    public CreditDto mapToCreditDto(final Credit credit) {
        return CreditDto.builder()
                .creditName(credit.getCreditName())
                .creditNumber(credit.getCreditNumber())
                .build();
    }

    public OutCreditDto mapToCreateCreditDto(final Credit credit, final ProductDto productDto, CustomerDto customerDto) {
        return new OutCreditDto(
                customerDto,
                productDto,
                mapToCreditDto(credit)
        );
    }
}
