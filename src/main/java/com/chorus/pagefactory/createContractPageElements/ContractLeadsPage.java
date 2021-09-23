package com.chorus.pagefactory.createContractPageElements;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Factory Class
 * Contract Leads
 */

public class ContractLeadsPage {

    @FindBy(xpath = "//h3[text()='Contract Lead(s)'][@class='layout-group-item-title']")
    public WebElement ContractLeadTab;

    @FindBy(xpath = "//label[text()='Lead Type']")
    public WebElement SyndicateText;

    @FindBy(xpath = "//tr[contains(@id, 'ListSyndicateLead')]")
    public List<WebElement> SyndicateAutoRecommend;

    @FindBy(xpath = "(//div[@string_type='label'][contains(text(), 'Maximum')])[2]")
    public WebElement SyndicateMaxMsg;

    @FindBy(xpath = "//select[@class='standard'][contains(@name, 'ContractLeadType')]")
    public WebElement LeadType;

    @FindBy(xpath = "//select[@class='standard'][contains(@name, 'BrusselsContractLead')]")
    public WebElement BrusselsLeadType;

    @FindBy(xpath = "//input[@class='autocomplete_input'][contains(@name, 'SyndicateSearchCriteria')]")
    public WebElement SyndicateSearch;

    @FindBy(xpath = "//input[@class='autocomplete_input'][contains(@name, 'BrusselsLead')][contains(@name, 'SyndicateSearchCriteria')]")
    public WebElement BrusselsSyndicateSearch;

    @FindBy(xpath = "//a[contains(@name, 'SyndicateList')]")
    public WebElement SyndicateDeleteIcon;

    @FindBy(xpath = "//input[contains(@name, 'ServiceCompanySearchCriteria')]")
    public WebElement ServiceCompanySearch;

    @FindBy(xpath = "//input[contains(@name, 'ServiceCompanyUMR')]")
    public WebElement ServiceCompanyUMR;

    @FindBy(xpath = "//button[contains(@name, 'LeadSearch')]")
    public WebElement ServiceCompanySearchButton;

    @FindBy(xpath = "//span[contains(@id, 'modaldialog_hd_title')][contains(text(), 'Search Service')]")
    public WebElement ServiceCompanyHeader;

    @FindBy(xpath = "//input[contains(@name, 'NonLloydsSearchCriteria')]")
    public WebElement NonLloydsSearch;

    @FindBy(xpath = "//td[contains(@class, 'autocomplete')]")
    public List<WebElement> NonLloydsList;

    @FindBy(xpath = "//div[contains(text(), 'cannot be the only Contract Lead')]")
    public WebElement NonLloydsError;

    @FindBy(xpath = "//button[@alt='Add']")
    public WebElement AddButton;

    @FindBy(xpath = "//span[contains(text(), 'There must be at least 1 London')]")
    public WebElement TwinContractBrusslesLeadErrorContractLeads;
    
}
