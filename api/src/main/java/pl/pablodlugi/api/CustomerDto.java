package pl.pablodlugi.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerDto {
    private String firstName;
    private String surname;
    private String pesel;
    private String creditNumber;
}
