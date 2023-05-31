package com.reto.tecnico.utils;

import com.github.javafaker.Faker;
import com.reto.tecnico.models.User;

import java.util.Locale;

public class Generate {

    private User user;

    private static final Faker FAKER = new Faker(new Locale("es"));

    public static User user() {
        return new User(
                FAKER.name().firstName(),
                FAKER.name().lastName(),
                FAKER.bothify("####?????@yopmail.com"));
    }
    public static User userWithEmailIncorrect(){
        return new User(
                FAKER.name().firstName(),
                FAKER.name().lastName(),
                FAKER.bothify("#######"));
    }
     public static User userWithoutEmail(){
        return new User(FAKER.name().firstName(), FAKER.name().lastName());
     }
     public static String idIncorrect(){
        return FAKER.bothify("######");
     }
    public static String appIdIncorrect(){
        return FAKER.bothify("##########");
    }
    public static String pathIncorrect(){
        return FAKER.bothify("????????");
    }
}
