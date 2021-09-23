package com.chorus.runners.regression;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Cucumber TestNG Regression Test Runner Class
 * Assign Contract to Individual, Team through dashboard and while creating contract
 * Dashboard Filter and Sorting
 * Contract Status
 * Twin Contract
 */

@CucumberOptions(features = {"src/test/resources/Features/RegressionTest/ContractAssign_DashboardFilterAndSorting_ContractStatus_TwinContract/"},
                  plugin = {"pretty", "html:target/Destination/index.html"},
                  tags = "not @ignore155399",
                  glue = "com/chorus/stepdefinitions"
                 )

                
public class TestRunner_ContractAssign_DashboardFilterAndSorting_ContractStatus_TwinContract extends AbstractTestNGCucumberTests {
 
}