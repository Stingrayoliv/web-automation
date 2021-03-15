package de.moemex.steps;

import de.moemax.pages.FilterMarkePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class FilterMarkeSteps implements En {
    FilterMarkePage filterMarkePage;

    public FilterMarkeSteps() {

        When("I search for the {}", (String make) -> {
            filterMarkePage = page(FilterMarkePage.class);
            filterMarkePage.clickOnFilter("Marke", make);

        });

        And("I am checking the {} of goods", (String quantity) -> {
            filterMarkePage.checkQuantityOfGoods(quantity);
        });

        Then("I see the filter {} is applied", (String make) -> {
            $( By.xpath("//li/div/div/span")).shouldHave(text(make));
        });

        When("I apply filters:", (DataTable filters) -> {
            filterMarkePage = page(FilterMarkePage.class);
            List<Map<String, String>> searchFilters = filters.asMaps();
            for (Map<String, String> filter : searchFilters) {
                String markeValue = filter.get("Marke");
                String farbeValue = filter.get("Farbe");
                filterMarkePage.clickOnFilter("Marke", markeValue);
                filterMarkePage.clickOnFilter("Farbe", farbeValue);
            }
        });
        Then("I see quantity of goods 15", () -> {
            $(By.xpath("//div[contains(text(),'15 Artikel')]")).exists();

        });
        Then("I see the filters are applied:", (DataTable filtersApplied) -> {
            List<Map<String, String>> applied = filtersApplied.asMaps();
            for (Map<String, String> filter : applied) {
                String markeValue = filter.get("Marke");
                String farbeValue = filter.get("Farbe");
                filterMarkePage.filtersIsApplied(markeValue, farbeValue);
            }
        });
    }
}
