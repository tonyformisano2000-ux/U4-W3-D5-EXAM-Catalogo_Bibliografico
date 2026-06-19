package tony.formisano.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import tony.formisano.entities.Catalogo;

import java.util.List;

public class CatalogoDAO {
    private final EntityManager entityManager;
    public CatalogoDAO(EntityManager em){
        this.entityManager=em;
    }
//    va creato ENTITY MANAGER e ENTITY MANAGER FACTORY in APPLICATION

    //    SALVA ELEMENTO
    public void salvaElemento(Catalogo Item){
        EntityTransaction transaction=this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(Item);
        transaction.commit();
        System.out.println("elemento salvato con successo");
    }
//      RICERCA PER ISBN
public void findByISBN(String isbn){
    Query query=this.entityManager.createQuery("SELECT a FROM Catalogo a WHERE a.ISBN=:isbn");
    query.setParameter("isbn", isbn);
    List<Catalogo> result=query.getResultList();
    System.out.println("ecco l'elemento con ISBN "+ isbn + ":"+ result);
    }

//      RIMOZIONE PER ISBN
    public void eliminaByISBN(String isbn){
        EntityTransaction transaction=this.entityManager.getTransaction();
        transaction.begin();
        Query query=this.entityManager.createQuery("DELETE FROM Catalogo a WHERE a.ISBN=:isbn");
        query.setParameter("isbn" , isbn);
        query.executeUpdate();
        transaction.commit();
        System.out.println("elemento con ISBN "+isbn+ "eliminato con successo");
    }

//      RICERCA PER ANNO DI PUBBLICAZIONE
public void findByYear(int date){
    TypedQuery<Catalogo> query=this.entityManager.createQuery("SELECT a FROM Catalogo a WHERE a.published=:date", Catalogo.class);
    query.setParameter("date", date);
    List<Catalogo> result=query.getResultList();
    System.out.println("pubblicati nel "+ date + ":"+ result);
}
//      RICERCA PER TITOLO (ANCHE PARZIALE)
public void findByTitle(String research){
    TypedQuery<Catalogo> query=this.entityManager.createQuery("SELECT a FROM Catalogo a WHERE a.title LIKE:research", Catalogo.class);
    query.setParameter("research", "%" + research + "%");
    List<Catalogo>result=query.getResultList();
    System.out.println("risultato della ricerca:"+ result);
}
}
