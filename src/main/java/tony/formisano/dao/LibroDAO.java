package tony.formisano.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tony.formisano.entities.Libro;

import java.util.List;

public class LibroDAO {
    private final EntityManager entityManager;
    public LibroDAO(EntityManager em){
        this.entityManager=em;
    }
//    va creato ENTITY MANAGER e ENTITY MANAGER FACTORY in APPLICATION

//      RICERCA PER AUTORE
public void findByAuthor(String autore){
    TypedQuery<Libro> query=this.entityManager.createQuery("SELECT a FROM Libro a WHERE a.author=:autore", Libro.class);
    query.setParameter("autore", autore);
    List<Libro> result=query.getResultList();
    System.out.println("ecco la bibliografia di "+ autore + ":"+ result);
}
}
