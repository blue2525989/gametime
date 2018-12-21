package com.bierbrauer.gametime.models.common;

import com.bierbrauer.gametime.models.monster.Monster;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Spell {

    // these represent records stats

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String spellName;

    @ManyToOne
    @JoinColumn(name = "monster_id")
    private Monster monster;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
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
        if (!(o instanceof Spell)) return false;
        Spell spell = (Spell) o;
        return Objects.equals(id, spell.id) &&
                Objects.equals(spellName, spell.spellName) &&
                Objects.equals(monster, spell.monster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, spellName, monster);
    }

    @Override
    public String toString() {
        return "Spell{" +
                "id=" + id +
                ", spellName='" + spellName + '\'' +
                ", monster=" + monster +
                '}';
    }
}
