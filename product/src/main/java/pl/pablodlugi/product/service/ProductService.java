package pl.pablodlugi.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pablodlugi.product.domain.Product;
import pl.pablodlugi.product.repository.ProductRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getProducts(List<String> numbers) {
        return productRepository.getProducts(numbers);
    }
}
