package de.sconto.steps;

import com.codeborne.selenide.Condition;
import de.sconto.pages.HomePage;
import de.sconto.pages.LoginPage;

import io.cucumber.docstring.DocString;
import io.cucumber.java8.En;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static de.sconto.pages.LoginPage.*;

/**
 * LoginSteps
 * Class implements the Login page step definitions.
 *
 * @author Violeta Abramova abramova.violetta@gmail.com
 */
public class LoginSteps implements En {

    LoginPage loginPage;
    HomePage homePage;

    public LoginSteps() {

        When( "I click on the Login icon", () -> {
            homePage = page( HomePage.class );
            loginPage = homePage.clickLoginIcon();
        } );

        Then( "I see Loginpage", () -> {
            loginPage.loginPageHeader().should( Condition.exist );
            loginPage.loginPageHeader().shouldHave( text( "Anmelden" ) );
        } );

        When( "I insert I insert {}", (String email) -> {
                $(emailInput).setValue(email);
        } );

        And( "I insert {}", (String password) -> {
            $(pwdInput).setValue(password);
        } );

        And( "I click on Login button", () -> {
            loginPage.clickLoginBtn();
        } );

        Then( "I see massage {}:", (DocString error) -> {
            String expectedMessage = error.getContent();
            $( By.id( "loginEmail-error") ).shouldHave( text( expectedMessage ) );
            //$(By.id( "loginPassword-error" )).shouldHave( text(error) );
        } );
    }
}
