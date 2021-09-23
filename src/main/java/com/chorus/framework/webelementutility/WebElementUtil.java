package com.chorus.framework.webelementutility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementUtil {

    private WebDriver driver;

    public WebElementUtil(WebDriver driver)
    {
        this.driver=driver;
    }

    /**
     * @param element Webelement
     */
    
    public void commonWaitForElement(WebElement element)
    {
        int counter = 0;
        while(counter<=5)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            }
            catch(org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException e)
            {
                counter++;
            }
        }   
    }

    /**
     * @param element Webelement
     */

    public void commonClick(WebElement element)
    {
        int counter = 0;
        while(counter<=5)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                break;
            }
            catch(org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException e)
            {
                counter++;
            }
        }
    }

    /**
     * @param element Webelement
     * @param testdata Enter text
     */
    public void commonSendTestData(WebElement element, String testdata)
    {
        int counter = 0;
        while(counter<=5)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.sendKeys(testdata);
                break;
            }
            catch(org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException e)
            {
                counter++;
            }
        }
    }


    public void SwitchToDefault()
    {
        driver.switchTo().defaultContent();
    }

    public void TimeOutWait()
    {
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    /**
     * @param element Webelement
     * @param option dropdown option(visible text)
     */

    public void commonSelectDropdown(String option, WebElement element)
    {
        int counter = 0;
        while(counter<=5)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                Select slctdropdown = new Select(element);
                slctdropdown.selectByVisibleText(option);
                break;
            }
            catch(org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException e)
            {
                counter++;
            }
        }
    }

    public String commonVerifySelectedOption(WebElement element)
    {
        String selectedtext = null;
        int counter = 0;
        while(counter<=5)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                Select slctdropdown = new Select(element);
                WebElement selectedoption = slctdropdown.getFirstSelectedOption();
                selectedtext = selectedoption.getText();
                break;
            }
            catch(org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException e)
            {
                counter++;
            }
        }
        
        return selectedtext;
    }

    public int commonGetDropdownSize(WebElement element)
    {
        int dropdownSize = 0;
        int counter = 0;
        while(counter<=5)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                Select slctdropdown = new Select(element);
                List<WebElement> countOptions = slctdropdown.getOptions();
                dropdownSize = countOptions.size();
                break;
            }
            catch(org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException e)
            {
                System.err.println("Exception Handled");
                counter++;
            }
        }

        return dropdownSize;
    }

    /**
     * 
     * @param locator xpath/id/name
     */
    public void WaitTillElementVisible(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void pause()
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(3000);
        }
        catch(InterruptedException e)
        {
            e.getMessage();
        }
    }

    public void HoverToElement(WebElement element)
    {
        
        Actions builder = new Actions(driver);
        builder.moveToElement(element).click(element);
        builder.pause(5);
        builder.perform();
    }
    public void AcceptAlert()
    {
        driver.switchTo().alert().accept();
        pause();
    }

    public Boolean commonPresenceListElement(List<WebElement> element)
    {
        try
        {
            pause();
            element.isEmpty();
            return true; 
        }
        catch (org.openqa.selenium.NoSuchElementException e) 
        {
            return false;
        }

    }
    
    public Boolean isPresent(WebElement element)
    {
        try
        {
            pause();
            element.isDisplayed();
            return true; 
        }
        catch (org.openqa.selenium.NoSuchElementException e) 
        {
            return false;
        }
    }
    public Boolean isnotPresent(WebElement element)
    {
        try
        {
            element.isDisplayed();
            return false; 
        }
        catch (org.openqa.selenium.NoSuchElementException e) 
        {
            return true;
        }
    }
    public Boolean isPresentDynamic(By locator)
    {
        try
        {
            pause();
            driver.findElement(locator);
            return true; 
        }
        catch (org.openqa.selenium.NoSuchElementException e) 
        {
            return false;
        }
    }

    public Boolean isPresentList(List<WebElement> element)
    {
        pause();
        if(element.size()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void ValidatePresenceOfElement(WebElement element)
    {
        int counter = 0;
        while(counter<=2)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 3);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            }
            catch(org.openqa.selenium.StaleElementReferenceException e)
            {
                counter++;
            }
        }
    }

    public void HoverOver(WebElement element)
    {
        Actions builder = new Actions(driver);
        builder.moveToElement(element);
    }

    public void WaitTillFrameLoad(WebElement element)
    {
        int counter = 0;
        while(counter<=5)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 180);
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
                break;
            }
            catch(org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException | org.openqa.selenium.TimeoutException e)
            {
                counter++;
            }
        }
    }

    public void WaitTillFrameLoadRenewEndorse(WebElement element)
    {
        int counter = 0;
        while(counter<=10)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
                break;
            }
            catch(org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException | org.openqa.selenium.TimeoutException e)
            {
                pauseForAgreeDisagreeReviewTask();
                driver.navigate().refresh();
                counter++;
            }
        }
    }

    public String GetCurrentDateMDY()
    {
        DateFormat customformat = new SimpleDateFormat("MMM-dd-yyyy");
        Date currentdate = new Date();
        return customformat.format(currentdate);
    }

    public String GetCurrentDateDMY()
    {
        DateFormat customformat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentdate = new Date();
        return customformat.format(currentdate);
    }

    public String GetCurrentDMMMY()
    {
        DateFormat customformat = new SimpleDateFormat("dd-MMM-yyyy");
        Date currentdate = new Date();
        return customformat.format(currentdate);
    }

    public String ChangeConfirmationDate(int days) throws ParseException
    {
        Date currentdate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentdate);
        calendar.add(Calendar.DATE, days);
        return dateFormat.format(calendar.getTime());
    }

    public String ChangePeriodFromDate(int days) throws ParseException
    {
        String currentdate = GetCurrentDateMDY();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(currentdate));
        calendar.add(Calendar.DATE, days);
        return dateFormat.format(calendar.getTime());
    }

    public String commonGetTextFromElement(WebElement element)
    {
        String expectedtext = null;
        int counter = 0;
        while(counter<=5)
        {
            try
            {
                commonWaitForElement(element);
                expectedtext = element.getAttribute("value");
                break;
            }
            catch(org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException e)
            {
                counter++;
            }
        }
        return expectedtext;
    }

    

    public void commonClearField(WebElement element)
    {
        int counter = 0;
        while(counter<=5)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.clear();
                break;
            }
            catch(org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException e)
            {
                counter++;
            }
        }
    }

    public void pauseForContractSubmission()
    {
        try
        {
            TimeUnit.SECONDS.sleep(60);
        }
        catch(InterruptedException e)
        {
            e.getMessage();
        }
    }

    public void pauseAfterSave()
    {
        try
        {
            TimeUnit.SECONDS.sleep(80);
        }
        catch(InterruptedException e)
        {
            e.getMessage();
        }
    }

    public void pauseForAgreeDisagreeReviewTask()
    {
        try
        {
            TimeUnit.SECONDS.sleep(60);
        }
        catch(InterruptedException e)
        {
            e.getMessage();
        }
    }


    public Boolean ContractSubmitted(WebElement element)
    {
        try
        {
            element.isDisplayed();
            return false; 
        }
        catch (org.openqa.selenium.TimeoutException exception) 
        {
            return true;
        }
    }

    public void commonWaitForList(List<WebElement> element)
    {
        int counter = 0;
        while(element.size()<=0 && counter<=10)
        {
            pause();
        }
           
    }

    public void ValidatePresenceOfListElements(List<WebElement> element)
    {
        int counter = 0;
        try
        {
            while(element.size()<=0 && counter<=2)
            {
                pause();
            }
        }
        catch (org.openqa.selenium.TimeoutException exception) 
        {
            counter++;
        }
    }

    public WebElement getDynamicElement(String dynamicXpath) {

        WebElement dynamicElement = null;
        try
        {
            dynamicElement = driver.findElement(By.xpath(dynamicXpath));
        }
        catch (org.openqa.selenium.NoSuchElementException e) 
        {
            e.printStackTrace();
        }

        return dynamicElement;
    }

    public void refreshPage() {

        try
        {
            driver.navigate().refresh();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public JavascriptExecutor getExecutor()
    {
        JavascriptExecutor executor = null;
        try
        {
            executor = (JavascriptExecutor)driver; 
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return executor;
    }

    
}
