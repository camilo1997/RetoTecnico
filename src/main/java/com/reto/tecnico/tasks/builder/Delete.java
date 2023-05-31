package com.reto.tecnico.tasks.builder;

import com.reto.tecnico.models.User;
import com.reto.tecnico.tasks.DeleteUserTo;
import com.reto.tecnico.tasks.UpdateUserTo;
import io.cucumber.java.hu.De;
import net.serenitybdd.screenplay.Tasks;

public class Delete {
    private String path;
    private String appId;


    public Delete(String path, String appId) {
        this.path = path;
        this.appId = appId;
    }



    public static Delete withData(String path, String appId){
        return new Delete(path, appId);
    }


    public DeleteUserTo AndWith(User user, String userId){
        return Tasks.instrumented(DeleteUserTo.class, user, path, appId, userId);
    }
}
