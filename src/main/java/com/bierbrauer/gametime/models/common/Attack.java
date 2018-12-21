package com.bierbrauer.gametime.models.common;

import com.bierbrauer.gametime.models.monster.Monster;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Attack {

    // these represent records stats

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String attackName;

    @ManyToOne
    @JoinColumn(name = "monster_id")
    private Monster monster;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttackName() {
        return attackName;
    }

    public void setAttackName(String attackName) {
        this.attackName = attackName;
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
        if (!(o instanceof Attack)) return false;
        Attack attack = (Attack) o;
        return Objects.equals(id, attack.id) &&
                Objects.equals(attackName, attack.attackName) &&
                Objects.equals(monster, attack.monster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, attackName, monster);
    }

    @Override
    public String toString() {
        return "Attack{" +
                "id=" + id +
                ", attackName='" + attackName + '\'' +
                ", monster=" + monster +
                '}';
    }
}
