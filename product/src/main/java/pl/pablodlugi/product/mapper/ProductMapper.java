package pl.pablodlugi.product.mapper;

import org.springframework.stereotype.Component;
import pl.pablodlugi.api.create.ProductDto;
import pl.pablodlugi.product.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product mapToProduct(ProductDto productDto) {
        return Product.builder()
                .productName(productDto.getProductName())
                .productValue(productDto.getProductValue())
                .creditNumber(productDto.getCreditNumber())
                .build();
    }

    public ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .productName(product.getProductName())
                .productValue(product.getProductValue())
                .build();
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> creditList) {
        return creditList.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }
}
