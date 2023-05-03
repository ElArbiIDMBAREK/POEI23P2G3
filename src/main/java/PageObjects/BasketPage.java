package PageObjects;

import Stepdefs.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasketPage {

    static final int TEMPS_ATTENTE = 5;

    WebDriver driver;

    /**
     * Définition des Sélecteurs
     */
    By titreBasketBy = By.cssSelector(".cart_totals h2");
    By articlePanierBy = By.cssSelector(".cart_item");
    By boutonSupprimerArticleBy = By.cssSelector(".product-remove a");
    By prixUnitaireArticleBy = By.cssSelector(".product-price span");
    By quantiteArticleBy = By.cssSelector(".quantity");
    By champQuantiteBy = By.cssSelector(".quantity input");
    By prixTotalArticleBy = By.cssSelector(".product-subtotal span");
    By boutonUpdateBasket = By.cssSelector("[name='update_cart']");
    By messageSuppressionBy = By.cssSelector(".woocommerce-message");
    By boutonProceedCheckoutBy = By.cssSelector(".checkout-button");

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifierPresenceTitreBasket() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(titreBasketBy));
        String titreBasket = driver.findElement(titreBasketBy).getText();
        Assert.assertTrue("Le titre Basket n'apparait pas", titreBasket.contains("Basket"));
    }

    public void verifierPresenceArticlePanier() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(articlePanierBy));
        Assert.assertTrue("Aucun article n'est présent", driver.findElement(articlePanierBy).isDisplayed());
    }

    public void verifierAbsenceArticlePanier() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(messageSuppressionBy));
        String messageSuppression = driver.findElement(messageSuppressionBy).getText();
        Assert.assertTrue("Au moins, un article est présent", messageSuppression.contains("removed"));
    }

    public void cliquerBoutonSupprimerArticle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonSupprimerArticleBy));
        driver.findElement(boutonSupprimerArticleBy).click();
    }

    public void verifierPresencePrixUnitaireArticle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(prixUnitaireArticleBy));
        Assert.assertTrue("L'article n'a pas de prix unitaire", driver.findElement(prixUnitaireArticleBy).isDisplayed());
    }

    public void verifierPresenceQuantiteArticle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(quantiteArticleBy));
        Assert.assertTrue("Aucune quantité n'est présente", driver.findElement(quantiteArticleBy).isDisplayed());
    }

    public void changerQuantiteArticle(String quantite) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champQuantiteBy));
        driver.findElement(champQuantiteBy).sendKeys(Keys.DELETE + quantite);
        driver.findElement(boutonUpdateBasket).click();
        Hooks.setTemporisation(5000);
    }

    public void verifierQuantiteArticle(String quantiteAttendu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(champQuantiteBy));
        String quantiteActuel = driver.findElement(champQuantiteBy).getAttribute("value");
        Assert.assertTrue("La quantité n'est pas " + quantiteAttendu + ", elle est " + quantiteActuel, quantiteAttendu.equals(quantiteActuel));
    }

    public void verifierPresencePrixTotalArticle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(prixTotalArticleBy));
        Assert.assertTrue("L'article n'a pas de prix total", driver.findElement(prixTotalArticleBy).isDisplayed());
    }

    public void cliquerBoutonProceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonProceedCheckoutBy));
        driver.findElement(boutonProceedCheckoutBy).click();
    }

}
