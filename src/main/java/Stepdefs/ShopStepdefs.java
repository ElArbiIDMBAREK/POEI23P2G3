package Stepdefs;

import PageObjects.HomePage;
import PageObjects.ShopPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class ShopStepdefs {

    WebDriver driver = Hooks.driver;

    HomePage homePage = new HomePage(driver);
    ShopPage shopPage = new ShopPage(driver);

    static final int PREMIER_ARTICLE = 0;
    static final int SIXIEME_ARTICLE = 5;

    @Given("je suis sur la page Shop")
    public void jeSuisSurLaPageShop() {
        Hooks.accederHome();
        homePage.accederShop();
    }

    @Then("je verifie que un article existe")
    public void jeVerifieQueUnArticleExiste() {
        shopPage.verifierPresenceArticle(PREMIER_ARTICLE);
    }

    @Then("je verifie que le bouton ADD TO BASKET est present")
    public void jeVerifieQueLeBoutonADDTOBASKETEstPresent() {
        shopPage.verifierPresenceBouton(SIXIEME_ARTICLE);
    }

    @Then("je verifie que le bouton READ MORE est present")
    public void jeVerifieQueLeBoutonREADMOREEstPresent() {
        shopPage.verifierPresenceBouton(PREMIER_ARTICLE);
    }

    @When("je clique sur le bouton ADD TO BASKET")
    public void jeCliqueSurLeBoutonADDTOBASKET() {
        shopPage.cliquerBoutonAddToBasketOuReadMore(SIXIEME_ARTICLE);
    }

    @And("je clique sur le lien View Basket")
    public void jeCliqueSurLeLienViewBasket() {
        shopPage.cliquerLienViewBasket();
    }

    @When("je choisi le filtre {string}")
    public void jeChoisiLeFiltre(String filtre) {
        shopPage.choisirFiltre(filtre);
        Hooks.setTemporisation(5000);
    }

    @Then("je verifie que les articles sont tries par ce {string}")
    public void jeVerifieQueLesArticlesSontTriesParCe(String filtre) {
        String prix = shopPage.getPrixArticle(0);
    }
}