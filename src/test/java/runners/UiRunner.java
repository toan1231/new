package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber",
                "json:target/cucumber.json"},
        features="src/test/resources/uiFeatures",
        glue="stepDefinitions",
        tags="@minh",
        dryRun = false,
        monochrome = true
)

public class UiRunner {

}
