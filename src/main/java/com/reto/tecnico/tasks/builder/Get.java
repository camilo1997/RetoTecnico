package com.reto.tecnico.tasks.builder;

import com.reto.tecnico.tasks.GetUserTo;
import net.serenitybdd.screenplay.Tasks;

public class Get {
    private String path;

    public Get(String path) {
        this.path = path;
    }
    public static Get withPath(String path){
        return new Get(path);
    }
    public GetUserTo andAppId(String appId){
        return Tasks.instrumented(GetUserTo.class, path, appId);
    }
}
