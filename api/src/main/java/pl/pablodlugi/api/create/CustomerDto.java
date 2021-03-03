package pl.pablodlugi.api.create;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerDto {
    private String firstName;
    private String surname;
    private String pesel;
    private String creditNumber;
}
