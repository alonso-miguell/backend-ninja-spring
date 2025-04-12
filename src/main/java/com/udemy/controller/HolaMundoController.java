package com.udemy.controller;

import java.util.ArrayList;
import java.util.List;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //para indicar que es un Bean -objeto usado por spring
@RequestMapping("/uwu") //para indicador de ruta a nivel clase 


public class HolaMundoController {

    @Autowired
    @Qualifier("exampleService")
    private ExampleService exampleService;

    public static final String VISTA_NOMBRE="holamundo";



    //request mapping es usada anteriormente
    @RequestMapping(value="/holaAlterno",method = RequestMethod.GET) //indicador de ruta a nivel metodo
    public ModelAndView holaMAV(){ //usamos model and view
        ModelAndView mav=new ModelAndView(VISTA_NOMBRE);
        mav.addObject("nameVar", "mike maV");
        mav.addObject("person", new Person("Mike MAV", 30));
        
        
        // mav.addObject("people", getPeople());
        mav.addObject("people", exampleService.getListPeople());
        return mav; //nombre de la vista
    }

    //Anotacion introducida en spring 4.3 es lo mismo que la anterior pero obviando el metodo GET
    @GetMapping("/holamundo") //indicador de ruta a nivel metodo
    public String helloWorld(Model model){
        model.addAttribute("nameVar", "Mike"); //para mandar el dato
        model.addAttribute("person", new Person("Mike", 31)); //para mandar el dato
        model.addAttribute("people", getPeople()); //para mandar el dato
        return VISTA_NOMBRE; //nombre de la vista
    }

    
    List<Person> getPeople(){
        List<Person> people=new ArrayList<>();
        people.add(new Person("Evanie", 26));
        people.add(new Person("Dan", 30));
        people.add(new Person("Bren", 26));
        people.add(new Person("Fab", 31));

        return people;
    }

    
}