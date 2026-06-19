package tony.formisano.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Libro extends Catalogo{
@Column(name="Author")
    private String author;
    @Column(name="Genre")
    private String genre;
    public Libro(){}

//    GETTER SETTER TO_STRING
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
