package com.bierbrauer.gametime.repositories.monster;

import com.bierbrauer.gametime.models.monster.Monster;
import org.springframework.data.repository.CrudRepository;

public interface monsterRepo extends CrudRepository<Monster, Long> {
}
