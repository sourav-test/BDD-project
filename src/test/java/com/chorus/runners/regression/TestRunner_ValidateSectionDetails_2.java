package com.chorus.runners.regression;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Cucumber TestNG Regression Test Runner Class
 * Validation of Section Details - 2
 * 
 */

@CucumberOptions(features = {"src/test/resources/Features/RegressionTest/ValidateSectionDetails_2/"},
                    plugin = {"pretty", "html:target/Destination/index.html"},
                    tags = "not @ignore155399",
                    glue = "com/chorus/stepdefinitions"
                )

public class TestRunner_ValidateSectionDetails_2 extends AbstractTestNGCucumberTests {
    
}
