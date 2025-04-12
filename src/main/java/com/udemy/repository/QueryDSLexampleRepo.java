package com.udemy.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Curso_spring;
import com.udemy.entity.QCurso_spring;
import com.udemy.model.CursoModelo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service("servicioDSL")
public class QueryDSLexampleRepo implements QuerydslInterface {

    // entidad Q generada por queryDSL
    private QCurso_spring qCurso = QCurso_spring.curso_spring;

    private static final Log LOGGER=LogFactory.getLog(QueryDSLexampleRepo.class);
    
    @PersistenceContext
    private EntityManager em; // objeto que gestiona la persistencia de las entidades de la aplicacion

    public Curso_spring getCursobyID(int id) {

        JPAQuery<Curso_spring> query = new JPAQuery<Curso_spring>(em); // objeto JPAQUERY

        BooleanBuilder predicateBuilder = new BooleanBuilder(qCurso.id.eq(2)); // conbtructor de
                                                                                                 // predicados

        if (id == 0) {
            // Predicate predicado = qCurso.id.eq(2);
            // predicateBuilder.and(predicado);
        } else {
            Predicate predicado2 = qCurso.nombre.endsWith("OP");
            predicateBuilder.and(predicado2);
        }
        LOGGER.info("desde el query builder  ejecutando id: "+id + " "+predicateBuilder.toString());

        // realizamos la query
        // en el select podemos especificar las columnas que queremos retraer
        return new Curso_spring(query.select(qCurso.id, qCurso.descripcion).from(qCurso).where( qCurso.nombre.eq("angular") ).fetchOne());
    }

    
    @Override
    public Optional<Curso_spring> findOne(Predicate predicate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Curso_spring> findAll(Predicate predicate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Curso_spring> findAll(Predicate predicate, Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Curso_spring> findAll(Predicate predicate, OrderSpecifier<?>... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Curso_spring> findAll(OrderSpecifier<?>... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Curso_spring> findAll(Predicate predicate, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count(Predicate predicate) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean exists(Predicate predicate) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Curso_spring getCurso(int id) {
        // TODO Auto-generated method stub
        return null;
    }

   
    // @Override
    // public CursoModelo getCurso(int id) {
    //     CursoModelo curso=converter.entidadModelo(queryDSLexampleRepo.findbyID(id));
    //     LOGGER.info(curso.toString());
    //     return curso;
    // }
    

}