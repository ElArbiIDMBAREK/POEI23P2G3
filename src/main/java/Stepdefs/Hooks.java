package Stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Hooks {

    static final int TEMPS_ATTENTE = 5;

    public static WebDriver driver;
    public static WebDriverWait wait;

    static final String URL = "https://practice.automationtesting.in/";

    @Before
    public void installation() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void accederHome() {
        driver.get(URL);
    }

    /**
     * Cliquer quelque part sur la page pour corriger quelques défauts du site
     * Quelques pages du site désactivent quelques boutons
     */
    public static void cliquer() {
        Actions actions = new Actions(driver);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.mouseMove(50,50);
        actions.click().build().perform();
    }

    public static void scroll() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);
    }

    public static void setTemporisation(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void demolition() {
        driver.quit();
    }
}
