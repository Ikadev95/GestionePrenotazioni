package com.epicode.GestionePrenotazioni;

import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class AppRunner implements ApplicationRunner {
    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

    }
}
