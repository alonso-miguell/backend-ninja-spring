package com.udemy.service;

import java.util.List;

// import com.udemy.entity.Curso_spring;
import com.udemy.model.CursoModelo;

public interface CursoService {
    
    public abstract List<CursoModelo> listAllCourses();
    public abstract CursoModelo addCurso(CursoModelo curso_spring);
    public abstract int removeCurso(int id);
    public abstract CursoModelo updateCurso(CursoModelo curso_spring);
    // 
}