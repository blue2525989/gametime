package com.bierbrauer.gametime.controllers.dice;

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
public class DiceControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void rollD2() throws Exception {
        for (int i = 0; i < 5000; i++) {
            HashMap response = this.restTemplate.getForObject("http://localhost:" + port + "/dice/d2",
                    HashMap.class);
            assertTrue("response is between the range of 1 and 2", (int) response.get("roll") >= 1 && (int) response.get("roll") <= 2);
        }
    }

    @Test
    public void rollD4() throws Exception {
        for (int i = 0; i < 5000; i++) {
            HashMap response = this.restTemplate.getForObject("http://localhost:" + port + "/dice/d4",
                    HashMap.class);
            assertTrue("response is between the range of 1 and 4", (int) response.get("roll") >= 1 && (int) response.get("roll") <= 4);
        }
    }

    @Test
    public void rollD6() throws Exception {
        for (int i = 0; i < 5000; i++) {
            HashMap response = this.restTemplate.getForObject("http://localhost:" + port + "/dice/d6",
                    HashMap.class);
            assertTrue("response is between the range of 1 and 6", (int) response.get("roll") >= 1 && (int) response.get("roll") <= 6);
        }
    }

    @Test
    public void rollD8() throws Exception {
        for (int i = 0; i < 5000; i++) {
            HashMap response = this.restTemplate.getForObject("http://localhost:" + port + "/dice/d8",
                    HashMap.class);
            assertTrue("response is between the range of 1 and 8", (int) response.get("roll") >= 1 && (int) response.get("roll") <= 8);
        }
    }

    @Test
    public void rollD10() throws Exception {
        for (int i = 0; i < 5000; i++) {
            HashMap response = this.restTemplate.getForObject("http://localhost:" + port + "/dice/d10",
                    HashMap.class);
            assertTrue("response is between the range of 1 and 10", (int) response.get("roll") >= 1 && (int) response.get("roll") <= 10);
        }
    }

    @Test
    public void rollD12() throws Exception {
        for (int i = 0; i < 5000; i++) {
            HashMap response = this.restTemplate.getForObject("http://localhost:" + port + "/dice/d12",
                    HashMap.class);
            assertTrue("response is between the range of 1 and 12", (int) response.get("roll") >= 1 && (int) response.get("roll") <= 12);
        }
    }

    @Test
    public void rollD20() throws Exception {
        for (int i = 0; i < 5000; i++) {
            HashMap response = this.restTemplate.getForObject("http://localhost:" + port + "/dice/d20",
                    HashMap.class);
            assertTrue("response is between the range of 1 and 20", (int) response.get("roll") >= 1 && (int) response.get("roll") <= 20);
        }
    }

    @Test
    public void rollD100() throws Exception {
        for (int i = 0; i < 5000; i++) {
            HashMap response = this.restTemplate.getForObject("http://localhost:" + port + "/dice/d100",
                    HashMap.class);
            assertTrue("response is between the range of 1 and 100", (int) response.get("roll") >= 1 && (int) response.get("roll") <= 100);
        }
    }

}
