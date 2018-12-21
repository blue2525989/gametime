package com.bierbrauer.gametime.models.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Speed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer landSpeed;

    private Integer flySpeed;

    private Integer swimSpeed;

    private Integer difficultTerrianSpeed;

    public Integer getLandSpeed() {
        return landSpeed;
    }

    public void setLandSpeed(Integer landSpeed) {
        this.landSpeed = landSpeed;
    }

    public Integer getFlySpeed() {
        return flySpeed;
    }

    public void setFlySpeed(Integer flySpeed) {
        this.flySpeed = flySpeed;
    }

    public Integer getSwimSpeed() {
        return swimSpeed;
    }

    public void setSwimSpeed(Integer swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    public Integer getDifficultTerrianSpeed() {
        return difficultTerrianSpeed;
    }

    public void setDifficultTerrianSpeed(Integer difficultTerrianSpeed) {
        this.difficultTerrianSpeed = difficultTerrianSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Speed)) return false;
        Speed speed = (Speed) o;
        return Objects.equals(landSpeed, speed.landSpeed) &&
                Objects.equals(flySpeed, speed.flySpeed) &&
                Objects.equals(swimSpeed, speed.swimSpeed) &&
                Objects.equals(difficultTerrianSpeed, speed.difficultTerrianSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(landSpeed, flySpeed, swimSpeed, difficultTerrianSpeed);
    }

    @Override
    public String toString() {
        return "Speed{" +
                "landSpeed=" + landSpeed +
                "ft, flySpeed=" + flySpeed +
                "ft, swimSpeed=" + swimSpeed +
                "ft, difficultTerrianSpeed=" + difficultTerrianSpeed +
                "ft" +
                '}';
    }
}
