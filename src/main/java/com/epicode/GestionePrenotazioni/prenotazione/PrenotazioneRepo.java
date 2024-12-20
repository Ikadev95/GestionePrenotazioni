package com.epicode.GestionePrenotazioni.prenotazione;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Long> {
    Optional<Prenotazione> findByPostazioneIdAndDataPrenotazione(Long postazioneId, LocalDate data);
    boolean existsByUtenteUsernameAndDataPrenotazione(String username, LocalDate data);
    int countByPostazioneIdAndDataPrenotazione(Long postazioneId, LocalDate data);
}
