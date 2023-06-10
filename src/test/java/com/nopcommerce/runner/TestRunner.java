package com.nopcommerce.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/",
        glue = "com.nopcommerce.steps",
        plugin = {"pretty", "summary",
                "html:target/test-report.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        },
        monochrome = false,
        publish = true,
        dryRun = false
)
public class TestRunner {
}
