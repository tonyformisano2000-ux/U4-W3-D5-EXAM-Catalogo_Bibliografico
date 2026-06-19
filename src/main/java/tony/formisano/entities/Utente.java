package tony.formisano.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="Birth")
    private LocalDate birthDate;
    @Column(name="Badge")
    private Long badgeNumber;
    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestitoList=new ArrayList<>();
    public Utente(){}

//    GETTER SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(Long badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", badgeNumber=" + badgeNumber +
                '}';
    }
}
