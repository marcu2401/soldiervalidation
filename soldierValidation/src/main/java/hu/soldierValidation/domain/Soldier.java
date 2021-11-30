package hu.soldierValidation.domain;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Soldier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min=2, message="characters of rank must be more than 1")
    private String rank;
    private Date birth;
    private String weapon;
    @AssertTrue(message="It would be better being alive")
    private boolean alive;
    @Max(value=100, message="You must be retired now")
    private int shotpeople;

    public Soldier() {
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getShotpeople() {
        return shotpeople;
    }

    public void setShotpeople(int shotpeople) {
        this.shotpeople = shotpeople;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "id=" + id +
                ", rank='" + rank + '\'' +
                ", birth=" + birth +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
