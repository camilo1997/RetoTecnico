package com.reto.tecnico.tasks.builder;

import com.reto.tecnico.tasks.GetUserTo;
import net.serenitybdd.screenplay.Tasks;

public class GetUser {
    private String path;

    public GetUser(String path) {
        this.path = path;
    }
    public static GetUser withPath(String path){
        return new GetUser(path);
    }
    public GetUserTo andAppId(String appId){
        return Tasks.instrumented(GetUserTo.class, path, appId);
    }
}
