package com.epicode.GestionePrenotazioni.faker;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class FakerConfig {

    @Bean
    public Faker getFaker(){
        Faker faker = new Faker(Locale.ITALIAN);
        return faker;
    }
}
