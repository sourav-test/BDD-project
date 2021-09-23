package com.chorus.runners.regression;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Cucumber TestNG Regression Test Runner Class
 * Validation of General Contract Information
 * Duplicate Contract Functionality
 * Contrtact Linking and Delinking
 * Create Contract with Not Listed Templates
 */

@CucumberOptions(features = {"src/test/resources/Features/RegressionTest/ValidateGeneralContractInfo_ContractDuplicate_LinkingDelinking_NotListed/"},
                    plugin = {"pretty", "html:target/Destination/index.html"},
                    tags = "not @ignore155399",
                    glue = "com/chorus/stepdefinitions"
                 )


public class TestRunner_ValidateGeneralContractInfo_ContractDuplicate_LinkingDelinking_NotListed extends AbstractTestNGCucumberTests {
    
}
