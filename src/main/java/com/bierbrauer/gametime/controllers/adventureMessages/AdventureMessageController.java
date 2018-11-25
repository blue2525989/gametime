package com.bierbrauer.gametime.controllers.adventureMessages;

import com.bierbrauer.gametime.services.adventureMessage.AdventureMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@RestController
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
}
