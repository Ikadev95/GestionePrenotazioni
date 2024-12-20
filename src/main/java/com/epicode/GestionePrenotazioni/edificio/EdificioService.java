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

    private EdificioRepo edificioRepo;
    private PostazioneRepo postazioneRepo;

    @Transactional
    public void salvaEdificioEPostazione(Edificio e, List<Postazione> p){
        if(p != null && !p.isEmpty()) {
            for (int i = 0; i < p.size(); i++) {
                p.get(i).setEdificio(e);
                postazioneRepo.save(p.get(i));
            }
            e.setPostazioni(p);
            edificioRepo.save(e);
        }
    }

}
