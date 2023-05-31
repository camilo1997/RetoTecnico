package com.reto.tecnico.stepdefinitions;

import com.reto.tecnico.models.User;
import com.reto.tecnico.questions.GetLastResponse;
import com.reto.tecnico.questions.GetStatusCode;
import com.reto.tecnico.tasks.CreateUserTo;
import com.reto.tecnico.tasks.builder.CreateUser;
import com.reto.tecnico.utils.Generate;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import static com.reto.tecnico.utils.Constant.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.*;

public class CreateUserStepDefinitions {


    @Given("I have access to the service")
    public void iHaveAccessToTheService() {
        setTheStage(new OnlineCast());
        theActorCalled("User").whoCan(CallAnApi.at(URL));
    }

    @When("I create a user with correct data")
    public void iCreateAUserWithCorrectData() {
        User user = Generate.user();
        theActorInTheSpotlight().remember("user", user);
        theActorInTheSpotlight().attemptsTo(CreateUser.withData(PATH_USER_CREATE,APP_ID).AndWith(user));
    }

    @Then("I see the response code {int}")
    public void iSeeTheResponseCode(Integer code) {
        theActorInTheSpotlight().should(seeThat(GetStatusCode.ofResponse(), equalTo(code)));
    }

    @Then("I see that the answer is not empty")
    public void iSeeThatTheAnswerIsNotEmpty() {
        theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), containsString("id")));

    }

    @Then("I see user data")
    public void iSeeUserData() {
        User user = theActorInTheSpotlight().recall("user");
        theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), allOf(
                containsString(user.getEmail()),
                containsString(user.getFirstName()),
                containsString(user.getLastName())
        )));
    }
    @When("I create user without email incorrect")
    public void iCreateUserWithoutEmailIncorrect() {
        User user = Generate.userWithEmailIncorrect();
        OnStage.theActorInTheSpotlight().attemptsTo(CreateUser.withData(PATH_USER_CREATE,APP_ID).AndWith(user));
            }
    @Then("I see the invalid email message")
    public void iSeeTheInvalidEmailMessage() {
        theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), allOf(
                containsString("BODY_NOT_VALID"),
                containsString("Path `email` is invalid")
        )));
    }

    @When("I create user without email")
    public void iCreateUserWithoutEmail() {
        User user = Generate.userWithoutEmail();
        theActorInTheSpotlight().attemptsTo(CreateUser.withData(PATH_USER_CREATE,APP_ID).AndWith(user));
    }
    @Then("I see the message email is required")
    public void iSeeTheMessageEmailIsRequired() {
        theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), allOf(
                containsString("BODY_NOT_VALID"),
                containsString("Path `email` is required")
        )));
    }
    @When("I create user with email already used")
    public void iCreateUserWithEmailAlreadyUsed() {
        User user = Generate.user();
        user.setEmail("test@test.com");
        theActorInTheSpotlight().attemptsTo(CreateUser.withData(PATH_USER_CREATE,APP_ID).AndWith(user));
    }
    @Then("I see the message Email already use")
    public void iSeeTheMessageEmailAlreadyUse() {
        OnStage.theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), Matchers.allOf(
                Matchers.containsString("BODY_NOT_VALID"),
                Matchers.containsString("Email already used")
        )));
    }

}
