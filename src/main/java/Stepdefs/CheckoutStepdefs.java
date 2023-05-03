package Stepdefs;

import PageObjects.CheckoutPage;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class CheckoutStepdefs {

    WebDriver driver = Hooks.driver;

    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Then("je verifie que je suis sur la page Paiement")
    public void jeVerifieQueJeSuisSurLaPagePaiement() {
        checkoutPage.verifierPresenceTitreYourOrder();
    }

}
