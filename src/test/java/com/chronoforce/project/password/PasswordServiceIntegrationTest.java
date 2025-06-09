package com.chronoforce.project.password;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PasswordServiceIntegrationTest {

    @Autowired
    private PasswordService passwordService;

    @Test
    public void testPasswordMatches() {
        String raw = "123";
        String encoded = passwordService.encode(raw);
        System.out.println("Encoded Password: " + encoded);
        assertTrue(passwordService.matches(raw, encoded));
    }
}
