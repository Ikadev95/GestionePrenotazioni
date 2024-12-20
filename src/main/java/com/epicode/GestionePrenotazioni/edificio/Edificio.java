package com.epicode.GestionePrenotazioni.edificio;

import com.epicode.GestionePrenotazioni.postazione.Postazione;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "edifici")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String indirizzo;
    private String citta;

    @OneToMany(mappedBy = "edificio", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private List<Postazione> postazioni = new ArrayList<>();
}