import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/features/US5.feature",
        glue = "Stepdefs",
        tags = {"@TEST_POEI23P2G3-117","@TNR"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber.json"
        }
)

public class RunnerMyTests {}
