package com.bierbrauer.gametime.services.adventureMessage;

import com.bierbrauer.gametime.models.AdventureMessage.AdventureMessage;
import com.bierbrauer.gametime.repositories.adventureMessage.AdventureMessageRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdventureMessageService {

	@Autowired
	private AdventureMessageRepo messageRepo;

	Logger log = LoggerFactory.getLogger(AdventureMessageService.class);

	/**
	 * saveMessage
	 * @param payload
	 * @return
	 */
    public Map<String, Object> saveMessage(Map<String, Object> payload) {

		System.out.println(payload.toString());
		Map<String, Object> response = new HashMap<>();

		log.debug("payload payload:" + payload);
		AdventureMessage msg = new AdventureMessage();
		log.debug("Saving payload:" + msg);
		msg.setMessage(payload.get("message").toString());
		msg.setRarity((Integer) payload.get("rarity"));
		log.debug("Saving payload:" + msg);
//		return messageRepo.save(msg);
		try {
			// save to repo
			log.debug("Saving payload:" + msg);
			messageRepo.save(msg);
			// return message
			response.put("body", "The message was saved.");
			response.put("status", 201);
		} catch (Exception e) {
			log.debug("Exception: " + e);
			response.put("body", "There has been an exception saving to database: " + e.getLocalizedMessage());
			response.put("status", 501);
		}
		return response;
    }

    public Map<String, Object> findAll() {
//    	return  messageRepo.findAll();
		Map<String, Object> response = new HashMap<String, Object>() {{
			try {
				Iterable<AdventureMessage> messages = messageRepo.findAll();
				log.debug("Found messages:", messages);
				put("body", messages);
				put("status", 200);
			} catch (Exception e) {
				log.debug("Exception: " + e);
				put("body", "There has been an exception obtaining the records.");
				put("status", 501);
			}
		}};
		return response;
	}
}
