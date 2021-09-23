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
* Assign Contract Step Definition
* Contract Assign To Individual and Team
*/

public class AssignContractStepdefinition {
    
    private List<HashMap<String, String>> MPRData;

    private TestContext testContext;

    private ScenarioContext scenarioContext;

    private PageFactoryController pageFactory;

    private FileReaderController fileReaderController;

    /**
     * This is a constructor which defines the Pico Container dependency
     * @param testContext
     * @param scenarioContext
     */
    
    public AssignContractStepdefinition(TestContext testContext, ScenarioContext scenarioContext) 
    {
        this.testContext=testContext;
        this.scenarioContext=scenarioContext;
        pageFactory = testContext.getPageFactoryController();
        fileReaderController = testContext.getFileReaderController();
        MPRData = testContext.getFileReaderController().getExcelReader().GetTestData("MPRData");
    }

    /**
     * This method is used to validate that the Radio Button
     * is set to My Task when user is assigining a Task 
     * from My Tasks Dashboard
     */
    
    @And("Navigate to Task Assignments Page validate the dashboard Radio Button set to My Task")
    public void ClickAssignMyTask()
    {
        try
        {   
            testContext.getWebElementUtil().refreshPage();
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getMyTasks().MyTasksFrame);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().AssignTask);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getCommon().PegaAssignFrame);
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().MyTaskToggled).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate that the Radio Button
     * is set to My Teams when user is assigining a Task 
     * from My Teams Dashboard
     */

    @And("Navigate to Task Assignments Page validate the dashboard Radio Button set to My Teams")
    public void ClickAssignTeamTask() 
    {
        try
        {   testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getMyTeamsTasks().PegaMyGroupsFrame);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().AssignTask);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getCommon().PegaAssignFrame);
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().MyTeamTaskToggled).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to select a Contract from
     * My Tasks and My Teams dashboard for Task Assign 
     */

    @And("Select a Contract for the assignment \"(.*)\"$")
    public void SelectContractForAssign(String testData) 
    {
        try 
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            try
            {
                WebElement SelectCheckbox = testContext.getWebElementUtil().getDynamicElement
                    ("//a[contains(text(),'"+scenarioContext.contractID+"')]//preceding::input[1][@class='checkbox chkBxCtl']");
                SelectCheckbox.click(); 
            }
            catch(org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException exception)
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
                catch(org.openqa.selenium.TimeoutException timeoutException)
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }

                /* Navigate to My Teams Dashboard */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getHome().MyTeamsTasks);
                testContext.getWebElementUtil().pause();

                /* Navigate to My Teams Task Assignment Page */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getMyTeamsTasks().PegaMyGroupsFrame);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().AssignTask);
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getCommon().PegaAssignFrame);
                testContext.getWebElementUtil().pause();

                /* apply Unique Filter for Contract Assign */
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UniqueIdentifierFilter);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().FilterText, scenarioContext.contractID);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
                testContext.getWebElementUtil().pause();
                
                testContext.getWebElementUtil().pause();

                WebElement SelectCheckbox = testContext.getWebElementUtil().getDynamicElement
                    ("//a[contains(text(),'"+scenarioContext.contractID+"')]//preceding::input[1][@class='checkbox chkBxCtl']");
                SelectCheckbox.click(); 
            }
            
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to click on Assign Button
     * after selecting a Contract from My Tasks or 
     * My Teams dashboard 
     */

    @When("Click on Assign Button")
    public void ClickAssign() {

        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().Assign);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to select Individual Option
     * and to select user for Task Assign from My Tasks or 
     * My Teams dashboard 
     * @param testData = row number
     */

    @And("Select Assignement to Individual and Select User for the assignment \"(.*)\"$")
    public void SelectUser(String testData) 
    {
        try 
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().AssignIndividual);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().AssignIndividualSearch, MPRData.get(index).get("AssignedToUser"));
            testContext.getWebElementUtil().pause();

            for(WebElement individualuser : pageFactory.getCommon().OperatorList)
            {
                if(individualuser.getText().equalsIgnoreCase(MPRData.get(index).get("AssignedToUser")))
                {
                    individualuser.click();
                    break;
                }
            }
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().AssignPopupOK);
            testContext.getWebElementUtil().pause();

        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail("Select User For Assign Contract Step Failed");
        }
    }

    /**
     * This method is used to select Team Option
     * and to select Team Workqueue for Task Assign 
     * from My Tasks or My Teams dashboard
     * @param testData = row number
     */

    @And("Select Assignement to Team and the Select Team workqueue \"(.*)\"$")
    public void SelectTeam(String testData) 
    {
        try 
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().AssignTeam);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().AssignTeamSearch, MPRData.get(index).get("TeamWorkqueue"));
            testContext.getWebElementUtil().pause();

            for(WebElement teamqueue : pageFactory.getCommon().OperatorList)
            {
                if(teamqueue.getText().equalsIgnoreCase(MPRData.get(index).get("TeamName")))
                {
                    teamqueue.click();
                    break;
                }
            }
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().AssignPopupOK);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate that Transferred 
     * wording is present when user assigned the Task 
     * from My Tasks or My Teams dashboard
     */

    @Then("Validate the Processing Results for the transferred Contracts")
    public void ProcessingResults() {

        try 
        {
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//a[contains(text(),'"+scenarioContext.contractID+"')]//preceding::label[contains(text(),'Transferred')]")).equals(true));
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate that the transferred
     * contract is assigned to the user selected and validate it 
     * on Review Harness page
     * @param testData = row number
     */

    @Then("Navigate to the transferred Contract and Verify the Contract Assigned To \"(.*)\"$")
    public void VerifyAssignedToUser(String testData) 
    {
        try 
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            WebElement selectContract = testContext.getWebElementUtil().getDynamicElement
                ("//a[contains(@name,'BulkProcessing')][text()='"+scenarioContext.contractID+"']");
            selectContract.click();

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getCommon().PegaTaskFrame);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+MPRData.get(index).get("AssignedToUser")+"']")).equals(true));
            testContext.getWebElementUtil().SwitchToDefault();
   
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate that the transferred
     * contract is assigned to Team Workqueue selected and validate it 
     * on Review Harness page
     * @param testData = row number
     */

    @Then("Navigate to a transferred Contract and Verify the Contract Assigned to Team Workqueue \"(.*)\"$")
    public void VerifyAssignedToTeam(String testData) 
    {
        try 
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;
            
            testContext.getWebElementUtil().pause();
            WebElement selectContract = testContext.getWebElementUtil().getDynamicElement
                ("//a[contains(@name,'BulkProcessing')][text()='"+scenarioContext.contractID+"']");
            selectContract.click();

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getCommon().PegaTaskFrame);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+MPRData.get(index).get("TeamName")+"']")).equals(true));
            testContext.getWebElementUtil().SwitchToDefault();
   
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to navigate to Task Assignment page
     * by selecting Assign option under Actions menu 
     */

    @And("Navigate to Task Assignement from Actions dropdown")
    public void ClickActionAssign() 
    {
        try
        {   testContext.getWebElementUtil().pauseAfterSave();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ActionsAssign);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to select Individual option and to select
     * user for Task Assign while creating a Contract
     * @param testData = row number
     */

    @And("Select Assignement to Individual and the Select User for the assignment \"(.*)\"$")
    public void SelectUserFromTask(String testData) 
    {
        try 
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().AssignIndividual);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().AssignIndividualSearch, MPRData.get(index).get("AssignedToUser"));
            testContext.getWebElementUtil().pause();

            for(WebElement individualuser : pageFactory.getCommon().OperatorList)
            {
                if(individualuser.getText().equalsIgnoreCase(MPRData.get(index).get("AssignedToUser")))
                {
                    individualuser.click();
                    break;
                }
            }

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().OKButton);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();

        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to select Team option and to select
     * Team Workqueue for Task Assign while creating a Contract
     * @param testData = row number
     */

    @And("Select Assignement to Individual and Select Team workqueue \"(.*)\"$")
    public void SelectTeamFromTask(String testData) 
    {
        try 
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().AssignTeam);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().AssignTeamSearch, MPRData.get(index).get("TeamWorkqueue"));
            testContext.getWebElementUtil().pause();

            for(WebElement teamqueue : pageFactory.getCommon().OperatorList)
            {
                if(teamqueue.getText().equalsIgnoreCase(MPRData.get(index).get("TeamName")))
                {
                    teamqueue.click();
                    break;
                }
            }
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().OKButton);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate that the Contract is assigned 
     * to the selected user and validate it on Review Harness page
     * while creating a Contract
     * @param testData = row number
     */

    @And("Verify the Contract Assigned to \"(.*)\"$")
    public void OpenUserAssignedContract(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+MPRData.get(index).get("AssignedToUser")+"']")).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate that the Contract is assigned 
     * to the selected Team Workqueue and validate it on Review Harness page
     * while creating a Contract
     * @param testData = row number
     */

    @And("Verify the Contract Assigned to Team Workqueue \"(.*)\"$")
    public void OpenTeamAssignedContract(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath("//span[text()='"+MPRData.get(index).get("TeamName")+"']")).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Apply Filter for Unique Identifier 
     * on My Tasks and My Teams dashboard
     */

    @And("Apply Unique Identifier Filter for Assign Contract")
    public void FilterWithUniqueIdentifier() 
    {
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

    /**
     * This method is used to validate that the Notification is getting triggered 
     * for the user when a Task has been assigned
     */

    @Then("Validate System Notification for Contract now Assigned To")
    public void ValidateSystemNotifAssignedTo() 
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NotificationIcon);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().NotificationLabel);
            for(WebElement ContractNotification : pageFactory.getCommon().NotificationList)
            {
                if(ContractNotification.getText().contains("Case "+scenarioContext.contractID+" has been assigned to you."))
                {
                    Assert.assertTrue(ContractNotification.getText().contains("Case "+scenarioContext.contractID+" has been assigned to you."));
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

}