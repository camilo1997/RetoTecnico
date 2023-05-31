package com.reto.tecnico.tasks.builder;

import com.reto.tecnico.models.User;
import com.reto.tecnico.tasks.CreateUserTo;
import net.serenitybdd.screenplay.Tasks;

public class Create {

    private String path;
    private String appId;

    public Create(String path, String appId) {
        this.path = path;
        this.appId = appId;
    }
    public static Create withData(String path, String appId){
        return new Create(path, appId);
    }

    public CreateUserTo AndWith(User user){
        return Tasks.instrumented(CreateUserTo.class, user, path, appId);
    }
}
