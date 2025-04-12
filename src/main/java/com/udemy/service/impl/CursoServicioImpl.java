package com.udemy.service.impl;

import java.util.List;

import com.udemy.converter.CursoConverter;
import com.udemy.entity.Curso_spring;
import com.udemy.model.CursoModelo;
import com.udemy.repository.CursoJpaRepository;
import com.udemy.repository.QueryDSLexampleRepo;
import com.udemy.service.CursoService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("cursoServicioImpl")
public class CursoServicioImpl implements CursoService {

    @Autowired
    @Qualifier("cursoJpaRepository")
    private CursoJpaRepository cursoJpaRepository;

    @Autowired
    @Qualifier("cursoConverter")
    private CursoConverter converter;

    

    private static final Log LOGGER = LogFactory.getLog(CursoServicioImpl.class);

    // curso converter se usa aqui

    @Override
    // public Curso_spring addCurso(Curso_spring curso_spring) {
    // return cursoJpaRepository.save(curso_spring) ;
    // }

    public CursoModelo addCurso(CursoModelo modelo) {
        Curso_spring entity = converter.modeloEntidad(modelo);
        CursoModelo modeloResultado = converter.entidadModelo(cursoJpaRepository.save(entity));
        return modeloResultado;
    }

    @Override
    // public List<Curso_spring> listAllCourses() {
    // LOGGER.info("llamada a curso servicio listall");
    // return cursoJpaRepository.findAll();
    // }
    public List<CursoModelo> listAllCourses() {
        LOGGER.info("llamada a curso servicio listall");
        return converter.listaEntidadModelo(cursoJpaRepository.findAll());
    }

    @Override
    public int removeCurso(int id) {
        cursoJpaRepository.deleteById(id);
        return 0;
    }

    @Override
    public CursoModelo updateCurso(CursoModelo modelo) {
        Curso_spring entity = converter.modeloEntidad(modelo);
        cursoJpaRepository.save(entity);
        return null;
    }

    
    
    

}