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

        Then( "I see Login page", () -> {
            loginPage.loginPageHeader().should( Condition.exist );
            loginPage.loginPageHeader().shouldHave( text( "Anmelden" ) );
        } );

        When( "I insert {} credentials", (String state) -> {
            if (state.equals( "valid" )) {
                loginPage.validLoginInput();
            }
            if (state.equals( "invalid" )){
                $( By.id( "username" ) ).setValue( "tomsmith" );
                $( By.id( "password" ) ).setValue( "8888888" );//неверный пароль
                $( By.cssSelector( ".radius" ) ).click();
            }
        } );

        Then( "I see error massage:", (DocString message) -> {
            String expectedMessage = message.getContent();
            $( By.id( "flash" ) ).shouldHave( text( expectedMessage ) );
        } );

        When( "I click on Login button", () -> {
            loginPage.clickLoginBtn();
        } );
    }
}
