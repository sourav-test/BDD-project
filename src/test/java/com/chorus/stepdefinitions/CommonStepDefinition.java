package com.chorus.stepdefinitions;

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
import io.cucumber.java.en.When;

/**
* Common Step Definition
* Common Steps for All Scenarios
* 
*/

public class CommonStepDefinition {

    private List<HashMap<String, String>> MPRData;

    private List<HashMap<String, String>> NonMPRData;

    private TestContext testContext;

    private ScenarioContext scenarioContext;

    private PageFactoryController pageFactory;

    private FileReaderController fileReaderController;

    /**
     * This is a constructor which defines the Pico Container dependency
     * @param testContext
     * @param scenarioContext
     */
    
    public CommonStepDefinition(TestContext testContext, ScenarioContext scenarioContext) 
    {
        this.testContext=testContext;
        this.scenarioContext=scenarioContext;
        pageFactory = testContext.getPageFactoryController();
        fileReaderController = testContext.getFileReaderController();
        MPRData = testContext.getFileReaderController().getExcelReader().GetTestData("MPRData");
        NonMPRData = testContext.getFileReaderController().getExcelReader().GetTestData("NonMPRData");
    }

    /**
     * This method is used to click on Save Button
     */

    @And("Click on Save")
    public void ClickSave() 
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().SaveButton);
            testContext.getWebElementUtil().pause(); 
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to click on Next Button
     */

    @And("Click on Next")
    public void ClickNext() 
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NextButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Then("Browser Warning Message Appeared")
    public void BowserWarning() 
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().AcceptAlert();
            
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to navigate to My Contracts or My Tasks
     * from Home Page
     */

    @And("Navigate to My Contracts")
    public void navigatetohome() 
    {
        try
        {
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().commonClick(pageFactory.getHome().HomePageLink);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getHome().HomePageLink);
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getHome().PegaDefaultFrame);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to refresh My Contracts or My Tasks
     * dashboard by clicking on Refresh button
     */

    @And("Refresh the MyContracts List")
    public void ClickRefreshList() 
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().RefreshListButton);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to click on Begin button
     * on Review Harness page
     */

    @When("I Click on Begin")
    public void ClickBegin() 
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BeginButton);
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to click on Assign To Me button
     * on Review Harness page
     */

    @Then("Click on Assign To Me")
    public void ClickAssignToMe() 
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().AssignToMeButton);
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to click on OK button
     */

    @Then("Click OK")
    public void ClickOK() 
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().OKButton);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to click on Continue button
     */

    @Then("Click Continue")
    public void ClickContinue() 
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to click on Submit for Review
     * button on Actions tab
     */

    @Then("Click on Submit For Review")
    public void ClickSubmitForReview() 
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().SubmitForReviewButton);
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SubmitForReviewOKButton);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to select Not Taken Up option
     * under Actions Menu
     */

    @Then("Select Not Taken Up")
    public void ClickActions() 
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsNotTakenUp);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ActionsNotTakenUp);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ConfirmButton);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ConfirmButton);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to click on Back button
     */
    
    @And("Click on Back")
    public void ClickOnBack() 
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate the absence of
     * System Notification for Contract Registration
     */

    @Then("Validate Absence of System Notification for Contract Registered")
    public void ValidateNotificationForRegsiteredStatusIsNotPresent() 
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NotificationIcon);
            testContext.getWebElementUtil().pause();
            
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().NotificationLabel);
            for(WebElement ContractNotification : pageFactory.getCommon().NotificationList)
            {
                if(ContractNotification.getText().contains("Your contract "+scenarioContext.contractID+" is now registered."))
                {
                    Assert.fail();
                }
            }
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate that the System
     * Notification is present for Contract Registration
     * for the Market Partcipants
     * @param testData = row number
     */

    @Then("Validate System Notification for Contract Completed \"(.*)\"$")
    public void ValidateNotificationForCompletedStatus(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NotificationIcon);
            testContext.getWebElementUtil().pause();
            
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().NotificationLabel);
            for(WebElement ContractNotification : pageFactory.getCommon().NotificationList)
            {
                if(ContractNotification.getText().equalsIgnoreCase(MPRData.get(index).get("CapacitySeeker")+": "+scenarioContext.UMR+" – Contract has been registered"))
                {
                    Assert.assertTrue(ContractNotification.getText().contains(MPRData.get(index).get("CapacitySeeker")+": "+scenarioContext.UMR+" – Contract has been registered"));
                    break;
                }
            }
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate that the System
     * Notification is present for Contract Retracted
     * for the Market Partcipants
     * @param testData = row number
     */

    @Then("Validate System Notification for Contract Retracted \"(.*)\"$")
    public void ValidateNotificationForRetracted(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NotificationIcon);
            testContext.getWebElementUtil().pause();
           
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().NotificationLabel);
            for(WebElement ContractNotification : pageFactory.getCommon().NotificationList)
            {
                if(ContractNotification.getText().equalsIgnoreCase(MPRData.get(index).get("CapacitySeeker")+": "+scenarioContext.UMR+"– Assignment has been retracted"))
                {
                    Assert.assertTrue(ContractNotification.getText().contains(MPRData.get(index).get("CapacitySeeker")+": "+scenarioContext.UMR+"– Assignment has been retracted"));
                    break;
                }
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate the absence of System
     * Notification for Contract Registration for the Market 
     * Partcipants
     * @param testData = row number
     */

    @Then("Validate Absence of System Notification for Contract Completed \"(.*)\"$")
    public void ValidateNotificationForCompletedStatusIsNotPresent(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NotificationIcon);
            testContext.getWebElementUtil().pause();

            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().NotificationLabel);
            for(WebElement ContractNotification : pageFactory.getCommon().NotificationList)
            {
                if(ContractNotification.getText().equalsIgnoreCase(MPRData.get(index).get("CapacitySeeker")+": "+scenarioContext.UMR+" – Contract has been registered"))
                {
                    Assert.fail();
                }
            }
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate that the System
     * Notification is present for Review Task Returned
     * for the Market Partcipants
     * @param testData = row number
     */

    @Then("Validate System Notification for Review Tasks Returned \"(.*)\"$")
    public void ValidateNotificationForReturned(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NotificationIcon);
            testContext.getWebElementUtil().pause();
            
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().NotificationLabel);
            for(WebElement ContractNotification : pageFactory.getCommon().NotificationList)
            {
                if(ContractNotification.getText().contentEquals(MPRData.get(index).get("CapacitySeeker")+": "+scenarioContext.UMR+" – Task has been assigned to you"))
                {
                    Assert.assertTrue(ContractNotification.getText().contains(MPRData.get(index).get("CapacitySeeker")+": "+scenarioContext.UMR+" – Task has been assigned to you"));
                    break;
                }  
            }    
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate the absence of System
     * Notification for Review Task Returned for the Market 
     * Partcipants
     * @param testData = row number
     */

    @And("Validate Absence of System Notification for Review Tasks Returned \"(.*)\"$")
    public void ValidateNotificationForReturnedIsNotPresent(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NotificationIcon);
            testContext.getWebElementUtil().pause();
            
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().NotificationLabel);
            for(WebElement ContractNotification : pageFactory.getCommon().NotificationList)
            {
                if(ContractNotification.getText().contentEquals(MPRData.get(index).get("CapacitySeeker")+": "+scenarioContext.UMR+" – Task has been assigned to you"))
                {
                    Assert.fail();
                }
            }  
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    /**
     * This method is used to validate that the System
     * Notification is present for Review Task Approved for 
     * the Market Partcipants
     * @param testData = row number
     */

    @Then("Validate System Notification for Review Tasks Approved \"(.*)\"$")
    public void ValidateNotificationForApproved(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NotificationIcon);
            testContext.getWebElementUtil().pause();
            
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().NotificationLabel);
            for(WebElement ContractNotification : pageFactory.getCommon().NotificationList)
            {
                if(ContractNotification.getText().contains(MPRData.get(index).get("CapacitySeeker")+": "+scenarioContext.UMR+"– has been approved"))
                {
                    Assert.assertTrue(ContractNotification.getText().contains(MPRData.get(index).get("CapacitySeeker")+": "+scenarioContext.UMR+"– has been approved"));
                    break;
                }
            }
            
        }    
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate that the System
     * Notification is present for Review Task Created for 
     * the Market Partcipants
     * @param testData = row number
     */

    @Then("Validate System Notification for Review Tasks Created for Syndicate \"(.*)\"$")
    public void ValidateNotificationForReviewTaskCreatedForSyndicate(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NotificationIcon);
            testContext.getWebElementUtil().pause();
            
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().NotificationLabel);
            for(WebElement ContractNotification : pageFactory.getCommon().NotificationList)
            {
                if(ContractNotification.getText().contains(MPRData.get(index).get("CapacitySeeker")+": "+scenarioContext.UMR+"– Assignment has been Retracted"))
                {
                    Assert.assertTrue(ContractNotification.getText().contains(MPRData.get(index).get("CapacitySeeker")+": "+scenarioContext.UMR+"– Assignment has been Retracted"));
                    break;
                }
            }
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate the absence of System
     * Notification for Review Task Approved for the Market
     * Partcipants
     * @param testData = row number
     */
    
    @Then("Validate Absence of System Notification for Review Tasks Approved \"(.*)\"$")
    public void ValidateNotificationForApprovedIsNotPresent(String testData) 
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NotificationIcon);
            testContext.getWebElementUtil().pause();
            
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().NotificationLabel);
            for(WebElement ContractNotification : pageFactory.getCommon().NotificationList)
            {
                if(ContractNotification.getText().contains(MPRData.get(index).get("CapacitySeeker")+": "+scenarioContext.UMR+"– has been approved"))
                {
                    Assert.fail();
                }
            }
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate that the System
     * Notification is present for Disagreed Review Returned 
     * Task for the Market Partcipants
     * @param testData = row number
     */

    @Then("Validate System Notification for Review Tasks Disagreed \"(.*)\"$")
    public void ValidateNotificationForDisagreed(String testData) 
    {
        try
        {
            int index = Integer.parseInt(testData)-1;

            String brokerOperatorID [] = MPRData.get(index).get("ContractCreator").split("@");
            String brokerFirstName = brokerOperatorID[0];
            String brokerLastName = " AUTOTEST";
            String contractCreator = brokerFirstName.concat(brokerLastName);

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NotificationIcon);
            testContext.getWebElementUtil().pause();
            
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().NotificationLabel);
            for(WebElement ContractNotification : pageFactory.getCommon().NotificationList)
            {
                if(ContractNotification.getText().equalsIgnoreCase("Your review case "+scenarioContext.ReviewTaskNumber+" has been disagreed by "+contractCreator))
                {
                    Assert.assertTrue(ContractNotification.getText().contains("Your review case "+scenarioContext.ReviewTaskNumber+" has been disagreed by "+contractCreator));
                    break;
                }
            }
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Disable and Enable all
     * System Notifications Options for a user
     */

    @And("Opt In or Out All System Notifications")
    public void OptInOutAllSysNotif()
    {
        try
        {
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NotificationPreferencesLink);
            
            try
            {
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommon().ContractContractRegisteredSysNotif);
            }
            catch(org.openqa.selenium.TimeoutException exception)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContractNotifOptions);
            }

            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContractPastInceptionDateSysNotif);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContractTaskAssignedSysNotif);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContractTaskReAssignedSysNotif);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContractContractRegisteredSysNotif);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContractRetractSysNotif);
            testContext.getWebElementUtil().pause();

            try
            {
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommon().ReviewTaskApprovedSysNotif);
            }
            catch(org.openqa.selenium.TimeoutException exception)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ReviewNotifOptions);
            }

            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ReviewPastInceptionDateSysNotif);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ReviewTaskReAssignedSysNotif);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ReviewTaskApprovedSysNotif);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ReviewTaskReceivedSysNotif);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ReviewRetractSysNotif);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ReviewTaskReturnedSysNotif);

            try
            {
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommon().EndorsementTaskAssignedSysNotif);
            }
            catch(org.openqa.selenium.TimeoutException exception)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().EndorsementNotifOptions);
            }

            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().EndorsementPastInceptionDateSysNotif);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().EndorsementTaskAssignedSysNotif);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().EndorsementTaskReAssignedSysNotif);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().EndorsementRegisteredSysNotif);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().EndorsementRetractSysNotif);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().SubmitButton);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to get the Contract Creator
     * Name from the test data sheet
     * @param testData = row number
     */

    @And("Get Contract Creator Name \"(.*)\"$")
    public void GetContractCreator(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            String brokerOperatorID [] = MPRData.get(index).get("ContractCreator").split("@");
            String brokerFirstName = brokerOperatorID[0];
            String brokerLastName = " AUTOTEST";
            scenarioContext.ContractCreator = brokerFirstName.concat(brokerLastName);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to get the Managing
     * Agent Name from the test data sheet
     * @param testData = row number
     */

    @And("Get Managing Agent Name \"(.*)\"$")
    public void GetManagingAgentName(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            String managingAgentOperatorID [] = MPRData.get(index).get("ManagingAgentOperator").split("@");
            String managingAgentFirstName = managingAgentOperatorID[0];
            String managingAgentLastName = " AUTOTEST";
            scenarioContext.ManagingAgentUsername = managingAgentFirstName.concat(managingAgentLastName);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to get the Service
     * Company Name from the test data sheet
     * @param testData = row number
     */

    @And("Get Service Company Name \"(.*)\"$")
    public void GetServiceCompanyName(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            String serviceCompanyOperatorID [] = MPRData.get(index).get("ServiceCompanyOperator").split("@");
            String serviceCompanyFirstName = serviceCompanyOperatorID[0];
            String serviceCompanyLastName = " AUTOTEST";
            scenarioContext.ServiceCompanyUsername = serviceCompanyFirstName.concat(serviceCompanyLastName);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to get the Lloyds User
     * Name from the test data sheet
     * @param testData = row number
     */

    @And("Get Lloyds User Name \"(.*)\"$")
    public void GetLloydsUserName(String testData) {

        try
        {
            int index = Integer.parseInt(testData)-1;
            String lloydsUserOperatorID [] = MPRData.get(index).get("LloydsUser").split("Autotest");
            String lloydsUserFirstName = lloydsUserOperatorID[0];
            String lloydsUserLastName = " Autotest";
            scenarioContext.LloydsUserName = lloydsUserFirstName.concat(lloydsUserLastName);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Upload the Copy of Signed
     * Contract on Actions tab
     */

    @Then("Upload Copy of Signed Contract")
    public void UploadDocument() 
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UploadButton);   
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UploadButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UploadButton);
                }      
            }
            
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().AttachFileHeader);
            testContext.getWebElementUtil().pause();
            String projectdirectory = System.getProperty("user.dir");
            String filepath = projectdirectory+"\\src\\test\\resources\\TestData\\TestDocument.txt";
            testContext.getWebElementUtil().pause();

            pageFactory.getCommon().UploadPath.sendKeys(filepath);
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Fully Signed Contract", pageFactory.getCommon().SelectTag);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Medium", pageFactory.getCommon().Classification);

            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().AttachButton);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().DocumentSavedMessage);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate the error when
     * user is not selecting Tag for Signed Contract Upload
     * on Actions tab
     */

    @Then("Validate the error when user is not selecting tag on Document Upload modal")
    public void ValidateAfterNotSelectingTag()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UploadButton);   
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UploadButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UploadButton);
                }      
            }
            
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().AttachFileHeader);
            testContext.getWebElementUtil().pause();
            String projectdirectory = System.getProperty("user.dir");
            String filepath = projectdirectory+"\\src\\test\\resources\\TestData\\TestDocument.txt";
            testContext.getWebElementUtil().pause();

            pageFactory.getCommon().UploadPath.sendKeys(filepath);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Medium", pageFactory.getCommon().Classification);

            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().AttachButton);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().AcceptAlert();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().DocumentUploadCancelButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to enter the Order Hereon percentages
     * on Non Schedule Data tab
     */

    @Then("Enter Order Heron Percenatge")
    public void EnterOrderHeronPercenatge() 
    {
        try
        {
           try
            {
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().HereOnFirstPercentage, "20");
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().HereOnFirstPercentage, "20");
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().HereOnFirstPercentage, "20");
                }
                    
            }
            
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().HereOnSecondPercentage);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().HereOnSecondPercentage, "20");
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to remove Service Company from
     * Capacity Lead for Endorsement
     */

    @And("Remove a Participant from the Endorsement")
    public void RemoveParticipantFromEndorsement()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                }
            }
            
            /***  Delete Service Company as a Lead and check the access for the contract/endorsement  ***/

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CapacityDetailsTab);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().DeleteServiceCompanyIcon);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().AcceptAlert();

            /************************Edit The Signed Line Percentage of Previously Added Syndicate *************************/

            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine);
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClearField(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine);
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SelectedLeadSyndicate);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine, "100"); 
            
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to navigate from Agreement Template to General
     * Contract Information for Endorsement, Termination Endorsement, Renewal 
     * and Duplicate Contract Test Cases
     */

    @And("Navigate to General Contract Information From Agreement Template")
    public void NavigateToGeneralContractInformationFromAgreementTemplate()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ContinueButton);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ContinueButton);
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ContinueButton);
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                }
            }
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to navigate from Agreement Template to General
     * Contract Information for Endorsement, Termination Endorsement, Renewal 
     * and Duplicate Contract Test Cases
     */

    @And("Navigate to Broker Details From Agreement Template")
    public void NavigateToBrokerDetailsFromAgreementTemplate()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().AgreementNmbr);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().AgreementNmbr);
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    try
                    {
                        testContext.getWebElementUtil().refreshPage();
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().SwitchToDefault();
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().AgreementNmbr);
                        testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                    }
                    catch(org.openqa.selenium.TimeoutException exceptionthird)
                    {
                        testContext.getWebElementUtil().refreshPage();
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().SwitchToDefault();
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().AgreementNmbr);
                        testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                    }
                }
            }
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to navigate from Broker Details to Contract
     * Leads for Endorsement, Termination Endorsement, Renewal
     * and Duplicate Contract Test Cases
     */

    @And("Navigate to Contract Leads From Broker Details")
    public void NavigateToContractLeadsFromBrokerDetails()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getBrokerDetails().ContractMngrEmail);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getBrokerDetails().ContractMngrEmail);
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    try
                    {
                        testContext.getWebElementUtil().refreshPage();
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().SwitchToDefault();
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getBrokerDetails().ContractMngrEmail);
                        testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                    }
                    catch(org.openqa.selenium.TimeoutException exceptionthird)
                    {
                        testContext.getWebElementUtil().refreshPage();
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().SwitchToDefault();
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getBrokerDetails().ContractMngrEmail);
                        testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                    }
                }
            }   
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to navigate from Contract Leads to Section
     * Details for Endorsement, Termination Endorsement, Renewal
     * and Duplicate Contract Test Cases
     */
    
    @And("Navigate to Section Details From Contract Leads")
    public void NavigateToSectionDetailsFromContractLeads()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractLeads().LeadType);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractLeads().LeadType);
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    try
                    {
                        testContext.getWebElementUtil().refreshPage();
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().SwitchToDefault();
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractLeads().LeadType);
                        testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                    }
                    catch(org.openqa.selenium.TimeoutException exceptionthird)
                    {
                        testContext.getWebElementUtil().refreshPage();
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().SwitchToDefault();
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractLeads().LeadType);
                        testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                    }
                }
            }
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to navigate from Section Details to
     * Non Schedule for Endorsement, Termination Endorsement, Renewal
     * and Duplicate Contract Test Cases
     */

    @And("Navigate to Non Schedule From Section Details")
    public void NavigateToNonScheduleFromSectionDetails()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    try
                    {
                        testContext.getWebElementUtil().refreshPage();
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().SwitchToDefault();
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                        testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                    }
                    catch(org.openqa.selenium.TimeoutException exceptionthird)
                    {
                        testContext.getWebElementUtil().refreshPage();
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().SwitchToDefault();
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                        testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                    }
                }
            }
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to navigate from Non Schedule to
     * Actions for Endorsement, Termination Endorsement, Renewal
     * and Duplicate Contract Test Cases
     */

    @And("Navigate to Actions From Non Schedule")
    public void NavigateToActionsFromNonSchedule()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().HereOnFirstPercentage);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().HereOnFirstPercentage);
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    try
                    {
                        testContext.getWebElementUtil().refreshPage();
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().SwitchToDefault();
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().HereOnFirstPercentage);
                        testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                    }
                    catch(org.openqa.selenium.TimeoutException exceptionthird)
                    {
                        testContext.getWebElementUtil().refreshPage();
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().SwitchToDefault();
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().HereOnFirstPercentage);
                        testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                    }
                }
            }
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to navigate Back to Non Schedule
     * from Actions tab
     */

    @And("Navigate Back to Non Schedule from Actions")
    public void NavigateBackToNonScheduleFromActions()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().UploadButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().UploadButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().UploadButton);
                }
            }

            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to navigate Back to Section Details
     * from Non Schedule
     */

    @And("Navigate back to Section Details from Non Schedule")
    public void NavigateBackToSectionDetailsFromNonSchedule()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().HereOnFirstPercentage);  
            }
            catch(org.openqa.selenium.TimeoutException firstexception)
            {
                try
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().HereOnFirstPercentage);
                }
                catch(org.openqa.selenium.TimeoutException secondexception)
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().HereOnFirstPercentage);
                }
            }   

            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to navigate Back to Contract Leads
     * from Section Details
     */

    @And("Navigate back to Contract Leads from Section Details")
    public void NavigateBackToContractLeadsFromSectionDetails()
    {
        try
        {   
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
            }
            catch(org.openqa.selenium.TimeoutException firstexception)
            {
                try
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                }
                catch(org.openqa.selenium.TimeoutException secondexception)
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                }
            }

            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to navigate Back to Broker Details
     * from Contract Leads
     */

    @And("Navigate back to Broker Details from Contract Leads")
    public void NavigateBackToBrokerDetailsFromContractLeads()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractLeads().LeadType);
            }
            catch(org.openqa.selenium.TimeoutException firstexception)
            {
                try
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractLeads().LeadType);
                }
                catch(org.openqa.selenium.TimeoutException secondexception)
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractLeads().LeadType);
                }
            }

            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to navigate Back to General Contract
     * Information from Broker Details
     */

    @And("Navigate back to General Contract Information from Broker Details")
    public void NavigateBackToGeneralContractInformationFromBrokerDetails()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getBrokerDetails().ContractMngrEmail);
            }
            catch(org.openqa.selenium.TimeoutException firstexception)
            {
                try
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getBrokerDetails().ContractMngrEmail);
                }
                catch(org.openqa.selenium.TimeoutException secondexception)
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getBrokerDetails().ContractMngrEmail);
                }
            }

            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Edit the Territorial on Individual Section
     * for Endorsement
     */

    @And("Edit Territorial Limitations on Individual Section")
    public void EditTerritorialLimitationsIndividualSection()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    try
                    {
                        testContext.getWebElementUtil().refreshPage();
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().SwitchToDefault();
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                        testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                    }
                    catch(org.openqa.selenium.TimeoutException exceptionthird)
                    {
                        testContext.getWebElementUtil().refreshPage();
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().SwitchToDefault();
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                        testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                    }
                }
            }

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().TerritorialLimitationsTab);

            /* Add Risk Location */
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddRiskLocation);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().RegionHeader);
            
            testContext.getWebElementUtil().pause();
            for(WebElement risklocationregion : pageFactory.getIndividualSectionDetails().RiskLocationRegionList)
            {
                if(risklocationregion.getText().equalsIgnoreCase("China"))
                {
                    risklocationregion.click();

                    WebElement SelectRiskLocation = testContext.getWebElementUtil().getDynamicElement
                        ("(//tr[contains(@id, 'RiskLocation')]//td//span[text()='China']//following::a)[1]");
                    SelectRiskLocation.click();

                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().OKButton);
                    break;
                }
            }
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Edit the Generic Class of Business
     * for Endorsement
     */

    @And("Edit Generic Class Of Business on Individual Section")
    public void EditGenericClassOfBusinessIndividualSection()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    try
                    {
                        testContext.getWebElementUtil().refreshPage();
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().SwitchToDefault();
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                        testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                    }
                    catch(org.openqa.selenium.TimeoutException exceptionthird)
                    {
                        testContext.getWebElementUtil().refreshPage();
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().SwitchToDefault();
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                        testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                    }
                }
            }

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AuthorisedClassBusinessCoverageTab);

            try
            {
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().RegulatoryClientClassification);
            }
            catch(org.openqa.selenium.TimeoutException exception)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ExpandHighLevelClassofBusiness);
            }

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Both Insurance and Reinsurance", pageFactory.getIndividualSectionDetails().InsuranceOrReInsurance);

            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().CapacitySeekerApprovalForGenericCOB);
            if(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().CapacitySeekerApprovalForGenericCOB).equals(false))
            {
                Assert.fail();
            }
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

     /**
     * This method is used to Edit the Orginal Coverholder
     * on Individual Section
     */

    @Then("Edit Orginal Coverholder For Renewal")
    public void EditOrginalCoverholderForRenewal()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CoverholderDetailsTab);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CoverholderField);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CoverholderDeleteLink);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().AcceptAlert();

            testContext.getWebElementUtil().pause();
            pageFactory.getIndividualSectionDetails().CoverholderField.clear();
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().CoverholderField, "Accessibility Brioche Llc");
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SearchCoverholderServiceCompanyLabel);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SearchCoverHolderButton);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().SearchResults);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("(//span[text()='Accessibility Brioche Llc']//preceding::input[@type='checkbox'])[1]"));
                
            WebElement SelectMP = testContext.getWebElementUtil().getDynamicElement("(//span[text()='Accessibility Brioche Llc']//preceding::input[@type='checkbox'])[1]");
            SelectMP.click();
                
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddButton);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().CoverholderDeleteLink);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().CoverholderDeleteLink));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Select Confirmation Date under
     * Capacity Details on Individual Section
     */

    @And("Select Confirmation Date on Individual Section for Renewal")
    public void SelectConfirmationDateIndividualSection()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    try
                    {
                        testContext.getWebElementUtil().refreshPage();
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().SwitchToDefault();
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                        testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                    }
                    catch(org.openqa.selenium.TimeoutException exceptionthird)
                    {
                        testContext.getWebElementUtil().refreshPage();
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().SwitchToDefault();
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                        testContext.getWebElementUtil().pause();
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                        testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                    }
                }
            }
            
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CapacityDetailsTab);  
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ConfirmationDate);
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().TodayLink);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

     /**
     * This method is used to Edit Capacity Details
     * on Individual Section for Endorsement Amend
     * @param testData = row number
     */

    @Then("Edit Capacity Details For Endorsement Amend \"(.*)\"$")
    public void EditCapacityDetailsForEndorsementAmend(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                }
            }

            /***  Add Either Syndicate or Service Company as a Lead for Amend and Retract Scenario  ***/

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CapacityDetailsTab);

            if(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().SelectedLeadSyndicate).equals(true))
            {
                /* Add Service Company as a Capacity Lead */

                testContext.getWebElementUtil().pause(); 
                testContext.getWebElementUtil().commonSelectDropdown("Service Company", pageFactory.getIndividualSectionDetails().LeadType);

                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyLead, MPRData.get(index).get("ServiceCompanyLead"));
        
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SearchButtonServiceCompanyLead);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().ServiceCompanyHeader);

                WebElement SelectName = testContext.getWebElementUtil().getDynamicElement
                    ("(//span[text()='"+MPRData.get(index).get("ServiceCompanyLead")+"']//preceding::input[@type='checkbox'])[1]");
                SelectName.click();

                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddButton);            
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadCompanyReference);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadCompanyReference, NonMPRData.get(index).get("Comments"));
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadWrittenLine);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadWrittenLine, "50");
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadSignedLine);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadSignedLine, "50");
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadUMR);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadUMR, MPRData.get(index).get("ServiceCompanyUMR"));   

                /************************Edit The Signed Line Percentage of Previously Added Syndicate *************************/

                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClearField(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SelectedLeadSyndicate);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine, "50"); 

            }
            else if(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().SelectedLeadServiceCompany).equals(true))
            {
                /* Add Syndicate as a Capacity Lead */

                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSelectDropdown("Syndicate", pageFactory.getIndividualSectionDetails().LeadType);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateLead, MPRData.get(index).get("SyndicateLead"));
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForList(pageFactory.getContractLeads().SyndicateAutoRecommend);

                for(WebElement SearchResult : pageFactory.getContractLeads().SyndicateAutoRecommend)
                {
                    if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("SyndicateLead").toLowerCase()))
                    {
                        SearchResult.click();
                    }
                
                }
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateLeadCompanyReference);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateLeadCompanyReference, NonMPRData.get(index).get("Comments"));
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateLeadWrittenLine);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateLeadWrittenLine, "50");
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine, "50"); 
            
                /************************Edit The Signed Line Percentage of Previously Added Service Company *************************/
                
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadSignedLine);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClearField(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadSignedLine);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SelectedLeadServiceCompany);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadSignedLine);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadSignedLine, "50");
            }
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate that Generate Document button
     * is disabled before selecting any Documents Components on Actions tab
     */

    @Then("Validate Generate Document button is disabled before selecting any Document Components")
    public void ValidateGenerateDocumentIsDisabled()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().UploadButton);
            Assert.assertFalse(pageFactory.getCommon().GenerateButton.isEnabled());
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate that Generate Document button
     * is disabled before selecting any Documents Components on Actions tab
     */

    @Then("Validate user is able to Generate Document")
    public void ValidateDocumentGeneration()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().WordingCheckbox);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ScheduleCheckbox);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NonScheduleCheckbox);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().GenerateButton);

            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//div[contains(text(), 'Please wait while your document "+scenarioContext.contractID+"')]"));
            WebElement documentGenerationMessage = testContext.getWebElementUtil().getDynamicElement("//div[contains(text(), 'Please wait while your document "+scenarioContext.contractID+"')]");
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(documentGenerationMessage).equals(true));
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate that User is able to Generate
     * MRCE Document for Endorsement
     */

    @Then("Validate user is able to Generate MRCE Document for Endorsement")
    public void ValidateMRCEDocumentGeneration()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().MRCEAllCheckbox);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().GenerateMRCEButton);

            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//div[contains(text(), 'Please wait while your MRCE endorsement document "+scenarioContext.contractID+"_Endorsement')]"));
            WebElement documentGenerationMessage = testContext.getWebElementUtil().getDynamicElement("//div[contains(text(), 'Please wait while your MRCE endorsement document "+scenarioContext.contractID+"_Endorsement')]");
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(documentGenerationMessage).equals(true));
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
}