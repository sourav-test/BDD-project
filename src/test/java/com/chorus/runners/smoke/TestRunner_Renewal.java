package com.chorus.runners.smoke;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Cucumber TestNG Smoke Test Runner Class 
 * Validate Renewal for Active Contract
 */


@CucumberOptions(features = {"src/test/resources/Features/SmokeTest/Renewal"},
                    plugin = {"pretty"},
                    glue = "com/chorus/stepdefinitions"
                 )

                
public class TestRunner_Renewal extends AbstractTestNGCucumberTests {

                
    
}