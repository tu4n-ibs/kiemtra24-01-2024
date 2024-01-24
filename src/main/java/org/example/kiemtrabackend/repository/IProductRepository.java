package org.example.kiemtrabackend.repository;

import org.example.kiemtrabackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByNameContains(String keyword);
}
