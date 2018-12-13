package com.bierbrauer.gametime.controllers.dice;

import com.bierbrauer.gametime.services.dice.DiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "dice")
public class DiceController {

    @Autowired
    DiceService diceService;

    @GetMapping("d2")
    public Map<String, Object> rollD2() {
        return diceService.rollD2();
    }

    @GetMapping("d4")
    public Map<String, Object> rollD4() {
        return diceService.rollD4();
    }

    @GetMapping("d6")
    public Map<String, Object> rollD6() { return diceService.rollD6(); }

    @GetMapping("d8")
    public Map<String, Object> rollD8() { return diceService.rollD8(); }

    @GetMapping("d10")
    public Map<String, Object> rollD10() {
        return diceService.rollD10();
    }

    @GetMapping("d12")
    public Map<String, Object> rollD12() {
        return diceService.rollD12();
    }

    @GetMapping("d20")
    public Map<String, Object> rolld20() {
        return diceService.rollD20();
    }

    @GetMapping("d100")
    public Map<String, Object> rolld100() {
        return diceService.rollD100();
    }
}
