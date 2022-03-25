package task4.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports/report.html"},
        features = "src/test/resources/Features",
        glue = "src/test/java/task4/StepDefs",
        dryRun = false,
        tags = "@wip"
)

public class CukesRunner {
}
