package tony.formisano.dao;

import jakarta.persistence.EntityManager;

public class RivistaDAO {
    private final EntityManager entityManager;
    public RivistaDAO(EntityManager em){
        this.entityManager=em;
    }
//    va creato ENTITY MANAGER e ENTITY MANAGER FACTORY in APPLICATION

}
