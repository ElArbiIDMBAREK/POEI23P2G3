package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    static final int TIMEOUT_SIDE_PANEL = 5;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By boutonMyAccountBy = By.cssSelector("#menu-item-50");

    public void accederMyAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        wait.until(ExpectedConditions.elementToBeClickable(boutonMyAccountBy));
        driver.findElement(boutonMyAccountBy).click();
    }

}
