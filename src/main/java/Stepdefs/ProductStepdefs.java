package Stepdefs;

import PageObjects.ProductPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class ProductStepdefs {

    WebDriver driver = Hooks.driver;

    ProductPage productPage = new ProductPage(driver);

    @Then("je verifie que le article a une image")
    public void jeVerifieQueLeArticleAUneImage() {
        productPage.verifierPresenceImageArticle();
    }

    @And("je verifie que le article a une prix")
    public void jeVerifieQueLeArticleAUnePrix() {
        productPage.verifierPresencePrixArticle();
    }

    @And("je verifie que le article a un detail")
    public void jeVerifieQueLeArticleAUnDetail() {
        productPage.verifierPresenceDescriptionArticle();
    }

    @And("je verifie que le article a le nombre de exemplaire disponible")
    public void jeVerifieQueLeArticleALeNombreDeExemplaireDisponible() {
        productPage.verifierPresenceQuantiteArticle();
    }

    @And("je clique sur le bouton ADD TO BASKET dans article")
    public void jeCliqueSurLeBoutonADDTOBASKETDansArticle() {
        productPage.cliquerBoutonAddToBasket();
    }

    @Then("je verifie que le {string} se affiche dans article")
    public void jeVerifieQueLeSeAfficheDansArticle(String message) {
        productPage.verifierPresenceMessageAjoutArticle(message);
    }

    @And("je verifie que le bouton View Basket est present")
    public void jeVerifieQueLeBoutonViewBasketEstPresent() {
        productPage.verifierPresenceBoutonViewBasket();
    }
}
