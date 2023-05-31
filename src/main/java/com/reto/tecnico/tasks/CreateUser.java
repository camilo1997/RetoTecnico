package com.reto.tecnico.tasks;


import com.reto.tecnico.models.User;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.logging.Logger;

import static com.reto.tecnico.utils.Constant.APP_ID;
import static com.reto.tecnico.utils.Constant.PATH_USER_CREATE;

public class CreateUser implements Task {

    private static final Logger LOGGER = Logger.getLogger(CreateUser.class.getName());
    private User user;

    public CreateUser(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Realizando Creacion del usuario " + user.firstName);
        actor.attemptsTo(Post.to(PATH_USER_CREATE).with(requestSpecification ->
                requestSpecification.header("app-id", APP_ID)
                        .body(user).relaxedHTTPSValidation()));
        SerenityRest.lastResponse().prettyPrint();
    }
    public static CreateUser withData(User user){
        return Tasks.instrumented(CreateUser.class, user);
    }
}
