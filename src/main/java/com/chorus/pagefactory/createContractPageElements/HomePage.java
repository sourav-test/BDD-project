package com.chorus.pagefactory.createContractPageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Factory Class
 * DCOM Home Page Objects
 */

public class HomePage {

    @FindBy(xpath = "//iframe[contains(@title, 'Home')]")
    public WebElement PegaDefaultFrame;
    
    @FindBy(xpath = "//a[@class='Header_nav']")
    public WebElement HomePageLink;

    @FindBy(xpath = "//a[contains(@data-click, 'My Teams')]")
    public WebElement MyTeamsTasks;

    @FindBy(xpath = "//a[contains(@data-click, 'Cases')]")
    public WebElement OngoingTasks;

    @FindBy(xpath = "//a[contains(@data-click, 'MyContracts')]")
    public WebElement MyTasks;

    @FindBy(xpath = "//a[contains(@data-click, 'CompletedContracts')]")
    public WebElement CompletedTasks;

    @FindBy(xpath = "//a[contains(@data-click, 'ContractSearch')]")
    public WebElement SearchContracts;

    @FindBy(xpath = "//div[contains(text(), 'Create/Register')]")
    public WebElement CreateContractButton;
    
}
