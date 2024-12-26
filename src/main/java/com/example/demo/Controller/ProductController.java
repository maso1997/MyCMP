package com.example.demo.Controller;

import com.example.demo.Service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/save")
    public void save (@RequestBody Product product){
        ProductService.save(product);
    }
}
