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

}
