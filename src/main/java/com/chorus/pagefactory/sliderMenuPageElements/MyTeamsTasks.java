package com.chorus.pagefactory.sliderMenuPageElements;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyTeamsTasks {

    @FindBy(xpath = "//iframe[@title='My Teams']")
    public WebElement PegaMyGroupsFrame;

    @FindBy(xpath = "//a[contains(@name, 'MyUserGroup')][contains(text(), 'DA-')]")
    public List<WebElement> UniqueIdentifierListMyTeams;

    @FindBy(xpath = "//a[contains(@name, 'MyUserGroup')][contains(text(), 'DA-')]")
    public WebElement UniqueIdentifierMyTeams;

    @FindBy(xpath = "//a[contains(@name, 'MyUserGroup')][contains(text(), 'B')]")
    public List<WebElement> UMRListMyTeams;

    @FindBy(xpath = "//a[contains(@name, 'MyUserGroup')][contains(text(), 'B')]")
    public WebElement UMRMyTeams;

    @FindBy(xpath = "//td[@data-attribute-name='Assigned to']")
    public List<WebElement> MyTeamsAssignedToList;

    @FindBy(xpath = "(//div[contains(@class, 'oflowDivM ')]//following::span)[4]")
    public WebElement MyTeamsTaskType;

    @FindBy(xpath = "(//div[contains(@class, 'oflowDivM ')]//following::span)[5]")
    public WebElement MyTeamsTaskStatus;

    @FindBy(xpath = "(//div[contains(@class, 'oflowDivM ')]//following::span)[9]")
    public WebElement MyTeamsContractType;
    
}