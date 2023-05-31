package com.reto.tecnico.tasks.builder;

import com.reto.tecnico.models.User;
import com.reto.tecnico.tasks.CreateUserTo;
import net.serenitybdd.screenplay.Tasks;

public class CreateUser {

    private String path;
    private String appId;

    public CreateUser(String path, String appId) {
        this.path = path;
        this.appId = appId;
    }
    public static CreateUser withData(String path, String appId){
        return new CreateUser(path, appId);
    }

    public CreateUserTo AndWith(User user){
        return Tasks.instrumented(CreateUserTo.class, user, path, appId);
    }
}
