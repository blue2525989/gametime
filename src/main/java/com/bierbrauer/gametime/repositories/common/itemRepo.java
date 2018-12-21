package com.bierbrauer.gametime.repositories.common;

import com.bierbrauer.gametime.models.common.Item;
import org.springframework.data.repository.CrudRepository;

public interface itemRepo extends CrudRepository<Item, Long> {
}
