package com.bierbrauer.gametime.repositories.adventureMessage;

import com.bierbrauer.gametime.models.adventureMessage.AdventureMessage;

import java.util.List;

public interface AdventureMessageRepoCustomFunctions<AdventureMessageRepo, Integer> {

    List<AdventureMessage> findByMessageFuzzy(String message);

    List<AdventureMessage> findByMessageExact(String message);

}
