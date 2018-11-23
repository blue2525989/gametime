package com.bierbrauer.gametime.services.adventureMessage;

import com.bierbrauer.gametime.models.AdventureMessage;
import com.bierbrauer.gametime.repositories.adventureMessage.AdventureMessageRepo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class AdventureMessageService {

	private AdventureMessageRepo messageRepo;

	/**
	 * saveMessage
	 * @param payload
	 * @return
	 */
    public Map<String, Object> saveMessage(AdventureMessage payload) {
		return new HashMap<String, Object>() {{
			try {
				// save to repo
				messageRepo.save(payload);
				// return message
				put("body", "The message was saved.");
				put("status", 201);
			} catch (Exception e) {
				put("body", "There has been an exception saving to database: " + e.getLocalizedMessage());
				put("status", 501);
			}
		}};
    }

    public Map<String, Object> findAll() {
    	System.out.println("farting");
    	return new HashMap<String, Object>() {{
			try {
				put("body", Arrays.asList(messageRepo.findAll()));
				put("status", 200);
			} catch (Exception e) {
				put("body", "There has been an exception obtaining the records.");
				put("status", 501);
			}
		}};
	}
}
