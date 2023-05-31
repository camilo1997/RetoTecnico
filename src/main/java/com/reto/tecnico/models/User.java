package com.reto.tecnico.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    public String firstName;
    public String lastName;
    public String email;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
