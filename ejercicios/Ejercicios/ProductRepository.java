package com.example.ejercicios.Ejercicios;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class ProductRepository {
  // Agrega 20 products con datos de ejemplo
  List<product> products = new ArrayList<>();

  public ProductRepository(){
    products.add(new product(1, "Gaseosa", "Bebida", 2500, 10));
    products.add(new product(2, "Agua", "Bebida", 1500, 20));
    products.add(new product(3, "Jugo de Naranja", "Bebida", 3000, 15));
    products.add(new product(4, "Cerveza", "Bebida", 3500, 12));
    products.add(new product(5, "Energizante", "Bebida", 4000, 8));
    products.add(new product(6, "Té Helado", "Bebida", 2800, 10));
    products.add(new product(7, "Café", "Bebida", 2000, 25));
    products.add(new product(8, "Leche", "Lácteo", 2300, 18));
    products.add(new product(9, "Yogur", "Lácteo", 2700, 14));
    products.add(new product(10, "Chocolate Caliente", "Bebida", 3200, 9));
    products.add(new product(11, "Limonada", "Bebida", 2900, 11));
    products.add(new product(12, "Smoothie", "Bebida", 4500, 6));
    products.add(new product(13, "Soda Italiana", "Bebida", 3700, 7));
    products.add(new product(14, "Malteada", "Bebida", 4800, 5));
    products.add(new product(15, "Agua con Gas", "Bebida", 1800, 16));
    products.add(new product(16, "Refresco", "Bebida", 2600, 13));
    products.add(new product(17, "Gaseosa Dietética", "Bebida", 2500, 10));
    products.add(new product(18, "Té Verde", "Bebida", 3000, 9));
    products.add(new product(19, "Kombucha", "Bebida", 5000, 4));
    products.add(new product(20, "Jugo de Mango", "Bebida", 3100, 10));
  }
  public List<product> findAll() { return products; }
}