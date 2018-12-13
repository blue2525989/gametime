package com.bierbrauer.gametime.controllers.adventureMessages;

import com.bierbrauer.gametime.models.adventureMessage.AdventureMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestDocs
public class AdventureMessageControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        // call endpoint
        HashMap response = this.restTemplate.getForObject("http://localhost:" + port + "/get-all",
                HashMap.class);
        // do assertions
        assertTrue("response contains body key", response.containsKey("status"));
        assertTrue("response contains status key", response.containsKey("body"));

    }

    @Test
    public void crudFunctionality() throws Exception {
        // todo learn to post functionality
        AdventureMessage msg =  new AdventureMessage();
        msg.setMessage("TEST MESSAGE DELETE ME");
        msg.setRarity(10);
        HashMap responseCreate = this.restTemplate.postForObject("http://localhost:" + port + "/adventure-message/save",
                msg,
                HashMap.class);
        // do assertions
        assertTrue("response contains body key", responseCreate.containsKey("status"));
        assertTrue("response contains status key", responseCreate.containsKey("body"));

        // todo post
        HashMap responseFind = this.restTemplate.postForObject("http://localhost:" + port + "/adventure-message/FindByMessageFuzzy",
                new HashMap<String, String>() {{ put("message", "TEST MESSAGE DELETE ME"); }},
                HashMap.class);
        // do assertions
        assertTrue("response contains body key", responseCreate.containsKey("status"));
        assertTrue("response contains status key", responseCreate.containsKey("body"));

        // todo grab the msg id
        System.out.println("what does this body look like?" + responseFind.get("body"));
//
//        // todo delete
//        HashMap responseDelete = this.restTemplate.getForObject("http://localhost:" + port + "/adventure-message/delete/" + "<id>",
//                HashMap.class);
//        // do assertions
//        assertTrue("response contains body key", responseCreate.containsKey("status"));
//        assertTrue("response contains status key", responseCreate.containsKey("body"));

    }
}
