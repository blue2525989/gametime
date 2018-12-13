package com.bierbrauer.gametime.repositories.adventureMessage;

import com.bierbrauer.gametime.models.adventureMessage.AdventureMessage;

import java.util.List;

public interface AdventureMessageRepositoryCustom<AdventureMessageRepo, Integer> {

    List<AdventureMessage> findByMessageFuzzy(String message);

}
