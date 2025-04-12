package com.udemy.converter;

import java.util.ArrayList;

import com.udemy.entity.Curso_spring;
import com.udemy.model.CursoModelo;

import org.springframework.stereotype.Component;
import java.util.List;


@Component("cursoConverter")
public class CursoConverter {
    //Creamos dos metodos para acceder a la entidad

    //De entidad --->Modelo para lectura

    public CursoModelo entidadModelo(final Curso_spring entidad) {
        // setteamos en el modelo los parametros que obtenemos de la entity
        final CursoModelo modelo = new CursoModelo();
        modelo.setDescripcion(entidad.getDescripcion());
        modelo.setHoras(entidad.getHoras());
        modelo.setPrecio(entidad.getPrecio());
        modelo.setNombre(entidad.getNombre());

        return modelo;
    }

    // De modelo---> a entidad para escritura

    public Curso_spring modeloEntidad(final CursoModelo modelo) {
        // setteamos en la entidad los parametros que obtenemos del modelo
        final Curso_spring entidad = new Curso_spring();
        entidad.setDescripcion(modelo.getDescripcion());
        entidad.setHoras(modelo.getHoras());
        entidad.setNombre(modelo.getNombre());
        entidad.setPrecio(modelo.getPrecio());

        return entidad;
    }

    public List<CursoModelo> listaEntidadModelo(List<Curso_spring> listaEntidad){
        List<CursoModelo> listaModelo=new ArrayList<>();
        for(Curso_spring entidad : listaEntidad){
            listaModelo.add( entidadModelo(entidad));
        }
        
        return listaModelo;
    }

    public List<Curso_spring> listaModeloEntidad(List<CursoModelo> listaModelo){
        List<Curso_spring> listaEntidad=new ArrayList<>();
        for(CursoModelo modelo : listaModelo){
            listaEntidad.add( modeloEntidad(modelo));
        }

        return listaEntidad;
    }

}