package com.bierbrauer.gametime.services.dice;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static org.junit.Assert.*;

public class DiceServiceTest {

    DiceService diceService = new DiceService();

    @Test
    public void rollD2() {
        HashMap roll = (HashMap<String, Object>) diceService.rollD2();
        assertTrue("contains key roll", roll.containsKey("roll"));
        assertTrue("", roll.get("roll") != null);
        assertTrue("", roll.get("roll") instanceof Integer);
    }

    @Test
    public void rollD4() {
        HashMap roll = (HashMap<String, Object>) diceService.rollD4();
        assertTrue("contains key roll", roll.containsKey("roll"));
        assertTrue("", roll.get("roll") != null);
        assertTrue("", roll.get("roll") instanceof Integer);
    }

    @Test
    public void rollD6() {
        HashMap roll = (HashMap<String, Object>) diceService.rollD6();
        assertTrue("contains key roll", roll.containsKey("roll"));
        assertTrue("", roll.get("roll") != null);
        assertTrue("", roll.get("roll") instanceof Integer);
    }

    @Test
    public void rollD8() {
        HashMap roll = (HashMap<String, Object>) diceService.rollD8();
        assertTrue("contains key roll", roll.containsKey("roll"));
        assertTrue("", roll.get("roll") != null);
        assertTrue("", roll.get("roll") instanceof Integer);
    }

    @Test
    public void rollD10() {
        HashMap roll = (HashMap<String, Object>) diceService.rollD10();
        assertTrue("contains key roll", roll.containsKey("roll"));
        assertTrue("", roll.get("roll") != null);
        assertTrue("", roll.get("roll") instanceof Integer);
    }

    @Test
    public void rollD12() {
        HashMap roll = (HashMap<String, Object>) diceService.rollD12();
        assertTrue("contains key roll", roll.containsKey("roll"));
        assertTrue("", roll.get("roll") != null);
        assertTrue("", roll.get("roll") instanceof Integer);
    }

    @Test
    public void rollD20() {
        HashMap roll = (HashMap<String, Object>) diceService.rollD20();
        assertTrue("contains key roll", roll.containsKey("roll"));
        assertTrue("", roll.get("roll") != null);
        assertTrue("", roll.get("roll") instanceof Integer);
    }

    @Test
    public void rollD100() {
        HashMap roll = (HashMap<String, Object>) diceService.rollD100();
        assertTrue("contains key roll", roll.containsKey("roll"));
        assertTrue("", roll.get("roll") != null);
        assertTrue("", roll.get("roll") instanceof Integer);
    }

    @Test
    public void rollAndKeep() {
        HashMap roll = (HashMap<String, Object>) diceService.rollAndKeep(20, 4, 3);
        assertTrue("contains key average", roll.containsKey("average"));
        assertTrue("contains key keptRolls", roll.containsKey("keptRolls"));
        assertTrue("contains key allRolls", roll.containsKey("allRolls"));
        assertTrue("", roll.get("average") != null);
        assertTrue("", roll.get("average") instanceof Integer);
    }
}
