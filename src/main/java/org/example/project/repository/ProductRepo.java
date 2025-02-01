package org.example.project.repository;

import org.example.project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    public Optional<Product> findByName(String name);
}
