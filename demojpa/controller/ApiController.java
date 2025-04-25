package com.example.demojpa.controller;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demojpa.domain.Person;
import com.example.demojpa.repository.PersonRepository;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {
    

    private final PersonRepository personrepository;

    public ApiController(PersonRepository personrepository) {
        this.personrepository = personrepository;
    }



    @GetMapping("/users")
    public List<Person> findAll(){
        List<Person> results = personrepository.findAll();
        
        return results;
    }
}
