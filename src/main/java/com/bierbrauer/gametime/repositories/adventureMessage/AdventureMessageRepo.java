package com.bierbrauer.gametime.repositories.adventureMessage;

import com.bierbrauer.gametime.models.AdventureMessage;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdventureMessageRepo extends CrudRepository<AdventureMessage, Long> {

    Optional<AdventureMessage> findById(Long id);
}
