package com.aston.mihail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int Id;
    private String login;
    private String password;


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
