package com.bierbrauer.gametime.controllers.adventureMessages;

import com.bierbrauer.gametime.services.adventureMessage.AdventureMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class AdventureMessageController {

    @Autowired
    AdventureMessageService adventureMessageService;

    @RequestMapping(value="get-all", method = RequestMethod.GET)
    public Map<String, Object> getAll() {
        System.out.println("we are in here");
        return adventureMessageService.findAll();
    }

    @RequestMapping(value="new-adv-msg", method=RequestMethod.POST)
    public Map<String, Object> postMessage(@RequestBody Map<String, Object> payload) {
        System.out.println(payload.toString());
        return adventureMessageService.saveMessage(payload);
    }


}
