package tony.formisano.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Rivista extends Catalogo{
    @Column(name="Period")
    private int period;
public Rivista(){}
//    GETTER SETTER TO_STRING
    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "period=" + period +
                '}';
    }
}
