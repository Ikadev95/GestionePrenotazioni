package com.epicode.GestionePrenotazioni.prenotazione;

import com.epicode.GestionePrenotazioni.postazione.Postazione;
import com.epicode.GestionePrenotazioni.postazione.PostazioneRepo;
import com.epicode.GestionePrenotazioni.utente.Utente;
import com.epicode.GestionePrenotazioni.utente.UtenteRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
@Component
@Order(3)
public class PrenotazioneRunner implements ApplicationRunner {

    private final UtenteRepo utenteRepo;
    private final PostazioneRepo postazioneRepo;
    private final PrenotazioneService prenotazioneService;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Utente> utenti = utenteRepo.findAll();
        List<Postazione> postazioni = postazioneRepo.findAll();
        LocalDate data = LocalDate.of(2024, 12, 20);
        LocalDate data1 = LocalDate.of(2024, 12, 21);
        prenotazioneService.creaPrenotazione(data,utenti.getFirst(),postazioni.getFirst());
        prenotazioneService.creaPrenotazione(data1,utenti.getLast(),postazioni.getLast());
        prenotazioneService.creaPrenotazione(data1,utenti.get(1),postazioni.getLast());

    }
}
