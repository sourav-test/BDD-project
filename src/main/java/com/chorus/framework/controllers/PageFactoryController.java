package com.chorus.framework.controllers;

import com.chorus.pagefactory.authentication.ApplicationAccess;
import com.chorus.pagefactory.commonobjects.Common;
import com.chorus.pagefactory.createContractPageElements.AgreementTemplatePage;
import com.chorus.pagefactory.createContractPageElements.BrokerDetailsPage;
import com.chorus.pagefactory.createContractPageElements.CommonSectionDetailsPage;
import com.chorus.pagefactory.createContractPageElements.ContractLeadsPage;
import com.chorus.pagefactory.createContractPageElements.ContractReviewPage;
import com.chorus.pagefactory.createContractPageElements.GeneralContractInformationPage;
import com.chorus.pagefactory.createContractPageElements.HomePage;
import com.chorus.pagefactory.createContractPageElements.IndividualSectionDetailsPage;
import com.chorus.pagefactory.sliderMenuPageElements.CompletedContracts;
import com.chorus.pagefactory.sliderMenuPageElements.ContractRecord;
import com.chorus.pagefactory.sliderMenuPageElements.MyTasks;
import com.chorus.pagefactory.sliderMenuPageElements.MyTeamsTasks;
import com.chorus.pagefactory.sliderMenuPageElements.OnGoingTasks;
import com.chorus.pagefactory.sliderMenuPageElements.SearchContracts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author p.a.kumar.banerjee
 */

public class PageFactoryController {

    private WebDriver driver;
    
    public PageFactoryController(WebDriver driver) {

        this.driver=driver;
    }

    public ApplicationAccess getApplicationAccess() {

        return PageFactory.initElements(driver, ApplicationAccess.class);
    }

    public Common getCommon() {

        return PageFactory.initElements(driver, Common.class);
    }

    public HomePage getHome() {

        return PageFactory.initElements(driver, HomePage.class);
    }

    public AgreementTemplatePage getAgreementTemplate() {

        return PageFactory.initElements(driver, AgreementTemplatePage.class);
    }

    public GeneralContractInformationPage getGeneralContractInformation() {

        return PageFactory.initElements(driver, GeneralContractInformationPage.class);
    }

    public BrokerDetailsPage getBrokerDetails() {

        return PageFactory.initElements(driver, BrokerDetailsPage.class);
    }

    public ContractLeadsPage getContractLeads() {

        return PageFactory.initElements(driver, ContractLeadsPage.class);
    }

    public CommonSectionDetailsPage getCommonSectionDetails() {

        return PageFactory.initElements(driver, CommonSectionDetailsPage.class);
    }

    public IndividualSectionDetailsPage getIndividualSectionDetails() {

        return PageFactory.initElements(driver, IndividualSectionDetailsPage.class);
    }

    public ContractReviewPage getContractReview() {

        return PageFactory.initElements(driver, ContractReviewPage.class);
    }

    public CompletedContracts getCompletedContracts() {

        return PageFactory.initElements(driver, CompletedContracts.class);
    }

    public ContractRecord getContractRecord() {

        return PageFactory.initElements(driver, ContractRecord.class);
    }

    public MyTasks getMyTasks() {

        return PageFactory.initElements(driver, MyTasks.class);
    }

    public MyTeamsTasks getMyTeamsTasks() {

        return PageFactory.initElements(driver, MyTeamsTasks.class);
    }

    public OnGoingTasks getOnGoingTasks() {

        return PageFactory.initElements(driver, OnGoingTasks.class);
    }

    public SearchContracts getSearchContracts() {

        return PageFactory.initElements(driver, SearchContracts.class);
    }
}
