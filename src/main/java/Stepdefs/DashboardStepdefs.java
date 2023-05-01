package Stepdefs;

import PageObjects.DashboardPage;
import PageObjects.MyAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class DashboardStepdefs {

    WebDriver driver = Hooks.driver;

    MyAccountPage myAccountPage = new MyAccountPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);

    @Then("je verifie que je suis sur la page Dashboard")
    public void jeVerifieQueJeSuisSurLaPageDashboard() {
        dashboardPage.verifierPresenceMessageBienvenue();
    }

    @And("je me deconnecte")
    public void jeMeDeconnecte() {
        dashboardPage.cliquerBoutonLogout();
    }

    @Then("je verifie que les liens sont presents")
    public void jeVerifieQueLesLiensSontPresents() {
        dashboardPage.verifierPresenceLienDashboard();
        dashboardPage.verifierPresenceLienOrders();
        dashboardPage.verifierPresenceLienDownloads();
        dashboardPage.verifierPresenceLienAddresses();
        dashboardPage.verifierPresenceLienAccountDetails();
        dashboardPage.verifierPresenceLienLogout();
    }

    @And("je verifie que le lien Dashboard renvoie a sa page")
    public void jeVerifieQueLeLienDashboardRenvoieASaPage() {
        dashboardPage.cliquerBoutonDashboard();
        dashboardPage.verifierPresenceMessageBienvenue();
    }

    @And("je verifie que le lien Orders renvoie a sa page")
    public void jeVerifieQueLeLienOrdersRenvoieASaPage() {
        dashboardPage.cliquerBoutonOrders();
    }

    @And("je verifie que le lien Download renvoie a sa page")
    public void jeVerifieQueLeLienDownloadRenvoieASaPage() {
        dashboardPage.cliquerBoutonDownloads();
    }

    @And("je verifie que le lien Adresses renvoie a sa page")
    public void jeVerifieQueLeLienAdressesRenvoieASaPage() {
        dashboardPage.cliquerBoutonAddresses();
    }

    @And("je verifie que le lien Account Details renvoie a sa page")
    public void jeVerifieQueLeLienAccountDetailsRenvoieASaPage() {
        dashboardPage.cliquerBoutonAccountDetails();
    }

    @And("je verifie que le lien Logout renvoie a sa page")
    public void jeVerifieQueLeLienLogoutRenvoieASaPage() {
        dashboardPage.cliquerBoutonLogout();
        myAccountPage.verifierPresencePaveRegister();
    }

    @When("je accede a la page Account Details")
    public void jeAccedeALaPageAccountDetails() {
        dashboardPage.cliquerBoutonAccountDetails();
    }

    @Then("je verifie que le {string} se affiche")
    public void jeVerifieQueLeSeAffiche(String message) {
        dashboardPage.verifierPresenceMessage(message);
    }
}
