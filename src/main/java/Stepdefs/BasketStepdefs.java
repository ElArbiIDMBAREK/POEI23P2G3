package Stepdefs;

import PageObjects.BasketPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BasketStepdefs {

    WebDriver driver = Hooks.driver;

    BasketPage basketPage = new BasketPage(driver);

    @Then("je verifie que je suis sur la page Basket")
    public void jeVerifieQueJeSuisSurLaPageBasket() {
        basketPage.verifierPresenceTitreBasket();
    }

    @Then("je verifie que un article est dans le panier")
    public void jeVerifieQueUnArticleEstDansLePanier() {
        basketPage.verifierPresenceArticlePanier();
    }

    @Then("je verifie que un champ quantite est present")
    public void jeVerifieQueUnChampQuantiteEstPresent() {
        basketPage.verifierPresenceQuantiteArticle();
    }

    @And("je verifie que un article a une quantite")
    public void jeVerifieQueUnArticleAUneQuantite() {
        basketPage.verifierPresenceQuantiteArticle();
    }

    @And("je verifie que un article a un prix unitaire")
    public void jeVerifieQueUnArticleAUnPrixUnitaire() {
        basketPage.verifierPresencePrixUnitaireArticle();
    }

    @And("je verifie que un article a un prix total")
    public void jeVerifieQueUnArticleAUnPrixTotal() {
        basketPage.verifierPresencePrixTotalArticle();
    }

    @When("je clique sur Supprimer Article")
    public void jeCliqueSurSupprimerArticle() {
        basketPage.cliquerBoutonSupprimerArticle();
    }

    @Then("je verifie que aucun article ne est present")
    public void jeVerifieQueAucunArticleNeEstPresent() {
        basketPage.verifierAbsenceArticlePanier();
    }

    @And("je modifie la case Quantity a {string}")
    public void jeModifieLaCaseQuantityA(String quantite) {
        basketPage.changerQuantiteArticle(quantite);
    }

    @Then("je verifie que la quantite egale a {string}")
    public void jeVerifieQueLaQuantiteEgaleA(String quantite) {
        basketPage.verifierQuantiteArticle(quantite);
    }

    @And("je clique sur le bouton Proceed to Chekout")
    public void jeCliqueSurLeBoutonProceedToChekout() {
        basketPage.cliquerBoutonProceedToCheckout();
    }
}
