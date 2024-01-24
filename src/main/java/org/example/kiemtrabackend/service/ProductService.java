package org.example.kiemtrabackend.service;

import org.example.kiemtrabackend.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    void update(Product product);
    void delete(Product product);
    List<Product> findAllByName(String keyword);
    Optional<Product> findById(int id);
}
