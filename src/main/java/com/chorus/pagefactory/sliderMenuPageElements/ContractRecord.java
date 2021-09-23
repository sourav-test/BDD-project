package com.chorus.pagefactory.sliderMenuPageElements;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContractRecord {

    @FindBy(xpath = "//iframe[contains(@title, 'Record')]")
    public WebElement PegaRecordFrame;

    @FindBy(xpath = "//div[contains(@aria-label, 'Actions')]")
    public WebElement ActionsTab;

    @FindBy(xpath = "//div[contains(@aria-label, 'Contract history')]")
    public WebElement AssociatedTasksTab;

    @FindBy(xpath = "//div[contains(@aria-label, 'Linked Contracts')]")
    public WebElement LinkedContractsTab;

    @FindBy(xpath = "//button[contains(@name, 'LinkedContracts')]")
    public WebElement LinkContractButton;

    @FindBy(xpath = "//input[contains(@name, 'SearchInput')]")
    public WebElement SearchContractToLink;

    @FindBy(xpath = "//button[contains(@name, 'LinkContractManual')][text()='Add']")
    public WebElement AddContract;

    @FindBy(xpath = "//a[contains(@name, 'LinkContractManual')]")
    public WebElement LinkContractDeleteIcon;

    @FindBy(xpath = "//button[contains(@name, 'LinkContractManual')][text()='Link Contract']")
    public WebElement LinktheContract;

    @FindBy(xpath = "//button[contains(@title, 'close modal')]")
    public WebElement CloseLinkContractPopUp;

    @FindBy(xpath = "//a[contains(@name, 'LinkedContracts')][@class='iconDelete']")
    public WebElement LinkedContracts;

    @FindBy(xpath = "//button[contains(@name, 'DelinkContract')][text()='Yes']")
    public WebElement DelinkContractYesButton;

    @FindBy(xpath = "//a[contains(@name, 'LinkedContracts')][text()='Renewed To']")
    public WebElement LinkTypeRenewedTo;

    @FindBy(xpath = "//a[contains(@name, 'LinkedContracts')][text()='Renewed From']")
    public WebElement LinkTypeRenewedFrom;

    @FindBy(xpath = "//div[contains(text(), 'The Unique ID entered cannot be found')]")
    public WebElement ContractLinkInvalidContractError;

    @FindBy(xpath = "//div[contains(text(), 'Create endorsement')]")
    public WebElement CreateEndorsementButton;

    @FindBy(xpath = "//div[contains(text(), 'Duplicate')]")
    public WebElement DuplicateButton;

    @FindBy(xpath = "//div[contains(text(), 'Terminate')]")
    public WebElement TerminateButton;

    @FindBy(xpath = "//div[text()= 'Renew']")
    public WebElement RenewButton;

    @FindBy(xpath = "//div[contains(text(), 'Re-sign contract')]")
    public WebElement ResignButton;

    @FindBy(xpath = "(//div[text()='Task']//following::a)[1]")
    public WebElement TaskFilter;

    @FindBy(xpath = "(//div[text()='Status']//following::a)[1]")
    public WebElement StatusFilter;

    @FindBy(xpath = "//input[contains(@name, 'FilterCriteria')][contains(@name, 'SearchText')]")
    public WebElement RecordUIFilterText;

    @FindBy(xpath = "//td[contains(@data-attribute-name, 'Task')]")
    public List<WebElement> TaskList;

    @FindBy(xpath = "(//input[@type='checkbox'][contains(@name, 'ContractSearchData')])[1]")
    public WebElement ComponentsCopyCheckbox;

    @FindBy(xpath = "//select[contains(@name, 'TerminationType')]")
    public WebElement TerminationType;

    @FindBy(xpath = "//textarea[contains(@name, 'TerminationReason')]")
    public WebElement TerminationReason;

    @FindBy(xpath = "//input[contains(@name, 'TerminationservedDate')]")
    public WebElement TerminationServedDate;

    @FindBy(xpath = "(//input[contains(@name, 'TerminationservedDate')]//following::img[contains(@name, 'Calendar')])[1]")
    public WebElement TerminationServedDateCalendar;

    @FindBy(xpath = "//select[contains(@name, 'TerminationInitiator')]")
    public WebElement TerminationInitiator;

    @FindBy(xpath = "//label[contains(text(), 'Yes')]")
    public WebElement TerminationNotifiedYes;

    @FindBy(xpath = "//label[contains(text(), 'No')]")
    public WebElement TerminationNotifiedNo;

    @FindBy(xpath = "//label[contains(text(), 'Termination effective date')]")
    public WebElement TerminationEndorsementEffectiveDateLabel;

    @FindBy(xpath = "//input[contains(@name, 'EndorsementEffectiveDate')]")
    public WebElement TerminationEndorsementEffectiveDate;

    @FindBy(xpath = "(//input[contains(@name, 'EndorsementEffectiveDate')]//following::img[contains(@name, 'Calendar')])[1]")
    public WebElement TerminationEffectiveDateCalendar;

    @FindBy(xpath = "//div[contains(text(), 'Termination effective date cannot be earlier than the contract inception date')]")
    public WebElement TerminationEffectiveDatePriorInceptionDateError;

    @FindBy(xpath = "//div[contains(text(), 'Termination effective date cannot be later than contract expiry date')]")
    public WebElement TerminationEffectiveDateLaterExpiryDateError;

    @FindBy(xpath = "//div[contains(text(), 're-signed.')]")
    public WebElement ResignEndorsementErrorMessage;

    @FindBy(xpath = "//div[contains(text(), 'date is not valid as this multiyear contract has not been re-signed')]")
    public WebElement ResignEndorsementErrorMessageCorequestions;

    @FindBy(xpath = "//input[contains(@name, 'EndorsementEffectiveDate')]")
    public WebElement ResignConfirmationDate;

    @FindBy(xpath = "//label[contains(text(), 'Re-sign')]")
    public WebElement ResignConfirmationDateLabel;

    @FindBy(xpath = "//span[contains(@class, 'on_time_display_text')][contains(text(), 'Not Taken Up (NTU)')]")
    public WebElement RecordStatusNotTakenUp;

    @FindBy(xpath = "//span[contains(@class, 'on_time_display_text')][contains(text(), 'Terminated')]")
    public WebElement RecordStatusTerminated;

    @FindBy(xpath = "//span[contains(@class, 'on_time_display_text')][contains(text(), 'Active')]")
    public WebElement RecordStatusActive;

    @FindBy(xpath = "//span[contains(@class, 'on_time_display_text')][contains(text(), 'Registered')]")
    public WebElement RecordStatusRegistered;

    @FindBy(xpath = "(//a[contains(text(), 'Endorsement')]//following::span[contains(text(),'Under review')])[1]")
    public WebElement AssociatedTaskEndorsementCompleteStatus;
    
}
