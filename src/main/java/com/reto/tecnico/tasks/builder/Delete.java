package com.reto.tecnico.tasks.builder;

import com.reto.tecnico.models.User;
import com.reto.tecnico.tasks.DeleteUserTo;
import com.reto.tecnico.tasks.UpdateUserTo;
import io.cucumber.java.hu.De;
import net.serenitybdd.screenplay.Tasks;

public class Delete {
    private String path;
    private String appId;
    private String userId;


    public Delete(String path) {
        this.path = path;
    }

    public static Delete withPath(String path){
        return new Delete(path);
    }
    public Delete andAppId(String appId){
        this.appId=appId;
        return this;
    }
    public Delete andUserId(String userId){
        this.userId=userId;
        return this;
    }

    public DeleteUserTo AndUser(User user){
        return Tasks.instrumented(DeleteUserTo.class, user, path, appId, userId);
    }
}
