package com.udemy.repository;

import java.io.Serializable;

import com.udemy.entity.Curso_spring;
import com.udemy.model.CursoModelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository("queryDSL")
public interface QuerydslInterface extends  QuerydslPredicateExecutor<Curso_spring> {
    public abstract Curso_spring getCurso(int id);
}
