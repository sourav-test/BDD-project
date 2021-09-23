package com.chorus.pagefactory.createContractPageElements;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Factory Class
 * Contract Review
 * Review Task Approve, Return
 * Validate Review Task Email
 * Agree and Disagree Returned Review Task
 * Open Draft and Review Task
 */


public class ContractReviewPage {

    @FindBy(xpath = "//h2[contains(text(), 'Contract Task Progress')]")
    public WebElement ReviewHarnessHeader;
    
    @FindBy(xpath = "//iframe[contains(@title, 'R-')]")
    public WebElement ReviewTaskFrame;

    @FindBy(xpath = "//a[contains(@title, 'has been assigned')][contains(@id, 'img')]")
    public WebElement EmailIconAssignedTo;
    
    @FindBy(xpath = "//a[contains(@title, 'has been created')][contains(@id, 'img')]")
    public WebElement EmailIconCaseCreation;

    @FindBy(xpath = "//a[contains(@title, 'has been returned')][contains(@id, 'img')]")
    public WebElement EmailIconReviewReturned;

    @FindBy(xpath = "//a[contains(@title, 'has been disagreed')][contains(@id, 'img')]")
    public WebElement EmailIconDisgareed;

    @FindBy(xpath = "//a[contains(@title, 'has been approved')][contains(@id, 'img')]")
    public WebElement EmailIconApproved;

    @FindBy(xpath = "//a[contains(@title, 'is now complete')][contains(@id, 'img')]")
    public List<WebElement> CompletedEmailForAllParticipants;

    @FindBy(xpath = "//a[contains(@title, 'is now registered')][contains(@id, 'img')]")
    public List<WebElement> RegisteredEmailForAllParticipants;

    @FindBy(xpath = "//button[contains(text(), 'Assign To Me')][@title='Begin']")
    public WebElement AssignToMeButton;

    @FindBy(xpath = "(//span[contains(text(), 'Review')]//following::button[text()='Begin'])[2]")
    public WebElement BeginButtonDefault;

    @FindBy(xpath = "//textarea[contains(@name, 'ReviewFeedback')]")
    public WebElement ReturnCommentTextArea;

    @FindBy(xpath = "//label[text()='Return']")
    public WebElement Return;

    @FindBy(xpath = "//label[text()='Approve']")
    public WebElement Approve;

    @FindBy(xpath = "//label[text()='Agree']")
    public WebElement Agree;

    @FindBy(xpath = "//label[text()='Disagree']")
    public WebElement Disagree;

    @FindBy(xpath = "//button[text()='Continue']")
    public WebElement SubmitButton;

    @FindBy(xpath = "(//span[text()='UMR:']//following::span)[2]")
    public WebElement WorkFlowStatus;

    @FindBy(xpath = "(//td[contains(text(), 'Subject')]//following::td)[1]")
    public WebElement ReviewTaskEmailSubject;

    @FindBy(xpath = "(//td[contains(text(), 'To:')]//following::td)[1]")
    public WebElement ReviewTaskEmailTO;

    @FindBy(xpath = "//a[contains(@name, 'AssignmentsOperatorAssignedTo')]")
    public List<WebElement> AssignedTo;

    @FindBy(xpath = "(//button[contains(@name, 'AssignmentsActions')][text()='Begin'])[2]")
    public WebElement BeginReviewTask;

    @FindBy(xpath = "//a[@class='Breadcrumbs']")
    public WebElement GoToContractTasks;

    @FindBy(xpath = "(//a[contains(text(), 'Open')])[1]")
    public WebElement FirstReviewTask;

    @FindBy(xpath = "(//a[contains(text(), 'Open')])[2]")
    public WebElement SecondReviewTask;

    @FindBy(xpath = "//button[contains(text(), 'Yes')]")
    public WebElement YesContinueButton;

    @FindBy(xpath = "//button[contains(text(), 'No')]")
    public WebElement NoWaitButton;

    @FindBy(xpath = "(//div[@readonly='true']//following::div[@class='custom_text'])[1]")
    public WebElement RetractErrorMessage;

    @FindBy(xpath = "//button[text()='Get next']")
    public WebElement GetNextButton;

    @FindBy(xpath = "(//span[contains(text(), 'Complete (approved)')])[3]")
    public WebElement ReviewStatusComplete;

    @FindBy(xpath = "(//span[contains(text(), 'Under review (contract creator updating)')])[3]")
    public WebElement ReviewStatusReturn;

    @FindBy(xpath = "(//span[contains(text(), 'Complete (returned)')])[3]")
    public WebElement AgreeReviewReturnStatus;

    @FindBy(xpath = "//button[contains(@name, 'ModalTemplateForDataCapture')][text()='OK']")
    public WebElement RetractPopupOK;

    @FindBy(xpath = "//span[text()='Close']")
    public WebElement Close;

    @FindBy(xpath = "//button[contains(text(), 'Create Endorsement')]")
    public WebElement CreateEndorsement;

    @FindBy(xpath = "((//span[text()='default@Lloyds'])[1]//following::button[text()='Begin'])[1]")
    public WebElement DefaultBeginButton;

    @FindBy(xpath = "//button[contains(text(), 'Assign To Me')]")
    public WebElement DefaultAssignToMeButton;

    @FindBy(xpath = "//a[contains(@class, 'tablist-menu-nav')][contains(@data-menuid, 'AddInfo')]")
    public WebElement ExpandMenu;

    @FindBy(xpath = "//span[text()='Audit']")
    public WebElement AuditOption;

    @FindBy(xpath = "(//span[contains(text(), 'Review (R-')])[2]")
    public WebElement ReviewTaskToDisagree;

    @FindBy(xpath = "//button[contains(@name,'CaseActionAreaButtons')][contains(text(),'Cancel')]")
    public WebElement ReviewCancel;

    @FindBy(xpath = "//span[contains(text(), 'Contract Details')]")
    public WebElement LloydsContractDetailsHeader;

    @FindBy(xpath = "(//div[contains(@data-click, 'showActiveTabListMenu')])[1]")
    public WebElement DownMenuIcon;

    @FindBy(xpath = "//span[contains(text(), 'Document Library')]")
    public WebElement DocumentLibraryLink;

    @FindBy(xpath = "//a[contains(@name, 'DocumentLibraryInReviewHarness')]")
    public WebElement DocumentLinkReviewHarness;
    
}
