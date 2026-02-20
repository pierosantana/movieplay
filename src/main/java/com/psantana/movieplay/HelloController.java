package com.psantana.movieplay;

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

    @GetMapping("/ai")
    public String helloOpenAi() {
        return aiService.generateGreeting(plataform);
    }




}
