package com.epicode.GestionePrenotazioni.edificio;

import com.epicode.GestionePrenotazioni.postazione.Postazione;
import com.epicode.GestionePrenotazioni.postazione.PostazioneRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EdificioService {

    private final EdificioRepo edificioRepo;
    private final PostazioneRepo postazioneRepo;

    @Transactional
    public void salvaEdificioEPostazione(Edificio e, List<Postazione> p){

        edificioRepo.save(e);
            for (int i = 0; i < p.size(); i++) {
                p.get(i).setEdificio(e);
            }
           e.setPostazioni(p);


    }

}
