package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(

            plugin={"html:target//cucumber-reports.html",
                    "json:target/json-reports/cucumber1.json",
                    "junit:target/xml-reports/cucumber1.xml"},

            features= "src/test/resources/features",

            glue="stepdefinitions",

            tags="@demo",

            dryRun= false

    )
    public class TestRunner {

    }

