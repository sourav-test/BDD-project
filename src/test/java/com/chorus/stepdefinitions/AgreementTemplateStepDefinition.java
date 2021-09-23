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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


/**
* Agreement Template Step Definition
* Select Template, Organisation, CSN, User Group
* 
*/

public class AgreementTemplateStepDefinition {

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
    
    public AgreementTemplateStepDefinition(TestContext testContext, ScenarioContext scenarioContext) 
    {
        this.testContext=testContext;
        this.scenarioContext=scenarioContext;
        pageFactory = testContext.getPageFactoryController();
        fileReaderController = testContext.getFileReaderController();
        MPRData = testContext.getFileReaderController().getExcelReader().GetTestData("MPRData");
        NonMPRData = testContext.getFileReaderController().getExcelReader().GetTestData("NonMPRData");
    }

    /**
     * This method is used to set the Agreement Template
     * given in the Feature file
     * @param testData = Template given in the feature file for a Scenario
     */
    
    @Given("Agreement Template \"(.*)\"$")
    public void getAgreementTemplate(String testData) 
    {
        scenarioContext.setAgreementTemplate = testData;
    }

    /**
     * This method is used to set the Contract Type
     * given in the Feature file
     * @param testData = Contract Type given in the feature file for a Scenario
     */

    @Given("Contract Type \"(.*)\"$")
    public void getContractType(String testData) 
    {
        scenarioContext.setContractType = testData;
    }

    /**
     * This method is used to set the Contract Status
     * given in the Feature file
     * @param testData = Contract Status given in the feature file for a Scenario
     */
    
    @Given("Contract Status \"(.*)\"$")
    public void getContractStatus(String testData) 
    {
        scenarioContext.setContractStatus = testData;
    }
    
    /**
     * This method is used to select the Template from Agreement Template
     * dropdown on Agreement Template page
     */
    
    @And("Select Agreement Template")
    public void SelectAgreementTemplate() 
    {
        try
        {
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getHome().PegaDefaultFrame);

            /* Exception Handle If Home Page doesn't get loaded or 502 Error */
            
            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getHome().CreateContractButton);
            }
            catch(org.openqa.selenium.TimeoutException exception)
            {
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().refreshPage();
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getHome().PegaDefaultFrame);
                testContext.getWebElementUtil().commonClick(pageFactory.getHome().CreateContractButton);
            }
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
            testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().TemplateField);

            if(scenarioContext.setAgreementTemplate.contains("Not Listed"))
            {
                String [] AgreementContractType = scenarioContext.setAgreementTemplate.split("-");
                String Agreement = AgreementContractType[0];
                String ContractType = AgreementContractType[1];
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getAgreementTemplate().SearchField, Agreement);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForList(pageFactory.getAgreementTemplate().ContractTypeList);
                for(WebElement SearchResult : pageFactory.getAgreementTemplate().ContractTypeList)
                {
                    if(SearchResult.getText().toLowerCase().equalsIgnoreCase(ContractType))
                    {
                        SearchResult.click();
                        break;
                    } 
                } 
            }
            else
            {
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getAgreementTemplate().SearchField, scenarioContext.setAgreementTemplate);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForList(pageFactory.getAgreementTemplate().ContractTypeList);
                
                WebElement SelectTemplate = testContext.getWebElementUtil().getDynamicElement
                    ("(//span[@class='match'][text()='"+scenarioContext.setAgreementTemplate+"'])[1]");
                SelectTemplate.click(); 
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to select the Organization from Organization
     * dropdown on Agreement Template page
     * @param testData = row number
     */

    @And("Select Organization \"(.*)\"$")
    public void SelectOrganization(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().OperatorOrganizationField);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForList(pageFactory.getAgreementTemplate().OrgCSNlist);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getAgreementTemplate().SearchField, MPRData.get(index).get("Organization"));
            testContext.getWebElementUtil().pause();
            for(WebElement SelectOrganization: pageFactory.getAgreementTemplate().OrgCSNlist)
            {
                if(SelectOrganization.getText().contains(MPRData.get(index).get("Organization")))
                {
                    SelectOrganization.click();
                    break;
                }
            }

            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getAgreementTemplate().DeleteOrgLink).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

     /**
     * This method is used to select the Central Settlement Number
     * from Central Settlement Number dropdown on Agreement Template page
     * @param testData = row number
     */

    @And("Select CSN \"(.*)\"$")
    public void SelectCSN(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().OperatorCSNField);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForList(pageFactory.getAgreementTemplate().OrgCSNlist);
            for(WebElement SelectCSN: pageFactory.getAgreementTemplate().OrgCSNlist)
            {
                if(SelectCSN.getText().contains(MPRData.get(index).get("CSN")))
                {
                    SelectCSN.click();
                    break;
                }
            }
            
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAgreementTemplate().DeleteCSNLink);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().AgreementTemplateHeader);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().OperatorCSNField);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForList(pageFactory.getAgreementTemplate().OrgCSNlist);
                for(WebElement SelectCSN: pageFactory.getAgreementTemplate().OrgCSNlist)
                {
                    if(SelectCSN.getText().contains(MPRData.get(index).get("CSN")))
                    {
                        SelectCSN.click();
                        break;
                    }
                }
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAgreementTemplate().DeleteCSNLink);
            }
            
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getAgreementTemplate().DeleteCSNLink).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to select the User Group from
     * User Group dropdown on Agreement Template page
     * @param testData = row number
     */

    @And("Select an User Group \"(.*)\"$")
    public void SelectUserGroup(String testData) 
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown(MPRData.get(index).get("UserGroup"), pageFactory.getAgreementTemplate().SelectUserGroup);
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAgreementTemplate().UserGroupDeleteLink);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSelectDropdown(MPRData.get(index).get("UserGroup"), pageFactory.getAgreementTemplate().SelectUserGroup);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAgreementTemplate().UserGroupDeleteLink);
            }
            
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getAgreementTemplate().UserGroupDeleteLink).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate that user or Contract Creator
     * can delete the added User Group on Agreement Template page
     */

    @Then("Validate user is able to delete User Group")
    public void ValidateUserIsAbleToDeleteuserGroup()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().UserGroupDeleteLink);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().AcceptAlert();
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getAgreementTemplate().UserGroupDeleteLink).equals(false));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate the Multiyear Template Message is present
     * on Agreement Template page when Contract Creator is selecting Multiyear Template
     */

    @Then("Validate the Multi Year Contract Message")
    public void MultiYearContractMessage() 
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAgreementTemplate().MultiYearTemplateMessage);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getAgreementTemplate().MultiYearTemplateMessage).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate the Endorsement Reference Number
     * when Contract Creator is creating Endorsement for first time
     */

    @Then("Validate Endorsement Reference For First Endorsement")
    public void ValidateEndorsementReferenceForFirstEndorsement() 
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAgreementTemplate().EndorsementReferenceNumber);
            String actualreferencenumber = "001";
            String expectedreferencenumber = pageFactory.getAgreementTemplate().EndorsementReferenceNumber.getAttribute("value");
            Assert.assertEquals(actualreferencenumber, expectedreferencenumber);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Set or Enter the Endorsement Effective Date
     * @param testData = row number
     */

    @And("Enter Endorsement Effective Date \"(.*)\"$")
    public void EnterEndorsementEffectiveDate(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAgreementTemplate().EndorsementEffectiveDate);
                testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().CalendarIconForEndorsement);
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
                else if(scenarioContext.setContractStatus.equalsIgnoreCase("Expired"))
                {
                    String dateForExpiredContract [] = testContext.getWebElementUtil().ChangePeriodFromDate(-30).split("-");
                    String day = dateForExpiredContract [1];
                    String month = dateForExpiredContract[0];
                    String year = dateForExpiredContract [2];
                
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
            catch(org.openqa.selenium.TimeoutException timeoutException)
            {
                /* Exception handling for Contract Status -- Logout and Login Again */
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
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractRecord().CreateEndorsementButton);
                testContext.getWebElementUtil().commonClick(pageFactory.getContractRecord().CreateEndorsementButton);

                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAgreementTemplate().EndorsementEffectiveDate);
                testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().CalendarIconForEndorsement);
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
                else if(scenarioContext.setContractStatus.equalsIgnoreCase("Expired"))
                {
                    String dateForExpiredContract [] = testContext.getWebElementUtil().ChangePeriodFromDate(-30).split("-");
                    String day = dateForExpiredContract [1];
                    String month = dateForExpiredContract[0];
                    String year = dateForExpiredContract [2];
                
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
                        
            testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().EndorsementEffectiveDateLabel);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().NextButton);
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().WaitTillFrameLoadRenewEndorse(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    /**
     * This method is used to Set or Enter the Changes Made
     * for Endorsement on Endorsement Agreement Template page
     */
    
    @And("Enter Changes Made and Confirmation Date")
    public void EnterConfirmationDate() 
    {
        try
        {
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getAgreementTemplate().EndorsementDetails, testContext.getWebElementUtil().GetCurrentDateMDY());
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAgreementTemplate().EndorsementConfirmationDate);
            testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().EndorsementConfirmationDateCalendar);
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
            else if(scenarioContext.setContractStatus.equalsIgnoreCase("Expired"))
            {
                String dateForExpiredContract [] = testContext.getWebElementUtil().ChangePeriodFromDate(-30).split("-");
                String day = dateForExpiredContract [1];
                String month = dateForExpiredContract[0];
                String year = dateForExpiredContract [2];
                
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

    /**
     * This method is used to Set or Enter the Changes Made
     * for Reassign on Reassign Agreement Template page
     */

    @And("Enter Changes Made for Resign")
    public void EnterChangesMadeForResign() 
    {
        try
        {
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getAgreementTemplate().EndorsementDetails, testContext.getWebElementUtil().GetCurrentDateMDY());
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Upload Copy of Signed Endorsement
     * for Endorsement on Endorsement Agreement Template page
     */

    @Then("Upload a Copy Of Signed Endorsement")
    public void UploadSignedEndorsement() 
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().AttachButton);
            testContext.getWebElementUtil().pause();
            String projectdirectory = System.getProperty("user.dir");
            String filepath = projectdirectory+"\\src\\test\\resources\\TestData\\TestDocument.txt";
            testContext.getWebElementUtil().pause();

            pageFactory.getAgreementTemplate().UploadEndorsementCopyPath.sendKeys(filepath);

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Fully Signed Endorsement", pageFactory.getCommon().SelectTag);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Medium", pageFactory.getCommon().Classification);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().AttachButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Upload Copy of Notice Of Termination 
     * Served for Termination Endorsement on Termination Endorsement 
     * Agreement Template page
     */

    @Then("Upload Copy of Notice Of Termination Served")
    public void UploadNoticeOfTermination() 
    {
        try
        {
            testContext.getWebElementUtil().pause();
            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().TerminationNoticeUploadButton);   
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().TerminationNoticeUploadButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaEndorsementFrame);
                    testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().TerminationNoticeUploadButton);
                }      
            }
            
            
            testContext.getWebElementUtil().pause();
            String projectdirectory = System.getProperty("user.dir");
            String filepath = projectdirectory+"\\src\\test\\resources\\TestData\\TestDocument.txt";
            testContext.getWebElementUtil().pause();

            pageFactory.getAgreementTemplate().UploadEndorsementCopyPath.sendKeys(filepath);

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Fully Signed Endorsement", pageFactory.getCommon().SelectTag);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Medium", pageFactory.getCommon().Classification);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().AttachButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate the Error Message when 
     * Contract Creator is trying to proceed without selecting
     * User Group on Agreement Template page
     */
    
    @Then("Validate the User Group error message")
    public void ValidateUserGroupErrorMessage() 
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAgreementTemplate().UserGroupErrorMessage);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getAgreementTemplate().UserGroupErrorMessage).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Validate the Error Message when 
     * Contract Creator is trying to proceed without selecting
     * User Group on Agreement Template page
     */
    
    @And("Clear the Endorsement Effective Date on Core Questions")
    public void ClearEndorsementEffectiveDateCoreQuestions() 
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAgreementTemplate().EndorsementEffectiveDateCoreQuestions);
            testContext.getWebElementUtil().commonClearField(pageFactory.getAgreementTemplate().EndorsementEffectiveDateCoreQuestions);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Clear the Termination Endorsement Effective Date on Core Questions")
    public void ClearTerminationEndorsementEffectiveDateCoreQuestions() {

        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAgreementTemplate().TerminationEndorsementEffectiveDateCoreQuestions);
            testContext.getWebElementUtil().commonClearField(pageFactory.getAgreementTemplate().TerminationEndorsementEffectiveDateCoreQuestions);
            testContext.getWebElementUtil().commonClick(pageFactory.getAgreementTemplate().AssociatedContentHeader);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

}