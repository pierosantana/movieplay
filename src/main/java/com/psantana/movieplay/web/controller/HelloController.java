package com.psantana.movieplay.web.controller;

import com.psantana.movieplay.domain.service.MoviePlayAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    public final MoviePlayAiService aiService;

    private final String plataform;

    public HelloController(@Value("${spring.application.name}")String plataform, MoviePlayAiService aiService) {
        this.plataform = plataform;
        this.aiService = aiService;
    }

    @GetMapping("/hello")
    public String hello() {
        return aiService.generateGreeting(plataform);
    }




}
