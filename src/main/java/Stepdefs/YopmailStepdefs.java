package Stepdefs;

import PageObjects.YopmailPage;
import cucumber.api.java.en.Then;

public class YopmailStepdefs {

    YopmailPage yopmailPage = new YopmailPage();

    @Then("je verifie que je recois un lien avec le {string} de réinitialisation dans ma boite email")
    public void jeVerifieQueJeRecoisUnLienAvecLeDeRéinitialisationDansMaBoiteEmail(String email) {
        yopmailPage.verifierMailRecu(email);
    }

}
