package com.reto.tecnico.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.json.JSONObject;

public class GetUserId implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        String response = SerenityRest.lastResponse().body().asString();
        JSONObject jsonObj = new JSONObject(response);
        return jsonObj.getString("id");
    }
    public static GetUserId ofResponse(){
        return new GetUserId();
    }
}
