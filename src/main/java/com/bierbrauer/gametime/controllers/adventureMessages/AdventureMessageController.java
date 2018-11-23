package com.bierbrauer.gametime.controllers.adventureMessages;

import com.bierbrauer.gametime.models.AdventureMessage;
import com.bierbrauer.gametime.services.adventureMessage.AdventureMessageService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class AdventureMessageController {

    AdventureMessageService adventureMessageService = new AdventureMessageService();

    @RequestMapping(path = "get-all", method = RequestMethod.GET)
    public Map<String, Object> getAll() {
        System.out.println("we are in here");
        return adventureMessageService.findAll();
    }

    @PostMapping("new-adventure-message")
    public Map<String, Object> postMessage(@RequestBody AdventureMessage payload) {
        System.out.println(payload.toString());
        return adventureMessageService.saveMessage(payload);
    }


}
