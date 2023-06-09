package Stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Hooks {

    static final int TEMPS_ATTENTE = 5;

    public static WebDriver driver;
    public static WebDriverWait wait;

    static final String URL = "https://practice.automationtesting.in/";

    /**
     * Définition des Sélecteurs
     */
    static By deuxiemeIFramePublicationGoogle = By.cssSelector("#aswift_7");
    static By troisiemeIFramePublicationGoogle = By.cssSelector("#ad_iframe");
    static By boutonCloseBy =By.cssSelector("#dismiss-button");

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
     * Fermer le pop-up des publicités de Google
     */
    public static void fermerPublicationGoogle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(deuxiemeIFramePublicationGoogle));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(troisiemeIFramePublicationGoogle));
        wait.until(ExpectedConditions.elementToBeClickable(boutonCloseBy));
        driver.findElement(boutonCloseBy).click();
        driver.switchTo().defaultContent();
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
        setTemporisation(1000);
    }

    public static void zoomer(int taille) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < taille; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
        setTemporisation(2000);
    }

    public static void dezoomer(int taille) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < taille; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
        setTemporisation(2000);
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
