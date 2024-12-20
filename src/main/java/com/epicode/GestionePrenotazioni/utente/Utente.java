package com.epicode.GestionePrenotazioni.utente;

import com.epicode.GestionePrenotazioni.prenotazione.Prenotazione;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;
    private String nome;
    private String email;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    List<Prenotazione> prenotazioni;

    public String stampa(){
        String s = "id:"+ this.id +" username: " + this.username + " mail: " + this.email;
        return s;
    }

}