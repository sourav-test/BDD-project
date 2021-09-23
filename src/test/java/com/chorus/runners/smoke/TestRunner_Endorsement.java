package com.chorus.runners.smoke;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Cucumber TestNG Smoke Test Runner Class 
 * Validate Endorsement for Active Contract
 */


@CucumberOptions(features = {"src/test/resources/Features/SmokeTest/Endorsement"},
                    plugin = {"pretty"},
                    glue = "com/chorus/stepdefinitions"
                 )

                
public class TestRunner_Endorsement extends AbstractTestNGCucumberTests {

                
    
}