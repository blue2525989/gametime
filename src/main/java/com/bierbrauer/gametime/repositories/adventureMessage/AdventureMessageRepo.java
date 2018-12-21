package com.bierbrauer.gametime.repositories.adventureMessage;

import com.bierbrauer.gametime.models.adventureMessage.AdventureMessage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AdventureMessageRepo extends CrudRepository<AdventureMessage, Integer>, AdventureMessageRepositoryCustom<AdventureMessageRepo, Integer> {

    Optional<AdventureMessage> findById(Integer id);

    Iterable<AdventureMessage> findAllByRarity(Integer rarity);

    /* Custom implementations */

    @Query("SELECT msg FROM AdventureMessage msg WHERE msg.message LIKE CONCAT(:message,'%')")
    List<AdventureMessage> findByMessageFuzzy(@Param("message") String message);

    @Query("SELECT msg FROM AdventureMessage msg WHERE msg.message = :message")
    List<AdventureMessage> findByMessageExact(@Param("message") String message);
}
