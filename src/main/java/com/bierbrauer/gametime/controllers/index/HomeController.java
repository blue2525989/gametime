package com.bierbrauer.gametime.controllers.index;

//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
//@AutoConfigureRestDocs
public class HomeController {

    @RequestMapping(path = {"/", "/greeting"})
    public Map<String, Object> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Map<String, Object> greeting = new HashMap<String, Object>() {{
            String template = "Hello %s";
            put("message", String.format(template, name));
            put("status", 200);
        }};
        return greeting;
    }
}
