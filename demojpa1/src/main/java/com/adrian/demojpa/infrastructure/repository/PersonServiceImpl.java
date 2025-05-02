package com.adrian.demojpa.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.adrian.demojpa.application.service.PersonService;
import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.Project;
import com.adrian.demojpa.domain.Rol;
import com.adrian.demojpa.infrastructure.error.RolDuplicateException;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final RolRepository rolRepository;
    private final ProjectRepository projectRepository;

    public PersonServiceImpl(PersonRepository personRepository, RolRepository rolRepository, ProjectRepository projectRepository) {
        this.personRepository = personRepository;
        this.rolRepository = rolRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Person> findAllUsersByFilter(String filter, String value) {
        if(filter.toLowerCase().equals("name") && !value.isEmpty()) {
            return personRepository.findByNameContains(value);
        } else if(filter.toLowerCase().equals("language") && !value.isEmpty()) {
            return personRepository.findByLanguageEquals(value);
        }
        return personRepository.findAll();
    }

    @Override
    public List<Rol> findAllRolesByFilter(String filter, String value) {
        return rolRepository.findAll();
    }

    @Override
    public List<Project> findAllByProjectsFilter(String filter, String value) {
        return projectRepository.findAll();
    }

    @Override
    public Rol createNewRol(String name) {
        Rol newRol = new Rol();
        newRol.setName(name);

        if(getRolByName(name).isPresent()){
            throw new RolDuplicateException("El rol: " + name + " ya esta registrado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rolRepository.save(newRol);
    }

    private Optional<Rol> getRolByName(String rolName){
        return rolRepository.findByName(rolName);
    }

}
