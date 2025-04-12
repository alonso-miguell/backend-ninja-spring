package com.udemy.controller;

import com.udemy.entity.Curso_spring;
//import com.udemy.entity.Curso_spring;
import com.udemy.model.CursoModelo;
import com.udemy.repository.QueryDSLexampleRepo;
import com.udemy.service.impl.CursoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/cursos")
public class CursoController {
    private static final String RUTA_CURSO="cursosVista";

    @Autowired
    @Qualifier("cursoServicioImpl")
    private CursoServicioImpl cursoServicioImpl;

    private static final Log LOGGER=LogFactory.getLog(CursoController.class);

    @Autowired
    @Qualifier("servicioDSL")
    private QueryDSLexampleRepo queryDSLexampleRepo;

    
    @GetMapping("/listacursos")
    public ModelAndView listAllCursos(){
        LOGGER.info("llamada a controlador LISTA ALL");
        ModelAndView mav=new ModelAndView(RUTA_CURSO);
        // LOGGER.info(cursoServicioImpl.listAllCourses().toString());
        mav.addObject("listaCursos", cursoServicioImpl.listAllCourses());
        mav.addObject("nuevoCurso", new CursoModelo());

        LOGGER.info("APUNTO DE LLAMAR A queryDSL");
        // cursoServicioImpl.getCurso(0);
        Curso_spring temporalQuery= queryDSLexampleRepo.getCursobyID(0);

    //    LOGGER.info(queryDSLexampleRepo.getCursobyID(0).toString());
       LOGGER.info("resultado query: " + temporalQuery.toString());
        return mav;
    }

    @PostMapping("/addcurso")
    //recibimos coursemodel
    public RedirectView addCurso (@ModelAttribute("nuevoCurso") CursoModelo curso_spring){
        cursoServicioImpl.addCurso(curso_spring);
        return new RedirectView("/cursos/listacursos");
    }

}