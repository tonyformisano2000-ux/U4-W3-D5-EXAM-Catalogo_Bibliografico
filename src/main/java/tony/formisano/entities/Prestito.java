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
    @Column(name="start_loan")
    private LocalDate startLoan;
    @Column(name="end_loan")
    private LocalDate endLoan;
    @Column(name="returned_loan")
    private LocalDate returnedLoan;
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
        this.startLoan = startLoan;
    }

    public LocalDate getEndLoan() {
        return endLoan;
    }

    public void setEndLoan(LocalDate endLoan) {
        endLoan = endLoan;
    }

    public LocalDate getReturnedLoan() {
        return returnedLoan;
    }

    public void setReturnedLoan(LocalDate returnedLoan) {

    if(returnedLoan!=null){returnedLoan = returnedLoan;}
    else{returnedLoan=null;}
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
                ", loanReturnedDate=" + returnedLoan +
                '}';
    }
}
