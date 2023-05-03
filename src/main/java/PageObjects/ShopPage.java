package PageObjects;

import Stepdefs.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ShopPage {

    static final int TEMPS_ATTENTE = 5;

    WebDriver driver;

    /**
     * Définition des Sélecteurs
     */
    By acrticlesBy = By.cssSelector(".products.masonry-done li");
    By imageArticleBy = By.cssSelector(".product img");
    By libelleArticleBy = By.cssSelector(".product a h3");
    By prixArticleBy = By.cssSelector(".woocommerce-Price-amount");
    By lienArticleBy = By.cssSelector(".woocommerce-LoopProduct-link");
    By boutonAddToBasketOuReadMoreBy = By.cssSelector(".button.product_type_simple");
    By lienViewBasketBy = By.cssSelector(".added_to_cart");
    By boutonFiltreBy = By.cssSelector(".orderby");
    By boutonPanierBy = By.cssSelector("#wpmenucartli");

    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifierPresenceArticle(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(acrticlesBy));
        List<WebElement> articles = driver.findElements(acrticlesBy);
        Assert.assertTrue("Aucun article n'est présent", articles.get(index).isDisplayed());
    }

    public void verifierPresenceImageArticle(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(imageArticleBy));
        List<WebElement> imagesArticles = driver.findElements(imageArticleBy);
        Assert.assertTrue("L'article " + index + " n'a pas d'image", imagesArticles.get(index).isDisplayed());
    }

    public void verifierPresenceLibelleArticle(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(libelleArticleBy));
        List<WebElement> libellesArticles = driver.findElements(libelleArticleBy);
        Assert.assertTrue("L'article " + index + " n'a pas de libellé", libellesArticles.get(index).isDisplayed());
    }

    public void verifierPresencePrixArticle(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(prixArticleBy));
        List<WebElement> prixArticles = driver.findElements(prixArticleBy);
        Assert.assertTrue("L'article " + index + " n'a pas de prix", prixArticles.get(index).isDisplayed());
    }

    public void verifierPresenceLienArticle(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(lienArticleBy));
        List<WebElement> liensArticles = driver.findElements(lienArticleBy);
        Assert.assertTrue("L'article " + index + " n'a pas de lien", liensArticles.get(index).isDisplayed());
    }

    public void cliquerArticle(int index) {
        Hooks.scroll();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(imageArticleBy));
        List<WebElement> articles = driver.findElements(imageArticleBy);
        articles.get(index).click();
    }

    public List<Double> getPrixArticle() {
        List<WebElement> articles = driver.findElements(prixArticleBy);
        List<Double> prixArticles = new ArrayList<>();
        for (int i = 0; i < articles.size(); i++) {
            prixArticles.add(Double.parseDouble(articles.get(i).getText().substring(1)));
        }
        prixArticles.remove(7);
        prixArticles.remove(5);
        return prixArticles;
    }

    public void verifierPresenceBouton(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonAddToBasketOuReadMoreBy));
        List<WebElement> boutonsAddToBasketOuReadMore = driver.findElements(boutonAddToBasketOuReadMoreBy);
        Assert.assertTrue("Le bouton " + index + " n'est pas présent", boutonsAddToBasketOuReadMore.get(index).isEnabled());
    }

    public void cliquerBoutonAddToBasketOuReadMore(int index) {
        Hooks.dezoomer(5);
        Hooks.scroll();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonAddToBasketOuReadMoreBy));
        List<WebElement> boutonsAddToBasketOuReadMore = driver.findElements(boutonAddToBasketOuReadMoreBy);
        boutonsAddToBasketOuReadMore.get(index).click();
        Hooks.zoomer(5);
    }

    public void verifierPresenceBoutonViewBasket() {
        Hooks.dezoomer(5);
        Hooks.scroll();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.presenceOfElementLocated(lienViewBasketBy));
        Assert.assertTrue("Le bouton View Basket n'est pas présent", driver.findElement(lienViewBasketBy).isDisplayed());
        Hooks.zoomer(5);
    }

    public void cliquerLienViewBasket() {
        Hooks.dezoomer(5);
        Hooks.scroll();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(lienViewBasketBy));
        WebElement lienViewBasket = driver.findElement(lienViewBasketBy);
        lienViewBasket.click();
        Hooks.zoomer(5);
    }

    public void choisirFiltre(String filtre) {
        WebElement boutonFiltre = driver.findElement(boutonFiltreBy);
        Select listeFiltre = new Select(boutonFiltre);
        listeFiltre.selectByVisibleText(filtre);
    }

    public void articleFiltre(String filtre) {
        List<Double> prixArticles = getPrixArticle();
        boolean etat = false;
        if (filtre.equals("Sort by price: low to high")) {
            for (int i = 0; i < prixArticles.size()-1; i++) {
                if (prixArticles.get(i) > prixArticles.get(i+1)) {
                    etat = false;
                }
            }
            etat = true;
        } else if (filtre.equals("Sort by price: high to low")) {
            for (int i = 0; i < prixArticles.size()-1; i++) {
                if (prixArticles.get(i) < prixArticles.get(i+1)) {
                    etat = false;
                }
            }
            etat = true;
        }
        Assert.assertTrue("Les articles ne sont pas : " + filtre, etat);
    }

    public void cliquerBoutonPanier() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.elementToBeClickable(boutonPanierBy));
        driver.findElement(boutonPanierBy).click();
    }

}
