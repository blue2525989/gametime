package com.bierbrauer.gametime.controllers.adventureMessages;

import com.bierbrauer.gametime.models.adventureMessage.AdventureMessage;
import com.bierbrauer.gametime.services.adventureMessage.AdventureMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController()
@RequestMapping(path = "adventure-messages")
public class AdventureMessageController {

    @Autowired
    AdventureMessageService adventureMessageService;

    @GetMapping("")
    public Map<String, Object> getAll() {
        return adventureMessageService.findAll();
    }

    @GetMapping("get-by-rarity/{rarity}")
    public Map<String, Object> getByRarity(@PathVariable int rarity) {
        return adventureMessageService.findAllByRarity(rarity);
    }

    @GetMapping("get-by-id/{id}")
    public Map<String, Object> findById(@PathVariable Long id) {
        return adventureMessageService.findById(id);
    }

    @GetMapping("random")
    public Map<String, Object> getRandom() {
        return adventureMessageService.findRandom();
    }

    /* find-* calls are GET calls pretending to be POST */

    @PostMapping("find-fuzzy")
    public Map<String, Object> findMessage(@RequestBody Map<String, Object> payload) {
        if (payload.containsKey("message")) {
            return adventureMessageService.findByFuzzy(payload.get("message").toString());
        } else {
            return new HashMap<String, Object>() {{
                put("body", "The wrong search payload was passed, please ensure proper payload structure.");
                put("exception: ", "The wrong search payload was passed, payload requires: {\"message\": \"<some message>\"}");
                put("status", 501);
            }};
        }

    }

    @PostMapping("find-exact")
    public Map<String, Object> findMessageExact(@RequestBody Map<String, Object> payload) {
        if (payload.containsKey("message")) {
            return adventureMessageService.findByExact(payload.get("message").toString());
        } else {
            return new HashMap<String, Object>() {{
                put("body", "The wrong search payload was passed, please ensure proper payload structure.");
                put("exception", "The wrong search payload was passed, payload requires: {\"message\": \"<some message>\"}");
                put("status", 501);
            }};
        }
    }

    /* NON GET calls */

    @PostMapping("save")
    public Map<String, Object> postMessage(@Valid @RequestBody AdventureMessage payload) {
        return adventureMessageService.save(payload);
    }

    @DeleteMapping("delete/{id}")
    public Map<String, Object> deleteMessage(@PathVariable Long id) {
        return adventureMessageService.delete(id);
    }


    @PutMapping("update/{id}")
    public Map<String, Object> updateMessage(@PathVariable Long id, @Valid @RequestBody AdventureMessage payload) {
        return adventureMessageService.update(id, payload);
    }

}
