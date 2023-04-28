package PageObjects;

import Hooks.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver = Hooks.driver;

    By boutonMyAccountBy = By.cssSelector("#menu-item-50");
    By titreRegisterBy = By.cssSelector(".u-column2.col-2");

    public void accederMyAccount() {
        driver.findElement(boutonMyAccountBy).click();
    }
    public void verifierLaPresenceDeRigiterSurMyAccount(String titreRegisterAttendu) {
        String titreRegisterActuel = driver.findElement(titreRegisterBy).getText();
        System.out.println(titreRegisterActuel);
        Assert.assertEquals("Le pavé 'Regsiter' n'est pas présent sur la page 'My Account'", titreRegisterAttendu, titreRegisterActuel);
    }

}
