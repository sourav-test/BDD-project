package com.chorus.pagefactory.sliderMenuPageElements;

import java.util.List;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class MyTasks {

    @FindBy(xpath = "//iframe[contains(@title, 'Contracts')]")
    public WebElement MyTasksFrame;

    @FindBy(xpath = "//td[@data-attribute-name='Assigned to']")
    public List<WebElement> AssignedToList;

    @FindBy(xpath = "//td[@data-attribute-name='Unique Identifier']")
    public List<WebElement> UniqueIdentifierList;

    @FindBy(xpath = "//td[@data-attribute-name='Unique Identifier']")
    public WebElement UniqueIdentifier;
    
    @FindBy(xpath = "//a[contains(@name, 'MyWorkList')][contains(text(), 'B')]")
    public List<WebElement> UMRList;

    @FindBy(xpath = "//a[contains(@name, 'MyWorkList')][contains(text(), 'B')]")
    public WebElement UMR;

    @FindBy(xpath = "(//div[contains(@class, 'oflowDivM ')]//following::span)[4]")
    public WebElement TaskType;

    @FindBy(xpath = "(//div[contains(@class, 'oflowDivM ')]//following::span)[5]")
    public WebElement TaskStatus;

    @FindBy(xpath = "(//div[contains(@class, 'oflowDivM ')]//following::span)[9]")
    public WebElement ContractType;

}