package de.glovo.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    //public static String basicURL="https://business.glovoapp.com/";
    private static final By cookies= By.id( "onetrust-accept-btn-handler" );

    public void acceptCookies(){
            $(cookies).click();
    }
}
