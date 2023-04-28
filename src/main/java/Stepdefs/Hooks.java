package Stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver driver;

    static final String URL = "https://practice.automationtesting.in/";

    @Before
    public void installation() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void accederSite() {
        driver.get(URL);
    }

    @After
    public void demolition() {
        driver.quit();
    }
}
