package com.example.demo.Repository;

import com.example.demo.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query ("select p from Product p where pname = :name")
    Product findbyName(String name);
}
