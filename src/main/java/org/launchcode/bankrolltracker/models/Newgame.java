package org.launchcode.bankrolltracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    private Double stakes;

    @NotNull
    private Double buyin;

    @NotNull
    private Double cashout;

    public Newgame(int id, Date date, String location,  Double stakes,  Double buyin, Double cashout) {
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

    public Double getStakes() {
        return stakes;
    }

    public void setStakes(Double stakes) {
        this.stakes = stakes;
    }

    public Double getBuyin() {
        return buyin;
    }

    public void setBuyin(Double buyin) {
        this.buyin = buyin;
    }

    public Double getCashout() {
        return cashout;
    }

    public void setCashout(Double cashout) {
        this.cashout = cashout;
    }
}
