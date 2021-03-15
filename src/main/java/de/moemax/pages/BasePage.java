package de.moemax.pages;

import de.moemax.util.PropertiesLoader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    public static String basicURL = "https://www.moemax.de";
    private static final By clickCookies = By.xpath("//button[@data-purpose='cookieBar.button.accept']");

    public void acceptCookies() {
        if ($(clickCookies).exists()) {
            $(clickCookies).click();
        }

    }
}
