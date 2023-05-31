package com.reto.tecnico.stepdefinitions;

import com.reto.tecnico.models.User;
import com.reto.tecnico.questions.GetId;
import com.reto.tecnico.questions.GetLastResponse;
import com.reto.tecnico.questions.GetUserId;
import com.reto.tecnico.tasks.builder.Create;
import com.reto.tecnico.tasks.builder.Delete;
import com.reto.tecnico.utils.Generate;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import static com.reto.tecnico.utils.Constant.*;
import static com.reto.tecnico.utils.Generate.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

public class DeleteUserStepDefinitions {
    @When("I delete user existing")
    public void iDeleteUserExisting() {
        User user = user();
        theActorInTheSpotlight().attemptsTo(Create.withData(PATH_USER_CREATE,APP_ID).AndWith(user));
        String userId = theActorInTheSpotlight().asksFor(GetUserId.ofResponse());
        theActorInTheSpotlight().remember("userId", userId);
        theActorInTheSpotlight().attemptsTo(Delete.withData(PATH_USER,APP_ID).AndWith(user,userId));
    }
    @Then("I see that id user")
    public void iSeeThatIdUser() {
        String userId = theActorInTheSpotlight().recall("userId").toString();
        theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), containsString(userId)));
    }
    @When("I delete user that not exist")
    public void iDeleteUserThatNotExist() {
        User user = user();
        String userId = Generate.idIncorrect();
        theActorInTheSpotlight().attemptsTo(Delete.withData(PATH_USER,APP_ID).AndWith(user,userId));
    }
}
