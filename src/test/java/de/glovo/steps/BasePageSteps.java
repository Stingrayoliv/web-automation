package de.glovo.steps;

import de.glovo.pages.BasePage;
import io.cucumber.java.af.En;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class BasePageSteps {
    BasePage basePage;

    @Given("I am on the SingUpPage page")
    public void goToLoginPage(){
        basePage = open("https://business.glovoapp.com/signup", BasePage.class);
    }

    @When( "I accept cookies" )
    public void accept(){
        basePage.acceptCookies();
    }
}
