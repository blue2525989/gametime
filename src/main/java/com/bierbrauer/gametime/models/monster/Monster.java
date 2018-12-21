package com.bierbrauer.gametime.models.monster;

import com.bierbrauer.gametime.models.common.*;

import javax.persistence.*;
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

    @OneToOne
    private Speed speed;

    @OneToMany
    private List<Attack> attacks;

    @OneToMany
    private List<Item> items;

    // these represent classifying stats

    // this represents 3.5E 5E etc.
    private String generation;

}
