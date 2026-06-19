package tony.formisano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tony.formisano.dao.CatalogoDAO;
import tony.formisano.dao.LibroDAO;
import tony.formisano.dao.PrestitoDAO;
import tony.formisano.dao.UtenteDAO;
import tony.formisano.entities.*;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5");
        EntityManager em = emf.createEntityManager();

        CatalogoDAO catalogoDAO = new CatalogoDAO(em);
        LibroDAO libroDAO = new LibroDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);

                // LIBRI
        Libro libro1 = new Libro();
        Libro libro2 = new Libro();
        Libro libro3 = new Libro();
        libro1.setISBN("978-88-06-22000-1");
        libro1.setTitle("Il Nome della Rosa");
        libro1.setPublished(1980);
        libro1.setnPages(502);
        libro1.setAuthor("Umberto Eco");
        libro1.setGenre("Romanzo storico");
        libro2.setISBN("978-88-07-81515-5");
        libro2.setTitle("Il nome della libertà");
        libro2.setPublished(1980);
        libro2.setnPages(220);
        libro2.setAuthor("Primo Levi");
        libro2.setGenre("Memoir");
        libro3.setISBN("978-88-06-12345-0");
        libro3.setTitle("Il Gattopardo");
        libro3.setPublished(1958);
        libro3.setnPages(336);
        libro3.setAuthor("Umberto Eco");
        libro3.setGenre("Romanzo");
// RIVISTE
        Rivista rivista1 = new Rivista();
        rivista1.setISBN("978-00-00-00001-1");
        rivista1.setTitle("National Geographic");
        rivista1.setPublished(2020);
        rivista1.setnPages(120);

        rivista1.setPeriod(Periodicita.MENSILE);

//                SALVA
        catalogoDAO.salvaElemento(libro1);
        catalogoDAO.salvaElemento(libro2);
        catalogoDAO.salvaElemento(libro3);
        catalogoDAO.salvaElemento(rivista1);

      // UTENTI
        Utente utente1 = new Utente();
        utente1.setName("Mario");
        utente1.setSurname("Rossi");
        utente1.setBirthDate(LocalDate.of(1990, 5, 15));
        utente1.setBadgeNumber(12345L);

        Utente utente2 = new Utente();
        utente2.setName("Giulia");
        utente2.setSurname("Bianchi");
        utente2.setBirthDate(LocalDate.of(1985, 8, 20));
        utente2.setBadgeNumber(67890L);

        UtenteDAO utenteDAO = new UtenteDAO(em);
        utenteDAO.salvaUtente(utente1);
        utenteDAO.salvaUtente(utente2);

        // NON RITORNATI
        Prestito prestitoAttivo = new Prestito();
        prestitoAttivo.setStartLoan(LocalDate.now());
        prestitoAttivo.setEndLoan(LocalDate.now().plusDays(30));
        prestitoAttivo.setReturnedLoan(null); // non ancora restituito
        prestitoAttivo.setUtente(utente1);
        prestitoAttivo.getBorrowedElements().add(libro1);

        //  PRESTITO SCADUTO
        Prestito prestitoScaduto = new Prestito();
        prestitoScaduto.setStartLoan(LocalDate.of(2026, 1, 1));
        prestitoScaduto.setEndLoan(LocalDate.of(2026, 1, 31)); // già passato
        prestitoScaduto.setReturnedLoan(null); // non restituito
        prestitoScaduto.setUtente(utente2);
        prestitoScaduto.getBorrowedElements().add(libro2);

        prestitoDAO.salvaPrestito(prestitoAttivo);
        prestitoDAO.salvaPrestito(prestitoScaduto);

//                              RISPOSTE ESAME:
        // Ricerca per ISBN
        System.out.println("\nRicerca per ISBN: ");
                catalogoDAO.findByISBN("978-88-06-22000-1");

                // Ricerca per anno pubblicazione
                System.out.println("\nRicerca per anno pubblicazione: ");
                catalogoDAO.findByYear(1980);

                // Ricerca per autore
                System.out.println("\nRicerca per autore");
                libroDAO.findByAuthor("Umberto Eco: ");

                // Ricerca per titolo parziale
                System.out.println("\nRicerca per titolo parziale: ");
                catalogoDAO.findByTitle("nome");

                // Ricerca elementi in prestito per badge
                System.out.println("\nRicerca elementi in prestito per badge: ");
                prestitoDAO.findByBadge(12345L);

                // Ricerca prestiti scaduti non restituiti
                System.out.println("\nRicerca prestiti scaduti non restituiti: ");
                prestitoDAO.findBorrowed();

                // Elimina per ISBN
                System.out.println("\nElimina per ISBN: ");
                catalogoDAO.eliminaByISBN("978-00-00-00001-1");

                em.close();
                emf.close();
            }
        }


