package Stepdefs;

import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomeStepdefs {

    WebDriver driver = Hooks.driver;

    @When("je entre le {string} dans la barre de recherche")
    public void jeEntreLeDansLaBarreDeRecherche(String url) {
        driver.get(url);
    }

}
