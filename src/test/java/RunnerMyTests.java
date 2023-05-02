import Stepdefs.IntegrationWithXray;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "Stepdefs",
        tags = {"@TEST_POEI23P2G3-82","@TNR"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber.json"
        }
)

public class RunnerMyTests {
        @AfterClass
        public static void importToXray() throws IOException, NoSuchAlgorithmException, KeyStoreException, InterruptedException, KeyManagementException {
                //IntegrationWithXray.importToXray();
        }
}
