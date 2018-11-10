package org.shooterCRUD.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Shooter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    String fullName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Shooter() {
    }

    public Shooter(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shooter shooter = (Shooter) o;
        return Objects.equals(id, shooter.id) &&
                Objects.equals(fullName, shooter.fullName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, fullName);
    }

    @Override
    public String toString() {
        return getFullName();
    }
}
