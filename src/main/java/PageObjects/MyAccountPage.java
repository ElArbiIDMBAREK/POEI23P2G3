package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class MyAccountPage {

    static final int TEMPS_ATTENTE = 5;

    static final String messageErreurMotDePasseNonConforme
            =   "The password should be at least seven characters long. To make it stronger, " +
                "use upper and lower case letters, numbers and symbols like ! \" ? $ % ^ & ).";

    WebDriver driver;

    /**
     * Définition des Sélecteurs
     */
    By paveRegisterBy = By.cssSelector(".register");
    By champMailResgisterBy = By.cssSelector("#reg_email");
    By champMotDePasseResgisterBy = By.cssSelector("#reg_password");
    By boutonRegisterBy = By.cssSelector("[name='register']");
    By messageErreurMotDePasseNonConformeBy = By.cssSelector(".woocommerce-password-hint");
    By messageHelloBy = By.cssSelector(".woocommerce-MyAccount-content p");
    By boutonLogoutBy = By.cssSelector(".woocommerce-MyAccount-navigation-link--customer-logout a");
    By messageErreurMailDejaUtiliseBy = By.cssSelector(".woocommerce-error li");

    /**
     * Constructeur de la page d'accueil "Home Page"
     * @param driver
     */
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Cliquer quelque part sur la page pour corriger quelques défauts du site
     * Quelques pages du site désactivent quelques boutons
     */
    public void cliquer() {
        Actions actions = new Actions(driver);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.mouseMove(50,50);
        actions.click().build().perform();
    }

    /**
     * Vérifier la présence du pavé "Register"
     */
    public void verifierPresencePaveRegister() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));                                      // Définition d'un "Wait"
        wait.until(ExpectedConditions.presenceOfElementLocated(paveRegisterBy));                                                // Attendre que le pavé "Register" soit présent
        Assert.assertTrue("Le pavé 'Regsiter' n'est pas présent", driver.findElement(paveRegisterBy).isDisplayed());    // Vérifier si le pavé "Register" est présent
    }

    public void entrerMailRegister(String mail) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champMailResgisterBy));
        driver.findElement(champMailResgisterBy).sendKeys(mail);
    }

    public void entrerMotDePasseRegister(String motDePasse) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champMotDePasseResgisterBy));
        driver.findElement(champMotDePasseResgisterBy).sendKeys(motDePasse);
    }

    public void verifierMailRegisterSaisi(String mailAttendu) {
        String mailActuel = driver.findElement(champMailResgisterBy).getAttribute("value");
        Assert.assertEquals("Le mail '" + mailAttendu + "' n'est pas saisi dans le champ", mailAttendu, mailActuel);
    }

    public void verifierMotDePasseRegisterSaisi(String motDePasseAttendu) {
        String motDePasseActuel = driver.findElement(champMotDePasseResgisterBy).getAttribute("value");
        Assert.assertEquals("Le mot de passe '" + motDePasseAttendu + "' n'est pas saisi dans le champ", motDePasseAttendu, motDePasseActuel);
    }

    public void verifierPresenceBoutonRegister() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonRegisterBy));
        Assert.assertTrue("Le bouton Register n'existe pas", driver.findElement(boutonRegisterBy).isDisplayed());
    }

    public void cliquerBoutonRegister() {
        cliquer();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonRegisterBy));
        driver.findElement(boutonRegisterBy).click();
    }

    public void verifierMotDePasseNonConforme() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(messageHelloBy));
        String messageHello = driver.findElement(messageHelloBy).getText();
        Assert.assertFalse("Le systeme valide la création des comptes avec des mots de passe non conforme", messageHello.contains("Hello"));
    }

    public void verifierMotDePasseConforme(String motDePasse) {
        String critereMotDePasse = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,32}$";
        Assert.assertTrue("Le mot de passe '" + motDePasse + "' n'est pas conforme", critereMotDePasse.matches(motDePasse));
    }

    public void verifierCompteCree() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(messageHelloBy));
        String messageHello = driver.findElement(messageHelloBy).getText();
        Assert.assertTrue("Le compte n'a pas été créé", messageHello.contains("Hello"));
    }

    public void cliquerBoutonLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonLogoutBy));
        driver.findElement(boutonLogoutBy).click();
    }

    public void verifierPresenceMessageErreurMailDejaUtilise(String messageErreurAttendu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(messageErreurMailDejaUtiliseBy));
        String messageErreurActuel = driver.findElement(messageErreurMailDejaUtiliseBy).getText();
        Assert.assertEquals("Le message d'erreur n'existe pas. Le système crée des comtes avec des mails en doublon", messageErreurAttendu, messageErreurActuel);

    }

    public void setTemporisation(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}