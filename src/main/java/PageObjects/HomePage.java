package PageObjects;

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
    By iFramePublicationGoogle = By.cssSelector("#google_esf");
    By boutonCloseBy =By.cssSelector("#dismiss-button div");
    By boutonMyAccountBy = By.cssSelector("#menu-item-50");

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
        /*
        setTemporisation(1000);
        driver.switchTo().frame(driver.findElement(iFramePublicationGoogle));
        driver.findElement(boutonCloseBy).click();
        driver.switchTo().defaultContent();
        */
    }

    /**
     * Cliquer sur le bouton "My Account" afin d'accéder à la page "My Account" pour se connceter ou créer nouveau un compte
     */
    public void accederMyAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));  // Définition d'un "Wait"
        wait.until(ExpectedConditions.elementToBeClickable(boutonMyAccountBy));             // Attendre que le bouton "My Account" soit cliquable
        driver.findElement(boutonMyAccountBy).click();                                      // Cliquer sur le bouton "My Account"
    }

    public void setTemporisation(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
