package com.example.springboot.restful.full_stack.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping("/")
    public String list(){
        return "products";
    }
}
