package runnerTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml"},
        monochrome = true,
        dryRun = false,
        publish = true,
        stepNotifications = true,  // it gives notifications if your tests are wrong executed, or have problem
        //Path to your feature file
        features = {"src/main/resources/Features"},
        // Specify tags to be executed
        tags = "@homepage",
        //Specify step definition package name (Note: make sure to have this package on current directory)
        glue = {"stepDefinition"}
)









public class TestRunner {
}
