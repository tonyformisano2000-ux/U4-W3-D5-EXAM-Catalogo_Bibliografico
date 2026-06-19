package tony.formisano.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import tony.formisano.entities.Catalogo;
import tony.formisano.entities.Utente;

import java.util.List;

public class UtenteDAO {

        private final EntityManager entityManager;
        public UtenteDAO(EntityManager em){
            this.entityManager=em;
        }
//    SALVA UTENTE
public void salvaUtente(Utente Item){
    EntityTransaction transaction=this.entityManager.getTransaction();
    transaction.begin();
    this.entityManager.persist(Item);
    transaction.commit();
    System.out.println("Utente salvato con successo");
}



}
