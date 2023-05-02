package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
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

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifierPresenceTitreBasket() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(titreBasketBy));
        String titreBasket = driver.findElement(titreBasketBy).getText();
        Assert.assertTrue("Le titre Basket n'apparait pas", titreBasket.contains("Basket"));
    }

}
