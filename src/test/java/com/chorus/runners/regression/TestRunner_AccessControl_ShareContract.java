package com.chorus.runners.regression;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Cucumber TestNG Regression Test Runner Class
 * Access Control
 * Share Contract
 */

@CucumberOptions(features = {"src/test/resources/Features/RegressionTest/AccessControl_ShareContract/"},
                  plugin = {"pretty", "html:target/Destination/index.html"},
                  tags = "not @ignore155399",
                  glue = "com/chorus/stepdefinitions"
                 )


public class TestRunner_AccessControl_ShareContract extends AbstractTestNGCucumberTests {
    
}
