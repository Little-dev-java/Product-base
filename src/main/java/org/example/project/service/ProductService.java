package org.example.project.service;

import org.example.project.exceptions.ProductAlreadyExistException;
import org.example.project.exceptions.ProductNotFoundEsception;
import org.example.project.exceptions.QuantityException;
import org.example.project.model.Product;
import org.example.project.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repository;

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProduct(int id) throws ProductNotFoundEsception {
        return repository.findById(id).orElseThrow(ProductNotFoundEsception::new);
    }

    public void addProduct(Product product) throws ProductAlreadyExistException {
        if (repository.findByName(product.getName()).isPresent()){
            throw new ProductAlreadyExistException();
        };
        repository.save(product);
    }

    public void updateProduct(Product product, int id) throws ProductNotFoundEsception {
        if (repository.findById(id).isPresent()){
            product.setId(id);
            repository.save(product);
        }
        else {
            throw new ProductNotFoundEsception();
        }
    }

    public void delete(int id) throws ProductAlreadyExistException {
        repository.findById(id).orElseThrow(ProductAlreadyExistException::new);
        repository.deleteById(id);
    }

    public void buyProduct(int id, int quantity) throws ProductNotFoundEsception, QuantityException {
        Product product = repository.findById(id).orElseThrow(ProductNotFoundEsception::new);
        int count = product.getCount() - quantity;
        if (count < 0) {
            throw new QuantityException();
        }
        product.setCount(count);
        repository.save(product);
    }
}
