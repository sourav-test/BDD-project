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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
* Access Control Step Definition
* Seperate Steps Only for Access Control Scenarios
*/


public class AccessControlStepDefinition {

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

    public AccessControlStepDefinition(TestContext testContext, ScenarioContext scenarioContext) 
    {
        this.testContext=testContext;
        this.scenarioContext=scenarioContext;
        pageFactory = testContext.getPageFactoryController();
        fileReaderController = testContext.getFileReaderController();
        MPRData = testContext.getFileReaderController().getExcelReader().GetTestData("MPRData");
        NonMPRData = testContext.getFileReaderController().getExcelReader().GetTestData("NonMPRData");
        
    }    
    
    /**
     * This method is used to Validate that the Create Contract
     * button or option is not present on Home Page for Read Only user
     */
    
    @Then("Validate Create Contract availability for Read Only User")
    public void ValidateCreateContractButton()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getHome().PegaDefaultFrame);
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getHome().CreateContractButton).equals(false));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    /**
     * This method is used to Validate that the Review Task
     * access for Read Only User
     */
    
    @Then("Validate the Review Task For Read Only User")
    public void ValidateReviewTaskReadOnlyUser()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().DefaultAssignToMeButton).equals(false));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate that the Review Task
     * access for Read Write User
     */

    @Then("Validate the Review Task For Read Write User")
    public void ValidateReviewTaskReadWriteUser()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().DefaultAssignToMeButton).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate that the Review Task
     * access for Read Write Submit Service Company User
     * @param testData
     */
    
    @Then("Validate the Review Task For Service Company Read Write Submit User \"(.*)\"$")
    public void ValidateReviewTaskForServiceCompanyReadWriteSubmitUser(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().DefaultAssignToMeButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractReview().ReturnCommentTextArea, NonMPRData.get(index).get("Comments"));
        
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().Approve).equals(true));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().Return).equals(true));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().SubmitButton).equals(true));
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().SaveButton);
            testContext.getWebElementUtil().pause(); 
        
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().ReviewCancel);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);

            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath
                ("((//a[text()='"+scenarioContext.ServiceCompanyUsername+"'])[1]//following::button[text()='Begin'])[1]"));
            
            WebElement SelectReviewReturnedTask = testContext.getWebElementUtil().getDynamicElement
                ("((//a[text()='"+scenarioContext.ServiceCompanyUsername+"'])[1]//following::button[text()='Begin'])[1]");
            SelectReviewReturnedTask.click();
            
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().ReturnCommentTextArea);
            String expComments = pageFactory.getContractReview().ReturnCommentTextArea.getText();
            String actComments = NonMPRData.get(index).get("Comments");
            Assert.assertEquals(actComments, expComments);
            
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().Approve);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().SubmitButton);
            
            int counter = 0;
            while(counter<=5)
            {
                System.out.println(counter);
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().GetNextButton);
                    break;
                }
                catch(Exception e)
                {
                    System.out.println("Exception Handled");
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
     * This method is used to Validate that the Review Task
     * access for Read Write Submit Managing Agent User
     * @param testData = row number
     */

    @Then("Validate the Review Task For Managing Agent Read Write Submit User \"(.*)\"$")
    public void ValidateReviewTaskForManagingAgentReadWriteSubmitUser(String testData)
    {
        try
        {
            /** Adding this line as Hashmap index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().DefaultAssignToMeButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractReview().ReturnCommentTextArea, NonMPRData.get(index).get("Comments"));
        
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().Approve).equals(true));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().Return).equals(true));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().SubmitButton).equals(true));
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().SaveButton);
            testContext.getWebElementUtil().pause(); 
        
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().ReviewCancel);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);

            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath
                ("((//a[text()='"+scenarioContext.ManagingAgentUsername+"'])[1]//following::button[text()='Begin'])[1]"));
            
            WebElement SelectReviewReturnedTask = testContext.getWebElementUtil().getDynamicElement
                ("((//a[text()='"+scenarioContext.ManagingAgentUsername+"'])[1]//following::button[text()='Begin'])[1]");
            SelectReviewReturnedTask.click();
            
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().ReturnCommentTextArea);
            String expComments = pageFactory.getContractReview().ReturnCommentTextArea.getText();
            String actComments = NonMPRData.get(index).get("Comments");
            Assert.assertEquals(actComments, expComments);
            
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().Approve);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().SubmitButton);
            
            int counter = 0;
            while(counter<=5)
            {
                System.out.println(counter);
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().GetNextButton);
                    break;
                }
                catch(Exception e)
                {
                    System.out.println("Exception Handled");
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
     * This method is used to Validate that the Create Contract Task
     * on Review Harness page for Read Only User
     */
    
    @Then("Validate the Create Contract Task For Read Only User")
    public void ValidateCreateContractTaskReadOnlyUser()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().BeginButton).equals(false));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate that the Create Contract Task
     * on Review Harness page for Read Write User
     */
    
    @Then("Validate the Create Contract Task For Read Write User")
    public void ValidateCreateContractTaskReadWriteUser()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().BeginButton).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate that the Create Contract Task
     * on Review Harness page for Read Write Submit User
     */
    
    @Then("Validate the Create Contract Task For Read Write Submit User")
    public void ValidateCreateContractTaskReadWriteSubmitUser()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().BeginButton).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate that the Review Return Task
     * on Review Harness page for Read Only User
     */
    
    @Then("Validate the Review Return Task For Read Only User")
    public void ValidateReviewReturnTaskReadOnlyUser()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            Assert.assertTrue(testContext.getWebElementUtil().isPresentDynamic(By.xpath
                ("((//a[text()='"+scenarioContext.ContractCreator+"'])[1]//following::button[text()='Begin'])[1]")).equals(false));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate that the Review Return Task
     * and Retract Contract on Review Harness page for Read Write User
     */

    @Then("Validate the Review Return And Retract For Read Write User")
    public void ValidateReviewReturnTaskReadWriteUser()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().BeginButton).equals(true));
            int expectedBeginButtonCount = 1;
            int actualBeginButtonCount = pageFactory.getCommon().BeginButtonList.size();
            Assert.assertEquals(actualBeginButtonCount, expectedBeginButtonCount);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate that the Review Return Task
     * and Retract Contract on Review Harness page for Read Write User
     * @param testData = row number
     */
    
    @Then("Validate the Review Return and Retract Task For Read Write Submit User \"(.*)\"$")
    public void ValidateReviewReturnTaskReadWriteSubmitUser(String testData)
    {
        try
        {
            /** Adding this line as Hashmap index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().BeginButton));
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath
                ("((//span[text()='"+scenarioContext.ContractCreator+"'])[1]//following::button[text()='Begin'])[1]"));

            WebElement SelectReviewReturnedTask = testContext.getWebElementUtil().getDynamicElement
                ("((//span[text()='"+scenarioContext.ContractCreator+"'])[1]//following::button[text()='Begin'])[1]");
            SelectReviewReturnedTask.click();

            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractReview().ReturnCommentTextArea, NonMPRData.get(index).get("Comments"));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().Disagree).equals(true));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().Agree).equals(true));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().SubmitButton).equals(true));
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().SaveButton);
            testContext.getWebElementUtil().pause(); 

            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().ReviewCancel);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath
                ("((//span[text()='"+scenarioContext.ContractCreator+"'])[1]//following::button[text()='Begin'])[1]"));

            WebElement SelectReviewReturnedTaskAgain = testContext.getWebElementUtil().getDynamicElement
                ("((//span[text()='"+scenarioContext.ContractCreator+"'])[1]//following::button[text()='Begin'])[1]");
            SelectReviewReturnedTaskAgain.click();

            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().ReturnCommentTextArea);
            String expComments = pageFactory.getContractReview().ReturnCommentTextArea.getText();
            String actComments = NonMPRData.get(index).get("Comments");
            Assert.assertEquals(actComments, expComments);

            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().Agree);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().SubmitButton);

            int counter = 0;
            while(counter<=5)
            {
                System.out.println(counter);
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
     * This method is used to Validate that the Submit For Review
     * is not present on Actions tab for Read Write User
     */

    @Then("Validate Submit For Review Button For Read Write User")
    public void ValidateSubmitForReviewReadWriteUser()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().SubmitForReviewButton).equals(false));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    /**
     * This method is used to Validate that Read Write User
     * can save the Feedback for the Returned Review Task
     * @param testData = row number
     */

    @Then("Validate Read Write user can save Feedback for Returned Review task \"(.*)\"$")
    public void ValidateReadWriteUserFeedbackSaveForReturnedReviewTask(String testData)
    {
        try
        {
            /** Adding this line as Hashmap index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BeginButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractReview().ReturnCommentTextArea, NonMPRData.get(index).get("Comments"));
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().SaveButton);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().CancelButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BeginButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().ReturnCommentTextArea);
            String actualFeedBack = pageFactory.getContractReview().ReturnCommentTextArea.getAttribute("value");
            Assert.assertEquals(actualFeedBack, NonMPRData.get(index).get("Comments"));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate that Read Write User
     * can save the Feedback for the Review Task
     * @param testData = row number
     */

    @Then("Validate Read Write user can save Feedback for Review task \"(.*)\"$")
    public void ValidateReadWriteUserFeedbackSaveForReviewTask(String testData)
    {
        try
        {
            /** Adding this line as Hashmap index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractReview().AssignToMeButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractReview().ReturnCommentTextArea, NonMPRData.get(index).get("Comments"));
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().SaveButton);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().CancelButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BeginButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractReview().ReviewTaskFrame);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractReview().ReturnCommentTextArea);
            String actualFeedBack = pageFactory.getContractReview().ReturnCommentTextArea.getAttribute("value");
            Assert.assertEquals(actualFeedBack, NonMPRData.get(index).get("Comments"));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate that Begin Button
     * is not present to Edit or Retract the Contract on 
     * Review Harness page for DXC User
     */
    
    @Then("Validate DXC user cannot edit the Contract")
    public void ValidateDXCUserCannotEditContract()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().DefaultAssignToMeButton).equals(false));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().DefaultBeginButton).equals(false));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate that Coverholder User
     * cannot access Review Task on Review harness Page
     */

    @Then("Validate Coverholder User cannot access Review task")
    public void ValidateCoverholderCannotAccessReviewTask()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().DefaultAssignToMeButton).equals(false));        
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate that Read Only User
     * cannot initiate Endorsement on Actions tab under Contract Record
     */

    @Then("Validate Read Only User Type cannot initiate Endorsement")
    public void ValidateReadOnlyUserCannotInitiateEndorsement()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().ActionsTab);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().CreateEndorsementButton);
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().CreateEndorsementButton);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getAgreementTemplate().EndorsementEffectiveDate).equals(false));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /*
    @When("I Click on Begin for Endorsement")
    public void ClickBeginForEndorsement()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BeginButton);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }*/
    
    
    /*
    @When("I Click on Close from Endorsement Task")
    public void ClickCloseTaskForEndorsement()
    {
        try
        {  
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ActionsDropdown);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ActionsClose);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getContractRecord().PegaRecordFrame);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }*/
    
    
    @Then("Validate the absence of Create Endorsement button")
    public void ValidateAbsenceOfCreateEndorsement()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().ActionsTab);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractRecord().CreateEndorsementButton).equals(true)); 
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Navigate to a Approved Endorsement")
    public void NavigateToApprovedEndorsement()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TaskFilter);
            testContext.getWebElementUtil().pause();
            pageFactory.getContractRecord().RecordUIFilterText.clear();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().RecordUIFilterText, "Endorsement");
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().StatusFilter);
            testContext.getWebElementUtil().pause();
            pageFactory.getContractRecord().RecordUIFilterText.clear();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().RecordUIFilterText, "Complete");
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
            
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    @Then("Navigate to a Draft Endorsement")
    public void NavigateToDraftEndorsement()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TaskFilter);
            testContext.getWebElementUtil().pause();
            pageFactory.getContractRecord().RecordUIFilterText.clear();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().RecordUIFilterText, "Endorsement");
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().StatusFilter);
            testContext.getWebElementUtil().pause();
            pageFactory.getContractRecord().RecordUIFilterText.clear();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().RecordUIFilterText, "Draft");
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
            
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Navigate to a Completed Contract")
    public void NavigateToCompletedContract()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TaskFilter);
            testContext.getWebElementUtil().pause();
            pageFactory.getContractRecord().RecordUIFilterText.clear();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().RecordUIFilterText, "Create Contract");
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().StatusFilter);
            testContext.getWebElementUtil().pause();
            pageFactory.getContractRecord().RecordUIFilterText.clear();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().RecordUIFilterText, "Complete");
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
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
            
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate Endorsement is Completed \"(.*)\"$")
    public void ValidateEndorsementCompleted(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TaskFilter);
            testContext.getWebElementUtil().pause();
            pageFactory.getContractRecord().RecordUIFilterText.clear();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().RecordUIFilterText, "Endorsement");
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().StatusFilter);
            testContext.getWebElementUtil().pause();
            pageFactory.getContractRecord().RecordUIFilterText.clear();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().RecordUIFilterText, "Complete");
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();

            for(WebElement Task : pageFactory.getContractRecord().TaskList)
            {
                if(Task.getText().contains("Endorsement"))
                {
                    Task.click();
                    break;
                }
                else
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

    @Then("Navigate to a Termination Endorsement")
    public void NavigateToTerminationEndorsement()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().TaskFilter);
            testContext.getWebElementUtil().pause();
            pageFactory.getContractRecord().RecordUIFilterText.clear();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().RecordUIFilterText, "Termination Endorsement");
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().StatusFilter);
            testContext.getWebElementUtil().pause();
            pageFactory.getContractRecord().RecordUIFilterText.clear();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractRecord().RecordUIFilterText, "Complete");
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();

            for(WebElement Task : pageFactory.getContractRecord().TaskList)
            {
                if(Task.getText().contains("Termination Endorsement"))
                {
                    Task.click();
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

    

    @Then("Verify the absence of Begin Button")
    public void AbsenceOfBeginButton()
    {
        try
        {
            if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().BeginButton).equals(true))
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

    @Then("Validate the absence of Submit For Review")
    public void AbsenceOfSubmitForReview()
    {
        try
        {
            if(testContext.getWebElementUtil().isPresent(pageFactory.getCommon().SubmitForReviewButton).equals(true))
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

    @Then("Assign Contract Creator for Endorsement Assignment \"(.*)\"$")
    public void AssignContractCreator(String User)
    {
        try
        {
            int index = Integer.parseInt(User)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().AssignIndividual);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().AssignIndividualSearch, MPRData.get(index).get("ContractCreator"));
            testContext.getWebElementUtil().pause();

            for(WebElement individualuser : pageFactory.getCommon().OperatorList)
            {
                if(individualuser.getText().equalsIgnoreCase(MPRData.get(index).get("ContractCreator")))
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
            Assert.fail();
        }
    }

    @Then("Assign Read Write User for Endorsement Assignment \"(.*)\"$")
    public void AssignReadWriteUser(String User)
    {
        try
        {
            int index = Integer.parseInt(User)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().AssignIndividual);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().AssignIndividualSearch, MPRData.get(index).get("ContractCreator"));
            testContext.getWebElementUtil().pause();

            for(WebElement individualuser : pageFactory.getCommon().OperatorList)
            {
                if(individualuser.getText().equalsIgnoreCase(MPRData.get(index).get("ContractCreator")))
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
            Assert.fail();
        }
    }

}