package pl.pablodlugi.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.pablodlugi.api.create.ProductDto;
import pl.pablodlugi.product.mapper.ProductMapper;
import pl.pablodlugi.product.service.ProductService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public void createProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(productMapper.mapToProduct(productDto));
    }

    @GetMapping
    public List<ProductDto> getProducts(@RequestParam List<String> numbers) {
        return productMapper.mapToProductDtoList(productService.getProducts(numbers));
    }
}
