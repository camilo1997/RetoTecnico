package com.reto.tecnico.tasks.builder;

import com.reto.tecnico.models.User;
import com.reto.tecnico.tasks.CreateUserTo;
import com.reto.tecnico.tasks.UpdateUserTo;
import net.serenitybdd.screenplay.Tasks;

public class Update {
    private String path;
    private String appId;

    public Update(String path, String appId) {
        this.path = path;
        this.appId = appId;
    }
    public static Update withData(String path, String appId){
        return new Update(path, appId);
    }

    public UpdateUserTo AndWith(User user){
        return Tasks.instrumented(UpdateUserTo.class, user, path, appId);
    }
}
