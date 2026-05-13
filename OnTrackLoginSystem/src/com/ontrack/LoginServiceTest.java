package com.ontrack;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class LoginServiceTest {

    @Test
    public void testValidLogin() {

        LoginService service = new LoginService();

        assertTrue(service.login("student", "deakin123"));
    }

    @Test
    public void testInvalidLogin() {

        LoginService service = new LoginService();

        assertFalse(service.login("student", "wrongpass"));
    }
}