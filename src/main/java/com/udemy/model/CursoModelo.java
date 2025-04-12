package com.udemy.model;

/*Hacemos un modelo similar a la entity pero sin id ya que no nos interesa recibirlo en la vista
Las entitys NO DEBEN estar ligadas a LOS CONTROLADORES
*/

public class CursoModelo {
    
   
    private String nombre;
    private String descripcion;
    private int precio;
    private int horas;


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

    
}