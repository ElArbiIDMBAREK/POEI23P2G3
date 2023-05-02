package PageObjects;

import Stepdefs.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShopPage {

    static final int TEMPS_ATTENTE = 5;

    WebDriver driver;

    /**
     * Définition des Sélecteurs
     */
    By acrticlesBy = By.cssSelector(".products.masonry-done li");
    By prixArticleBy = By.cssSelector(".woocommerce-Price-amount");
    By boutonAddToBasketOuReadMoreBy = By.cssSelector(".button.product_type_simple");
    By lienViewBasketBy = By.cssSelector(".added_to_cart");
    By boutonFiltreBy = By.cssSelector(".orderby");

    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifierPresenceArticle(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(acrticlesBy));
        List<WebElement> articles = driver.findElements(acrticlesBy);
        Assert.assertTrue("Aucun article n'est présent", articles.get(index).isDisplayed());
    }

    public String getPrixArticle(int index) {
        List<WebElement> prixArticle = driver.findElements(prixArticleBy);
        System.out.println(prixArticle.get(0));
        prixArticle.get(9).clear();
        prixArticle.get(0).clear();
        System.out.println(prixArticle);
        return driver.findElement(prixArticleBy).getText();
    }

    public void verifierPresenceBouton(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonAddToBasketOuReadMoreBy));
        List<WebElement> boutonsAddToBasketOuReadMore = driver.findElements(boutonAddToBasketOuReadMoreBy);
        Assert.assertTrue("Le bouton " + index + " n'est pas présent", boutonsAddToBasketOuReadMore.get(index).isEnabled());
    }

    public void cliquerBoutonAddToBasketOuReadMore(int index) {
        Hooks.setTemporisation(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonAddToBasketOuReadMoreBy));
        List<WebElement> boutonsAddToBasketOuReadMore = driver.findElements(boutonAddToBasketOuReadMoreBy);
        boutonsAddToBasketOuReadMore.get(index).click();
    }

    public void cliquerLienViewBasket() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(lienViewBasketBy));
        driver.findElement(lienViewBasketBy).click();
    }

    public void choisirFiltre(String filtre) {
        WebElement boutonFiltre = driver.findElement(boutonFiltreBy);
        Select listeFiltre = new Select(boutonFiltre);
        listeFiltre.selectByVisibleText(filtre);
    }

    public boolean articleFiltre(String filtre) {
        List<WebElement> articles = driver.findElements(acrticlesBy);
        if (filtre.equals("Sort by price: low to high")) {
            for (int i = 0; i < articles.size(); i++) {

            }
        } else if (filtre.equals("Sort by price: high to low")) {

        }
        return true;
    }

}
