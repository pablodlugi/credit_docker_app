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
public class ProductDto {
    private String productName;
    private int productValue;
    private String creditNumber;
}
