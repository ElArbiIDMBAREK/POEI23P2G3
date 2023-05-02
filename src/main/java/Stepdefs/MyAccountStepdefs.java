package Stepdefs;

import PageObjects.DashboardPage;
import PageObjects.HomePage;
import PageObjects.MyAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MyAccountStepdefs {

    WebDriver driver = Hooks.driver;

    HomePage homePage = new HomePage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);

    @Given("je suis sur le espace My Account")
    public void jeSuisSurLeEspaceMyAccount() {
        Hooks.accederHome();
        homePage.accederMyAccount();
        //homePage.fermerPublicationGoogle();
    }

    @Then("je verifie que le pave Register est present")
    public void jeVerifieQueLePaveRegisterEstPresent() {
        homePage.accederMyAccount();
        //homePage.fermerPublicationGoogle();
        myAccountPage.verifierPresencePaveRegister();
    }

    @When("je saisis un {string} dans le champ Register Nom")
    public void jeSaisisUnDansLeChampRegisterNom(String nom) {
        homePage.accederMyAccount();
        Assert.assertTrue("Le champ 'Nom' n'existe pas !",false);
    }

    @And("je saisis un {string} dans le champ Register Prenom")
    public void jeSaisisUnDansLeChampRegisterPrenom(String prenom) {
        homePage.accederMyAccount();
        Assert.assertTrue("Le champ 'Prénom' n'existe pas !",false);
    }

    @And("je saisis un {string} dans le champ Register Mail")
    public void jeSaisisUnDansLeChampRegisterMail(String mail) {
        myAccountPage.entrerMailRegister(mail);
    }

    @And("je saisis un {string} dans le champ Register Mot De Passe")
    public void jeSaisisUnDansLeChampMotRegisterDePasse(String motDePasse) {
        myAccountPage.entrerMotDePasseRegister(motDePasse);
    }

    @Then("je verifie que le {string} est saisi dans le champ Register Nom")
    public void jeVerifieQueLeEstSaisiDansLeChampRegisterNom(String nom) {
        Assert.assertTrue("Le champ 'Nom' n'existe pas !",false);
    }

    @And("je verifie que le {string} est saisi dans le champ Register Prenom")
    public void jeVerifieQueLeEstSaisiDansLeChampRegisterPrenom(String prenom) {
        Assert.assertTrue("Le champ 'Prénom' n'existe pas !",false);
    }

    @And("je verifie que le {string} est saisi dans le champ Register Mail")
    public void jeVerifieQueLeEstSaisiDansLeChampRegisterMail(String mail) {
        myAccountPage.verifierMailRegisterSaisi(mail);
    }

    @And("je verifie que le {string} est saisi dans le champ Register Mot De Passe")
    public void jeVerifieQueLeEstSaisiDansLeChampRegisterMotDePasse(String motDePasse) {
        myAccountPage.verifierMotDePasseRegisterSaisi(motDePasse);
    }

    @Then("je verifie que le bouton REGISTER est present")
    public void jeVerifieQueLeBoutonREGISTEREstPresent() {
        myAccountPage.verifierPresenceBoutonRegister();
    }

    @And("je clique sur le bouton REGISTER")
    public void jeCliqueSurLeBoutonREGISTER() {
        myAccountPage.cliquerBoutonRegister();
    }

    @Then("je verifie que la creation du compte a echouee")
    public void jeVerifieQueLaCreationDuCompteAEchouee() {
        myAccountPage.verifierMotDePasseNonConforme();
    }

    @Then("je verifie que le compte ne pas ete cree")
    public void jeVerifieQueLeCompteNePasEteCree() {
        myAccountPage.verifierPresencePaveRegister();
    }

    @And("je verifie que le {string} de erreur se affiche")
    public void jeVerifieQueLeDeErreurSeAffiche(String message) {
        myAccountPage.verifierPresenceMessageErreur(message);
    }

    @Then("je verifie que je suis sur le espace My Account")
    public void jeVerifieQueJeSuisSurLeEspaceMyAccount() {
        myAccountPage.verifierPresencePaveRegister();
    }

    @When("je saisis un {string} dans le champ Login")
    public void jeSaisisUnDansLeChampLogin(String login) {
        myAccountPage.entrerMailLogin(login);
    }

    @And("je saisis un {string} dans le champ Login Mot De Passe")
    public void jeSaisisUnDansLeChampLoginMotDePasse(String motDePasse) {
        myAccountPage.entrerMotDePasseLogin(motDePasse);
    }

    @And("je clique sur le bouton LOGIN")
    public void jeCliqueSurLeBoutonLOGIN() {
        myAccountPage.cliquerBoutonLogin();
    }

    @When("je me connecte avec le {string} et le {string}")
    public void jeMeConnecteAvecLeEtLe(String login, String motDePasse) {
        myAccountPage.entrerMailLogin(login);
        myAccountPage.entrerMotDePasseLogin(motDePasse);
        myAccountPage.cliquerBoutonLogin();
    }

    @When("je coche la case Remember Me")
    public void jeCocheLaCaseRememberMe() {
        myAccountPage.cocherCaseRememberMe();
    }

    @Then("je verifie que le {string} est saisi")
    public void jeVerifieQueLeEstSaisi(String login) {
        myAccountPage.verifierMailLoginSaisi(login);
    }
}
