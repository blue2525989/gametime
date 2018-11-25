package com.bierbrauer.gametime.repositories.adventureMessage;

import com.bierbrauer.gametime.models.AdventureMessage.AdventureMessage;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdventureMessageRepo extends CrudRepository<AdventureMessage, Integer> {

    Optional<AdventureMessage> findById(Integer id);

    Iterable<AdventureMessage> findAllByRarity(Integer rarity);
}
