package Stepdefs;

import PageObjects.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomeStepdefs {

    WebDriver driver = Hooks.driver;

    HomePage homePage = new HomePage(driver);

    @Given("je suis sur la page Home")
    public void jeSuisSurLaPageHome() {
        Hooks.accederHome();
    }

    @When("je clique sur le bouton My Account")
    public void jeCliqueSurLeBoutonMyAccount() {
        homePage.accederMyAccount();
    }

    @Then("je verifie que la icone Panier est presente")
    public void jeVerifieQueLaIconePanierEstPresente() {
        homePage.verifierPresenceIconePanier();
        homePage.accederMyAccount();
        homePage.verifierPresenceIconePanier();
        Hooks.accederHome();
        homePage.accederShop();
        homePage.verifierPresenceIconePanier();
    }
}
