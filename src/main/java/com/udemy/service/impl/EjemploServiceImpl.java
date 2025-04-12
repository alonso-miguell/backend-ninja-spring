package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("exampleService")
public class EjemploServiceImpl implements ExampleService {

    private static final Log LOGGER=LogFactory.getLog(EjemploServiceImpl.class);
    @Override
    public List<Person> getListPeople() {
        
        List<Person> people=new ArrayList<>();
        people.add(new Person("Evanie", 26));
        people.add(new Person("Dan", 30));
        people.add(new Person("Bren", 26));
        people.add(new Person("Fab", 31));
        LOGGER.info("llamada desde servicio");

        return people;
    
    }
    


}