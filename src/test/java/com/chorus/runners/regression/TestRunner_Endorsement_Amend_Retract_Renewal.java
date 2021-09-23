package com.chorus.runners.regression;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Cucumber TestNG Regression Test Runner Class
 * Endorsement Amend and Retract
 * Contract Renewal
 */

@CucumberOptions(features = {"src/test/resources/Features/RegressionTest/Endorsement_Amend_Retract_Renewal/"},
                    plugin = {"pretty", "html:target/Destination/index.html"},
                    tags = "not @ignore155399",
                    glue = "com/chorus/stepdefinitions"
                 )


public class TestRunner_Endorsement_Amend_Retract_Renewal extends AbstractTestNGCucumberTests {
    
}
