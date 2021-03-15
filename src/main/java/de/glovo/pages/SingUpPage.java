package de.glovo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SingUpPage extends BasePage{
   private static final By nameInput =By.name("inner_name");
   private static final By emailInput=By.name("inner_email");
   private static By passwordInput=By.name("inner_password");
   public static By submitButton=By.xpath("//button[@data-test-id='signup-submit']");

   public void singUp(String nameValue, String emailValue, String passwordValue) {
       $(nameInput).setValue( nameValue);
       $(emailInput).setValue( emailValue );
       $(passwordInput).setValue( passwordValue );
   }

   public PrivacyPage clickSubmit(){
       $(submitButton).click();
       return page(PrivacyPage.class);
   }


}
