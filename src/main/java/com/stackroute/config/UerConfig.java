package com.stackroute.config;


import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UerConfig {
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean servletRegistrationBean= new ServletRegistrationBean(new WebdavServlet());
        servletRegistrationBean.addUrlMappings("/console/*");
        return servletRegistrationBean;
    }
}
