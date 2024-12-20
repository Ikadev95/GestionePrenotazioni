package com.epicode.GestionePrenotazioni.postazione;

import com.epicode.GestionePrenotazioni.edificio.Edificio;
import com.epicode.GestionePrenotazioni.enums.TipoPostazione;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class PostazioneService {
  private PostazioneRepo postazioneRepo;

    public List<Postazione> cercaPostazioni(TipoPostazione tipo, String citta){

        return postazioneRepo.findByTipoPostazioneAndEdificioCitta(tipo, citta);
    }

}
