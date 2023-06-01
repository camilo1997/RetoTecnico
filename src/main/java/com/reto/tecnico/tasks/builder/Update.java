package com.reto.tecnico.tasks.builder;

import com.reto.tecnico.models.User;
import com.reto.tecnico.tasks.CreateUserTo;
import com.reto.tecnico.tasks.UpdateUserTo;
import net.serenitybdd.screenplay.Tasks;

public class Update {
    private String path;
    private String appId;

    public Update(String path) {
        this.path = path;
    }

    public static Update withPath(String path){
        return new Update(path);
    }
    public Update andAppId(String appId){
        this.appId=appId;
        return this;
    }

    public UpdateUserTo andUser(User user){
        return Tasks.instrumented(UpdateUserTo.class, user, path, appId);
    }
}
