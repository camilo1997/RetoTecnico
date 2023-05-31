package com.reto.tecnico.tasks;

import com.reto.tecnico.models.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.logging.Logger;

public class UpdateUserTo implements Task {
    private static final Logger LOGGER = Logger.getLogger(UpdateUserTo.class.getName());
    private String appId;
    private User user;
    private String path;

    public UpdateUserTo(User user, String path, String appId) {
        this.appId = appId;
        this.user = user;
        this.path = path;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Actualizando el usuario con id" + path.replace("user/",""));
        actor.attemptsTo(
                Put.to(path)
                        .with(requestSpecification -> requestSpecification
                                .header("app-id", appId)
                                .body(user)
                                .relaxedHTTPSValidation())
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
