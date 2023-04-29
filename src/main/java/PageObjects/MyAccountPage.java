package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage {

    static final int TIMEOUT_SIDE_PANEL = 5;

    static final String messageErreurMotDePasseNonConforme
            =   "The password should be at least seven characters long. To make it stronger, " +
                "use upper and lower case letters, numbers and symbols like ! \" ? $ % ^ & ).";

    WebDriver driver;

    By paveRegisterBy = By.cssSelector(".register");
    By champMailResgisterBy = By.cssSelector("#reg_email");
    By champMotDePasseResgisterBy = By.cssSelector("#reg_password");
    By boutonRegisterBy = By.cssSelector("[name='register']");
    By messageErreurMotDePasseNonConformeBy = By.cssSelector(".woocommerce-password-hint");
    By messageHelloBy = By.cssSelector(".woocommerce-MyAccount-content p");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifierPresencePaveRigiterMyAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        wait.until(ExpectedConditions.presenceOfElementLocated(paveRegisterBy));
        Assert.assertTrue("Le pavé 'Regsiter' n'est pas présent sur la page 'My Account'", driver.findElement(paveRegisterBy).isDisplayed());
    }

    public void entrerMailRegister(String mail) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        wait.until(ExpectedConditions.presenceOfElementLocated(champMailResgisterBy));
        driver.findElement(champMailResgisterBy).sendKeys(mail);
    }

    public void entrerMotDePasseRegister(String motDePasse) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        wait.until(ExpectedConditions.elementToBeClickable(boutonRegisterBy));
        Assert.assertTrue("Le bouton Register n'existe pas", driver.findElement(boutonRegisterBy).isDisplayed());
    }

    public void cliquerBoutonRegister() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        wait.until(ExpectedConditions.elementToBeClickable(boutonRegisterBy));
        driver.findElement(boutonRegisterBy).click();
    }

    public void verifierMotDePasseNonConforme() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        wait.until(ExpectedConditions.presenceOfElementLocated(messageHelloBy));
        String messageHello = driver.findElement(messageHelloBy).getText();
        Assert.assertFalse("Le systeme valide la création des comptes avec des mots de passe non conforme", messageHello.contains("Hello"));
    }

    public void verifierMotDePasseConforme(String motDePasse) {
        String critereMotDePasse = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,32}$";
        Assert.assertTrue("Le mot de passe '" + motDePasse + "' n'est pas conforme", critereMotDePasse.matches(motDePasse));
    }

    public void verifierCompteCree() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        wait.until(ExpectedConditions.presenceOfElementLocated(messageHelloBy));
        String messageHello = driver.findElement(messageHelloBy).getText();
        Assert.assertTrue("Le compte n'a pas été créé", messageHello.contains("Hello"));
    }

    public void setTemporisation(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}