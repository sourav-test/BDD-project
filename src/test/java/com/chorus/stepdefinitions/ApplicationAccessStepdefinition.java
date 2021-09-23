package com.chorus.stepdefinitions;

import java.util.HashMap;
import java.util.List;
import com.chorus.framework.controllers.FileReaderController;
import com.chorus.framework.controllers.PageFactoryController;
import com.chorus.framework.picocontainerdependency.TestContext;
import com.chorus.scenariocontext.ScenarioContext;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


/**
* Application Access Step Definition
* Login, Logout
*/


public class ApplicationAccessStepdefinition {
    
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

    public ApplicationAccessStepdefinition(TestContext testContext, ScenarioContext scenarioContext) 
    {
        this.testContext=testContext;
        this.scenarioContext=scenarioContext;
        pageFactory = testContext.getPageFactoryController();
        fileReaderController = testContext.getFileReaderController();
        MPRData = testContext.getFileReaderController().getExcelReader().GetTestData("MPRData");
    }

    /**
     * This method is used to check that the User is already
     * logged in to the DCOM Application or not
     * @return boolean
     */
    
    public Boolean SessionCheck() 
    {
        if(testContext.getWebElementUtil().isPresent(pageFactory.getAgreementTemplate().PegaTaskFrame).equals(true) | testContext.getWebElementUtil().isPresent(pageFactory.getCommon().PegaAssignFrame).equals(true))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * This method is used to login to the DCOM Application
     * for Contract Creator
     * @param testData = row number
     */

    @Given("Login as Contract Creator \"(.*)\"$")
    public void LoginAsContractCreator(String testData) 
    {    
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

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
            if(SessionCheck().equals(true))
            {
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
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
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }

    }

    /**
     * This method is used to login to the DCOM Application
     * for Lloyds User
     * @param testData = row number
     */
    
    @Given("Login as Lloyds User \"(.*)\"$")
    public void LoginAsLloydsUser(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("LloydsUser"));
            scenarioContext.ContractCreator= MPRData.get(index).get("LlyodsUser");
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
            }
            
            testContext.getWebElementUtil().TimeOutWait();
            if(SessionCheck().equals(true))
            {
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("LloydsUser"));
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionfirst)
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
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
     * This method is used to login to the DCOM Application
     * for DXC User
     * @param testData = row number
     */

    @Given("Login as DXC User \"(.*)\"$")
    public void LoginAsDXCUser(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("DXCUser"));
            scenarioContext.ContractCreator= MPRData.get(index).get("LlyodsUser");
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
            }
            
            testContext.getWebElementUtil().TimeOutWait();
            if(SessionCheck().equals(true))
            {
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("DXCUser"));
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionfirst)
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
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
     * This method is used to logout from DCOM Application
     * for All Types of User 
     */
    
    @And("Log out from Application")
    public void logout() 
    {
        try
        {
            testContext.getWebElementUtil().pause();
            testContext.getWebElementUtil().SwitchToDefault();
            testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().pause();
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
            }

            try
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getApplicationAccess().UsernameField);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getApplicationAccess().UsernameField);
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * This method is used to login to the DCOM Application
     * for Managing Agent User
     * @param testData = row number
     */
    
    @And("Login as Managing Agent Operator \"(.*)\"$")
    public void LoginAsManagingAgentOperator(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ManagingAgentOperator"));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
            }
            
            if(SessionCheck().equals(true))
            {
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ManagingAgentOperator"));
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionfirst)
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
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
     * This method is used to login to the DCOM Application
     * for Service Company User
     * @param testData = row number
     */

    @And("Login as Service Company Operator \"(.*)\"$")
    public void LoginAsServiceCompanyOperator(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ServiceCompanyOperator"));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
            }
            if(SessionCheck().equals(true))
            {
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ServiceCompanyOperator"));
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionfirst)
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
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
     * This method is used to login to the DCOM Application
     * for Coverholder User
     * @param testData = row number
     */

    @And("Login as Coverholder Operator \"(.*)\"$")
    public void LoginAsCoverholderOperator(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("CoverholderOperator"));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
            }
            if(SessionCheck().equals(true))
            {
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("CoverholderOperator"));
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionfirst)
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
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
     * This method is used to login to the DCOM Application
     * for Task Assign User
     * @param testData = row number
     */

    
    @And("^Login as Assigned To User \"(.*)\"$")
    public void LoginAsAssignedUser(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("AssignedToUsername"));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
            }
            testContext.getWebElementUtil().TimeOutWait();
            if(SessionCheck().equals(true))
            {
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("AssignedToUsername"));
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionfirst)
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
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
     * This method is used to login to the DCOM Application
     * for Managerial Group User or Default Shared User 
     * for Share Contract Scenarios
     * @param testData = row number
     */

    @Given("^Login as Default Shared User \"(.*)\"$")
    public void DefaultSharelogin(String testData)
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ManagerialGroupUser"));
            scenarioContext.ContractCreator= MPRData.get(index).get("ManagerialGroupUser");
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());

            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
            }
            
            testContext.getWebElementUtil().TimeOutWait();
            if(SessionCheck().equals(true))
            {
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ManagerialGroupUser"));
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionfirst)
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
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
     * This method is used to login to the DCOM Application
     * for Child Group User for Share Contract Scenarios
     * @param testData = row number
     */

    @Given("Login as Additional Shared User \"(.*)\"$")
    public void AddSharelogin(String testData) 
    {
        try
        {
            /** Adding this line as List index starts from 0, so the row number will be -1 */
            int index = Integer.parseInt(testData)-1;

            testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ChildGroupUser"));
            scenarioContext.ContractCreator= MPRData.get(index).get("ChildGroupUser");
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());

            try
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
            }
            catch(org.openqa.selenium.TimeoutException exceptionfirst)
            {
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
            }

            testContext.getWebElementUtil().TimeOutWait();
            if(SessionCheck().equals(true))
            {
                testContext.getWebElementUtil().SwitchToDefault();
                testContext.getWebElementUtil().commonClick(pageFactory.getCommon().ProfileIcon);
                testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LogOfflink);
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().UsernameField, MPRData.get(index).get("ChildGroupUser"));
                testContext.getWebElementUtil().commonSendTestData(pageFactory.getApplicationAccess().PasswordField, fileReaderController.getPropertiesReader().getPassword());
                try
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
                }
                catch(org.openqa.selenium.TimeoutException exceptionfirst)
                {
                    testContext.getWebElementUtil().commonClick(pageFactory.getApplicationAccess().LoginButton);
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