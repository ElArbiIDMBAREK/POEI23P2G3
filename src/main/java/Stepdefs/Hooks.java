package Stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        wait = new WebDriverWait(driver, Duration.ofSeconds(TEMPS_ATTENTE));
    }

    public static void accederSite() {
        driver.get(URL);
    }

    @After
    public void demolition() {
        driver.quit();
    }
}
