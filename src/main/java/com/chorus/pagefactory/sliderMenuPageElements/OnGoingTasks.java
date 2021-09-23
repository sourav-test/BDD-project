package com.chorus.pagefactory.sliderMenuPageElements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnGoingTasks {

    @FindBy(xpath = "//iframe[contains(@title, 'Cases')]")
    public WebElement PegaOngoingTaskFrame;

    @FindBy(xpath = "//a[contains(@name, 'MyCases')][contains(text(), 'DA-')]")
    public List<WebElement> UniqueIdentifierListOngTask;

    @FindBy(xpath = "//a[contains(@name, 'MyCases')][contains(text(), 'DA-')]")
    public WebElement UniqueIdentifierOngTask;

    @FindBy(xpath = "//a[contains(@name, 'MyCases')][contains(text(), 'B')]")
    public WebElement UMROngTask;

    @FindBy(xpath = "//span[text()='Create Registration'][contains(@data-click, 'OPEN')]")
    public WebElement TaskTypeOngTask;

    @FindBy(xpath = "//div[contains(@class, 'oflowDivM ')]//following::span[contains(@style, 'width')]")
    public WebElement TaskStatusOngTask;
    
}
