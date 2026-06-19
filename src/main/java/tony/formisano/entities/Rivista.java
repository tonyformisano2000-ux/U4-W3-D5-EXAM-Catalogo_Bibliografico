package tony.formisano.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Rivista extends Catalogo{
    @Enumerated(EnumType.STRING)
    private Periodicita period;
public Rivista(){}

//    GETTER SETTER TO_STRING
    public Periodicita getPeriod() {
        return period;
    }

    public void setPeriod(Periodicita period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "period=" + period +
                '}';
    }
}
