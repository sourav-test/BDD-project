package com.chorus.pagefactory.createContractPageElements;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Factory Class
 * General Contract Information
 */

public class GeneralContractInformationPage {

    @FindBy(xpath = "//iframe[contains(@title, 'CON-')]")
    public WebElement PegaTaskFrame;

    @FindBy(xpath = "//div[contains(text(), 'Unique Market Reference Number (UMR)')]")
    public  WebElement UMRHeader;

    @FindBy(xpath = "(//div[contains(text(), 'Unique Market Reference Number (UMR)')]//following::input)[1]")
    public WebElement UMRFrstPart;

    @FindBy(xpath = "(//div[contains(text(), 'Unique Market Reference Number (UMR)')]//following::input)[2]")
    public WebElement UMRScndPart;

    @FindBy(xpath = "//div[contains(text(), 'Invalid value')]")
    public WebElement UMRErrorMessage;

    @FindBy(xpath = "(//label[text()='Agreement Number']//following::input)[1]")
    public WebElement AgreementNmbr;

    @FindBy(xpath = "//span[contains(@name, 'PeriodFrom')]")
    public WebElement PeriodFromDt;

    @FindBy(xpath = "//span[contains(@name, 'PeriodTo')]")
    public WebElement PeriodToDt;

    @FindBy(xpath = "(//span[@id='monthSpinner']//following::input[@type='text'])[1]")
    public WebElement DateMonth;

    @FindBy(xpath = "(//span[@id='yearSpinner']//following::input[@type='text'])[1]")
    public WebElement DateYear;

    @FindBy(xpath = "//td[contains(@class, 'calcell')]//a")
    public List<WebElement> DateDay;

    @FindBy(xpath = "(//label[contains(text(), 'Any Time Zone')]//following::label[text()='No'])[1]")
    public WebElement AnyTimeZoneNo;

    @FindBy(xpath = "(//label[contains(text(), 'Any Time Zone')]//following::label[text()='Yes'])[1]")
    public WebElement AnyTimeZoneYes;

    @FindBy(xpath = "//select[contains(@name, 'TimeZone')]")
    public WebElement SelectTimezone;

    @FindBy(xpath = "(//label[contains(text(), 'Both Days Inclusive')]//following::label[text()='Yes'])[1]")
    public WebElement BothDaysYes;

    @FindBy(xpath = "(//label[contains(text(), 'Both Days Inclusive')]//following::label[text()='No'])[1]")
    public WebElement BothDaysNo;

    @FindBy(xpath = "//select[contains(@id, 'TimePeriodFromHrsHr')]")
    public WebElement SelectTimePeriodFromHours;

    @FindBy(xpath = "//select[contains(@id, 'TimePeriodFromHrsMi')]")
    public WebElement SelectTimePeriodFromMinutes;

    @FindBy(xpath = "//select[contains(@id, 'TimePeriodToHrsHr')]")
    public WebElement SelectTimePeriodToHours;

    @FindBy(xpath = "//select[contains(@id, 'TimePeriodToHrsMi')]")
    public WebElement SelectTimePeriodToMinutes;

    @FindBy(xpath = "(//label[contains(text(), 'Is this a sub-contract')]//following::label[text()='Yes'])[1]")
    public WebElement SubContractYes;

    @FindBy(xpath = "(//label[contains(text(), 'Is this a sub-contract')]//following::label[text()='No'])[1]")
    public WebElement SubContractNo;

    @FindBy(xpath = "//input[contains(@name, 'MasterContractUMR')]")
    public WebElement SubContractField;

    @FindBy(xpath = "(//label[contains(text(), 'Is this a tripartite agreement?')]//following::label[text()='Yes'])[1]")
    public WebElement TripartiteAgreementYes;

    @FindBy(xpath = "(//label[text()='Is this a tripartite agreement?']//following::label[text()='No'])[1]")
    public WebElement TripartiteAgreementNo;

    @FindBy(xpath = "//input[contains(@name, 'CurrencyCode')]")
    public WebElement CurrencyCode;

    @FindBy(xpath = "//span[@class='match']")
    public List<WebElement> CurrencyCodeAutoRecommend;

    @FindBy(xpath = "//tr[contains(@id, 'UMRSearch')]")
    public List<WebElement> UMRSubContractAutoRecommend;

    @FindBy(xpath = "(//label[contains(text(),'Direct Reporting')]//following::label[text()='Yes'])[1]")
    public WebElement LloydsDirectReportingYes;

    @FindBy(xpath = "(//label[contains(text(),'Direct Reporting')]//following::label[text()='No'])[1]")
    public WebElement LloydsDirectReportingNo;

    @FindBy(xpath = "//span[contains(text(), 'There is a gap in cover between this contract and the contract it is renewing from')]")
    public WebElement RenewalTimePeriodGapError;

    @FindBy(xpath = "//div[contains(text(), 'Characters 2-5 of the UMR do not match')]")
    public WebElement UMRMatchWithBrokerErrorMsg;

    @FindBy(xpath = "((//span[text()='Date confirmation was received'])[1]//following::span)[1]")
    public WebElement DateConfirmation;
    
}
