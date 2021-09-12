package com.Food.config;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String userId = httpServletRequest.getParameter("userId");

       String url =  httpServletRequest.getRequestURI();

           if(!(url.indexOf("auth") > -1)){
               if (userId == null){
                   httpServletResponse.sendError(403);
               }
           }

       filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
