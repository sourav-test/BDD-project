package com.chorus.pagefactory.createContractPageElements;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Factory Class
 * Agreement Template
 */


public class AgreementTemplatePage {

    @FindBy(xpath = "//h1[contains(text(), 'Agreement template')]")
    public WebElement AgreementTemplateHeader;
    
    @FindBy(xpath = "//input[@placeholder='Select...']")
    public WebElement TemplateField;

    @FindBy(xpath = "//span[@class='secondary']")
    public List<WebElement> ContractTypeList;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement SearchField;

    @FindBy(xpath = "//li[contains(@role, 'treeitem')]")
    public List<WebElement> OrgCSNlist;

    @FindBy(xpath = "//input[@type='text'][contains(@name, 'OperatorOrg')]")
    public WebElement OperatorOrganizationField;

    @FindBy(xpath = "//a[contains(@name, 'AddCreatorOrg')]")
    public WebElement DeleteOrgLink;

    @FindBy(xpath = "//input[@type='text'][contains(@name, 'OperatorCSN')]")
    public WebElement OperatorCSNField;

    @FindBy(xpath = "//a[contains(@name, 'AddCreatorCSN')]")
    public WebElement DeleteCSNLink;

    @FindBy(xpath = "//select[contains(@name, 'SelectUserGroup')]")
    public WebElement SelectUserGroup;

    @FindBy(xpath = "//a[contains(@name, 'AddCreatorUserGroup')]")
    public WebElement UserGroupDeleteLink;

    @FindBy(xpath = "//label[text()='Yes']")
    public WebElement NonScheduleCheckYes;

    @FindBy(xpath = "//label[text()='No']")
    public WebElement NonScheduleCheckNo;

    @FindBy(xpath = "(//iframe[contains(@title, 'Contracts')])")
    public WebElement PegaMyContractsNavigateBackFrame;

    @FindBy(xpath = "//iframe[contains(@src, 'MarketParticipant')]")
    public WebElement PegaTaskFrame;

    @FindBy(xpath = "(//iframe[contains(@src, 'MarketParticipant')])[2]")
    public WebElement PegaTaskRetractFrame;

    @FindBy(xpath = "//iframe[contains(@title, 'E-')]")
    public WebElement PegaEndorsementFrame;

    @FindBy(xpath = "//input[@title='Enter text to search']")
    public WebElement EnterContractID;

    @FindBy(xpath = "(//*[@title='Search'])[1]")
    public WebElement SearchIcon;

    @FindBy(xpath = "//a[contains(text(), 'CON-')]")
    public WebElement ContractResult;

    @FindBy(xpath = "//button[@title='Begin']")
    public WebElement Begin;

    @FindBy(xpath = "//div[contains(text(), 'multi-year template')]")
    public WebElement MultiYearTemplateMessage;

    @FindBy(xpath = "//div[contains(text(), 'Please select at least one user group')]")
    public WebElement UserGroupErrorMessage;

    /* Endorsement Objects */

    @FindBy(xpath = "//input[contains(@name, 'EndorsementReferenceNumber')]")
    public WebElement EndorsementReferenceNumber;
    
    @FindBy(xpath = "//span[contains(@name, 'EffectiveDate')]")
    public WebElement EndorsementEffectiveDate;

    @FindBy(xpath = "(//img[contains(@name, 'Calendar')])[1]")
    public WebElement CalendarIconForEndorsement;

    @FindBy(xpath = "//label[contains(text(), 'Endorsement effective date')]")
    public WebElement EndorsementEffectiveDateLabel;

    @FindBy(xpath = "//span[contains(@name, 'ConfirmationDate')]")
    public WebElement EndorsementConfirmationDate;

    @FindBy(xpath = "(//input[contains(@name, 'ConfirmationDate')]//following::img[contains(@name, 'Calendar')])[1]")
    public WebElement EndorsementConfirmationDateCalendar;

    @FindBy(xpath = "//textarea[contains(@name, 'EndorsementDetails')]")
    public WebElement EndorsementDetails;

    @FindBy(xpath = "//button[text()='Attach']")
    public WebElement AttachButton;

    @FindBy(xpath = "(//input[@type='file'])[1]")
    public WebElement UploadEndorsementCopyPath;

    @FindBy(xpath = "//button[contains(text(), 'Upload')]")
    public WebElement TerminationNoticeUploadButton;

    @FindBy(xpath = "//input[contains(@name, 'ContractData')][contains(@name, 'EffectiveDate')]")
    public WebElement EndorsementEffectiveDateCoreQuestions;

    @FindBy(xpath = "//input[contains(@name, 'WorkPage')][contains(@name, 'EndorsementEffectiveDate')]")
    public WebElement TerminationEndorsementEffectiveDateCoreQuestions;

    @FindBy(xpath = "(//h2[contains(text(), 'Associated content')])[2]")
    public WebElement AssociatedContentHeader;

}
