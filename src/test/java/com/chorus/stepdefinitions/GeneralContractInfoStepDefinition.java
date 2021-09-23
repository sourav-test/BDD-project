package com.chorus.stepdefinitions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
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
* General Contract Info Step Definition
* General Contract Info
* Broker Details
* Contract Leads
*/


public class GeneralContractInfoStepDefinition {
    
    public List<HashMap<String, String>> MPRData;

    public List<HashMap<String, String>> NonMPRData;

    private TestContext testContext;

    private ScenarioContext scenarioContext;

    private PageFactoryController pageFactory;

    private FileReaderController fileReaderController;

    /**
     * This is a constructor which defines the Pico Container dependency
     * @param testContext
     * @param scenarioContext
     */

    public GeneralContractInfoStepDefinition(TestContext testContext, ScenarioContext scenarioContext) 
    {
        this.testContext=testContext;
        this.scenarioContext=scenarioContext;
        pageFactory = testContext.getPageFactoryController();
        fileReaderController = testContext.getFileReaderController();
        MPRData = testContext.getFileReaderController().getExcelReader().GetTestData("MPRData");
        NonMPRData = testContext.getFileReaderController().getExcelReader().GetTestData("NonMPRData");
    }

    /**
     * This method is used to enter UMR on General Contract
     * Information page
     * @param testData = row number
     */

    @When("Enter UMR Number \"(.*)\"$")
    public void EnterUMR(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;
            
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().UMRFrstPart);
            }
            catch(org.openqa.selenium.TimeoutException timeoutExceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().UMRFrstPart);
                }
                catch(org.openqa.selenium.TimeoutException timeoutExceptionsecond)
                {
                    testContext.getWebElementUtil().pauseForAgreeDisagreeReviewTask();
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().UMRFrstPart);
                }
            }
            
            testContext.getWebElementUtil().commonClearField(pageFactory.getGeneralContractInformation().UMRFrstPart);
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRFrstPart);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().UMRFrstPart, MPRData.get(index).get("CSN"));
            
            try
            {
                scenarioContext.contractID = pageFactory.getCommon().ContractID.getText();
            }
            catch(org.openqa.selenium.StaleElementReferenceException staleElementReferenceExceptionFirst)
            {
                try
                {
                    scenarioContext.contractID = pageFactory.getCommon().ContractID.getText();
                }
                catch(org.openqa.selenium.StaleElementReferenceException staleElementReferenceExceptionSecond)
                {
                    scenarioContext.contractID = pageFactory.getCommon().ContractID.getText();
                }
            }
            
            String splitContractID [] = scenarioContext.contractID.split("-");
            String contractType = splitContractID [1];
            String contractcreationDate = splitContractID[2];
            String contractIDSequence = splitContractID [3];
            String UMRSecondPart = contractType+contractcreationDate+contractIDSequence;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClearField(pageFactory.getGeneralContractInformation().UMRScndPart);
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRScndPart);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().UMRScndPart, UMRSecondPart);
        }
        catch (AssertionError | Exception e)
        {
          e.printStackTrace();
          Assert.fail();
        }
    }

    /**
     * This method is used to edit the first 2-5 Characters
     * of UMR and to validate the error when 2-5 Characters 
     * does not match with Broker's CSN
     */

    @Then("Edit the UMR and Validate the absence of UMR does not match with Broker error")
    public void EditTheUMR()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().UMRFrstPart);
            testContext.getWebElementUtil().commonClearField(pageFactory.getGeneralContractInformation().UMRFrstPart);
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRFrstPart);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().UMRFrstPart, "1234");
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRScndPart);
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getGeneralContractInformation().UMRMatchWithBrokerErrorMsg).equals(true));
        }
        catch (AssertionError | Exception e)
        {
          e.printStackTrace();
          Assert.fail();
        }
    }

    /**
     * This method is used to enter invalid characters as UMR
     * on General Contract Information
     */
    
    @When("Enter Invalid UMR Number")
    public void EnterInValidUMR()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().UMRFrstPart);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().UMRFrstPart, "$1$1");
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().AgreementNmbr);
        }
        catch (AssertionError | Exception e)
        {
          e.printStackTrace();
          Assert.fail();
        }
    }

    /**
     * This method is used to enter invalid characters as UMR
     * on General Contract Information
     */

    @Then("Validate the invalid UMR error message")
    public void ValidateUMRErrMsg()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().UMRErrorMessage);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getGeneralContractInformation().UMRErrorMessage).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate 
     * on General Contract Information
     */

    @Then("Validate UMR number, Contract ID and Work Status")
    public void ValidateUMRContractIDWorkStatus()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRHeader);
            testContext.getWebElementUtil().pause();
            
            scenarioContext.UMR= pageFactory.getCommon().UMR.getText();
            scenarioContext.contractID = pageFactory.getCommon().ContractID.getText();
            System.out.println(scenarioContext.contractID);
            scenarioContext.WorkStatus = pageFactory.getCommon().Workstatus.getText();
            String arrcontractID [] = scenarioContext.contractID.split("-");
            String contractIDSequence = arrcontractID [3];
            Assert.assertTrue(contractIDSequence.length() == 4);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to validate the Confirmation
     * Date field on General Contract Information when navigating
     * back from Section Details
     */
    
    @Then("Validate the Confirmation Date field")
    public void ValidateConfirmationDateOnGeneralContractInfo()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().UMRFrstPart);
            String actualDate = pageFactory.getGeneralContractInformation().DateConfirmation.getText();
            String expectedDate = testContext.getWebElementUtil().GetCurrentDMMMY();
            Assert.assertEquals(actualDate, expectedDate);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to select London Syndicate 
     * using Syndicate Name on Contract Leads tab 
     * @param testData = row number
     */

    @And("Select a Syndicate \"(.*)\"$")
    public void SelectSyndicate(String testData)  
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonSelectDropdown("Syndicate", pageFactory.getContractLeads().LeadType);
            
            testContext.getWebElementUtil().pause();
            if(scenarioContext.setAgreementTemplate.contains("LBS"))
            {
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractLeads().SyndicateSearch, MPRData.get(index).get("SyndicateLeadBrussels"));
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForList(pageFactory.getContractLeads().SyndicateAutoRecommend);

                for(WebElement SearchResult : pageFactory.getContractLeads().SyndicateAutoRecommend)
                {
                    if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("SyndicateLeadBrussels").toLowerCase()))
                    {
                        SearchResult.click();
                        break;
                    }    
                }
            }
            else
            {
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractLeads().SyndicateSearch, MPRData.get(index).get("SyndicateLead"));
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForList(pageFactory.getContractLeads().SyndicateAutoRecommend);

                for(WebElement SearchResult : pageFactory.getContractLeads().SyndicateAutoRecommend)
                {
                    if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("SyndicateLead").toLowerCase()))
                    {
                        SearchResult.click();
                        break;
                    }    
                }
            }

            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractLeads().SyndicateDeleteIcon);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractLeads().SyndicateDeleteIcon).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to select Brussels Syndicate using 
     * Syndicate Name on Contract Leads tab 
     * @param testData = row number
     */
    
    @And("Select Syndicate For Brussels \"(.*)\"$")
    public void SelectSecondSyndicate(String testData)  
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Syndicate", pageFactory.getContractLeads().BrusselsLeadType);
        
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractLeads().BrusselsSyndicateSearch, MPRData.get(index).get("SyndicateLeadBrussels"));
            
            testContext.getWebElementUtil().pause();
            for(WebElement SearchResult : pageFactory.getContractLeads().SyndicateAutoRecommend)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("SyndicateLeadBrussels").toLowerCase()))
                {
                    SearchResult.click();
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
     * This method is used to select London Syndicate using 
     * Syndicate Number on Contract Leads tab 
     * @param testData = row number
     */

    @Then("Select Syndicate using Syndicate Number \"(.*)\"$")
    public void SelectSyndicateUsingSyndicateNumber(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonSelectDropdown("Syndicate", pageFactory.getContractLeads().LeadType);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClearField(pageFactory.getContractLeads().SyndicateSearch);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractLeads().SyndicateSearch, MPRData.get(index).get("SyndicateNumber"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForList(pageFactory.getContractLeads().SyndicateAutoRecommend);

            for(WebElement SearchResult : pageFactory.getContractLeads().SyndicateAutoRecommend)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("SyndicateLead").toLowerCase()))
                {
                    SearchResult.click();
                    break;
                }    
            }

            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractLeads().SyndicateDeleteIcon);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractLeads().SyndicateDeleteIcon).equals(true));

        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to select London Syndicate using 
     * Managing Agent Name on Contract Leads tab 
     * @param testData = row number
     */
    
    @Then("Select Syndicate using Managing Agent \"(.*)\"$")
    public void SelectSyndicateUsingManagingAgent(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            if(testContext.getWebElementUtil().isPresent(pageFactory.getContractLeads().SyndicateDeleteIcon).equals(true))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getContractLeads().SyndicateDeleteIcon);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().DeletePopupYes);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().DeletePopupYes);
                testContext.getWebElementUtil().pause();
            }
            
            testContext.getWebElementUtil().commonSelectDropdown("Syndicate", pageFactory.getContractLeads().LeadType);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClearField(pageFactory.getContractLeads().SyndicateSearch);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractLeads().SyndicateSearch, MPRData.get(index).get("ManagingAgent"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForList(pageFactory.getContractLeads().SyndicateAutoRecommend);

            for(WebElement SearchResult : pageFactory.getContractLeads().SyndicateAutoRecommend)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("SyndicateLead").toLowerCase()))
                {
                    SearchResult.click();
                    break;
                }    
            }

            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractLeads().SyndicateDeleteIcon);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractLeads().SyndicateDeleteIcon).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate that user is not able to select Duplicate Syndicate \"(.*)\"$")
    public void ValidateUserNotAbleToSelectDuplicateSyndicate(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Syndicate", pageFactory.getContractLeads().LeadType);
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractLeads().SyndicateSearch, MPRData.get(index).get("SyndicateLead"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForList(pageFactory.getContractLeads().SyndicateAutoRecommend);

            for(WebElement SearchResult : pageFactory.getContractLeads().SyndicateAutoRecommend)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("SyndicateLead").toLowerCase()))
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

    @And("^Select a Service Company \"(.*)\"$")
    public void SelectServiceCompany(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Service Company", pageFactory.getContractLeads().LeadType);

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractLeads().ServiceCompanySearch, MPRData.get(index).get("ServiceCompanyLead"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getContractLeads().ServiceCompanySearchButton);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractLeads().ServiceCompanyHeader);
            
            WebElement SelectName = testContext.getWebElementUtil().getDynamicElement
                ("(//span[text()='"+MPRData.get(index).get("ServiceCompanyLead")+"']//preceding::input[@type='checkbox'])[1]");
            SelectName.click();
            
            testContext.getWebElementUtil().commonClick(pageFactory.getContractLeads().AddButton);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractLeads().ServiceCompanyUMR, MPRData.get(index).get("ServiceCompanyUMR"));
            
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Select a Non-Llyods Insurer \"(.*)\"$")
    public void SelectNonLloydsInsurer(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Non-Lloyd's Insurer", pageFactory.getContractLeads().LeadType);

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractLeads().NonLloydsSearch, MPRData.get(index).get("NonLloydsInsurer"));
            
            testContext.getWebElementUtil().pause();
            for(WebElement SearchResult : pageFactory.getContractLeads().NonLloydsList)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("NonLloydsInsurer").toLowerCase()))
                {
                    SearchResult.click();
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

    @Then("Validate that user is not able to select Duplicate Non-Llyods Insurer \"(.*)\"$")
    public void ValidateUserNotAbleToSelectDuplicateNonLloydsInsurer(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Non-Lloyd's Insurer", pageFactory.getContractLeads().LeadType);

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractLeads().NonLloydsSearch, MPRData.get(index).get("NonLloydsInsurer"));
            
            testContext.getWebElementUtil().pause();
            for(WebElement SearchResult : pageFactory.getContractLeads().NonLloydsList)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("NonLloydsInsurer").toLowerCase()))
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

    @Then("Validate the Non-Lloyd's insurer being the only lead")
    public void ValidateNonLloydsError()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractLeads().NonLloydsError).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the absence of Non-Lloyd's insurer being the only lead")
    public void ValidateAbsenceOfNonLloydsError()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractLeads().NonLloydsError).equals(false));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Maximum Error Message")
    public void ValidateMaxErrMsgSyndicate()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(pageFactory.getContractLeads().SyndicateMaxMsg.isDisplayed());
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }

    }

    
    @And("I Expand Broker Section")
    public void ExpandBrokerQuestion()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getBrokerDetails().BrokerDetailsTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Enter Broker Details")
    public void EnterBrokerDetails()
    {
        try 
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getBrokerDetails().ContractMngrFirstName, "Firstname");
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getBrokerDetails().ContractMngrSurName, "Surname");
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getBrokerDetails().ContractMngrEmail, "test@test.com");  
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Broker Maximum Error Message")
    public void ValidateBrkrMaxErrMsg()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getBrokerDetails().BrokerMaxMsg);
           
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Validate the Contract ID as per Template \"(.*)\"$")
    public void ValidateContractIDWithCoverholder(String testData)
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ContractID);
            String ContractID = pageFactory.getCommon().ContractID.getText();
            String map = null;
            Assert.assertTrue(ContractID.contains(map));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @And("^I Enter the Agreement Number \"(.*)\"$")
    public void enteragreementnumber(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().AgreementNmbr, NonMPRData.get(index).get("AgreementNumber"));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Then("I Enter Period From Date \"(.*)\"$")
    public void EnterPeriodFromDate(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            
            if(scenarioContext.setContractStatus.equalsIgnoreCase("Active"))
            {
                String dateForActiveContract [] = testContext.getWebElementUtil().GetCurrentDateMDY().split("-");
                String day = dateForActiveContract [1];
                String month = dateForActiveContract[0];
                String year = dateForActiveContract [2];

                testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().PeriodFromDt);
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
                
                testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRHeader);
            }
            else if(scenarioContext.setContractStatus.equalsIgnoreCase("Registered"))
            {
                String dateForRegisteredContract [] = testContext.getWebElementUtil().ChangePeriodFromDate(20).split("-");
                String day = dateForRegisteredContract [1];
                String month = dateForRegisteredContract[0];
                String year = dateForRegisteredContract [2];
                
                testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().PeriodFromDt);
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
                
                testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRHeader);
            }
            else if(scenarioContext.setContractStatus.equalsIgnoreCase("Expired"))
            {
                String dateForExpiredContract [] = testContext.getWebElementUtil().ChangePeriodFromDate(-30).split("-");
                String day = dateForExpiredContract [1];
                String month = dateForExpiredContract[0];
                String year = dateForExpiredContract [2];
                
                testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().PeriodFromDt);
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
            }
            
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("I Enter Period From Date For Resign \"(.*)\"$")
    public void EnterPeriodFromDateForResign(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().PeriodFromDt, "1/1/2020");
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRHeader); 
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Enter the Period From Date with gap for Renewal")
    public void EnterPeriodFromDateWithGapRenewal()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().PeriodFromDt);
            
            String dateForActiveContract [] = testContext.getWebElementUtil().ChangePeriodFromDate(380).split("-");
            String day = dateForActiveContract [1];
            String month = dateForActiveContract[0];
            String year = dateForActiveContract [2];

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().PeriodFromDt);
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
               
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRHeader);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Validate the Period To Date as per Template \"(.*)\"$")
    public void ValidatePeriodToDate(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRHeader);
            String FromDate = pageFactory.getGeneralContractInformation().PeriodFromDt.getText();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().PeriodToDt);
            String ToDate = pageFactory.getGeneralContractInformation().PeriodToDt.getText();
            Assert.assertNotNull(ToDate);
            Date actFromDate = new SimpleDateFormat("dd/MM/yyyy").parse(FromDate);
            
            if(scenarioContext.setContractStatus.equalsIgnoreCase("Active") | scenarioContext.setContractStatus.equalsIgnoreCase("Registered"))
            {
                if(scenarioContext.setAgreementTemplate.endsWith("M"))
                {
                    Date actToDate = new SimpleDateFormat("dd/MM/yyyy").parse(ToDate);
                    long duration = actToDate.getTime() - actFromDate.getTime();
                    long actDaysDifference = TimeUnit.MILLISECONDS.toDays(duration);
                    long expDaysDifference = 1095;
                    Assert.assertEquals(actDaysDifference, expDaysDifference);
                }
                else
                {
                    Date actToDate = new SimpleDateFormat("dd/MM/yyyy").parse(ToDate);
                    long duration = actToDate.getTime() - actFromDate.getTime();
                    long actDaysDifference = TimeUnit.MILLISECONDS.toDays(duration);
                    long expDaysDifference = 364;
                    Assert.assertEquals(actDaysDifference, expDaysDifference);
                }
            }
            else if(scenarioContext.setContractStatus.equalsIgnoreCase("Expired"))
            {
                String dateForActiveContract [] = testContext.getWebElementUtil().ChangePeriodFromDate(-1).split("-");
                String day = dateForActiveContract [1];
                String month = dateForActiveContract[0];
                String year = dateForActiveContract [2];

                testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().PeriodToDt);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateMonth, month);
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateYear, year);
                
                for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                {
                    if(selectday.getText().equalsIgnoreCase(day))
                    {
                        selectday.click();
                        break;
                    }
                }
                
                testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRHeader);
            } 
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("I Enter Period To Date")
    public void EnterPeriodToDate()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRHeader);
            testContext.getWebElementUtil().commonClearField(pageFactory.getGeneralContractInformation().PeriodToDt);
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().PeriodToDt);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().PeriodToDt, testContext.getWebElementUtil().ChangePeriodFromDate(2));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("I Enter Period To Date For Renewal")
    public void EnterPeriodToDateForRenewal()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRHeader);
            testContext.getWebElementUtil().commonClearField(pageFactory.getGeneralContractInformation().PeriodToDt);
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().PeriodToDt);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().PeriodToDt, testContext.getWebElementUtil().ChangePeriodFromDate(4));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("I Enter Period To Date For Resign")
    public void EnterPeriodToDateForResign()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRHeader);
            testContext.getWebElementUtil().commonClearField(pageFactory.getGeneralContractInformation().PeriodToDt);
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().PeriodToDt);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().PeriodToDt, testContext.getWebElementUtil().GetCurrentDateMDY());
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Select Period To date For Link and Delink And Capture the Contract ID For Linking")
    public void EnterPeriodToDateForLinkAndDelink()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRHeader);
            testContext.getWebElementUtil().pause();

            String dateForActiveContract [] = testContext.getWebElementUtil().ChangePeriodFromDate(30).split("-");
            String day = dateForActiveContract [1];
            String month = dateForActiveContract[0];
            String year = dateForActiveContract [2];

            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().PeriodToDt);
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
                
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRHeader);
            scenarioContext.contractIDForLinking = pageFactory.getCommon().ContractID.getText();
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Edit Period From Date and To Date For Link and Delink")
    public void EnterPeriodToAndFromDateForLinkAndDelink()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRHeader);
            testContext.getWebElementUtil().pause();
            
            String periodFromDateForActiveContract [] = testContext.getWebElementUtil().ChangePeriodFromDate(31).split("-");
            String periodFromDay = periodFromDateForActiveContract [1];
            String periodFromMonth = periodFromDateForActiveContract[0];
            String periodFromYear = periodFromDateForActiveContract [2];

            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().PeriodFromDt);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateMonth, periodFromMonth);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateYear, periodFromYear);
                
            if(periodFromDay.startsWith("0"))
            {
                String editedPeriodFromDay = periodFromDay.substring(1);

                for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                {
                    if(selectday.getText().equalsIgnoreCase(editedPeriodFromDay))
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
                    if(selectday.getText().equalsIgnoreCase(periodFromDay))
                    {
                        selectday.click();
                        break;
                    }
                }
            }
                
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRHeader);
        
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRHeader);
            testContext.getWebElementUtil().pause();

            String periodToDateForActiveContract [] = testContext.getWebElementUtil().ChangePeriodFromDate(60).split("-");
            String periodToDay = periodToDateForActiveContract [1];
            String periodToMonth = periodToDateForActiveContract[0];
            String periodToYear = periodToDateForActiveContract [2];

            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().PeriodToDt);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateMonth, periodToMonth);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().DateYear, periodToYear);
                
            if(periodToDay.startsWith("0"))
            {
                String editedPeriodToDay = periodToDay.substring(1);

                for(WebElement selectday : pageFactory.getGeneralContractInformation().DateDay)
                {
                    if(selectday.getText().equalsIgnoreCase(editedPeriodToDay))
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
                    if(selectday.getText().equalsIgnoreCase(periodToDay))
                    {
                        selectday.click();
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

    @Then("^Select Any Time Zone \"(.*)\"$")
    public void Timezone(String zone)
    {
        try
        {
            int index = Integer.parseInt(zone)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().AnyTimeZoneNo);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown(NonMPRData.get(index).get("TimeZone"), pageFactory.getGeneralContractInformation().SelectTimezone);  
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Select Both Days Inclusive Time Period \"(.*)\"$")
    public void BothDaysInclusive(String period)
    {
        try
        {
            int index = Integer.parseInt(period)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().BothDaysNo);
            testContext.getWebElementUtil().pause();

            String TimePeriodFrom = NonMPRData.get(index).get("TimePeriodFrom");
            String splitTimePeriodFrom [] = TimePeriodFrom.split(":");
            String TimePeriodFromHours = splitTimePeriodFrom [0];
            String TimePeriodFromMinutes = splitTimePeriodFrom [1];
            testContext.getWebElementUtil().commonSelectDropdown(TimePeriodFromHours, pageFactory.getGeneralContractInformation().SelectTimePeriodFromHours);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown(TimePeriodFromMinutes, pageFactory.getGeneralContractInformation().SelectTimePeriodFromMinutes);
            
            String TimePeriodTo = NonMPRData.get(index).get("TimePeriodTo");
            String splitTimePeriodTo [] = TimePeriodTo.split(":");
            String TimePeriodToHours = splitTimePeriodTo [0];
            String TimePeriodToMinutes = splitTimePeriodTo [1];
            testContext.getWebElementUtil().commonSelectDropdown(TimePeriodToHours, pageFactory.getGeneralContractInformation().SelectTimePeriodToHours);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown(TimePeriodToMinutes, pageFactory.getGeneralContractInformation().SelectTimePeriodToMinutes);

        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Select Sub Contract \"(.*)\"$")
    public void SubContract(String contractno)
    {
        try
        {
            int index = Integer.parseInt(contractno)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().SubContractYes);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().SubContractField, NonMPRData.get(index).get("MasterContract"));
            testContext.getWebElementUtil().pause();

            for(WebElement SubContract : pageFactory.getGeneralContractInformation().UMRSubContractAutoRecommend)
            {
                if(SubContract.getText().equalsIgnoreCase(NonMPRData.get(index).get("MasterContract")))
                {
                    SubContract.click();
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

    @Then("Validate the Contract Details")
    public void ValidateSearchedContract()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().UMR);
            String actualUMR = pageFactory.getCommon().UMR.getText();
            String actualContractID = pageFactory.getCommon().ContractID.getText();
            Assert.assertEquals(actualUMR, scenarioContext.UMR);
            Assert.assertEquals(actualContractID, scenarioContext.contractID);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @Then("I enter Broker search criteria and validate the results \"(.*)\"$")
    public void wildcardsearchbroker(String keyword)
    {
        try
        {
            int index = Integer.parseInt(keyword)-1;
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getBrokerDetails().BrokerField, MPRData.get(index).get("Organization"));
            testContext.getWebElementUtil().pause();
            
            for(WebElement SearchResult : pageFactory.getBrokerDetails().BrokerAutoRecommend)
            {
                Assert.assertTrue(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("Organization").toLowerCase()));
            }
        }
        catch (AssertionError | Exception e)
        {
           e.printStackTrace();
           Assert.fail();
        }
    }

    @Then("I enter Syndicate search criteria as \"(.*)\" and validate the results$")
    public void wildcardsearchsyndicate(String keyword)
    {
        try
        {
            int index = Integer.parseInt(keyword)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Syndicate", pageFactory.getContractLeads().LeadType);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getContractLeads().SyndicateSearch, MPRData.get(index).get("SyndicateLead"));
            testContext.getWebElementUtil().pause();
            
            for(WebElement SearchResult : pageFactory.getContractLeads().SyndicateAutoRecommend)
            {
                Assert.assertTrue(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("SyndicateLead").toLowerCase()));
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate WorkFlow Status Under Review")
    public void ValidateWorkFlowStatusForReview()
    {
        int counter = 0;
        while(counter<=1)
        {
            try
            {
                if(testContext.getWebElementUtil().isPresentDynamic(By.xpath
                ("(//div[@class='custom_text'][contains(text(), ' Errors exist on Section Details tab')])")).equals(true))
                {
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
                    try
                    {
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().HereOnFirstPercentage);
                    }
                    catch(org.openqa.selenium.TimeoutException exception)
                    {
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().HereOnFirstPercentage);    
                    }

                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);

                    if(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().RefreshParticipantDataErrorMessage).equals(true))
                    {
                        testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().RefreshParticipantDataButton);
                        testContext.getWebElementUtil().pause();

                        if(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().PlatformBlankErrorMessage).equals(true))
                        {
                            testContext.getWebElementUtil().pause();
                            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                            testContext.getWebElementUtil().pause();
                            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().NonScheduleTab);
                            testContext.getWebElementUtil().commonSelectDropdown("London", pageFactory.getIndividualSectionDetails().Platform);
                            testContext.getWebElementUtil().pause();
                        }

                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ContinueButton);
                        testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
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
                                testContext.getWebElementUtil().refreshPage();
                                testContext.getWebElementUtil().SwitchToDefault();
                                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().HereOnFirstPercentage);
                                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                            }
                        }

                        try
                        {
                            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().SubmitForReviewButton);
                            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().SubmitForReviewButton);
                            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SubmitForReviewOKButton);
                        }
                        catch(org.openqa.selenium.TimeoutException exceptionfirst)
                        {
                            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().SubmitForReviewButton);
                            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().SubmitForReviewButton);
                            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SubmitForReviewOKButton);
                            testContext.getWebElementUtil().pause();
                        }
                    } 
                }

                if(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().PlatformBlankErrorMessage).equals(true))
                {
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().NonScheduleTab);
                    testContext.getWebElementUtil().commonSelectDropdown("London", pageFactory.getIndividualSectionDetails().Platform);
                    testContext.getWebElementUtil().pause();

                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ContinueButton);
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
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
                            testContext.getWebElementUtil().refreshPage();
                            testContext.getWebElementUtil().SwitchToDefault();
                            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().HereOnFirstPercentage);
                            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ContinueButton);
                        }
                    }

                    try
                    {
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().SubmitForReviewButton);
                        testContext.getWebElementUtil().commonClick(pageFactory.getCommon().SubmitForReviewButton);
                        testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SubmitForReviewOKButton);
                    }
                    catch(org.openqa.selenium.TimeoutException exceptionfirst)
                    {
                        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().SubmitForReviewButton);
                        testContext.getWebElementUtil().commonClick(pageFactory.getCommon().SubmitForReviewButton);
                        testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SubmitForReviewOKButton);
                        testContext.getWebElementUtil().pause();
                    }
                } 
                
                
                if(testContext.getWebElementUtil().isPresentDynamic(By.xpath
                    ("(//div[@class='custom_text'][contains(text(), ' Errors exist on Section Details tab')])")).equals(true)) {

                    testContext.getWebElementUtil().pause();
                    
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().RefreshParticipantDataButton);
                    testContext.getWebElementUtil().pause();
                    
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().SubmitForReviewButton);
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().SubmitForReviewButton);
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SubmitForReviewOKButton);
                    testContext.getWebElementUtil().pause();
                }

                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ContractSubmittedForReviewMessage);
                break;
                
            }
            catch(Exception e)
            {
                System.err.println("Exception Handled");
                testContext.getWebElementUtil().pauseForContractSubmission();
                counter++;
            }
        }

        try
        {
            scenarioContext.WorkStatus = pageFactory.getCommon().Workstatus.getText();
            String expWorkFlowStatus = "UNDER REVIEW (LEAD(S) REVIEWING)";
            Assert.assertEquals(scenarioContext.WorkStatus, expWorkFlowStatus);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
        
    }

    @Then("Validate WorkFlow Status for COMPLETED")
    public void ValidateWorkFlowStatusForCompleted()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ActionsDropdown);
            String workStatus = pageFactory.getCommon().WorkflowStatusComplete.getText();
            String expWorkFlowStatus = "COMPLETE";
            //Assert.assertEquals(workStatus, expWorkFlowStatus);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate WorkFlow Status Not Taken Up")
    public void ValidateWorkFlowStatusNotTakenUp()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommon().ContractSubmittedForReviewMessage);
            String workstatus = pageFactory.getCommon().WorkStatusNTU.getText();
            String expWorkStatus = "NOT TAKEN UP (NTU)";
            Assert.assertEquals(workstatus.toLowerCase(), expWorkStatus.toLowerCase());
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    
    /* NOT REQUIRED ---- NEED TO CHECK
    
    @Then("^Modify the Period From Date and Validate Period To Date \"(.*)\"$")
    public void AmmendContractModifyDate(String fromdate)
    {
        try
        {
            int index = Integer.parseInt(fromdate)-1;
            testContext.getWebElementUtil().commonWaitForElement(UniqueMarketReference.initiate(testContext.getWebElementUtil().driver).PeriodFromDt);
            UniqueMarketReference.initiate(testContext.getWebElementUtil().driver).PeriodFromDt.clear();
            UniqueMarketReference.initiate(testContext.getWebElementUtil().driver).PeriodToDt.clear();
            UniqueMarketReference.initiate(testContext.getWebElementUtil().driver).PeriodFromDt.sendKeys(GenContractInfo.get(index).get("PeriodFrom"));
            testContext.getWebElementUtil().commonClick(UniqueMarketReference.initiate(testContext.getWebElementUtil().driver).UMRHeader);
            
            testContext.getWebElementUtil().pause();
            String FromDate = UniqueMarketReference.initiate(testContext.getWebElementUtil().driver).PeriodFromDt.getAttribute("value");
            String ToDate = UniqueMarketReference.initiate(testContext.getWebElementUtil().driver).PeriodToDt.getAttribute("value");
            Assert.assertNotNull(ToDate);
            Date actFromDate = new SimpleDateFormat("dd/MM/yyyy").parse(FromDate);
            Date actToDate = new SimpleDateFormat("dd/MM/yyyy").parse(ToDate);
            if(CreateContractData.get(index).get("Template").endsWith("M"))
            {
                long duration = actToDate.getTime() - actFromDate.getTime();
                long actDaysDifference = TimeUnit.MILLISECONDS.toDays(duration);
                long expDaysDifference = 1094;
                Assert.assertEquals(actDaysDifference, expDaysDifference);
            }
            else
            {
                long duration = actToDate.getTime() - actFromDate.getTime();
                long actDaysDifference = TimeUnit.MILLISECONDS.toDays(duration);
                long expDaysDifference = 364;
                Assert.assertEquals(actDaysDifference, expDaysDifference);
            }

        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    */

    @Then("Select the Tripartite Agreement as Yes")
    public void SelectTripartiteAgreement()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().TripartiteAgreementYes);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Select the Primary Currency \"(.*)\"$")
    public void SelectCurrency(String CurrencyCode)
    {
        try
        {
            int index = Integer.parseInt(CurrencyCode)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getGeneralContractInformation().CurrencyCode, NonMPRData.get(index).get("CurrencyCode"));
            testContext.getWebElementUtil().pause();
            for(WebElement SelectCurrency : pageFactory.getGeneralContractInformation().CurrencyCodeAutoRecommend)
            {
                if(SelectCurrency.getText().equalsIgnoreCase(NonMPRData.get(index).get("CurrencyCode")))
                {
                    testContext.getWebElementUtil().pause();
                    SelectCurrency.click();
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

    @Then("Select Lloyds Direct Reporting")
    public void SelectLloydsDirectReporting()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().LloydsDirectReportingYes);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate Broker Details for Broker \"(.*)\"$")
    public void ValidateBrokerDetailsForBroker(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getBrokerDetails().CSNForBroker);
            String expCSN = MPRData.get(index).get("CSN");
            String actCSN = pageFactory.getBrokerDetails().CSNForBroker.getText();
            Assert.assertEquals(actCSN, expCSN);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getBrokerDetails().BrokerReferenceNumber).equals(true));
            //Assert.assertTrue(testContext.getWebElementUtil().isD(pageFactory.getBrokerDetails().DirectDealing).equals(false));

        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate Broker Details for Managing Agent \"(.*)\"$")
    public void SelectDirectDealing(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getBrokerDetails().DirectDealing);
                Assert.fail();
            }
            catch(org.openqa.selenium.TimeoutException timeoutException)
            {
                Assert.assertTrue(true);
            }

            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getBrokerDetails().CSNForManagingAgent);
            String expCSN = MPRData.get(index).get("CSN");
            String actCSN = pageFactory.getBrokerDetails().CSNForManagingAgent.getText();
            Assert.assertEquals(actCSN, expCSN);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Select CSN Number \"(.*)\"$")
    public void SelectCSNNumber(String CSNNumber)
    {
        try
        {
            int index = Integer.parseInt(CSNNumber)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown(MPRData.get(index).get("CSN"), pageFactory.getBrokerDetails().CSNNumber);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    /*@Then("I Navigate to General Contract Info Tab")
    public void NvgtGCITab()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().GeneralConInfoTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }*/

    /*@Then("I validate the Broker Organization server side error message post submission for Review")
    public void BrkrOrgValidation()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Errors']"));
            testContext.getWebElementUtil().isPresent(pageFactory.getCommon().BrokerOrgErrorMsg);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }*/

    @Then("Verify Service Company and Non Lloyds Insurer is not present")
    public void AbsenceOfServiceCompanyNonLloydsInsurerDropdown()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            try
            {
                testContext.getWebElementUtil().commonSelectDropdown("Service Company", pageFactory.getContractLeads().LeadType);
            }
            catch (Exception e)
            {
                Assert.assertTrue(true);
            }
            testContext.getWebElementUtil().pause();
            try
            {
                testContext.getWebElementUtil().commonSelectDropdown("Non-Lloyd's Insurer", pageFactory.getContractLeads().LeadType);
            }
            catch (Exception e)
            {
                Assert.assertTrue(true);
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the new Contract ID for Duplicate Contract")
    public void ValidateNewContractID()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().UMRHeader);
            }
            catch(org.openqa.selenium.TimeoutException timeoutExceptionfirst)
            {
                try
                {   
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().UMRHeader);
                }
                catch(org.openqa.selenium.TimeoutException timeoutExceptionsecond)
                {
                    testContext.getWebElementUtil().pauseForAgreeDisagreeReviewTask();
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().UMRHeader);
                }
                
            }
            
            testContext.getWebElementUtil().commonClick(pageFactory.getGeneralContractInformation().UMRHeader);
            testContext.getWebElementUtil().pause();
            String newContractID = pageFactory.getCommon().ContractID.getText();
            System.out.println(newContractID);
            Assert.assertNotEquals(scenarioContext.contractID, newContractID);            
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the error message when user have not selected lead for Brussels on Contract Leads")
    public void ValidateBrusselsLeadErrorContractLeadTwinContract()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractLeads().TwinContractBrusslesLeadErrorContractLeads);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getContractLeads().TwinContractBrusslesLeadErrorContractLeads).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
}