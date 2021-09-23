package com.chorus.runners.regression;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Cucumber TestNG Regression Test Runner Class
 * Contract Notification
 * Create Contract Amend and Retract
 * Termination Endorsement
 */


@CucumberOptions(features = {"src/test/resources/Features/RegressionTest/ContractNotification_Retract_Amend_Termination/"},
                    plugin = {"pretty", "html:target/Destination/index.html"},
                    tags = "not @ignore155399",
                    glue = "com/chorus/stepdefinitions"
                 )

public class TestRunner_ContractNotification_Retract_Amend_Termination extends AbstractTestNGCucumberTests {
    
}