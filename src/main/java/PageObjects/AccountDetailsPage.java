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

    public AccountDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifierPrenomSaisi(String prenomAttendu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champPrenomBy));
        String prenomActuel = driver.findElement(champPrenomBy).getAttribute("value");
        Assert.assertEquals("Le prénom '" + prenomAttendu + "' n'est pas saisi dans le champ", prenomAttendu, prenomActuel);
    }

    public void verifierNomSaisi(String nomAttendu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champNomBy));
        String nomActuel = driver.findElement(champNomBy).getAttribute("value");
        Assert.assertEquals("Le nom '" + nomAttendu + "' n'est pas saisi dans le champ", nomAttendu, nomActuel);
    }

    public void verifierLoginSaisi(String loginAttendu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champLoginBy));
        String loginActuel = driver.findElement(champLoginBy).getAttribute("value");
        Assert.assertEquals("Le login '" + loginAttendu + "' n'est pas saisi dans le champ", loginAttendu, loginActuel);
    }

    public void entrerMotDePasse(String motDePasse) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champMotDePasseBy));
        driver.findElement(champMotDePasseBy).sendKeys(motDePasse);
    }

    public void entrerNouveauMotDePasse(String motDePasse) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champNouveauMotDePasseBy));
        driver.findElement(champNouveauMotDePasseBy).sendKeys(motDePasse);
    }

    public void entrerConfirmationMotDePasse(String motDePasse) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champConfirmationMotDePasseBy));
        driver.findElement(champConfirmationMotDePasseBy).sendKeys(motDePasse);
    }

    public void cliquerBoutonSaveChanges() {
        Hooks.cliquer();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        //wait.until(ExpectedConditions.elementToBeClickable(boutonSaveChangesBy));
        driver.findElement(boutonSaveChangesBy).click();
    }

    public void verifierMotDePasseSaisi(String motDePasseAttendu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champMotDePasseBy));
        String motDePasseActuel = driver.findElement(champMotDePasseBy).getAttribute("value");
        Assert.assertEquals("Le mot de passe n'est pas saisi dans le champ", motDePasseAttendu, motDePasseActuel);
    }

    public void verifierNouveauMotDePasseSaisi(String nouveauMotDePasseAttendu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champNouveauMotDePasseBy));
        String nouveauMotDePasseActuel = driver.findElement(champNouveauMotDePasseBy).getAttribute("value");
        Assert.assertEquals("Le nouveau mot de passe n'est pas saisi dans le champ", nouveauMotDePasseAttendu, nouveauMotDePasseActuel);
    }

    public void verifierConfirmationMotDePasseSaisi(String nouveauMotDePasseAttendu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champConfirmationMotDePasseBy));
        String nouveauMotDePasseActuel = driver.findElement(champConfirmationMotDePasseBy).getAttribute("value");
        Assert.assertEquals("La confirmation du mot de passe n'est pas saisi dans le champ", nouveauMotDePasseAttendu, nouveauMotDePasseActuel);
    }

}
