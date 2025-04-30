package com.adrian.demojpa.infrastructure.repository;

import java.util.List;
import org.springframework.stereotype.Service;
import com.adrian.demojpa.application.service.PersonService;
import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.Project;
import com.adrian.demojpa.domain.Rol;

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

}
