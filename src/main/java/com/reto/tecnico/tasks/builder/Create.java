package com.reto.tecnico.tasks.builder;

import com.reto.tecnico.models.User;
import com.reto.tecnico.tasks.CreateUserTo;
import net.serenitybdd.screenplay.Tasks;

public class Create {

    private String path;
    private String appId;

    public Create(String path) {
        this.path = path;
    }
    public static Create withPath(String path){
        return new Create(path);
    }
    public Create andAppId(String appId){
        this.appId=appId;
        return this;
    }

    public CreateUserTo andUser(User user){
        return Tasks.instrumented(CreateUserTo.class, user, path, appId);
    }
}
