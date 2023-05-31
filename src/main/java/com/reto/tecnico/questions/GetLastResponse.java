package com.reto.tecnico.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetLastResponse implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().body().asString();
    }
    public static GetLastResponse ofResponse(){
        return new GetLastResponse();
    }
}
