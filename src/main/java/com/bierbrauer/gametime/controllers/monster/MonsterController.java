package com.bierbrauer.gametime.controllers.monster;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "monster")
public class MonsterController {

    @GetMapping("get-all")
    public Map<String, Object> getAll() {
        return new HashMap<String, Object>() {{
           // todo return stuff
        }};
    }

    @GetMapping("get-by-id/{id}")
    public Map<String, Object> getById(@PathVariable Integer id) {
        return new HashMap<String, Object>() {{
            // todo return stuff
        }};
    }

    @PostMapping("new")
    public Map<String, Object> newRecord(@RequestBody Map<String, Object> payload) {
        return new HashMap<String, Object>() {{
            // todo return and post stuff
        }};
    }

    @PutMapping("update/{id}")
    public Map<String, Object> updateRecord(@RequestBody Map<String, Object> payload) {
        return new HashMap<String, Object>() {{
            // todo return and post stuff
        }};
    }

    @DeleteMapping("delete/{id}")
    public Map<String, Object> deleteRecord(@RequestBody Map<String, Object> payload) {
        return new HashMap<String, Object>() {{
            // todo return and post stuff
        }};
    }
}
