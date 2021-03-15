package de.glovo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class PrivacyPage {
    private static final By checkbox=By.cssSelector(".el-checkbox__inner");
    private static final By buttonContinue = By.xpath("//form/button[2]/span");
    private static final By privacyMessage=By.xpath("//h1");


    public void clickCheckbox() {
        $(checkbox).click();
    }

    public LastPage clickBtnContinue(){
        $(buttonContinue).click();
        return page(LastPage.class);
    }

    public void checkMessage(String message){
        $(privacyMessage).shouldHave( Condition.text(message) );
    }
}
