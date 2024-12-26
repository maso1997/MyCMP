package com.example.demo.Service;

import com.example.demo.Domain.Product;
import com.example.demo.Repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public void save (Product product){
        ProductRepository.save(product);
    }
}
