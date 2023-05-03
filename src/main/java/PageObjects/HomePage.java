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
    //By premierIFramePublicationGoogle = By.cssSelector("#google_esf");
    By deuxiemeIFramePublicationGoogle = By.cssSelector("#aswift_7");
    By troisiemeIFramePublicationGoogle = By.cssSelector("#ad_iframe");
    By boutonCloseBy =By.cssSelector("#dismiss-button");
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
     * Fermer le pop-up des publicités de Google
     */
    public void fermerPublicationGoogle() {
        Hooks.setTemporisation(1000);
        //driver.switchTo().frame(driver.findElement(premierIFramePublicationGoogle));
        driver.switchTo().frame(driver.findElement(deuxiemeIFramePublicationGoogle));
        driver.switchTo().frame(driver.findElement(troisiemeIFramePublicationGoogle));
        driver.findElement(boutonCloseBy).click();
        driver.switchTo().defaultContent();
        Hooks.setTemporisation(1000);
    }

    /**
     * Cliquer sur le bouton "Shop" afin d'accéder à la page "Shop" pour se connceter ou créer nouveau un compte
     */
    public void accederShop() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonShopBy));
        driver.findElement(boutonShopBy).click();
        Hooks.cliquer();
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
    }

    public void verifierPresenceIconePanier() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(iconePanierBy));
        Assert.assertTrue("L'icone Panier n'est pas présente", driver.findElement(iconePanierBy).isDisplayed());
    }

}
