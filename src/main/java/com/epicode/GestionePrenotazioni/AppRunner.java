package com.epicode.GestionePrenotazioni;

import com.epicode.GestionePrenotazioni.edificio.EdificioRepo;
import com.epicode.GestionePrenotazioni.enums.TipoPostazione;
import com.epicode.GestionePrenotazioni.postazione.Postazione;
import com.epicode.GestionePrenotazioni.postazione.PostazioneRepo;
import com.epicode.GestionePrenotazioni.prenotazione.Prenotazione;
import com.epicode.GestionePrenotazioni.prenotazione.PrenotazioneService;
import com.epicode.GestionePrenotazioni.utente.Utente;
import com.epicode.GestionePrenotazioni.utente.UtenteRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RequiredArgsConstructor
@Component
@Order(5)
public class AppRunner implements ApplicationRunner {

    private final Logger logger;
    private final PrenotazioneService prenotazioneService;
    private final UtenteRepo utenteRepo;
    private final EdificioRepo edificioRepo;
    private final PostazioneRepo postazioneRepo;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        boolean continueExecution = true;

        while (continueExecution) {
            try {
                System.out.println("-------------------------");
                System.out.println("Benvenuto in GestionePrenotazioni");
                System.out.println("-------------------------");
                System.out.println("Seleziona un utente (scrivi l'id): ");


                List<Utente> utenti = utenteRepo.findAll();
                for (int i = 0; i < utenti.size(); i++) {
                    System.out.println(utenti.get(i).stampa());
                }
                System.out.println("-------------------------");


                Long id = scanner.nextLong();
                Optional<Utente> utente = utenteRepo.findById(id);
                if (!utente.isPresent()) {
                    System.out.println("Utente non trovato. Riprova.");
                    continue;
                }
                Utente utenteScelto = utente.get();

                System.out.println("seleziona il tipo di postazione: PRIVATO, OPENSPACE, SALA_RIUNIONI");
                System.out.println("-------------------------");

                scanner.nextLine();
                String tipoP = scanner.nextLine().toUpperCase();


                TipoPostazione tipoPostazione;
                try {
                    tipoPostazione = TipoPostazione.valueOf(tipoP);
                } catch (IllegalArgumentException e) {
                    System.out.println("Tipo di postazione non valido. Riprova.");
                    continue;
                }

                System.out.println("Hai selezionato: " + tipoPostazione);
                System.out.println("-------------------------");
                System.out.println("Seleziona una città: ");
                System.out.println("-------------------------");


                List<String> citta = edificioRepo.trovaCittaPerTipoPostazione(tipoPostazione);
                if (citta.isEmpty()) {
                    System.out.println("Nessuna città disponibile per questo tipo di postazione.");
                    continue;
                }
                citta.forEach(System.out::println);

                String cittaScelta = scanner.nextLine().toLowerCase();
                if (citta.stream().map(String::toLowerCase).noneMatch(cittaScelta::equals)) {
                    System.out.println("Città non valida. Riprova.");
                    continue;
                }

                System.out.println("Hai selezionato la città: " + cittaScelta);
                System.out.println("-------------------------");
                System.out.println("Quale postazione vuoi prenotare? (seleziona tramite codice)");


                List<Postazione> postazioniFiltrate = postazioneRepo.findByTipoPostazioneAndEdificioCitta(tipoPostazione, cittaScelta);
                if (postazioniFiltrate.isEmpty()) {
                    System.out.println("Nessuna postazione disponibile per questa città e tipo. Riprova.");
                    continue;
                }
                for (Postazione postazione : postazioniFiltrate) {
                    System.out.println(postazione.stampa());
                }

                String postazione = scanner.nextLine();
                Optional<Postazione> p = postazioniFiltrate.stream().filter(post -> post.getCodice().equals(postazione)).findFirst();
                if (!p.isPresent()) {
                    System.out.println("Codice postazione non valido. Riprova.");
                    continue;
                }
                Postazione postazioneScelta = p.get();
                System.out.println("Postazione selezionata: " + postazioneScelta.stampa());

                System.out.println("-------------------------");
                System.out.println("Per quale giorno vuoi prenotare la postazione? (scrivi la data yyyy-MM-dd)");


                LocalDate data;
                try {
                    data = LocalDate.parse(scanner.next());
                } catch (Exception e) {
                    System.out.println("Formato data non valido. Riprova.");
                    continue;
                }


                Prenotazione prenotazioneEffettuata = prenotazioneService.creaPrenotazione(data, utenteScelto, postazioneScelta);
                System.out.println("Prenotazione creata: ID = " + prenotazioneEffettuata.getId() +
                        ", Utente = " + prenotazioneEffettuata.getUtente().getUsername() +
                        ", Postazione = " + prenotazioneEffettuata.getPostazione().getCodice() +
                        ", Data = " + prenotazioneEffettuata.getDataPrenotazione());


                scanner.nextLine();
                System.out.println("Vuoi fare un'altra prenotazione? (si/no)");
                String risposta = scanner.nextLine().toLowerCase();
                if (!risposta.equals("si")) {
                    continueExecution = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("Input non valido. Riprova.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Si è verificato un errore: " + e.getMessage());
            }
        }

        System.out.println("Grazie per aver utilizzato il sistema di prenotazione.");
    }
}
