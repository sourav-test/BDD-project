package com.chorus.pagefactory.createContractPageElements;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Factory Class
 * Section Details -----  Individual Section
 * 
 */


public class IndividualSectionDetailsPage {


    @FindBy(xpath = "//div[contains(@aria-label, 'INDIVIDUAL SECTION DETAILS')]")
    public WebElement IndividualSectionDetails;

    @FindBy(xpath = "//span[contains(text(), 'overall operation and control cannot be blank')]")
    public WebElement PersonResposibleOverallOperationAndControlError;

    @FindBy(xpath = "//span[contains(text(), 'authorised to bind insurances cannot be blank')]")
    public WebElement PersonResposibleAuthorisedBindInsuranceError;

    @FindBy(xpath = "//span[contains(text(), 'issuance of documents evidencing insurances bound cannot be blank')]")
    public WebElement PersonResposibleOverallIssuanceDocEvidencesError;
    
    @FindBy(xpath = "//span[contains(text(), 'Total capacity must be equal to 100')]")
    public WebElement CapacityPercentageError;

    @FindBy(xpath = "//span[contains(text(), 'does not exist as Contract Lead for any sections')]")
    public WebElement ContractLeadError;

    @FindBy(xpath = "//span[contains(text(), 'cannot be the only Contract Lead')]")
    public WebElement NonLloydsContractLeadError;

    @FindBy(xpath = "//span[contains(text(), 'Reporting and Aggregates Exposure: No underwriter(s) selected')]")
    public WebElement ReportingAggregatesExposureUnderwriterError;

    @FindBy(xpath = "//span[contains(text(), 'Reporting and Aggregates Exposure: No coverholder(s) selected')]")
    public WebElement ReportingAggregatesExposureCoverholderError;

    @FindBy(xpath = "//span[contains(text(), 'Reporting and Aggregates Exposure: No delegated claims administrator(s) selected')]")
    public WebElement ReportingAggregatesExposureDCAError;

    @FindBy(xpath = "//span[contains(text(), 'DCA Contact Email')]")
    public WebElement ClaimsAndComplaintsDCAEmailError;
    
    @FindBy(xpath = "//h2[text()='Validation Error']//following::span[contains(text(),'Coverholder(s) selected do not have claims handling authority')]")
    public WebElement CHAServerSideErrorCH;

    @FindBy(xpath = "//h2[text()='Validation Error']//following::span[contains(text(),'Service Company(s) selected do not have claims handling authority')]")
    public WebElement CHAServerSideErrorSC;

    @FindBy(xpath = "//h2[text()='Validation Error']//following::span[contains(text(),'service company(s) have been added as capacity seeker and capacity lead')]")
    public WebElement CSPServerSideError;

    @FindBy(xpath = "//div[@class='custom_text'][contains(text(), ' Errors exist on Section Details tab')]")
    public WebElement SectionDetailsValidation;

    @FindBy(xpath = "//span[contains(text(), 'There must be at least one original Coverholder remaining on this renewal')]")
    public WebElement OriginalCoverholderRenewalError;

    @FindBy(xpath = "//span[contains(text(), 'At least 1 of the Syndicates you manage must be on this contract')]")
    public WebElement ManagingAgentSyndicateError;

    @FindBy(xpath = "//h2[text()='Validation Error']//following::span[contains(text(),'Your Coverholder organisation needs to be in at least 1 section')]")
    public WebElement CHOrgErrorMsg;

    @FindBy(xpath = "//h2[text()='Validation Error']//following::span[contains(text(),'Your service company needs to be a capacity lead in at least 1 section or a capacity seeker')]")
    public WebElement SCOrgErrorMsg;

    @FindBy(xpath = "//h2[text()='Validation Error']//following::span[contains(text(),'Your Syndicate needs to be a capacity lead in at least 1 section')]")
    public WebElement SyndOrgErrorMsg;

    @FindBy(xpath = "//button[contains(@name, 'EnterSectionDetails')][contains(@data-click, 'Termination')]")
    public WebElement TerminateButton;

    @FindBy(xpath = "//button[contains(text(), 'Terminated Section')]")
    public WebElement CancelTerminateButton;

    @FindBy(xpath = "//a[text()='Add Section']")
    public WebElement AddItem;

    @FindBy(xpath = "//a[text()='Delete']")
    public WebElement DeleteItem;

    @FindBy(xpath = "//span[@class='heading_2'][contains(text(), '00')]")
    public WebElement SectionID;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'Description')]")
    public WebElement SectionDescription;

    @FindBy(xpath = "//td[@data-attribute-name='Sections']")
    public List<WebElement> SectionIDs;

    @FindBy(xpath = "//a[contains(@data-click, 'CopyCurrent')][contains(@data-click, 'SectionInformation')]")
    public WebElement CopySection;

    @FindBy(xpath = "(//a[contains(@data-click, 'CopyCurrent')][contains(@data-click, 'SectionInformation')])[2]")
    public WebElement CopySectionEndorsement;

    @FindBy(xpath = "//button[contains(@name, 'ModalTemplateForDataCapture')][text()='OK']")       // Need to Create a new class
    public WebElement SubmitForReviewOKButton;

    @FindBy(xpath = "//h2[text()='Validation Error']//following::span[contains(text(),'Refresh Participants Data')]")
    public WebElement RefreshParticipantDataErrorMessage;

    @FindBy(xpath = "//button[contains(@data-click, 'RefreshParticipantData')]")
    public WebElement RefreshParticipantDataButton;

    @FindBy(xpath = "//span[contains(text(), 'none of the capacity seekers in this section has approval for this Generic Class of Business')]")
    public WebElement GenericCOBApprovalCapacitySeekerErrorMessage;

    @FindBy(xpath = "//span[contains(text(), 'Platform cannot be blank')]")
    public WebElement PlatformBlankErrorMessage;

    @FindBy(xpath = "//div[contains(text(), ' Errors exist on Agreement Template tab')]")
    public WebElement EndorsementError;

    @FindBy(xpath = "//span[text()='There must be at least one London section and one Brussels section']")
    public WebElement TwinContractBrusslesLeadErrorSectionDetails;

    
    /**
     *      Accordion ------ Cover Holder / Service Company Details
     */
        
    
    @FindBy(xpath = "(//div[contains(@aria-label, 'Coverholder Details')])[2]")
    public WebElement CoverholderDetailsTab;

    @FindBy(xpath = "(//div[contains(@aria-label, 'Service Company Details')])[2]")
    public WebElement ServiceCompanyTab;

    @FindBy(xpath = "(//input[contains(@name, 'CoverholderSearchCriteria')])[2]")
    public WebElement CoverholderField;

    @FindBy(xpath = "(//input[contains(@name, 'ServiceCompanySearchCriteria')])[2]")
    public WebElement ServiceCompanyField;

    @FindBy(xpath = "(//label[contains(text(), 'Name or PIN')])[2]")
    public WebElement SearchCoverholderServiceCompanyLabel;

    @FindBy(xpath = "//button[contains(@name, 'SearchButtonCoverHolderIndividual')]")
    public WebElement SearchCoverHolderButton;

    @FindBy(xpath = "//span[@id='modaldialog_hd_title'][contains(text(), 'Search')]")
    public WebElement SearchResults;

    @FindBy(xpath = "//button[@alt='Add']")
    public WebElement AddButton;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'PropertyValue')]")
    public WebElement TradingNameField;

    @FindBy(xpath = "(//button[@type='button'][contains(@name, 'TradingNames')])[2]")
    public WebElement SearchTradingNamesButton;

    @FindBy(xpath = "//button[@type='button'][contains(@name, 'ContractSectionList')][contains(@name, 'CoverholderList')]")
    public WebElement SearchTradingNamesButtonCoverholder;

    @FindBy(xpath = "//button[@type='button'][contains(@name, 'ContractSectionList')][contains(@name, 'ServiceCompanyList')]")
    public WebElement SearchTradingNamesButtonServiceCompany;

    @FindBy(xpath = "//button[contains(@name, 'SearchButtonForScIndividual')]")
    public WebElement SearchServiceCompanyButton;

    @FindBy(xpath = "//a[contains(@name, 'CoverholderForIndividualSection')][@class='iconDelete']")
    public WebElement CoverholderDeleteLink;

    @FindBy(xpath = "//a[contains(@name, 'ServiceCompanyForIndividualSection')][@class='iconDelete']")
    public WebElement ServiceCompanyDeleteLink;

    /**
     *      Accordion ------ Persons Responsible for Operation and Control
     */

    @FindBy(xpath = "(//div[contains(@aria-label, 'Operation and Control')])[2]")
    public WebElement PersonResponsibleTab;

    @FindBy(xpath = "(//input[contains(@name, 'ContractSectionList')][contains(@name, 'FirstName')])[1]")
    public WebElement PersonResponsibleFirstName;

    @FindBy(xpath = "(//input[contains(@name, 'FirstName')])[2]")
    public WebElement PersonResponsibleFirstNameServiceCompany;

    @FindBy(xpath = "(//input[contains(@name, 'List')][contains(@name, 'FirstName')])[1]")
    public WebElement PersonResponsibleLinkedFirstName;

    @FindBy(xpath = "(//input[contains(@name, 'ContractSectionList')][contains(@name, 'SurName')])[1]")
    public WebElement PersonResponsibleSurName;

    @FindBy(xpath = "(//input[contains(@name, 'List')][contains(@name, 'SurName')])[1]")
    public WebElement PersonResponsibleLinkedSurName;

    @FindBy(xpath = "(//input[contains(@name, 'ContractSectionList')][contains(@name, 'Email')])[1]")
    public WebElement PersonResponsibleEmail;

    @FindBy(xpath = "(//input[contains(@name, 'Email')])[2]")  
    public WebElement PersonResponsibleEmailServiceCompany;

    @FindBy(xpath = "(//input[contains(@name, 'List')][contains(@name, 'Email')])[1]")
    public WebElement PersonResponsibleLinkedEmail;
    
    @FindBy(xpath = "(//button[contains(@name, 'ContractSectionList')][contains(@name, 'EmailButton')])[1]")    
    public WebElement AddPersonResponsible;

    @FindBy(xpath = "(//button[contains(@name, 'List')][contains(@name, 'EmailButton')])[1]")
    public WebElement AddPersonResponsibleLinked;

    @FindBy(xpath = "(//a[@data-ctl='Link'][contains(@name, 'OperationAndControlDetails')])[1]")
    public WebElement CopyNamesBindInsurance;

    @FindBy(xpath = "(//a[@data-ctl='Link'][contains(@name, 'OperationAndControlDetails')])[2]")
    public WebElement CopyNamesInsurancesBound;

    @FindBy(xpath = "(//td[@data-attribute-name='Surname']//following::a[@title='Delete this row  '])[1]")
    public WebElement DeleteAddedName;

    @FindBy(xpath = "(//td[@data-attribute-name='Surname']//following::a[@title='Delete this row  '])[2]")
    public WebElement DeleteCopiedName;

    @FindBy(xpath = "(//td[@data-attribute-name='Surname']//following::a[@title='Delete this row  '])[3]")
    public WebElement DeleteInsurancesBoundCopiedName;

    @FindBy(xpath = "(//input[@type='checkbox'][contains(@name, 'CheckCoverholder')])[2]")
    public WebElement EachCoverholderCheckbox;

    /**
     *      Accordion ------ Authorised Classes  of Business And Coverages
     */
    
    @FindBy(xpath = "(//div[contains(@aria-label, 'Authorised Class')])")
    public WebElement AuthorisedClassBusinessCoverageTab;

    @FindBy(xpath = "//select[contains(@name, 'DistributionMethod')]")
    public WebElement DistributionMethod;

    @FindBy(xpath = "//select[contains(@name, 'PremiumLevelOfAuthority')]")
    public WebElement PremiumLevelOfAuthority;

    @FindBy(xpath = "//div[contains(text(), 'At least one coverholder/service company selected is not approved')]")
    public WebElement PremiumLevelOfAuthorityFieldError;

    @FindBy(xpath = "//select[contains(@name, 'DeductibleOrExcess')]")
    public WebElement DeductiblesOrExcess;

    @FindBy(xpath = "//input[contains(@name, 'IsDeductibles')][@type='checkbox']")
    public WebElement IsDeductible;

    @FindBy(xpath = "//input[contains(@name, 'ClassOfBusinessSearchCriteria')]")
    public WebElement ClassOfBusinessSearchCriteria;

    @FindBy(xpath = "//button[contains(@name, 'SearchClassOfBusiness')]")
    public WebElement ClassOfBusinessSearchButton;

    @FindBy(xpath = "//span[contains(@id, 'modaldialog_hd_title')][contains(text(), 'Class Of Business')]")
    public WebElement ClassOfBusinessHeader;

    @FindBy(xpath = "(//a[@class='iconDelete'][contains(@name, 'ClassOfBusinessList')])[1]")
    public WebElement HighLevelClassOfBusinessDeleteIcon;

    @FindBy(xpath = "//h2[contains(text(), 'High level Class of Business')]")
    public WebElement ExpandHighLevelClassofBusiness;

    @FindBy(xpath = "//h2[contains(text(), 'Generic Class of Business')]")
    public WebElement ExpandGenericClassofBusiness;

    @FindBy(xpath = "//a[@class='iconDelete'][contains(@name, 'HighLevelCOB')]")
    public WebElement DeleteIconCOB;

    @FindBy(xpath = "//input[contains(@name, 'RegulatoryClientClassification')]")
    public WebElement RegulatoryClientClassification;

    @FindBy(xpath = "//td[contains(@class, 'autocomplete')]")
    public List<WebElement> RegulatoryClientClassificationList;

    @FindBy(xpath = "//a[@class='iconDelete'][contains(@name, 'RegulatoryClientClassification')]")
    public WebElement DeleteIconRegulatoryClient;

    @FindBy(xpath = "(//input[contains(@name, 'MinimumLimitsForCOBDetails')][contains(@name, 'CurrencyCode')])[1]")
    public WebElement HighLevelClassOfBusinessCurrencyCode;

    @FindBy(xpath = "(//input[contains(@name, 'MinimumLimitsForCOBDetails')][contains(@name, 'LimitCurrencyInt')])[1]")
    public WebElement HighLevelClassOfBusinessMaxLimit;

    @FindBy(xpath = "(//select[contains(@name, 'MinimumLimitsForCOBDetails')][contains(@name, 'LimitQualifier')])[1]")
    public WebElement HighLevelClassOfBusinessLimitQualifier;

    @FindBy(xpath = "(//button[contains(@name, 'LimitQualifier')][text()='Add'])[1]")
    public WebElement MaximumLimitLiabilityAddButton;

    @FindBy(xpath = "(//a[@class='iconDelete'][contains(@name, 'LimitList')])[1]")
    public WebElement MaximumLimitLiabilityDelete;

    @FindBy(xpath = "(//input[contains(@name, 'DeductiblesForCOBDetails')][contains(@name, 'LimitCurrencyInt')])[1]")
    public WebElement DeductiblesAndExcessMaxLimit;

    @FindBy(xpath = "(//select[contains(@name, 'DeductiblesForCOBDetails')][contains(@name, 'LimitQualifier')])[1]")
    public WebElement DeductiblesAndExcessLimitQualifier;

    @FindBy(xpath = "(//button[contains(@name, 'LimitQualifierForDeductibles')][text()='Add'])[1]")
    public WebElement MaximumLimitDeductiblesAndExcessAddButton;
    
    @FindBy(xpath = "//select[contains(@name, 'InsuranceReinsurance')]")
    public WebElement InsuranceOrReInsurance;

    @FindBy(xpath = "//input[contains(@name, 'GenericClassOfBusiness')][contains(@name, 'RiskCode')]")
    public WebElement AddRiskCode;

    @FindBy(xpath = "//td[contains(@class, 'autocomplete')]")
    public List<WebElement> RiskCodeList;

    @FindBy(xpath = "//a[contains(@name, 'RiskCodeList')]")
    public WebElement DeleteIconRiskCode;

    @FindBy(xpath = "//span[contains(text(), 'This risk code is not generally associated')]")
    public WebElement RiskCodeWarning;
    
    @FindBy(xpath = "(//a[@class='iconDelete'][contains(@name, 'GenericClassOfBusinessList')])[1]")
    public WebElement GenericClassOfBusinessDeleteIcon;
    
    @FindBy(xpath = "(//input[contains(@name, 'GenericClassOfBusiness')][contains(@name, 'CurrencyCode')])[1]")
    public WebElement GenericClassOfBusinessCurrencyCode;

    @FindBy(xpath = "(//input[contains(@name, 'GenericClassOfBusiness')][contains(@name, 'LimitCurrencyInt')])[1]")
    public WebElement GenericClassOfBusinessMaxLimit;

    @FindBy(xpath = "(//select[contains(@name, 'GenericClassOfBusiness')][contains(@name, 'LimitQualifier')])[1]")
    public WebElement GenericClassOfBusinessLimitQualifier;

    @FindBy(xpath = "(//button[contains(@name, 'LimitQualifier')][text()='Add'])[2]")
    public WebElement MaximumLimitLiabilityGenericCOBAddButton;

    @FindBy(xpath = "(//a[@class='iconDelete'][contains(@name, 'GenericClassOfBusiness')][contains(@name, 'LimitList')])[1]")
    public WebElement MaximumLimitLiabilityGenericCOBDelete;

    @FindBy(xpath = "//input[contains(@name, 'PerilSelection')]")
    public WebElement AddPeril;

    @FindBy(xpath = "//td[contains(@class, 'autocomplete')]")
    public List<WebElement> PerilList;

    @FindBy(xpath = "//input[contains(@name, 'PerilDetails')][contains(@name, 'CurrencyCode')]")
    public WebElement PerilDetailsCurrencyCode;

    @FindBy(xpath = "//input[contains(@name, 'PerilDetails')][contains(@name, 'LimitCurrencyInt')]")
    public WebElement PerilDetailsMaxLimit;

    @FindBy(xpath = "//select[contains(@name, 'PerilDetails')][contains(@name, 'LimitQualifier')]")
    public WebElement PerilDetailsLimitQualifier;

    @FindBy(xpath = "(//button[contains(@name, 'LimitQualifier')][text()='Add'])[3]")
    public WebElement PerilDetailsAddButton;

    @FindBy(xpath = "//input[contains(@name, 'LossContingencySearchCriteria')]")
    public WebElement PerilLossContingencySearch;

    @FindBy(xpath = "//button[contains(@name, 'SearchLossContingencyGroup')]")
    public WebElement LossContingencySearchButton;

    @FindBy(xpath = "//span[contains(text(), 'Loss Contingency Group')]")
    public WebElement LossContingencySearchModalHeader;

    @FindBy(xpath = "//a[contains(@name, 'LossContingencyList')]")
    public WebElement LossContingencyDeleteIcon;

    @FindBy(xpath = "//a[@class='iconDelete'][contains(@name, 'PerilDetailsList')]")
    public WebElement PerilDetailsDeleteIcon;

    @FindBy(xpath = "//div[contains(text(), 'has approval for this Generic Class of Business')]")
    public WebElement CapacitySeekerApprovalForGenericCOB;

    
    /**
     *      Accordion ------ Territorial Limitations 
     */

    @FindBy(xpath = "(//div[contains(@aria-label, 'Territorial Limitations')])[2]")
    public WebElement TerritorialLimitationsTab;

    @FindBy(xpath = "(//a[contains(@name, 'RiskLocationSelector')])[2]")
    public WebElement AddRiskLocation;

    @FindBy(xpath = "(//a[contains(@name, 'InsuredDomicileSelector')])[2]")
    public WebElement AddInsuredDomicile;

    @FindBy(xpath = "(//a[contains(@name, 'TerritorialLimitSelector')])[2]")
    public WebElement AddTerritorialLimits;

    @FindBy(xpath = "//div[@class='cellIn '][text()='Region/Country/Division']")
    public WebElement RegionHeader;

    @FindBy(xpath = "//span[@id='modaldialog_hd_title'][contains(text(), 'Search')]")
    public WebElement WorldwideExcludeSearchHeader;

    @FindBy(xpath = "//tr[contains(@id, 'RiskLocation')]//td//span")
    public List<WebElement> RiskLocationRegionList;

    @FindBy(xpath = "//span[contains(text(), 'none of the capacity seekers in this section has approval for this risk location country')]")
    public WebElement RiskLocationApprovalForCHSCError;

    @FindBy(xpath = "//tr[contains(@id, 'InsuredDomicile')]//td//span")
    public List<WebElement> InsuredDomicileRegionList;

    @FindBy(xpath = "//tr[contains(@id, 'TerritorialLimit')]//td//span")
    public List<WebElement> TerritorialLimitsRegionList;
    
    @FindBy(xpath = "//button[@alt='Ok']")
    public WebElement OKButton;

    @FindBy(xpath = "(//a[contains(@data-click, 'InsuredDomicile')][contains(@name, 'TerritorialLimits')])[2]")
    public WebElement CopyForInsuredDomicile;

    @FindBy(xpath = "//li[contains(@id, 'InsuredDomicile')]")
    public WebElement CopyInsuredDomicileCheck;

    @FindBy(xpath = "(//a[contains(@data-click, 'CopyTerritorialLimit')][contains(@name, 'TerritorialLimits')])[4]")
    public WebElement CopyForTerritorialLimit;

    @FindBy(xpath = "//li[contains(@id, 'TerritorialLimit')]")
    public WebElement CopyTerritorialLimitCheck;

    @FindBy(xpath = "(//input[contains(@name, 'ContractSectionList')][contains(@name, 'RiskWorldwide')])[2]")
    public WebElement RiskLocationWorldwideCheckbox;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'ExcludingRiskCountrySearch')]")
    public WebElement ExcludeCountrySearchRiskLocation;

    @FindBy(xpath = "//button[contains(@name, 'ContractSectionList')][contains(@data-click, 'ExcludingRiskCountries')]")
    public WebElement ExcludeCountryRiskLocationSearchButton;

    @FindBy(xpath = "(//input[contains(@name, 'ContractSectionList')][contains(@name, 'InsuredWorldwide')])[2]")
    public WebElement InsuredDomicileWorldwideCheckbox;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'ExcludingInsuredCountrySearch')]")
    public WebElement ExcludeCountrySearchInsuredDomicile;

    @FindBy(xpath = "//button[contains(@name, 'ContractSectionList')][contains(@data-click, 'ExcludingInsuredCountries')]")
    public WebElement ExcludeCountryInsuredCountriesSearchButton;

    @FindBy(xpath = "(//input[contains(@name, 'ContractSectionList')][contains(@name, 'Worldwide')][@type='checkbox'])[3]")
    public WebElement TerritorialLimitsWorldwideCheckbox;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'ExcludingCountrySearch')]")
    public WebElement ExcludeCountrySearchTerritorialLimit;

    @FindBy(xpath = "//button[contains(@name, 'ContractSectionList')][contains(@data-click, 'ExcludingCountries')]")
    public WebElement ExcludeCountryTerritorialLimitSearchButton;


    /**
     *      Accordion ------ Gross Premium Income Limit
     */
    
    @FindBy(xpath = "//div[contains(@aria-label, 'Gross Premium Income Limit')]")
    public WebElement GrossPremiumIncomeLimitTab;

    @FindBy(xpath = "//input[contains(@name, 'GrossPremiumIncome')][contains(@name, 'CurrencyCode')]")
    public WebElement GrossPremiumIncomeCurrency;

    @FindBy(xpath = "//input[contains(@name, 'GrossIncomeLimit')]")
    public WebElement GrossIncomeLimit;

    @FindBy(xpath = "//input[contains(@name, 'NotifiablePercentage')]")
    public WebElement IncomePercentage;

    @FindBy(xpath = "//div[text()= 'Notifiable percentage should be between 1 to 100%']")
    public WebElement IncomePercentageFieldError;
    
    
    
    /**
     *      Accordion ------ Period Of Insurances Bound
     */

    @FindBy(xpath = "(//div[contains(@aria-label, 'Period Of Insurances Bound')])[2]")
    public WebElement PeriodOfInsuranceBoundTab;

    @FindBy(xpath = "(//input[contains(@name, 'PeriodOfInsurancesBound')])[2]")
    public WebElement InsuranceBoundField;

    @FindBy(xpath = "(//input[contains(@name, 'PeriodOfInsurancesBound')])[2]//following::div[text()= 'Period Of Insurance must be within 0 to 999']")
    public WebElement InsuranceBoundFieldErrorMessage;

    @FindBy(xpath = "(//input[contains(@name, 'MAXIMUMPERIODOFINSURANCESBOUND')])[2]")
    public WebElement MaxPeriodInsuranceBoundField;

    @FindBy(xpath = "(//input[contains(@name, 'PeriodOfInsurancesBound')])[2]//following::div[text()= 'Maximum Period Of Insurance must be within 0 to 999']")
    public WebElement MaxPeriodInsuranceBoundFieldErrorMessage;

    @FindBy(xpath = "(//input[contains(@name, 'PeriodOfInsurancesBound')])[2]//following::div[text()= 'Maximum period of insurances bound must be greater than or equal to Period of insurances bound']")
    public WebElement MaxPeriodInsuranceBoundIsLessErrorMessage;

    @FindBy(xpath = "(//input[contains(@name, 'MaxAdvancePeriodInception')])[2]")
    public WebElement MaxAdvPeriodInsuranceBoundField;

    @FindBy(xpath = "(//input[contains(@name, 'PeriodOfInsurancesBound')])[2]//following::div[text()= 'Maximum advance period for inception dates must be within 0 to 366']")
    public WebElement MaxAdvPeriodInsuranceBoundFieldErrorMessage;

    @FindBy(xpath = "(//input[contains(@name, 'MaxAdvancePeriodInception')])[2]")
    public WebElement MaxPeriodInsuranceBoundFieldSC;

    /**
     *      Accordion ------ Commissions
     */

    @FindBy(xpath = "(//div[contains(@aria-label, 'Commissions')])[2]")
    public WebElement CommissionsTab;

    @FindBy(xpath = "((//div[contains(text(), 'The coverholder commission')])[2]//following::input)[1]")
    public WebElement Commision;

    @FindBy(xpath = "((//div[contains(text(), 'The  service company commission ')])[2]//following::input)[1]")
    public WebElement ServiceCompanyCommision;

    @FindBy(xpath = "((//p[contains(text(), 'Will there be a profit commission')])[2]//following::label[text()='Yes'])[1]")
    public WebElement ProfitCommissionYes;

    @FindBy(xpath = "((//p[contains(text(), 'Will there be a profit commission')])[2]//following::label[text()='No'])[1]")
    public WebElement ProfitCommissionNo;

    @FindBy(xpath = "(//input[@type='number'][contains(@name, 'CommissionDetails')][contains(@name, 'Profit')])[2]")
    public WebElement ProfitCommissionPercentage;

    @FindBy(xpath = "(//select[contains(@name, 'CommissionDetails')][contains(@name, 'ProfitBasis')])[2]")
    public WebElement ProfitCommissionBasis;

    @FindBy(xpath = "(//select[contains(@name, 'CommissionDetails')][contains(@name, 'Underwriting')][contains(@name, 'CurrencyCode')])[2]")
    public WebElement UnderwritingExpensesCurrency;

    @FindBy(xpath = "(//input[contains(@name, 'CommissionDetails')][contains(@name, 'Underwriting')][contains(@name, 'Fees')])[2]")
    public WebElement UnderwritingExpensesFees;

    @FindBy(xpath = "(//textarea[contains(@name, 'CommissionDetails')][contains(@name, 'Underwriting')][contains(@name, 'FeesDescription')])[2]")
    public WebElement UnderwritingExpensesDescription;

    @FindBy(xpath = "(//textarea[contains(@name, 'CommissionDetails')][contains(@name, 'Underwriting')][contains(@name, 'CostsDescription')])[2]")
    public WebElement ProfitCommissionDescription;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'RetailCommission')]")
    public WebElement MaxRetailBrokerCommission;

    @FindBy(xpath = "(//input[contains(@name, 'CommissionDetails')][contains(@name, 'Premium')][contains(@name, 'CurrencyCode')])[1]")
    public WebElement MaxFeesChargedCurrencyCode;

    @FindBy(xpath = "(//input[contains(@name, 'CommissionDetails')][contains(@name, 'Premium')][contains(@name, 'Commission')])[2]")
    public WebElement MaxFeesCharged;

    @FindBy(xpath = "(//input[contains(@name, 'CommissionDetails')][contains(@name, 'Premium')][contains(@name, 'CurrencyCode')])[2]")
    public WebElement MaxFeesDeductedCurrencyCode;

    @FindBy(xpath = "//input[contains(@name, 'CommissionDetails')][contains(@name, 'AdditionalPremium')][contains(@name, 'Fees')]")
    public WebElement MaxFeesDeducted;

    @FindBy(xpath = "(//textarea[contains(@name, 'CommissionDetails')][contains(@name, 'Premium')][contains(@name, 'FeesDescription')])")
    public WebElement FeesDescription;

    @FindBy(xpath = "//input[contains(@name, 'CommissionDetails')][contains(@name, 'Acquisition')][contains(@name, 'CurrencyCode')]")
    public WebElement MaxAcquisitionCostCurrencyCode;

    @FindBy(xpath = "(//input[contains(@name, 'CommissionDetails')][contains(@name, 'Acquisition')][contains(@name, 'Commission')])[2]")
    public WebElement MaxAcquisitionCostFees;

    @FindBy(xpath = "(//textarea[contains(@name, 'CommissionDetails')][contains(@name, 'Acquisition')][contains(@name, 'AcquisitionCostsDescription')])[3]")
    public WebElement AcquisitionCostDescriptionFees;

    @FindBy(xpath = "//input[contains(@name, 'CommissionDetails')][contains(@name, 'PermittedCommission')]")
    public WebElement PermittedCommission;

    @FindBy(xpath = "//div[contains(text(), 'retail broker commission')]")
    public WebElement RetailBrokerCommissionText;


    /**
     *      Accordion ------ Claims And Complaints
     */

    @FindBy(xpath = "(//div[contains(@aria-label, 'Claims and Complaints')])[2]")
    public WebElement ClaimsAndComplaintsTab;
    
    @FindBy(xpath = "((//div[text()='Coverholder'])[3]//preceding::label[text()='Yes'])[10]")
    public WebElement ClaimsHandlingCoverholderYes;

    @FindBy(xpath = "((//div[text()='Service Company'])[3]//preceding::label[text()='Yes'])[7]")
    public WebElement ClaimsHandlingServiceCompanyYes;

    @FindBy(xpath = "((//div[text()='Coverholder'])[3]//preceding::label[text()='No'])[10]")
    public WebElement ClaimsHandlingCoverholderNo;

    @FindBy(xpath = "((//div[text()='Coverholder'])[3]//preceding::label[text()='No'])[9]")
    public WebElement ClaimsHandlingCoverholderNoLBS;

    @FindBy(xpath = "((//div[text()='Service Company'])[3]//preceding::label[text()='No'])[7]")
    public WebElement ClaimsHandlingServiceCompanyNo;

    @FindBy(xpath = "((//div[text()='Coverholder'])[4]//preceding::label[text()='Yes'])[11]")
    public WebElement ClaimsHandlingDelegatedClaimsAdminYes;

    @FindBy(xpath = "((//div[text()='Delegated Claims Administrator'])[3]//preceding::label[text()='Yes'])[8]")
    public WebElement ClaimsHandlingDelegatedClaimsAdminYesServiceCompany;

    @FindBy(xpath = "((//div[text()='Delegated Claims Administrator'])[3]//preceding::label[text()='No'])[11]")
    public WebElement ClaimsHandlingDelegatedClaimsAdminNo;

    @FindBy(xpath = "((//div[text()='Delegated Claims Administrator'])[3]//preceding::label[text()='No'])[10]")
    public WebElement ClaimsHandlingDelegatedClaimsAdminNoLBS;

    @FindBy(xpath = "((//div[text()='Delegated Claims Administrator'])[3]//preceding::label[text()='No'])[8]")
    public WebElement ClaimsHandlingDelegatedClaimsAdminNoServiceCompany;

    @FindBy(xpath = "(((//div[text()='Coverholder'])[4])//preceding::label[text()='Yes'])[11]")
    public WebElement ComplaintsHandlingCoverholderYes;

    @FindBy(xpath = "(((//div[text()='Coverholder'])[4])//preceding::label[text()='No'])[12]")
    public WebElement ComplaintsHandlingCoverholderNo;

    @FindBy(xpath = "(((//div[text()='Coverholder'])[4])//preceding::label[text()='No'])[11]")
    public WebElement ComplaintsHandlingCoverholderNoLBS;

    @FindBy(xpath = "((//div[text()='Service Company'])[4]//preceding::label[text()='No'])[9]")
    public WebElement ComplaintsHandlingServiceCompanyNo;

    @FindBy(xpath = "((//div[text()='Delegated Claims Administrator'])[4]//preceding::label[text()='Yes'])[12]")
    public WebElement ComplaintsHandlingDelegatedClaimsAdminYes;

    @FindBy(xpath = "((//div[text()='Delegated Claims Administrator'])[4]//preceding::label[text()='No'])[13]")
    public WebElement ComplaintsHandlingDelegatedClaimsAdminNo;

    @FindBy(xpath = "((//div[text()='Delegated Claims Administrator'])[4]//preceding::label[text()='No'])[12]")
    public WebElement ComplaintsHandlingDelegatedClaimsAdminNoLBS;

    @FindBy(xpath = "((//div[text()='Delegated Claims Administrator'])[4]//preceding::label[text()='No'])[10]")
    public WebElement ComplaintsHandlingDelegatedClaimsAdminNoServiceCompany;

    @FindBy(xpath = "((//div[contains(text(), 'eligible complainants')])[2]//following::label[text()='Yes'])[1]")
    public WebElement EligibleComplainantsYes;

    @FindBy(xpath = "((//p[contains(text(), 'eligible complainants')])[2]//following::label[text()='No'])[1]")
    public WebElement EligibleComplainantsNo;

    @FindBy(xpath = "//div[contains(@data-lg-id,'EnterSectionDetails')]//div[contains(text(),'do not have claims handling authority')]")
    public WebElement ClaimsHandlingAuthorityError;

    @FindBy(xpath = "(//input[contains(@name, 'CurrencyCode')])[3]")
    public WebElement ClaimsAndComplaintsCurrency;

    @FindBy(xpath = "(//input[contains(@name, 'ContractSectionList')][contains(@name, 'PerClaimLimit')])")
    public WebElement ClaimsAndComplaintsPerClaimLimit;

    @FindBy(xpath = "(//input[contains(@name, 'ContractSectionList')][contains(@name, 'FirstName')][contains(@name, 'DedicatedClaimAuthority')])")
    public WebElement ClaimsAndComplaintsFirstname;

    @FindBy(xpath = "(//input[contains(@name, 'ContractSectionList')][contains(@name, 'SurName')][contains(@name, 'DedicatedClaimAuthority')])")
    public WebElement ClaimsAndComplaintsSurname;

    @FindBy(xpath = "(//input[contains(@name, 'ContractSectionList')][contains(@name, 'Email')][contains(@name, 'DedicatedClaimAuthority')])")
    public WebElement ClaimsAndComplaintsEmail;

    @FindBy(xpath = "(//button[contains(@name, 'ContractSectionList')][contains(@name, 'ClaimsAndComplaintsButton')][contains(@name, 'DedicatedClaimAuthority')])")
    public WebElement ClaimsAndComplaintsAddButton;

    @FindBy(xpath = "//div[contains(@data-lg-id,'EnterSectionDetails')]//a[contains(@name,'ClaimsAndComplaints')][@class='iconDelete']")
    public WebElement ClaimsAndComplaintsDeleteIcon;

    @FindBy(xpath = "(//input[contains(@name, 'ContractSectionList')][contains(@name, 'DCASearchCriteria')])")
    public WebElement DCASearchBox;

    @FindBy(xpath = "(//button[contains(@name, 'ContractSectionList')][contains(@name, 'DelegatedClaimAuthorityDetails')][text()='Search'])")
    public WebElement DCASearchButton;

    @FindBy(xpath = "//span[contains(@id, 'modaldialog')][contains(text(), 'Search Delegated Claim Authority')]")
    public WebElement SearchDCAheader;

    @FindBy(xpath = "//a[contains(@name, 'DelegatedClaimAuthority')][contains(@name,'ContractSectionList')]")
    public WebElement DCADeleteButton;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'DCAEmail')]")
    public WebElement DCAContactEmail;

    @FindBy(xpath = "(//input[contains(@name, 'ContractSectionList')][contains(@name, 'DedicatedClaimAuthorityDetails')][@type='checkbox'])")
    public WebElement ClaimsAndComplaintsPersonCheckBox;

    @FindBy(xpath = "//div[contains(@data-lg-id,'EnterCommonSectionDetails')]//div[text()='The person(s) authorised to exercise any claims authority']")
    public WebElement ClaimsAndComplaintsPerson;

    /**
     *      Accordion ------ Reporting And Aggregate Exposures
     */

    @FindBy(xpath = "(//div[contains(@aria-label, 'Reporting and Aggregate Exposures')])[2]")
    public WebElement ReportingAggrExposuresTab;

    @FindBy(xpath = "//select[contains(@name, 'ContractSectionList')][contains(@name, 'ContractAdministrator')]")
    public WebElement ContractAdministratorDropdown;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'ContractAdministrator')]")
    public WebElement ContractAdministratorValue;

    @FindBy(xpath = "(//select[contains(@name, 'SchemeOption')])[2]")
    public WebElement SchemeCanadaOption;

    @FindBy(xpath = "(//select[contains(@name, 'ReportingInterval')])[2]")
    public WebElement RisksReporting;

    @FindBy(xpath = "(//input[contains(@name, 'WrittenBordereau')])[2]")
    public WebElement WrittenBordereau;

    @FindBy(xpath = "(//select[contains(@name, 'AggregateReporting')])[2]")
    public WebElement AggregateReporting;

    @FindBy(xpath = "(//input[contains(@name, 'AggregateExposures')])[2]")
    public WebElement AggregateExposures;

    @FindBy(xpath = "(//select[contains(@name, 'PremiumInterval')])[2]")
    public WebElement PremiumReporting;

    @FindBy(xpath = "(//input[contains(@name, 'PremiumBordereaux')])[2]")
    public WebElement PremiumBordereau;

    @FindBy(xpath = "//select[contains(@name, 'ClaimReportingInterval')]")
    public WebElement ClaimsReporting;

    @FindBy(xpath = "//input[contains(@name, 'ClaimBordereaux')]")
    public WebElement MaxReportingBordereau;

    @FindBy(xpath = "(//input[contains(@name, 'RemittanceofSettlements')])[2]")
    public WebElement RemittanceofSettlements;

    @FindBy(xpath = "(//input[contains(@name, 'PaidClaims')])[2]")
    public WebElement PaidClaims;

    @FindBy(xpath = "(//textarea[contains(@name, 'ChargeDeduction')])[2]")
    public WebElement ChargesDeducted;

    @FindBy(xpath = "(//select[contains(@name, 'RisksWritten')][contains(@name, 'Submission')][contains(@name, 'Party')])[2]")
    public WebElement RisksWrittenSubmissionParty;

    @FindBy(xpath = "(//input[contains(@name, 'RisksWritten')][contains(@name, 'Submission')][contains(@name, 'Participant')])[2]")
    public WebElement RisksWrittenSubmissionParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'RisksWritten')][contains(@name, 'Transformation')][contains(@name, 'Party')])[2]")
    public WebElement RisksWrittenTransformationParty;

    @FindBy(xpath = "(//input[contains(@name, 'RisksWritten')][contains(@name, 'Transformation')][contains(@name, 'Participant')])[2]")
    public WebElement RisksWrittenTransformationParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'RisksWritten')][contains(@name, 'Assignment')][contains(@name, 'Party')])[2]")
    public WebElement RisksWrittenAssignmentParty;

    @FindBy(xpath = "(//input[contains(@name, 'RisksWritten')][contains(@name, 'Assignment')][contains(@name, 'Participant')])[2]")
    public WebElement RisksWrittenAssignmentParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'RisksWritten')][contains(@name, 'Approval')][contains(@name, 'Party')])[2]")
    public WebElement RisksWrittenApprovalParty;

    @FindBy(xpath = "(//input[contains(@name, 'RisksWritten')][contains(@name, 'Approval')][contains(@name, 'Participant')])[2]")
    public WebElement RisksWrittenApprovalParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'PaidPremium')][contains(@name, 'Submission')][contains(@name, 'Party')])[2]")
    public WebElement PaidPremiumSubmissionParty;

    @FindBy(xpath = "(//input[contains(@name, 'PaidPremium')][contains(@name, 'Submission')][contains(@name, 'Participant')])[2]")
    public WebElement PaidPremiumSubmissionParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'PaidPremium')][contains(@name, 'Transformation')][contains(@name, 'Party')])[2]")
    public WebElement PaidPremiumTransformationParty;

    @FindBy(xpath = "(//input[contains(@name, 'PaidPremium')][contains(@name, 'Transformation')][contains(@name, 'Participant')])[2]")
    public WebElement PaidPremiumTransformationParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'PaidPremium')][contains(@name, 'Assignment')][contains(@name, 'Party')])[2]")
    public WebElement PaidPremiumAssignmentParty;

    @FindBy(xpath = "(//input[contains(@name, 'PaidPremium')][contains(@name, 'Assignment')][contains(@name, 'Participant')])[2]")
    public WebElement PaidPremiumAssignmentParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'PaidPremium')][contains(@name, 'Approval')][contains(@name, 'Party')])[2]")
    public WebElement PaidPremiumApprovalParty;

    @FindBy(xpath = "(//input[contains(@name, 'PaidPremium')][contains(@name, 'Approval')][contains(@name, 'Participant')])[2]")
    public WebElement PaidPremiumApprovalParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'Claims')][contains(@name, 'Submission')][contains(@name, 'Party')])[2]")
    public WebElement ClaimsSubmissionParty;
    
    @FindBy(xpath = "(//select[contains(@name, 'Aggregates')][contains(@name, 'Submission')][contains(@name, 'Party')])[2]")
    public WebElement AggregatesSubmissionParty;

    @FindBy(xpath = "(//input[contains(@name, 'Aggregates')][contains(@name, 'Submission')][contains(@name, 'Participant')])[2]")
    public WebElement AggregatesSubmissionParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'Aggregates')][contains(@name, 'Transformation')][contains(@name, 'Party')])[2]")
    public WebElement AggregatesTransformationParty;

    @FindBy(xpath = "(//input[contains(@name, 'Aggregates')][contains(@name, 'Transformation')][contains(@name, 'Participant')])[2]")
    public WebElement AggregatesTransformationParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'Aggregates')][contains(@name, 'Assignment')][contains(@name, 'Party')])[2]")
    public WebElement AggregatesAssignmentParty;

    @FindBy(xpath = "(//input[contains(@name, 'Aggregates')][contains(@name, 'Assignment')][contains(@name, 'Participant')])[2]")
    public WebElement AggregatesAssignmentParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'Aggregates')][contains(@name, 'Approval')][contains(@name, 'Party')])[2]")
    public WebElement AggregatesApprovalParty;

    @FindBy(xpath = "(//input[contains(@name, 'Aggregates')][contains(@name, 'Approval')][contains(@name, 'Participant')])[2]")
    public WebElement AggregatesApprovalParticipant;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'BreachManagement')][contains(@name, 'Participant')]")
    public WebElement BreachManagement;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'ContractAdministrator')][contains(@name, 'Participant')]")
    public WebElement ContractAdministrator;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'RisksWritten')][contains(@name, 'Transformation')]")
    public WebElement RisksWrittenTransformation;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'RisksWritten')][contains(@name, 'Assignment')]")
    public WebElement RisksWrittenAssignment;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'RisksWritten')][contains(@name, 'Approval')]")
    public WebElement RisksWrittenApproval;

    @FindBy(xpath = "(//a[contains(@name, 'PartyAndParticipantDetailsIndividual')][contains(@name, 'ContractSectionList')])[1]")
    public WebElement CopyQuestionsPaidPremium;

    @FindBy(xpath = "(//a[contains(@name, 'PartyAndParticipantDetailsIndividual')][contains(@name, 'ContractSectionList')])[2]")
    public WebElement CopyQuestionsAggregates;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'Aggregates')][contains(@name, 'Transformation')]")
    public WebElement AggregatesTransformation;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'Aggregates')][contains(@name, 'Assignment')]")
    public WebElement AggregatesAssignment;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'Aggregates')][contains(@name, 'Approval')]")
    public WebElement AggregatesApproval;

    @FindBy(xpath = "//td[contains(@class, 'autocomplete')]")
    public List<WebElement> ParticipantList;



    /**
     *      Accordion ------ Capacity Details
     */
    
    @FindBy(xpath = "(//div[contains(@aria-label, 'Capacity Details')])[2]")
    public WebElement CapacityDetailsTab;

    @FindBy(xpath = "(//label[text()='LBS0001A'])")
    public WebElement SyndicateTypeCountryBrussels;

    @FindBy(xpath = "//select[contains(@name, 'ContractSectionList')][contains(@name, 'ContractLeadType')][contains(@name, 'SectionLead')]")
    public WebElement LeadType;

    @FindBy(xpath = "//select[contains(@name, 'ContractSectionList')][contains(@name, 'BrusselsLeadType')][contains(@name, 'SectionLead')]")
    public WebElement BrusselsLeadType;

    @FindBy(xpath = "//select[contains(@name, 'ContractSectionList')][contains(@name, 'ContractLeadType')][contains(@name, 'SectionFollow')]")
    public WebElement FollowType;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'SectionLead')][contains(@name, 'SyndicateSearchCriteria')]")  
    public WebElement SyndicateLead;

    @FindBy(xpath = "(//input[contains(@name, 'SyndicateSearchCriteria')][contains(@name, 'SectionLead')])")
    public WebElement SyndicateLeadBrussels;

    @FindBy(xpath = "//input[contains(@name, 'SyndicateList')][contains(@name, 'CompanyReference')]")
    public WebElement SyndicateLeadCompanyReference;

    @FindBy(xpath = "//input[contains(@name, 'SyndicateList')][contains(@name, 'SectionLead')][contains(@name, 'SignedLine')]")
    public WebElement SyndicateLeadSignedLine;

    @FindBy(xpath = "//div[text()= 'Each Signed Line values should be between 0.0000001 to 100.0000000']")
    public WebElement SignedLinePercentageError;

    @FindBy(xpath = "//input[contains(@name, 'SyndicateList')][contains(@name, 'SectionLead')][contains(@name, 'WrittenLine')]")
    public WebElement SyndicateLeadWrittenLine;

    @FindBy(xpath = "//div[text()= 'Each Written Line values should be between 0.0000001 to 100.0000000']")
    public WebElement WrittenLinePercentageError;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'SyndicateSearchCriteria')][contains(@name, 'SectionFollow')]")
    public WebElement SyndicateFollow;

    @FindBy(xpath = "//input[contains(@name, 'SectionFollow')][contains(@name, 'SyndicateList')][contains(@name, 'CompanyReference')]")
    public WebElement SyndicateFollowCompanyReference;
    
    @FindBy(xpath = "//input[contains(@name, 'SyndicateList')][contains(@name, 'SectionFollow')][contains(@name, 'SignedLine')]")
    public WebElement SyndicateFollowSignedLine;

    @FindBy(xpath = "//input[contains(@name, 'ServiceCompanySearchCriteria')][contains(@name, 'SectionLead')]")
    public WebElement ServiceCompanyLead;

    @FindBy(xpath = "//button[contains(@name, 'ContractLeadSearch')][contains(@name, 'SectionLead')]")
    public WebElement SearchButtonServiceCompanyLead;

    @FindBy(xpath = "//span[contains(@id, 'modaldialog_hd_title')][contains(text(), 'Search Service')]")
    public WebElement ServiceCompanyHeader;

    @FindBy(xpath = "//input[contains(@name, 'ServiceCompanyList')][contains(@name, 'CompanyReference')]")
    public WebElement ServiceCompanyLeadCompanyReference;

    @FindBy(xpath = "//input[contains(@name, 'ServiceCompanyList')][contains(@name, 'SectionLead')][contains(@name, 'WrittenLine')]")
    public WebElement ServiceCompanyLeadWrittenLine;
    
    @FindBy(xpath = "//input[contains(@name, 'ServiceCompanyList')][contains(@name, 'SignedLine')][contains(@name, 'SectionLead')]")
    public WebElement ServiceCompanyLeadSignedLine;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'ServiceCompanyList')][contains(@name, 'ServiceCompanyUMR')]")
    public WebElement ServiceCompanyLeadUMR;

    @FindBy(xpath = "//input[contains(@name, 'ServiceCompanySearchCriteria')][contains(@name, 'SectionFollow')]")
    public WebElement ServiceCompanyFollow;

    @FindBy(xpath = "//button[contains(@name, 'ContractFollowSearch')][contains(@name, 'SectionFollow')]")
    public WebElement SearchButtonServiceCompanyFollow;

    @FindBy(xpath = "//input[contains(@name, 'ServiceCompanyList')][contains(@name, 'SignedLine')][contains(@name, 'SectionFollow')]")
    public WebElement ServiceCompanyFollowSignedLine;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'NonLloydsSearchCriteria')]")
    public WebElement NonLloydsInsurerLead;

    @FindBy(xpath = "//td[contains(@class, 'autocomplete')]")
    public List<WebElement> NonLloydsInsurerList;

    @FindBy(xpath = "//input[contains(@name, 'NonLloydsInsurerList')][contains(@name, 'SignedLine')][contains(@name, 'SectionLead')]")
    public WebElement NonLloydsInsurerLeadSignedLine;

    @FindBy(xpath = "//input[contains(@name, 'NonLloydsSearchCriteria')][contains(@name, 'SectionFollow')]")
    public WebElement NonlloydsInsurerFollow;

    @FindBy(xpath = "//input[contains(@name, 'NonLloydsInsurerList')][contains(@name, 'SignedLine')][contains(@name, 'SectionFollow')]")
    public WebElement NonLloydsInsurerFollowSignedLine;

    @FindBy(xpath = "//td[contains(text(), 'no results found')]")
    public WebElement ServiceCompanyNoResultFoundMsg;

    @FindBy(xpath = "//label[text()='Syndicate']")
    public WebElement SelectedLeadSyndicate;

    @FindBy(xpath = "//label[text()='Service Company']")
    public WebElement SelectedLeadServiceCompany;

    @FindBy(xpath = "//button[@title='close modal']")
    public WebElement CloseServiceCompanyModalIcon;

    @FindBy(xpath = "//a[contains(@name, 'SyndicateList')]")
    public WebElement DeleteSyndicateIcon;

    @FindBy(xpath = "//a[contains(@name, 'ServiceCompanyList')]")
    public WebElement DeleteServiceCompanyIcon;
    
    @FindBy(xpath = "(//span[contains(@name, 'DateConfirmReceived')])[2]")
    public WebElement ConfirmationDate;

    @FindBy(xpath = "(//span[@id='monthSpinner']//following::input[@type='text'])[1]")
    public WebElement ConfirmationDateMonth;

    @FindBy(xpath = "(//span[@id='yearSpinner']//following::input[@type='text'])[1]")
    public WebElement ConfirmationDateYear;

    @FindBy(xpath = "//td[contains(@class, 'calcell')]//a")
    public List<WebElement> ConfirmationDateDay;

    @FindBy(xpath = "(//span[contains(@name, 'DateConfirmReceived')])[1]")
    public WebElement ConfirmationDateCommonSection;

    @FindBy(xpath = "//a[@class='today-link']")
    public WebElement TodayLink;

            /**   Section Capacity Details For Twin Contract - Second Section */

            @FindBy(xpath = "(//div[contains(@aria-label, 'Capacity Details')])")
            public WebElement CapacityDetailsSecondSection;

            @FindBy(xpath = "//select[contains(@name, 'ContractSectionList')][contains(@name, 'BrusselsLeadType')][contains(@name, 'SectionLead')]")
            public WebElement LeadTypeBrusselsSecondSection;

            @FindBy(xpath = "(//span[contains(@name, 'DateConfirmReceived')])")
            public WebElement ConfirmationDateTwinContract;

            /** Section Capacity Details For Non Twin Contract - Second Section */

            @FindBy(xpath = "(//div[contains(@aria-label, 'Capacity Details')])[2]")
            public WebElement CapacityDetailsSecondSectionNonTwin;

    

    /**
     *      Accordion ------ Non - Schedule
     */

    @FindBy(xpath = "(//div[contains(@aria-label, 'Non-Schedule')])[2]")
    public WebElement NonScheduleTab;
    
    @FindBy(xpath = "(//input[contains(@name, 'NonSchedulerDetails')][contains(@name, 'CurrencyCode')])[2]")
    public WebElement GrossEPICurrency;

    @FindBy(xpath = "(//input[contains(@name, 'GrossEPI')])[2]")
    public WebElement GrossEPI;

    @FindBy(xpath = "(//select[contains(@name, 'WrittenLineValues')])[2]")
    public WebElement BasisWrittenLine;

    @FindBy(xpath = "(//select[contains(@name, 'SignedLineValues')])[2]")
    public WebElement BasisSignedLine;

    @FindBy(xpath = "(//select[contains(@name, 'SigningProvisionsValues')])[2]")
    public WebElement SigningProvision;

    @FindBy(xpath = "(//input[contains(@name, 'TotalLloydsBrokerage')])[4]")
    public WebElement LloydsBrokerage;

    @FindBy(xpath = "(//input[contains(@name, 'CheckTotalLloydsBrokerage')][@type='checkbox'])[2]")
    public WebElement LloydsBrokerageCheck;

    @FindBy(xpath = "(//select[contains(@name, 'ManualBrokerageCurrencyCode')])[1]")
    public WebElement ManualBrokerageCurrencyCode;

    @FindBy(xpath = "(//input[contains(@name, 'ManualTotalBrokerage')])[2]")
    public WebElement ManualBrokerage;

    @FindBy(xpath = "(//select[contains(@name, 'NonSchedulePlatform')])[2]")
    public WebElement Platform;

    @FindBy(xpath = "(//span[contains(text(), 'Brussels Subsidiary')])")
    public WebElement PlatformReadOnlyLBS;

    @FindBy(xpath = "//a[@class='iconDelete'][contains(@name, 'NonSchedulePlatformValues')]")
    public WebElement PlatformDeleteIcon;

    @FindBy(xpath = "(//span[contains(text(), 'Brussels Subsidiary')])[2]")
    public WebElement PlatformReadOnlyLBSExceptTwinContract;

    @FindBy(xpath = "(//textarea[contains(@name, 'OtherDeductionsText')])[2]")
    public WebElement OtherDeductions;

    @FindBy(xpath = "(//select[contains(@name, 'ProductRiskRatingValues')])[2]")
    public WebElement ProductRiskRating;

    @FindBy(xpath = "(//select[contains(@name, 'RouteOfValues')])[2]")
    public WebElement RouteOfBusiness;

}
