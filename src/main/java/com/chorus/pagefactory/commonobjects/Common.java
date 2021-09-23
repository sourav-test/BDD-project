package com.chorus.pagefactory.commonobjects;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Factory Class
 * Common Objects
 */


public class Common {

    
    /**
     * Common Buttons
     */
    
    @FindBy(xpath = "//button[text()='Continue']")
    public WebElement ContinueButton;

    @FindBy(xpath = "//button[text()='Finish']")
    public WebElement FinishButton;

    @FindBy(xpath = "//button[text()='Next   ']")
    public WebElement NextButton;

    @FindBy(xpath = "//button[text()='Save'][@class='pzhc pzbutton']")
    public WebElement SaveButton;

    @FindBy(xpath = "//button[text()='Edit']")
    public WebElement EditButton;

    @FindBy(xpath = "//button[contains(text(), 'Back')]")
    public WebElement BackButton;

    @FindBy(xpath = "//button[contains(text(), 'Confirm')]")
    public WebElement ConfirmButton;

    @FindBy(xpath = "//button[text()='Cancel'][@class='pzhc pzbutton']")
    public WebElement CancelButton;

    @FindBy(xpath = "(//button[contains(text(),'Begin')])[1]")
    public WebElement BeginButton;

    @FindBy(xpath = "(//button[contains(text(),'Begin')])")
    public List<WebElement> BeginButtonList;

    @FindBy(xpath = "//button[@title='OK']")
    public WebElement OKButton;
    
    @FindBy(xpath = "//button[text()='Submit For Review']")
    public WebElement SubmitForReviewButton;

    @FindBy(xpath = "//button[contains(text(), 'Submit')]")
    public WebElement SubmitButton;

    @FindBy(xpath = "//button[text()='Yes']")
    public WebElement DeletePopupYes;

    @FindBy(xpath = "//button[contains(text(),'No')]")
    public WebElement DeletePopupNo;

    /**
     * Common Header Elements
     */

    @FindBy(xpath = "//span[@class='on_time_display_text'][contains(text(), 'DA')]")
    public WebElement ContractID;

    @FindBy(xpath = "(//span[text() = 'UMR:']//following::span)[1]")
    public WebElement UMR;

    @FindBy(xpath = "(//span[text()='UMR:']//following::span)[4]")
    public WebElement Workstatus;

    @FindBy(xpath = "(//span[contains(text(), 'Not')])[5]")
    public WebElement WorkStatusNTU;

    @FindBy(xpath = "(//span[contains(text(), 'Part VII:')]//following::span)[4]")
    public WebElement WorkflowStatusComplete;

    @FindBy(xpath = "//div[@string_type='label'][contains(text(), 'routed')]")
    public WebElement ContractSubmittedForReviewMessage;

    @FindBy(xpath = "//div[@string_type='label'][contains(text(), 'EndConfirmationNote')]")
    public WebElement ReviewTaskCompleteMessage;
    
    /**
     * Common Elements For Notification
     */
    
    @FindBy(xpath = "(//i[@class='pi pi-bell pi-white'])[1]//following::button[@tabindex='0']")
    //@FindBy(xpath = "((//i[@class='pi pi-bell pi-white'])[1]//following::i[@tabindex='0'])[1]")
    public WebElement ProfileIcon;

    @FindBy(xpath = "//span[text()='Notification preferences']")
    public WebElement NotificationPreferencesLink;

    @FindBy(xpath = "//span[@data-ctl='Checkbox']")
    public WebElement RecieveNotificationCheckbox;

    @FindBy(xpath = "//h3[text()='Create Registration']")
    public WebElement ContractNotifOptions;

    @FindBy(xpath = "((//label[contains(text(),'past inception date')])[2]//following::input[@type='checkbox'])[1]")
    public WebElement ContractPastInceptionDateSysNotif;

    @FindBy(xpath = "((//label[contains(text(),'task is assigned')])[2]//following::input[@type='checkbox'])[1]")
    public WebElement ContractTaskAssignedSysNotif;

    @FindBy(xpath = "((//label[contains(text(),'task is Re-assigned')])[2]//following::input[@type='checkbox'])[1]")
    public WebElement ContractTaskReAssignedSysNotif;

    @FindBy(xpath = "((//label[contains(text(),'contract is registered')])[2]//following::input[@type='checkbox'])[1]")
    public WebElement ContractContractRegisteredSysNotif;

    @FindBy(xpath = "((//label[contains(text(),'contract review task is retracted')])[2]//following::input[@type='checkbox'])[1]")
    public WebElement ContractRetractSysNotif;

    @FindBy(xpath = "//h3[text()='Review']") 
    public WebElement ReviewNotifOptions;

    @FindBy(xpath = "((//label[contains(text(),'returned past inception')])[2]//following::input[@type='checkbox'])[1]")
    public WebElement ReviewPastInceptionDateSysNotif;

    @FindBy(xpath = "((//label[contains(text(),'task is Re-assigned')])[6]//following::input[@type='checkbox'])[1]")
    public WebElement ReviewTaskReAssignedSysNotif;

    @FindBy(xpath = "((//label[contains(text(),'review task is approved')])[2]//following::input[@type='checkbox'])[1]")
    public WebElement ReviewTaskApprovedSysNotif;

    @FindBy(xpath = "((//label[contains(text(),'review task is received')])[2]//following::input[@type='checkbox'])[1]")
    public WebElement ReviewTaskReceivedSysNotif;

    @FindBy(xpath = "((//label[contains(text(),'contract review task is retracted')])[4]//following::input[@type='checkbox'])[1]")
    public WebElement ReviewRetractSysNotif;

    @FindBy(xpath = "((//label[contains(text(),'review task is returned')])[2]//following::input[@type='checkbox'])[1]")
    public WebElement ReviewTaskReturnedSysNotif;

    @FindBy(xpath = "//h3[text()='Endorsement']")
    public WebElement EndorsementNotifOptions;

    @FindBy(xpath = "((//label[contains(text(),'past inception date')])[4]//following::input[@type='checkbox'])[1]")
    public WebElement EndorsementPastInceptionDateSysNotif;

    @FindBy(xpath = "((//label[contains(text(),'task is assigned')])[4]//following::input[@type='checkbox'])[1]")
    public WebElement EndorsementTaskAssignedSysNotif;

    @FindBy(xpath = "((//label[contains(text(),'task is Re-assigned')])[8]//following::input[@type='checkbox'])[1]")
    public WebElement EndorsementTaskReAssignedSysNotif;

    @FindBy(xpath = "((//label[contains(text(),'contract is registered')])[4]//following::input[@type='checkbox'])[1]")
    public WebElement EndorsementRegisteredSysNotif;

    @FindBy(xpath = "((//label[contains(text(),'contract review task is retracted')])[6]//following::input[@type='checkbox'])[1]")
    public WebElement EndorsementRetractSysNotif;

    @FindBy(xpath = "//div[contains(@node_name, 'DesktopNotificationGadget')]")
    public WebElement NotificationIcon;

    @FindBy(xpath = "//div[contains(@class, 'notification-Message')]//following::div[@class='field-item']")
    public List<WebElement> NotificationList;

    @FindBy(xpath = "//h2[text()='Notifications']")
    public WebElement NotificationLabel;
    
    /**
     * Common Actions Menu
     */
    
    @FindBy(xpath = "//button[text()='Actions']")
    public WebElement ActionsDropdown;

    @FindBy(xpath = "//span[text()='Close']")
    public WebElement ActionsClose;

    @FindBy(xpath = "//span[text()='Not Taken Up']")
    public WebElement ActionsNotTakenUp;

    @FindBy(xpath = "//span[contains(text(),'Assign')]")
    public WebElement ActionsAssign;

    /**
     * Common Element Share Visibility For Draft Wording Checkbox
     */

    @FindBy(xpath = "//input[@type='checkbox'][contains(@name, 'IsShared')]")
    public WebElement ShareChkBox;
    
    /**
     * Common Elements For Participants Table - Review Harness Page
     */

    @FindBy(xpath = "(//button[contains(@title,'Manage User groups')]//following::i)[1]")
    public WebElement ManageShare;

    @FindBy(xpath = "//label[text()='Select a User Group']//following::select")
    public WebElement SelectUserGrp;

    @FindBy(xpath = "//a[contains(@data-click,'AddUserGroup')]")
    public WebElement AddUserGrp;

    @FindBy(xpath = "//button[contains(text(), 'Submit')]")
    public WebElement UserGrpSubmit;
    
    
    /**
     * Common Elements Document Upload Modal
     */
    
    @FindBy(xpath = "(//input[@type='file'])[1]")
    public WebElement UploadPath;
    
    @FindBy(xpath = "//button[contains(@name, 'UploadDocuments')]")
    public WebElement UploadButton;

    @FindBy(xpath = "//span[contains(@id, 'modaldialog_hd_title')][contains(text(), 'Attach file')]")
    public WebElement AttachFileHeader;

    @FindBy(xpath = "//b[contains(text(), 'Your document(s) has been saved')]")
    public WebElement DocumentSavedMessage;

    @FindBy(xpath = "//div[@role='application']")
    public WebElement SelectFiles;

    @FindBy(xpath = "//select[contains(@name, 'DropFileUpload')]")
    public WebElement SelectTag;

    @FindBy(xpath = "//select[contains(@name, 'Classification')]")
    public WebElement Classification;

    @FindBy(xpath = "//button[contains(@title, 'Attach')]")
    public WebElement AttachButton;

    @FindBy(xpath = "//button[contains(text(),'Cancel')][@class='buttonTdButton']")
    public WebElement DocumentUploadCancelButton;

    /**
     * Common Elements Non Schedule Tab
     */

    @FindBy(xpath = "//input[contains(@name, 'OrderHereon1stPercentage')]")
    public WebElement HereOnFirstPercentage;

    @FindBy(xpath = "//input[contains(@name, 'OrderHereon2ndPercentage')]")
    public WebElement HereOnSecondPercentage;

    /**
     * Common Elements Actions Tab
     */

    @FindBy(xpath = "//span[text()='Wording']//preceding::input[@type='checkbox'][contains(@name, 'DropdownList')]")
    public WebElement WordingCheckbox;

    @FindBy(xpath = "(//span[text()='Schedule']//preceding::input[@type='checkbox'][contains(@name, 'DropdownList')])[2]")
    public WebElement ScheduleCheckbox;

    @FindBy(xpath = "(//span[text()='Non-schedule']//preceding::input[@type='checkbox'][contains(@name, 'DropdownList')])[3]")
    public WebElement NonScheduleCheckbox;

    @FindBy(xpath = "//button[contains(@name, 'GenerateButtonForDocuments')]")
    public WebElement GenerateButton;

    @FindBy(xpath = "(//input[@type='checkbox'][contains(@name, 'Selected')])[1]")
    public WebElement MRCEAllCheckbox;

    @FindBy(xpath = "//button[contains(@name, 'GenerateMRCE')]")
    public WebElement GenerateMRCEButton;

    /**
     * Common Elements For Contract Assign 
     */

    @FindBy(xpath = "//label[contains(text(),'Individual')]")
    public  WebElement AssignIndividual;

    @FindBy(xpath = "//label[contains(text(),'Team')]")
    public  WebElement AssignTeam;

    @FindBy(xpath = "//input[contains(@name,'ReassignOperatorName')]")
    public  WebElement AssignIndividualSearch;

    @FindBy(xpath = "//input[contains(@name,'ReassignWorkGroupName')]")
    public  WebElement AssignTeamSearch;

    @FindBy(xpath = "//button[contains(text(),'Assign Task')]")
    public WebElement AssignTask;

    @FindBy(xpath = "//button[text()='Assign']")
    public WebElement Assign;

    @FindBy(xpath = "//input[@class='checkbox chkBxCtl ']")
    public  WebElement MyTaskToggled;

    @FindBy(xpath = "//input[@class='checkbox chkBxCtl '][@checked]")
    public WebElement MyTeamTaskToggled;

    @FindBy(xpath = "//button[contains(@name,'TransferAssignment')][text()='OK']")
    public WebElement AssignPopupOK;

    @FindBy(xpath = "//button[contains(@name,'BulkProcessing')][text()='Cancel']")
    public WebElement AssignPopupCancel;

    @FindBy(xpath = "//iframe[@title='Bulk Action']")
    public WebElement PegaAssignFrame;

    @FindBy(xpath = "//td[contains(@class, 'autocomplete')]")
    public List<WebElement> OperatorList;

    /**
     * Common Elements For Dashboard (Applicable To My Tasks,
     * My Teams Tasks, Completed Tasks, Ongoing Tasks, Search Contracts)
     */

    @FindBy(xpath = "//button[@title='Refresh List']")
    public WebElement RefreshListButton;
    
    @FindBy(xpath = "//div[text()='UMR']")
    public WebElement UMRColumnHeader;

    @FindBy(xpath = "//div[text()='Unique Identifier']")
    public WebElement UniqueIdentiferColumnHeader;

    @FindBy(xpath = "//div[text()='Contract Type']")
    public WebElement ContractTypeColumnHeader;

    @FindBy(xpath = "//div[text()='Broker']")
    public WebElement BrokerColumnHeader;

    @FindBy(xpath = "//div[text()='Effective Date']")
    public WebElement EffectiveDateColumnHeader;

    @FindBy(xpath = "//div[text()='Inception Date']")
    public WebElement InceptionDateColumnHeader;

    @FindBy(xpath = "//div[contains(text(), 'Status')]")
    public WebElement TaskColumnHeader;

    @FindBy(xpath = "//td[contains(@data-attribute-name, 'Status')]")
    public List<WebElement> TaskStatusList;

    @FindBy(xpath = "//td[contains(@data-attribute-name, 'Status')]")
    public WebElement TaskStatus;

    @FindBy(xpath = "//td[@data-attribute-name='Contract Type']")
    public List<WebElement> ContractTypeList;

    @FindBy(xpath = "//td[@data-attribute-name='Broker']")
    public List<WebElement> BrokerList;

    @FindBy(xpath = "//td[@data-attribute-name='Effective Date']")
    public List<WebElement> EffectiveDateList;

    @FindBy(xpath = "//td[@data-attribute-name='Inception Date']")
    public List<WebElement> InceptionDateList;

    @FindBy(xpath = "(//div[text()='UMR']//following::a)[1]")
    public WebElement UMRFilter;

    @FindBy(xpath = "(//div[text()='Unique Identifier']//following::a)[1]")
    public WebElement UniqueIdentifierFilter;

    @FindBy(xpath = "(//div[text()='Task Status']//following::a)[1]")
    public WebElement TaskStatusFilter;

    @FindBy(xpath = "(//div[text()='Assigned to']//following::a)[1]")
    public WebElement AssignedToFilter;

    @FindBy(xpath = "(//div[text()='Broker']//following::a)[1]")
    public WebElement BrokerFilter;

    @FindBy(xpath = "(//div[text()='Contract Type']//following::a)[1]")
    public WebElement ContractTypeFilter;

    @FindBy(xpath = "(//div[text()='Effective']//following::a)[1]")
    public WebElement EffectiveDateFilter;

    @FindBy(xpath = "(//div[text()='Inception Date']//following::a)[1]") 
    public WebElement InceptionDateFilter;

    @FindBy(xpath = "//input[contains(@name, 'FilterCriteria')][contains(@name, 'SearchText')]")
    public WebElement FilterText;
    
    @FindBy(xpath = "(//label[text()='From']//following::input)[1]")
    public WebElement FromField;

    @FindBy(xpath = "(//label[text()='To']//following::input)[1]")
    public WebElement ToField;

    @FindBy(xpath = "//button[text()='Apply']")
    public WebElement ApplyFilter;

    @FindBy(xpath = "//*[text()='Clear Filter']")
    public WebElement ClearFilter;

    @FindBy(xpath = "//span[@title='Expand this row']")
    public WebElement Expand;

    @FindBy(xpath = "//span[contains(@title, 'Collapse')]")
    public WebElement Collapse;

    @FindBy(xpath = "//td[@data-attribute-name='Broker Name']//div//span")
    public WebElement BrokerName;

    @FindBy(xpath = "//td[@data-attribute-name='Broker Number']//div//span")
    public WebElement BrokerNumber;

    @FindBy(xpath = "(//td[contains(@data-attribute-name, 'Lloyd')]//div//span)[2]")
    public WebElement LloydsLead;

    @FindBy(xpath = "(//td[contains(@data-attribute-name, 'Third Party Participant')]//div//span)[2]")
    public WebElement ThirdPartyParticipant;

    @FindBy(xpath = "//*[@sortfield='.EntityID']//span[contains(@title, 'descending order')]")
    public WebElement UniqueIdentifierDescendCheck;

    @FindBy(xpath = "//*[@sortfield='.EntityID']//span[contains(@title, 'ascending order')]")
    public WebElement UniqueIdentifierAscendCheck;

    @FindBy(xpath = "//*[@sortfield='.ContractData.UMR']//span[contains(@title, 'descending order')]")
    public WebElement UMRDescendCheck;

    @FindBy(xpath = "//*[@sortfield='.ContractData.UMR']//span[contains(@title, 'ascending order')]")
    public WebElement UMRAscendCheck;

    @FindBy(xpath = "//*[@sortfield='.ContractData.ReportingBroker']//span[contains(@title, 'descending order')]")
    public WebElement BrokerDescendCheck;

    @FindBy(xpath = "//*[@sortfield='.ContractData.ReportingBroker']//span[contains(@title, 'ascending order')]")
    public WebElement BrokerAscendCheck;

    @FindBy(xpath = "//*[@sortfield='.ContractData.ContractType']//span[contains(@title, 'descending order')]")
    public WebElement ContractTypeDescendCheck;

    @FindBy(xpath = "//*[@sortfield='.ContractData.ContractType']//span[contains(@title, 'ascending order')]")
    public WebElement ContractTypeAscendCheck;

    @FindBy(xpath = "//*[@sortfield='.ContractData.EffectiveStartDate']//span[contains(@title, 'descending order')]")
    public WebElement EffectiveDateDescendCheck;

    @FindBy(xpath = "//*[@sortfield='.ContractData.EffectiveStartDate']//span[contains(@title, 'ascending order')]")
    public WebElement EffectiveDateAscendCheck;

    @FindBy(xpath = "//*[contains(@sortfield, 'Status')]//span[contains(@title, 'ascending order')]")
    public WebElement ContractStatusAscendCheck;

    @FindBy(xpath = "//*[contains(@sortfield, 'Status')]//span[contains(@title, 'descending order')]")
    public WebElement ContractStatusDescendCheck;

    @FindBy(xpath = "//*[@sortfield='.ContractData.InceptionDate']//span[contains(@title, 'ascending order')]")
    public WebElement InceptionDateAscendCheck;

    @FindBy(xpath = "//*[@sortfield='.ContractData.InceptionDate']//span[contains(@title, 'descending order')]")
    public WebElement InceptionDateDescendCheck;

    @FindBy(xpath = "//iframe[contains(@title, 'CON-')]")
    public WebElement PegaTaskFrame;

    @FindBy(xpath = "//button[contains(text(), 'Upload')]")
    public WebElement TerminationEndorsementUpload;

}