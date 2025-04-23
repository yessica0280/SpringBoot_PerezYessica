package com.example.ejercicios.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class customersRepository {
    List<Customer> Customers = new ArrayList<>();

    public customersRepository(){
        Customers.add(new Customer(1, "Jaime", "Barrera", "jaenba10@gmail.com"));
        Customers.add(new Customer(2, "Lucía", "Gómez", "lucia.gomez@gmail.com"));
        Customers.add(new Customer(3, "Carlos", "Ramírez", "carlos.ramirez@gmail.com"));
        Customers.add(new Customer(4, "María", "Fernández", "maria.fernandez@gmail.com"));
        Customers.add(new Customer(5, "Andrés", "Pérez", "andres.perez@gmail.com"));
        Customers.add(new Customer(6, "Valentina", "Martínez", "valen.martinez@gmail.com"));
        Customers.add(new Customer(7, "Diego", "López", "diego.lopez@gmail.com"));
        Customers.add(new Customer(8, "Sofía", "Díaz", "sofia.diaz@gmail.com"));
        Customers.add(new Customer(9, "Mateo", "Gutiérrez", "mateo.gutierrez@gmail.com"));
        Customers.add(new Customer(10, "Camila", "Rojas", "camila.rojas@gmail.com"));
        Customers.add(new Customer(11, "Julián", "Sánchez", "julian.sanchez@gmail.com"));
        Customers.add(new Customer(12, "Isabella", "Cano", "isa.cano@gmail.com"));
        Customers.add(new Customer(13, "Tomás", "Moreno", "tomas.moreno@gmail.com"));
        Customers.add(new Customer(14, "Laura", "Vargas", "laura.vargas@gmail.com"));
        Customers.add(new Customer(15, "Samuel", "Castro", "samuel.castro@gmail.com"));
        Customers.add(new Customer(16, "Antonella", "Navarro", "antonella.n@gmail.com"));
        Customers.add(new Customer(17, "Sebastián", "Reyes", "seb.reyes@gmail.com"));
        Customers.add(new Customer(18, "Manuela", "Mendoza", "manuela.mendoza@gmail.com"));
        Customers.add(new Customer(19, "Nicolás", "Ortega", "nicolas.ortega@gmail.com"));
        Customers.add(new Customer(20, "Paula", "Silva", "paula.silva@gmail.com"));
    }
    public List<Customer> findAll() { return Customers; }
}