package Stepdefs;

import Hooks.Hooks;
import PageObjects.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomeStepdefs {

    static final String titreRegister = "Register";

    HomePage homePage = new HomePage();

    private WebDriver driver = Hooks.driver;

    @When("je entre le {string} dans la barre de recherche")
    public void jeEntreLeDansLaBarreDeRecherche(String url) {
        driver.get("https://practice.automationtesting.in/");
    }

    @Then("je verifie que le pave Register est present sur le espace My Account")
    public void jeVerifieQueLePaveRegisterEstPresentSurLeEspaceMyAccount() {
        homePage.accederMyAccount();
        homePage.verifierLaPresenceDeRigiterSurMyAccount(titreRegister);
    }

}
