package com.chorus.pagefactory.createContractPageElements;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Factory Class
 * Broker Details
 */

public class BrokerDetailsPage {


    @FindBy(xpath = "//h3[text()='Broker Details'][@class='layout-group-item-title']")
    public WebElement BrokerDetailsTab;

    @FindBy(xpath = "//input[contains(@name, 'LloydsBroker')]")
    public WebElement BrokerField;

    @FindBy(xpath = "//td[contains(@class, 'autocomplete')]")
    public List<WebElement> BrokerAutoRecommend;

    @FindBy(xpath = "//input[contains(@name, 'FirstName')]")
    public WebElement ContractMngrFirstName;

    @FindBy(xpath = "//input[contains(@name, 'LastName')]")
    public WebElement ContractMngrSurName;

    @FindBy(xpath = "//input[contains(@name, 'ContractManagerEmail')]")
    public WebElement ContractMngrEmail;

    @FindBy(xpath = "(//label[contains(text(),'Broker Number')]//following::select)[1]")
    public WebElement BrokerNumber;

    @FindBy(xpath = "(//label[contains(text(),'Broker User Group')]//following::select)[1]")
    public WebElement BrokerUserGroup;

    @FindBy(xpath = "//a[@class='iconDelete']")
    public WebElement DeleteBroker;

    @FindBy(xpath = "(//div[@string_type='label'][contains(text(), 'Maximum')])[1]")
    public WebElement BrokerMaxMsg;

    @FindBy(xpath = "//input[contains(@name, 'DirectDeal')][@type='checkbox']")
    public WebElement DirectDealing;

    @FindBy(xpath = "//select[contains(@name, 'CSNNumber')]")
    public WebElement CSNNumber;

    @FindBy(xpath = "(//span[contains(text(), 'Central Settlement Number')]//following::span)[1]")
    public WebElement CSNForManagingAgent;

    @FindBy(xpath = "(//span[contains(text(), 'Broker Number')]//following::span)[1]")
    public WebElement CSNForBroker;

    @FindBy(xpath = "//input[contains(@name, 'BrokerReference')]")
    public WebElement BrokerReferenceNumber;

    @FindBy(xpath = "//input[contains(@name, 'ManagingAgentReference')]")
    public WebElement ManagingAgentReferenceNumber;
    
}
