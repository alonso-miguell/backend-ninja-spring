package com.udemy.entity;

import java.lang.reflect.Array;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.querydsl.core.Tuple;

@Entity
@Table(name = "curso")
public class Curso_spring {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@GeneratedValue  Indica que esa clave se auto genera por medio de auto increment
    @Column(name="id")
    private int id=0;

    @Column(name="nombre")
    private String nombre="";
    
    @Column(name="descripcion")
    private String descripcion="";

    @Column(name="precio")
    private int precio=0;

    @Column(name="horas")
    private int horas=0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Curso_spring(){
        this.id = 0;
        this.nombre = "";
        this.descripcion = "";
        this.precio = 0;
        this.horas = 0;
     }

     public Curso_spring(Tuple tuple){
        Object obj[]= tuple.toArray();
        for(Object obj1 :obj){
            System.out.println("creando obj"+ obj1.toString());

        }

        // for (Tuple row : result) {
        //     System.out.println("firstName " + row.get(employee.firstName));
        //     System.out.println("lastName " + row.get(employee.lastName));
        // }
        
        // this.id = tuple.get(0,int);
        // this.nombre = tuple.nombre;
        // this.descripcion = tuple.descripcion;
        // this.precio = tuple.precio;
        // this.horas = tuple.horas;
     }

    public Curso_spring(int id, String nombre, String descripcion, int precio, int horas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Curso_spring [descripcion=" + descripcion + ", horas=" + horas + ", id=" + id + ", nombre=" + nombre
                + ", precio=" + precio + "]";
    }

    
    
}