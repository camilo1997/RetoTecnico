package com.reto.tecnico.stepdefinitions;

import com.reto.tecnico.questions.GetId;
import com.reto.tecnico.questions.GetLastResponse;
import com.reto.tecnico.tasks.builder.GetUser;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import static com.reto.tecnico.utils.Constant.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

public class GetUserStepDefinitions {
    @When("I get user by id")
    public void iGetUserById() {
        theActorInTheSpotlight().attemptsTo(GetUser.withPath(PATH_USER).andAppId(APP_ID));
        String idUser = theActorInTheSpotlight().asksFor(GetId.allUsers());
        theActorInTheSpotlight().attemptsTo(GetUser.withPath(PATH_USER.concat(idUser)).andAppId(APP_ID));
    }
    @Then("I see that the response is not empty")
    public void iSeeThatTheResponseIsNotEmpty() {
        theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(),
                containsString("id")));
    }
}
