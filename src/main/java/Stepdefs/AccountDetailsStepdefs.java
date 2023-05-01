package Stepdefs;

import PageObjects.AccountDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class AccountDetailsStepdefs {

    WebDriver driver = Hooks.driver;

    AccountDetailsPage accountDetailsPage = new AccountDetailsPage(driver);

    @Then("je verifie que le {string} est saisi dans le champ Account Details Prenom")
    public void jeVerifieQueLeEstSaisiDansLeChampAccountDetailsPrenom(String prenom) {
        accountDetailsPage.verifierPrenomSaisi(prenom);
    }

    @And("je verifie que le {string} est saisi dans le champ Account Details Nom")
    public void jeVerifieQueLeEstSaisiDansLeChampAccountDetailsNom(String nom) {
        accountDetailsPage.verifierNomSaisi(nom);
    }

    @And("je verifie que le {string} est saisi dans le champ Account Details Login")
    public void jeVerifieQueLeEstSaisiDansLeChampAccountDetailsLogin(String login) {
        accountDetailsPage.verifierLoginSaisi(login);
    }

    @And("je saisi un {string} dans le champ Account Details Current Password")
    public void jeSaisiUnDansLeChampAccountDetailsCurrentPassword(String motDePasse) {
        accountDetailsPage.entrerMotDePasse(motDePasse);
    }

    @And("je saisi un {string} dans le champ Account Details New Password")
    public void jeSaisiUnDansLeChampAccountDetailsNewPassword(String nouveauMotDePasse) {
        accountDetailsPage.entrerNouveauMotDePasse(nouveauMotDePasse);
    }

    @And("je saisi un {string} dans le champ Account Details Confirm New Password")
    public void jeSaisiUnDansLeChampAccountDetailsConfirmNewPassword(String nouveauMotDePasse) {
        accountDetailsPage.entrerConfirmationMotDePasse(nouveauMotDePasse);
    }

    @Then("je verifie que le {string} est saisi dans le champ Account Details Current Password")
    public void jeVerifieQueLeEstSaisiDansLeChampAccountDetailsCurrentPassword(String motDePasse) {
        accountDetailsPage.verifierMotDePasseSaisi(motDePasse);
    }

    @And("je verifie que le {string} est saisi dans le champ Account Details New Password")
    public void jeVerifieQueLeEstSaisiDansLeChampAccountDetailsNewPassword(String nouveauMotDePasse) {
        accountDetailsPage.verifierNouveauMotDePasseSaisi(nouveauMotDePasse);
    }

    @And("je verifie que le {string} est saisi dans le champ Account Details Confirm New Password")
    public void jeVerifieQueLeEstSaisiDansLeChampAccountDetailsConfirmNewPassword(String nouveauMotDePasse) {
        accountDetailsPage.verifierConfirmationMotDePasseSaisi(nouveauMotDePasse);
    }

    @And("je clique sur le bouton SAVE CHANGES")
    public void jeCliqueSurLeBoutonSAVECHANGES() {
        accountDetailsPage.cliquerBoutonSaveChanges();
    }
}
