package Stepdefs;

import PageObjects.BasketPage;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class BasketStepdefs {

    WebDriver driver = Hooks.driver;

    BasketPage basketPage = new BasketPage(driver);

    @Then("je verifie que je suis sur la page Basket")
    public void jeVerifieQueJeSuisSurLaPageBasket() {
        basketPage.verifierPresenceTitreBasket();
    }
}
