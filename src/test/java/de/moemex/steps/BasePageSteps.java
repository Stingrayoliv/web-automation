package de.moemex.steps;

import de.moemax.pages.BasePage;
import io.cucumber.java8.En;

import static com.codeborne.selenide.Selenide.open;
import static de.moemax.pages.BasePage.basicURL;

public class BasePageSteps implements En {
    BasePage basePage;

    public BasePageSteps() {
        Given("I am on the Search page", () -> {

            basePage = open(basicURL + "/s/", BasePage.class);
            basePage.acceptCookies();

        });

    }

}
