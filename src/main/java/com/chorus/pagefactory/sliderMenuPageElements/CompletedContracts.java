package com.chorus.pagefactory.sliderMenuPageElements;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompletedContracts {

    @FindBy(xpath = "//iframe[@title='CompletedContracts']")
    public WebElement PegaCompletedContractsFrame;

    @FindBy(xpath = "//a[contains(@name, 'CompletedContractList')][contains(text(), 'DA-')]")
    public List<WebElement> UniqueIdentifierListCompletedContracts;

    @FindBy(xpath = "//a[contains(@name, 'CompletedContractList')][contains(text(), 'DA-')]")
    public WebElement UniqueIdentifierCompletedContracts;

    @FindBy(xpath = "//a[contains(@name, 'CompletedContractList')][contains(text(), 'B')]")
    public List<WebElement> UMRListCompletedContracts;

    @FindBy(xpath = "//a[contains(@name, 'CompletedContractList')][contains(text(), 'B')]")
    public WebElement UMRCompletedContracts;

    @FindBy(xpath = "(//input[contains(@name, 'CompletedContracts')][@type='checkbox'])[2]")
    public WebElement CompletedContractsFilterCheckbox;

    @FindBy(xpath = "(//div[contains(@class, 'oflowDivM ')]//following::span)[3]")
    public WebElement CompletedContractsTaskStatus;

    @FindBy(xpath = "(//div[contains(@class, 'oflowDivM ')]//following::span)[6]")
    public WebElement CompletedContractsContractType;
    
}
