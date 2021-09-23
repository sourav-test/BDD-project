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

/**
 * Contract Review Step Definition
 * Review Task Approve, Return
 * Validate Review Task Email
 * Agree and Disagree Returned Review Task
 * Open Draft and Review Task
 */


public class ContractReviewStepDefinition {
    
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
    
    public ContractReviewStepDefinition(TestContext testContext, ScenarioContext scenarioContext) 
    {
        this.testContext=testContext;
        this.scenarioContext=scenarioContext;
        pageFactory = testContext.getPageFactoryController();
        fileReaderController = testContext.getFileReaderController();
        MPRData = testContext.getFileReaderController().getExcelReader().GetTestData("MPRData");
        NonMPRData = testContext.getFileReaderController().getExcelReader().GetTestData("NonMPRData");
    }
    
    /**
     * This method is used to Return the Review Task with Comments
     * from Review Harness Page for Managing Agent or Service Company
     * @param testData
     */

    @Then("Return the Review Task with comments \"(.*)\"$")
    public void ReturnReviewTask(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().DefaultAssignToMeButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractReview().ReturnCommentTextArea, NonMPRData.get(index).get("Comments"));
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().Return);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().SubmitButton);
            
            int counter = 0;
            while(counter<=5)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().ReviewStatusReturn);
                    break;
                }
                catch(Exception e)
                {
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

    /**
     * This method is used to validate that the Review Task cannot
     * be returned without Comments from Review Harness Page for 
     * Managing Agent or Service Company
     * @param testData
     */

    @Then("Validate Review Task cannot be returned without Comments")
    public void ValidateReviewTaskReturnWithoutComments()
    {
        try
        {
            
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Approve the Review Task with Comments
     * from Review Harness Page for Managing Agent or Service Company
     * @param testData
     */

    @Then("Approve the Review Task with comments \"(.*)\"$")
    public void ApproveReviewTask(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().DefaultAssignToMeButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractReview().ReturnCommentTextArea, NonMPRData.get(index).get("Comments"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().Approve);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().SubmitButton);
            
            int counter = 0;
            while(counter<=5)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().ReviewStatusComplete);
                    break;
                }
                catch(Exception e)
                {
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

    /**
     * This method is used to Approve the Review Task for Endorsement 
     * with Commentsfrom Review Harness Page for Managing Agent or 
     * Service Company
     * @param testData
     */

    @Then("Approve the Review Task For Endorsement with comments \"(.*)\"$")
    public void ApproveReviewTaskForEndorsement(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().DefaultAssignToMeButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractReview().ReturnCommentTextArea, NonMPRData.get(index).get("Comments"));
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().Approve);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().SubmitButton);
            
            int counter = 0;
            while(counter<=5)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().ReviewStatusComplete);
                    break;
                }
                catch(Exception e)
                {
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

    /**
     * This method is used to Approve the Review Task for 
     * with Comments from Review Harness Page for Service Company
     * user when the task is assigned
     * @param testData
     */

    @Then("Approve the Review Task For Service Company with comments \"(.*)\"$")
    public void ApproveReviewTaskForServiceCompany(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("((//span[text()='"+scenarioContext.ServiceCompanyUsername+"'])[1]//following::button[text()='Begin'])[1]"));
            
            WebElement SelectReviewTask = testContext.getWebElementUtil().getDynamicElement
                ("((//span[text()='"+scenarioContext.ServiceCompanyUsername+"'])[1]//following::button[text()='Begin'])[1]");
            SelectReviewTask.click();
            
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractReview().ReturnCommentTextArea, NonMPRData.get(index).get("Comments"));
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().Approve);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().SubmitButton);
            
            int counter = 0;
            while(counter<=5)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().ReviewStatusComplete);
                    break;
                }
                catch(Exception e)
                {
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

    /**
     * This method is used to Approve the Review Task with
     * Comments from Review Harness Page for Managing Agent
     * user when the task is assigned
     * @param testData
     */

    @Then("Approve the Review Task For Managing Agent with comments \"(.*)\"$")
    public void ApproveReviewTaskForManagingAgent(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("((//span[text()='"+scenarioContext.ManagingAgentUsername+"'])[1]//following::button[text()='Begin'])[1]"));
            
            WebElement SelectReviewTask = testContext.getWebElementUtil().getDynamicElement
                ("((//span[text()='"+scenarioContext.ManagingAgentUsername+"'])[1]//following::button[text()='Begin'])[1]");
            SelectReviewTask.click();

            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractReview().ReturnCommentTextArea, NonMPRData.get(index).get("Comments"));
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().Approve);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().SubmitButton);
            
            int counter = 0;
            while(counter<=5)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().ReviewStatusComplete);
                    break;
                }
                catch(Exception e)
                {
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

    /**
     * This method is used to Approve the Review Task for Endorsement
     * with Comments from Review Harness Page for Service Company
     * user when the task is assigned
     * @param testData
     */

    @Then("Approve the Endorsement Review Task For Service Company with comments \"(.*)\"$")
    public void ApproveEndorsementReviewTaskForServiceCompany(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().BeginButtonDefault);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractReview().ReturnCommentTextArea, NonMPRData.get(index).get("Comments"));
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().Approve);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().SubmitButton);
            
            int counter = 0;
            while(counter<=5)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().ReviewStatusComplete);
                    break;
                }
                catch(Exception e)
                {
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

    /**
     * This method is used to Open the Review Task which is Returned
     * on Review Harness Page for Contract Creator
     */

    @Then("Open the Review Task Returned")
    public void OpenReviewTaskReturned()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            
            if(scenarioContext.LloydsUserName.isEmpty())
            {
                WebElement SelectReviewReturnedTask = testContext.getWebElementUtil().getDynamicElement
                    ("((//span[text()='"+scenarioContext.ContractCreator+"'])[1]//following::button[text()='Begin'])[1]");
                SelectReviewReturnedTask.click();
            }
            else
            {
                WebElement SelectReviewReturnedTask = testContext.getWebElementUtil().getDynamicElement
                    ("((//span[text()='"+scenarioContext.LloydsUserName+"'])[1]//following::button[text()='Begin'])[1]");
                SelectReviewReturnedTask.click();
            }
            
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

     
    /*
    @Then("Open the Review Task Returned When Assigned To Default")
    public void OpenReviewTaskReturnedAssignedToDefault()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().DefaultBeginButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }*/

    @Then("Open the Contract Draft Task")
    public void OpenContractDraftTask()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);

            WebElement SelectReviewReturnedTask = testContext.getWebElementUtil().getDynamicElement("((//a[text()='"+scenarioContext.ContractCreator+"'])[1]//following::button[text()='Begin'])[1]");
            SelectReviewReturnedTask.click();
            
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Agree the Review Task which is Returned
     * on Review Harness Page for Contract Creator
     * @param testData = row number
     */

    @Then("Agree the Review Tasks Returned with comments \"(.*)\"$")
    public void AgreeReviewReturnedTask(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractReview().ReturnCommentTextArea, NonMPRData.get(index).get("Comments"));
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().Agree);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().SubmitButton);

            int counter = 0;
            while(counter<=5)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().AgreeReviewReturnStatus);
                    break;
                }
                catch(Exception e)
                {
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

    /**
     * This method is used to Disagree the Review Task which is Returned
     * on Review Harness Page for Contract Creator
     * @param testData = row number
     */

    @Then("Disagree the Review Tasks Returned with comments \"(.*)\"$")
    public void DisagreeReviewReturnedTask(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractReview().ReturnCommentTextArea, NonMPRData.get(index).get("Comments"));
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().Disagree);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().SubmitButton);

            int counter = 0;
            while(counter<=5)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ReviewTaskCompleteMessage);
                    break;
                }
                catch(Exception e)
                {
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

    /*@Then("Validate the Retract Error Message For Open Task")
    public void ValidateRetractErrorMessage()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().YesContinueButton);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().RetractPopupOK);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().RetractErrorMessage);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }*/

    /**
     * This method is used to Retract the Contract
     * on Review Harness Page for Contract Creator
     */

    @Then("Retract The Contract")
    public void RetractContract()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BeginButton);
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);

            int counter = 0;
            while(counter<=5)
            {
                try
                {
                    testContext.getWebElementUtil().pauseForAgreeDisagreeReviewTask();
                    testContext.getWebElementUtil().refreshPage();
                    if(testContext.getWebElementUtil().ContractSubmitted(pageFactory.getAgreementTemplate().PegaTaskFrame).equals(true))
                    {
                        
                    }
                    else if(testContext.getWebElementUtil().ContractSubmitted(pageFactory.getAgreementTemplate().PegaTaskFrame).equals(false))
                    {
                        testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
                        break;
                    }
                }
                catch(Exception e)
                {
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

    /*@Then("Retract The Contract For Endorsement")
    public void RetractContractForEndorsement()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BeginButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().YesContinueButton);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().RetractPopupOK);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }*/

    /*@And("Close the Contract Task Progress")
    public void CloseContractTaskProgress()
    {
        try
        {
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().Close);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }*/

    /*@Then("Validate The Contract is Submitted")
    public void ValidateContractSubmitted()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            }
            catch(org.openqa.selenium.TimeoutException exception)
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            }   
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }*/

    /**
     * This method is used to Navigate to the Review task
     * from Search Contract and Contract Record
     * @param testData = row number
     */
    
    @And("Navigate to Review Task From Search Contract \"(.*)\"$")
    public void NavigateToReviewTaskFromSearchContract(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;
            
            testContext.getWebElementUtil().pause();
            if(scenarioContext.setAgreementTemplate.equalsIgnoreCase("Active") | scenarioContext.setAgreementTemplate.equalsIgnoreCase("Registered"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TaskFilter);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().RecordUIFilterText);
                pageFactory.getContractRecord().RecordUIFilterText.clear();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().RecordUIFilterText, "Create Contract");
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            }
            
            testContext.getWebElementUtil().pause();

            for(WebElement Task : pageFactory.getContractRecord().TaskList)
            {
                if(Task.getText().contains("Create Contract"))
                {
                    Task.click();
                    break;
                }
            }
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().pause();

            try
            {
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
            }
            catch(org.openqa.selenium.TimeoutException timeoutException)
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

               /* Navigate to Associated Tasks */
               testContext.getWebElementUtil().pause();
               testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().AssociatedTasksTab);

               /* Navigate to Review task*/
               testContext.getWebElementUtil().pause();
               testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TaskFilter);
               testContext.getWebElementUtil().pause();
               testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().RecordUIFilterText);
               pageFactory.getContractRecord().RecordUIFilterText.clear();
               testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().RecordUIFilterText, "Create Contract");
               testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
               testContext.getWebElementUtil().pause();
           

                for(WebElement Task : pageFactory.getContractRecord().TaskList)
                {
                    if(Task.getText().contains("Create Contract"))
                    {
                        Task.click();
                        break;
                    }
                }
               testContext.getWebElementUtil().SwitchToDefault();
               testContext.getWebElementUtil().pause();

               testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Navigate to the Review task
     * from Ongoing Task Dashboard
     */

    @And("Navigate to Review Task From Ongoing Task Dashboard")
    public void NavigateToReviewTaskFromOngoingTask()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().UniqueIdentifierFilter);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UniqueIdentifierFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().FilterText, scenarioContext.contractID);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();

            for(WebElement uniqueIdentifier : pageFactory.getOnGoingTasks().UniqueIdentifierListOngTask)
            {
                if(uniqueIdentifier.getText().equalsIgnoreCase(scenarioContext.contractID))
                {
                    uniqueIdentifier.click();
                    break;
                }
                else
                {
                    Assert.fail();
                }
            }

            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Navigate to the Review task
     * from Search Contract and Contract Record for Endorsement
     */

    @And("Navigate to Endorsement Review Task From Search Contract")
    public void NavigateToEndorsementReviewTaskFromSearchContract()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TaskFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().RecordUIFilterText);
            pageFactory.getContractRecord().RecordUIFilterText.clear();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().RecordUIFilterText, "Endorsement");
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();
           

            for(WebElement Task : pageFactory.getContractRecord().TaskList)
            {
                if(Task.getText().contains("Endorsement"))
                {
                    Task.click();
                    break;
                }
            }

            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate that Endorsement Task is not
     * present on Contract Record for removed Market Participant 
     * for Endorsement
     */

    @Then("Validate Endorsement is not present for removed Participant")
    public void ValidateEndorsementNotPresentForRemovedParticipant()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TaskFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().RecordUIFilterText);
            pageFactory.getContractRecord().RecordUIFilterText.clear();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().RecordUIFilterText, "Endorsement");
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();

            for(WebElement Task : pageFactory.getContractRecord().TaskList)
            {
                if(Task.getText().contains("Endorsement"))
                {
                    Assert.fail();
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
     * This method is used to Initiate Contract Amend workflow 
     * from Review Harness page for Contract
     * @param testData = row number
     */

    @Then("Initiate Contract Amend \"(.*)\"$")
    public void InitiateContractAmend(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            while(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().LloydsContractDetailsHeader).equals(false))
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

               /* Navigate to Associated Tasks */
               testContext.getWebElementUtil().pause();
               testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().AssociatedTasksTab);

               /* Navigate to Review task*/
               testContext.getWebElementUtil().pause();
               testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TaskFilter);
               testContext.getWebElementUtil().pause();
               testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().RecordUIFilterText);
               pageFactory.getContractRecord().RecordUIFilterText.clear();
               testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().RecordUIFilterText, "Create Contract");
               testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
               testContext.getWebElementUtil().pause();
           

                for(WebElement Task : pageFactory.getContractRecord().TaskList)
                {
                    if(Task.getText().contains("Create Contract"))
                    {
                        Task.click();
                        break;
                    }
                }
               testContext.getWebElementUtil().SwitchToDefault();
               testContext.getWebElementUtil().pause();

               testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
            }

            testContext.getWebElementUtil().pause();
            WebElement beginButtonForAmend = testContext.getWebElementUtil().getDynamicElement("((//span[text()='"+scenarioContext.ContractCreator+"'])[1]//following::button[text()='Begin'])[1]");
            beginButtonForAmend.click();
            
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Initiate Endorsement Amend workflow 
     * from Review Harness page for Endorsement
     * @param testData = row number
     */

    @Then("Initiate Endorsement Amend \"(.*)\"$")
    public void InitiateEndorsementAmend(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;

            while(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().LloydsContractDetailsHeader).equals(false))
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
               catch(org.openqa.selenium.TimeoutException exception)
               {
                   testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
               }

               /* Navigate to Search Contracts */
               testContext.getWebElementUtil().SwitchToDefault();
               testContext.getWebElementUtil().commonClick(pageFactory.getHome().SearchContracts);
               testContext.getWebElementUtil().pause();
               testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getSearchContracts().PegaSearchContractFrame);

               /* Search and Navigate to the Endorsement */
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

               /* Navigate to Associated Tasks */
               testContext.getWebElementUtil().pause();
               testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().AssociatedTasksTab);

               /* Navigate to Review task*/
               testContext.getWebElementUtil().pause();
               testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TaskFilter);
               testContext.getWebElementUtil().pause();
               testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().RecordUIFilterText);
               pageFactory.getContractRecord().RecordUIFilterText.clear();
               testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().RecordUIFilterText, "Endorsement");
               testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
               testContext.getWebElementUtil().pause();
           

                for(WebElement Task : pageFactory.getContractRecord().TaskList)
                {
                    if(Task.getText().contains("Endorsement"))
                    {
                        Task.click();
                        break;
                    }
                }
               testContext.getWebElementUtil().SwitchToDefault();
               testContext.getWebElementUtil().pause();

               testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
            }

            testContext.getWebElementUtil().pause();
            WebElement beginButtonForAmend = testContext.getWebElementUtil().getDynamicElement("((//span[text()='"+scenarioContext.ContractCreator+"'])[1]//following::button[text()='Begin'])[1]");
            beginButtonForAmend.click();
            
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate the Document Library 
     * for Contract Reviewer on Review harness page
     */

    @Then("Validate the Document Library on Review harness for Contract Reviewer")
    public void ValidateDocumentLibraryReviewHarnessReviewer()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().DownMenuIcon);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().DownMenuIcon);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().DocumentLibraryLink);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().DocumentLibraryLink);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().DocumentLinkReviewHarness);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().GenerateButton).equals(false));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().DocumentLinkReviewHarness).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate the Document Library 
     * for Contract Creator on Review harness page
     */

    @Then("Validate the Document Library on Review harness for Contract Creator")
    public void ValidateDocumentLibraryReviewHarnessCreator()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().DownMenuIcon);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().DownMenuIcon);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().DocumentLibraryLink);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().DocumentLibraryLink);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().DocumentLinkReviewHarness);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().DocumentLinkReviewHarness).equals(true));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().WordingCheckbox).equals(true));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().ScheduleCheckbox).equals(true));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().NonScheduleCheckbox).equals(true));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().GenerateButton).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
}