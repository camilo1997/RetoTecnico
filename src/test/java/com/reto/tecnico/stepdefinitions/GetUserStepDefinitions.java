package com.reto.tecnico.stepdefinitions;

import com.reto.tecnico.questions.GetId;
import com.reto.tecnico.questions.GetLastResponse;
import com.reto.tecnico.tasks.builder.Get;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.reto.tecnico.utils.Constant.APP_ID;
import static com.reto.tecnico.utils.Constant.PATH_USER;
import static com.reto.tecnico.utils.Generate.idIncorrect;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

public class GetUserStepDefinitions {
    @When("I get user by id")
    public void iGetUserById() {
        theActorInTheSpotlight().attemptsTo(Get.withPath(PATH_USER).andAppId(APP_ID));
        String idUser = theActorInTheSpotlight().asksFor(GetId.allUsers());
        theActorInTheSpotlight().attemptsTo(Get.withPath(PATH_USER.concat(idUser)).andAppId(APP_ID));
    }
    @Then("I see that the response is not empty")
    public void iSeeThatTheResponseIsNotEmpty() {
        theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(),
                containsString("id")));
    }
    @When("I get all users")
    public void iGetAllUsers() {
        theActorInTheSpotlight().attemptsTo(Get.withPath(PATH_USER).andAppId(APP_ID));
    }
    @When("I get user by id incorrect")
    public void iGetUserByIdIncorrect() {
        String path = PATH_USER.concat(idIncorrect());
        theActorInTheSpotlight().attemptsTo(Get.withPath(path).andAppId(APP_ID));
    }
    @Then("I see that message params not valid")
    public void iSeeThatMessageParamsNotValid() {
        theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(),
                containsString("PARAMS_NOT_VALID")));
    }


}
