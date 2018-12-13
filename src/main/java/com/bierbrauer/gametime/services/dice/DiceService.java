package com.bierbrauer.gametime.services.dice;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class DiceService {

    public Map<String, Object> rollD2() {
        return new HashMap<String, Object>() {{
            put("roll", randomNumber(2));
        }};
    }

    public Map<String, Object> rollD4() {
        return new HashMap<String, Object>() {{
            put("roll", randomNumber(4));
        }};
    }

    public Map<String, Object> rollD6() {
        return new HashMap<String, Object>() {{
            put("roll", randomNumber(6));
        }};
    }

    public Map<String, Object> rollD8() {
        return new HashMap<String, Object>() {{
            put("roll", randomNumber(8));
        }};
    }

    public Map<String, Object> rollD10() {
        return new HashMap<String, Object>() {{
            put("roll", randomNumber(10));
        }};
    }

    public Map<String, Object> rollD12() {
        return new HashMap<String, Object>() {{
            put("roll", randomNumber(12));
        }};
    }

    public Map<String, Object> rollD20() {
        return new HashMap<String, Object>() {{
            put("roll", randomNumber(20));
        }};
    }

    public Map<String, Object> rollD100() {
        return new HashMap<String, Object>() {{
            put("roll", randomNumber(100));
        }};
    }

    /**
     * randomNumber
     * generate a random number in range
     * @param dieSize
     * @return
     */
    private Integer randomNumber(int dieSize) {
        Random rand = new Random();
        return rand.nextInt(dieSize) + 1;
    }
}
