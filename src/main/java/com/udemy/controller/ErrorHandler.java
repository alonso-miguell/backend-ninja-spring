package com.udemy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* La clase de manejo de errores nos sirve para personalizar el manejo de errores
en caso de error 500 s[pring ya se encargas del amjeo automatico,
en este acaso al personalizar, nosotros podemos mandar un log o designar
el nombre dde la vista a miostrar, que puede ser diferente a error/500 
*/


//@ControllerAdvice //anotacion para indicar que esta clase se encargara del amnejo de errores
public class ErrorHandler {
    public static final String ERROR_VIEW="error/500 copy";

    //anotacion para indicar que capturara todo tipo de excepciones    
    @ExceptionHandler(Exception.class)

    public String errorGenerico(){
        System.out.println("hubo un error en tiempo de ejecuion");
        return ERROR_VIEW;
    }
    
}