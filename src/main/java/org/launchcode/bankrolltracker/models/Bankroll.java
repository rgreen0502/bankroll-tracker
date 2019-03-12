package org.launchcode.bankrolltracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Bankroll {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private BigDecimal goal;

    @NotNull
    private BigDecimal progress;

    public Bankroll(int id, BigDecimal goal, BigDecimal progress) {
        this.id = id;
        this.goal = goal;
        this.progress = progress;
    }

    public Bankroll() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getGoal() {
        return goal;
    }

    public void setGoal(BigDecimal goal) {
        this.goal = goal;
    }

    public BigDecimal getProgress() {
        return progress;
    }

    public void setProgress(BigDecimal progress) {
        this.progress = progress;
    }
}
