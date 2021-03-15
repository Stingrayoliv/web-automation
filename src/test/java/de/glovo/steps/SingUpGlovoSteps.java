package de.glovo.steps;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import de.glovo.pages.LastPage;
import de.glovo.pages.SingUpPage;
import de.glovo.pages.PrivacyPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class SingUpGlovoSteps {
    SingUpPage singUpPage;
    Faker faker = new Faker();
    PrivacyPage privacyPage;
    LastPage lastPage;

    @When("I insert user credentials:")
    public void fillLoginInputs(DataTable fields) {
        singUpPage = page(SingUpPage.class );
        List<Map<String, String>> inputData = fields.asMaps();
        for (Map<String, String> form : inputData) {
            String nameValue = form.get( "name" );
            //String emailValue=form.get("email");
            String emailValue = faker.internet().emailAddress();
            String passwordValue = form.get( "password" );
            singUpPage.singUp( nameValue, emailValue, passwordValue );

        }
    }

    @And("I click on button Signup")
    public PrivacyPage submitData() {
        return singUpPage.clickSubmit();
    }

    @Then("I see PrivacyPage")
    public void confirmTextOnPage(String message) {
        privacyPage.checkMessage( "Privacy" );
    }

    @When("I click on checkbox")
    public void clickCheckboxOnPrivacyPage() {
        privacyPage.clickCheckbox();
    }

    @And("I click on button Continue")
    public LastPage clickButtonContinue() {
        return privacyPage.clickBtnContinue();
    }

    @Then("Then I see account creation message")
    public void checkMessage() {
        lastPage.checkMessage().exists();
    }
}
