package com.epicode.GestionePrenotazioni.prenotazione;

import com.epicode.GestionePrenotazioni.postazione.Postazione;
import com.epicode.GestionePrenotazioni.utente.Utente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PrenotazioneService {

    private PrenotazioneRepo prenotazioneRepo;

    public Prenotazione creaPrenotazione(LocalDate data , Utente u, Postazione p){

        Optional<Prenotazione> pEsistente = prenotazioneRepo.findByPostazioneIdAndDataPrenotazione
                (p.getId(), data);

        boolean esistePUtente = prenotazioneRepo
                .existsByUtenteUsernameAndDataPrenotazione(u.getUsername(), data);

        int numeroPrenotazioni = prenotazioneRepo.countByPostazioneIdAndDataPrenotazione(p.getId(), data);

        if (pEsistente.isPresent()) {
            throw new IllegalArgumentException("La postazione è già stata prenotata per questa data");
        } else if (esistePUtente) {
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
