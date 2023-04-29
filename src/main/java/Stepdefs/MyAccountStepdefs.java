package Stepdefs;

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

    Hooks hooks = new Hooks();
    HomePage homePage = new HomePage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);

    @Given("je suis sur le espace My Account")
    public void jeSuisSurLeEspaceMyAccount() {
        hooks.accederSite();
        homePage.accederMyAccount();
        homePage.fermerPublicationGoogle();
    }

    @Then("je verifie que le pave Register est present sur le espace My Account")
    public void jeVerifieQueLePaveRegisterEstPresentSurLeEspaceMyAccount() {
        homePage.accederMyAccount();
        homePage.fermerPublicationGoogle();
        myAccountPage.verifierPresencePaveRegister();
    }

    @When("je saisis un {string} dans le champ Nom")
    public void jeSaisisUnDansLeChampNom(String nom) {
        Assert.assertTrue("Le champ 'Nom' n'existe pas !",false);
    }

    @And("je saisis un {string} dans le champ Prenom")
    public void jeSaisisUnDansLeChampPrenom(String prenom) {
        Assert.assertTrue("Le champ 'Prénom' n'existe pas !",false);
    }

    @And("je saisis un {string} dans le champ Mail")
    public void jeSaisisUnDansLeChampMail(String mail) {
        myAccountPage.entrerMailRegister(mail);
    }

    @And("je saisis un {string} dans le champ Mot De Passe")
    public void jeSaisisUnDansLeChampMotDePasse(String motDePasse) {
        myAccountPage.entrerMotDePasseRegister(motDePasse);
    }

    @Then("je verifie que le {string} est saisi dans le champ Nom")
    public void jeVerifieQueLeEstSaisiDansLeChampNom(String nom) {
        Assert.assertTrue("Le champ 'Nom' n'existe pas !",false);
    }

    @And("je verifie que le {string} est saisi dans le champ Prenom")
    public void jeVerifieQueLeEstSaisiDansLeChampPrenom(String prenom) {
        Assert.assertTrue("Le champ 'Prénom' n'existe pas !",false);
    }

    @And("je verifie que le {string} est saisi dans le champ Mail")
    public void jeVerifieQueLeEstSaisiDansLeChampMail(String mail) {
        myAccountPage.verifierMailRegisterSaisi(mail);
    }

    @And("je verifie que le {string} est saisi dans le champ Mot De Passe")
    public void jeVerifieQueLeEstSaisiDansLeChampMotDePasse(String motDePasse) {
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

    @Then("je verifie que le compte est cree")
    public void jeVerifieQueLeCompteEstCree() {
        myAccountPage.verifierCompteCree();
    }

    @And("je me deconnecte")
    public void jeMeDeconnecte() {
        myAccountPage.cliquerBoutonLogout();
    }

    @Then("je verifie que le compte ne pas ete cree")
    public void jeVerifieQueLeCompteNePasEteCree() {
        myAccountPage.verifierPresencePaveRegister();
    }

    @And("je verifie que le {string} se affiche")
    public void jeVerifieQueLeSeAffiche(String messageErreur) {
        myAccountPage.verifierPresenceMessageErreurMailDejaUtilise(messageErreur);
    }


}
