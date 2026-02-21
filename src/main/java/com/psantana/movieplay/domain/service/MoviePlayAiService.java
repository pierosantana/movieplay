package com.psantana.movieplay.domain.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface MoviePlayAiService {
    @UserMessage("""
                Genera un saludo de bienvenida a la plataforma de gestión de peliculas {{plataform}}.
                Usa menos de 120 caracteres.
                """)
    String generateGreeting(@V("plataform") String plataform);

}
