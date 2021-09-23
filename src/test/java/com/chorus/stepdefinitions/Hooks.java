package com.chorus.stepdefinitions;

import com.chorus.framework.controllers.FileReaderController;
import com.chorus.framework.picocontainerdependency.TestContext;
import com.chorus.scenariocontext.ScenarioContext;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
* Hooks
* After and Before Hooks
*/


public class Hooks {

    private TestContext testContext;

    private FileReaderController fileReaderController;

    private ScenarioContext scenarioContext;

    /**
     * Pico Container Dependency Inject
     * @param testBase
     */

    public Hooks(TestContext testContext, ScenarioContext scenarioContext) {

        this.testContext=testContext;
        this.scenarioContext=scenarioContext;
        fileReaderController = testContext.getFileReaderController();
    }

    @Before (order = 0)
    public void createSession() throws Throwable {
        
        try
        {
            testContext.getWebDriverController().getDriver().get(fileReaderController.getPropertiesReader().getApplicationURL());
            
        } catch (Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    
    @Before (order = 1)
    public String scenarioName(Scenario scenario) {

        scenarioContext.scenarioName = scenario.getName();
        return scenarioContext.scenarioName;
    }
    
    @Before (order = 2)
    public String contractID() {

        scenarioContext.contractID = "";
        return scenarioContext.contractID;
    }

    @Before (order = 3)
    public String contractIDForLinking() {

        scenarioContext.contractIDForLinking = "";
        return scenarioContext.contractIDForLinking;
    }

    @Before (order = 4)
    public String UMR() {

        scenarioContext.UMR = "";
        return scenarioContext.UMR;
    }

    @Before (order = 5)
    public String ContractCreator() {

        scenarioContext.ContractCreator = "";
        return scenarioContext.ContractCreator;
    }

    @Before (order = 6)
    public String ManagingAgentUsername() {

        scenarioContext.ManagingAgentUsername = "";
        return scenarioContext.ManagingAgentUsername;
    }

    @Before (order = 7)
    public String LloydsUserName() {

        scenarioContext.LloydsUserName = "";
        return scenarioContext.LloydsUserName;
    }

    @Before (order = 8)
    public String ServiceCompanyUsername() {

        scenarioContext.ServiceCompanyUsername = "";
        return scenarioContext.ServiceCompanyUsername;
    }

    @Before (order = 9)
    public String ReviewTaskNumber() {

        scenarioContext.ReviewTaskNumber = "";
        return scenarioContext.ReviewTaskNumber;
    }

    @Before (order = 10)
    public String setAgreementTemplate() {

        scenarioContext.setAgreementTemplate = "";
        return scenarioContext.setAgreementTemplate;
    }

    @Before (order = 11)
    public String setContractStatus() {

        scenarioContext.setContractStatus = "";
        return scenarioContext.setContractStatus;
    }


    @After (order = 1)
    public void printTestEvidence() {

        try
        {
            String testEvidence = "CONTRACT ID AND UMR FOR SCENARIO - "+scenarioContext.scenarioName+" IS "+scenarioContext.contractID+" AND "+scenarioContext.UMR;
            System.out.println(testEvidence);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    @After (order = 0)
    public void endSession() {

        try
        {
            testContext.getWebDriverController().quitDriver();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}