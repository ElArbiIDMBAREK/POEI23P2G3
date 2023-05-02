package PageObjects;

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
    By quantiteArticleBy = By.cssSelector(".quantity");
    By stockArticleBy = By.cssSelector(".stock");


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
        if (driver.findElement(quantiteArticleBy).isDisplayed()) {
            //Assert.assertTrue("L'article n'a pas de quantité", driver.findElement(descriptionArticleBy).isDisplayed());
        } else if (driver.findElement(stockArticleBy).isDisplayed()) {
            Assert.assertTrue("L'article n'a pas de quantité", driver.findElement(stockArticleBy).isDisplayed());
        }
    }

}
