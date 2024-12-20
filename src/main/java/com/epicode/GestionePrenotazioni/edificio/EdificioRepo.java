package com.epicode.GestionePrenotazioni.edificio;

import com.epicode.GestionePrenotazioni.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdificioRepo extends JpaRepository<Edificio, Long> {
    @Query("""
    SELECT DISTINCT e.citta
    FROM Edificio e
    JOIN e.postazioni p
    WHERE p.tipoPostazione = :tipoPostazione
""")
    List<String> trovaCittaPerTipoPostazione(@Param("tipoPostazione") TipoPostazione tipoPostazione);
}
