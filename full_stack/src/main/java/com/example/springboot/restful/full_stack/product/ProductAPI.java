package com.example.springboot.restful.full_stack.product;


import jdk.jfr.internal.Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
@RequiredArgsConstructor
public class ProductAPI {
    private final ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {return  ResponseEntity.ok(productService.findAll());}

    @PostMapping
    public ResponseEntity create(@Validated @RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }
     @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
         Optional<Product> stock = productService.finById(id);
         if (!stock.isPresent()) {
             log.error("Id" + id + "is not existed");
             ResponseEntity.badRequest().build();
        }
         return ResponseEntity.ok(stock.get());
     }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id,@Validated @RequestBody Product product){
        if (!productService.finById(id).isPresent()){
            log.error("Id" + id + "is not existed");
            ResponseEntity.badRequest().build();
        }
        return RequestEntity.ok(productService.save(product));
     }
     @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
         if (!productService.finById(id).isPresent()){
             log.error("Id" + id + "is not existed");
             ResponseEntity.badRequest().build();
         }
         productService.deleteById(id);
         return ResponseEntity.ok().build();
     }


}