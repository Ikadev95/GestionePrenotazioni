package com.epicode.GestionePrenotazioni.postazione;


import com.epicode.GestionePrenotazioni.enums.TipoPostazione;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostazioneConfig {


    @Bean
    public Postazione postazione1() {
        Postazione postazione = new Postazione();
        postazione.setCodice("P001");
        postazione.setDescrizione("Postazione privata al piano 1");
        postazione.setTipoPostazione(TipoPostazione.PRIVATO);
        postazione.setNumeroTotaleOccupanti(4);
        return postazione;
    }

    @Bean
    public Postazione postazione2() {
        Postazione postazione = new Postazione();
        postazione.setCodice("P002");
        postazione.setDescrizione("Postazione open space piano 2");
        postazione.setTipoPostazione(TipoPostazione.OPENSPACE);
        postazione.setNumeroTotaleOccupanti(12);
        return postazione;
    }

    @Bean
    public Postazione postazione3() {
        Postazione postazione = new Postazione();
        postazione.setCodice("P003");
        postazione.setDescrizione("Sala riunioni piano 3");
        postazione.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
        postazione.setNumeroTotaleOccupanti(2);
        return postazione;
    }
}
