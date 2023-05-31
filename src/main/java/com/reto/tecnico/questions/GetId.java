package com.reto.tecnico.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetId implements Question<String>{
    @Override
    public String answeredBy(Actor actor) {
        String response = SerenityRest.lastResponse().body().asString();
        JSONObject jsonObj = new JSONObject(response);
        JSONArray data = jsonObj.getJSONArray("data");
        JSONObject first = data.getJSONObject(0);
        return first.getString("id");
    }
    public static GetId allUsers(){
        return new GetId();
    }
}
