package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    static final int TEMPS_ATTENTE = 5;

    WebDriver driver;

    /**
     * Définition des Sélecteurs
     */
    By messageHelloBy = By.cssSelector(".woocommerce-MyAccount-content p");
    By boutonDashbordBy = By.cssSelector(".woocommerce-MyAccount-navigation-link--dashboard a");
    By boutonOrdersBy = By.cssSelector(".woocommerce-MyAccount-navigation-link--orders a");
    By boutonDownloadsdBy = By.cssSelector(".woocommerce-MyAccount-navigation-link--downloads a");
    By boutonAddressesBy = By.cssSelector(".woocommerce-MyAccount-navigation-link--edit-address a");
    By boutonAccountDetailsBy = By.cssSelector(".woocommerce-MyAccount-navigation-link--edit-account a");
    By boutonLogoutBy = By.cssSelector(".woocommerce-MyAccount-navigation-link--customer-logout a");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifierPresenceMessageBienvenue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(messageHelloBy));
        String messageHello = driver.findElement(messageHelloBy).getText();
        Assert.assertTrue("Le message de bienvenue n'apparait pas", messageHello.contains("Hello"));
    }

    public void cliquerBoutonDashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonDashbordBy));
        driver.findElement(boutonDashbordBy).click();
    }

    public void cliquerBoutonOrders() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonOrdersBy));
        driver.findElement(boutonOrdersBy).click();
    }

    public void cliquerBoutonDownloads() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonDownloadsdBy));
        driver.findElement(boutonDownloadsdBy).click();
    }

    public void cliquerBoutonAddresses() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonAddressesBy));
        driver.findElement(boutonAddressesBy).click();
    }

    public void cliquerBoutonAccountDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonAccountDetailsBy));
        driver.findElement(boutonAccountDetailsBy).click();
    }

    public void cliquerBoutonLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonLogoutBy));
        driver.findElement(boutonLogoutBy).click();
    }

    public void verifierPresenceLienDashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonDashbordBy));
        Assert.assertTrue("Le lien Dashboard n'existe pas", driver.findElement(boutonDashbordBy).isDisplayed());
    }

    public void verifierPresenceLienOrders() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonOrdersBy));
        Assert.assertTrue("Le lien Dashboard n'existe pas", driver.findElement(boutonOrdersBy).isDisplayed());
    }

    public void verifierPresenceLienDownloads() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonDownloadsdBy));
        Assert.assertTrue("Le lien Dashboard n'existe pas", driver.findElement(boutonDownloadsdBy).isDisplayed());
    }

    public void verifierPresenceLienAddresses() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonAddressesBy));
        Assert.assertTrue("Le lien Dashboard n'existe pas", driver.findElement(boutonAddressesBy).isDisplayed());
    }

    public void verifierPresenceLienAccountDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonAccountDetailsBy));
        Assert.assertTrue("Le lien Dashboard n'existe pas", driver.findElement(boutonAccountDetailsBy).isDisplayed());
    }

    public void verifierPresenceLienLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonLogoutBy));
        Assert.assertTrue("Le lien Dashboard n'existe pas", driver.findElement(boutonLogoutBy).isDisplayed());
    }

}
