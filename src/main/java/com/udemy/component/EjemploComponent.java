package com.udemy.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

//anotacion para definir un componenete
@Component("exampleComponent")
public class EjemploComponent {
    private static final Log LOGGER=LogFactory.getLog(EjemploComponent.class);

    public void hola(){
        LOGGER.info("Hola desde componente");
    }
    
}