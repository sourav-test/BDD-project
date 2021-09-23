package com.chorus.stepdefinitions;

import java.util.HashMap;
import java.util.List;
import com.chorus.framework.controllers.FileReaderController;
import com.chorus.framework.controllers.PageFactoryController;
import com.chorus.framework.picocontainerdependency.TestContext;
import com.chorus.scenariocontext.ScenarioContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

/**
* Share Contract Step Definition
* Seperate Steps Only for Share Contract Scenarios
* 
*/

public class ShareContractSteps {

    public List<HashMap<String, String>> MPRData;

    public List<HashMap<String, String>> NonMPRData;

    private TestContext testContext;

    private ScenarioContext scenarioContext;

    private PageFactoryController pageFactory;

    private FileReaderController fileReaderController;

    /**
     * Pico Container Dependency Inject (TestBase Class)
     * @param testBase
     */

    public ShareContractSteps(TestContext testContext, ScenarioContext scenarioContext) {

        this.testContext=testContext;
        this.scenarioContext=scenarioContext;
        pageFactory = testContext.getPageFactoryController();
        fileReaderController = testContext.getFileReaderController();
        MPRData = testContext.getFileReaderController().getExcelReader().GetTestData("MPRData");
        NonMPRData = testContext.getFileReaderController().getExcelReader().GetTestData("NonMPRData");
    }    
    
    
    @And("Click on Share visibility of contract")
    public void ClickShare()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ShareChkBox);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Then("Validate the availability of Share Contract option")
    public void ValidateAvailabilityOfShareContractOption()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().UploadButton);
            Assert.assertFalse(pageFactory.getCommon().ShareChkBox.isEnabled());
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @And("Validate the Shared Contract on Ongoing Task Dashboard")
    public void ValShareCnctPresent()
    {
        try
        {
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getOnGoingTasks().PegaOngoingTaskFrame);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UniqueIdentifierFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().FilterText, scenarioContext.contractID);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();

            if(pageFactory.getOnGoingTasks().UniqueIdentifierListOngTask.isEmpty())
            {
                Assert.fail();
            }

            for(WebElement uniqueIdentifier : pageFactory.getOnGoingTasks().UniqueIdentifierListOngTask)
            {
                if(uniqueIdentifier.getText().equalsIgnoreCase(scenarioContext.contractID))
                {
                    Assert.assertTrue(true);
                    break;
                }
                else
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

    
    @And("Click on Manage Share Gear Icon")
    public void ClickManageShare()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ManageShare);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }

    }

    
    @Then("^Select User Group to Share \"(.*)\"$")
    public void AddUG(String UG)
    {
        try
        {
            int index = Integer.parseInt(UG)-1;

            JavascriptExecutor clickOperation = testContext.getWebElementUtil().getExecutor();
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//span[text()='"+MPRData.get(index).get("ShareUserGroup")+"']//following::a[contains(@title, 'Add a row')]"));
            
            WebElement selectUserGroup = testContext.getWebElementUtil().getDynamicElement
                ("//span[text()='"+MPRData.get(index).get("ShareUserGroup")+"']//following::a[contains(@title, 'Add a row')]");
            clickOperation.executeScript("arguments[0].click();", selectUserGroup);

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().pause();
            clickOperation.executeScript("arguments[0].click();", pageFactory.getCommon().UserGrpSubmit);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    @Then("^Remove the User Group \"(.*)\"$")
    public void DeleteUG(String UG)
    {
        try
        {
            int index = Integer.parseInt(UG)-1;
            testContext.getWebElementUtil().pause();
            
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//span[text()='"+MPRData.get(index).get("ShareUserGroup")+"']//following::a[contains(@title, 'Delete this row')]"));
            
            WebElement deleteUserGroup = testContext.getWebElementUtil().getDynamicElement
                ("//span[text()='"+MPRData.get(index).get("ShareUserGroup")+"']//following::a[contains(@title, 'Delete this row')]");
            deleteUserGroup.click();

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UserGrpSubmit);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @And("Validate the Shared Contract Not present on Ongoing Task Dashboard")
    public void ValShareCnctNotPresent()
    {
        try
        {
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getOnGoingTasks().PegaOngoingTaskFrame);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UniqueIdentifierFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().FilterText, scenarioContext.contractID);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();
            if (pageFactory.getOnGoingTasks().UniqueIdentifierListOngTask.isEmpty())
            {
                Assert.assertTrue(true);
            }
            else
            {
                for(WebElement uniqueIdentifier : pageFactory.getOnGoingTasks().UniqueIdentifierListOngTask)
                {
                    if(uniqueIdentifier.getText().equalsIgnoreCase(scenarioContext.contractID))
                    {
                        Assert.fail();
                        break;
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

    @Then("Validate Assign To Me is not present for different CSN")
    public void ValidateAssignToMe()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractReview().DefaultAssignToMeButton).equals(false));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate that Shared Contract
     * is present on Ongoing Task dashboard for DXC User
     * and Navigate to Review Harness page and Validate DXC User
     * cannot Edit the Contract
     */
    
    @Then("Validate the Shared Contract is present for DXC user and cannot edit the Contract")
    public void ValidateContractIsPresentForDXCUserAndCannotEditContract()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().UniqueIdentifierFilter);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().UniqueIdentifierFilter);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommon().FilterText, scenarioContext.contractID);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ApplyFilter);
            testContext.getWebElementUtil().pause();

            if(pageFactory.getOnGoingTasks().UniqueIdentifierListOngTask.isEmpty())
            {
                Assert.fail();
            }

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
}
    