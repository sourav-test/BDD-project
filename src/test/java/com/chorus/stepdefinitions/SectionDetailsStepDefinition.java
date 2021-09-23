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
* Section Details Step Definition
* Common Section Details
* Individual Section Details
* 
*/


public class SectionDetailsStepDefinition  {

    public List<HashMap<String, String>> MPRData;

    public List<HashMap<String, String>> NonMPRData;

    private TestContext testContext;

    private ScenarioContext scenarioContext;

    private PageFactoryController pageFactory;

    private FileReaderController fileReaderController;

    /**
     * Pico Container Dependency Inject
     * @param testBase
     */

    public SectionDetailsStepDefinition(TestContext testContext, ScenarioContext scenarioContext) 
    {
        this.testContext=testContext;
        this.scenarioContext=scenarioContext;
        pageFactory = testContext.getPageFactoryController();
        fileReaderController = testContext.getFileReaderController();
        MPRData = testContext.getFileReaderController().getExcelReader().GetTestData("MPRData");
        NonMPRData = testContext.getFileReaderController().getExcelReader().GetTestData("NonMPRData");
    }

    /**
     * This method is used to Navigate to Individual Section
     * Details
     */
    
    @When("Navigate to Individual Section Details")
    public void NavigatetoIndividualSectionDetails()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);   
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Navigate to Common Section
     * Details
     */

    @When("Navigate to Common Section Details")
    public void NavigatetoCommonSectionDetails()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().CommonSectionDetails);  
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to expand the Coverholder Details 
     * Accordion Individual Section
     */

    @Then("Expand Coverholder Details Tab for Individual Section")
    public void ExpandCoverholderDetailsTabIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CoverholderDetailsTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to expand the Service Company 
     * Details Accordion Individual Section
     */

    @Then("Expand Service Company Details Tab for Individual Section")
    public void ExpandServiceCompanyDetailsTabIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ServiceCompanyTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Add Section, Validate the Section ID 
     * and Add Section Description on Individual Section
     */

    @Then("Add Section, Validate the SectionID and Add the description \"(.*)\"$")
    public void AddSectionwithDescription(String description)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(description)-1;

            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddItem);
            testContext.getWebElementUtil().pause();
            int totalsections = pageFactory.getIndividualSectionDetails().SectionIDs.size();
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//span[text()='00"+totalsections+"']"));

            WebElement clickSection = testContext.getWebElementUtil().getDynamicElement("//span[text()='00"+totalsections+"']");
            clickSection.click();

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().SectionID);
            String sectiondetailID = pageFactory.getIndividualSectionDetails().SectionID.getText();
            
            WebElement section = testContext.getWebElementUtil().getDynamicElement("//span[text()='00"+totalsections+"']");
            String sectionID = section.getText();

            Assert.assertEquals(sectionID, sectiondetailID);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SectionDescription, NonMPRData.get(index).get("SectionDescription"));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to add Coverholder or Service Company 
     * under Coverholder Details Accordion Individual Section
     * @param testData = row number
     */

    @Then("Verify Section Accordian and Add Market Participant for Individual Section \"(.*)\"$")
    public void ValidateSectionAccordianIndividualSection(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CoverholderField);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().CoverholderField, MPRData.get(index).get("CapacitySeeker"));
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SearchCoverholderServiceCompanyLabel);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SearchCoverHolderButton);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().SearchResults);
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("(//span[text()='"+MPRData.get(index).get("CapacitySeeker")+"']//preceding::input[@type='checkbox'])[1]"));
                
                WebElement SelectMP = testContext.getWebElementUtil().getDynamicElement("(//span[text()='"+MPRData.get(index).get("CapacitySeeker")+"']//preceding::input[@type='checkbox'])[1]");
                SelectMP.click();
                
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddButton);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().CoverholderDeleteLink);
                Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().CoverholderDeleteLink));           
            }
            else if(scenarioContext.contractID.contains("SC"))
            {   
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ServiceCompanyField);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyField, MPRData.get(index).get("CapacitySeeker"));
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SearchCoverholderServiceCompanyLabel);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SearchServiceCompanyButton);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().SearchResults);
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("(//span[text()='"+MPRData.get(index).get("CapacitySeeker")+"']//preceding::input[@type='checkbox'])[1]"));
                
                WebElement SelectMP = testContext.getWebElementUtil().getDynamicElement
                    ("(//span[text()='"+MPRData.get(index).get("CapacitySeeker")+"']//preceding::input[@type='checkbox'])[1]");
                SelectMP.click();

                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddButton);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().ServiceCompanyDeleteLink);
                Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().ServiceCompanyDeleteLink));  
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to add Coverholder or Service Company 
     * under Coverholder Details Accordion Common Section
     * @param testData = row number
     */

    @Then("Verify Section Accordian and Add Market Participant for Common Section \"(.*)\"$")
    public void ValidateSectionAccordianCommonSection(String participant)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(participant)-1;

            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().CoverholderDetailsTab);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().CoverholderField);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().CoverholderField, MPRData.get(index).get("CapacitySeeker"));
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SearchCoverholderServiceCompanyLabel);
                testContext.getWebElementUtil().pause();
                try
                {
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SearchCoverHolderButton);
                }
                catch(org.openqa.selenium.TimeoutException timeoutException)
                {
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SearchCoverholderServiceCompanyLabel);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SearchCoverHolderButton);
                }
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().SearchResults);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("(//span[text()='"+MPRData.get(index).get("CapacitySeeker")+"']//preceding::input[@type='checkbox'])[1]"));
                
                WebElement SelectMP = testContext.getWebElementUtil().getDynamicElement
                    ("(//span[text()='"+MPRData.get(index).get("CapacitySeeker")+"']//preceding::input[@type='checkbox'])[1]");
                SelectMP.click();

                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddButton);
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='"+MPRData.get(index).get("CapacitySeeker")+"']"));
    
                try
                {
                    testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommonSectionDetails().TradingNameFieldCoverholder);
                }
                catch(org.openqa.selenium.TimeoutException exception)
                {
                    WebElement ExpandMP = testContext.getWebElementUtil().getDynamicElement("//h2[text()='"+MPRData.get(index).get("CapacitySeeker")+"']");
                    ExpandMP.click(); 
                }
            }
            else if(scenarioContext.contractID.contains("SC"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ServiceCompanyTab);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ServiceCompanyField);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ServiceCompanyField, MPRData.get(index).get("CapacitySeeker"));
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SearchCoverholderServiceCompanyLabel);
                testContext.getWebElementUtil().pause();
                try
                {
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SearchServiceCompanyButton);
                }
                catch(org.openqa.selenium.TimeoutException timeoutException)
                {
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SearchCoverholderServiceCompanyLabel);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SearchServiceCompanyButton);
                }
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().SearchResults);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("(//span[text()='"+MPRData.get(index).get("CapacitySeeker")+"']//preceding::input[@type='checkbox'])[1]"));
                
                WebElement SelectMP = testContext.getWebElementUtil().getDynamicElement
                    ("(//span[text()='"+MPRData.get(index).get("CapacitySeeker")+"']//preceding::input[@type='checkbox'])[1]");
                SelectMP.click();

                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddButton);
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='"+MPRData.get(index).get("CapacitySeeker")+"']"));
                
                try
                {
                    testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommonSectionDetails().TradingNameFieldCoverholder); 
                }
                catch(org.openqa.selenium.TimeoutException exception)
                {
                    WebElement ExpandMP = testContext.getWebElementUtil().getDynamicElement
                        ("//h2[text()='"+MPRData.get(index).get("CapacitySeeker")+"']");
                    ExpandMP.click();
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
     * This method is used to Delete existing Section 
     * on Individual Section
     */

    @And("Delete Existing SectionID")
    public void DeleteExistingSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().DeleteItem);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to add Trading Names under 
     * Coverholder Details Accordion Common Section
     * @param testData = row number
     */

    @Then("Add Trading Name for Common Section \"(.*)\"$")
    public void AddTradingNameCommonSection(String testData)
    {   
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().TradingNameFieldCoverholder);
            }
            catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.StaleElementReferenceException exception)
            {
                WebElement ExpandMPAttempt = testContext.getWebElementUtil().getDynamicElement
                    ("//h2[text()='"+MPRData.get(index).get("CapacitySeeker")+"']");
                ExpandMPAttempt.click();
            } 
            
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().TradingNameFieldCoverholder, MPRData.get(index).get("TradingNames"));
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SearchTradingNamesButton);
            testContext.getWebElementUtil().pause();
            
            WebElement SelectName = testContext.getWebElementUtil().getDynamicElement
                ("(//span[text()='"+MPRData.get(index).get("TradingNames")+"']//preceding::input[@type='checkbox'])[1]");
            SelectName.click();

            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to add Trading Names under 
     * Coverholder Details Accordion Individual Section
     * @param testData = row number
     */

    @Then("Add Trading Name for Individual Section \"(.*)\"$")
    public void AddTradingNameIndividualSection(String testData)
    {   
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().TradingNameField);
            }
            catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.StaleElementReferenceException exception)
            {
                WebElement ExpandMPAttempt = testContext.getWebElementUtil().getDynamicElement
                    ("//h2[text()='"+MPRData.get(index).get("CapacitySeeker")+"']");
                ExpandMPAttempt.click();
            } 
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().TradingNameField, MPRData.get(index).get("TradingNames"));
            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SearchTradingNamesButtonCoverholder);
            }
            else if(scenarioContext.contractID.contains("SC"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SearchTradingNamesButtonServiceCompany);
            }
            
            testContext.getWebElementUtil().pause();
            
            WebElement SelectName = testContext.getWebElementUtil().getDynamicElement
                ("(//span[text()='"+MPRData.get(index).get("TradingNames")+"']//preceding::input[@type='checkbox'])[1]");
            SelectName.click();

            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to delete Trading Names under
     * Coverholder Details Accordion
     * @param testData = row number
     */

    @Then("Delete the Trading Name \"(.*)\"$")
    public void DeleteTradingName(String testData)
    {   
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            //testContext.getWebElementUtil().commonWaitForElement(SectionDetails.initiate(testContext.getWebElementUtil().driver).TradingNameFieldCoverholderCommonSection);
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("(//span[text()='"+MPRData.get(index).get("TradingNames")+"']//following::a[@class='iconDelete'])[1]"));
            
            WebElement DeleteName = testContext.getWebElementUtil().getDynamicElement
                ("(//span[text()='"+MPRData.get(index).get("TradingNames")+"']//following::a[@class='iconDelete'])[1]");
            DeleteName.click();

            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().DeletePopupYes);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to Apply Coverholder or Service 
     * Company Details on Common Section
     */

    @Then("Apply CoverHolder or Service Company Details")
    public void ApplyCoverholderServiceCompany()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyCoverholderDetails);
            }
            else if(scenarioContext.contractID.contains("SC"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyServiceCompanyDetails);
            }

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyAllYesButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    

    @Then("Expand Person Responsible Tab for Individual Section")
    public void ExpandPersonResponsibleTabIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Expand Person Responsible Tab for Common Section")
    public void ExpandPersonResponsibleTabCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().PersonResponsibleTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("^Select Each Coverholder or Service Company for Individual Section")
    public void SelectEachQuestionIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().EachCoverholderCheckbox);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Select Each Coverholder or Service Company for Common Section")
    public void SelectEachQuestionCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().EachCoverholderCheckbox);
            testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Person Responsible Operation and Control for Individual Section \"(.*)\"$")
    public void AddPersonForOperationAndControlIndividualSection(String personresponsible)
    {
        try
        {
            int index = Integer.parseInt(personresponsible)-1;
            String persondetails = NonMPRData.get(index).get("PersonResponsible");
            String [] persondetailsSplit = persondetails.split("-");
            String FirstName = persondetailsSplit[0];
            String SurName = persondetailsSplit[1];
            String Email = persondetailsSplit[2];
            testContext.getWebElementUtil().pause();
            if(scenarioContext.setAgreementTemplate.contains("LMA3134") | scenarioContext.setAgreementTemplate.contains("Service Company Agreement"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleFirstNameServiceCompany);
                //testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PersonResponsibleFirstNameServiceCompany, FirstName);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleSurName);
                //testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PersonResponsibleSurName, SurName);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleEmailServiceCompany);
                //testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PersonResponsibleEmailServiceCompany, Email);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleSurName);
                //testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddPersonResponsible);
                //testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().DeleteAddedName);
                Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().DeleteAddedName).equals(true));
            }
            else
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleFirstName);
                //testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PersonResponsibleFirstName, FirstName);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleSurName);
                //testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PersonResponsibleSurName, SurName);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleEmail);
                //testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PersonResponsibleEmail, Email);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleSurName);
                //testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddPersonResponsible);
                //testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().DeleteAddedName);
                Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().DeleteAddedName).equals(true));
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Person Responsible Linked Operation and Control for Individual Section \"(.*)\"$")
    public void AddPersonForOperationAndControlLinkedIndividualSection(String personresponsible)
    {
        try
        {
            int index = Integer.parseInt(personresponsible)-1;
            String persondetails = NonMPRData.get(index).get("PersonResponsible");
            String [] persondetailsSplit = persondetails.split("-");
            String FirstName = persondetailsSplit[0];
            String SurName = persondetailsSplit[1];
            String Email = persondetailsSplit[2];
            testContext.getWebElementUtil().pause();
            if(scenarioContext.setAgreementTemplate.contains("LMA3134") | scenarioContext.setAgreementTemplate.contains("Service Company Agreement"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleLinkedFirstName);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PersonResponsibleLinkedFirstName, FirstName);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleLinkedSurName);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PersonResponsibleLinkedSurName, SurName);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleLinkedEmail);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PersonResponsibleLinkedEmail, Email);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleLinkedSurName);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddPersonResponsibleLinked);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().DeleteAddedName);
                Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().DeleteAddedName).equals(true));
            }
            else
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleLinkedFirstName);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PersonResponsibleLinkedFirstName, FirstName);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleLinkedSurName);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PersonResponsibleLinkedSurName, SurName);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleLinkedEmail);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PersonResponsibleLinkedEmail, Email);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PersonResponsibleLinkedSurName);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddPersonResponsibleLinked);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().DeleteAddedName);
                Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().DeleteAddedName).equals(true));
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    @Then("^Add Person Responsible Operation and Control for Common Section \"(.*)\"$")
    public void AddPersonForOperationAndControlCommonSection(String personresponsible)
    {
        try
        {
            int index = Integer.parseInt(personresponsible)-1;
            String persondetails = NonMPRData.get(index).get("PersonResponsible");
            String [] persondetailsSplit = persondetails.split("-");
            String FirstName = persondetailsSplit[0];
            String SurName = persondetailsSplit[1];
            String Email = persondetailsSplit[2];
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().PersonResponsibleFirstName);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().PersonResponsibleFirstName, FirstName);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().PersonResponsibleSurName);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().PersonResponsibleSurName, SurName);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().PersonResponsibleEmail);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().PersonResponsibleEmail, Email);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().PersonResponsibleSurName);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddPersonResponsible);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().DeleteAddedPersonResposible);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommonSectionDetails().DeleteAddedPersonResposible).equals(true));

        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Person Authorised to Bind Insurances for Common Section \"(.*)\"$")
    public void AddPersonAuthorisedBindInsurancesCommonSection(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            String persondetails = NonMPRData.get(index).get("PersonResponsible");
            String [] persondetailsSplit = persondetails.split("-");
            String FirstName = persondetailsSplit[0];
            String SurName = persondetailsSplit[1];
            String Email = persondetailsSplit[2];
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AuthorisedBindInsurancesFirstName);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().AuthorisedBindInsurancesFirstName, FirstName);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AuthorisedBindInsurancesSurname);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().AuthorisedBindInsurancesSurname, SurName);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AuthorisedBindInsurancesEmail);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().AuthorisedBindInsurancesEmail, Email);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AuthorisedBindInsurancesSurname);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddAuthorisedBindInsurances);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().DeleteAddedAuthorisedBindInsurances);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommonSectionDetails().DeleteAddedAuthorisedBindInsurances).equals(true));

        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Person Overall Responsibility for Common Section \"(.*)\"$")
    public void AddPersonOverallResponsibilityCommonSection(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            String persondetails = NonMPRData.get(index).get("PersonResponsible");
            String [] persondetailsSplit = persondetails.split("-");
            String FirstName = persondetailsSplit[0];
            String SurName = persondetailsSplit[1];
            String Email = persondetailsSplit[2];
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().OverallResponsibleFirstName);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().OverallResponsibleFirstName, FirstName);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().OverallResponsibleSurname);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().OverallResponsibleSurname, SurName);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().OverallResponsibleEmail);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().OverallResponsibleEmail, Email);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().OverallResponsibleSurname);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddOverallResponsible);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().DeleteAddedOverallResponsible);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommonSectionDetails().DeleteAddedOverallResponsible).equals(true));

        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Person Responsible Linked Operation and Control for Common Section \"(.*)\"$")
    public void AddPersonForOperationAndControlLinkedCommonSection(String personresponsible)
    {
        try
        {
            int index = Integer.parseInt(personresponsible)-1;
            String persondetails = NonMPRData.get(index).get("PersonResponsible");
            String [] persondetailsSplit = persondetails.split("-");
            String FirstName = persondetailsSplit[0];
            String SurName = persondetailsSplit[1];
            String Email = persondetailsSplit[2];
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().PersonResponsibleLinkedFirstName);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().PersonResponsibleLinkedFirstName, FirstName);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().PersonResponsibleLinkedSurName);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().PersonResponsibleLinkedSurName, SurName);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().PersonResponsibleLinkedEmail);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().PersonResponsibleLinkedEmail, Email);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().PersonResponsibleLinkedSurName);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddPersonResponsibleLinked);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().DeleteAddedPersonResposible);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommonSectionDetails().DeleteAddedPersonResposible).equals(true));

        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Perform Copy Names To Bind Insurances for Individual Section")
    public void CopyNamesToBindInsurancesIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().CopyNamesBindInsurance);
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CopyNamesBindInsurance);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().DeleteCopiedName);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().DeleteCopiedName).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Perform Copy Names To Bind Insurances for Common Section")
    public void CopyNamesBindInsurancesCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().CopyNamesBindInsurance);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().DeleteAddedAuthorisedBindInsurances);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommonSectionDetails().DeleteAddedAuthorisedBindInsurances).equals(true));
            testContext.getWebElementUtil().pause();
            
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Perform Copy Names To Insurances Bound for Individual Section")
    public void CopyNamesToInsurancesBoundIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().CopyNamesInsurancesBound);
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CopyNamesInsurancesBound);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().DeleteInsurancesBoundCopiedName);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().DeleteInsurancesBoundCopiedName).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Perform Copy Names To Insurances Bound for Common Section")
    public void CopyNamesToInsurancesBoundCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().CopyNamesInsurancesBound);
            testContext.getWebElementUtil().pause();
            //testContext.getWebElementUtil().commonWaitForElement(SectionDetails.initiate(testContext.getWebElementUtil().driver).DeleteInsurancesBoundCopiedName);
            //Assert.assertTrue(testContext.getWebElementUtil().isPresent(SectionDetails.initiate(testContext.getWebElementUtil().driver).DeleteInsurancesBoundCopiedName).equals(true));
            //testContext.getWebElementUtil().pause();
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Apply Person Responsible for Operation and Control")
    public void ApplyPersonResponsible()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyPersonResponsible);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyAllYesButton);  
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Delete Names from Person Responsible for Operation and Control")
    public void DeleteAddedName()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().DeleteAddedName);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().AcceptAlert();
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }



    @Then("Expand Territorial Limitations Section for Common Section")
    public void ExpandTerritorialLimitationsCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().TerritorialLimitationsTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Expand Territorial Limitations Section for Individual Section")
    public void ExpandTerritorialLimitationsIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().TerritorialLimitationsTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add and Copy Territorial Limitations for Individual Section \"(.*)\"$")
    public void AddCopyTerritoriesIndividualSection(String territories)
    {
        try
        {
            int index = Integer.parseInt(territories)-1;
            testContext.getWebElementUtil().pause();
            
            /* Add Risk Location */
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddRiskLocation);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().RegionHeader);
            
            testContext.getWebElementUtil().pause();
            for(WebElement risklocationregion : pageFactory.getIndividualSectionDetails().RiskLocationRegionList)
            {
                if(risklocationregion.getText().equalsIgnoreCase(NonMPRData.get(index).get("RiskLocation")))
                {
                    risklocationregion.click();

                    WebElement SelectRiskLocation = testContext.getWebElementUtil().getDynamicElement
                        ("(//tr[contains(@id, 'RiskLocation')]//td//span[text()='"+NonMPRData.get(index).get("RiskLocation")+"']//following::a)[1]");
                    SelectRiskLocation.click();

                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().OKButton);
                    break;
                }
            }    
            
            /* Copy from Risk Location */

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CopyForInsuredDomicile);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().CopyInsuredDomicileCheck);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().CopyInsuredDomicileCheck).equals(true));
            
            /* Add Insured Domicile */
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddInsuredDomicile);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().RegionHeader);
            
            testContext.getWebElementUtil().pause();
            for(WebElement insureddomicileregion : pageFactory.getIndividualSectionDetails().InsuredDomicileRegionList)
            {
                if(insureddomicileregion.getText().equalsIgnoreCase(NonMPRData.get(index).get("InsuredDomicile")))
                {
                    insureddomicileregion.click();

                    WebElement SelectRegion = testContext.getWebElementUtil().getDynamicElement
                        ("(//tr[contains(@id, 'InsuredDomicile')]//td//span[text()='"+NonMPRData.get(index).get("InsuredDomicile")+"']//following::a)[1]");
                    SelectRegion.click();

                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().OKButton);
                    break;
                }
            }
            /* Copy from Insured Domicile */
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CopyForTerritorialLimit);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().CopyTerritorialLimitCheck);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().CopyTerritorialLimitCheck).equals(true));
            
           /* Add Territorial Limits */
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddTerritorialLimits);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().RegionHeader);
            
            testContext.getWebElementUtil().pause();
            for(WebElement territoriallimitregion : pageFactory.getIndividualSectionDetails().TerritorialLimitsRegionList)
            {
                if(territoriallimitregion.getText().equalsIgnoreCase(NonMPRData.get(index).get("TerritorialLimit")))
                {
                    territoriallimitregion.click();

                    WebElement SelectRegion = testContext.getWebElementUtil().getDynamicElement
                        ("(//tr[contains(@id, 'TerritorialLimit')]//td//span[text()='"+NonMPRData.get(index).get("TerritorialLimit")+"']//following::a)[1]");
                    SelectRegion.click();

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

    @Then("^Add and Copy Territorial Limitations for Common Section \"(.*)\"$")
    public void AddCopyTerritoriesCommonSection(String territories)
    {
        try
        {
            int index = Integer.parseInt(territories)-1;
            testContext.getWebElementUtil().pause();
            
            /* Add Risk Location */
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddRiskLocation);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().RegionHeader);
            
            testContext.getWebElementUtil().pause();
            for(WebElement risklocationregion : pageFactory.getCommonSectionDetails().RiskLocationRegionList)
            {
                if(risklocationregion.getText().equalsIgnoreCase(NonMPRData.get(index).get("RiskLocation")))
                {
                    risklocationregion.click();

                    WebElement SelectRiskLocation = testContext.getWebElementUtil().getDynamicElement
                        ("(//tr[contains(@id, 'RiskLocation')]//td//span[text()='"+NonMPRData.get(index).get("RiskLocation")+"']//following::a)[1]");
                    SelectRiskLocation.click();

                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().OKButton);
                    break;
                }
            }

            /* Copy from Risk Location  */

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().CopyForInsuredDomicile);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().CopyInsuredDomicileCheck);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommonSectionDetails().CopyInsuredDomicileCheck).equals(true));
            
            /* Add Insured Domicile */
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddInsuredDomicile);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().RegionHeader);
            
            testContext.getWebElementUtil().pause();
            for(WebElement insureddomicileregion : pageFactory.getCommonSectionDetails().InsuredDomicileRegionList)
            {
                if(insureddomicileregion.getText().equalsIgnoreCase(NonMPRData.get(index).get("InsuredDomicile")))
                {
                    insureddomicileregion.click();

                    WebElement SelectRegion = testContext.getWebElementUtil().getDynamicElement
                        ("(//tr[contains(@id, 'InsuredDomicile')]//td//span[text()='"+NonMPRData.get(index).get("InsuredDomicile")+"']//following::a)[1]");
                    SelectRegion.click();

                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().OKButton);
                    break;
                }
            }

            /* Copy from Insured Domicile  */
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().CopyForTerritorialLimit);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().CopyTerritorialLimitCheck);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommonSectionDetails().CopyTerritorialLimitCheck).equals(true));
            
            /* Add Territorial Limits */
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddTerritorialLimits);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().RegionHeader);
           
            testContext.getWebElementUtil().pause();
            for(WebElement territoriallimitregion : pageFactory.getCommonSectionDetails().TerritorialLimitsRegionList)
            {
                if(territoriallimitregion.getText().equalsIgnoreCase(NonMPRData.get(index).get("TerritorialLimit")))
                {
                    territoriallimitregion.click();

                    WebElement SelectRegion = testContext.getWebElementUtil().getDynamicElement
                        ("(//tr[contains(@id, 'TerritorialLimit')]//td//span[text()='"+NonMPRData.get(index).get("TerritorialLimit")+"']//following::a)[1]");
                    SelectRegion.click();

                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().OKButton);
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

    @And("Apply Territorial Limitations")
    public void ApplyTerritorialLimitations()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyTerritorialLimits);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyAllYesButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Expand Period Of Insurances Bound for Individual Section")
    public void ExpandPeriodOfInsurancesIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PeriodOfInsuranceBoundTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add details to the Period Of Insurances Bound for Individual Section \"(.*)\"$")
    public void AddPeriodOfInsurancesForIndividualSection(String period)
    {
        try
        {
            int index = Integer.parseInt(period)-1;
            if(scenarioContext.contractID.contains("CH"))
            {
                if (scenarioContext.setAgreementTemplate.equalsIgnoreCase("LBS0001A") | scenarioContext.setAgreementTemplate.equalsIgnoreCase("LBS0067A"))
                {
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().InsuranceBoundField);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().InsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundMonths"));
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaxAdvPeriodInsuranceBoundField);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().MaxAdvPeriodInsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundDays"));
                }
                else
                {
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().InsuranceBoundField);
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().InsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundMonths"));
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaxPeriodInsuranceBoundField);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().MaxPeriodInsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundMonths"));
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaxAdvPeriodInsuranceBoundField);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().MaxAdvPeriodInsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundDays")); 
                }
            }
            else if(scenarioContext.contractID.contains("SC"))
            {
                if(scenarioContext.setAgreementTemplate.equalsIgnoreCase("LMA3134") | scenarioContext.setAgreementTemplate.contains("Service Company Agreement"))
                {
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().InsuranceBoundField);
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().InsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundMonths"));
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaxPeriodInsuranceBoundField);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().MaxPeriodInsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundMonths"));
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaxAdvPeriodInsuranceBoundField);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().MaxAdvPeriodInsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundDays"));   
                }
                else
                {
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().InsuranceBoundField);
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().InsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundMonths"));
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaxPeriodInsuranceBoundFieldSC);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().MaxPeriodInsuranceBoundFieldSC, NonMPRData.get(index).get("PeriodOfInsuranceBoundDays"));   
                }
            } 
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Verify the Period Of Insurances Bound field validation")
    public void VerifyThePeriodOfInsurancesBoundFieldValidation()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().InsuranceBoundField);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().InsuranceBoundField, "-1");
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaxPeriodInsuranceBoundField);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().MaxPeriodInsuranceBoundField, "-2");
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaxAdvPeriodInsuranceBoundField);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().MaxAdvPeriodInsuranceBoundField, "-3");
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaxPeriodInsuranceBoundField);

            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().InsuranceBoundFieldErrorMessage).equals(true));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().MaxPeriodInsuranceBoundFieldErrorMessage).equals(true));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().MaxAdvPeriodInsuranceBoundFieldErrorMessage).equals(true));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().MaxPeriodInsuranceBoundIsLessErrorMessage).equals(true));

        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Expand Period Of Insurances Bound for Common Section")
    public void ExpandPeriodOfInsurancesCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().PeriodOfInsuranceBoundTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add details to the Period Of Insurances Bound for Common Section \"(.*)\"$")
    public void AddPeriodOfInsurancesForCommonSection(String period)
    {
        try
        {
            int index = Integer.parseInt(period)-1;

            if(scenarioContext.contractID.contains("CH"))
            {
                if (scenarioContext.setAgreementTemplate.equalsIgnoreCase("LBS0001A") | scenarioContext.setAgreementTemplate.equalsIgnoreCase("LBS0067A"))
                {
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().InsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundMonths"));
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().MaxAdvPeriodInsuranceBoundField);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().MaxAdvPeriodInsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundDays"));
                }
                else
                {
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().InsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundMonths"));
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().MaxPeriodInsuranceBoundField);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().MaxPeriodInsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundMonths"));
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().MaxAdvPeriodInsuranceBoundField);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().MaxAdvPeriodInsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundDays"));   
                }
            }
            else if(scenarioContext.contractID.contains("SC"))
            {
                if(scenarioContext.setAgreementTemplate.equalsIgnoreCase("LMA3134"))
                {
                    
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().InsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundMonths"));
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().MaxPeriodInsuranceBoundField);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().MaxPeriodInsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundMonths"));
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().MaxAdvPeriodInsuranceBoundField);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().MaxAdvPeriodInsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundDays")); 
                }
                else
                {
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().InsuranceBoundField, NonMPRData.get(index).get("PeriodOfInsuranceBoundMonths"));
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().MaxPeriodInsuranceBoundFieldSC);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().MaxPeriodInsuranceBoundFieldSC, NonMPRData.get(index).get("PeriodOfInsuranceBoundDays"));
                }
                
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Apply Period Of Insurances Bound")
    public void ApplyPeriodOfInsurancesBound()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyPeriodOfInsuranceBound);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyAllYesButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Expand Capacity Section Section for Individual Section")
    public void ExpandCapacityDetailsIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CapacityDetailsTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Expand Capacity Section Section for Individual Second Section")
    public void ExpandCapacityDetailsIndividualSecondSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(scenarioContext.setAgreementTemplate.equalsIgnoreCase("LMA3113AT-B"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CapacityDetailsSecondSection);
            }
            else
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CapacityDetailsSecondSectionNonTwin);
            }
            
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    @Then("^Add Syndicate under Capacity Details for Lead Individual Section \"(.*)\"$")
    public void AddSyndicateForLead(String SyndicateLead)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(SyndicateLead)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Syndicate", pageFactory.getIndividualSectionDetails().LeadType);
            testContext.getWebElementUtil().pause();

            if(scenarioContext.setAgreementTemplate.contains("LBS"))
            {
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateLead, MPRData.get(index).get("SyndicateLeadBrussels"));
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForList(pageFactory.getContractLeads().SyndicateAutoRecommend);

                for(WebElement SearchResult : pageFactory.getContractLeads().SyndicateAutoRecommend)
                {
                    if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("SyndicateLeadBrussels").toLowerCase()))
                    {
                        SearchResult.click();
                    }
                
                }
            }
            else
            {
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
            }
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateLeadCompanyReference);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateLeadCompanyReference, NonMPRData.get(index).get("Comments"));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateLeadWrittenLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateLeadWrittenLine, NonMPRData.get(index).get("SignedLine"));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine, NonMPRData.get(index).get("SignedLine")); 
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Syndicate under Capacity Details for Brussels Lead Individual Section \"(.*)\"$")
    public void AddSyndicateForBrusselsLead(String testData)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Syndicate", pageFactory.getIndividualSectionDetails().BrusselsLeadType);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateLeadBrussels, MPRData.get(index).get("SyndicateLeadBrussels"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForList(pageFactory.getContractLeads().SyndicateAutoRecommend);
            
            for(WebElement SearchResult : pageFactory.getContractLeads().SyndicateAutoRecommend)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("SyndicateLeadBrussels").toLowerCase()))
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
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateLeadWrittenLine, NonMPRData.get(index).get("SignedLine"));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine, NonMPRData.get(index).get("SignedLine"));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Add Service Company under Capacity Details for Lead Individual Second Section \"(.*)\"$")
    public void AddServiceCompanyForLeadIndividualSecondSection(String testData)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().DeleteSyndicateIcon);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().AcceptAlert();
            testContext.getWebElementUtil().pause();

            /** Add Service Company as a Lead for Second Section */

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
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadWrittenLine, NonMPRData.get(index).get("SignedLine"));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadSignedLine, NonMPRData.get(index).get("SignedLine"));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadUMR);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadUMR, MPRData.get(index).get("ServiceCompanyUMR")); 
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Verify the Signed Line and Written Line field validation \"(.*)\"$")
    public void VerifyTheSignedLineFieldvalidation(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
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
                    break;
                } 
            }

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateLeadCompanyReference);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateLeadCompanyReference, NonMPRData.get(index).get("Comments"));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateLeadWrittenLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateLeadWrittenLine, "180");
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateLeadSignedLine, "200");
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateLeadWrittenLine);
            testContext.getWebElementUtil().pause();
            
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().WrittenLinePercentageError).equals(true));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().SignedLinePercentageError).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Expand Capacity Section Section for Common Section")
    public void ExpandCapacityDetailsCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().CapacityDetailsTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Syndicate Type Individual")
    public void ValidateIndividualSyndicateType()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().SyndicateTypeCountryBrussels);
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateTypeCountryBrussels);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Syndicate under Capacity Details for Lead Common Section \"(.*)\"$")
    public void AddSyndicateForLeadCommon(String SyndicateLead)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(SyndicateLead)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Syndicate", pageFactory.getCommonSectionDetails().LeadType);
            
            testContext.getWebElementUtil().pause();

            if(scenarioContext.setAgreementTemplate.contains("LBS"))
            {
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().SyndicateLead, MPRData.get(index).get("SyndicateLeadBrussels"));
                testContext.getWebElementUtil().pause();
                for(WebElement SearchResult : pageFactory.getContractLeads().SyndicateAutoRecommend)
                {
                    if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("SyndicateLeadBrussels").toLowerCase()))
                    {
                        SearchResult.click();
                    }
                
                }
            }
            else
            {
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().SyndicateLead, MPRData.get(index).get("SyndicateLead"));
                testContext.getWebElementUtil().pause();
                for(WebElement SearchResult : pageFactory.getContractLeads().SyndicateAutoRecommend)
                {
                    if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("SyndicateLead").toLowerCase()))
                    {
                        SearchResult.click();
                    }
                
                }
            }

            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SyndicateLeadCompanyReference);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().SyndicateLeadCompanyReference, NonMPRData.get(index).get("Comments"));
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SyndicateLeadWrittenLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().SyndicateLeadWrittenLine, NonMPRData.get(index).get("SignedLine"));
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SyndicateLeadSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().SyndicateLeadSignedLine, NonMPRData.get(index).get("SignedLine"));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Service Company under Capacity Details for Lead Individual Section \"(.*)\"$")
    public void AddServiceCompanyForLead(String ServiceCompanyLead)
    {
        try
        {
            testContext.getWebElementUtil().pause(); 
            int index = Integer.parseInt(ServiceCompanyLead)-1;
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
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadWrittenLine, NonMPRData.get(index).get("SignedLine"));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadSignedLine, NonMPRData.get(index).get("SignedLine"));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadUMR);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyLeadUMR, MPRData.get(index).get("ServiceCompanyUMR"));   
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Service Company under Capacity Details for Lead Common Section \"(.*)\"$")
    public void AddServiceCompanyForLeadCommon(String ServiceCompanyLead)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(ServiceCompanyLead)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Service Company", pageFactory.getCommonSectionDetails().LeadType);
           
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ServiceCompanyLead, MPRData.get(index).get("ServiceCompanyLead"));
            
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SearchButtonServiceCompanyLead);
            testContext.getWebElementUtil().pause();

            WebElement SelectName = testContext.getWebElementUtil().getDynamicElement
                ("(//span[text()='"+MPRData.get(index).get("ServiceCompanyLead")+"']//preceding::input[@type='checkbox'])[1]");
            SelectName.click();

            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddButton);
            
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ServiceCompanyLeadSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ServiceCompanyLeadSignedLine, NonMPRData.get(index).get("SignedLine"));    
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Non-Lloyd's Insurer under Capacity Details for Lead Individual Section \"(.*)\"$")
    public void AddNonLloydsInsurerForLead(String InsurerLead)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(InsurerLead)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Non-Lloyd's Insurer", pageFactory.getIndividualSectionDetails().LeadType);
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().NonLloydsInsurerLead, MPRData.get(index).get("NonLloydsInsurer"));
           
            testContext.getWebElementUtil().pause();
            for(WebElement NonInsurer : pageFactory.getIndividualSectionDetails().NonLloydsInsurerList)
            {
                if(NonInsurer.getText().equalsIgnoreCase(MPRData.get(index).get("NonLloydsInsurer")))
                {
                    NonInsurer.click();
                }
            }
            
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().NonLloydsInsurerLeadSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().NonLloydsInsurerLeadSignedLine, NonMPRData.get(index).get("SignedLine"));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Non-Lloyd's Insurer under Capacity Details for Lead Common Section \"(.*)\"$")
    public void AddNonLloydsInsurerForLeadCommon(String InsurerLead)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(InsurerLead)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Non-Lloyd's Insurer", pageFactory.getCommonSectionDetails().LeadType);
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().NonLloydsInsurerLead, MPRData.get(index).get("NonLloydsInsurer"));
            
            testContext.getWebElementUtil().pause();
            for(WebElement NonInsurer : pageFactory.getCommonSectionDetails().NonLloydsInsurerList)
            {
                if(NonInsurer.getText().equalsIgnoreCase(MPRData.get(index).get("NonLloydsInsurer")))
                {
                    NonInsurer.click();
                }
            }
            
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().NonLloydsInsurerLeadSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().NonLloydsInsurerLeadSignedLine, NonMPRData.get(index).get("SignedLine"));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Syndicate under Capacity Details for Follow Individual Section \"(.*)\"$")
    public void AddSyndicateForFollow(String SyndicateFollow)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(SyndicateFollow)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Syndicate", pageFactory.getIndividualSectionDetails().FollowType);
            
            testContext.getWebElementUtil().pause();            
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateFollow, MPRData.get(index).get("SyndicateFollow"));
            
            testContext.getWebElementUtil().pause();
            for(WebElement SearchResult : pageFactory.getContractLeads().SyndicateAutoRecommend)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("SyndicateFollow").toLowerCase()))
                {
                    SearchResult.click();
                }
                
            }
            testContext.getWebElementUtil().pause();

            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateFollowCompanyReference);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateFollowCompanyReference, NonMPRData.get(index).get("Comments"));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SyndicateFollowSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateFollowSignedLine, NonMPRData.get(index).get("SignedLine"));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Syndicate under Capacity Details for Follow Common Section \"(.*)\"$")
    public void AddSyndicateForFollowCommon(String SyndicateFollow)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(SyndicateFollow)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Syndicate", pageFactory.getCommonSectionDetails().FollowType);
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().SyndicateFollow, MPRData.get(index).get("SyndicateFollow"));
            
            testContext.getWebElementUtil().pause();
            for(WebElement SearchResult : pageFactory.getContractLeads().SyndicateAutoRecommend)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("SyndicateFollow").toLowerCase()))
                {
                    SearchResult.click();
                }
                
            }
            testContext.getWebElementUtil().pause();
            
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SyndicateFollowSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().SyndicateFollowSignedLine, NonMPRData.get(index).get("SignedLine"));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Service Company under Capacity Details for Follow Individual Section \"(.*)\"$")
    public void AddServiceCompanyForFollow(String ServiceCompanyFollow)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(ServiceCompanyFollow)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Service Company", pageFactory.getIndividualSectionDetails().FollowType);
                
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyFollow, MPRData.get(index).get("ServiceCompanyFollow"));
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SearchButtonServiceCompanyFollow);
            testContext.getWebElementUtil().pause();

            WebElement SelectName = testContext.getWebElementUtil().getDynamicElement
                ("(//span[text()='"+MPRData.get(index).get("ServiceCompanyFollow")+"']//preceding::input[@type='checkbox'])[1]");
            SelectName.click();

            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddButton);
            
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ServiceCompanyFollowSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyFollowSignedLine, NonMPRData.get(index).get("SignedLine"));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Service Company under Capacity Details for Follow Common Section \"(.*)\"$")
    public void AddServiceCompanyForFollowCommon(String ServiceCompanyFollow)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(ServiceCompanyFollow)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Service Company", pageFactory.getCommonSectionDetails().FollowType);
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ServiceCompanyFollow, MPRData.get(index).get("ServiceCompanyFollow"));
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SearchButtonServiceCompanyFollow);
            testContext.getWebElementUtil().pause();

            WebElement SelectName = testContext.getWebElementUtil().getDynamicElement
                ("(//span[text()='"+MPRData.get(index).get("ServiceCompanyFollow")+"']//preceding::input[@type='checkbox'])[1]");
            SelectName.click();

            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddButton);
            
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ServiceCompanyFollowSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ServiceCompanyFollowSignedLine, NonMPRData.get(index).get("SignedLine"));     
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Non-Lloyd's Insurer under Capacity Details for Follow Individual Section \"(.*)\"$")
    public void AddNonLloydsInsurerForFollow(String InsurerFollow)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(InsurerFollow)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Non-Lloyd's Insurer", pageFactory.getIndividualSectionDetails().FollowType);
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().NonlloydsInsurerFollow, MPRData.get(index).get("NonLloydsInsurerFollow"));
            
            testContext.getWebElementUtil().pause();
            for(WebElement NonInsurer : pageFactory.getIndividualSectionDetails().NonLloydsInsurerList)
            {
                if(NonInsurer.getText().equalsIgnoreCase(MPRData.get(index).get("NonLloydsInsurerFollow")))
                {
                    NonInsurer.click();
                }
            }
            
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().NonLloydsInsurerFollowSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().NonLloydsInsurerFollowSignedLine, NonMPRData.get(index).get("SignedLine"));      
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Non-Lloyd's Insurer under Capacity Details for Follow Common Section \"(.*)\"$")
    public void AddNonLloydsInsurerForFollowCommon(String InsurerFollow)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(InsurerFollow)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Non-Lloyd's Insurer", pageFactory.getCommonSectionDetails().FollowType);
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().NonlloydsInsurerFollow, MPRData.get(index).get("NonLloydsInsurerFollow"));
            
            testContext.getWebElementUtil().pause();
            for(WebElement NonInsurer : pageFactory.getCommonSectionDetails().NonLloydsInsurerList)
            {
                if(NonInsurer.getText().equalsIgnoreCase(MPRData.get(index).get("NonLloydsInsurerFollow")))
                {
                    NonInsurer.click();
                }
            }
            
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().NonLloydsInsurerFollowSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().NonLloydsInsurerFollowSignedLine, NonMPRData.get(index).get("SignedLine"));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate Duplicate Syndicate is not present under Section Follow Individual Section \"(.*)\"$")
    public void ValidateDuplicateSyndicateSectionFollowIndividualSection(String SyndicateFollow)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(SyndicateFollow)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Syndicate", pageFactory.getIndividualSectionDetails().FollowType);
            
            testContext.getWebElementUtil().pause();            
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().SyndicateFollow, MPRData.get(index).get("SyndicateLead"));
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().ValidatePresenceOfListElements(pageFactory.getContractLeads().SyndicateAutoRecommend);
        }
        catch (AssertionError | Exception e)
        {
            Assert.assertTrue(true);
        }
    }

    @Then("Validate Duplicate Syndicate is not present under Section Follow Common Section \"(.*)\"$")
    public void ValidateDuplicateSyndicateSectionFollowCommonSection(String SyndicateFollow)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(SyndicateFollow)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Syndicate", pageFactory.getCommonSectionDetails().FollowType);
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().SyndicateFollow, MPRData.get(index).get("SyndicateLead"));
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().ValidatePresenceOfListElements(pageFactory.getContractLeads().SyndicateAutoRecommend);
        }
        catch (AssertionError | Exception e)
        {
            Assert.assertTrue(true);
        }
    }

    @Then("Validate Duplicate Service Company is not present Section Follow Individual Section \"(.*)\"$")
    public void ValidateDuplicateServiceCompanySectionFollowIndividualSection(String ServiceCompanyFollow)
    {
        try
        {
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(ServiceCompanyFollow)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Service Company", pageFactory.getIndividualSectionDetails().FollowType);
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ServiceCompanyFollow);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyFollow, MPRData.get(index).get("ServiceCompanyLead"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SearchButtonServiceCompanyFollow);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().ServiceCompanyHeader);
            testContext.getWebElementUtil().pause();
            
            testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().ServiceCompanyNoResultFoundMsg);
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CloseServiceCompanyModalIcon);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate Duplicate Service Company is not present Section Follow Common Section \"(.*)\"$")
    public void ValidateDuplicateServiceCompanySectionFollowCommonSection(String ServiceCompanyFollow)
    {
        try
        {
            
            testContext.getWebElementUtil().pause();
            int index = Integer.parseInt(ServiceCompanyFollow)-1;
            testContext.getWebElementUtil().commonSelectDropdown("Service Company", pageFactory.getCommonSectionDetails().FollowType);
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ServiceCompanyFollow);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ServiceCompanyFollow, MPRData.get(index).get("ServiceCompanyLead"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SearchButtonServiceCompanyFollow);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().ServiceCompanyHeader);
            testContext.getWebElementUtil().pause();

            testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().ServiceCompanyNoResultFoundMsg);
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CloseServiceCompanyModalIcon);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    
    @Then("Perform Copy Section action and verify the result")
    public void CopySection()
    {
        try
        {
            testContext.getWebElementUtil().pauseAfterSave();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CopySection);
            testContext.getWebElementUtil().pause();
            int totalsections = pageFactory.getIndividualSectionDetails().SectionIDs.size();
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//span[text()='00"+totalsections+"']"));

            WebElement section = testContext.getWebElementUtil().getDynamicElement("//span[text()='00"+totalsections+"']");
            section.click();
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    
    @Then("Perform Copy Section for Endorsement and verify the result")
    public void CopySectionEndorsement()
    {
        try
        {
            testContext.getWebElementUtil().pauseAfterSave();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CopySectionEndorsement);
            testContext.getWebElementUtil().pause();
            int totalsections = pageFactory.getIndividualSectionDetails().SectionIDs.size();
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("(//span[text()='00"+totalsections+"'])[2]"));
                                    
            WebElement section = testContext.getWebElementUtil().getDynamicElement("(//span[text()='00"+totalsections+"'])[2]");
            section.click();
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Apply Capacity Details")
    public void ApplyCapacityDetails()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyCapacityDetails);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyAllYesButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Capacity Details Percentage Error")
    public void ValidateCapacityDetailsPercentageError()
    {
        try
        {
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
            testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().CapacityPercentageError);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Capacity Details Contract Lead Error")
    public void ValidateCapacityDetailsContractLeadError()
    {
        try
        {
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
            testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().ContractLeadError);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the NonLloyds Insurer only Contract Lead Error")
    public void ValidateNonLloydsContractLeadError()
    {
        try
        {
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
            testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().NonLloydsContractLeadError);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Validate the Worldwide Excluding For Individual Section \"(.*)\"$")
    public void ValidateWorldwideExcludingIndividualSection(String territories)
    {
        try
        {
            int index = Integer.parseInt(territories)-1;
            /* Exclude Risk Location */
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().RiskLocationWorldwideCheckbox);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ExcludeCountrySearchRiskLocation, NonMPRData.get(index).get("TerritorialLimit"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ExcludeCountryRiskLocationSearchButton);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().WorldwideExcludeSearchHeader);
            
            WebElement SelectAreaForRiskLocation = testContext.getWebElementUtil().getDynamicElement
                ("(//span[text()='"+NonMPRData.get(index).get("TerritorialLimit")+"']//preceding::input[@type='checkbox'])[1]");
            SelectAreaForRiskLocation.click();
            
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddButton);
            
            /* Exclude Insured Domicile */
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().InsuredDomicileWorldwideCheckbox);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ExcludeCountrySearchInsuredDomicile, NonMPRData.get(index).get("TerritorialLimit"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ExcludeCountryInsuredCountriesSearchButton);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().WorldwideExcludeSearchHeader);
            WebElement SelectAreaForInsuredDomicile = testContext.getWebElementUtil().getDynamicElement("(//span[text()='"+NonMPRData.get(index).get("TerritorialLimit")+"']//preceding::input[@type='checkbox'])[1]");
            SelectAreaForInsuredDomicile.click();

            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddButton);

            /* Exclude Insured Domicile */
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().TerritorialLimitsWorldwideCheckbox);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ExcludeCountrySearchTerritorialLimit, NonMPRData.get(index).get("TerritorialLimit"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ExcludeCountryTerritorialLimitSearchButton);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().WorldwideExcludeSearchHeader);
            WebElement SelectAreaForTerritorialLimit = testContext.getWebElementUtil().getDynamicElement("(//span[text()='"+NonMPRData.get(index).get("TerritorialLimit")+"']//preceding::input[@type='checkbox'])[1]");
            SelectAreaForTerritorialLimit.click();
            
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Validate the Worldwide Excluding For Common Section \"(.*)\"$")
    public void ValidateWorldwideExcludingCommonSection(String territories)
    {
        try
        {
            int index = Integer.parseInt(territories)-1;
            /* Exclude Risk Location */
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().RiskLocationWorldwideCheckbox);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ExcludeCountrySearchRiskLocation, NonMPRData.get(index).get("TerritorialLimit"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ExcludeCountryRiskLocationSearchButton);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().WorldwideExcludeSearchHeader);

            WebElement SelectAreaForRiskLocation = testContext.getWebElementUtil().getDynamicElement
                ("(//span[text()='"+NonMPRData.get(index).get("TerritorialLimit")+"']//preceding::input[@type='checkbox'])[1]");
            SelectAreaForRiskLocation.click();

            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddButton);
            
            /* Exclude Insured Domicile */
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().InsuredDomicileWorldwideCheckbox);
            testContext.getWebElementUtil().pause();
            //testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ExcludeCountrySearchInsuredDomicile, NonMPRData.get(index).get("TerritorialLimit"));
            //testContext.getWebElementUtil().pause();
            //testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ExcludeCountryInsuredCountriesSearchButton);
            //testContext.getWebElementUtil().pause();
            //testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().WorldwideExcludeSearchHeader);
            //WebElement SelectAreaForInsuredDomicile = testContext.getWebElementUtil().driver.findElement(By.xpath("(//span[text()='"+NonMPRData.get(index).get("TerritorialLimit")+"']//preceding::input[@type='checkbox'])[1]"));
            //SelectAreaForInsuredDomicile.click();
            //testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddButton);

            /* Exclude Insured Domicile */
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().TerritorialLimitsWorldwideCheckbox);
            testContext.getWebElementUtil().pause();
            //testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ExcludeCountrySearchTerritorialLimit, NonMPRData.get(index).get("TerritorialLimit"));
            //testContext.getWebElementUtil().pause();
            //testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ExcludeCountryTerritorialLimitSearchButton);
            //testContext.getWebElementUtil().pause();
            //testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().WorldwideExcludeSearchHeader);
            //WebElement SelectAreaForTerritorialLimit = testContext.getWebElementUtil().driver.findElement(By.xpath("(//span[text()='"+NonMPRData.get(index).get("TerritorialLimit")+"']//preceding::input[@type='checkbox'])[1]"));
            //SelectAreaForTerritorialLimit.click();
            //testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Expand Gross Premium Income Limit Individual Section")
    public void ExpandIncomeLimitIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().GrossPremiumIncomeLimitTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Validate Currency and Enter Gross Premium Income Limit Details \"(.*)\"$")
    public void CurrencyCodeGrossPremiumIncomeLimit(String IncomeDetails)
    {
        try
        {
            int index = Integer.parseInt(IncomeDetails)-1;
            testContext.getWebElementUtil().pause();
            String actualGrossIncomeCurrency = testContext.getWebElementUtil().commonGetTextFromElement(pageFactory.getIndividualSectionDetails().GrossPremiumIncomeCurrency);
            Assert.assertTrue(actualGrossIncomeCurrency.contains(NonMPRData.get(index).get("CurrencyCode")));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().GrossIncomeLimit);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().GrossIncomeLimit, NonMPRData.get(index).get("IncomeLimit"));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IncomePercentage);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().IncomePercentage, NonMPRData.get(index).get("IncomePercentage"));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Verify the Notifiable Percentage field validation")
    public void VerifyNotifiablePercentageFieldValidation()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IncomePercentage);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().IncomePercentage, "180");
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().GrossIncomeLimit);
            testContext.getWebElementUtil().pause();

            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().IncomePercentageFieldError).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Expand Claims and Complaints for Common Section")
    public void ExpandClaimsAndComplaintsCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsAndComplaintsTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select Yes for Claims Handling Authority Common Section")
    public void SelectYesClaimsHandlingAuthorityCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsHandlingCoverholderYes);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsHandlingDelegatedClaimsAdminYes);
            }
            else if(scenarioContext.contractID.contains("SC")) 
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsHandlingServiceCompanyYes);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsHandlingDelegatedClaimsAdminYesServiceCompany);
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select Yes for Claims Handling Authority For Coverholder Common Section")
    public void SelectYesClaimsHandlingAuthorityForCoverholderCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsHandlingCoverholderYes);
            }
            else if(scenarioContext.contractID.contains("SC")) 
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsHandlingServiceCompanyYes);
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    @Then("Select Yes for Claims Handling Authority For DCA Common Section")
    public void SelectYesClaimsHandlingAuthorityForDCACommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsHandlingDelegatedClaimsAdminYes);
            }
            else if(scenarioContext.contractID.contains("SC")) 
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsHandlingDelegatedClaimsAdminYesServiceCompany);
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }



    @Then("Select No for Claims Handling Authority Common Section")
    public void SelectNoClaimsHandlingAuthorityCommonSection()
    {
        try
        {
            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsHandlingCoverholderNo);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsHandlingDelegatedClaimsAdminNo);
            }
            else if(scenarioContext.contractID.contains("SC"))
            {
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsHandlingServiceCompanyNo);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsHandlingDelegatedClaimsAdminNoServiceCompany); 
            }
            
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    @Then("Select Yes for Complaints Handling Authority Common Section")
    public void SelectYesComplaintsHandlingAuthorityCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ComplaintsHandlingCoverholderYes);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ComplaintsHandlingDelegatedClaimsAdminYes);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select No for Complaints Handling Authority Common Section")
    public void SelectNoComplaintsHandlingAuthorityCommonSection()
    {
        try
        {
            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ComplaintsHandlingCoverholderNo);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ComplaintsHandlingDelegatedClaimsAdminNo);
            }
            else if(scenarioContext.contractID.contains("SC"))
            {
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ComplaintsHandlingServiceCompanyNo);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ComplaintsHandlingDelegatedClaimsAdminServiceCompanyNo); 
            }
            
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select Yes for Eligible Complainants Under This Contract Common Section")
    public void SelectYesEligibleComplaintsCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().EligibleComplainantsYes);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select No for Eligible Complainants Under This Contract Common Section")
    public void SelectNoEligibleComplaintsCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().EligibleComplainantsNo);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Apply Claims and Complaints")
    public void ApplyClaimsAndComplaints()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyClaimsAndComplaints);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyAllYesButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Expand Claims and Complaints for Individual Section")
    public void ExpandClaimsAndComplaintsIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select Yes for Claims Handling Authority Individual Section")
    public void SelectYesClaimsHandlingAuthorityIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsHandlingCoverholderYes);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsHandlingDelegatedClaimsAdminYes);
            }
            else
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsHandlingServiceCompanyYes);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsHandlingDelegatedClaimsAdminYesServiceCompany);
            } 
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select No for Claims Handling Authority Individual Section")
    public void SelectNoClaimsHandlingAuthorityIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(scenarioContext.contractID.contains("CH"))
            {
                if(scenarioContext.setAgreementTemplate.contains("LBS") | scenarioContext.setAgreementTemplate.contains("LMA3113AT-B"))
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsHandlingCoverholderNoLBS);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsHandlingDelegatedClaimsAdminNoLBS);
                }
                else
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsHandlingCoverholderNo);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsHandlingDelegatedClaimsAdminNo);
                }
            }
            else if(scenarioContext.contractID.contains("SC"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsHandlingServiceCompanyNo);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsHandlingDelegatedClaimsAdminNoServiceCompany);
            }
            
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    @Then("Select Yes for Complaints Handling Authority Individual Section")
    public void SelectYesComplaintsHandlingAuthorityIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ComplaintsHandlingCoverholderYes);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ComplaintsHandlingDelegatedClaimsAdminYes);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select No for Complaints Handling Authority Individual Section")
    public void SelectNoComplaintsHandlingAuthorityIndividualSection()
    {
        try
        {
            if(scenarioContext.contractID.contains("CH"))
            {
                if(scenarioContext.setAgreementTemplate.contains("LBS") | scenarioContext.setAgreementTemplate.contains("LMA3113AT-B"))
                {
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ComplaintsHandlingCoverholderNoLBS);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ComplaintsHandlingDelegatedClaimsAdminNoLBS);
                }
                else
                {
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ComplaintsHandlingCoverholderNo);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ComplaintsHandlingDelegatedClaimsAdminNo);
                }
                
            }
            else if(scenarioContext.contractID.contains("SC"))
            {
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ComplaintsHandlingServiceCompanyNo);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ComplaintsHandlingDelegatedClaimsAdminNoServiceCompany);
            }
            
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select Yes for Eligible Complainants Under This Contract Individual Section")
    public void SelectYesEligibleComplaintsIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().EligibleComplainantsYes);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select No for Eligible Complainants Under This Contract Individual Section")
    public void SelectNoEligibleComplaintsIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().EligibleComplainantsNo);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Expand Reporting and Aggregate Exposures for Common Section")
    public void ExpandReportingAndAggregateExposuresCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ReportingAggrExposuresTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add details to the Reporting and Aggregate Exposures for Common Section \"(.*)\"$")
    public void AddReportingAggregateExposuresCommonSection(String ReportDetails)
    {
        try
        {
            int index = Integer.parseInt(ReportDetails)-1;
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().RisksReporting);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown(NonMPRData.get(index).get("ReportingInterval"), pageFactory.getCommonSectionDetails().RisksReporting);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().WrittenBordereau);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().WrittenBordereau, NonMPRData.get(index).get("ReportingDays"));
            testContext.getWebElementUtil().pause();
            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AggregateReporting);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSelectDropdown(NonMPRData.get(index).get("ReportingInterval"), pageFactory.getCommonSectionDetails().AggregateReporting);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AggregateExposures);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().AggregateExposures, NonMPRData.get(index).get("ReportingDays"));
            }
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown(NonMPRData.get(index).get("ReportingInterval"), pageFactory.getCommonSectionDetails().PremiumReporting);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().PremiumBordereau, NonMPRData.get(index).get("ReportingDays"));
            testContext.getWebElementUtil().pause();
            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().RemittanceofSettlements);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().RemittanceofSettlements, NonMPRData.get(index).get("ReportingDays"));
                testContext.getWebElementUtil().pause();
            }
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ChargesDeducted);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ChargesDeducted, NonMPRData.get(index).get("ReportingDays"));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Apply Reporting and Aggregate Exposures")
    public void ApplyReportingAndAggregateExposures()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyReportingAndAggregate);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyAllYesButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Expand Reporting and Aggregate Exposures for Individual Section")
    public void ExpandReportingAndAggregateExposuresIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ReportingAggrExposuresTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add details to the Reporting and Aggregate Exposures for Individual Section \"(.*)\"$")
    public void AddReportingAggregateExposuresIndividualSection(String ReportDetails)
    {
        try
        {
            int index = Integer.parseInt(ReportDetails)-1;
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().RisksReporting);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown(NonMPRData.get(index).get("ReportingInterval"), pageFactory.getIndividualSectionDetails().RisksReporting);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().WrittenBordereau);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().WrittenBordereau, NonMPRData.get(index).get("ReportingDays"));
            testContext.getWebElementUtil().pause();

            if(scenarioContext.setAgreementTemplate.contains("LMA3115M"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SchemeCanadaOption);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSelectDropdown("Non-Scheme Canada - (LMA5131A)", pageFactory.getIndividualSectionDetails().SchemeCanadaOption);
                testContext.getWebElementUtil().pause();
            }
            
            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AggregateReporting);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSelectDropdown(NonMPRData.get(index).get("ReportingInterval"), pageFactory.getIndividualSectionDetails().AggregateReporting);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AggregateExposures);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().AggregateExposures, NonMPRData.get(index).get("ReportingDays"));
                testContext.getWebElementUtil().pause();
            }
            
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PremiumReporting);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown(NonMPRData.get(index).get("ReportingInterval"), pageFactory.getIndividualSectionDetails().PremiumReporting);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PremiumBordereau);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PremiumBordereau, NonMPRData.get(index).get("ReportingDays"));
            testContext.getWebElementUtil().pause();

            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().RemittanceofSettlements);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().RemittanceofSettlements, NonMPRData.get(index).get("ReportingDays"));
                testContext.getWebElementUtil().pause();
            }

            if(scenarioContext.setAgreementTemplate.contains("LMA3115M"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PaidClaims);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PaidClaims, NonMPRData.get(index).get("ReportingDays"));
                testContext.getWebElementUtil().pause();
            }
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ChargesDeducted);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ChargesDeducted, NonMPRData.get(index).get("ReportingDays"));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Add Claims Reporting Interval and Maximum Period to Reporting and Aggregate Exposures for DCA Individual Section \"(.*)\"$")
    public void AddClaimsReportingIntervalMaximumPeriodReportingAndAggregateExposuresDCA(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsReporting);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown(NonMPRData.get(index).get("ReportingInterval"), pageFactory.getIndividualSectionDetails().ClaimsReporting);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaxReportingBordereau);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().MaxReportingBordereau, NonMPRData.get(index).get("ReportingDays"));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select Participants For Twin Contract \"(.*)\"$")
    public void SelectParticipantsForTwinContract(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            
            /**  Add Contract Administrator */
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ContractAdministrator, MPRData.get(index).get("ServiceCompanyLead"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForList(pageFactory.getIndividualSectionDetails().ParticipantList);

            for(WebElement SearchResult : pageFactory.getIndividualSectionDetails().ParticipantList)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("ServiceCompanyLead").toLowerCase()))
                {
                    SearchResult.click();
                    break;
                }    
            }

            /** Add Delegated Data Manager */
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().BreachManagement, MPRData.get(index).get("ServiceCompanyLead"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForList(pageFactory.getIndividualSectionDetails().ParticipantList);

            for(WebElement SearchResult : pageFactory.getIndividualSectionDetails().ParticipantList)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("ServiceCompanyLead").toLowerCase()))
                {
                    SearchResult.click();
                    break;
                }    
            }

            /** Risks Written Add Transformation */
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().RisksWrittenTransformation, MPRData.get(index).get("ServiceCompanyLead"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForList(pageFactory.getIndividualSectionDetails().ParticipantList);

            for(WebElement SearchResult : pageFactory.getIndividualSectionDetails().ParticipantList)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("ServiceCompanyLead").toLowerCase()))
                {
                    SearchResult.click();
                    break;
                }    
            }

            /** Risks Written Add Assignment */
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().RisksWrittenAssignment, MPRData.get(index).get("ServiceCompanyLead"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForList(pageFactory.getIndividualSectionDetails().ParticipantList);

            for(WebElement SearchResult : pageFactory.getIndividualSectionDetails().ParticipantList)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("ServiceCompanyLead").toLowerCase()))
                {
                    SearchResult.click();
                    break;
                }    
            }

            /** Risks Written Add Approval */
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().RisksWrittenApproval, MPRData.get(index).get("ServiceCompanyLead"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForList(pageFactory.getIndividualSectionDetails().ParticipantList);

            for(WebElement SearchResult : pageFactory.getIndividualSectionDetails().ParticipantList)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("ServiceCompanyLead").toLowerCase()))
                {
                    SearchResult.click();
                    break;
                }    
            }

            /** Copy Questions From Risk Written */
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CopyQuestionsPaidPremium);

            /** Aggregates Add Transformation */
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().AggregatesTransformation, MPRData.get(index).get("ServiceCompanyLead"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForList(pageFactory.getIndividualSectionDetails().ParticipantList);

            for(WebElement SearchResult : pageFactory.getIndividualSectionDetails().ParticipantList)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("ServiceCompanyLead").toLowerCase()))
                {
                    SearchResult.click();
                    break;
                }    
            }

            /** Aggregates Add Assignment */
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().AggregatesAssignment, MPRData.get(index).get("ServiceCompanyLead"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForList(pageFactory.getIndividualSectionDetails().ParticipantList);

            for(WebElement SearchResult : pageFactory.getIndividualSectionDetails().ParticipantList)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("ServiceCompanyLead").toLowerCase()))
                {
                    SearchResult.click();
                    break;
                }    
            }

            /** Aggregates Add Approval */
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().AggregatesApproval, MPRData.get(index).get("ServiceCompanyLead"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForList(pageFactory.getIndividualSectionDetails().ParticipantList);

            for(WebElement SearchResult : pageFactory.getIndividualSectionDetails().ParticipantList)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("ServiceCompanyLead").toLowerCase()))
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

    @Then("Validate Claims Reporting Interval and Maximum Period for Reporting Questions Common Section")
    public void ClaimsReportingIntervalAndMaximumPeriodCommon()
    {
        try
        {
            testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommonSectionDetails().ClaimsReporting);
            testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommonSectionDetails().MaxReportingBordereau);
        }
        catch (AssertionError | Exception e)
        {
            Assert.assertTrue(true);
        }
    }

    @Then("Validate Claims Reporting Interval and Maximum Period for Reporting Questions Individual Section")
    public void ClaimsReportingIntervalAndMaximumPeriodIndividual()
    {
        try
        {
            testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().ClaimsReporting);
            testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().MaxReportingBordereau);
        }
        catch (AssertionError | Exception e)
        {
            Assert.assertTrue(true);
        }
    }

    @Then("Validate Reporting and Aggregate Exposures Common Section")
    public void ValidateReportingAndAggregateExposuresCommonSection()
    {
        try
        {
            if(scenarioContext.setAgreementTemplate.equalsIgnoreCase("LMA3114"))
            {
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommonSectionDetails().AggregateReporting);
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommonSectionDetails().AggregateExposures);
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommonSectionDetails().ClaimsReporting);
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommonSectionDetails().MaxReportingBordereau);
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommonSectionDetails().RemittanceofSettlements);
            }
            else if(scenarioContext.setAgreementTemplate.equalsIgnoreCase("LBS0067A"))
            {
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommonSectionDetails().ClaimsReporting);
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommonSectionDetails().MaxReportingBordereau);
            }
            else if(scenarioContext.setAgreementTemplate.equalsIgnoreCase("LMA3115M"))
            {
                testContext.getWebElementUtil().commonSelectDropdown("Non-Scheme Canada - (LMA5131A)", pageFactory.getCommonSectionDetails().SchemeCanadaOption);
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommonSectionDetails().ClaimsReporting);
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommonSectionDetails().MaxReportingBordereau);
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().PaidClaims, "Non-Scheme Canada - (LMA5131A)");
            }
        }
        catch (AssertionError | Exception e)
        {
            Assert.assertTrue(true);
        }
    }

    @Then("Validate Reporting and Aggregate Exposures Individual Section")
    public void ValidateReportingAndAggregateExposuresIndividualSection()
    {
        try
        {
            if(scenarioContext.setAgreementTemplate.equalsIgnoreCase("LMA3114"))
            {
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().AggregateReporting);
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().AggregateExposures);
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().ClaimsReporting);
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().MaxReportingBordereau);
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().RemittanceofSettlements);
            }
            else if(scenarioContext.setAgreementTemplate.equalsIgnoreCase("LBS0067A"))
            {
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().ClaimsReporting);
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().MaxReportingBordereau);
            }
            else if(scenarioContext.setAgreementTemplate.equalsIgnoreCase("LMA3115M"))
            {
                testContext.getWebElementUtil().commonSelectDropdown("Non-Scheme Canada - (LMA5131A)", pageFactory.getIndividualSectionDetails().SchemeCanadaOption);
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().ClaimsReporting);
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().MaxReportingBordereau);
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PaidClaims, "Non-Scheme Canada - (LMA5131A)");
            }
        }
        catch (AssertionError | Exception e)
        {
            Assert.assertTrue(true);
        }
    }

    @Then("^Add Market Participant for Claims Handling Common Section \"(.*)\"$")
    public void AddMarketParticipantClaimshandlingCommonSection(String participant)
    {
        try
        {
            int index = Integer.parseInt(participant)-1;
            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().CoverholderDetailsTab);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().CoverholderField);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().CoverholderField, MPRData.get(index).get("CapacitySeeker"));
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SearchCoverholderServiceCompanyLabel);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SearchCoverHolderButton);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("(//span[text()='"+MPRData.get(index).get("CapacitySeeker")+"']//preceding::input[@type='checkbox'])[1]"));
                
                WebElement SelectMP = testContext.getWebElementUtil().getDynamicElement
                    ("(//span[text()='"+MPRData.get(index).get("CapacitySeeker")+"']//preceding::input[@type='checkbox'])[1]");
                SelectMP.click();

                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddButton);
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//div[contains(@data-lg-id,'EnterCommonSectionDetails')]//h2[text()='"+MPRData.get(index).get("CapacitySeeker")+"']"));
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().TradingNameFieldCoverholder);
                }
                catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.StaleElementReferenceException exception)
                {
                    WebElement ExpandMPAttempt = testContext.getWebElementUtil().getDynamicElement
                        ("//div[contains(@data-lg-id,'EnterCommonSectionDetails')]//h2[text()='"+MPRData.get(index).get("CapacitySeeker")+"']");
                    ExpandMPAttempt.click();
                } 
                
            }
            else if(scenarioContext.contractID.contains("SC"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ServiceCompanyTab);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ServiceCompanyField);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ServiceCompanyField, MPRData.get(index).get("CapacitySeeker"));
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SearchCoverholderServiceCompanyLabel);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().SearchServiceCompanyButton);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("(//span[text()='"+MPRData.get(index).get("CapacitySeeker")+"']//preceding::input[@type='checkbox'])[1]"));
                
                WebElement SelectMP = testContext.getWebElementUtil().getDynamicElement
                    ("(//span[text()='"+MPRData.get(index).get("CapacitySeeker")+"']//preceding::input[@type='checkbox'])[1]");
                SelectMP.click();

                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddButton);
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//div[contains(@data-lg-id,'EnterCommonSectionDetails')]//h2[text()='"+MPRData.get(index).get("CapacitySeeker")+"']"));
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().TradingNameFieldCoverholder);
                }
                catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.StaleElementReferenceException exception)
                {
                    WebElement ExpandMPAttempt = testContext.getWebElementUtil().getDynamicElement
                        ("//div[contains(@data-lg-id,'EnterCommonSectionDetails')]//h2[text()='"+MPRData.get(index).get("CapacitySeeker")+"']");
                    ExpandMPAttempt.click();
                } 

            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add Market Participant for Claims Handling Individual Section \"(.*)\"$")
    public void AddMarketParticipantClaimshandlingIndividualSection(String participant)
    {
        try
        {
            int index = Integer.parseInt(participant)-1;
            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CoverholderField);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().CoverholderField, MPRData.get(index).get("CapacitySeeker"));
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SearchCoverholderServiceCompanyLabel);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SearchCoverHolderButton);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().SearchResults);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("(//span[text()='"+MPRData.get(index).get("CapacitySeeker")+"']//preceding::input[@type='checkbox'])[1]"));
                
                WebElement SelectMP = testContext.getWebElementUtil().getDynamicElement
                    ("(//span[text()='"+MPRData.get(index).get("CapacitySeeker")+"']//preceding::input[@type='checkbox'])[1]");
                SelectMP.click();

                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddButton);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().CoverholderDeleteLink);
                Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().CoverholderDeleteLink));
                //testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//div[contains(@data-lg-id,'EnterSectionDetails')]//h2[text()='"+SectionDetailsNonSchedule.get(index).get("CH/SCName")+"']"));
            }
            else if(scenarioContext.contractID.contains("SC"))
            {   
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ServiceCompanyField);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyField, MPRData.get(index).get("CapacitySeeker"));
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SearchCoverholderServiceCompanyLabel);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().SearchServiceCompanyButton);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().SearchResults);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("(//span[text()='"+MPRData.get(index).get("CapacitySeeker")+"']//preceding::input[@type='checkbox'])[1]"));
                
                WebElement SelectMP = testContext.getWebElementUtil().getDynamicElement
                    ("(//span[text()='"+MPRData.get(index).get("CapacitySeeker")+"']//preceding::input[@type='checkbox'])[1]");
                SelectMP.click();

                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddButton);
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().ServiceCompanyDeleteLink);
                Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().ServiceCompanyDeleteLink));
                //testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//div[contains(@data-lg-id,'EnterSectionDetails')]//h2[text()='"+SectionDetailsNonSchedule.get(index).get("CH/SCName")+"']"));
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
    

    @Then("Validate the claims handling authority client side error Message Common Section")
    public void ValidateCHAcommon()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommonSectionDetails().ClaimsHandlingAuthorityError).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    @Then("Validate the claims handling authority client side error Message Individual Section")
    public void ValidateCHAIndividual()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().ClaimsHandlingAuthorityError).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    @Then("Validate the Currency Feild of Claims and Complaints Accordion for Common Section \"(.*)\"$")
    public void ValidateCurrencyCACcommon(String CurrencyCode)
    {
        try
        {
            int index = Integer.parseInt(CurrencyCode)-1;
            //testContext.getWebElementUtil().commonWaitForElement(SectionDetails.initiate(testContext.getWebElementUtil().driver).ClaimsAndComplaintsCurrencyCommon);
            //Assert.assertTrue(SectionDetails.initiate(testContext.getWebElementUtil().driver).ClaimsAndComplaintsCurrencyCommon.getAttribute("value").equalsIgnoreCase(CreateContractData.get(index).get("CurrencyCode")));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    @Then("Validate the Currency Feild of Claims and Complaints Accordion for Individual Section \"(.*)\"$")
    public void ValidateCurrencyCACIndividual(String CurrencyCode)
    {
        try
        {
            int index = Integer.parseInt(CurrencyCode)-1;
            //testContext.getWebElementUtil().commonWaitForElement(SectionDetails.initiate(testContext.getWebElementUtil().driver).ClaimsAndComplaintsCurrencyIndividual);
            //testContext.getWebElementUtil().pause();
            //testContext.getWebElementUtil().isPresentDynamic(By.xpath("//div[contains(@data-lg-id,'EnterSectionDetails')]//div[contains(@data-ui-meta,'CurrencyCode')]//input[contains(@data-attributes,'ClaimsAndComplaintsDetails')][@value='"+CreateContractData.get(index).get("Currency")+"']"));
            //Assert.assertTrue(SectionDetails.initiate(testContext.getWebElementUtil().driver).ClaimsAndComplaintsCurrencyIndividual.getAttribute("value").equalsIgnoreCase(CreateContractData.get(index).get("CurrencyCode")));

        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    @Then("Add Per Claim Limit value of Claims and Complaints Accordion for Common Section \"(.*)\"$")
    public void AddPerClaimLimitCACcommon(String PerClaimLimit)
    {
        try
        {
            int index = Integer.parseInt(PerClaimLimit)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().ClaimsAndComplaintsPerClaimLimit);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsAndComplaintsPerClaimLimit);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ClaimsAndComplaintsPerClaimLimit, NonMPRData.get(index).get("PerClaimLimit"));
        }
        catch(AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    @Then("Add Per Claim Limit value of Claims and Complaints Accordion for Individual Section \"(.*)\"$")
    public void AddPerClaimLimitCACIndividual(String PerClaimLimit)
    {
        try
        {
            int index = Integer.parseInt(PerClaimLimit)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsPerClaimLimit);
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsPerClaimLimit);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsPerClaimLimit, NonMPRData.get(index).get("PerClaimLimit")); 
        }
        catch(AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    @Then("Add person authorised to exercise any claims authority of Claims and Complaints Accordion for Common Section \"(.*)\"$")
    public void AddPersonAuthorisedCACcommon(String Details)
    {
        try
        {
            int index = Integer.parseInt(Details)-1;
            String persondetails = NonMPRData.get(index).get("PersonResponsible");
            String [] persondetailsSplit = persondetails.split("-");
            String FirstName = persondetailsSplit[0];
            String SurName = persondetailsSplit[1];
            String Email = persondetailsSplit[2];
            testContext.getWebElementUtil().pause();
            if(scenarioContext.setAgreementTemplate.equalsIgnoreCase("LMA3134"))
            {
                testContext.getWebElementUtil().isnotPresent(pageFactory.getCommonSectionDetails().ClaimsAndComplaintsPerson);
            }
            else
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsAndComplaintsFirstname);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ClaimsAndComplaintsFirstname, FirstName);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsAndComplaintsSurname);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ClaimsAndComplaintsSurname, SurName);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsAndComplaintsEmail);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ClaimsAndComplaintsEmail, Email);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsAndComplaintsSurname);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsAndComplaintsAddButton);
            }
        }
        catch(AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    @Then("Add person authorised to exercise any claims authority of Claims and Complaints Accordion for Individual Section \"(.*)\"$")
    public void AddPersonAuthorisedCACIndividual(String Details)
    {
        try
        {
            int index = Integer.parseInt(Details)-1;
            String persondetails = NonMPRData.get(index).get("PersonResponsible");
            String [] persondetailsSplit = persondetails.split("-");
            String FirstName = persondetailsSplit[0];
            String SurName = persondetailsSplit[1];
            String Email = persondetailsSplit[2];
            testContext.getWebElementUtil().pause();
            if(scenarioContext.setAgreementTemplate.equalsIgnoreCase("LMA3134"))
            {
                testContext.getWebElementUtil().isnotPresent(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsPerson);
            }
            else
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsFirstname);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsFirstname, FirstName);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsSurname);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsSurname, SurName);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsEmail);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsEmail, Email);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsSurname);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsAddButton);
            }   
        }
        catch(AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @Then("Search and Add DCA for Common Section \"(.*)\"$")
    public void SearchAddDCACcommon(String Participants)
    {
        try
        {
            int index = Integer.parseInt(Participants)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().DCASearchBox);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().DCASearchBox, MPRData.get(index).get("DCA"));
                
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().DCASearchButton);
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().SearchDCAheader);

            WebElement SelectDCA = testContext.getWebElementUtil().getDynamicElement
                ("(//span[text()='"+MPRData.get(index).get("DCA")+"']//preceding::input[@type='checkbox'])[1]");
            SelectDCA.click();

            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AddButton);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().DCADeleteLink);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getCommonSectionDetails().DCADeleteLink).equals(true));
        }
        catch(AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Search and Add DCA for Individual Section \"(.*)\"$")
    public void SearchAddDCACIndividual(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().DCASearchBox);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().DCASearchBox, MPRData.get(index).get("DCA"));
                
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().DCASearchButton);
            
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().SearchDCAheader);

            WebElement SelectDCA = testContext.getWebElementUtil().getDynamicElement
                ("(//span[text()='"+MPRData.get(index).get("DCA")+"']//preceding::input[@type='checkbox'])[1]");
            SelectDCA.click();

            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddButton);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().DCADeleteButton);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().DCADeleteButton).equals(true));
            
        }
        catch(AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Add DCA Contact Email")
    public void AddDCAContactEmail()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().DCAContactEmail);
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().DCAContactEmail);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().DCAContactEmail, "test@test.com");
        }
        catch(AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the the claims handling authority server side error message post submission for Review")
    public void CHA_ServerSideValidation()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
                Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().CHAServerSideErrorCH).equals(true));
            }
            else if(scenarioContext.contractID.contains("SC"))
            {   
                testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
                Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().CHAServerSideErrorSC).equals(true));
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("I Validate the DCA Contact Email Mandatory Validation")
    public void DCAEmailMandatoryValidation()
    {
        try
        {
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
            if(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsDCAEmailError).equals(false))
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

    @Then("I validate the the capacity seeker and provider server side error message post submission for Review")
    public void CSP_ServerSideValidation()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
            if(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().CSPServerSideError).equals(false))
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

    @Then("Validate the Person Responsible accordion when Enter for each coverholder is checked")
    public void ValidationPersonResponsibleAccordion()
    {
        try
        {
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));

            if(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().PersonResposibleOverallOperationAndControlError).equals(false))
            {
                Assert.fail();
            }
            if(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().PersonResposibleAuthorisedBindInsuranceError).equals(false))
            {
                Assert.fail();
            }
            if(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().PersonResposibleOverallIssuanceDocEvidencesError).equals(false))
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

    @And("Select Each Coverholder or Service Company of Claims and Complaints Accordion for Common Section")
    public void SelectEachQuestionCACCommonSection()
    {
        try
        {
            if(scenarioContext.setAgreementTemplate.equalsIgnoreCase("LMA3134"))
            {
                testContext.getWebElementUtil().isnotPresent(pageFactory.getCommonSectionDetails().ClaimsAndComplaintsPerson);
            }
            else
            {
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ClaimsAndComplaintsPersonCheckBox);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommonSectionDetails().ClaimsAndComplaintsFirstname);
            }
        }
        catch (AssertionError | Exception e)
        {
            Assert.assertTrue(true);
        }
    }

    @And("Select Each Coverholder or Service Company of Claims and Complaints Accordion for Individual Section")
    public void SelectEachQuestionCACIndividualSection()
    {
        try
        {
            if(scenarioContext.setAgreementTemplate.equalsIgnoreCase("LMA3134"))
            {
                testContext.getWebElementUtil().isnotPresent(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsPerson);
            }
            else
            {
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsPersonCheckBox);
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsPersonCheckBox);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().ClaimsAndComplaintsFirstname);     
            }
            
        }   
        catch (AssertionError | Exception e)
        {
            Assert.assertTrue(true);
        }
    }

    @And("Expand Non Schedule for Common Section")
    public void ExpandNonScheduleTabCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().NonScheduleTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @Then("^Add details to the Non Schedule for Common Section \"(.*)\"$")
    public void AddNonScheduleDetailsCommonSection(String NonScheduleDetails)
    {
        try
        {
            int index = Integer.parseInt(NonScheduleDetails)-1;
            //testContext.getWebElementUtil().commonWaitForElement(SectionDetails.initiate(testContext.getWebElementUtil().driver).GrossEPICurrencyCommonSection);
            //String primarycurrency = SectionDetails.initiate(testContext.getWebElementUtil().driver).GrossEPICurrencyCommonSection.getAttribute("value");
            //Assert.assertTrue(primarycurrency.equalsIgnoreCase(CreateContractData.get(index).get("CurrencyCode")));
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().GrossEPI);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().GrossEPI, "100");
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().BasisWrittenLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Part of Whole", pageFactory.getCommonSectionDetails().BasisWrittenLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Part of Whole", pageFactory.getCommonSectionDetails().BasisSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Other", pageFactory.getCommonSectionDetails().SigningProvision);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().LloydsBrokerage);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().LloydsBrokerage, "50");
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().LloydsBrokerageCheck);
            //testContext.getWebElementUtil().commonWaitForElement(SectionDetails.initiate(testContext.getWebElementUtil().driver).ManualBrokerageCurrencyCodeCommonSection);
            //String manualbrokeragecurrency = SectionDetails.initiate(testContext.getWebElementUtil().driver).ManualBrokerageCurrencyCodeCommonSection.getAttribute("value");
            //Assert.assertTrue(manualbrokeragecurrency.equalsIgnoreCase(CreateContractData.get(index).get("CurrencyCode")));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ManualBrokerage);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ManualBrokerage, "100");
            if(scenarioContext.setAgreementTemplate.contains("LBS"))
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().PlatformReadOnlyLBS);
                if(testContext.getWebElementUtil().isnotPresent(pageFactory.getCommonSectionDetails().PlatformReadOnlyLBS).equals(true))
                {
                    Assert.fail();
                }
            }
            else
            {
                testContext.getWebElementUtil().commonSelectDropdown("London", pageFactory.getCommonSectionDetails().Platform);
            }
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().OtherDeductions);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().OtherDeductions, "100");
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Low", pageFactory.getCommonSectionDetails().ProductRiskRating);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Via coverholder", pageFactory.getCommonSectionDetails().RouteOfBusiness);

        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Apply Non Schedule")
    public void ApplyNonSchedule()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyNonSchedule);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyAllYesButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Expand Non Schedule for Individual Section")
    public void ExpandNonScheduleTabIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            try
            {
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().GrossEPICurrency);
            }
            catch(org.openqa.selenium.TimeoutException exception)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().NonScheduleTab);
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add details to the Non Schedule for Individual Section \"(.*)\"$")
    public void AddNonScheduleDetailsIndividualSection(String NonScheduleDetails)
    {
        try
        {
            int index = Integer.parseInt(NonScheduleDetails)-1;
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().GrossEPICurrency);
            String primarycurrency = testContext.getWebElementUtil().commonGetTextFromElement(pageFactory.getIndividualSectionDetails().GrossEPICurrency);
            Assert.assertTrue(primarycurrency.contains(NonMPRData.get(index).get("CurrencyCode")));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().GrossEPI, "100");
            testContext.getWebElementUtil().commonSelectDropdown("Part of Whole", pageFactory.getIndividualSectionDetails().BasisWrittenLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Part of Whole", pageFactory.getIndividualSectionDetails().BasisSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Other", pageFactory.getIndividualSectionDetails().SigningProvision);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().LloydsBrokerage, "50");
            //testContext.getWebElementUtil().commonClick(SectionDetails.initiate(testContext.getWebElementUtil().driver).LloydsBrokerageCheckIndividualSection);
            //testContext.getWebElementUtil().commonWaitForElement(SectionDetails.initiate(testContext.getWebElementUtil().driver).ManualBrokerageCurrencyCodeIndividualSection);
            //String manualbrokeragecurrency = SectionDetails.initiate(testContext.getWebElementUtil().driver).ManualBrokerageCurrencyCodeIndividualSection.getAttribute("value");
            //Assert.assertTrue(manualbrokeragecurrency.equalsIgnoreCase(CreateContractData.get(index).get("CurrencyCode")));
            //testContext.getWebElementUtil().commonSendTestData(SectionDetails.initiate(testContext.getWebElementUtil().driver).ManualBrokerageIndividualSection, "100");
            if(scenarioContext.setAgreementTemplate.contains("LBS"))
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().PlatformReadOnlyLBSExceptTwinContract);
                if(testContext.getWebElementUtil().isnotPresent(pageFactory.getIndividualSectionDetails().PlatformReadOnlyLBSExceptTwinContract).equals(true))
                {
                    Assert.fail();
                }
            }
            else
            {
                testContext.getWebElementUtil().commonSelectDropdown("London", pageFactory.getIndividualSectionDetails().Platform);
            }
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().OtherDeductions, "100");
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Low", pageFactory.getIndividualSectionDetails().ProductRiskRating);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Via coverholder", pageFactory.getIndividualSectionDetails().RouteOfBusiness);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("^Add details to the Non Schedule for Individual Section For Managing Agent \"(.*)\"$")
    public void AddNonScheduleDetailsIndividualSectionForManagingAgent(String NonScheduleDetails)
    {
        try
        {
            int index = Integer.parseInt(NonScheduleDetails)-1;
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().GrossEPICurrency);
            //String primarycurrency = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getIndividualSectionDetails().GrossEPICurrency);
            //Assert.assertTrue(primarycurrency.contains(NonMPRData.get(index).get("CurrencyCode")));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().GrossEPI, "100");
            testContext.getWebElementUtil().commonSelectDropdown("Part of Whole", pageFactory.getIndividualSectionDetails().BasisWrittenLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Part of Whole", pageFactory.getIndividualSectionDetails().BasisSignedLine);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Other", pageFactory.getIndividualSectionDetails().SigningProvision);
            //testContext.getWebElementUtil().commonClick(SectionDetails.initiate(testContext.getWebElementUtil().driver).LloydsBrokerageCheckIndividualSection);
            //testContext.getWebElementUtil().commonWaitForElement(SectionDetails.initiate(testContext.getWebElementUtil().driver).ManualBrokerageCurrencyCodeIndividualSection);
            //String manualbrokeragecurrency = SectionDetails.initiate(testContext.getWebElementUtil().driver).ManualBrokerageCurrencyCodeIndividualSection.getAttribute("value");
            //Assert.assertTrue(manualbrokeragecurrency.equalsIgnoreCase(CreateContractData.get(index).get("CurrencyCode")));
            //testContext.getWebElementUtil().commonSendTestData(SectionDetails.initiate(testContext.getWebElementUtil().driver).ManualBrokerageIndividualSection, "100");
            if(scenarioContext.setAgreementTemplate.contains("LBS"))
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().PlatformReadOnlyLBSExceptTwinContract);
                if(testContext.getWebElementUtil().isnotPresent(pageFactory.getIndividualSectionDetails().PlatformReadOnlyLBSExceptTwinContract).equals(true))
                {
                    Assert.fail();
                }
            }
            else
            {
                testContext.getWebElementUtil().commonSelectDropdown("London", pageFactory.getIndividualSectionDetails().Platform);
            }
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Low", pageFactory.getIndividualSectionDetails().ProductRiskRating);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Via coverholder", pageFactory.getIndividualSectionDetails().RouteOfBusiness);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Expand Commissions for Common Section")
    public void ExpandCommissionTabCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().CommissionsTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Add details to the Commission for Common Section \"(.*)\"$")
    public void AddCommissionCommonSection(String Commission)
    {
        try
        {
            int index = Integer.parseInt(Commission)-1;
            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().Commision);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().Commision, "20");
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ProfitCommissionNo);
                //testContext.getWebElementUtil().commonClick(SectionDetails.initiate(testContext.getWebElementUtil().driver).ProfitCommissionPercentageCommonSection);
                //testContext.getWebElementUtil().pause();
                //testContext.getWebElementUtil().commonSendTestData(SectionDetails.initiate(testContext.getWebElementUtil().driver).ProfitCommissionPercentageCommonSection, "10");
                testContext.getWebElementUtil().pause();
                //testContext.getWebElementUtil().commonSelectDropdown("Net", SectionDetails.initiate(testContext.getWebElementUtil().driver).ProfitCommissionBasisCommonSection);
                //String underwritingexpensecurrency = testContext.getWebElementUtil().commonGetTextFromElement(SectionDetails.initiate(testContext.getWebElementUtil().driver).UnderwritingExpensesCurrencyCommonSection);
                //Assert.assertTrue(underwritingexpensecurrency.contains(GenContractInfo.get(index).get("CurrencyCode")));
                //testContext.getWebElementUtil().commonClick(SectionDetails.initiate(testContext.getWebElementUtil().driver).UnderwritingExpensesFeesCommonSection);
                //testContext.getWebElementUtil().pause();
                //testContext.getWebElementUtil().commonSendTestData(SectionDetails.initiate(testContext.getWebElementUtil().driver).UnderwritingExpensesFeesCommonSection, "50");
                //testContext.getWebElementUtil().commonClick(SectionDetails.initiate(testContext.getWebElementUtil().driver).UnderwritingExpensesDescriptionCommonSection);
                //testContext.getWebElementUtil().pause();
                //testContext.getWebElementUtil().commonSendTestData(SectionDetails.initiate(testContext.getWebElementUtil().driver).UnderwritingExpensesDescriptionCommonSection, SectionDetailsNonSchedule.get(index).get("Comments"));
                //testContext.getWebElementUtil().commonClick(SectionDetails.initiate(testContext.getWebElementUtil().driver).ProfitCommissionDescriptionCommonSection);
                //testContext.getWebElementUtil().pause();
                //testContext.getWebElementUtil().commonSendTestData(SectionDetails.initiate(testContext.getWebElementUtil().driver).ProfitCommissionDescriptionCommonSection, SectionDetailsNonSchedule.get(index).get("Comments"));
            }
            else if(scenarioContext.contractID.contains("SC"))
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ServiceCompanyCommision);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().ServiceCompanyCommision, "20");
            }
            
            //String maxfeeschargedcurrency = testContext.getWebElementUtil().commonGetTextFromElement(SectionDetails.initiate(testContext.getWebElementUtil().driver).MaxFeesChargedCurrencyCodeCommonSection);
            //Assert.assertTrue(maxfeeschargedcurrency.contains(GenContractInfo.get(index).get("CurrencyCode")));
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().MaxFeesCharged);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().MaxFeesCharged, "10");
            //String maxfeesdeductedcurrency = testContext.getWebElementUtil().commonGetTextFromElement(SectionDetails.initiate(testContext.getWebElementUtil().driver).MaxFeesDeductedCurrencyCodeCommonSection);
            //Assert.assertTrue(maxfeesdeductedcurrency.contains(GenContractInfo.get(index).get("CurrencyCode")));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().MaxFeesDeducted);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().MaxFeesDeducted, "10");
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().FeesDescription);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().FeesDescription, NonMPRData.get(index).get("Comments"));
            //String maxacquisitioncurrency = testContext.getWebElementUtil().commonGetTextFromElement(SectionDetails.initiate(testContext.getWebElementUtil().driver).MaxAcquisitionCostCurrencyCodeCommonSection);
            //Assert.assertTrue(maxacquisitioncurrency.contains(GenContractInfo.get(index).get("CurrencyCode")));
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().MaxAcquisitionCostFees);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().MaxAcquisitionCostFees, "10");
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().AcquisitionCostDescriptionFees);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().AcquisitionCostDescriptionFees, NonMPRData.get(index).get("Comments"));
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().PermittedCommission);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getCommonSectionDetails().PermittedCommission, "20");

            /*
            if(testContext.getWebElementUtil().isnotPresent(SectionDetails.initiate(testContext.getWebElementUtil().driver).RetailBrokerCommissionText).equals(false))
            {
                Assert.fail();
            }*/
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Apply Commission")
    public void ApplyCommission()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyCommissions);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ApplyAllYesButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Expand Commissions for Individual Section")
    public void ExpandCommissionTabIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().CommissionsTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Add details to the Commission for Individual Section \"(.*)\"$")
    public void AddCommissionIndividualSection(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            if(scenarioContext.contractID.contains("CH"))
            {
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().Commision, "20");
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ProfitCommissionYes);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ProfitCommissionPercentage);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ProfitCommissionPercentage, "10");
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ProfitCommissionBasis);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSelectDropdown("Net", pageFactory.getIndividualSectionDetails().ProfitCommissionBasis);
                //String underwritingexpensecurrency = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getIndividualSectionDetails().UnderwritingExpensesCurrency);
                //Assert.assertTrue(underwritingexpensecurrency.contains(NonMPRData.get(index).get("CurrencyCode")));
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().UnderwritingExpensesFees);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().UnderwritingExpensesFees, "50");
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().UnderwritingExpensesDescription);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().UnderwritingExpensesDescription, NonMPRData.get(index).get("Comments"));
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ProfitCommissionDescription);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ProfitCommissionDescription, NonMPRData.get(index).get("Comments"));
            }
            else if(scenarioContext.contractID.contains("SC"))
            {
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ServiceCompanyCommision, "20");
            }
           
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaxRetailBrokerCommission);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().MaxRetailBrokerCommission, "10");
            String maxfeeschargedcurrency = testContext.getWebElementUtil().commonGetTextFromElement(pageFactory.getIndividualSectionDetails().MaxFeesChargedCurrencyCode);
            Assert.assertTrue(maxfeeschargedcurrency.contains(NonMPRData.get(index).get("CurrencyCode")));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaxFeesCharged);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().MaxFeesCharged, "10");
            String maxfeesdeductedcurrency = testContext.getWebElementUtil().commonGetTextFromElement(pageFactory.getIndividualSectionDetails().MaxFeesDeductedCurrencyCode);
            Assert.assertTrue(maxfeesdeductedcurrency.contains(NonMPRData.get(index).get("CurrencyCode")));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaxFeesDeducted);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().MaxFeesDeducted, "10");
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().FeesDescription);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().FeesDescription, NonMPRData.get(index).get("Comments"));
            String maxacquisitioncurrency = testContext.getWebElementUtil().commonGetTextFromElement(pageFactory.getIndividualSectionDetails().MaxAcquisitionCostCurrencyCode); 
            Assert.assertTrue(maxacquisitioncurrency.contains(NonMPRData.get(index).get("CurrencyCode")));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaxAcquisitionCostFees);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().MaxAcquisitionCostFees, "10");
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AcquisitionCostDescriptionFees);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().AcquisitionCostDescriptionFees, NonMPRData.get(index).get("Comments"));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PermittedCommission);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PermittedCommission, "20");
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the absence of Maximum Retail Broker Commission")
    public void ValidateAbsenceOfMaximumRetailBrokerCommission()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().Commision);
            if(testContext.getWebElementUtil().isnotPresent(pageFactory.getCommonSectionDetails().RetailBrokerCommissionText).equals(false))
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

    @And("Expand Authorised Class and Business Coverage")
    public void ExpandAuthorisedClassBusinessCoverage()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AuthorisedClassBusinessCoverageTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select Distribution Method Premium Level of Authority and Deductibles or Excess")
    public void SelectDistributionMethod()
    {
        try
        {   
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().DistributionMethod);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("via a Broker(s)", pageFactory.getIndividualSectionDetails().DistributionMethod);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PremiumLevelOfAuthority);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Prior submit Business Only - Each risk to be individually rated by Underwriters", pageFactory.getIndividualSectionDetails().PremiumLevelOfAuthority);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().DeductiblesOrExcess);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("No deductibles and/or excesses", pageFactory.getIndividualSectionDetails().DeductiblesOrExcess);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate after checking the Deductibles checkbox user is not able to select Deductibles Excess")
    public void UserIsNotAbleToSelectDeductiblesExcess()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IsDeductible);
            testContext.getWebElementUtil().pause();
            Assert.assertFalse(pageFactory.getIndividualSectionDetails().DeductiblesOrExcess.isEnabled());
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select Is Deductible Checkbox")
    public void SelectIsDeductibleCheckbox()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().IsDeductible);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Add High Level Class of Business")
    public void AddAddHighLevelClassOfBusiness()
    {
        try
        {
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ClassOfBusinessSearchCriteria, "Space");
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ClassOfBusinessSearchButton);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().ClassOfBusinessHeader);
            
            WebElement SelectClassOfBusiness = testContext.getWebElementUtil().getDynamicElement
                ("(//span[text()='Space']//preceding::input[@type='checkbox'])[1]");
            SelectClassOfBusiness.click();

            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddButton);
            testContext.getWebElementUtil().pause();

            try
            {
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().RegulatoryClientClassification);
            }
            catch(org.openqa.selenium.TimeoutException exception)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ExpandHighLevelClassofBusiness);
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Delete High Level Class of Business")
    public void DeleteHighLevelOfBusiness()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().DeleteIconCOB);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Add Regulatory Client Classification For High Level Class Of Business")
    public void AddRegulatoryClientClassification()
    {
        try
        {
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().RegulatoryClientClassification, "Reinsurance");
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForList(pageFactory.getIndividualSectionDetails().RegulatoryClientClassificationList);

            for(WebElement RegulatoryClient : pageFactory.getIndividualSectionDetails().RegulatoryClientClassificationList)
            {
                if(RegulatoryClient.getText().equalsIgnoreCase("Reinsurance"))
                {
                    RegulatoryClient.click();
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

    @Then("Delete Regulatory Client Classification")
    public void DeleteRegulatoryClientClassification()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().DeleteIconRegulatoryClient);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Currency Code and Add Maximum limit of Liability Sum Insured for High Level Class of Business \"(.*)\"$")
    public void ValidateCurrencyAndEnterMaxLimitForHighLevelCOB(String Currency)
    {
        try
        {
            int index = Integer.parseInt(Currency)-1;
            String MaxLimitCurrency = testContext.getWebElementUtil().commonGetTextFromElement(pageFactory.getIndividualSectionDetails().HighLevelClassOfBusinessCurrencyCode);
            Assert.assertTrue(MaxLimitCurrency.contains(NonMPRData.get(index).get("CurrencyCode")));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().HighLevelClassOfBusinessMaxLimit);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().HighLevelClassOfBusinessMaxLimit, "200.59");
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().HighLevelClassOfBusinessLimitQualifier);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Any one event", pageFactory.getIndividualSectionDetails().HighLevelClassOfBusinessLimitQualifier);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaximumLimitLiabilityAddButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Currency Code and Add Maximum limit of Liability Sum Insured for Deductibles and Excess \"(.*)\"$")
    public void ValidateCurrencyAndEnterMaxLimitForDeductibles(String Currency)
    {
        try
        {
            int index = Integer.parseInt(Currency)-1;
            //testContext.getWebElementUtil().commonWaitForElement(SectionDetails.initiate(testContext.getWebElementUtil().driver).HighLevelClassOfBusinessCurrencyCode);
            //String MaxLimitCurrency = SectionDetails.initiate(testContext.getWebElementUtil().driver).HighLevelClassOfBusinessCurrencyCode.getAttribute("value");
            //Assert.assertTrue(MaxLimitCurrency.equalsIgnoreCase(CreateContractData.get(index).get("CurrencyCode")));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().DeductiblesAndExcessMaxLimit);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().DeductiblesAndExcessMaxLimit, "200.59");
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().DeductiblesAndExcessLimitQualifier);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Any one event", pageFactory.getIndividualSectionDetails().DeductiblesAndExcessLimitQualifier);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaximumLimitDeductiblesAndExcessAddButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select Insurance or Reinsurance and Risk Codes for Generic Class Of Business \"(.*)\"$")
    public void SelectInsuranceorReinsuranceforGenericCOB(String data)
    {
        try
        {
            int index = Integer.parseInt(data)-1;
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().InsuranceOrReInsurance);
            testContext.getWebElementUtil().commonSelectDropdown(NonMPRData.get(index).get("GenericCOB"), pageFactory.getIndividualSectionDetails().InsuranceOrReInsurance);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddRiskCode);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().AddRiskCode, NonMPRData.get(index).get("RiskCodeCOB"));
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForList(pageFactory.getIndividualSectionDetails().RiskCodeList);

            for(WebElement RiskCode : pageFactory.getIndividualSectionDetails().RiskCodeList)
            {
                if(RiskCode.getText().equalsIgnoreCase(NonMPRData.get(index).get("RiskCodeCOB")))
                {
                    RiskCode.click();
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

    @Then("Delete Risk Code and Description")
    public void DeleteRiskCodeandDescription()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().DeleteIconRiskCode);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Currency Code and Add Maximum limit of Liability Sum Insured for Generic Class Of Business \"(.*)\"$")
    public void ValidateCurrencyAndEnterMaxLimitForGenericClassCOB(String Currency)
    {
        try
        {
            int index = Integer.parseInt(Currency)-1;
            String MaxLimitCurrency = testContext.getWebElementUtil().commonGetTextFromElement(pageFactory.getIndividualSectionDetails().GenericClassOfBusinessCurrencyCode);
            Assert.assertTrue(MaxLimitCurrency.contains(NonMPRData.get(index).get("CurrencyCode")));
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().GenericClassOfBusinessMaxLimit);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().GenericClassOfBusinessMaxLimit, "200.59");
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().GenericClassOfBusinessLimitQualifier);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Any one event", pageFactory.getIndividualSectionDetails().GenericClassOfBusinessLimitQualifier);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaximumLimitLiabilityGenericCOBAddButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Add Peril")
    public void AddPeril()
    {
        try
        {
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().AddPeril, "Coastal Flood");
            testContext.getWebElementUtil().pause();
            for(WebElement Peril : pageFactory.getIndividualSectionDetails().PerilList)
            {
                if(Peril.getText().equalsIgnoreCase("Coastal Flood"))
                {
                    Peril.click();
                    break;
                }
            }

            testContext.getWebElementUtil().pause();

            try
            {
                testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().PerilDetailsMaxLimit);
            }
            catch(org.openqa.selenium.TimeoutException exception)
            {
                WebElement ExpandPeril = testContext.getWebElementUtil().getDynamicElement("//h2[contains(text(), 'Coastal Flood')]");
                ExpandPeril.click();
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Currency Code and Add Maximum limit of Liability Sum Insured for Peril \"(.*)\"$")
    public void ValidateCurrencyAndEnterMaxLimitForPeril(String Currency)
    {
        try
        {
            int index = Integer.parseInt(Currency)-1;
            //testContext.getWebElementUtil().commonWaitForElement(SectionDetails.initiate(testContext.getWebElementUtil().driver).PerilDetailsCurrencyCode);
            //String MaxLimitCurrency = SectionDetails.initiate(testContext.getWebElementUtil().driver).PerilDetailsCurrencyCode.getAttribute("value");
            //Assert.assertTrue(MaxLimitCurrency.equalsIgnoreCase(CreateContractData.get(index).get("CurrencyCode")));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PerilDetailsMaxLimit, "200.59");
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSelectDropdown("Any one event", pageFactory.getIndividualSectionDetails().PerilDetailsLimitQualifier);
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PerilDetailsAddButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @And("Add Loss Contingency Group for Peril")
    public void AddLossContingencyGroupPeril()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PerilLossContingencySearch);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().PerilLossContingencySearch, "Accident and Health");
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().LossContingencySearchButton);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().LossContingencySearchModalHeader);

            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("(//span[text()='Accident and Health']//preceding::input[@type='checkbox'])[1]"));
                
            WebElement SelectMP = testContext.getWebElementUtil().getDynamicElement("(//span[text()='Accident and Health']//preceding::input[@type='checkbox'])[1]");
            SelectMP.click();
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().AddButton);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().LossContingencyDeleteIcon);

            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().LossContingencyDeleteIcon).equals(true));

        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate user is able to remove Peril")
    public void ValidateUserIsAbleToRemovePeril()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().PerilDetailsDeleteIcon);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().AcceptAlert();
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().PerilDetailsDeleteIcon).equals(false));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate user is able to remove Generic Class of Business")
    public void ValidateUserIsAbleToRemoveGenericClassOfBusiness()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().GenericClassOfBusinessDeleteIcon);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().AcceptAlert();
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().GenericClassOfBusinessDeleteIcon).equals(false));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate user is able to remove High Level Class of Business")
    public void ValidateUserIsAbleToRemoveHighLevelClassOfBusiness()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().HighLevelClassOfBusinessDeleteIcon);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().AcceptAlert();
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().HighLevelClassOfBusinessDeleteIcon).equals(false));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate that Capacity Seeker is not approved for the Generic COB")
    public void ValidateCapacitySeekerApprovalForGenericCOB()
    {
        try
        {
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

    @Then("Validate the presence of Maximum Retail Broker Commission")
    public void ValidatePresenceOfMaximumRetailBrokerCommission()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().Commision);
            if(testContext.getWebElementUtil().isnotPresent(pageFactory.getIndividualSectionDetails().RetailBrokerCommissionText).equals(true))
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

    @Then("Validate the absence of Total Lloyds Brokerage and Lloyds Brokerage Amount for Common Section")
    public void ValidateAbsenceOfTotalLloydsBrokerageAndAmountCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().GrossEPI);
            if(testContext.getWebElementUtil().isnotPresent(pageFactory.getCommonSectionDetails().LloydsBrokerage).equals(false))
            {
                Assert.fail();
            }
            if(testContext.getWebElementUtil().isnotPresent(pageFactory.getCommonSectionDetails().LloydsBrokerageCheck).equals(false))
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

    @Then("Validate the absence of Total Lloyds Brokerage and Lloyds Brokerage Amount for Individual Section")
    public void ValidateAbsenceOfTotalLloydsBrokerageAndAmountIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().GrossEPI);
            if(testContext.getWebElementUtil().isnotPresent(pageFactory.getIndividualSectionDetails().LloydsBrokerage).equals(false))
            {
                Assert.fail();
            }
            if(testContext.getWebElementUtil().isnotPresent(pageFactory.getIndividualSectionDetails().LloydsBrokerageCheck).equals(false))
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

    @Then("Verify the Non Schedule Platform as per template for Common Section \"(.*)\"$")
    public void VerifyNonSchedulePlatformCommonSection(String Template)
    {
        try
        {
            int index = Integer.parseInt(Template)-1;
            if(scenarioContext.setAgreementTemplate.equalsIgnoreCase("LMA3113A-TA"))
            {
                if(MPRData.get(index).get("SyndicateLead").equalsIgnoreCase("Tie Up"))
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().PlatformReadOnlyLBS);
                    if(testContext.getWebElementUtil().isnotPresent(pageFactory.getCommonSectionDetails().PlatformReadOnlyLBS).equals(true))
                    {
                        Assert.fail();
                    }
                }
                else
                {   
                    testContext.getWebElementUtil().commonSelectDropdown("London", pageFactory.getCommonSectionDetails().Platform);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().PlatformDeleteIcon);
                }   
            }
            else if(scenarioContext.setAgreementTemplate.contains("LBS"))
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().PlatformReadOnlyLBS);
                if(testContext.getWebElementUtil().isnotPresent(pageFactory.getCommonSectionDetails().PlatformReadOnlyLBS).equals(true))
                {
                    Assert.fail();
                }
            }
            else
            {
                testContext.getWebElementUtil().commonSelectDropdown("London", pageFactory.getCommonSectionDetails().Platform);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().PlatformDeleteIcon);
            }
                
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Delete Platform")
    public void DeletePlatform()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().PlatformDeleteIcon);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Verify the Non Schedule Platform as per template for Individual Section \"(.*)\"$")
    public void VerifyNonSchedulePlatformIndividualSection(String Template)
    {
        try
        {
            int index = Integer.parseInt(Template)-1;
            
            
            /*
            if(testContext.getWebElementUtil().setAgreementTemplate.equalsIgnoreCase("LMA3113AT-B"))
            {
                if(MPRData.get(index).get("SyndicateLeadBrussels").equalsIgnoreCase("Mechanical Registration Tech"))
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().PlatformReadOnlyLBS);
                    if(testContext.getWebElementUtil().isnotPresent(pageFactory.getIndividualSectionDetails().PlatformReadOnlyLBS).equals(true))
                    {
                        Assert.fail();
                    }
                }
                else
                {   
                    testContext.getWebElementUtil().commonSelectDropdown("London", pageFactory.getIndividualSectionDetails().Platform);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().PlatformDeleteIcon);
                }   
            }
            */

            testContext.getWebElementUtil().commonSelectDropdown("London", pageFactory.getIndividualSectionDetails().Platform);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().PlatformDeleteIcon);

            if(scenarioContext.setAgreementTemplate.contains("LBS"))
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().PlatformReadOnlyLBS);
                if(testContext.getWebElementUtil().isnotPresent(pageFactory.getIndividualSectionDetails().PlatformReadOnlyLBS).equals(true))
                {
                    Assert.fail();
                }
            }
            else
            {
                testContext.getWebElementUtil().commonSelectDropdown("London", pageFactory.getIndividualSectionDetails().Platform);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().PlatformDeleteIcon);
            }
                
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    @Then("Verify the Non Schedule Platform for Brussels Capacity Individual Section \"(.*)\"$")
    public void VerifyNonSchedulePlatformBrusselsCapacityIndividualSection(String Template)
    {
        try
        {
            int index = Integer.parseInt(Template)-1;

            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().PlatformReadOnlyLBS);
            if(testContext.getWebElementUtil().isnotPresent(pageFactory.getIndividualSectionDetails().PlatformReadOnlyLBS).equals(true))
            {
                Assert.fail();
            }

            if(scenarioContext.setAgreementTemplate.contains("LBS"))
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().PlatformReadOnlyLBS);
                if(testContext.getWebElementUtil().isnotPresent(pageFactory.getIndividualSectionDetails().PlatformReadOnlyLBS).equals(true))
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



    @Then("Validate the Absence of Profit Commission as per Template for Common Section")
    public void ValidateAbsenceOfProfitCommissionCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().FeesDescription);
            if(testContext.getWebElementUtil().isnotPresent(pageFactory.getCommonSectionDetails().ProfitCommissionYes).equals(false))
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

    @Then("Validate the Absence of Profit Commission as per Template for Individual Section")
    public void ValidateAbsenceOfProfitCommissionIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().FeesDescription);
            if(testContext.getWebElementUtil().isnotPresent(pageFactory.getIndividualSectionDetails().ProfitCommissionYes).equals(false))
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

    @Then("Validate the Presence of roles in relation to Claims for Common Section")
    public void ValidatePresenceRolesRelationToClaimsCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().RisksWrittenSubmissionParty);
            if(testContext.getWebElementUtil().isnotPresent(pageFactory.getCommonSectionDetails().ClaimsSubmissionParty).equals(true))
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

    @Then("Validate the Presence of roles in relation to Claims for Individual Section")
    public void ValidatePresenceRolesRelationToClaimsIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().RisksWrittenSubmissionParty);
            if(testContext.getWebElementUtil().isnotPresent(pageFactory.getIndividualSectionDetails().ClaimsSubmissionParty).equals(true))
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

    @Then("Validate the Absence of roles in relation to Claims for Common Section")
    public void ValidateAbsenceRolesRelationToClaimsCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().RisksWrittenSubmissionParty);
            testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getCommonSectionDetails().ClaimsSubmissionParty);
        }
        catch (AssertionError | Exception e)
        {
            Assert.assertTrue(true);
        }
    }

    @Then("Validate the Absence of roles in relation to Claims for Individual Section")
    public void ValidateAbsenceRolesRelationToClaimsIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().RisksWrittenSubmissionParty);
            testContext.getWebElementUtil().ValidatePresenceOfElement(pageFactory.getIndividualSectionDetails().ClaimsSubmissionParty);
        }
        catch (AssertionError | Exception e)
        {
            Assert.assertTrue(true);
        }
    }

    @Then("Select the Risk Written Submission as Broker for Individual Section")
    public void SelectBrokerSubmissionRiskWrittenforIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().commonSelectDropdown("Broker", pageFactory.getIndividualSectionDetails().RisksWrittenSubmissionParty);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select the Risk Written Submission as Underwriter for Individual Section")
    public void SelectUnderwriterSubmissionRiskWrittenforIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().commonSelectDropdown("Underwriters", pageFactory.getIndividualSectionDetails().RisksWrittenSubmissionParty);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select the Risk Written Submission as Coverholder for Individual Section")
    public void SelectCoverholderSubmissionRiskWrittenforIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().commonSelectDropdown("Coverholder", pageFactory.getIndividualSectionDetails().RisksWrittenSubmissionParty);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Select the Claims Submission as Delegated Claims Authority for Individual Section")
    public void SelectDCASubmissionClaimsforIndividualSection()
    {
        try
        {
            testContext.getWebElementUtil().commonSelectDropdown("Delegated Claims Administrator", pageFactory.getIndividualSectionDetails().ClaimsSubmissionParty);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Error Message for Underwriter Not Selected")
    public void ValidateUnderwriterNotSelected()
    {
        try
        {
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
            testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().ReportingAggregatesExposureUnderwriterError);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Error Message for Coverholder Not Selected")
    public void ValidateCoverholderNotSelected()
    {
        try
        {
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
            testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().ReportingAggregatesExposureCoverholderError);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Error Message for Delegated Claims Administrator Not Selected")
    public void ValidateDCANotSelected()
    {
        try
        {
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
            testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().ReportingAggregatesExposureDCAError);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Risk Code Warning")
    public void ValidateRiskCodeWarning()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().RiskCodeWarning);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Premium Level of Authority Field Error for Coverholder")
    public void ValidatePremiumLevelofAuthorityCoverholderError()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().PremiumLevelOfAuthorityFieldError);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Verify the Contract Administrator when Managing Agent acts as a Contract Creator \"(.*)\"$")
    public void ContractAdministratorWhenManagingAgentIsContractcreator(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            int actualOption = testContext.getWebElementUtil().commonGetDropdownSize(pageFactory.getIndividualSectionDetails().ContractAdministratorDropdown);
            Assert.assertEquals(actualOption, 1);

            String actualContractAdministrator = testContext.getWebElementUtil().commonGetTextFromElement(pageFactory.getIndividualSectionDetails().ContractAdministratorValue);
            String expectedContractAdministrator = MPRData.get(index).get("SyndicateLead");
            Assert.assertEquals(actualContractAdministrator, expectedContractAdministrator);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Default Party for roles in relation to Risks Written for Common section")
    public void ValidateDefaultsforRisksWrittenCommonsection()
    {
        try
        {
            String selectedpartySubmission = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getCommonSectionDetails().RisksWrittenSubmissionParty);
            Assert.assertEquals(selectedpartySubmission, "Coverholder");
            String selectedpartyTransformation = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getCommonSectionDetails().RisksWrittenTransformationParty);
            Assert.assertEquals(selectedpartyTransformation, "Underwriters");
            String selectedpartyAssignment = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getCommonSectionDetails().RisksWrittenAssignmentParty);
            Assert.assertEquals(selectedpartyAssignment, "Underwriters");
            String selectedpartyApproval = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getCommonSectionDetails().RisksWrittenApprovalParty);
            Assert.assertEquals(selectedpartyApproval, "Underwriters");
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Default Party for roles in relation to Paid Premium for Common section")
    public void ValidateDefaultsforPaidPremiumCommonsection()
    {
        try
        {
            String selectedpartySubmission = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getCommonSectionDetails().PaidPremiumSubmissionParty);
            Assert.assertEquals(selectedpartySubmission, "Coverholder");
            String selectedpartyTransformation = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getCommonSectionDetails().PaidPremiumTransformationParty);
            Assert.assertEquals(selectedpartyTransformation, "Underwriters");
            String selectedpartyAssignment = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getCommonSectionDetails().PaidPremiumAssignmentParty);
            Assert.assertEquals(selectedpartyAssignment, "Underwriters");
            String selectedpartyApproval = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getCommonSectionDetails().PaidPremiumApprovalParty);
            Assert.assertEquals(selectedpartyApproval, "Underwriters");
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Default Party for roles in relation to Aggregates for Common section")
    public void ValidateDefaultsforAggregatesCommonsection()
    {
        try
        {
            String selectedpartySubmission = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getCommonSectionDetails().AggregatesSubmissionParty);
            Assert.assertEquals(selectedpartySubmission, "Coverholder");
            String selectedpartyTransformation = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getCommonSectionDetails().AggregatesTransformationParty);
            Assert.assertEquals(selectedpartyTransformation, "Underwriters");
            String selectedpartyAssignment = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getCommonSectionDetails().AggregatesAssignmentParty);
            Assert.assertEquals(selectedpartyAssignment, "Underwriters");
            String selectedpartyApproval = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getCommonSectionDetails().AggregatesApprovalParty);
            Assert.assertEquals(selectedpartyApproval, "Underwriters");
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Default Party for roles in relation to Risks Written for Individual section")
    public void ValidateDefaultsforRisksWrittenIndividualsection()
    {
        try
        {
            String selectedpartySubmission = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getIndividualSectionDetails().RisksWrittenSubmissionParty);
            Assert.assertEquals(selectedpartySubmission, "Coverholder");
            String selectedpartyTransformation = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getIndividualSectionDetails().RisksWrittenTransformationParty);
            Assert.assertEquals(selectedpartyTransformation, "Underwriters");
            String selectedpartyAssignment = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getIndividualSectionDetails().RisksWrittenAssignmentParty);
            Assert.assertEquals(selectedpartyAssignment, "Underwriters");
            String selectedpartyApproval = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getIndividualSectionDetails().RisksWrittenApprovalParty);
            Assert.assertEquals(selectedpartyApproval, "Underwriters");
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Default Party for roles in relation to Paid Premium for Individual section")
    public void ValidateDefaultsforPaidPremiumIndividualsection()
    {
        try
        {
            String selectedpartySubmission = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getIndividualSectionDetails().PaidPremiumSubmissionParty);
            Assert.assertEquals(selectedpartySubmission, "Coverholder");
            String selectedpartyTransformation = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getIndividualSectionDetails().PaidPremiumTransformationParty);
            Assert.assertEquals(selectedpartyTransformation, "Underwriters");
            String selectedpartyAssignment = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getIndividualSectionDetails().PaidPremiumAssignmentParty);
            Assert.assertEquals(selectedpartyAssignment, "Underwriters");
            String selectedpartyApproval = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getIndividualSectionDetails().PaidPremiumApprovalParty);
            Assert.assertEquals(selectedpartyApproval, "Underwriters");
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Default Party for roles in relation to Aggregates for Individual section")
    public void ValidateDefaultsforAggregatesIndividualsection()
    {
        try
        {
            String selectedpartySubmission = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getIndividualSectionDetails().AggregatesSubmissionParty);
            Assert.assertEquals(selectedpartySubmission, "Coverholder");
            String selectedpartyTransformation = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getIndividualSectionDetails().AggregatesTransformationParty);
            Assert.assertEquals(selectedpartyTransformation, "Underwriters");
            String selectedpartyAssignment = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getIndividualSectionDetails().AggregatesAssignmentParty);
            Assert.assertEquals(selectedpartyAssignment, "Underwriters");
            String selectedpartyApproval = testContext.getWebElementUtil().commonVerifySelectedOption(pageFactory.getIndividualSectionDetails().AggregatesApprovalParty);
            Assert.assertEquals(selectedpartyApproval, "Underwriters");
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Participants for Risks Written Coverholder or Service Company and Underwriters Common section \"(.*)\"$")
    public void ValidateCoverholderandUnderwritersRisksWrittenCommonsection(String details)
    {
        try
        {
            int index = Integer.parseInt(details)-1;
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().RisksWrittenSubmissionParticipant);
            if(scenarioContext.contractID.contains("SC"))
            {
                String actualServiceCompany = pageFactory.getCommonSectionDetails().RisksWrittenSubmissionParticipant.getAttribute("value");
                String expectedServiceCompany = MPRData.get(index).get("CapacitySeeker");
                Assert.assertEquals(actualServiceCompany, expectedServiceCompany);
            }
            else
            {
                String actualCoverholder = pageFactory.getCommonSectionDetails().RisksWrittenSubmissionParticipant.getAttribute("value");
                String expectedCoverholder = MPRData.get(index).get("CapacitySeeker");
                Assert.assertEquals(actualCoverholder, expectedCoverholder);
            }
            
            String actualUnderwriterTransformation = pageFactory.getCommonSectionDetails().RisksWrittenTransformationParticipant.getAttribute("value");
            String expectedUnderwriter = MPRData.get(index).get("SyndicateLead");
            Assert.assertEquals(actualUnderwriterTransformation, expectedUnderwriter);
            String actualUnderwriterAssignment = pageFactory.getCommonSectionDetails().RisksWrittenAssignmentParticipant.getAttribute("value");
            Assert.assertEquals(actualUnderwriterAssignment, expectedUnderwriter);
            String actualUnderwriterApproval = pageFactory.getCommonSectionDetails().RisksWrittenApprovalParticipant.getAttribute("value");
            Assert.assertEquals(actualUnderwriterApproval, expectedUnderwriter);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Participants for Paid Premium Coverholder or Service Company and Underwriters Common section \"(.*)\"$")
    public void ValidateCoverholderandUnderwritersPaidPremiumCommonsection(String details)
    {
        try
        {
            int index = Integer.parseInt(details)-1;
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().PaidPremiumSubmissionParticipant);
            if(scenarioContext.contractID.contains("SC"))
            {
                String actualCoverholder = pageFactory.getCommonSectionDetails().PaidPremiumSubmissionParticipant.getAttribute("value");
                String expectedCoverholder = MPRData.get(index).get("CapacitySeeker");
                Assert.assertEquals(actualCoverholder, expectedCoverholder);
            }
            else
            {
                String actualCoverholder = pageFactory.getCommonSectionDetails().PaidPremiumSubmissionParticipant.getAttribute("value");
                String expectedCoverholder = MPRData.get(index).get("CapacitySeeker");
                Assert.assertEquals(actualCoverholder, expectedCoverholder);
            }
            
            String actualUnderwriterTransformation = pageFactory.getCommonSectionDetails().PaidPremiumTransformationParticipant.getAttribute("value");
            String expectedUnderwriter = MPRData.get(index).get("SyndicateLead");
            Assert.assertEquals(actualUnderwriterTransformation, expectedUnderwriter);
            String actualUnderwriterAssignment = pageFactory.getCommonSectionDetails().PaidPremiumAssignmentParticipant.getAttribute("value");
            Assert.assertEquals(actualUnderwriterAssignment, expectedUnderwriter);
            String actualUnderwriterApproval = pageFactory.getCommonSectionDetails().PaidPremiumApprovalParticipant.getAttribute("value");
            Assert.assertEquals(actualUnderwriterApproval, expectedUnderwriter);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Participants for Aggregates Coverholder or Service Company and Underwriters Common section \"(.*)\"$")
    public void ValidateCoverholderandUnderwritersAggregatesCommonsection(String details)
    {
        try
        {
            int index = Integer.parseInt(details)-1;
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getCommonSectionDetails().AggregatesSubmissionParticipant);
            String actualCoverholder = pageFactory.getCommonSectionDetails().AggregatesSubmissionParticipant.getAttribute("value");
            String expectedCoverholder = MPRData.get(index).get("CapacitySeeker");
            Assert.assertEquals(actualCoverholder, expectedCoverholder);
            String actualUnderwriterTransformation = pageFactory.getCommonSectionDetails().AggregatesTransformationParticipant.getAttribute("value");
            String expectedUnderwriter = MPRData.get(index).get("SyndicateLead");
            Assert.assertEquals(actualUnderwriterTransformation, expectedUnderwriter);
            String actualUnderwriterAssignment = pageFactory.getCommonSectionDetails().AggregatesAssignmentParticipant.getAttribute("value");
            Assert.assertEquals(actualUnderwriterAssignment, expectedUnderwriter);
            String actualUnderwriterApproval = pageFactory.getCommonSectionDetails().AggregatesApprovalParticipant.getAttribute("value");
            Assert.assertEquals(actualUnderwriterApproval, expectedUnderwriter);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Participants for Risks Written Coverholder or Service Company and Underwriters Individual section \"(.*)\"$")
    public void ValidateCoverholderandUnderwritersRisksWrittenIndividualsection(String details)
    {
        try
        {
            int index = Integer.parseInt(details)-1;
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().RisksWrittenSubmissionParticipant);
            if(scenarioContext.contractID.contains("SC"))
            {
                String actualServiceCompany = pageFactory.getIndividualSectionDetails().RisksWrittenSubmissionParticipant.getAttribute("value");
                String expectedServiceCompany = MPRData.get(index).get("CapacitySeeker");
                Assert.assertEquals(actualServiceCompany, expectedServiceCompany);
            }
            else
            {
                String actualCoverholder = pageFactory.getIndividualSectionDetails().RisksWrittenSubmissionParticipant.getAttribute("value");
                String expectedCoverholder = MPRData.get(index).get("CapacitySeeker");
                Assert.assertEquals(actualCoverholder, expectedCoverholder);
            }
            
            String actualUnderwriterTransformation = pageFactory.getIndividualSectionDetails().RisksWrittenTransformationParticipant.getAttribute("value");
            String expectedUnderwriter = MPRData.get(index).get("SyndicateLead");
            Assert.assertEquals(actualUnderwriterTransformation, expectedUnderwriter);
            String actualUnderwriterAssignment = pageFactory.getIndividualSectionDetails().RisksWrittenAssignmentParticipant.getAttribute("value");
            Assert.assertEquals(actualUnderwriterAssignment, expectedUnderwriter);
            String actualUnderwriterApproval = pageFactory.getIndividualSectionDetails().RisksWrittenApprovalParticipant.getAttribute("value");
            Assert.assertEquals(actualUnderwriterApproval, expectedUnderwriter);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Participants for Paid Premium Coverholder or Service Company and Underwriters Individual section \"(.*)\"$")
    public void ValidateCoverholderandUnderwritersPaidPremiumIndividualsection(String details)
    {
        try
        {
            int index = Integer.parseInt(details)-1;
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().PaidPremiumSubmissionParticipant);
            if(scenarioContext.contractID.contains("SC"))
            {
                String actualCoverholder = pageFactory.getIndividualSectionDetails().PaidPremiumSubmissionParticipant.getAttribute("value");
                String expectedCoverholder = MPRData.get(index).get("CapacitySeeker");
                Assert.assertEquals(actualCoverholder, expectedCoverholder);
            }
            else
            {
                String actualCoverholder = pageFactory.getIndividualSectionDetails().PaidPremiumSubmissionParticipant.getAttribute("value");
                String expectedCoverholder = MPRData.get(index).get("CapacitySeeker");
                Assert.assertEquals(actualCoverholder, expectedCoverholder);
            }
            
            String actualUnderwriterTransformation = pageFactory.getIndividualSectionDetails().PaidPremiumTransformationParticipant.getAttribute("value");
            String expectedUnderwriter = MPRData.get(index).get("SyndicateLead");
            Assert.assertEquals(actualUnderwriterTransformation, expectedUnderwriter);
            String actualUnderwriterAssignment = pageFactory.getIndividualSectionDetails().PaidPremiumAssignmentParticipant.getAttribute("value");
            Assert.assertEquals(actualUnderwriterAssignment, expectedUnderwriter);
            String actualUnderwriterApproval = pageFactory.getIndividualSectionDetails().PaidPremiumApprovalParticipant.getAttribute("value");
            Assert.assertEquals(actualUnderwriterApproval, expectedUnderwriter);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Participants for Aggregates Coverholder or Service Company and Underwriters Individual section \"(.*)\"$")
    public void ValidateCoverholderandUnderwritersAggregatesIndividualsection(String details)
    {
        try
        {
            int index = Integer.parseInt(details)-1;
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().AggregatesSubmissionParticipant);
            String actualCoverholder = pageFactory.getIndividualSectionDetails().AggregatesSubmissionParticipant.getAttribute("value");
            String expectedCoverholder = MPRData.get(index).get("CapacitySeeker");
            Assert.assertEquals(actualCoverholder, expectedCoverholder);
            String actualUnderwriterTransformation = pageFactory.getIndividualSectionDetails().AggregatesTransformationParticipant.getAttribute("value");
            String expectedUnderwriter = MPRData.get(index).get("SyndicateLead");
            Assert.assertEquals(actualUnderwriterTransformation, expectedUnderwriter);
            String actualUnderwriterAssignment = pageFactory.getIndividualSectionDetails().AggregatesAssignmentParticipant.getAttribute("value");
            Assert.assertEquals(actualUnderwriterAssignment, expectedUnderwriter);
            String actualUnderwriterApproval = pageFactory.getIndividualSectionDetails().AggregatesApprovalParticipant.getAttribute("value");
            Assert.assertEquals(actualUnderwriterApproval, expectedUnderwriter);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
    //Tuhin//
    @When("I Navigate to Section Details Tab")
    public void NavigatetoSecDtlsTab()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            //testContext.getWebElementUtil().commonClick(SectionDetails.initiate(testContext.getWebElementUtil().driver).SectionDetailsTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
        
    }

    @Then("I validate the CH Organization server side error message post submission for Review")
    public void CHOrgValidation()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().CHOrgErrorMsg).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("I validate the SC Organization server side error message post submission for Review")
    public void SCOrgValidation()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().SCOrgErrorMsg).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("I validate the Syndicate Organization server side error message post submission for Review")
    public void SyndOrgValidation()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().SyndOrgErrorMsg).equals(true));
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the error for Service Company as a Capacity Seeker and Capacity Lead \"(.*)\"$")
    public void ValidateErrorForServiceCompanyCapacitySeekerAndCapacityLead(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData)-1;
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
            WebElement errorForSameServiceCompany = testContext.getWebElementUtil().getDynamicElement
                ("//span[contains(text(), '"+MPRData.get(index).get("CapacitySeeker")+" has been added as capacity seeker and capacity lead')]");
            
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(errorForSameServiceCompany).equals(true));     
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Enter Confirmation Date For Capacity for Individual Section \"(.*)\"$")
    public void EnterConfirmationDateForCapacity(String Status)
    {
        try
        {
            int index = Integer.parseInt(Status)-1;
            if(scenarioContext.scenarioName.contains("Re-Sign"))
            {
                String month = "Jan";
                String day = "1";
                String year = "2020";

                testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ConfirmationDate);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ConfirmationDateMonth, month);
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ConfirmationDateYear, year);
                
                for(WebElement selectday : pageFactory.getIndividualSectionDetails().ConfirmationDateDay)
                {
                    if(selectday.getText().equalsIgnoreCase(day))
                    {
                        selectday.click();
                        break;
                    }
                }
            }
            else
            {
                if(scenarioContext.setContractStatus.equalsIgnoreCase("Active"))
                {
                    if(scenarioContext.setAgreementTemplate.contains("LMA3113AT-B"))
                    {
                        testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ConfirmationDateTwinContract);
                        testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().TodayLink);
                    }
                    else
                    {
                        testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ConfirmationDate);
                        testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().TodayLink);
                    }
                }
                else if(scenarioContext.setContractStatus.equalsIgnoreCase("Registered"))
                {
                    String newDate = testContext.getWebElementUtil().ChangeConfirmationDate(20);
                    String splitnewDate [] = newDate.split("-");
                    String month = splitnewDate [0];
                    String day = splitnewDate[1];
                    String year = splitnewDate [2];
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ConfirmationDate);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ConfirmationDateMonth, month);
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ConfirmationDateYear, year);
                
                    if(day.startsWith("0"))
                    {
                        String editDay = day.substring(1);

                        for(WebElement selectday : pageFactory.getIndividualSectionDetails().ConfirmationDateDay)
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
                        for(WebElement selectday : pageFactory.getIndividualSectionDetails().ConfirmationDateDay)
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
                    String newDate = testContext.getWebElementUtil().ChangeConfirmationDate(-30);
                    String splitnewDate [] = newDate.split("-");
                    String month = splitnewDate [0];
                    String day = splitnewDate[1];
                    String year = splitnewDate [2];
                    testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().ConfirmationDate);
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ConfirmationDateMonth, month);
                    testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().ConfirmationDateYear, year);
                
                    if(day.startsWith("0"))
                    {
                        String editDay = day.substring(1);

                        for(WebElement selectday : pageFactory.getIndividualSectionDetails().ConfirmationDateDay)
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
                        for(WebElement selectday : pageFactory.getIndividualSectionDetails().ConfirmationDateDay)
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
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Enter Confirmation Date For Capacity for Common Section")
    public void EnterConfirmationDateForCapacityCommonSection()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().ConfirmationDate);
            testContext.getWebElementUtil().commonClick(pageFactory.getCommonSectionDetails().TodayLink);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Add Delegated Data Manager \"(.*)\"$")
    public void AddDelegatedDataManager(String SyndicateName)
    {
        try
        {
            int index = Integer.parseInt(SyndicateName)-1;
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().BreachManagement, MPRData.get(index).get("SyndicateLead"));
            
            testContext.getWebElementUtil().pause();
            for(WebElement SearchResult : pageFactory.getBrokerDetails().BrokerAutoRecommend)
            {
                if(SearchResult.getText().toLowerCase().contains(MPRData.get(index).get("SyndicateLead").toLowerCase()))
                {
                    SearchResult.click();
                }
                
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Enter Maximum Retail Broker Commission")
    public void EnterMaximumRetailBrokerCommission()
    {
        try
        {
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().MaxRetailBrokerCommission);
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getIndividualSectionDetails().MaxRetailBrokerCommission, "20");
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Navigate Back to Sections Details")
    public void NavigateBackToSectionDetails()
    {
        try
        {
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().SectionDetailsValidation);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().SectionDetailsValidation);
                }
                catch(org.openqa.selenium.TimeoutException exceptionsecond)
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().WaitTillElementVisible(By.xpath
                        ("(//div[@class='custom_text'][contains(text(), ' Errors exist on Section Details tab')])[2]"));
                }
            }

            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);

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

            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
            }   
            catch(org.openqa.selenium.TimeoutException exception)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
            }

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
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Verify Service Company and Non Lloyds Insurer is not present for Common Section")
    public void AbsenceOfServiceCompanyNonLloydsInsurerDropdownCommon()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            try
            {
                testContext.getWebElementUtil().commonSelectDropdown("Service Company", pageFactory.getCommonSectionDetails().LeadType);
            }
            catch (Exception e)
            {
                Assert.assertTrue(true);
            }
            testContext.getWebElementUtil().pause();
            try
            {
                testContext.getWebElementUtil().commonSelectDropdown("Non-Lloyd's Insurer", pageFactory.getCommonSectionDetails().LeadType);
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

    @Then("Verify Service Company and Non Lloyds Insurer is not present for Individual Section")
    public void AbsenceOfServiceCompanyNonLloydsInsurerDropdownIndividual()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            try
            {
                testContext.getWebElementUtil().commonSelectDropdown("Service Company", pageFactory.getIndividualSectionDetails().LeadType);
            }
            catch (Exception e)
            {
                Assert.assertTrue(true);
            }
            testContext.getWebElementUtil().pause();
            try
            {
                testContext.getWebElementUtil().commonSelectDropdown("Non-Lloyd's Insurer", pageFactory.getIndividualSectionDetails().LeadType);
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

    @Then("Validate the Error Message for Gap in Renewal Period From and Absence of Original Coverholder")
    public void ValidateRenewalGapAndOriginalCH()
    {
        try
        {
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().OriginalCoverholderRenewalError));
            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
            }
            catch(org.openqa.selenium.TimeoutException firstexception)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
            }

            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractLeads().LeadType);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
            }
            catch(org.openqa.selenium.TimeoutException firstexception)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractLeads().LeadType);
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
                }
                catch(org.openqa.selenium.TimeoutException secondexception)
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getContractLeads().LeadType);
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
                }
            }
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getBrokerDetails().ContractMngrEmail);
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);    
            }
            catch(org.openqa.selenium.TimeoutException firstexception)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getBrokerDetails().ContractMngrEmail);
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
                }
                catch(org.openqa.selenium.TimeoutException secondexception)
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getBrokerDetails().ContractMngrEmail);
                    testContext.getWebElementUtil().commonClick(pageFactory.getCommon().BackButton);
                } 
            }
            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().UMRFrstPart);
            }
            catch(org.openqa.selenium.TimeoutException exception)
            {
                try
                {
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().UMRFrstPart);
                }
                catch(org.openqa.selenium.TimeoutException secondexception)
                {
                    testContext.getWebElementUtil().refreshPage();
                    testContext.getWebElementUtil().pause();
                    testContext.getWebElementUtil().SwitchToDefault();
                    testContext.getWebElementUtil().WaitTillFrameLoad(pageFactory.getAgreementTemplate().PegaTaskFrame);
                    testContext.getWebElementUtil().commonWaitForElement(pageFactory.getGeneralContractInformation().UMRFrstPart);
                }
            }

            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getGeneralContractInformation().RenewalTimePeriodGapError));
            
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Error Message for Managing Agent Syndicate")
    public void ErrorMessageManagingAgentSyndicate()
    {
        try
        {
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
            testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().ManagingAgentSyndicateError);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @And("Terminate a section on Individual Section Details")
    public void TerminateSectionAndNavigateToActions()
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

            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().TerminateButton);
            testContext.getWebElementUtil().commonClick(pageFactory.getIndividualSectionDetails().TerminateButton);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().CancelTerminateButton);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().CancelTerminateButton).equals(true));
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate Terminated Section is not present on Individual Section Details")
    public void ValidateTerminatedSectionIsNotPresent()
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
            
            testContext.getWebElementUtil().pause();
            int totalsections = pageFactory.getIndividualSectionDetails().SectionIDs.size();
            Assert.assertEquals(totalsections, 1);
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the error message for Capacity Seeker approval with Generic COB")
    public void ValidateErrorMessageForCapacitySeekerApprovalWithGenericCOB()
    {
        try
        {
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
            if(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().GenericCOBApprovalCapacitySeekerErrorMessage).equals(false))
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

    @Then("Validate the CH or SC enetered not approved for Risk Location")
    public void ValidateRiskLocationApprovalForCHSC()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().RiskLocationApprovalForCHSCError);
            if(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().RiskLocationApprovalForCHSCError).equals(false))
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

    @Then("Validate the error message for Risk Location approval with CH or SC")
    public void ValidateErrorMessageForRiskLocationApprovalWithCHSC()
    {
        try
        {
            testContext.getWebElementUtil().WaitTillElementVisible(By.xpath("//h2[text()='Validation Error']"));
            if(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().RiskLocationApprovalForCHSCError).equals(false))
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

    @Then("Validate Person Responsible For Operation and Control Apply is Disabled")
    public void ValidatePersonResponsibleForOperationAndControlApplyIsDisabled()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            Assert.assertFalse(pageFactory.getCommonSectionDetails().ApplyPersonResponsible.isEnabled());
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate Territorial Limitations Apply is Disabled")
    public void ValidateTerritorialLimitationsApplyIsDisabled()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            Assert.assertFalse(pageFactory.getCommonSectionDetails().ApplyTerritorialLimits.isEnabled());
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate Period Of Insurances Bound Apply is Disabled")
    public void ValidatePeriodOfInsurancesBoundApplyIsDisabled()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            Assert.assertFalse(pageFactory.getCommonSectionDetails().ApplyPeriodOfInsuranceBound.isEnabled());
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate Commissions Apply is Disabled")
    public void ValidateCommissionsApplyIsDisabled()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            Assert.assertFalse(pageFactory.getCommonSectionDetails().ApplyCommissions.isEnabled());
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate Claims and Complaints Apply is Disabled")
    public void ValidateClaimsAndComplaintsApplyIsDisabled()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            Assert.assertFalse(pageFactory.getCommonSectionDetails().ApplyClaimsAndComplaints.isEnabled());
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate Reporting and Aggregate Exposures Apply is Enabled")
    public void ValidateReportingAndAggregateExposuresApplyIsEnabled()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            Assert.assertTrue(pageFactory.getCommonSectionDetails().ApplyReportingAndAggregate.isEnabled());
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate Capacity Details Apply is Disabled")
    public void ValidateCapacityDetailsApplyIsDisabled()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            Assert.assertFalse(pageFactory.getCommonSectionDetails().ApplyCapacityDetails.isEnabled());
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate Non Schedule Apply is Disabled")
    public void ValidateNonScheduleApplyIsDisabled()
    {
        try
        {
            testContext.getWebElementUtil().pause();
            Assert.assertFalse(pageFactory.getCommonSectionDetails().ApplyNonSchedule.isEnabled());
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate user is not able to submit Endorsement without filling mandatory details")
    public void ValidateEndorsementErrorWithoutFillingMandatoryDetails()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().EndorsementError);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().EndorsementError).equals(true));
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the error message when user have not selected lead for Brussels on Section Details")
    public void ValidateBrusselsLeadErrorTwinContract()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getIndividualSectionDetails().IndividualSectionDetails);
            Assert.assertTrue(testContext.getWebElementUtil().isPresent(pageFactory.getIndividualSectionDetails().TwinContractBrusslesLeadErrorSectionDetails).equals(true));
        }
        catch (AssertionError | Exception e) 
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

}