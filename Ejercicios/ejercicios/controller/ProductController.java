package com.example.ejercicios.controller;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.ejercicios.domain.ProductRepository;
import com.example.ejercicios.domain.product;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
		//Aquí usas inyecciónes de Dependencias 😁
    private final ProductRepository repo;
    public ProductController(ProductRepository repo) { this.repo = repo; }

    @GetMapping("/products/all")
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

    private List<product> listProduct = List.of(
        new product(11, "Pony", "Bebida", 3500, 5),
        new product(12, "leche", "lacteo", 5000, 12),
        new product(13, "yogurt", "lacteo", 3500, 8)
    );

    @GetMapping("/products/stats")
    public Map<String, Double> getStats(@RequestParam(required = false) String category){
         List<product> filteredproduct = listProduct.stream()
         .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
         .collect(Collectors.toList());

         DoubleSummaryStatistics statistics = filteredproduct.stream()
            .mapToDouble(product::getPrice)
            .summaryStatistics();

        return Map.of(
            "count", (double) statistics.getCount(),
            "avgPrice", statistics.getAverage(),
            "minPrice", statistics.getMin(),
            "maxPrice", statistics.getMax(),
            "totalValue", statistics.getSum()
        );
    }

    @GetMapping("/products")
    public List<product> getProducts(
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice,
        @RequestParam(required = false) String category,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ){
        return repo.findAll().stream()
        .filter(p -> minPrice == null || p.getPrice() >= minPrice)
        .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
        .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
        .skip((long) page * size)
        .limit(size)
        .collect(Collectors.toList());
    }
}