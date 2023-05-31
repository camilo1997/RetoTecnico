package com.reto.tecnico.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetStatusCode implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
    public static GetStatusCode ofResponse(){
        return new GetStatusCode();
    }
}
