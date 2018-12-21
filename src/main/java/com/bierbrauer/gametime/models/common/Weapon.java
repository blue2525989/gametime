package com.bierbrauer.gametime.models.common;

import com.bierbrauer.gametime.models.monster.Monster;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Weapon {

    // these represent records stats

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String weaponName;

    @ManyToOne
    @JoinColumn(name = "monster_id")
    private Monster monster;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weapon)) return false;
        Weapon weapon = (Weapon) o;
        return Objects.equals(id, weapon.id) &&
                Objects.equals(weaponName, weapon.weaponName) &&
                Objects.equals(monster, weapon.monster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weaponName, monster);
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", weaponName='" + weaponName + '\'' +
                ", monster=" + monster +
                '}';
    }
}
