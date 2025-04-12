package com.udemy.repository;

import java.io.Serializable;

import com.udemy.entity.Curso_spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository("cursoJpaRepository")
public interface CursoJpaRepository extends JpaRepository<Curso_spring, Serializable>  {
    //Aqui se declararan los diferentes metodos que implementaran las consultas a la BD

    // public abstract Curso_spring findByPrice(int price);
    // public abstract Curso_spring findByPriceAndName(int price, String name);
    // public abstract Curso_spring findByNameOrderByHours(int price, String name);
    // public abstract List<Curso_spring> findByNameOrderByHours(String name);


}