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
public class CreditDto {
    private String creditName;
    private String creditNumber;
}
