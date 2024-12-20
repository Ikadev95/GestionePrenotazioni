package com.epicode.GestionePrenotazioni.postazione;

import com.epicode.GestionePrenotazioni.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepo extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipoPostazioneAndEdificioCitta(TipoPostazione tipo, String citta);
}
