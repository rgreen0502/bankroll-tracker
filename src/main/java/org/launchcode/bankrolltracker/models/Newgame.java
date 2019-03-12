package org.launchcode.bankrolltracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Newgame {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private Date date;

    @NotNull
    @Size(min=3, max=20, message = "Location must be between 3 and 20 characters.")
    private String location;

    @NotNull
    private BigDecimal stakes;

    @NotNull
    private BigDecimal buyin;

    @NotNull
    private BigDecimal cashout;

    public Newgame(int id, Date date, String location, BigDecimal stakes, BigDecimal buyin, BigDecimal cashout) {
        this.id = id;
        this.date = date;
        this.location = location;
        this.stakes = stakes;
        this.buyin = buyin;
        this.cashout = cashout;
    }

    public Newgame() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getStakes() {
        return stakes;
    }

    public void setStakes(BigDecimal stakes) {
        this.stakes = stakes;
    }

    public BigDecimal getBuyin() {
        return buyin;
    }

    public void setBuyin(BigDecimal buyin) {
        this.buyin = buyin;
    }

    public BigDecimal getCashout() {
        return cashout;
    }

    public void setCashout(BigDecimal cashout) {
        this.cashout = cashout;
    }
}
