package com.epicode.GestionePrenotazioni.edificio;

import com.epicode.GestionePrenotazioni.postazione.Postazione;
import com.epicode.GestionePrenotazioni.postazione.PostazioneRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
@Order(1)
public class EdificioRunner implements ApplicationRunner {

    private final EdificioService edificioService;
    private final EdificioRepo edificioRepo;
    private final PostazioneRepo postazioneRepo;
    private final Edificio edificio1;
    private final Edificio edificio2;
    private final Postazione postazione1;
    private final Postazione postazione2;
    private final Postazione postazione3;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {

            edificioRepo.save(edificio1);
            edificioRepo.save(edificio2);

            postazioneRepo.save(postazione1);
            postazioneRepo.save(postazione2);
            postazioneRepo.save(postazione3);


        edificioService.salvaEdificioEPostazione(edificio1, Arrays.asList(postazione1, postazione2));
       /* edificioService.salvaEdificioEPostazione(edificio2, Arrays.asList(postazione3));*/
    }
}