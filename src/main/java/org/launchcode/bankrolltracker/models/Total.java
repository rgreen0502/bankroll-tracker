package org.launchcode.bankrolltracker.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Total {

    @NotNull
    private BigDecimal bank;

    @Id
    @GeneratedValue
    private int id;

    public Total(BigDecimal bank, int id) {
        this.bank = bank;
        this.id = id;
    }

    public Total() {
    }

    public BigDecimal getBank() {
        return bank;
    }

    public void setBank(BigDecimal bank) {
        this.bank = bank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
