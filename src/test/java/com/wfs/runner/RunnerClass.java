package com.wfs.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", 
                 glue = { "com.wfs.stepdefinition","com.wfs.hooks" },
                 plugin = { "pretty","html:target/report.html"}, 
                tags="@ProductCheckout",
                 monochrome = true, 
                 dryRun = false)
public class RunnerClass extends AbstractTestNGCucumberTests {

}
