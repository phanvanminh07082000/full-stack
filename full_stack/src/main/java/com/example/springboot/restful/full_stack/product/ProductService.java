package com.example.springboot.restful.full_stack.product;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> findAll() {return productRepository.findAll();}
    public Optional<Product> finById(Long id) {return productRepository.findById(id);}
    public Product save(Product stock) {return productRepository.save(stock);}
    public void deleteById(Long id) {productRepository.deleteById(id);}

}
