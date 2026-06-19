package tony.formisano.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tony.formisano.entities.Catalogo;
import tony.formisano.entities.Prestito;

import java.time.LocalDate;
import java.util.List;

public class PrestitoDAO {
    private final EntityManager entityManager;
    public PrestitoDAO(EntityManager em){
        this.entityManager=em;
    }
//    va creato ENTITY MANAGER e ENTITY MANAGER FACTORY in APPLICATION

//      RICERCA PER ELEMENTI IN PRESTITO NON RESTITUITI
public void findBorrowed(){
    TypedQuery<Prestito> query=this.entityManager.createQuery("SELECT a FROM Prestito a WHERE a.returnedLoan IS NULL AND a.endLoan<:now", Prestito.class);
    query.setParameter("now",LocalDate.now());
    List<Prestito> scaduti = query.getResultList();
    System.out.println("Elementi non restituiti :"+ query);
}

//      RICERCA PER ELEMENTI IN PRESTITO ATTRAVERSO NUMERO BADGE
    public void findByBadge(Long badge) {
        TypedQuery<Prestito> query = this.entityManager.createQuery(
                "SELECT a FROM Prestito a WHERE a.utente.numeroTessera = :badge AND p.dataRestituzioneEffettiva IS NULL",
                Prestito.class
        );
        query.setParameter("badge", badge);
        List<Prestito> result = query.getResultList();
        System.out.println("elementi in prestito per badge " + badge + ": " + result);
    }
}
