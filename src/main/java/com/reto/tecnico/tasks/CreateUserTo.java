package com.reto.tecnico.tasks;


import com.reto.tecnico.models.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.logging.Logger;

import static com.reto.tecnico.utils.Constant.APP_ID;

public class CreateUserTo implements Task {

    private static final Logger LOGGER = Logger.getLogger(CreateUserTo.class.getName());
    private User user;
    private String path;
    private String appId;

    public CreateUserTo(User user, String path, String appId) {
        this.user = user;
        this.path = path;
        this.appId = appId;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Realizando Creacion del usuario " + user.firstName);
        actor.attemptsTo(Post.to(path).with(requestSpecification ->
                requestSpecification.header("app-id", appId)
                        .body(user).relaxedHTTPSValidation()));
        SerenityRest.lastResponse().prettyPrint();
        LOGGER.info("Response de la petición: " + SerenityRest.lastResponse().asString() + "con un status code: "
                + SerenityRest.lastResponse().statusCode());
    }

}