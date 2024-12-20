package com.epicode.GestionePrenotazioni.postazione;

import com.epicode.GestionePrenotazioni.edificio.Edificio;
import com.epicode.GestionePrenotazioni.enums.TipoPostazione;
import com.epicode.GestionePrenotazioni.prenotazione.Prenotazione;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Data
@Table(name = "postazioni")
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String codice;
    private TipoPostazione tipoPostazione;
    private int numeroTotaleOccupanti;
    private String descrizione;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Prenotazione> prenotazioni = new ArrayList<>();
}