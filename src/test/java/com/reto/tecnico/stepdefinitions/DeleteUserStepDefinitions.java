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
        theActorInTheSpotlight().attemptsTo(Create.withPath(PATH_USER_CREATE).andAppId(APP_ID).andUser(user));
        String userId = theActorInTheSpotlight().asksFor(GetUserId.ofResponse());
        theActorInTheSpotlight().remember("userId", userId);
        theActorInTheSpotlight().attemptsTo(Delete.withPath(PATH_USER).andAppId(APP_ID).andUserId(userId).AndUser(user));
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
        theActorInTheSpotlight().attemptsTo(Delete.withPath(PATH_USER).andAppId(APP_ID).andUserId(userId).AndUser(user));
    }
}
