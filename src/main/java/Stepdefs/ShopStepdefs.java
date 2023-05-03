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
        //shopPage.cliquerBoutonAddToBasketOuReadMore(SIXIEME_ARTICLE);
    }

    @And("je clique sur le lien View Basket")
    public void jeCliqueSurLeLienViewBasket() {
        shopPage.cliquerLienViewBasket();
    }

    @When("je choisi le filtre {string}")
    public void jeChoisiLeFiltre(String filtre) {
        shopPage.choisirFiltre(filtre);
        //Hooks.setTemporisation(5000);
    }

    @Then("je verifie que les articles sont tries par ce {string}")
    public void jeVerifieQueLesArticlesSontTriesParCe(String filtre) {
        shopPage.articleFiltre(filtre);
    }

    @Then("je verifie que un article a une Photo")
    public void jeVerifieQueUnArticleAUnePhoto() {
        shopPage.verifierPresenceImageArticle(PREMIER_ARTICLE);
    }

    @And("je verifie que un article a un Libelle")
    public void jeVerifieQueUnArticleAUnLibelle() {
        shopPage.verifierPresenceLibelleArticle(PREMIER_ARTICLE);
    }

    @And("je verifie que un article a un Prix")
    public void jeVerifieQueUnArticleAUnPrix() {
        shopPage.verifierPresencePrixArticle(PREMIER_ARTICLE);
    }

    @And("je verifie que un article contient un lien")
    public void jeVerifieQueUnArticleContientUnLien() {
        shopPage.verifierPresenceLienArticle(PREMIER_ARTICLE);
    }

    @When("je clique sur le article {string}")
    public void jeCliqueSurLeArticle(String indexArticle) {
        shopPage.cliquerArticle(Integer.parseInt(indexArticle));
    }

    @And("je clique sur le bouton Panier")
    public void jeCliqueSurLeBoutonPanier() {
        shopPage.cliquerBoutonPanier();
    }

    @And("je verifie que le lien View Basket est present")
    public void jeVerifieQueLeLienViewBasketEstPresent() {
        shopPage.verifierPresenceBoutonViewBasket();
    }

    @Then("je verifie que les articles sont tries par theme")
    public void jeVerifieQueLesArticlesSontTriesParTheme() {
        shopPage.verifierArticlesFiltresTheme();
    }
}
