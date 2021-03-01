package pl.pablodlugi.credit.mapper;

import org.springframework.stereotype.Component;
import pl.pablodlugi.api.CreditDto;
import pl.pablodlugi.credit.domain.dao.Credit;

@Component
public class CreditMapper {

    public Credit mapToCredit(CreditDto creditDto) {
        return Credit.builder()
                .creditName(creditDto.getCreditName())
                .creditNumber(creditDto.getCreditNumber())
                .build();
    }

    public CreditDto mapToCredit(Credit credit) {
        return CreditDto.builder()
                .creditName(credit.getCreditName())
                .creditNumber(credit.getCreditNumber())
                .build();
    }

//    public Credit mapToCredit(CreditDto creditDto) {
//        return new Credit(
//                creditDto.getCreditName(),
//                creditDto.getCreditNumber()
//        );
//    }
//
//    public CreditDto mapToCreditDto(Credit credit) {
//        return new CreditDto(
//                credit.getCreditName(),
//                credit.getCreditNumber()
//        );
//    }
}
