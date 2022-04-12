package com.aston.mihail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    int id;
    private String name;
    private String surName;
    private String email;
    private String phone;

    public Owner(String name, String surName, String email, String phone) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.phone = phone;
    }
}
