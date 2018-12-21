package com.bierbrauer.gametime.repositories.common;

import com.bierbrauer.gametime.models.common.Spell;
import org.springframework.data.repository.CrudRepository;

public interface spellRepo extends CrudRepository<Spell, Long> {
}
