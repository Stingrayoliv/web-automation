package de.glovo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class LastPage {
    public static By accountMessageText = By.xpath("//h4/div");
    //String message="let’s make your account secure";

    public SelenideElement checkMessage(){
        return (SelenideElement) accountMessageText;
    }
}
