package com.example.demojpa.infraestructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demojpa.domain.Person;

public interface PersonRepository extends JpaRepository< Person,Long>{

    List<Person>findByNameContains(String name);
    List<Person>findByLanguage(String language);
    List<Person> findByLastname(String lastname);
}
