package org.example.kiemtrabackend.service;

import org.example.kiemtrabackend.model.Product;
import org.example.kiemtrabackend.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductImpl implements ProductService {
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void update(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        iProductRepository.delete(product);
    }

    @Override
    public List<Product> findAllByName(String keyword) {
        return iProductRepository.findAllByNameContains(keyword);
    }

    @Override
    public Optional<Product> findById(int id) {
        return iProductRepository.findById(id);
    }
}
