package com.reto.tecnico.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.logging.Logger;

public class GetUserTo implements Task {
    private static final Logger LOGGER = Logger.getLogger(GetUserTo.class.getName());
    private String path;
    private String appId;

    public GetUserTo(String path, String appId) {
        this.path = path;
        this.appId = appId;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Obteniendo todos los usuarios de dummyapi");
        actor.attemptsTo(
                Get.resource(path)
                        .with(requestSpecification -> requestSpecification.header("app-id", appId))
        );
        if (SerenityRest.lastResponse().statusCode() == 200) {
            LOGGER.info("Petición exitosa, response de la peticion: " + SerenityRest.lastResponse().asString());
        } else {
            LOGGER.info("Error al momento de hacer la petición, este es el response: "
                    + SerenityRest.lastResponse().asString());
        }
        SerenityRest.lastResponse().prettyPrint();
    }
}
