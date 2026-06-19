package tony.formisano.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
@Column(name="ISBN")
    protected String ISBN;
    @Column(name="Title")
    protected String title;
    @Column(name="Published")
    protected int published;
    @Column(name="Number_of_pages")
    protected int nPages;
@ManyToMany(mappedBy = "catalogoList")
private List<Prestito> prestiti=new ArrayList<>();
    public Catalogo() {}
//    GETTER SETTER TO_STRING
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public int getnPages() {
        return nPages;
    }

    public void setnPages(int nPages) {
        this.nPages = nPages;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", published=" + published +
                ", nPages=" + nPages +
                '}';
    }
}
