package com.chorus.pagefactory.sliderMenuPageElements;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchContracts {

    @FindBy(xpath = "//iframe[contains(@title, 'Search')]")
    public WebElement PegaSearchContractFrame;
    
    @FindBy(xpath = "(//label[text()='UMR']//following::input)[1]")
    public WebElement UMRSearch;

    @FindBy(xpath = "(//label[text()='Unique Identifier']//following::input)[1]")
    public WebElement UniqueIdentifierSearch;
    
    @FindBy(xpath = "//input[contains(@name, 'InceptionDateFrom')]")
    public WebElement InceptionDateFromSearch;

    @FindBy(xpath = "(//input[contains(@name, 'InceptionDateFrom')]//following::img[contains(@name, 'Calendar')])[1]")
    public WebElement InceptionDateCalendar;

    @FindBy(xpath = "(//label[text()='Contract Inception Date (To)']//following::input)[1]")
    public WebElement InceptionDateToSearch;

    @FindBy(xpath = "(//label[text()='Third Party Participant / PIN']//following::input)[1]")
    public WebElement MarketParticipantSearch;

    @FindBy(xpath = "(//label[text()='Master UMR']//following::input)[1]")
    public WebElement MasterUMRSearch;

    @FindBy(xpath = "(//label[text()='Contract Expiry Date (From)']//following::input)[1]")
    public WebElement ExpiryDateFromSearch;

    @FindBy(xpath = "(//label[text()='Contract Expiry Date(To)']//following::input)[1]")
    public WebElement ExpiryDateToSearch;

    @FindBy(xpath = "(//label[text()='Contract Type']//following::select)[1]")
    public WebElement ContractTypeSearch;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement SearchButton;

    @FindBy(xpath = "//button[text()='Clear Search']")
    public WebElement ClearSearchButton;

    @FindBy(xpath = "(//div[text()='Unique Identifier']//following::span[contains(@title, 'ascending')])[1]")
    public WebElement DefaultSortUniqueIdentifier;

    @FindBy(xpath = "(//div[text()='Inception Date']//following::span[contains(@title, 'ascending')])[1]")
    public WebElement DefaultSortInceptionDate;

    @FindBy(xpath = "(//div[text()='Third Party Participant']//following::span[contains(@title, 'ascending')])[1]")
    public WebElement DefaultSortParticipant;

    @FindBy(xpath = "//a[contains(@name, 'ContractSearchSection')][contains(text(), 'DA-')]")
    public List<WebElement> UniqueIdentifierListSearchContracts;

    @FindBy(xpath = "//a[contains(@name, 'ContractSearchSection')][contains(text(), 'B')]")
    public List<WebElement> UMRListSearchContracts;
    
}