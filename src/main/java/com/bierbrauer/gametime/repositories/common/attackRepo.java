package com.bierbrauer.gametime.repositories.common;

import com.bierbrauer.gametime.models.common.Attack;
import org.springframework.data.repository.CrudRepository;

public interface attackRepo extends CrudRepository<Attack, Long> {
}
