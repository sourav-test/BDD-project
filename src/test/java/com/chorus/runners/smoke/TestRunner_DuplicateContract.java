package com.chorus.runners.smoke;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Features/SmokeTest/DuplicateContract"},
                    plugin = {"pretty"},
                    glue = "com/chorus/stepdefinitions"
                 )

public class TestRunner_DuplicateContract extends AbstractTestNGCucumberTests {
    
}
