package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    static final int TEMPS_ATTENTE = 5;

    WebDriver driver;

    /**
     * Définition des Sélecteurs
     */
    By titreYourOrderBy = By.cssSelector("#order_review_heading");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifierPresenceTitreYourOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(titreYourOrderBy));
        String titreYourOrder = driver.findElement(titreYourOrderBy).getText();
        Assert.assertTrue("Le titre Your Order n'apparait pas", titreYourOrder.contains("order"));
    }

}
