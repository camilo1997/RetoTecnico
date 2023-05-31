package com.reto.tecnico.runners;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.FeatureRunnerExtractors;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/create_user.feature",
        glue = "com.reto.tecnico.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CreateUserRunner {
}
