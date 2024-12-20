package com.epicode.GestionePrenotazioni;

import com.epicode.GestionePrenotazioni.prenotazione.PrenotazioneService;
import com.epicode.GestionePrenotazioni.utente.Utente;
import com.epicode.GestionePrenotazioni.utente.UtenteRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RequiredArgsConstructor
@Component
@Order(5)
public class AppRunner implements ApplicationRunner {

    private final Logger logger;
    private final PrenotazioneService prenotazioneService;
    private final UtenteRepo utenteRepo;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------------------");
        System.out.println("Benvenuto in GestionePrenotazioni");
        System.out.println("-------------------------");
        System.out.println("Seleziona un utente (scrivi l'id): ");

            List<Utente> utenti = utenteRepo.findAll();
            for (int i = 0; i < utenti.size(); i++) {
                System.out.println(utenti.get(i).stampa());
            }
        System.out.println("-------------------------");

            Long id = scanner.nextLong();
            Optional<Utente> utenteScelto = utenteRepo.findById(id);

        System.out.println("seleziona il tipo di postazione: PRIVATO, OPENSPACE, SALA_RIUNIONI");




    }
}
