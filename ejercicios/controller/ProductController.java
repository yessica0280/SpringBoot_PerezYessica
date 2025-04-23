package com.example.ejercicios.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.ejercicios.Ejercicios.ProductRepository;
import com.example.ejercicios.Ejercicios.product;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
		//Aquí usas inyecciónes de Dependencias 😁
    private final ProductRepository repo;
    public ProductController(ProductRepository repo) { this.repo = repo; }

    @GetMapping("/products")
    public List<product> getProducts(
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice,
        @RequestParam(required = false) String category
    ) {
      	//Aplica los filtros de minPrice, maxPrice y category, recuerda que pueden aplicarse todos o ninguno
        return repo.findAll().stream()
        .filter(p -> minPrice == null || p.getPrice() >= minPrice)
        .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
        .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
        .collect(Collectors.toList());
    }
}
