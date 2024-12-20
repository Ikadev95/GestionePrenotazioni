package com.epicode.GestionePrenotazioni.edificio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepo extends JpaRepository<Edificio, Long> {
}
