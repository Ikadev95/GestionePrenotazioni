package com.epicode.GestionePrenotazioni.edificio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EdificioConfig {

    @Bean
    public Edificio edificio1() {
        Edificio edificio = new Edificio();
        edificio.setNome("Edificio A");
        edificio.setIndirizzo("Via Roma 123");
        edificio.setCitta("milano");
        return edificio;
    }

    @Bean
    public Edificio edificio2() {
        Edificio edificio = new Edificio();
        edificio.setNome("Edificio B");
        edificio.setIndirizzo("Corso Vittorio 456");
        edificio.setCitta("torino");
        return edificio;
    }

}
