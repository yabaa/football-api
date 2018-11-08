package com.github.yabaa.footballapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Sets.newHashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /*  Api Info */
    private static final String DESCRIPTION = "Football API";
    private static final String LICENSE = "Football API License";
    private static final String TITLE = "FOOTBALL API";
    private static final String VERSION = "1.0";
    /* Contact Info */
    private static final String CONTACT = "yabaa@github.com";
    private static final String NAME = "Yahya Baassou";
    private static final String WEBSITE = "http://yabaa.github.io";
    /* Protocol */
    private static final String HTTP_PROTOCOL = "http";
    private static final String HTTPS_PROTOCOL = "https";

    private static ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .contact(new Contact(NAME, WEBSITE, CONTACT))
                .termsOfServiceUrl(WEBSITE)
                .license(LICENSE)
                .licenseUrl(WEBSITE)
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .protocols(newHashSet(HTTPS_PROTOCOL, HTTP_PROTOCOL))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/api/.*"))
                .build();
    }

}
