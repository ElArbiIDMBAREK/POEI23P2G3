package Stepdefs;

import PageObjects.HomePage;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomeStepdefs {

    WebDriver driver = Hooks.driver;

    Hooks hooks = new Hooks();
    HomePage homePage = new HomePage(driver);

    @When("je entre le {string} dans la barre de recherche")
    public void jeEntreLeDansLaBarreDeRecherche(String url) {
        driver.get(url);
    }

}
