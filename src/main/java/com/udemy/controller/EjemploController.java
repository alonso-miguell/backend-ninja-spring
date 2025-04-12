package com.udemy.controller;

import javax.validation.Valid;

import com.udemy.component.EjemploComponent;
import com.udemy.model.Person;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/ejemplo")
public class EjemploController {

    @Autowired // para indicar que inyectaremos un componenete
    @Qualifier("exampleComponent") // indicamos el nombre del componenete de spring a inyectar
    private EjemploComponent ejemploComponent; // declaramso la clase d enuestro com ponente

    private static final String RUTA = "ejemploGet";

    private static final Log LOGGER = LogFactory.getLog(EjemploController.class); // clase responsable del log

    // colocamos @RequestParam antes del string nombre para indicar que esa variable
    // tomara el valor desde la ruta
    // nameVar es el nombre del atributo en la ruta
    // required=false en caso de no venir la variable no tirar un error

    // localhost:8080/ejemplo/request1?nameVar=MIGUEL
    @GetMapping("request1")
    public ModelAndView request1(
            @RequestParam(name = "nameVar", required = false, defaultValue = "NULO") String nombre) {
        ModelAndView mav = new ModelAndView(RUTA);

        ejemploComponent.hola(); // //llamamos el componente sin ne cesidad de instanciarlo
        mav.addObject("nombre_en_Modelo", nombre);
        return mav;
    }

    // Similar a como codeigniter
    // localhost:8080/ejemplo/request2/MIGUEL
    @GetMapping("request2/{nameVar}")
    public ModelAndView request2(@PathVariable("nameVar") String nombre) {
        ModelAndView mav = new ModelAndView(RUTA);
        mav.addObject("nombre_en_Modelo", nombre);
        return mav;
    }

    @GetMapping("postExample")
    public ModelAndView request3(
            @RequestParam(name = "nameVar", required = false, defaultValue = "NULO") String nombre) {
        //int a=6/0;
        LOGGER.info("nuevo log");
        LOGGER.warn("nuevo log");
        LOGGER.error("nuevo log");
        ModelAndView mav = new ModelAndView("ejemploPost");
        mav.addObject("personPOST", new Person());
        return mav;
    }

    // para POST
    @PostMapping("addperson") // indica q es peticion POST

    // @Valid es par aindicar que el atributo sera pasado por una validacion
    // @ModelAttribute para indicar que es unb atributo q se pasara a la vista
    // Binding result será el objeto que validarael formulario y guardara los
    // errores
    public ModelAndView muestrapersona(@Valid @ModelAttribute("personPOST") Person person, BindingResult bindingResult) {
        LOGGER.info("Persona enviada " + person.toString());
        ModelAndView mav = new ModelAndView();
        LOGGER.info(bindingResult.toString());
        if(bindingResult.hasErrors()){  //si hay errores en la vista
            mav.setViewName("ejemploPost");
        }
        else{ //si no hay errores
            mav.setViewName("postResult");
            mav.addObject("resultado", person);
        }

        return mav;
    }

    // para redireccionar
    @GetMapping("/")
    public RedirectView redirect() {
        return new RedirectView("/ejemplo/postExample");
    }

    // version alterna de redireccionamiento
    // @GetMapping("/")
    // public String redirect2(){
    // return "redirect:/ejemplo/postExample";
    // }

}