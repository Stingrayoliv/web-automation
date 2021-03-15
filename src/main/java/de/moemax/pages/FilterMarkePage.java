package de.moemax.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FilterMarkePage {
    //private static final By clickMarke = By.xpath("//span[contains(text(),'Marke')]");



    public void clickOnFilter(String filter,String value) {
        String filterNameXpath = "//span[contains(text(),'" + filter + "')]";
        $(By.xpath(filterNameXpath)).click();
        String xpath = "//*[contains(text(),'" + value + "')]";
        $(By.xpath(xpath)).click();
        //  $(By.xpath(filterNameXpath)).click();
    }
    public SelenideElement checkQuantityOfGoods(String quantity) {
        String xpath = "//div[contains(text(), '" + quantity + "')]";
        return  $(By.xpath(xpath)).waitUntil(Condition.appears, 3000).shouldHave(Condition.exist);
    }
    public void filtersIsApplied(String marke, String farbe){
        $(By.xpath("//li/div/div/span")).shouldHave(text(marke));
        $(By.xpath("//li/div/div/span")).shouldHave(text(farbe));
    }
}
