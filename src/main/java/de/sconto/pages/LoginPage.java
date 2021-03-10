package de.sconto.pages;

import com.codeborne.selenide.SelenideElement;
import de.sconto.util.PropertiesLoader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    /* Properties */
    private static String validEmail = PropertiesLoader.loadProperty("valid.email");
    private static String validPwd = PropertiesLoader.loadProperty("valid.password");

    /* Elements */

    public static By emailInput = By.id("loginEmail");
    public static By pwdInput = By.id("loginPassword");
    public static By loginBtn = By.id("login-submit");
    private static By loginHeader = By.cssSelector(".existingAccount__headline");


    public void validLoginInput() {
        $(emailInput).setValue(validEmail);
        $(pwdInput).setValue(validPwd);
    }

    public void clickLoginBtn(){
        $(loginBtn).click();
    }

    public SelenideElement loginPageHeader() {return $(loginHeader); }
}
