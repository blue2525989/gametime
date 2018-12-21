package com.bierbrauer.gametime.services.adventureMessage;

import com.bierbrauer.gametime.models.adventureMessage.AdventureMessage;
import com.bierbrauer.gametime.repositories.adventureMessage.AdventureMessageRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

	public Map<String, Object> findById(Long id) {
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

	public Map<String, Object> findByFuzzy(String messagePart) {
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

	public Map<String, Object> findByExact(String message) {
		return new HashMap<String, Object>() {{
			try {
				Iterable<AdventureMessage> messages = messageRepo.findByMessageExact(message);
				put("body", messages);
				put("status", 200);
			} catch (Exception e) {
				put("body", "There has been an exception searching for the message: " + message);
				put("exception", e.getMessage());
				put("status", 501);
			}
		}};
	}

	public Map<String, Object> findRandom() {
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

	/**
	 * saveMessage
	 * @param payload
	 * @return
	 */
	public Map<String, Object> save(AdventureMessage payload) {
		return new HashMap<String, Object>() {{
			try {
				AdventureMessage msg = messageRepo.save(payload);
				put("body", msg);
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
	 * delete
	 * @param id
	 * @return
	 */
	public Map<String, Object> delete(Long id) {
		return new HashMap<String, Object>(){{
			try {
				messageRepo.findById(id).map(msgResp -> {
					messageRepo.delete(msgResp);
					return null;
				}).orElseThrow( () -> new EntityNotFoundException("Unable to find record: " + id + " to preform delete."));
				put("body", "The record with id: " + id + " has been deleted.");
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

	/**
	 * update
	 * @param id
	 * @param payload
	 * @return
	 */
	public Map<String, Object> update(Long id, AdventureMessage payload) {
		return new HashMap<String, Object>(){{
			try {
				AdventureMessage msg = messageRepo.findById(id).map(msgResp -> {
					msgResp.setMessage(payload.getMessage());
					msgResp.setRarity((payload.getRarity() != null) ? payload.getRarity() : msgResp.getRarity());
					return messageRepo.save(msgResp);
				}).orElseThrow( () -> new EntityNotFoundException("Unable to find record: " + id + " to preform update."));
				put("body", msg);
				put("status", 204);
				log.debug("Record has been updating with id: " + id);
			} catch (Exception e) {
				log.debug("Exception: " + e);
				put("body", "There has been an exception updating the record with id: " + id);
				put("exception", e.getMessage());
				put("status", 501);
			}
		}};
	}
}
