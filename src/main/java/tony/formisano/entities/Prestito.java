package tony.formisano.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Prestito {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Start")
    private LocalDate startLoan;
    @Column(name="End")
    private LocalDate endLoan;
    @Column(name="Returned")
    private int returnedLoan;
@ManyToOne
    private Utente utente;
@ManyToMany
@JoinTable(
        name="Loan_List",
        joinColumns = @JoinColumn(name="Items_Of_The_Loan"),
        inverseJoinColumns=@JoinColumn(name="Loan_History")
)
    private List<Catalogo> catalogoList=new ArrayList<>();


public Prestito(){}
//    GETTER SETTER TO_STRING
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartLoan() {
        return startLoan;
    }

    public void setStartLoan(LocalDate startLoan) {
        startLoan = startLoan;
    }

    public LocalDate getEndLoan() {
        return endLoan;
    }

    public void setEndLoan(int endLoan) {
        endLoan = endLoan;
    }

    public int getReturnedLoan() {
        return returnedLoan;
    }

    public void setReturnedLoan(int returnedLoan) {
        returnedLoan = returnedLoan;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<Catalogo> getBorrowedElements() {
        return catalogoList;
    }

    public void setBorrowedElements(List<Catalogo> borrowedElements) {
        this.catalogoList = borrowedElements;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", borrowedElements=" + catalogoList +
                ", loanStartingDate=" + startLoan +
                ", loanEndDate=" + endLoan +
                ", loanReturnedDate=" + catalogoList +
                '}';
    }
}
