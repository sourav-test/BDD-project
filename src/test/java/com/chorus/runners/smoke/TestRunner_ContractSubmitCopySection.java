package com.chorus.runners.smoke;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Cucumber TestNG Smoke Test Runner Class 
 * Submit Contract with Binding Authority Agreement Contract Type with 2 sections
 */



@CucumberOptions(features = {"src/test/resources/Features/SmokeTest/ContractSubmitCopySection"},
                    plugin = {"pretty"},
                    glue = "com/chorus/stepdefinitions"
                 )

public class TestRunner_ContractSubmitCopySection extends AbstractTestNGCucumberTests {
    
}