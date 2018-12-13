package com.bierbrauer.gametime.services.adventureMessage;

import com.bierbrauer.gametime.models.adventureMessage.AdventureMessage;
import com.bierbrauer.gametime.repositories.adventureMessage.AdventureMessageRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

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
		return new HashMap<String, Object>() {{

			AdventureMessage msg = new AdventureMessage();
			msg.setMessage(payload.get("message").toString());
			msg.setRarity((Integer) payload.get("rarity"));

			try {
				messageRepo.save(msg);
				put("body", "The message was saved.");
				put("status", 201);
			} catch (Exception e) {
				log.debug("Exception: " + e);
				put("body", "There has been an exception saving to database: " + e.getLocalizedMessage());
				put("exception", e.getMessage());
				put("status", 501);
			}
		}};
    }

	/**
	 * findAll
	 * @return
	 */
	public Map<String, Object> findAll() {
		return new HashMap<String, Object>() {{
			try {
				Iterable<AdventureMessage> messages = messageRepo.findAll();
				put("body", messages);
				put("status", 200);
			} catch (Exception e) {
				log.debug("Exception: " + e);
				put("body", "There has been an exception obtaining the records.");
				put("exception", e.getMessage());
				put("status", 501);
			}
		}};
	}

	public Map<String, Object> findById(int id) {
		return new HashMap<String, Object>() {{
			try {
				Optional<AdventureMessage> message = messageRepo.findById(id);
				put("body", message);
				put("status", 200);
			} catch (Exception e) {
				log.debug("Exception: " + e);
				put("body", "There has been an exception obtaining the record with id: " + id);
				put("exception", e.getMessage());
				put("status", 501);
			}
		}};
	}

	public Map<String, Object> findByMessageFuzzy(String messagePart) {
		return new HashMap<String, Object>() {{
			try {
				Iterable<AdventureMessage> message = messageRepo.findByMessageFuzzy(messagePart);
				put("body", message);
				put("status", 200);

			} catch (Exception e) {
				log.debug("Exception: " + e);
				put("body", "There has been an exception obtaining the record matching message: " + messagePart);
				put("exception", e.getMessage());
				put("status", 501);
			}
		}};
	}

	public Map<String, Object> delete(int id) {
		return new HashMap<String, Object>(){{
			try {
				messageRepo.deleteById(id);
				put("body", "Successful delete operation.");
				put("status", 200);
				log.debug("Message has been deleted with id: " + id);
			} catch (Exception e) {
				log.debug("Exception: " + e);
				put("body", "There has been an exception obtaining the record with id: " + id);
				put("exception", e.getMessage());
				put("status", 501);
			}
		}};
	}

	public Map<String, Object> update(int id, Map<String, Object> payload) {
		return new HashMap<String, Object>(){{
			try {
				Optional<AdventureMessage> advMsg = messageRepo.findById(id);
				AdventureMessage msg = advMsg.isPresent() ? advMsg.get() : null;
				if (payload.containsKey("message"))
				{
					msg.setMessage(payload.get("message").toString());
				}
				if (payload.containsKey("rarity"))
				{
					msg.setRarity(Integer.parseInt(payload.get("rarity").toString()));
				}
				messageRepo.save(msg);
				put("body", "Successful update operation.");
				put("status", 200);
				log.debug("Message has been updating with id: " + id);
			} catch (Exception e) {
				log.debug("Exception: " + e);
				put("body", "There has been an exception updating the record with id: " + id);
				put("exception", e.getMessage());
				put("status", 501);
			}
		}};
	}

	public Map<String, Object> findRandomMessage() {
		return new HashMap<String, Object>() {{
			try {

				long count = messageRepo.count();
				int idRandom = ThreadLocalRandom.current().nextInt(0, Math.toIntExact(count) -1);

				Optional<AdventureMessage> message = messageRepo.findById(idRandom);
				put("body", message);
				put("status", 200);
			} catch (Exception e) {
				log.debug("Exception: " + e);
				put("body", "There has been an exception obtaining random record.");
				put("exception", e.getMessage());
				put("status", 501);
			}
		}};
	}

	public Map<String, Object> findAllByRarity(int rarity) {
		return new HashMap<String, Object>() {{
			try {
				Iterable<AdventureMessage> messages = messageRepo.findAllByRarity(rarity);
				put("body", messages);
				put("status", 200);
			} catch (Exception e) {
				log.debug("Exception: " + e);
				put("body", "There has been an exception obtaining records by rarity.");
				put("exception", e.getMessage());
				put("status", 501);
			}
		}};
	}
}
