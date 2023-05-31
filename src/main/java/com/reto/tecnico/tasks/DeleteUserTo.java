package com.reto.tecnico.tasks;

import com.reto.tecnico.models.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import java.util.logging.Logger;

public class DeleteUserTo implements Task {

    private static final Logger LOGGER = Logger.getLogger(DeleteUserTo.class.getName());
    private String path;
    private String appId;
    private String idUser;
    private User user;

    public DeleteUserTo(User user, String path, String appId, String idUser) {
        this.path = path;
        this.appId = appId;
        this.idUser = idUser;
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Eliminando el usuario con el id " + idUser);
        actor.attemptsTo(
                Delete.from(path.concat(idUser)).with(
                        requestSpecification -> requestSpecification
                                .header("app-id", appId)
                                .relaxedHTTPSValidation()
                )
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

