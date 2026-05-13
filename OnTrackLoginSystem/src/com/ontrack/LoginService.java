package com.ontrack;

public class LoginService {

    public boolean login(String username, String password) {

        return username.equals("student") &&
               password.equals("deakin123");
    }
}