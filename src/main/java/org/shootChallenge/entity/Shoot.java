package org.shootChallenge.entity;

import org.shooterCRUD.entity.Shooter;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Shoot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer res;

    @JoinColumn(name = "shooter_id", referencedColumnName = "id")
    @ManyToOne
    Shooter shooter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRes() {
        return res;
    }

    public void setRes(Integer res) {
        this.res = res;
    }

    public Shooter getShooter() {
        return shooter;
    }

    public void setShooter(Shooter shooter) {
        this.shooter = shooter;
    }

    public Shoot() {
    }

    public Shoot(Integer res, Shooter shooter) {
        this.res = res;
        this.shooter = shooter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shoot shoot = (Shoot) o;
        return Objects.equals(id, shoot.id) &&
                Objects.equals(res, shoot.res) &&
                Objects.equals(shooter, shoot.shooter);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, res, shooter);
    }

    @Override
    public String toString() {
        return shooter + " - "+ res;
    }
}
