package com.bierbrauer.gametime.controllers.adventureMessages;

import com.bierbrauer.gametime.services.adventureMessage.AdventureMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController()
@RequestMapping(path = "adventure-message")
public class AdventureMessageController {

    @Autowired
    AdventureMessageService adventureMessageService;

    @GetMapping("get-all")
    public Map<String, Object> getAll() {
        return adventureMessageService.findAll();
    }

    @PostMapping("new-adv-msg")
    public Map<String, Object> postMessage(@RequestBody Map<String, Object> payload) {
        return adventureMessageService.saveMessage(payload);
    }

    @DeleteMapping("delete-message/{id}")
    public Map<String, Object> deleteMessage(@PathVariable int id) {
        return adventureMessageService.delete(id);
    }

    @GetMapping("get-random")
    public Map<String, Object> getRandom() {
        return adventureMessageService.findRandomMessage();
    }

    @GetMapping("get-by-rarity/{rarity}")
    public Map<String, Object> getByRarity(@PathVariable int rarity) {
        return adventureMessageService.findAllByRarity(rarity);
    }

    @GetMapping("get-by-id/{id}")
    public Map<String, Object> findById(@PathVariable int id) {
        return adventureMessageService.findById(id);
    }

    @PutMapping("update-message/{id}")
    public Map<String, Object> updateMessage(@PathVariable int id, @RequestBody Map<String, Object> payload) {
        return adventureMessageService.update(id, payload);
    }

    @PostMapping("find-message-fuzzy")
    public Map<String, Object> findMessage(@RequestBody Map<String, Object> payload) {
        if (payload.containsKey("message")) {
            return adventureMessageService.findByMessageFuzzy(payload.get("message").toString());
        } else {
            return new HashMap<String, Object>() {{
                put("body", "The wrong search payload was passed, please ensure proper payload structure.");
                put("exception: ", "The wrong search payload was passed, payload requires: {\"message\": \"<some message>\"}");
                put("status", 501);
            }};
        }

    }

    @PostMapping("find-message-exact")
    public Map<String, Object> findMessageExact(@RequestBody Map<String, Object> payload) {
        if (payload.containsKey("message")) {
            return adventureMessageService.findByMessageExact(payload.get("message").toString());
        } else {
            return new HashMap<String, Object>() {{
                put("body", "The wrong search payload was passed, please ensure proper payload structure.");
                put("exception", "The wrong search payload was passed, payload requires: {\"message\": \"<some message>\"}");
                put("status", 501);
            }};
        }
    }
}
