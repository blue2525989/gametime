package com.bierbrauer.gametime.repositories.adventureMessage;

import com.bierbrauer.gametime.models.adventureMessage.AdventureMessage;

import java.util.ArrayList;
import java.util.List;

public class AdventureMessageRepositoryImpl implements AdventureMessageRepositoryCustom {

    @Override
    public List<AdventureMessage> findByMessageFuzzy(String message) {
        return new ArrayList<AdventureMessage>() {{

        }};
    }
}
