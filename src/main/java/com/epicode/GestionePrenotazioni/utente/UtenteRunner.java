package com.epicode.GestionePrenotazioni.utente;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Order(2)
public class UtenteRunner implements ApplicationRunner {

    private final UtenteRepo utenteRepo;
    private final UtenteConfig utenteConfig;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        utenteRepo.save(utenteConfig.utente());
        utenteRepo.save(utenteConfig.utente());
        utenteRepo.save(utenteConfig.utente());
    }
}
