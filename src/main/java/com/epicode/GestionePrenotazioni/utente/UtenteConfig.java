package com.epicode.GestionePrenotazioni.utente;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UtenteConfig {
    @Autowired
    private Faker faker;

    @Bean
    @Scope ("prototype")
    public Utente utente(){
        Utente utente = new Utente();
        utente.setNome(faker.name().fullName());
        utente.setEmail(faker.internet().emailAddress());
        utente.setUsername(faker.name().username());
        return utente;
    }
}
