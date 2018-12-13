package com.bierbrauer.gametime.models.monster;

import com.bierbrauer.gametime.models.common.Attack;
import com.bierbrauer.gametime.models.common.Spell;
import com.bierbrauer.gametime.models.common.Weapon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Monster {

    // these represent records stats

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String monsterName;

    private Integer healthPoints;

    private Integer armorClass;

    private String description;

    private List<Attack> attacks;

    private List<Spell> spells;

    private List<Weapon> weapons;

    // these represent classifying stats

    // this represents 3.5E 5E etc.
    private String generation;

}
