package tony.formisano.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import tony.formisano.entities.Utente;

import java.util.List;

public class UtenteDAO {

        private final EntityManager entityManager;
        public UtenteDAO(EntityManager em){
            this.entityManager=em;
        }
//    va creato ENTITY MANAGER e ENTITY MANAGER FACTORY in APPLICATION




}
