package PageObjects;

import Stepdefs.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    static final int TEMPS_ATTENTE = 5;

    WebDriver driver;

    /**
     * Définition des Sélecteurs
     */
    By imageArticleBy = By.cssSelector(".product img");
    By prixArticleBy = By.cssSelector(".woocommerce-Price-amount");
    By descriptionArticleBy = By.cssSelector("#tab-description h2");
    By stockArticleBy = By.cssSelector(".stock");
    By boutonAddToCartBy = By.cssSelector(".single_add_to_cart_button");
    By messageAjoutBy = By.cssSelector(".woocommerce-message");
    By boutonViewBasketBy = By.cssSelector(".button.wc-forward");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifierPresenceImageArticle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(imageArticleBy));
        Assert.assertTrue("L'article n'a pas d'image", driver.findElement(imageArticleBy).isDisplayed());
    }

    public void verifierPresencePrixArticle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(prixArticleBy));
        Assert.assertTrue("L'article n'a pas de prix", driver.findElement(prixArticleBy).isDisplayed());
    }

    public void verifierPresenceDescriptionArticle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(descriptionArticleBy));
        Assert.assertTrue("L'article n'a pas de prix", driver.findElement(descriptionArticleBy).isDisplayed());
    }

    public void verifierPresenceQuantiteArticle() {
        Assert.assertTrue("L'article n'a pas de quantité", driver.findElement(stockArticleBy).isDisplayed());
    }

    public void cliquerBoutonAddToBasket() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonAddToCartBy));
        driver.findElement(boutonAddToCartBy).click();
    }

    public void verifierPresenceMessageAjoutArticle(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(messageAjoutBy));
        String messageAjout = driver.findElement(messageAjoutBy).getText();
        System.out.println("message : " + messageAjout);
        Assert.assertTrue("Aucun article n'est ajouter", messageAjout.contains(message));
    }

    public void verifierPresenceBoutonViewBasket() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(boutonViewBasketBy));
        Assert.assertTrue("Le bouton View Basket n'est pas présent", driver.findElement(boutonViewBasketBy).isDisplayed());
    }

}
