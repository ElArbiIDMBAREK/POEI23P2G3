package PageObjects;

import Stepdefs.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    static final int TEMPS_ATTENTE = 5;

    WebDriver driver;

    /**
     * Définition des Sélecteurs
     */
    By boutonShopBy = By.cssSelector("#menu-item-40");
    By boutonMyAccountBy = By.cssSelector("#menu-item-50");
    By iconePanierBy = By.cssSelector(".wpmenucart-icon-shopping-cart-0");

    /**
     * Constructeur de la page d'accueil "Home Page"
     * @param driver
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Cliquer sur le bouton "Shop" afin d'accéder à la page "Shop" pour se connceter ou créer nouveau un compte
     */
    public void accederShop() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonShopBy));
        driver.findElement(boutonShopBy).click();
        Hooks.cliquer();
        //Hooks.fermerPublicationGoogle();
        Hooks.setTemporisation(2000);
    }

    /**
     * Cliquer sur le bouton "My Account" afin d'accéder à la page "My Account" pour se connceter ou créer nouveau un compte
     */
    public void accederMyAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonMyAccountBy));
        driver.findElement(boutonMyAccountBy).click();
        Hooks.cliquer();
        //Hooks.fermerPublicationGoogle();
    }

    public void verifierPresenceIconePanier() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(iconePanierBy));
        Assert.assertTrue("L'icone Panier n'est pas présente", driver.findElement(iconePanierBy).isDisplayed());
    }

}
