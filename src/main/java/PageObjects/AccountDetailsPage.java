package PageObjects;

import Stepdefs.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountDetailsPage {

    static final int TEMPS_ATTENTE = 5;

    WebDriver driver;

    /**
     * Définition des Sélecteurs
     */
    By champPrenomBy = By.cssSelector("#account_first_name");
    By champNomBy = By.cssSelector("#account_last_name");
    By champLoginBy = By.cssSelector("#account_email");
    By champMotDePasseBy = By.cssSelector("#password_current");
    By champNouveauMotDePasseBy = By.cssSelector("#password_1");
    By champConfirmationMotDePasseBy = By.cssSelector("#password_2");
    By boutonSaveChangesBy = By.cssSelector("[name='save_account_details']");

    /**
     * Constructeur
     * @param driver pilote
     */
    public AccountDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Vérifier si le prénom est saisi dans le champs Prenom de la page Account Details
     * @param prenomAttendu prénom de l'utilisateur
     */
    public void verifierPrenomSaisi(String prenomAttendu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champPrenomBy));
        String prenomActuel = driver.findElement(champPrenomBy).getAttribute("value");
        Assert.assertEquals("Le prénom '" + prenomAttendu + "' n'est pas saisi dans le champ", prenomAttendu, prenomActuel);
    }

    /**
     * Vérifier si le nom est saisi dans le champs Nom de la page Account Details
     * @param nomAttendu nom de l'utilisateur
     */
    public void verifierNomSaisi(String nomAttendu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champNomBy));
        String nomActuel = driver.findElement(champNomBy).getAttribute("value");
        Assert.assertEquals("Le nom '" + nomAttendu + "' n'est pas saisi dans le champ", nomAttendu, nomActuel);
    }

    /**
     * Vérifier si le login est saisi dans le champs Login de la page Account Details
     * @param loginAttendu login du compte
     */
    public void verifierLoginSaisi(String loginAttendu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champLoginBy));
        String loginActuel = driver.findElement(champLoginBy).getAttribute("value");
        Assert.assertEquals("Le login '" + loginAttendu + "' n'est pas saisi dans le champ", loginAttendu, loginActuel);
    }

    /**
     * Saisir l'actuel mot de passe dans le champ Current Password de la pasge Account Details
     * @param motDePasse actuel mot de passe du compte
     */
    public void entrerMotDePasse(String motDePasse) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champMotDePasseBy));
        driver.findElement(champMotDePasseBy).sendKeys(motDePasse);
    }

    /**
     * Saisir le nouveau mot de passe dans le champ New Password de la page Account Details
     * @param motDePasse nouveau mot de passe du compte
     */
    public void entrerNouveauMotDePasse(String motDePasse) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champNouveauMotDePasseBy));
        driver.findElement(champNouveauMotDePasseBy).sendKeys(motDePasse);
    }

    /**
     * Sasir la confirmation du nouveau mot de passe dans le champs Confirmation Password de la page Account Details
     * @param motDePasse nouveau mot de passe
     */
    public void entrerConfirmationMotDePasse(String motDePasse) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champConfirmationMotDePasseBy));
        driver.findElement(champConfirmationMotDePasseBy).sendKeys(motDePasse);
    }

    /**
     * Cliquer sur le bouton Save Changes pour enregistrer les modification des informations du compte
     */
    public void cliquerBoutonSaveChanges() {
        Hooks.dezoomer(5);
        Hooks.scroll();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonSaveChangesBy));
        driver.findElement(boutonSaveChangesBy).click();
        Hooks.zoomer(5);
    }

    /**
     * Vérifier que le mot de passe actuel est saisi dans le champ Current Password de la page Account Details
     * @param motDePasseAttendu actuel mot de passe du compte
     */
    public void verifierMotDePasseSaisi(String motDePasseAttendu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champMotDePasseBy));
        String motDePasseActuel = driver.findElement(champMotDePasseBy).getAttribute("value");
        Assert.assertEquals("Le mot de passe n'est pas saisi dans le champ", motDePasseAttendu, motDePasseActuel);
    }

    /**
     * Vérifier que le nouveau mote de passe est saisi dans le champ New Password de la page Account Details
     * @param nouveauMotDePasseAttendu nouveau mot de passe du compte
     */
    public void verifierNouveauMotDePasseSaisi(String nouveauMotDePasseAttendu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champNouveauMotDePasseBy));
        String nouveauMotDePasseActuel = driver.findElement(champNouveauMotDePasseBy).getAttribute("value");
        Assert.assertEquals("Le nouveau mot de passe n'est pas saisi dans le champ", nouveauMotDePasseAttendu, nouveauMotDePasseActuel);
    }

    /**
     * Vérifier que la confirmation du mote de passe est saisi dans le champ Confirmation Password de la page Account Details
     * @param nouveauMotDePasseAttendu nouveau mot de passe du compte
     */
    public void verifierConfirmationMotDePasseSaisi(String nouveauMotDePasseAttendu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champConfirmationMotDePasseBy));
        String nouveauMotDePasseActuel = driver.findElement(champConfirmationMotDePasseBy).getAttribute("value");
        Assert.assertEquals("La confirmation du mot de passe n'est pas saisi dans le champ", nouveauMotDePasseAttendu, nouveauMotDePasseActuel);
    }

}
