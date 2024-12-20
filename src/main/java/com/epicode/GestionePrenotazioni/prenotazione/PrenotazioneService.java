package com.epicode.GestionePrenotazioni.prenotazione;

import com.epicode.GestionePrenotazioni.postazione.Postazione;
import com.epicode.GestionePrenotazioni.postazione.PostazioneRepo;
import com.epicode.GestionePrenotazioni.utente.Utente;
import com.epicode.GestionePrenotazioni.utente.UtenteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PrenotazioneService {

    private final PrenotazioneRepo prenotazioneRepo;

    public Prenotazione creaPrenotazione(LocalDate data , Utente u, Postazione p){

        boolean esistePUtente = prenotazioneRepo
                .existsByUtenteUsernameAndDataPrenotazione(u.getUsername(), data);

        int numeroPrenotazioni = prenotazioneRepo.countByPostazioneIdAndDataPrenotazione(p.getId(), data);

      if (esistePUtente) {
            throw new IllegalArgumentException("non puoi prenotare più di una postazione per questa data");
        } else if (numeroPrenotazioni  >= p.getNumeroTotaleOccupanti()) {
            throw new IllegalArgumentException("la postazione ha raggiunto il numero massimo di prenotazioni per la data scelta");
        } else {
            Prenotazione prenotazione = new Prenotazione();
            prenotazione.setDataPrenotazione(data);
            prenotazione.setPostazione(p);
            prenotazione.setUtente(u);
            return prenotazioneRepo.save(prenotazione);
        }
    }




}
