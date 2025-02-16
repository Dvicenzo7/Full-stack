package com.startup.course.config;


import com.startup.course.serialization.converter.YamlJackson2HttpMesageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJackson2HttpMesageConverter());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
//
//        Via Query PARAM. http://localhost:8080/api/person/v1?mediaType=xml
//        configurer.favorParameter(true) //recebe parametro por isso o true
//                .parameterName("mediaType") // pega conforme a URL
//                .ignoreAcceptHeader(true) //ignora parametro no header
//                .useRegisteredExtensionsOnly(false) //
//                .defaultContentType(MediaType.APPLICATION_JSON)
//                .mediaType("json", MediaType.APPLICATION_JSON)
//                .mediaType("xml", MediaType.APPLICATION_XML);

//        Via HEADER PARAM. http://localhost:8080/api/person/v1
        configurer.favorParameter(false) //nao recebe parametro por isso o false
                 .ignoreAcceptHeader(false) //nao ignora parametro no header
                .useRegisteredExtensionsOnly(false) //
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML);
    }
}
