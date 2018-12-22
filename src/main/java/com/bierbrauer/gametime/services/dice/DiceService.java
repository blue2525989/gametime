package com.bierbrauer.gametime.services.dice;

import org.springframework.stereotype.Service;

import java.util.*;

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

    public Map<String, Object> rollAndKeep(int dieSize, int dieAmount, int keepAmount) {
        if (dieSize != 0 && dieSize % 2 == 0 && dieSize <= 20 || dieSize == 100) {
            List<Integer> rolls = new ArrayList<>();
            List<Integer> keptRolls = new ArrayList<>();
            int average = 0;
            for (int i = 0; i < dieAmount; i++) {
                int roll = randomNumber(dieSize);
                rolls.add( roll );
            }

            // sort it
            rolls.sort((o1, o2) -> {
                if (o1 < o2) {
                    return -1;
                } else if (o1 > o2) {
                    return 1;
                } else {
                    return 0;
                }
            });

            int rollsSize = rolls.size() -1;
            for (int i = 0; i < keepAmount; i++) {
                average += rolls.get(rollsSize);
                keptRolls.add(rolls.get(rollsSize));
                rollsSize--;
            }

            final int value = average;
            return new HashMap<String, Object>() {{
                put("average", value);
                put("keptRolls", keptRolls);
                put("allRolls", rolls);
            }};
        } else {
            return new HashMap<String, Object>() {{
                put("status", 501);
                put("body", "Please enter proper die size, " + dieSize + " is not valid.");
            }};
        }
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
