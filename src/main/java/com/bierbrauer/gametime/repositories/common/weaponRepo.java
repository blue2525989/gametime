package com.bierbrauer.gametime.repositories.common;

import com.bierbrauer.gametime.models.common.Weapon;
import org.springframework.data.repository.CrudRepository;

public interface weaponRepo extends CrudRepository<Weapon, Long> {
}
