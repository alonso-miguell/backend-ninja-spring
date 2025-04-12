package com.udemy.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

    private static final Log LOGGER=LogFactory.getLog(RequestTimeInterceptor.class);

    ///Metodo que se ejecutara antes de manejarse las peticiones
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
                //obtenemos la hr actual en ms 
                LOGGER.info("ejecutando preHnadle");
                request.setAttribute("startTime", System.currentTimeMillis());
                return true;
    }

    //Metodo que se ejecutara DESPUES de manjear las peticiones
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

        long startTime= (long) request.getAttribute("startTime");
        long totalTime=System.currentTimeMillis()-startTime;
        LOGGER.info("Ejecutando afterCOmpletion Request desde: " + request.getRequestURL()+" en "+totalTime+" ms");
    }

   
    
}