package com.chorus.pagefactory.createContractPageElements;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


    /**
    *    Page Factory Class
    *    Section Details -----  Common Section Details
    */


public class CommonSectionDetailsPage  {
    
    @FindBy(xpath = "//div[contains(@aria-label, 'COMMON SECTION DETAILS')]")
    public WebElement CommonSectionDetails;

    @FindBy(xpath = "//button[@title='Yes']")
    public WebElement ApplyAllYesButton;
    
    /**
     *      Accordion ------ Cover Holder / Service Company Details
     */

    @FindBy(xpath = "(//div[contains(@aria-label, 'Coverholder Details')])[1]")
    public WebElement CoverholderDetailsTab;

    @FindBy(xpath = "(//div[contains(@aria-label, 'Service Company Details')])[1]")         
    public WebElement ServiceCompanyDetailsTab;

    @FindBy(xpath = "(//div[contains(@aria-label, 'Service Company Details')])[1]")
    public WebElement ServiceCompanyTab;

    @FindBy(xpath = "(//input[contains(@name, 'CoverholderSearchCriteria')])[1]")
    public WebElement CoverholderField;

    @FindBy(xpath = "(//input[contains(@name, 'ServiceCompanySearchCriteria')])[1]")
    public WebElement ServiceCompanyField;

    @FindBy(xpath = "//button[contains(@name, 'SearchCoverholderForCommonSection')]")
    public WebElement SearchCoverHolderButton;

    @FindBy(xpath = "(//label[contains(text(), 'Name or PIN')])[1]")
    public WebElement SearchCoverholderServiceCompanyLabel;

    @FindBy(xpath = "//span[@id='modaldialog_hd_title'][contains(text(), 'Search')]")
    public WebElement SearchResults;

    @FindBy(xpath = "//button[@alt='Add']")
    public WebElement AddButton;

    @FindBy(xpath = "//input[contains(@name, 'CopyCoverHolderDetails')][contains(@name, 'PropertyValue')]")
    public WebElement TradingNameFieldCoverholder;

    @FindBy(xpath = "(//button[@type='button'][contains(@name, 'TradingNames')])[1]")
    public WebElement SearchTradingNamesButton;

    @FindBy(xpath = "//button[contains(@name, 'SearchButtonForScCommon')]") 
    public WebElement SearchServiceCompanyButton;

    @FindBy(xpath = "//button[contains(@name, 'CoverHolderDetails')][text()='Apply']")
    public WebElement ApplyCoverholderDetails;

    @FindBy(xpath = "//button[contains(@name, 'ServiceCompanyDetails')][text()='Apply']")
    public WebElement ApplyServiceCompanyDetails;

    /**
     *      Accordion ------ Persons Responsible for Operation and Control
     */

    @FindBy(xpath = "(//div[contains(@aria-label, 'Operation and Control')])[1]")
    public WebElement PersonResponsibleTab;

    @FindBy(xpath = "(//input[contains(@name, 'OperationData')][contains(@name, 'FirstName')])[1]")
    public WebElement PersonResponsibleFirstName;

    @FindBy(xpath = "(//input[contains(@name, 'List')][contains(@name, 'FirstName')])[1]")
    public WebElement PersonResponsibleLinkedFirstName;

    @FindBy(xpath = "(//input[contains(@name, 'OperationData')][contains(@name, 'SurName')])[1]")
    public WebElement PersonResponsibleSurName;

    @FindBy(xpath = "(//button[contains(@name, 'OperationData')][contains(@name, 'EmailButton')])[1]")
    public WebElement AddPersonResponsible;

    @FindBy(xpath = "(//input[contains(@name, 'List')][contains(@name, 'SurName')])[1]")
    public WebElement PersonResponsibleLinkedSurName;

    @FindBy(xpath = "(//input[contains(@name, 'OperationData')][contains(@name, 'Email')])[1]")
    public WebElement PersonResponsibleEmail;

    @FindBy(xpath = "(//input[contains(@name, 'List')][contains(@name, 'Email')])[1]")
    public WebElement PersonResponsibleLinkedEmail;

    @FindBy(xpath = "(//input[contains(@name, 'OperationData')][contains(@name, 'FirstName')])[2]")
    public WebElement AuthorisedBindInsurancesFirstName;

    @FindBy(xpath = "(//input[contains(@name, 'OperationData')][contains(@name, 'Surname')])[1]")
    public WebElement AuthorisedBindInsurancesSurname;

    @FindBy(xpath = "(//input[contains(@name, 'OperationData')][contains(@name, 'Email')])[2]")
    public WebElement AuthorisedBindInsurancesEmail;

    @FindBy(xpath = "(//button[contains(@name, 'OperationData')][contains(@name, 'Email1Button')])[1]")
    public WebElement AddAuthorisedBindInsurances;

    @FindBy(xpath = "(//input[contains(@name, 'OperationData')][contains(@name, 'FirstName')])[3]")
    public WebElement OverallResponsibleFirstName;

    @FindBy(xpath = "(//input[contains(@name, 'OperationData')][contains(@name, 'Surname')])[2]")
    public WebElement OverallResponsibleSurname;

    @FindBy(xpath = "(//input[contains(@name, 'OperationData')][contains(@name, 'Email')])[3]")
    public WebElement OverallResponsibleEmail;

    @FindBy(xpath = "(//button[contains(@name, 'OperationData')][contains(@name, 'Email2Button')])[1]")
    public WebElement AddOverallResponsible;

    @FindBy(xpath = "(//button[contains(@name, 'List')][contains(@name, 'EmailButton')])[1]")
    public WebElement AddPersonResponsibleLinked;

    @FindBy(xpath = "(//a[contains(@name, 'OperationAndControlDetails')])[1]")
    public WebElement CopyNamesBindInsurance;

    @FindBy(xpath = "(//a[contains(@name, 'OperationAndControlDetails')])[2]")
    public WebElement CopyNamesInsurancesBound;

    @FindBy(xpath = "(//td[@data-attribute-name='Surname']//following::a[@title='Delete this row  '])[1]")
    public WebElement DeleteAddedPersonResposible;

    @FindBy(xpath = "(//td[@data-attribute-name='Surname']//following::a[@title='Delete this row  '])[2]")
    public WebElement DeleteAddedAuthorisedBindInsurances;

    @FindBy(xpath = "(//td[@data-attribute-name='Surname']//following::a[@title='Delete this row  '])[3]")
    public WebElement DeleteAddedOverallResponsible;

    @FindBy(xpath = "(//input[@type='checkbox'][contains(@name, 'CheckCoverholder')])[1]")
    public WebElement EachCoverholderCheckbox;

    @FindBy(xpath = "//button[contains(@name, 'OperationAndControlCommonSection')][text()='Apply']")
    public WebElement ApplyPersonResponsible;

    /**
     *      Accordion ------ Territorial Limitations 
     */

    @FindBy(xpath = "(//div[contains(@aria-label, 'Territorial Limitations')])[1]")
    public WebElement TerritorialLimitationsTab;

    @FindBy(xpath = "(//a[contains(@name, 'RiskLocationSelector')])[1]")  
    public WebElement AddRiskLocation;

    @FindBy(xpath = "(//a[contains(@name, 'InsuredDomicileSelector')])[1]")
    public WebElement AddInsuredDomicile;

    @FindBy(xpath = "(//a[contains(@name, 'TerritorialLimitSelector')])[1]")
    public WebElement AddTerritorialLimits;

    @FindBy(xpath = "//div[@class='cellIn '][text()='Region/Country/Division']")
    public WebElement RegionHeader;

    @FindBy(xpath = "//span[@id='modaldialog_hd_title'][contains(text(), 'Search')]")
    public WebElement WorldwideExcludeSearchHeader;

    @FindBy(xpath = "//tr[contains(@id, 'RiskLocation')]//td//span")
    public List<WebElement> RiskLocationRegionList;

    @FindBy(xpath = "//tr[contains(@id, 'InsuredDomicile')]//td//span")
    public List<WebElement> InsuredDomicileRegionList;

    @FindBy(xpath = "//tr[contains(@id, 'TerritorialLimit')]//td//span")
    public List<WebElement> TerritorialLimitsRegionList;
    
    @FindBy(xpath = "//button[@alt='Ok']")
    public WebElement OKButton;

    @FindBy(xpath = "(//img[contains(@data-click, 'InsuredDomicile')])[1]")
    public WebElement CopyForInsuredDomicile;

    @FindBy(xpath = "//li[contains(@id, 'InsuredDomicile')]")
    public WebElement CopyInsuredDomicileCheck;

    @FindBy(xpath = "(//img[contains(@data-click, 'TerritorialLimit')])[2]")
    public WebElement CopyForTerritorialLimit;

    @FindBy(xpath = "//li[contains(@id, 'TerritorialLimit')]")
    public WebElement CopyTerritorialLimitCheck;

    @FindBy(xpath = "(//li[contains(@id, 'InsuredDomicile')])[3]")
    public WebElement CopyInsuredDomicileCheckFromCommon;

    @FindBy(xpath = "(//li[contains(@id, 'TerritorialLimit')])[4]")
    public WebElement CopyTerritorialLimitCheckFromCommon;

    @FindBy(xpath = "//button[contains(@name, 'TerritorialDetails')][text()='Apply']")
    public WebElement ApplyTerritorialLimits;

    @FindBy(xpath = "(//input[contains(@name, 'CommonSectionDetails')][contains(@name, 'RiskWorldwide')])[2]")
    public WebElement RiskLocationWorldwideCheckbox;

    @FindBy(xpath = "//input[contains(@name, 'CommonSectionDetails')][contains(@name, 'ExcludingRiskCountrySearch')]")
    public WebElement ExcludeCountrySearchRiskLocation;

    @FindBy(xpath = "//button[contains(@name, 'CommonSectionDetails')][contains(@data-click, 'ExcludingRiskCountries')]")
    public WebElement ExcludeCountryRiskLocationSearchButton;

    @FindBy(xpath = "(//input[contains(@name, 'CommonSectionDetails')][contains(@name, 'InsuredWorldwide')])[2]")
    public WebElement InsuredDomicileWorldwideCheckbox;

    @FindBy(xpath = "//input[contains(@name, 'CommonSectionDetails')][contains(@name, 'ExcludingInsuredCountrySearch')]")
    public WebElement ExcludeCountrySearchInsuredDomicile;

    @FindBy(xpath = "//button[contains(@name, 'CommonSectionDetails')][contains(@data-click, 'ExcludingInsuredCountries')]")
    public WebElement ExcludeCountryInsuredCountriesSearchButton;

    @FindBy(xpath = "(//input[contains(@name, 'CommonSectionDetails')][contains(@name, 'Worldwide')][@type='checkbox'])[3]")
    public WebElement TerritorialLimitsWorldwideCheckbox;

    @FindBy(xpath = "//input[contains(@name, 'CommonSectionDetails')][contains(@name, 'ExcludingCountrySearch')]")
    public WebElement ExcludeCountrySearchTerritorialLimit;

    @FindBy(xpath = "//button[contains(@name, 'CommonSectionDetails')][contains(@data-click, 'ExcludingCountries')]")
    public WebElement ExcludeCountryTerritorialLimitSearchButton;


    /**
     *      Accordion ------ Period Of Insurances Bound
     */

    @FindBy(xpath = "(//div[contains(@aria-label, 'Period Of Insurances Bound')])[1]")
    public WebElement PeriodOfInsuranceBoundTab;

    @FindBy(xpath = "(//input[contains(@name, 'PeriodOfInsurancesBound')])[1]")
    public WebElement InsuranceBoundField;

    @FindBy(xpath = "(//input[contains(@name, 'MAXIMUMPERIODOFINSURANCESBOUND')])[1]")
    public WebElement MaxPeriodInsuranceBoundField;

    @FindBy(xpath = "(//input[contains(@name, 'MaxAdvancePeriodInception')])[1]")
    public WebElement MaxAdvPeriodInsuranceBoundField;

    @FindBy(xpath = "(//input[contains(@name, 'MaxAdvancePeriodInception')])[1]")
    public WebElement MaxPeriodInsuranceBoundFieldSC;

    @FindBy(xpath = "//button[contains(@name, 'PeriodOfInsurancesBound')][text()='Apply']")
    public WebElement ApplyPeriodOfInsuranceBound;

    /**
     *      Accordion ------ Commissions
     */

    @FindBy(xpath = "(//div[contains(@aria-label, 'Commissions')])[1]")
    public WebElement CommissionsTab;
    
    @FindBy(xpath = "((//div[contains(text(),'The coverholder commission')])[1]//following::input)[1]")
    public WebElement Commision;

    @FindBy(xpath = "((//div[contains(text(),'service company commission ')])[1]//following::input)[1]")
    public WebElement ServiceCompanyCommision;

    @FindBy(xpath = "((//p[contains(text(),'Will there be a profit commission')])[1]//following::label[text()='Yes'])[1]")
    public WebElement ProfitCommissionYes;

    @FindBy(xpath = "((//p[contains(text(),'Will there be a profit commission')])[1]//following::label[text()='No'])[1]")
    public WebElement ProfitCommissionNo;

    @FindBy(xpath = "(//input[@type='number'][contains(@name, 'CommissionData')][contains(@name, 'Profit')])[2]")
    public WebElement ProfitCommissionPercentage;

    @FindBy(xpath = "(//select[contains(@name, 'CommissionData')][contains(@name, 'ProfitBasis')])[2]")
    public WebElement ProfitCommissionBasis;

    @FindBy(xpath = "(//select[contains(@name, 'CommissionData')][contains(@name, 'Underwriting')][contains(@name, 'CurrencyCode')])[2]")
    public WebElement UnderwritingExpensesCurrency;

    @FindBy(xpath = "(//input[contains(@name, 'CommissionData')][contains(@name, 'Underwriting')][contains(@name, 'Fees')])[2]")
    public WebElement UnderwritingExpensesFees;

    @FindBy(xpath = "(//textarea[contains(@name, 'CommissionData')][contains(@name, 'Underwriting')][contains(@name, 'FeesDescription')])[2]")
    public WebElement UnderwritingExpensesDescription;

    @FindBy(xpath = "(//textarea[contains(@name, 'CommissionData')][contains(@name, 'Underwriting')][contains(@name, 'CostsDescription')])[2]")
    public WebElement ProfitCommissionDescription;

    @FindBy(xpath = "(//select[contains(@name, 'CommissionData')][contains(@name, 'Premium')][contains(@name, 'CurrencyCode')])[1]")
    public WebElement MaxFeesChargedCurrencyCode;

    @FindBy(xpath = "(//input[contains(@name, 'CommissionData')][contains(@name, 'Premium')][contains(@name, 'Fees')])[1]")
    public WebElement MaxFeesCharged;

    @FindBy(xpath = "(//select[contains(@name, 'CommissionData')][contains(@name, 'Premium')][contains(@name, 'CurrencyCode')])[2]")
    public WebElement MaxFeesDeductedCurrencyCode;

    @FindBy(xpath = "(//input[contains(@name, 'CommissionData')][contains(@name, 'Premium')][contains(@name, 'Fees')])[2]")
    public WebElement MaxFeesDeducted;

    @FindBy(xpath = "//textarea[contains(@name, 'CommissionData')][contains(@name, 'Premium')][contains(@name, 'FeesDescription')]")
    public WebElement FeesDescription;

    @FindBy(xpath = "//select[contains(@name, 'CommissionData')][contains(@name, 'Acquisition')][contains(@name, 'CurrencyCode')]")
    public WebElement MaxAcquisitionCostCurrencyCode;

    @FindBy(xpath = "//input[contains(@name, 'CommissionData')][contains(@name, 'Acquisition')][contains(@name, 'Fees')]")
    public WebElement MaxAcquisitionCostFees;

    //@FindBy(xpath = "//textarea[contains(@name, 'CommissionData')][contains(@name, 'Acquisition')][contains(@name, 'AcquisitionCostsDescription')]")
    @FindBy(xpath = "//textarea[@name='$PpyWorkPage$pCommissionData$pAcquisition$pAcquisitionCostsDescription']")
    public WebElement AcquisitionCostDescriptionFees;

    @FindBy(xpath = "//input[contains(@name, 'CommissionData')][contains(@name, 'PermittedCommission')]")
    public WebElement PermittedCommission;

    @FindBy(xpath = "//button[contains(@name, 'CommissionDetails')][text()='Apply']")
    public WebElement ApplyCommissions;

    @FindBy(xpath = "//div[contains(text(), 'retail broker commission')]")
    public WebElement RetailBrokerCommissionText;


    /**
     *      Accordion ------ Claims and Complaints
     */

    @FindBy(xpath = "(//div[contains(@aria-label, 'Claims and Complaints')])[1]")
    public WebElement ClaimsAndComplaintsTab;

    @FindBy(xpath = "((//div[text()='Coverholder'])[1]//preceding::label[text()='No'])[2]")
    public WebElement ClaimsHandlingCoverholderNo;

    @FindBy(xpath = "((//div[text()='Service Company'])[1]//preceding::label[text()='No'])")
    public WebElement ClaimsHandlingServiceCompanyNo;

    @FindBy(xpath = "((//div[text()='Coverholder'])[1]//preceding::label[text()='Yes'])[2]")
    public WebElement ClaimsHandlingCoverholderYes;

    @FindBy(xpath = "((//div[text()='Delegated Claims Administrator'])[1]//preceding::label[text()='Yes'])[3]")
    public WebElement ClaimsHandlingDelegatedClaimsAdminYes;

    @FindBy(xpath = "((//div[text()='Delegated Claims Administrator'])[1]//preceding::label[text()='Yes'])[2]")
    public WebElement ClaimsHandlingDelegatedClaimsAdminYesServiceCompany;

    @FindBy(xpath = "((//div[text()='Delegated Claims Administrator'])[1]//preceding::label[text()='No'])[3]")
    public WebElement ClaimsHandlingDelegatedClaimsAdminNo;

    @FindBy(xpath = "((//div[text()='Delegated Claims Administrator'])[1]//preceding::label[text()='No'])[2]")
    public WebElement ClaimsHandlingDelegatedClaimsAdminNoServiceCompany;

    @FindBy(xpath = "(((//div[text()='Coverholder'])[2])//preceding::label[text()='No'])[4]")
    public WebElement ComplaintsHandlingCoverholderNo;

    @FindBy(xpath = "(((//div[text()='Service Company'])[2])//preceding::label[text()='No'])[3]")
    public WebElement ComplaintsHandlingServiceCompanyNo;

    @FindBy(xpath = "(((//div[text()='Coverholder'])[2])//preceding::label[text()='Yes'])[4]")
    public WebElement ComplaintsHandlingCoverholderYes;

    @FindBy(xpath = "((//div[text()='Delegated Claims Administrator'])[2]//preceding::label[text()='Yes'])[5]")
    public WebElement ComplaintsHandlingDelegatedClaimsAdminYes;

    @FindBy(xpath = "((//div[text()='Delegated Claims Administrator'])[2]//preceding::label[text()='No'])[5]")
    public WebElement ComplaintsHandlingDelegatedClaimsAdminNo;

    @FindBy(xpath = "((//div[text()='Delegated Claims Administrator'])[2]//preceding::label[text()='No'])[4]")
    public WebElement ComplaintsHandlingDelegatedClaimsAdminServiceCompanyNo;

    @FindBy(xpath = "((//div[contains(text(), 'eligible complainants')])[1]//following::label[text()='Yes'])[1]")
    public WebElement EligibleComplainantsYes;

    @FindBy(xpath = "((//p[contains(text(), 'eligible complainants')])[1]//following::label[text()='No'])[1]")
    public WebElement EligibleComplainantsNo;

    @FindBy(xpath = "//button[contains(@name, 'ClaimAuthorityDetails')][text()='Apply']")
    public WebElement ApplyClaimsAndComplaints;

    @FindBy(xpath = "//div[contains(@data-lg-id,'EnterCommonSectionDetails')]//div[contains(text(),'do not have claims handling authority')]")
    public WebElement ClaimsHandlingAuthorityError;

    @FindBy(xpath = "(//input[contains(@name, 'CurrencyCode')])[1]")
    public WebElement ClaimsAndComplaintsCurrency;

    @FindBy(xpath = "(//input[contains(@name, 'PerClaimLimit')])[1]")
    public WebElement ClaimsAndComplaintsPerClaimLimit;

    @FindBy(xpath = "(//input[contains(@name, 'FirstName')][contains(@name, 'DedicatedClaimAuthority')])[1]")
    public WebElement ClaimsAndComplaintsFirstname;

    @FindBy(xpath = "(//input[contains(@name, 'SurName')][contains(@name, 'DedicatedClaimAuthority')])[1]") //new xpath
    public WebElement ClaimsAndComplaintsSurname;

    @FindBy(xpath = "(//input[contains(@name, 'Email')][contains(@name, 'DedicatedClaimAuthority')])[1]")  //new xpath
    public WebElement ClaimsAndComplaintsEmail;

    @FindBy(xpath = "(//button[contains(@name, 'ClaimsAndComplaintsButton')][text()='Add'])[1]")  //new xpath
    public WebElement ClaimsAndComplaintsAddButton;

    @FindBy(xpath = "//div[contains(@data-lg-id,'EnterCommonSectionDetails')]//a[contains(@name,'ClaimsAndComplaints')][@class='iconDelete']")
    public WebElement ClaimsAndComplaintsDeleteIcon;

    @FindBy(xpath = "(//input[contains(@name, 'DCASearchCriteria')])[1]")  //new xpath
    public WebElement DCASearchBox;

    @FindBy(xpath = "(//button[contains(@name, 'DelegatedClaimAuthorityDetails')][text()='Search'])[1]")  //new xpath
    public WebElement DCASearchButton;

    @FindBy(xpath = "//a[contains(@name, 'DelegatedClaimAuthority')]")
    public WebElement DCADeleteLink;

    @FindBy(xpath = "(//input[contains(@name, 'DedicatedClaimAuthorityDetails')][@type='checkbox'])[1]")  //new xpath
    public WebElement ClaimsAndComplaintsPersonCheckBox;

    @FindBy(xpath = "//div[contains(@data-lg-id,'EnterCommonSectionDetails')]//div[text()='The person(s) authorised to exercise any claims authority']")
    public WebElement ClaimsAndComplaintsPerson;

    @FindBy(xpath = "(//div[text()='Service Company'])[1]//preceding::label[text()='Yes']")
    public WebElement ClaimsHandlingServiceCompanyYes;
        
    /**
     *      Accordion ------ Reporting and Aggregate Exposures
     */
     
    @FindBy(xpath = "(//div[contains(@aria-label, 'Reporting and Aggregate Exposures')])[1]")
    public WebElement ReportingAggrExposuresTab;
    
    @FindBy(xpath = "(//select[contains(@name, 'SchemeOption')])[1]")
    public WebElement SchemeCanadaOption;
    
    @FindBy(xpath = "(//select[contains(@name, 'ReportingInterval')])[1]")
    public WebElement RisksReporting;

    @FindBy(xpath = "(//input[contains(@name, 'WrittenBordereau')])[1]")
    public WebElement WrittenBordereau;

    @FindBy(xpath = "(//select[contains(@name, 'AggregateReporting')])[1]")
    public WebElement AggregateReporting;

    @FindBy(xpath = "(//input[contains(@name, 'AggregateExposures')])[1]")
    public WebElement AggregateExposures;

    @FindBy(xpath = "(//select[contains(@name, 'PremiumInterval')])[1]")
    public WebElement PremiumReporting;

    @FindBy(xpath = "(//input[contains(@name, 'PremiumBordereaux')])[1]")
    public WebElement PremiumBordereau;

    @FindBy(xpath = "(//select[contains(@name, 'ClaimReportingInterval')])[1]")
    public WebElement ClaimsReporting;

    @FindBy(xpath = "(//input[contains(@name, 'ClaimBordereau')])[1]")
    public WebElement MaxReportingBordereau;

    @FindBy(xpath = "(//input[contains(@name, 'RemittanceofSettlements')])[1]")
    public WebElement RemittanceofSettlements;

    @FindBy(xpath = "(//input[contains(@name, 'PaidClaims')])[1]")
    public WebElement PaidClaims;

    @FindBy(xpath = "(//textarea[contains(@name, 'ChargeDeduction')])[1]")
    public WebElement ChargesDeducted;

    @FindBy(xpath = "//input[contains(@name, 'ContractSectionList')][contains(@name, 'BreachManagement')]") //---------------
    public WebElement BreachManagementIndividualSection;

    @FindBy(xpath = "(//select[contains(@name, 'RisksWritten')][contains(@name, 'Submission')][contains(@name, 'Party')])[1]")
    public WebElement RisksWrittenSubmissionParty;

    @FindBy(xpath = "(//input[contains(@name, 'RisksWritten')][contains(@name, 'Submission')][contains(@name, 'Participant')])[1]")
    public WebElement RisksWrittenSubmissionParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'RisksWritten')][contains(@name, 'Transformation')][contains(@name, 'Party')])[1]")
    public WebElement RisksWrittenTransformationParty;

    @FindBy(xpath = "(//input[contains(@name, 'RisksWritten')][contains(@name, 'Transformation')][contains(@name, 'Participant')])[1]")
    public WebElement RisksWrittenTransformationParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'RisksWritten')][contains(@name, 'Assignment')][contains(@name, 'Party')])[1]")
    public WebElement RisksWrittenAssignmentParty;

    @FindBy(xpath = "(//input[contains(@name, 'RisksWritten')][contains(@name, 'Assignment')][contains(@name, 'Participant')])[1]")
    public WebElement RisksWrittenAssignmentParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'RisksWritten')][contains(@name, 'Approval')][contains(@name, 'Party')])[1]")
    public WebElement RisksWrittenApprovalParty;

    @FindBy(xpath = "(//input[contains(@name, 'RisksWritten')][contains(@name, 'Approval')][contains(@name, 'Participant')])[1]")
    public WebElement RisksWrittenApprovalParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'PaidPremium')][contains(@name, 'Submission')][contains(@name, 'Party')])[1]")
    public WebElement PaidPremiumSubmissionParty;

    @FindBy(xpath = "(//input[contains(@name, 'PaidPremium')][contains(@name, 'Submission')][contains(@name, 'Participant')])[1]")
    public WebElement PaidPremiumSubmissionParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'PaidPremium')][contains(@name, 'Transformation')][contains(@name, 'Party')])[1]")
    public WebElement PaidPremiumTransformationParty;

    @FindBy(xpath = "(//input[contains(@name, 'PaidPremium')][contains(@name, 'Transformation')][contains(@name, 'Participant')])[1]")
    public WebElement PaidPremiumTransformationParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'PaidPremium')][contains(@name, 'Assignment')][contains(@name, 'Party')])[1]")
    public WebElement PaidPremiumAssignmentParty;

    @FindBy(xpath = "(//input[contains(@name, 'PaidPremium')][contains(@name, 'Assignment')][contains(@name, 'Participant')])[1]")
    public WebElement PaidPremiumAssignmentParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'PaidPremium')][contains(@name, 'Approval')][contains(@name, 'Party')])[1]")
    public WebElement PaidPremiumApprovalParty;

    @FindBy(xpath = "(//input[contains(@name, 'PaidPremium')][contains(@name, 'Approval')][contains(@name, 'Participant')])[1]")
    public WebElement PaidPremiumApprovalParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'Claims')][contains(@name, 'Submission')][contains(@name, 'Party')])[1]")
    public WebElement ClaimsSubmissionParty;
    
    @FindBy(xpath = "(//select[contains(@name, 'Aggregates')][contains(@name, 'Submission')][contains(@name, 'Party')])[1]")
    public WebElement AggregatesSubmissionParty;

    @FindBy(xpath = "(//input[contains(@name, 'Aggregates')][contains(@name, 'Submission')][contains(@name, 'Participant')])[1]")
    public WebElement AggregatesSubmissionParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'Aggregates')][contains(@name, 'Transformation')][contains(@name, 'Party')])[1]")
    public WebElement AggregatesTransformationParty;

    @FindBy(xpath = "(//input[contains(@name, 'Aggregates')][contains(@name, 'Transformation')][contains(@name, 'Participant')])[1]")
    public WebElement AggregatesTransformationParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'Aggregates')][contains(@name, 'Assignment')][contains(@name, 'Party')])[1]")
    public WebElement AggregatesAssignmentParty;

    @FindBy(xpath = "(//input[contains(@name, 'Aggregates')][contains(@name, 'Assignment')][contains(@name, 'Participant')])[1]")
    public WebElement AggregatesAssignmentParticipant;

    @FindBy(xpath = "(//select[contains(@name, 'Aggregates')][contains(@name, 'Approval')][contains(@name, 'Party')])[1]")
    public WebElement AggregatesApprovalParty;

    @FindBy(xpath = "(//input[contains(@name, 'Aggregates')][contains(@name, 'Approval')][contains(@name, 'Participant')])[1]")
    public WebElement AggregatesApprovalParticipant;

    @FindBy(xpath = "//button[contains(@name, 'ReportingAndAggregate')][text()='Apply']")
    public WebElement ApplyReportingAndAggregate;
    

    /**
     *      Accordion ------ Capacity Details
     */
    
    @FindBy(xpath = "(//div[contains(@aria-label, 'Capacity Details')])[1]")
    public WebElement CapacityDetailsTab;

    @FindBy(xpath = "(//select[contains(@name, 'ContractLeadType')][contains(@name, 'SectionLead')])[1]")
    public WebElement LeadType;

    @FindBy(xpath = "(//select[contains(@name, 'ContractLeadType')][contains(@name, 'SectionFollow')])[1]")
    public WebElement FollowType;

    @FindBy(xpath = "(//input[contains(@name, 'SyndicateSearchCriteria')][contains(@name, 'SectionLead')])[1]")
    public WebElement SyndicateLead;

    @FindBy(xpath = "//input[contains(@name, 'SyndicateList')][contains(@name, 'CompanyReference')]")
    public WebElement SyndicateLeadCompanyReference;

    @FindBy(xpath = "//input[contains(@name, 'SyndicateList')][contains(@name, 'SectionLead')][contains(@name, 'SignedLine')]")
    public WebElement SyndicateLeadSignedLine;

    @FindBy(xpath = "//input[contains(@name, 'SyndicateList')][contains(@name, 'SectionLead')][contains(@name, 'WrittenLine')]")
    public WebElement SyndicateLeadWrittenLine;

    @FindBy(xpath = "//input[contains(@name, 'SyndicateSearchCriteria')][contains(@name, 'SectionFollow')]")
    public WebElement SyndicateFollow;

    @FindBy(xpath = "//input[contains(@name, 'SectionFollow')][contains(@name, 'SyndicateList')][contains(@name, 'CompanyReference')]")
    public WebElement SyndicateFollowCompanyReference;
    
    @FindBy(xpath = "//input[contains(@name, 'SyndicateList')][contains(@name, 'SectionFollow')][contains(@name, 'SignedLine')]")
    public WebElement SyndicateFollowSignedLine;

    @FindBy(xpath = "//input[contains(@name, 'ServiceCompanySearchCriteria')][contains(@name, 'SectionLead')]")
    public WebElement ServiceCompanyLead;

    @FindBy(xpath = "//button[contains(@name, 'ContractLeadSearch')][contains(@name, 'SectionLead')]")
    public WebElement SearchButtonServiceCompanyLead;

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

    @FindBy(xpath = "(//input[contains(@name, 'NonLloydsSearchCriteria')][contains(@name, 'SectionLead')])[2]")
    public WebElement NonLloydsInsurerLead;

    @FindBy(xpath = "//td[contains(@class, 'autocomplete')]")
    public List<WebElement> NonLloydsInsurerList;

    @FindBy(xpath = "//input[contains(@name, 'NonLloydsInsurerList')][contains(@name, 'SignedLine')][contains(@name, 'SectionLead')]")
    public WebElement NonLloydsInsurerLeadSignedLine;

    @FindBy(xpath = "//input[contains(@name, 'NonLloydsSearchCriteria')][contains(@name, 'SectionFollow')]")
    public WebElement NonlloydsInsurerFollow;

    @FindBy(xpath = "//input[contains(@name, 'NonLloydsInsurerList')][contains(@name, 'SignedLine')][contains(@name, 'SectionFollow')]")
    public WebElement NonLloydsInsurerFollowSignedLine;

    @FindBy(xpath = "//button[contains(@name, 'CapacityDetails')][text()='Apply']")
    public WebElement ApplyCapacityDetails;

    @FindBy(xpath = "(//span[contains(@name, 'DateConfirmReceived')])[1]")
    public WebElement ConfirmationDate;

    @FindBy(xpath = "//a[@class='today-link']")
    public WebElement TodayLink;

    /**
     *      Accordion ------ Non - Schedule 
     */
    
    @FindBy(xpath = "(//div[contains(@aria-label, 'Non-Schedule')])[1]")
    public WebElement NonScheduleTab;
    
    @FindBy(xpath = "(//input[contains(@name, 'NonSchedulerDetails')][contains(@name, 'CurrencyCode')])[1]")
    public WebElement GrossEPICurrency;

    @FindBy(xpath = "(//input[contains(@name, 'GrossEPI')])[1]")
    public WebElement GrossEPI;

    @FindBy(xpath = "(//select[contains(@name, 'WrittenLineValues')])[1]")
    public WebElement BasisWrittenLine;

    @FindBy(xpath = "(//select[contains(@name, 'SignedLineValues')])[1]")
    public WebElement BasisSignedLine;

    @FindBy(xpath = "(//select[contains(@name, 'SigningProvisionsValues')])[1]")
    public WebElement SigningProvision;

    @FindBy(xpath = "(//input[contains(@name, 'TotalLloydsBrokerage')])[1]")
    public WebElement LloydsBrokerage;

    @FindBy(xpath = "(//input[contains(@name, 'CheckTotalLloydsBrokerage')][@type='checkbox'])[1]")
    public WebElement LloydsBrokerageCheck;

    @FindBy(xpath = "(//input[contains(@name, 'ManualBrokerageCurrencyCode')])[1]")
    public WebElement ManualBrokerageCurrencyCode;

    @FindBy(xpath = "(//input[contains(@name, 'ManualTotalBrokerage')])[1]")
    public WebElement ManualBrokerage;

    @FindBy(xpath = "(//select[contains(@name, 'NonSchedulePlatform')])[1]")
    public WebElement Platform;

    @FindBy(xpath = "(//span[contains(text(), 'Brussels Subsidiary')])[1]")
    public WebElement PlatformReadOnlyLBS;

    @FindBy(xpath = "//a[@class='iconDelete'][contains(@name, 'NonSchedulePlatformValues')]")
    public WebElement PlatformDeleteIcon;

    @FindBy(xpath = "(//textarea[contains(@name, 'OtherDeductionsText')])[1]")
    public WebElement OtherDeductions;

    @FindBy(xpath = "(//select[contains(@name, 'ProductRiskRatingValues')])[1]")
    public WebElement ProductRiskRating;

    @FindBy(xpath = "(//select[contains(@name, 'RouteOfValues')])[1]")
    public WebElement RouteOfBusiness;

    @FindBy(xpath = "//button[contains(@name, 'NonSchedule')][text()='Apply']")
    public WebElement ApplyNonSchedule;
    
}