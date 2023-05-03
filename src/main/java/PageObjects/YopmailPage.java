package PageObjects;

import Stepdefs.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopmailPage {

    static final int TEMPS_ATTENTE = 5;

    WebDriver yopmailDriver;


    /**
     * Définition des Sélecteurs
     */
    By cacheBoiteMailBy = By.cssSelector("#necesary");
    By champloginYopmailBy = By.cssSelector("input#login.ycptinput");
    By boutonCheckInboxBy = By.cssSelector("i.material-icons-outlined.f36");
    By mailRecuBy = By.cssSelector("[dir='ltr']");

    public void verifierMailRecu(String email) {
        yopmailDriver = new ChromeDriver();
        yopmailDriver.get("https://www.yopmail.fr");
        yopmailDriver.manage().window().maximize();
        yopmailDriver.findElement(cacheBoiteMailBy).click();
        yopmailDriver.findElement(champloginYopmailBy).sendKeys(email);
        yopmailDriver.findElement(boutonCheckInboxBy).click();
        WebDriverWait wait = new WebDriverWait(yopmailDriver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(mailRecuBy));
        String nomExpediteur = yopmailDriver.findElement(mailRecuBy).getText();
        Assert.assertTrue("Le mail de changement de mot de passe n'est pas recu", nomExpediteur.contains("test"));
    }

}
