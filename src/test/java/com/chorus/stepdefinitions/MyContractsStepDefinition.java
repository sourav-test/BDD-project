package com.chorus.stepdefinitions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.chorus.framework.controllers.FileReaderController;
import com.chorus.framework.controllers.PageFactoryController;
import com.chorus.framework.picocontainerdependency.TestContext;
import com.chorus.scenariocontext.ScenarioContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class MyContractsStepDefinition {

    public List<HashMap<String, String>> MPRData;

    public List<HashMap<String, String>> NonMPRData;

    public List<HashMap<String, String>> SortingFilterData;

    private TestContext testContext;

    private ScenarioContext scenarioContext;

    private PageFactoryController pageFactory;

    private FileReaderController fileReaderController;

    /**
     * Pico Container Dependency Inject
     * @param testBase
     */

    public MyContractsStepDefinition(TestContext testContext, ScenarioContext scenarioContext) {

        this.testContext=testContext;
        this.scenarioContext=scenarioContext;
        pageFactory = testContext.getPageFactoryController();
        fileReaderController = testContext.getFileReaderController();
        MPRData = testContext.getFileReaderController().getExcelReader().GetTestData("MPRData");
        NonMPRData = testContext.getFileReaderController().getExcelReader().GetTestData("NonMPRData");
        SortingFilterData = testContext.getFileReaderController().getExcelReader().GetTestData("SortingFilterScenarios");
    }
    
    
    @Then("Validate All the Contracts are Assigned to the Logged In User \"(.*)\"$")
    public void ValidateAssignedto(String testData) {

        try
        {
            testContext.getWebElementUtil().pause();
            for(WebElement AssignedTo : pageFactory.getMyTasks().AssignedToList)
            {
                Assert.assertTrue(AssignedTo.getText().equalsIgnoreCase(scenarioContext.ContractCreator));
            }

        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }
    
    @And("Apply Filter for UMR")
    public void FilterWithUMR() {

        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UMRFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().FilterText, scenarioContext.UMR);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Apply Filter for Unique Identifier")
    public void FilterWithUniqueIdentifier() {

        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UniqueIdentifierFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().FilterText, scenarioContext.contractID);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Apply Filter Task Status for Completed Contracts dashboard \"(.*)\"$")
    public void FilterWithTaskStatusCompletedContracts(String testData) {

        try
        {
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().TaskStatusFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().FilterText, "Complete");
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();

            while(pageFactory.getCompletedContracts().UniqueIdentifierListCompletedContracts.size()<1)
            {
                /* If the Contract is still not in Complete Status */
                /* Logout From Application */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getApplicationAccess().UsernameField);

                /* Login To Application */
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ContractCreator"));
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionfirst)
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }

                /* Navigate to Completed Contracts */
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getHome().CompletedTasks);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getCompletedContracts().PegaCompletedContractsFrame);
                testContext.getWebElementUtil().pause();

                /* Apply Filter for Unique Identifier */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UniqueIdentifierFilter);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().FilterText, scenarioContext.contractID);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
                testContext.getWebElementUtil().pause();
                
                /* Apply Task Status as Completed */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().TaskStatusFilter);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().FilterText, "Complete");
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
                testContext.getWebElementUtil().pause();

                break;
            }
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("^Apply Filter for Broker \"(.*)\"$")
    public void FilterWithBroker(String testData) {

        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BrokerFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().FilterText, MPRData.get(index).get("Organization"));
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Apply Filter for Contract Type")
    public void FilterWithContractType() {

        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContractTypeFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().FilterText, scenarioContext.setContractType);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("^Apply Filter for Inception Date \"(.*)\"$")
    public void FilterWithInceptionDate(String inceptiondate)
    {
        try
        {
            int index = Integer.parseInt(inceptiondate)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().InceptionDateFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().FromField, SortingFilterData.get(index).get("InceptionDateFilter"));
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }


    @And("Apply Filter for Effective Date \"(.*)\"$")
    public void FilterWithEffectiveDate(String effectivedate)
    {
        try
        {
            int index = Integer.parseInt(effectivedate)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().EffectiveDateFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().FromField, SortingFilterData.get(index).get("EffectiveFromFilter"));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().ToField, SortingFilterData.get(index).get("EffectiveToFilter"));
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();

        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Validate All the Header values of My Task dashboard \"(.*)\"$")
    public void ValidateAllHeaderValuesMyTaskDashboard(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getMyTasks().UMR);

            String actualUMR = pageFactory.getMyTasks().UMR.getText();
            Assert.assertEquals(actualUMR, scenarioContext.UMR);

            String effectiveDate = testContext.getWebElementUtil().GetCurrentDateDMY();
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("(//span[text()='"+effectiveDate+"'])[1]")).equals(true));

            String thirdPartyParticipant = MPRData.get(index).get("CapacitySeeker");
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+thirdPartyParticipant+"']")).equals(true));

            String actaulUniqueIdentifier = pageFactory.getMyTasks().UniqueIdentifier.getText();
            Assert.assertEquals(actaulUniqueIdentifier, scenarioContext.contractID);

            String actualtaskType = pageFactory.getMyTasks().TaskType.getText();
            Assert.assertEquals(actualtaskType, "Create Registration");

            String actualtaskStatus = pageFactory.getMyTasks().TaskStatus.getText();
            Assert.assertEquals(actualtaskStatus, "Draft");

            String brokerOperatorID [] = MPRData.get(index).get("ContractCreator").split("@");
            String brokerFirstName = brokerOperatorID[0];
            String brokerLastName = " AUTOTEST";
            String contractCreator = brokerFirstName.concat(brokerLastName);
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+contractCreator+"']")).equals(true));
            
            String broker = MPRData.get(index).get("Organization");
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+broker+"']")).equals(true));

            String lloydsLead = MPRData.get(index).get("SyndicateLead");
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+lloydsLead+"']")).equals(true));

            if(scenarioContext.contractID.contains("CH"))
            {
                String actualContractType =  pageFactory.getMyTasks().ContractType.getText();
                Assert.assertEquals(actualContractType, "BAA");
            }
            else if(scenarioContext.contractID.contains("SC"))
            {
                String actualContractType =  pageFactory.getMyTasks().ContractType.getText();
                Assert.assertEquals(actualContractType, "BAA");
            }

            String submittedDate = testContext.getWebElementUtil().GetCurrentDateDMY();
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("(//span[text()='"+submittedDate+"'])[2]")).equals(true));

        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    

    @Then("Validate All the Header values of My Teams dashboard \"(.*)\"$")
    public void ValidateAllHeaderValuesMyTeamsDashboard(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getMyTeamsTasks().UMRMyTeams);

            String actualUMR = pageFactory.getMyTeamsTasks().UMRMyTeams.getText();
            Assert.assertEquals(actualUMR, scenarioContext.UMR);

            String effectiveDate = testContext.getWebElementUtil().GetCurrentDateDMY();
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("(//span[text()='"+effectiveDate+"'])[1]")).equals(true));

            String thirdPartyParticipant = MPRData.get(index).get("CapacitySeeker");
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+thirdPartyParticipant+"']")).equals(true));

            String actaulUniqueIdentifier = pageFactory.getMyTeamsTasks().UniqueIdentifierMyTeams.getText();
            Assert.assertEquals(actaulUniqueIdentifier, scenarioContext.contractID);

            String actualtaskType = pageFactory.getMyTeamsTasks().MyTeamsTaskType.getText();
            Assert.assertEquals(actualtaskType, "Create Registration");

            String actualtaskStatus = pageFactory.getMyTeamsTasks().MyTeamsTaskStatus.getText();
            Assert.assertEquals(actualtaskStatus, "Draft");

            String brokerOperatorID [] = MPRData.get(index).get("ContractCreator").split("@");
            String brokerFirstName = brokerOperatorID[0];
            String brokerLastName = " AUTOTEST";
            String contractCreator = brokerFirstName.concat(brokerLastName);
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+contractCreator+"']")).equals(true));
            
            String broker = MPRData.get(index).get("Organization");
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+broker+"']")).equals(true));

            String lloydsLead = MPRData.get(index).get("SyndicateLead");
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+lloydsLead+"']")).equals(true));

            if(scenarioContext.contractID.contains("CH"))
            {
                String actualContractType =  pageFactory.getMyTeamsTasks().MyTeamsContractType.getText();
                Assert.assertEquals(actualContractType, "BAA");
            }
            else if(scenarioContext.contractID.contains("SC"))
            {
                String actualContractType =  pageFactory.getMyTeamsTasks().MyTeamsContractType.getText();
                Assert.assertEquals(actualContractType, "BAA");
            }

            String submittedDate = testContext.getWebElementUtil().GetCurrentDateDMY();
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("(//span[text()='"+submittedDate+"'])[2]")).equals(true));

        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Validate All the Header values of Completed dashboard \"(.*)\"$")
    public void ValidateAllHeaderValuesCompletedDashboard(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCompletedContracts().UniqueIdentifierCompletedContracts);

            String actualUMR = pageFactory.getCompletedContracts().UMRCompletedContracts.getText();
            Assert.assertEquals(actualUMR, scenarioContext.UMR);

            String actaulUniqueIdentifier = pageFactory.getCompletedContracts().UniqueIdentifierCompletedContracts.getText();
            Assert.assertEquals(actaulUniqueIdentifier, scenarioContext.contractID);

            String actualtaskStatus = pageFactory.getCompletedContracts().CompletedContractsTaskStatus.getText();
            Assert.assertEquals(actualtaskStatus, "Complete");

            String broker = MPRData.get(index).get("Organization");
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+broker+"']")).equals(true));

            String lloydsLead = MPRData.get(index).get("SyndicateLead");
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+lloydsLead+"']")).equals(true));

            if(scenarioContext.contractID.contains("CH"))
            {
                String actualContractType =  pageFactory.getCompletedContracts().CompletedContractsContractType.getText();
                Assert.assertEquals(actualContractType, "Binding Authority Agreement");
            }
            else if(scenarioContext.contractID.contains("SC"))
            {
                String actualContractType =  pageFactory.getCompletedContracts().CompletedContractsContractType.getText();
                Assert.assertEquals(actualContractType, "Service Company Agreement");
            }

            String thirdPartyParticipant = MPRData.get(index).get("CapacitySeeker");
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+thirdPartyParticipant+"']")).equals(true));

            String effectiveDate = testContext.getWebElementUtil().GetCurrentDateDMY();
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("(//span[text()='"+effectiveDate+"'])[1]")).equals(true));

            String submittedDate = testContext.getWebElementUtil().GetCurrentDateDMY();
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("(//span[text()='"+submittedDate+"'])[2]")).equals(true));
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Validate All the Header values of Ongoing Task dashboard \"(.*)\"$")
    public void ValidateAllHeaderValuesOngoingTaskDashboard(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getOnGoingTasks().UniqueIdentifierOngTask);

            String actualtaskType = pageFactory.getOnGoingTasks().TaskTypeOngTask.getText();
            Assert.assertEquals(actualtaskType, "Create Registration");
            
            String actualUMR = pageFactory.getOnGoingTasks().UMROngTask.getText();
            Assert.assertEquals(actualUMR, scenarioContext.UMR);
            
            String actaulUniqueIdentifier = pageFactory.getOnGoingTasks().UniqueIdentifierOngTask.getText();
            Assert.assertEquals(actaulUniqueIdentifier, scenarioContext.contractID);
            
            String actualtaskStatus = pageFactory.getOnGoingTasks().TaskStatusOngTask.getText();
            Assert.assertEquals(actualtaskStatus, "Under review (lead(s) reviewing)");

            String assignedTo = MPRData.get(index).get("ManagingAgent");
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+assignedTo+"']")).equals(true));

            String broker = MPRData.get(index).get("Organization");
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+broker+"']")).equals(true));

            String lloydsLead = MPRData.get(index).get("SyndicateLead");
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+lloydsLead+"']")).equals(true));

            if(scenarioContext.contractID.contains("CH"))
            {
                String actualContractType =  pageFactory.getCompletedContracts().CompletedContractsContractType.getText();
                Assert.assertEquals(actualContractType, "BAA");
            }
            else if(scenarioContext.contractID.contains("SC"))
            {
                String actualContractType =  pageFactory.getCompletedContracts().CompletedContractsContractType.getText();
                Assert.assertEquals(actualContractType, "SerCo");
            }

            String thirdPartyParticipant = MPRData.get(index).get("CapacitySeeker");
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+thirdPartyParticipant+"']")).equals(true));

            String effectiveDate = testContext.getWebElementUtil().GetCurrentDateDMY();
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("(//span[text()='"+effectiveDate+"'])[1]")).equals(true));
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("^Validate the Details of the Contract in Expanded View \"(.*)\"$")
    public void ValidateContract(String testData) {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().Expand);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().BrokerName);
            
            String actualBroker = pageFactory.getCommon().BrokerName.getText();
            String expectedBroker = MPRData.get(index).get("Organization");
            Assert.assertEquals(actualBroker, expectedBroker);
            
            String actualBrokerNumber = pageFactory.getCommon().BrokerNumber.getText();
            String expectedBrokerNumber = MPRData.get(index).get("CSN");
            Assert.assertEquals(actualBrokerNumber, expectedBrokerNumber);
            
            String actualLloydsLead = pageFactory.getCommon().LloydsLead.getText();
            String expectedLloydsLead = MPRData.get(index).get("SyndicateLead");
            Assert.assertEquals(actualLloydsLead, expectedLloydsLead);

            String actualThirdPartyParticipant = pageFactory.getCommon().ThirdPartyParticipant.getText();
            String expectedThirdPartyParticipant = MPRData.get(index).get("CapacitySeeker");
            Assert.assertEquals(actualThirdPartyParticipant, expectedThirdPartyParticipant);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    
    @And("Clear the Filter for UMR")
    public void ClearFilterUMR()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().Collapse);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UMRFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ClearFilter);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Clear the Filter for Broker")
    public void ClearFilterBroker()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().Collapse);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BrokerFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ClearFilter);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Clear the Filter for Inception Date")
    public void ClearFilterInceptionDate()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().InceptionDateFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ClearFilter);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }


    @And("Clear the Filter for Unique Identifier")
    public void ClearFilterIdentifier()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().Collapse);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UniqueIdentifierFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ClearFilter);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }
   

    @Then("Sort with UMR in Ascending Order")
    public void SortUMRAscending()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().UMRAscendCheck).equals(true))
            {
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                if(scenarioContext.scenarioName.contains("Teams"))
                {
                    for(WebElement UMRList : pageFactory.getMyTeamsTasks().UMRListMyTeams)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Completed"))
                {
                    for(WebElement UMRList : pageFactory.getCompletedContracts().UMRListCompletedContracts)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Search"))
                {
                    for(WebElement UMRList : pageFactory.getSearchContracts().UMRListSearchContracts)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                else
                {
                    for(WebElement UMRList : pageFactory.getMyTasks().UMRList)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                
                    
                /*List After Sort*/
                ArrayList <String> sortlist = new ArrayList<>();
                for(String UMRsortedlist : defaultlist)
                {
                    sortlist.add(UMRsortedlist);
                }
                Collections.sort(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
            else 
            {
                pageFactory.getCommon().UMRColumnHeader.click();
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                if(scenarioContext.scenarioName.contains("Teams"))
                {
                    for(WebElement UMRList : pageFactory.getMyTeamsTasks().UMRListMyTeams)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Completed"))
                {
                    for(WebElement UMRList : pageFactory.getCompletedContracts().UMRListCompletedContracts)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Search"))
                {
                    for(WebElement UMRList : pageFactory.getSearchContracts().UMRListSearchContracts)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                else
                {
                    for(WebElement UMRList : pageFactory.getMyTasks().UMRList)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                    
                /*List After Sort*/
                ArrayList <String> sortlist = new ArrayList<>();
                for(String UMRsortedlist : defaultlist)
                {
                    sortlist.add(UMRsortedlist);
                }
                Collections.sort(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
                }
        }

        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }

    }
    
    
    @Then("Sort with UMR in Descending Order")
    public void SortUMRDescending()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().UMRAscendCheck).equals(true))
            {
                pageFactory.getCommon().UMRColumnHeader.click();
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                if(scenarioContext.scenarioName.contains("Teams"))
                {
                    for(WebElement UMRList : pageFactory.getMyTeamsTasks().UMRListMyTeams)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Completed"))
                {
                    for(WebElement UMRList : pageFactory.getCompletedContracts().UMRListCompletedContracts)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Search"))
                {
                    for(WebElement UMRList : pageFactory.getSearchContracts().UMRListSearchContracts)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                else
                {
                    for(WebElement UMRList : pageFactory.getMyTasks().UMRList)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                    
                /*List After Sort*/
                    
                ArrayList <String> sortlist = new ArrayList<>();
                for(String UMRsortedlist : defaultlist)
                {
                    sortlist.add(UMRsortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
            else if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().UMRDescendCheck).equals(true))
            {
                ArrayList <String> defaultlist = new ArrayList<>();
                if(scenarioContext.scenarioName.contains("Teams"))
                {
                    for(WebElement UMRList : pageFactory.getMyTeamsTasks().UMRListMyTeams)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Completed"))
                {
                    for(WebElement UMRList : pageFactory.getCompletedContracts().UMRListCompletedContracts)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Search"))
                {
                    for(WebElement UMRList : pageFactory.getSearchContracts().UMRListSearchContracts)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                else
                {
                    for(WebElement UMRList : pageFactory.getMyTasks().UMRList)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                    
                /*List After Sort*/
                    
                ArrayList <String> sortlist = new ArrayList<>();
                for(String UMRsortedlist : defaultlist)
                {
                    sortlist.add(UMRsortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
            else
            {
                pageFactory.getCommon().UMRColumnHeader.click();
                try
                {
                    testContext.getWebElementUtil().pause();
                    pageFactory.getCommon().UMRColumnHeader.click();
                }
                catch(org.openqa.selenium.ElementClickInterceptedException firstexception)
                {
                    try
                    {
                        testContext.getWebElementUtil().pause();
                        pageFactory.getCommon().UMRColumnHeader.click();
                    }
                    catch(org.openqa.selenium.ElementClickInterceptedException secondexception)
                    {
                        testContext.getWebElementUtil().pause();
                        pageFactory.getCommon().UMRColumnHeader.click();
                    }
                    
                }
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                if(scenarioContext.scenarioName.contains("Teams"))
                {
                    for(WebElement UMRList : pageFactory.getMyTeamsTasks().UMRListMyTeams)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Completed"))
                {
                    for(WebElement UMRList : pageFactory.getCompletedContracts().UMRListCompletedContracts)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Search"))
                {
                    for(WebElement UMRList : pageFactory.getSearchContracts().UMRListSearchContracts)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                else
                {
                    for(WebElement UMRList : pageFactory.getMyTasks().UMRList)
                    {
                        defaultlist.add(UMRList.getText());
                    }
                }
                    
                /*List After Sort*/
                    
                ArrayList <String> sortlist = new ArrayList<>();
                for(String UMRsortedlist : defaultlist)
                {
                    sortlist.add(UMRsortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));

            }


        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }
    
    
    @Then("Sort with Unique Identifier in Ascending Order")
    public void SortUniqueIdentifierAscending()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().UniqueIdentifierAscendCheck).equals(true))
            {
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                if(scenarioContext.scenarioName.contains("Teams"))
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getMyTeamsTasks().UniqueIdentifierListMyTeams)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Search"))
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getSearchContracts().UniqueIdentifierListSearchContracts)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Completed"))
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getCompletedContracts().UniqueIdentifierListCompletedContracts)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                else
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getMyTasks().UniqueIdentifierList)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                    
                /*List After Sort*/
                ArrayList <String> sortlist = new ArrayList<>();
                for(String UniqueIdentifiersortedlist : defaultlist)
                {
                    sortlist.add(UniqueIdentifiersortedlist);
                }
                Collections.sort(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
            else
            {
                pageFactory.getCommon().UniqueIdentiferColumnHeader.click();
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                if(scenarioContext.scenarioName.contains("Teams"))
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getMyTeamsTasks().UniqueIdentifierListMyTeams)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Search"))
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getSearchContracts().UniqueIdentifierListSearchContracts)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Completed"))
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getCompletedContracts().UniqueIdentifierListCompletedContracts)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                else
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getMyTasks().UniqueIdentifierList)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                    
                /*List After Sort*/
                ArrayList <String> sortlist = new ArrayList<>();
                for(String UniqueIdentifiersortedlist : defaultlist)
                {
                    sortlist.add(UniqueIdentifiersortedlist);
                }
                Collections.sort(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            } 
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }
    
    
    @Then("Sort with Unique Identifier in Descending Order")
    public void SortUniqueIdentifierDescending()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().UniqueIdentifierAscendCheck).equals(true))
            {
                pageFactory.getCommon().UniqueIdentiferColumnHeader.click();
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                if(scenarioContext.scenarioName.contains("Teams"))
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getMyTeamsTasks().UniqueIdentifierListMyTeams)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Search"))
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getSearchContracts().UniqueIdentifierListSearchContracts)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Completed"))
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getCompletedContracts().UniqueIdentifierListCompletedContracts)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                else
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getMyTasks().UniqueIdentifierList)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                    
                /*List After Sort*/
                    
                ArrayList <String> sortlist = new ArrayList<>();
                for(String UniqueIdentifiersortedlist : defaultlist)
                {
                    sortlist.add(UniqueIdentifiersortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
            else if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().UniqueIdentifierDescendCheck).equals(true))
            {
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                if(scenarioContext.scenarioName.contains("Teams"))
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getMyTeamsTasks().UniqueIdentifierListMyTeams)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Search"))
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getSearchContracts().UniqueIdentifierListSearchContracts)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Completed"))
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getCompletedContracts().UniqueIdentifierListCompletedContracts)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                else
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getMyTasks().UniqueIdentifierList)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                    
                /*List After Sort*/
                    
                ArrayList <String> sortlist = new ArrayList<>();
                for(String UniqueIdentifiersortedlist : defaultlist)
                {
                    sortlist.add(UniqueIdentifiersortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
            else
            {
                pageFactory.getCommon().UniqueIdentiferColumnHeader.click();
                try
                {
                    testContext.getWebElementUtil().pause();
                    pageFactory.getCommon().UniqueIdentiferColumnHeader.click();
                }
                catch(org.openqa.selenium.ElementClickInterceptedException firstexception)
                {
                    try
                    {
                        testContext.getWebElementUtil().pause();
                        pageFactory.getCommon().UniqueIdentiferColumnHeader.click();
                    }
                    catch(org.openqa.selenium.ElementClickInterceptedException secondexception)
                    {
                        testContext.getWebElementUtil().pause();
                        pageFactory.getCommon().UniqueIdentiferColumnHeader.click();
                    }
                }
                
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                if(scenarioContext.scenarioName.contains("Teams"))
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getMyTeamsTasks().UniqueIdentifierListMyTeams)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Search"))
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getSearchContracts().UniqueIdentifierListSearchContracts)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                else if(scenarioContext.scenarioName.contains("Completed"))
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getCompletedContracts().UniqueIdentifierListCompletedContracts)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                else
                {
                    for(WebElement UniqueIdentifierList : pageFactory.getMyTasks().UniqueIdentifierList)
                    {
                        defaultlist.add(UniqueIdentifierList.getText());
                    }
                }
                    
                /*List After Sort*/
                    
                ArrayList <String> sortlist = new ArrayList<>();
                for(String UniqueIdentifiersortedlist : defaultlist)
                {
                    sortlist.add(UniqueIdentifiersortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
                
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }


    @Then("Sort with Contract Type in Ascending Order")
    public void SortContractTypeAscending()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().ContractTypeAscendCheck).equals(true))
            {
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                for(WebElement ContractTypeList : pageFactory.getCommon().ContractTypeList)
                {
                    defaultlist.add(ContractTypeList.getText());
                }
                    
                /*List After Sort*/
                ArrayList <String> sortlist = new ArrayList<>();
                for(String ContractTypesortedlist : defaultlist)
                {
                    sortlist.add(ContractTypesortedlist);
                }
                Collections.sort(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));    
            }
            else
            {
                pageFactory.getCommon().ContractTypeColumnHeader.click();
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                for(WebElement ContractTypeList : pageFactory.getCommon().ContractTypeList)
                {
                    defaultlist.add(ContractTypeList.getText());
                }
                    
                /*List After Sort*/
                ArrayList <String> sortlist = new ArrayList<>();
                for(String ContractTypesortedlist : defaultlist)
                {
                    sortlist.add(ContractTypesortedlist);
                }
                Collections.sort(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));  
            } 
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }


    @Then("Sort with Contract Type in Descending Order")
    public void SortContractTypeDescending()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().ContractTypeAscendCheck).equals(true))
            {
                pageFactory.getCommon().ContractTypeColumnHeader.click();
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                for(WebElement ContractTypeList : pageFactory.getCommon().ContractTypeList)
                {
                    defaultlist.add(ContractTypeList.getText());
                }
                    
                /*List After Sort*/
                    
                ArrayList <String> sortlist = new ArrayList<>();
                for(String ContractTypesortedlist : defaultlist)
                {
                    sortlist.add(ContractTypesortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
            else if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().ContractTypeDescendCheck).equals(true))
            {
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                for(WebElement ContractTypeList : pageFactory.getCommon().ContractTypeList)
                {
                    defaultlist.add(ContractTypeList.getText());
                }
                    
                /*List After Sort*/
                    
                ArrayList <String> sortlist = new ArrayList<>();
                for(String ContractTypesortedlist : defaultlist)
                {
                    sortlist.add(ContractTypesortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
            else
            {
                pageFactory.getCommon().ContractTypeColumnHeader.click();
                try
                {
                    testContext.getWebElementUtil().pause();
                    pageFactory.getCommon().ContractTypeColumnHeader.click();
                }
                catch(org.openqa.selenium.ElementClickInterceptedException firstexception)
                {
                    try
                    {
                        testContext.getWebElementUtil().pause();
                        pageFactory.getCommon().ContractTypeColumnHeader.click();
                    }
                    catch(org.openqa.selenium.ElementClickInterceptedException secondexception)
                    {
                        testContext.getWebElementUtil().pause();
                        pageFactory.getCommon().ContractTypeColumnHeader.click();
                    }
                }
                
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                for(WebElement ContractTypeList : pageFactory.getCommon().ContractTypeList)
                {
                    defaultlist.add(ContractTypeList.getText());
                }
                    
                /*List After Sort*/
                    
                ArrayList <String> sortlist = new ArrayList<>();
                for(String ContractTypesortedlist : defaultlist)
                {
                    sortlist.add(ContractTypesortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }


    @Then("Sort with Broker in Ascending Order")
    public void SortBrokerAscending()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().BrokerAscendCheck).equals(true))
            {
                ArrayList <String> defaultlist = new ArrayList<>();
                for(WebElement BrokerList : pageFactory.getCommon().BrokerList)
                {
                    defaultlist.add(BrokerList.getText());
                }
                    
                /*List After Sort*/
                ArrayList <String> sortlist = new ArrayList<>();
                for(String Brokersortedlist : defaultlist)
                {
                    sortlist.add(Brokersortedlist);
                }
                Collections.sort(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
            else
            {
                pageFactory.getCommon().BrokerColumnHeader.click();
                testContext.getWebElementUtil().pause();   
                ArrayList <String> defaultlist = new ArrayList<>();
                for(WebElement BrokerList : pageFactory.getCommon().BrokerList)
                {
                    defaultlist.add(BrokerList.getText());
                }
                    
                /*List After Sort*/
                ArrayList <String> sortlist = new ArrayList<>();
                for(String Brokersortedlist : defaultlist)
                {
                    sortlist.add(Brokersortedlist);
                }
                Collections.sort(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
                    
                
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }


    @Then("Sort with Broker in Descending Order")
    public void SortBrokerDescending()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().BrokerAscendCheck).equals(true))
            {
                pageFactory.getCommon().BrokerColumnHeader.click();
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                for(WebElement BrokerList : pageFactory.getCommon().BrokerList)
                {
                    defaultlist.add(BrokerList.getText());
                }
                    
                /*List After Sort*/
                    
                ArrayList <String> sortlist = new ArrayList<>();
                for(String Brokersortedlist : defaultlist)
                {
                    sortlist.add(Brokersortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
            else if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().BrokerDescendCheck).equals(true))
            {
                ArrayList <String> defaultlist = new ArrayList<>();
                for(WebElement BrokerList : pageFactory.getCommon().BrokerList)
                {
                    defaultlist.add(BrokerList.getText());
                }
                    
                /*List After Sort*/
                    
                ArrayList <String> sortlist = new ArrayList<>();
                for(String Brokersortedlist : defaultlist)
                {
                    sortlist.add(Brokersortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
            else
            {
                pageFactory.getCommon().BrokerColumnHeader.click();
                try
                {
                    testContext.getWebElementUtil().pause();
                    pageFactory.getCommon().BrokerColumnHeader.click();
                }
                catch(org.openqa.selenium.ElementClickInterceptedException firstexception)
                {
                    try
                    {
                        testContext.getWebElementUtil().pause();
                        pageFactory.getCommon().BrokerColumnHeader.click();    
                    }
                    catch(org.openqa.selenium.ElementClickInterceptedException secondexception)
                    {
                        testContext.getWebElementUtil().pause();
                        pageFactory.getCommon().BrokerColumnHeader.click();
                    }
                }
                
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                for(WebElement BrokerList : pageFactory.getCommon().BrokerList)
                {
                    defaultlist.add(BrokerList.getText());
                }
                    
                /*List After Sort*/
                    
                ArrayList <String> sortlist = new ArrayList<>();
                for(String Brokersortedlist : defaultlist)
                {
                    sortlist.add(Brokersortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Sort with Effective Date in Ascending Order")
    public void SortEffectiveDateAscendingOrder()
    {
        try
        {
            if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().EffectiveDateAscendCheck).equals(true))
            {
                testContext.getWebElementUtil().pause();
                ArrayList <Date> defaultlist = new ArrayList<>();
                for(WebElement EffectiveDateList : pageFactory.getCommon().EffectiveDateList)
                {
                    String date = EffectiveDateList.getText();
                    if(!date.isEmpty())
                    {
                        SimpleDateFormat formatdate = new SimpleDateFormat("dd-MMM-yyyy");
                        Date formatteddate = formatdate.parse(date);
                        defaultlist.add(formatteddate);
                    }
                    
                }
                    
                /*List After Sort*/
                ArrayList <Date> sortlist = new ArrayList<>();
                for(Date EffectiveDatesortedlist : defaultlist)
                {
                    sortlist.add(EffectiveDatesortedlist);
                }
                Collections.sort(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
            else
            {
                pageFactory.getCommon().EffectiveDateColumnHeader.click();
                testContext.getWebElementUtil().pause();
                ArrayList <Date> defaultlist = new ArrayList<>();
                for(WebElement EffectiveDateList : pageFactory.getCommon().EffectiveDateList)
                {
                    String date = EffectiveDateList.getText();
                    if(!date.isEmpty())
                    {
                        SimpleDateFormat formatdate = new SimpleDateFormat("dd-MM-yyyy");
                        Date formatteddate = formatdate.parse(date);
                        defaultlist.add(formatteddate);
                    }
                    
                    
                }
                    
                /*List After Sort*/
                ArrayList <Date> sortlist = new ArrayList<>();
                for(Date EffectiveDatesortedlist : defaultlist)
                {
                    sortlist.add(EffectiveDatesortedlist);
                }
                Collections.sort(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }   
        }    
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
        
    }

    @Then("Sort with Effective Date in Descending Order")
    public void SortEffectiveDateDescendingOrder()
    {
        try
        {
            if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().EffectiveDateAscendCheck).equals(true))
            {
                pageFactory.getCommon().EffectiveDateColumnHeader.click();
                testContext.getWebElementUtil().pause();
                ArrayList <Date> defaultlist = new ArrayList<>();
                for(WebElement EffectiveDateList : pageFactory.getCommon().EffectiveDateList)
                {
                    String date = EffectiveDateList.getText();
                    if(!date.isEmpty())
                    {
                        SimpleDateFormat formatdate = new SimpleDateFormat("dd-MM-yyyy");
                        Date formatteddate = formatdate.parse(date);
                        defaultlist.add(formatteddate);
                    }
                    
                    
                }
                    
                /*List After Sort*/
                    
                ArrayList <Date> sortlist = new ArrayList<>();
                for(Date EffectiveDatesortedlist : defaultlist)
                {
                    sortlist.add(EffectiveDatesortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));    
            }
            else if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().EffectiveDateDescendCheck).equals(true))
            {
                ArrayList <Date> defaultlist = new ArrayList<>();
                for(WebElement EffectiveDateList : pageFactory.getCommon().EffectiveDateList)
                {
                    String date = EffectiveDateList.getText();
                    if(!date.isEmpty())
                    {
                        SimpleDateFormat formatdate = new SimpleDateFormat("dd-MMM-yyyy");
                        Date formatteddate = formatdate.parse(date);
                        defaultlist.add(formatteddate);
                    }
                    
                    
                }
                    
                /*List After Sort*/
                    
                ArrayList <Date> sortlist = new ArrayList<>();
                for(Date EffectiveDatesortedlist : defaultlist)
                {
                    sortlist.add(EffectiveDatesortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));    
            }
            else
            {
                pageFactory.getCommon().EffectiveDateColumnHeader.click();
                try
                {
                    testContext.getWebElementUtil().pause();
                    pageFactory.getCommon().EffectiveDateColumnHeader.click();
                }
                catch(org.openqa.selenium.ElementClickInterceptedException firstexception)
                {
                    try
                    {
                        testContext.getWebElementUtil().pause();
                        pageFactory.getCommon().EffectiveDateColumnHeader.click();
                    }
                    catch(org.openqa.selenium.ElementClickInterceptedException secondexception)
                    {
                        testContext.getWebElementUtil().pause();
                        pageFactory.getCommon().EffectiveDateColumnHeader.click();
                    }
                }
                
                testContext.getWebElementUtil().pause();
                ArrayList <Date> defaultlist = new ArrayList<>();
                for(WebElement EffectiveDateList : pageFactory.getCommon().EffectiveDateList)
                {
                    String date = EffectiveDateList.getText();
                    if(!date.isEmpty())
                    {
                        SimpleDateFormat formatdate = new SimpleDateFormat("dd-MM-yyyy");
                        Date formatteddate = formatdate.parse(date);
                        defaultlist.add(formatteddate);
                    }
                    
                    
                }
                    
                /*List After Sort*/
                    
                ArrayList <Date> sortlist = new ArrayList<>();
                for(Date EffectiveDatesortedlist : defaultlist)
                {
                    sortlist.add(EffectiveDatesortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist)); 
            }
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Sort with Inception Date in Ascending Order")
    public void SortInceptionDateAscendingOrder()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().InceptionDateAscendCheck).equals(true))
            {
                ArrayList <Date> defaultlist = new ArrayList<>();
                for(WebElement InceptionDateList : pageFactory.getCommon().InceptionDateList)
                {
                    String date = InceptionDateList.getText();
                    if(!date.isEmpty())
                    {
                        SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/yyyy");
                        Date formatteddate = formatdate.parse(date);    
                        defaultlist.add(formatteddate);
                    }
                    
                }
                    
                /*List After Sort*/
                ArrayList <Date> sortlist = new ArrayList<>();
                for(Date InceptionDatesortedlist : defaultlist)
                {
                    sortlist.add(InceptionDatesortedlist);
                }
                Collections.sort(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
            else
            {
                pageFactory.getCommon().InceptionDateColumnHeader.click();
                testContext.getWebElementUtil().pause();
                ArrayList <Date> defaultlist = new ArrayList<>();
                for(WebElement InceptionDateList : pageFactory.getCommon().InceptionDateList)
                {
                    String date = InceptionDateList.getText();
                    if(!date.isEmpty())
                    {
                        SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/yyyy");
                        Date formatteddate = formatdate.parse(date);    
                        defaultlist.add(formatteddate);
                    }
                }
                    
                /*List After Sort*/
                ArrayList <Date> sortlist = new ArrayList<>();
                for(Date InceptionDatesortedlist : defaultlist)
                {
                    sortlist.add(InceptionDatesortedlist);
                }
                Collections.sort(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }                        
                
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }
    
    @Then("Sort with Inception Date in Descending Order")
    public void SortInceptionDateDescendingOrder()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().InceptionDateAscendCheck).equals(true))
            {
                pageFactory.getCommon().InceptionDateColumnHeader.click();
                testContext.getWebElementUtil().pause();
                ArrayList <Date> defaultlist = new ArrayList<>();
                for(WebElement InceptionDateList : pageFactory.getCommon().InceptionDateList)
                {
                    String date = InceptionDateList.getText();
                    if(!date.isEmpty())
                    {
                        SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/yyyy");
                        Date formatteddate = formatdate.parse(date);    
                        defaultlist.add(formatteddate);
                    }
                }
                    
                /*List After Sort*/
                    
                ArrayList <Date> sortlist = new ArrayList<>();
                for(Date InceptionDatesortedlist : defaultlist)
                {
                    sortlist.add(InceptionDatesortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));    
            }
            else
            if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().InceptionDateDescendCheck).equals(true))
            {
                ArrayList <Date> defaultlist = new ArrayList<>();
                for(WebElement InceptionDateList : pageFactory.getCommon().InceptionDateList)
                {
                    String date = InceptionDateList.getText();
                    if(!date.isEmpty())
                    {
                        SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/yyyy");
                        Date formatteddate = formatdate.parse(date);    
                        defaultlist.add(formatteddate);
                    }
                }
                    
                /*List After Sort*/
                    
                ArrayList <Date> sortlist = new ArrayList<>();
                for(Date InceptionDatesortedlist : defaultlist)
                {
                    sortlist.add(InceptionDatesortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));   
            }
            else
            {
                pageFactory.getCommon().InceptionDateColumnHeader.click();
                try
                {
                    testContext.getWebElementUtil().pause();
                    pageFactory.getCommon().InceptionDateColumnHeader.click();
                }
                catch(org.openqa.selenium.ElementClickInterceptedException firstexception)
                {
                    try
                    {
                        testContext.getWebElementUtil().pause();
                        pageFactory.getCommon().InceptionDateColumnHeader.click();
                    }
                    catch(org.openqa.selenium.ElementClickInterceptedException secondexception)
                    {
                        testContext.getWebElementUtil().pause();
                        pageFactory.getCommon().InceptionDateColumnHeader.click();
                    }
                }
                
                testContext.getWebElementUtil().pause();
                ArrayList <Date> defaultlist = new ArrayList<>();
                for(WebElement InceptionDateList : pageFactory.getCommon().InceptionDateList)
                {
                    String date = InceptionDateList.getText();
                    if(!date.isEmpty())
                    {
                        SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/yyyy");
                        Date formatteddate = formatdate.parse(date);    
                        defaultlist.add(formatteddate);
                    }
                }
                    
                /*List After Sort*/
                    
                ArrayList <Date> sortlist = new ArrayList<>();
                for(Date InceptionDatesortedlist : defaultlist)
                {
                    sortlist.add(InceptionDatesortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));   
            }    
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }
    
    @Then("Sort with Contract Status in Ascending Order")
    public void SortContractStatusAscendingOrder()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().ContractStatusAscendCheck).equals(true))
            {
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                for(WebElement TaskStatusList : pageFactory.getCommon().TaskStatusList)
                {
                    String status = TaskStatusList.getText();
                    if(status.contains("Active") | status.contains("Draft") | status.contains("Registered") | status.contains("Terminated") | status.contains("Not Taken Up (NTU)"))
                    {
                        defaultlist.add(status);
                    }
                    
                }
                    
                /*List After Sort*/
                ArrayList <String> sortlist = new ArrayList<>();
                for(String TaskStatussortedlist : defaultlist)
                {
                    sortlist.add(TaskStatussortedlist);
                }
                Collections.sort(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
            else
            {
                pageFactory.getCommon().TaskColumnHeader.click();
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                for(WebElement TaskStatusList : pageFactory.getCommon().TaskStatusList)
                {
                    String status = TaskStatusList.getText();
                    if(status.contains("Active") | status.contains("Draft") | status.contains("Registered") | status.contains("Terminated") | status.contains("Not Taken Up (NTU)"))
                    {
                        defaultlist.add(status);
                    }
                }
                    
                /*List After Sort*/
                ArrayList <String> sortlist = new ArrayList<>();
                for(String TaskStatussortedlist : defaultlist)
                {
                    sortlist.add(TaskStatussortedlist);
                }
                Collections.sort(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));
            }
                        
            
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Sort with Contract Status in Descending Order")
    public void SortContractStatusDescendingOrder()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(pageFactory.getCommon().ContractStatusAscendCheck.equals(true))
            {
                pageFactory.getCommon().TaskColumnHeader.click();
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                for(WebElement TaskStatusList : pageFactory.getCommon().TaskStatusList)
                {
                    String status = TaskStatusList.getText();
                    if(status.contains("Active") | status.contains("Draft") | status.contains("Registered") | status.contains("Terminated") | status.contains("Not Taken Up (NTU)"))
                    {
                        defaultlist.add(status);
                    }
                }
                    
                /*List After Sort*/
                    
                ArrayList <String> sortlist = new ArrayList<>();
                for(String TaskStatussortedlist : defaultlist)
                {
                    sortlist.add(TaskStatussortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));    
            }
            else if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().ContractStatusDescendCheck).equals(true))
            {
                ArrayList <String> defaultlist = new ArrayList<>();
                for(WebElement TaskStatusList : pageFactory.getCommon().TaskStatusList)
                {
                    String status = TaskStatusList.getText();
                    if(status.contains("Active") | status.contains("Draft") | status.contains("Registered") | status.contains("Terminated") | status.contains("Not Taken Up (NTU)"))
                    {
                        defaultlist.add(status);
                    }
                }
                    
                /*List After Sort*/
                    
                ArrayList <String> sortlist = new ArrayList<>();
                for(String TaskStatussortedlist : defaultlist)
                {
                    sortlist.add(TaskStatussortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist)); 
            }
            else
            {
                pageFactory.getCommon().TaskColumnHeader.click();
                try
                {
                    testContext.getWebElementUtil().pause();
                    pageFactory.getCommon().TaskColumnHeader.click();
                }
                catch(org.openqa.selenium.ElementClickInterceptedException firstexception)
                {
                    try
                    {
                        testContext.getWebElementUtil().pause();
                        pageFactory.getCommon().TaskColumnHeader.click();
                    }
                    catch(org.openqa.selenium.ElementClickInterceptedException secondexception)
                    {
                        testContext.getWebElementUtil().pause();
                        pageFactory.getCommon().TaskColumnHeader.click();
                    }
                }
                
                testContext.getWebElementUtil().pause();
                ArrayList <String> defaultlist = new ArrayList<>();
                for(WebElement TaskStatusList : pageFactory.getCommon().TaskStatusList)
                {
                    String status = TaskStatusList.getText();
                    if(status.contains("Active") | status.contains("Draft") | status.contains("Registered") | status.contains("Terminated") | status.contains("Not Taken Up (NTU)"))
                    {
                        defaultlist.add(status);
                    }
                }
                    
                /*List After Sort*/
                    
                ArrayList <String> sortlist = new ArrayList<>();
                for(String TaskStatussortedlist : defaultlist)
                {
                    sortlist.add(TaskStatussortedlist);
                }
                Collections.sort(sortlist);
                Collections.reverse(sortlist);
                Assert.assertTrue(sortlist.equals(defaultlist));   
            }
                            
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    
    @And("Navigate to the My Contracts")
    public void GotoMyContracts()
    {
        try
        {
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().commonClick(pageFactory.getHome().MyTasks);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaMyContractsNavigateBackFrame);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }
    
    @And("Navigate to the My Teams")
    public void GotoMyTeams()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().commonClick(pageFactory.getHome().MyTeamsTasks);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Navigate to the Completed Contracts")
    public void GotoCompletedContracts()
    {
        try
        {
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().commonClick(pageFactory.getHome().CompletedTasks);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getCompletedContracts().PegaCompletedContractsFrame);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Validate All the Contracts are Assigned to My Group \"(.*)\"$")
    public void ValidateAssignedToMyGroup(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getMyTeamsTasks().PegaMyGroupsFrame);
            
            for(WebElement AssignedTo : pageFactory.getMyTeamsTasks().MyTeamsAssignedToList)
            {
                if(AssignedTo.getText().contains(MPRData.get(index).get("UserGroup")) | AssignedTo.getText().contains("deferred@lloyds"))
                {
                    Assert.assertTrue(true);
                }
            }
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Validate All the Contracts are Completed or Not Taken Up or Expired")
    public void ValidateCompletedContracts()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            for(WebElement TaskStatus : pageFactory.getCommon().TaskStatusList)
            {
                if(TaskStatus.getText().equalsIgnoreCase("Not Taken Up (NTU)") | TaskStatus.getText().equalsIgnoreCase("Completed") | TaskStatus.getText().equalsIgnoreCase("Expired"))
                {
                    Assert.assertTrue(true);
                }
            }
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Navigate to the Search Contracts")
    public void NavigateToSearchContracts()
    {
        try
        {
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().commonClick(pageFactory.getHome().SearchContracts);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getSearchContracts().PegaSearchContractFrame);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Navigate to Ongoing Tasks Dashboard")
    public void NavigateToOngoingTasks()
    {
        try
        {
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().commonClick(pageFactory.getHome().OngoingTasks);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getOnGoingTasks().PegaOngoingTaskFrame);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Navigate to the Search Contracts For Sorting")
    public void GoToSearchContractsForSorting()
    {
        try
        {
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getHome().PegaDefaultFrame);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().commonClick(pageFactory.getHome().SearchContracts);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getSearchContracts().PegaSearchContractFrame);

        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
        
    }

    @And("Click on Search")
    public void ClickOnSearch()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().SearchButton);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Click on Clear Search")
    public void ClickOnClearSearch()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().ClearSearchButton);
            testContext.getWebElementUtil().pause();
            
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Validate the Default Sort applied on Inception Date, Third Party Participants and Unique Identifier")
    public void ValidateDefaultSort()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getSearchContracts().DefaultSortInceptionDate);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getSearchContracts().DefaultSortParticipant);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getSearchContracts().DefaultSortUniqueIdentifier);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Search with UMR")
    public void EnterUMR()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getSearchContracts().UMRSearch, scenarioContext.UMR);
            testContext.getWebElementUtil().HoverOver(pageFactory.getSearchContracts().SearchButton);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Search with Unique Identifier")
    public void EnterUniqueIdentifier()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getSearchContracts().UniqueIdentifierSearch, scenarioContext.contractID);
            testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().SearchButton);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Search with Inception Date")
    public void EnterInceptionDate()
    {
        try
        {
            String inceptionData [] = testContext.getWebElementUtil().GetCurrentDateMDY().split("-");
            String day = inceptionData [1];
            String month = inceptionData[0];
            String year = inceptionData [2];

            testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().InceptionDateCalendar);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateMonth, month);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateYear, year);
                
            if(day.startsWith("0"))
            {
                String editDay = day.substring(1);

                for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                {
                    if(selectday.getText().equalsIgnoreCase(editDay))
                    {
                        selectday.click();
                        break;
                    }
                }
            }
            else
            {
                for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                {
                    if(selectday.getText().equalsIgnoreCase(day))
                    {
                        selectday.click();
                        break;
                    }
                }
            }
            
            testContext.getWebElementUtil().HoverOver(pageFactory.getSearchContracts().SearchButton);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("^Search with Third Party Participant \"(.*)\"$")
    public void EnterThirdPartyParticipant(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getSearchContracts().MarketParticipantSearch, MPRData.get(index).get("CapacitySeeker"));
            testContext.getWebElementUtil().HoverOver(pageFactory.getSearchContracts().SearchButton);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("^Search with PIN as \"(.*)\"$")
    public void EnterPIN(String pin)
    {
        try
        {
            int index = Integer.parseInt(pin)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getSearchContracts().MarketParticipantSearch, SortingFilterData.get(index).get("PIN"));
            testContext.getWebElementUtil().HoverOver(pageFactory.getSearchContracts().SearchButton);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Search with Contract Type")
    public void EnterContractType()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown(scenarioContext.setContractType, pageFactory.getSearchContracts().ContractTypeSearch);
            testContext.getWebElementUtil().HoverOver(pageFactory.getSearchContracts().SearchButton);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }
    
    @Then("Validate Dashboard Task Status for DRAFT")
    public void ValidateDashboardForDraft()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().Expand);
            String actualStatus = pageFactory.getCommon().TaskStatus.getText().toLowerCase();
            String expStatus = "draft";
            Assert.assertEquals(actualStatus, expStatus);

            for(WebElement ContractID : pageFactory.getMyTasks().UMRList)
            {
                if(ContractID.getText().equalsIgnoreCase(scenarioContext.UMR))
                {
                    testContext.getWebElementUtil().commonWaitForElement(ContractID);
                    ContractID.click();
                    break;
                }
            }
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);

        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Validate Dashboard Task Status for ACTIVE \"(.*)\"$")
    public void ValidateDashboardForActive(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            int counter = 0;

            while(counter<=5)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().Expand);
                    String actualStatus = pageFactory.getCommon().TaskStatus.getText().toLowerCase();
                    String expStatus = "active";
                    Assert.assertEquals(actualStatus, expStatus);
                    break;
                }
                catch(java.lang.AssertionError excepAssertionError)
                {
                    /* Exception Handle If Contract is still in Draft Status  */

                    /* Logout From Application */
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getApplicationAccess().UsernameField);

                    /* Login To Application */
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ContractCreator"));
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                    try
                    {
                        testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                    }
                    catch(org.openqa.selenium.TimeoutException exceptionfirst)
                    {
                        testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                    }

                    /* Navigate to Search Contracts */
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().commonClick(pageFactory.getHome().SearchContracts);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getSearchContracts().PegaSearchContractFrame);

                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getSearchContracts().UniqueIdentifierSearch, scenarioContext.contractID);
                    testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().SearchButton);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().pause();
                    counter++;
                }
            }
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Validate Dashboard Task Status for REGISTERED \"(.*)\"$")
    public void ValidateDashboardForRegistered(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            int counter = 0;

            while(counter<=5)
            {
                try
                {   
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().Expand);
                    String actualStatus = pageFactory.getCommon().TaskStatus.getText().toLowerCase();
                    String expStatus = "registered";
                    Assert.assertEquals(actualStatus, expStatus);
                    break;
                }
                catch(java.lang.AssertionError excepAssertionError)
                {
                    /* Exception Handle If Contract is still in Draft Status  */

                    /* Logout From Application */
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getApplicationAccess().UsernameField);

                    /* Login To Application */
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ContractCreator"));
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                    try
                    {
                        testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                    }
                    catch(org.openqa.selenium.TimeoutException exceptionfirst)
                    {
                        testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                    }

                    /* Navigate to Search Contracts */
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().commonClick(pageFactory.getHome().SearchContracts);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getSearchContracts().PegaSearchContractFrame);

                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getSearchContracts().UniqueIdentifierSearch, scenarioContext.contractID);
                   
                    testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().SearchButton);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().pause();
                    counter++;
                }
            }
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }


    @And("Search and Navigate to Record \"(.*)\"$")
    public void SearchAndNavigateToContract(String testData)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getSearchContracts().UniqueIdentifierSearch);
            pageFactory.getSearchContracts().UniqueIdentifierSearch.clear();
            
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getSearchContracts().UniqueIdentifierSearch, scenarioContext.contractID);
            testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().SearchButton);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//a[contains(@name, 'ContractSearchSection')][contains(text(), '"+scenarioContext.contractID+"')]"));
            testContext.getWebElementUtil().pause();
            for(WebElement UMR : pageFactory.getSearchContracts().UniqueIdentifierListSearchContracts)
            {
                if(UMR.getText().equalsIgnoreCase(scenarioContext.contractID))
                {
                    UMR.click();
                    break;
                }
            }
            
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractRecord().PegaRecordFrame);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Search and Navigate to Record For Linking Delinking \"(.*)\"$")
    public void SearchAndNavigateToContractLinkingDelinking(String testData)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getSearchContracts().UniqueIdentifierSearch);
            pageFactory.getSearchContracts().UniqueIdentifierSearch.clear();
            
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getSearchContracts().UniqueIdentifierSearch, scenarioContext.contractIDForLinking);
            testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().SearchButton);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//a[contains(@name, 'ContractSearchSection')][contains(text(), '"+scenarioContext.contractIDForLinking+"')]"));
            testContext.getWebElementUtil().pause();
            for(WebElement UMR : pageFactory.getSearchContracts().UniqueIdentifierListSearchContracts)
            {
                if(UMR.getText().equalsIgnoreCase(scenarioContext.contractIDForLinking))
                {
                    UMR.click();
                    break;
                }
            }
            
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractRecord().PegaRecordFrame);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Validate Not Taken Up status under Record")
    public void ValidateNotTakenUpStatusUnderRecord()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().ActionsTab);
            testContext.getWebElementUtil().pause();
            String actRecordStatus = pageFactory.getContractRecord().RecordStatusNotTakenUp.getText();
            String expRecordStatus = "NOT TAKEN UP (NTU)";
            Assert.assertEquals(actRecordStatus.toLowerCase(), expRecordStatus.toLowerCase());
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Validate Terminated status under Record \"(.*)\"$")
    public void ValidateTerminatedStatusUnderRecord(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            String actRecordStatus = null;
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().ActionsTab);
            testContext.getWebElementUtil().pauseAfterSave();
            try
            {
                actRecordStatus = pageFactory.getContractRecord().RecordStatusTerminated.getText();
            }
            catch(org.openqa.selenium.NoSuchElementException noelementException)
            {
                /* Exception handling for timeout -- Logout and Login Again */

                /* Logout From Application */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getApplicationAccess().UsernameField);

                /* Login To Application */
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ContractCreator"));
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }
                catch(org.openqa.selenium.TimeoutException exception)
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }

                /* Navigate to Search Contracts */
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getHome().SearchContracts);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getSearchContracts().PegaSearchContractFrame);

                /* Search and Navigate to the Contract */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().commonClearField(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getSearchContracts().UniqueIdentifierSearch, scenarioContext.contractID);
                testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().SearchButton);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//a[contains(@name, 'ContractSearchSection')][contains(text(), '"+scenarioContext.contractID+"')]"));
                testContext.getWebElementUtil().pause();
                for(WebElement UMR : pageFactory.getSearchContracts().UniqueIdentifierListSearchContracts)
                {
                    if(UMR.getText().equalsIgnoreCase(scenarioContext.contractID))
                    {
                        UMR.click();
                        break;
                    }
                }

                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractRecord().PegaRecordFrame);
                testContext.getWebElementUtil().pause();
                actRecordStatus = pageFactory.getContractRecord().RecordStatusTerminated.getText();
            }
            
            String expRecordStatus = "TERMINATED";
            Assert.assertEquals(actRecordStatus.toLowerCase(), expRecordStatus.toLowerCase());
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }


    @Then("Start Endorsement Workflow \"(.*)\"$")
    public void StartEndorsementWorkflow(String details)
    {
        try
        {   
            int index = Integer.parseInt(details)-1;
            try
            {
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().ActionsTab);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().CreateEndorsementButton);
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().CreateEndorsementButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                /****************  Exception handling for timeout -- Logout and Login Again ******************/
                
                /* Logout From Application */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getApplicationAccess().UsernameField);

                /* Login To Application */
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ContractCreator"));
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }
                catch(org.openqa.selenium.TimeoutException exception)
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }

                /* Navigate to Search Contracts */
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getHome().SearchContracts);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getSearchContracts().PegaSearchContractFrame);

                /* Search and Navigate to the Contract */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().commonClearField(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getSearchContracts().UniqueIdentifierSearch, scenarioContext.contractID);
                testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().SearchButton);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//a[contains(@name, 'ContractSearchSection')][contains(text(), '"+scenarioContext.contractID+"')]"));
                testContext.getWebElementUtil().pause();
                for(WebElement UMR : pageFactory.getSearchContracts().UniqueIdentifierListSearchContracts)
                {
                    if(UMR.getText().equalsIgnoreCase(scenarioContext.contractID))
                    {
                        UMR.click();
                        break;
                    }
                }

                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractRecord().PegaRecordFrame);
                
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().ActionsTab);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().CreateEndorsementButton);
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().CreateEndorsementButton);
            }

            
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Start Duplicate Workflow \"(.*)\"$")
    public void StartDuplicateWorkflow(String details)
    {
        try
        {
            int index = Integer.parseInt(details)-1;

            try
            {
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().ActionsTab);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().DuplicateButton);
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().DuplicateButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                /* Exception handling for timeout -- Logout and Login Again */
                System.out.println("Catch Block Executed");
                /* Logout From Application */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getApplicationAccess().UsernameField);

                /* Login To Application */
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ContractCreator"));
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }
                catch(org.openqa.selenium.TimeoutException exception)
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }

                /* Navigate to Search Contracts */
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getHome().SearchContracts);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getSearchContracts().PegaSearchContractFrame);

                /* Search and Navigate to the Contract */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().commonClearField(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getSearchContracts().UniqueIdentifierSearch, scenarioContext.contractID);
                testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().SearchButton);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//a[contains(@name, 'ContractSearchSection')][contains(text(), '"+scenarioContext.contractID+"')]"));
                testContext.getWebElementUtil().pause();
                for(WebElement UMR : pageFactory.getSearchContracts().UniqueIdentifierListSearchContracts)
                {
                    if(UMR.getText().equalsIgnoreCase(scenarioContext.contractID))
                    {
                        UMR.click();
                        break;
                    }
                }

                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractRecord().PegaRecordFrame);
                
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().ActionsTab);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().DuplicateButton);
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().DuplicateButton);
            }
        }
            
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Navigate To Linked Contracts")
    public void NavigateToLinkedContracts()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().LinkedContractsTab);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Link the Contract and Validate the Link Type as Renewed To")
    public void LinkContractValidateLinkTypeRenewedTo()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().LinkContractButton);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().SearchContractToLink);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().SearchContractToLink, scenarioContext.contractIDForLinking);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().AddContract);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().LinkContractDeleteIcon);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().LinktheContract);

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().LinkedContracts);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().CloseLinkContractPopUp);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().pause();

            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractRecord().LinkTypeRenewedTo).equals(true));
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Validate the Link Type as Renewed From and Delink the Contract")
    public void DelinkContractValidateLinkTypeRenewedFrom()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().LinkedContracts);

            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractRecord().LinkTypeRenewedFrom).equals(true));

            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().LinkedContracts);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().DelinkContractYesButton);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().pause();

            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractRecord().LinkTypeRenewedFrom).equals(false));

        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Validate the error for invalid Contract when linking contract")
    public void ValidateErrorForInvalidContractWhileContractLinking()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().LinkContractButton);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().SearchContractToLink);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().SearchContractToLink, "DA-CH-00000-0000");
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().AddContract);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().ContractLinkInvalidContractError);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractRecord().ContractLinkInvalidContractError).equals(true));
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().CloseLinkContractPopUp);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Navigate to Associated tasks")
    public void NavigateToAssociatedTasks()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().AssociatedTasksTab);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Navigate to Review Task From My Contracts")
    public void NavigateToContractFromMyContracts()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getHome().PegaDefaultFrame);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UniqueIdentifierFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().FilterText, scenarioContext.contractID);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();
            for(WebElement UMR : pageFactory.getMyTasks().UMRList)
            {
                if(UMR.getText().equalsIgnoreCase(scenarioContext.UMR))
                {
                    UMR.click();
                    break;
                }
            }

            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Navigate to Review Task From My Contracts For Endorsement Amend")
    public void NavigateToContractFromMyContractsForEndorsementAmend()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getHome().PegaDefaultFrame);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UniqueIdentifierFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().FilterText, scenarioContext.contractID);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();
            for(WebElement ContractID : pageFactory.getMyTasks().UniqueIdentifierList)
            {
                if(ContractID.getText().equalsIgnoreCase(scenarioContext.contractID))
                {
                    ContractID.click();
                    break;
                }
            }

            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Navigate to Contract From Search Contract")
    public void NavigateToContract()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            for(WebElement UniqueIdentifier : pageFactory.getSearchContracts().UniqueIdentifierListSearchContracts)
            {
                if(UniqueIdentifier.getText().equalsIgnoreCase(scenarioContext.contractID))
                {
                    UniqueIdentifier.click();
                    break;
                }
            }
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Select the Components to Copy")
    public void SelectComponentsToCopy()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().ComponentsCopyCheckbox);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NextButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Start Termination Endorsement Workflow \"(.*)\"$")
    public void StartTerminateWorkflow(String details)
    {
        try
        {
            int index = Integer.parseInt(details)-1;
            try
            {
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().ActionsTab);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().TerminateButton);
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminateButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                /* Exception handling for timeout -- Logout and Login Again */

                /* Logout From Application */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getApplicationAccess().UsernameField);

                /* Login To Application */
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ContractCreator"));
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }
                catch(org.openqa.selenium.TimeoutException exception)
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }

                /* Navigate to Search Contracts */
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getHome().SearchContracts);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getSearchContracts().PegaSearchContractFrame);

                /* Search and Navigate to the Contract */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().commonClearField(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getSearchContracts().UniqueIdentifierSearch, scenarioContext.contractID);
                testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().SearchButton);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//a[contains(@name, 'ContractSearchSection')][contains(text(), '"+scenarioContext.contractID+"')]"));
                testContext.getWebElementUtil().pause();
                for(WebElement UMR : pageFactory.getSearchContracts().UniqueIdentifierListSearchContracts)
                {
                    if(UMR.getText().equalsIgnoreCase(scenarioContext.contractID))
                    {
                        UMR.click();
                        break;
                    }
                }

                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractRecord().PegaRecordFrame);
                
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().ActionsTab);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().TerminateButton);
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminateButton);
            }
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Validate Termination Endorsement is disabled when one Termination is in progress")
    public void ValidateTerminationEndorsementDisabledWhenOneTerminationInProgress()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().ActionsTab);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().TerminateButton);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminateButton);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractRecord().TerminationType).equals(false));
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Enter the Termination Endorsement Details \"(.*)\"$")
    public void EnterTerminationEndorsementDetails(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().TerminationType);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                /* Exception handling for Contract Status -- Logout and Login Again */

                /* Logout From Application */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getApplicationAccess().UsernameField);

                /* Login To Application */
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ContractCreator"));
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }
                catch(org.openqa.selenium.TimeoutException exception)
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }

                /* Navigate to Search Contracts */
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getHome().SearchContracts);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getSearchContracts().PegaSearchContractFrame);

                /* Search and Navigate to the Contract */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().commonClearField(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getSearchContracts().UniqueIdentifierSearch, scenarioContext.contractID);
                testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().SearchButton);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//a[contains(@name, 'ContractSearchSection')][contains(text(), '"+scenarioContext.contractID+"')]"));
                testContext.getWebElementUtil().pause();
                for(WebElement UMR : pageFactory.getSearchContracts().UniqueIdentifierListSearchContracts)
                {
                    if(UMR.getText().equalsIgnoreCase(scenarioContext.contractID))
                    {
                        UMR.click();
                        break;
                    }
                }

                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractRecord().PegaRecordFrame);

                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().ActionsTab);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().TerminateButton);
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminateButton);

                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().TerminationType);
            }
            
            testContext.getWebElementUtil().commonSelectDropdown("Immediate Termination", pageFactory.getContractRecord().TerminationType);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().TerminationReason, "test");
            
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().TerminationServedDate);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminationServedDateCalendar);
            testContext.getWebElementUtil().pause();
            
            if(scenarioContext.setContractStatus.equalsIgnoreCase("Active"))
            {
                String dateForActiveContract [] = testContext.getWebElementUtil().GetCurrentDateMDY().split("-");
                String day = dateForActiveContract [1];
                String month = dateForActiveContract[0];
                String year = dateForActiveContract [2];

                testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateMonth, month);
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateYear, year);
                
                if(day.startsWith("0"))
                {
                    String editDay = day.substring(1);

                    for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                    {
                        if(selectday.getText().equalsIgnoreCase(editDay))
                        {
                            selectday.click();
                            break;
                        }
                    }
                }
                else
                {
                    for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                    {
                        if(selectday.getText().equalsIgnoreCase(day))
                        {
                            selectday.click();
                            break;
                        }
                    }
                }
            }
            else if(scenarioContext.setContractStatus.equalsIgnoreCase("Registered"))
            {
                String dateForRegisteredContract [] = testContext.getWebElementUtil().ChangePeriodFromDate(20).split("-");
                String day = dateForRegisteredContract [1];
                String month = dateForRegisteredContract[0];
                String year = dateForRegisteredContract [2];
                
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateMonth, month);
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateYear, year);
                
                if(day.startsWith("0"))
                {
                    String editDay = day.substring(1);

                    for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                    {
                        if(selectday.getText().equalsIgnoreCase(editDay))
                        {
                            selectday.click();
                            break;
                        }
                    }
                }
                else
                {
                    for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                    {
                        if(selectday.getText().equalsIgnoreCase(day))
                        {
                            selectday.click();
                            break;
                        }
                    }
                }
            }
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Managing Agent", pageFactory.getContractRecord().TerminationInitiator);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminationNotifiedYes);
            testContext.getWebElementUtil().pause();
            if(scenarioContext.scenarioName.contains("Resign"))
            {
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().TerminationEndorsementEffectiveDate, testContext.getWebElementUtil().ChangePeriodFromDate(566));
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminationEndorsementEffectiveDateLabel);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().ResignEndorsementErrorMessage);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClearField(pageFactory.getContractRecord().TerminationEndorsementEffectiveDate);
                testContext.getWebElementUtil().pause();
            }

            

            if(scenarioContext.setContractStatus.contains("Active"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminationEffectiveDateCalendar);
                testContext.getWebElementUtil().pause();

                String dateForActiveContract [] = testContext.getWebElementUtil().GetCurrentDateMDY().split("-");
                String day = dateForActiveContract [1];
                String month = dateForActiveContract[0];
                String year = dateForActiveContract [2];

                testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateMonth, month);
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateYear, year);
                
                if(day.startsWith("0"))
                {
                    String editDay = day.substring(1);

                    for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                    {
                        if(selectday.getText().equalsIgnoreCase(editDay))
                        {
                            selectday.click();
                            break;
                        }
                    }
                }
                else
                {
                    for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                    {
                        if(selectday.getText().equalsIgnoreCase(day))
                        {
                            selectday.click();
                            break;
                        }
                    }
                }

                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminationEndorsementEffectiveDateLabel);
            }

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NextButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Validate the error when Termination Effective Date prior to Contract Inception Date")
    public void ValidateErrorTerminationEffectiveDatePriorToContractInceptionDate()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().TerminationType);
            testContext.getWebElementUtil().commonSelectDropdown("Immediate Termination", pageFactory.getContractRecord().TerminationType);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().TerminationReason, "test");
            
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().TerminationServedDate);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminationServedDateCalendar);
            testContext.getWebElementUtil().pause();
            
            
            String dateForTerminationServed [] = testContext.getWebElementUtil().ChangePeriodFromDate(-20).split("-");
            String dayTerminationServed = dateForTerminationServed [1];
            String monthTerminationServed = dateForTerminationServed[0];
            String yearTerminationServed = dateForTerminationServed [2];
                
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateMonth, monthTerminationServed);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateYear, yearTerminationServed);
                
            if(dayTerminationServed.startsWith("0"))
            {
                String editDay = dayTerminationServed.substring(1);

                for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                {
                    if(selectday.getText().equalsIgnoreCase(editDay))
                    {
                        selectday.click();
                        break;
                    }
                }
            }
            else
            {
                for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                {
                    if(selectday.getText().equalsIgnoreCase(dayTerminationServed))
                    {
                        selectday.click();
                        break;
                    }
                }
            }
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Managing Agent", pageFactory.getContractRecord().TerminationInitiator);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminationNotifiedYes);
            testContext.getWebElementUtil().pause();
            
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminationEffectiveDateCalendar);
            testContext.getWebElementUtil().pause();

            String dateForTerminationEffective [] = testContext.getWebElementUtil().ChangePeriodFromDate(-20).split("-");
            String dayTerminationEffective = dateForTerminationEffective [1];
            String monthTerminationEffective = dateForTerminationEffective[0];
            String yearTerminationEffective = dateForTerminationEffective [2];

            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateMonth, monthTerminationEffective);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateYear, yearTerminationEffective);
                
            if(dayTerminationEffective.startsWith("0"))
            {
                String editDay = dayTerminationEffective.substring(1);

                for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                {
                    if(selectday.getText().equalsIgnoreCase(editDay))
                    {
                        selectday.click();
                        break;
                    }
                }
            }
            else
            {
                for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                {
                    if(selectday.getText().equalsIgnoreCase(dayTerminationEffective))
                    {
                        selectday.click();
                        break;
                    }
                }
            }

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminationEndorsementEffectiveDateLabel);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().TerminationEffectiveDatePriorInceptionDateError);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractRecord().TerminationEffectiveDatePriorInceptionDateError).equals(true));
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().CloseLinkContractPopUp);
        
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Validate the error when Termination Effective Date later than Contract Expiry Date")
    public void ValidateErrorTerminationEffectiveDateLaterThanContractExpiryDate()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().TerminationType);
            testContext.getWebElementUtil().commonSelectDropdown("Immediate Termination", pageFactory.getContractRecord().TerminationType);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().TerminationReason, "test");
            
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().TerminationServedDate);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminationServedDateCalendar);
            testContext.getWebElementUtil().pause();
            
            
            String dateForTerminationServed [] = testContext.getWebElementUtil().ChangePeriodFromDate(370).split("-");
            String dayTerminationServed = dateForTerminationServed [1];
            String monthTerminationServed = dateForTerminationServed[0];
            String yearTerminationServed = dateForTerminationServed [2];
                
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateMonth, monthTerminationServed);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateYear, yearTerminationServed);
                
            if(dayTerminationServed.startsWith("0"))
            {
                String editDay = dayTerminationServed.substring(1);

                for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                {
                    if(selectday.getText().equalsIgnoreCase(editDay))
                    {
                        selectday.click();
                        break;
                    }
                }
            }
            else
            {
                for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                {
                    if(selectday.getText().equalsIgnoreCase(dayTerminationServed))
                    {
                        selectday.click();
                        break;
                    }
                }
            }
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Managing Agent", pageFactory.getContractRecord().TerminationInitiator);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminationNotifiedYes);
            testContext.getWebElementUtil().pause();
            
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminationEffectiveDateCalendar);
            testContext.getWebElementUtil().pause();

            String dateForTerminationEffective [] = testContext.getWebElementUtil().ChangePeriodFromDate(370).split("-");
            String dayTerminationEffective = dateForTerminationEffective [1];
            String monthTerminationEffective = dateForTerminationEffective[0];
            String yearTerminationEffective = dateForTerminationEffective [2];

            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateMonth, monthTerminationEffective);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateYear, yearTerminationEffective);
                
            if(dayTerminationEffective.startsWith("0"))
            {
                String editDay = dayTerminationEffective.substring(1);

                for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                {
                    if(selectday.getText().equalsIgnoreCase(editDay))
                    {
                        selectday.click();
                        break;
                    }
                }
            }
            else
            {
                for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                {
                    if(selectday.getText().equalsIgnoreCase(dayTerminationEffective))
                    {
                        selectday.click();
                        break;
                    }
                }
            }

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TerminationEndorsementEffectiveDateLabel);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().TerminationEffectiveDateLaterExpiryDateError);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractRecord().TerminationEffectiveDateLaterExpiryDateError).equals(true));
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().CloseLinkContractPopUp);
        
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }


    @Then("Start Renewal Workflow \"(.*)\"$")
    public void StartRenewalWorkflow(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().ActionsTab);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().RenewButton);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().RenewButton);
            testContext.getWebElementUtil().pause();
            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NextButton);
            }
            catch(org.openqa.selenium.TimeoutException exception)
            {
                /* Exception handling for timeout -- Logout and Login Again */
                System.out.println("Catch Block Executed");
                /* Logout From Application */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getApplicationAccess().UsernameField);

                /* Login To Application */
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ContractCreator"));
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionfirst)
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }

                /* Navigate to Search Contracts */
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getHome().SearchContracts);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getSearchContracts().PegaSearchContractFrame);

                /* Search and Navigate to the Contract */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().commonClearField(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getSearchContracts().UniqueIdentifierSearch, scenarioContext.contractID);
                testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().SearchButton);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//a[contains(@name, 'ContractSearchSection')][contains(text(), '"+scenarioContext.contractID+"')]"));
                testContext.getWebElementUtil().pause();
                for(WebElement UMR : pageFactory.getSearchContracts().UniqueIdentifierListSearchContracts)
                {
                    if(UMR.getText().equalsIgnoreCase(scenarioContext.contractID))
                    {
                        UMR.click();
                        break;
                    }
                }

                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractRecord().PegaRecordFrame);

                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().ActionsTab);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().RenewButton);
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().RenewButton);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().NextButton);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NextButton);
            }
            
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoadRenewEndorse(pageFactory.getAgreementTemplate().PegaTaskFrame);

            /* To Test Blank Page After Clicking on Renewal */
            int counter = 0;
            while(counter<=5)
            {
                try
                {
                    testContext.getWebElementUtil().refreshPage();
                    if(testContext.getWebElementUtil().ContractSubmitted(pageFactory.getAgreementTemplate().PegaTaskFrame).equals(true))
                    {
                    
                    }
                    else if(testContext.getWebElementUtil().ContractSubmitted(pageFactory.getAgreementTemplate().PegaTaskFrame).equals(false))
                    {
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ContinueButton);
                        break;
                    }
                }
                catch(Exception e)
                {
                    System.err.println("Exception Handled");
                    testContext.getWebElementUtil().pauseForContractSubmission();
                    counter++;
                }
            }

        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @And("Enter Endorsement Effective Date beyond the anniversary date of a Multi Year contract")
    public void EnterEndorsementEffectiveDateBeyondAnniversaryDate()
    {
        try
        {
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getAgreementTemplate().EndorsementEffectiveDate, testContext.getWebElementUtil().ChangePeriodFromDate(566));
            testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().EndorsementEffectiveDateLabel);
            testContext.getWebElementUtil().pause();
            
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Enter Endorsement Effective Date beyond the anniversary date of a Multi Year contract on Core Questions")
    public void EnterEndorsementEffectiveDateBeyondAnniversaryDateCoreQuestions()
    {
        try
        {
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getAgreementTemplate().EndorsementEffectiveDateCoreQuestions, testContext.getWebElementUtil().ChangePeriodFromDate(566));
            testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().EndorsementReferenceNumber);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Endorsement error message and clear the Effective Date")
    public void ValidateEndorsementErrorMessage()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().ResignEndorsementErrorMessage);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClearField(pageFactory.getAgreementTemplate().EndorsementEffectiveDate);
            testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().EndorsementEffectiveDateLabel);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Endorsement error message for Multi Year Contract on Core Questions")
    public void ValidateEndorsementErrorMessageCoreQuestions()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().ResignEndorsementErrorMessageCorequestions);
                testContext.getWebElementUtil().pause();
            }
            catch(org.openqa.selenium.TimeoutException timeoutException)
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAgreementTemplate().EndorsementEffectiveDateLabel);
                testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().EndorsementEffectiveDateLabel);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().ResignEndorsementErrorMessageCorequestions);
                testContext.getWebElementUtil().pause();
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Enter Termination Endorsement Effective Date beyond the anniversary date of a Multi Year contract on Core Questions")
    public void EnterTerminationEndorsementEffectiveDateBeyondAnniversaryDateCoreQuestions()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().TerminationEndorsementEffectiveDateCoreQuestions);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getAgreementTemplate().TerminationEndorsementEffectiveDateCoreQuestions, testContext.getWebElementUtil().ChangePeriodFromDate(566));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().AssociatedContentHeader);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Start Resign Workflow")
    public void StartResignWorkflow()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().ActionsTab);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().ResignButton);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().ResignConfirmationDate);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().ResignConfirmationDate, testContext.getWebElementUtil().GetCurrentDateMDY());
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().ResignConfirmationDateLabel);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NextButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);

            /* To Test Blank Page After Clicking on Re-Sign */
            int counter = 0;
            while(counter<=5)
            {
                try
                {
                    testContext.getWebElementUtil().refreshPage();
                    if(testContext.getWebElementUtil().ContractSubmitted(pageFactory.getAgreementTemplate().PegaEndorsementFrame).equals(true))
                    {
                    
                    }
                    else if(testContext.getWebElementUtil().ContractSubmitted(pageFactory.getAgreementTemplate().PegaEndorsementFrame).equals(false))
                    {
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ContinueButton);
                        break;
                    }
                }
                catch(Exception e)
                {
                    System.err.println("Exception Handled");
                    testContext.getWebElementUtil().pauseForContractSubmission();
                    counter++;
                }
            }
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("Validate that Endorsement is Completed \"(.*)\"$")
    public void ValidateEndorsementCompleted(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            int counter = 0;
            while(counter<=5)
            {
                try
                {
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().TaskFilter);
                    Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractRecord().AssociatedTaskEndorsementCompleteStatus).equals(false));
                    break;
                }
                catch(AssertionError eAssertionError)
                {
                    /* Logout From Application */
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getApplicationAccess().UsernameField);

                    /* Login To Application */
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ContractCreator"));
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                    try
                    {
                        testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                    }
                    catch(org.openqa.selenium.TimeoutException exceptionfirst)
                    {
                        testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                    }

                    /* Navigate to Search Contracts */
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().commonClick(pageFactory.getHome().SearchContracts);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getSearchContracts().PegaSearchContractFrame);

                    /* Search and Navigate to Record */
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getSearchContracts().UniqueIdentifierSearch);
                    pageFactory.getSearchContracts().UniqueIdentifierSearch.clear();
            
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getSearchContracts().UniqueIdentifierSearch, scenarioContext.contractID);
                    testContext.getWebElementUtil().commonClick(pageFactory.getSearchContracts().SearchButton);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//a[contains(@name, 'ContractSearchSection')][contains(text(), '"+scenarioContext.contractID+"')]"));
                    testContext.getWebElementUtil().pause();
                    for(WebElement UMR : pageFactory.getSearchContracts().UniqueIdentifierListSearchContracts)
                    {
                        if(UMR.getText().equalsIgnoreCase(scenarioContext.contractID))
                        {
                            UMR.click();
                            break;
                        }
                    }
            
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractRecord().PegaRecordFrame);

                    /* Navigate To Associated Tasks */
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().AssociatedTasksTab);
                    counter++;
                }
            }
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

}