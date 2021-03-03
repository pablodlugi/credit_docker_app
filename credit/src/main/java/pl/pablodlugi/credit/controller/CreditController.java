package pl.pablodlugi.credit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.pablodlugi.credit.domain.dto.OutCreditDto;
import pl.pablodlugi.credit.domain.dto.CreditCreateResponse;
import pl.pablodlugi.credit.mapper.CreditMapper;
import pl.pablodlugi.credit.service.CreditService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/credits")
public class CreditController {

    private final CreditService creditService;
    private final CreditMapper creditMapper;

    @PostMapping
    public CreditCreateResponse createCredit(@RequestBody OutCreditDto outCreditDto) {
        return new CreditCreateResponse(creditService.saveCredit(creditMapper.mapToCredit(outCreditDto.getCredit()), outCreditDto.getProduct(), outCreditDto.getCustomer()));
    }

    @GetMapping
    public List<OutCreditDto> getCredits() {
        return creditService.getCredits();
    }
}
