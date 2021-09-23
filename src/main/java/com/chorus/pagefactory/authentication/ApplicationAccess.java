package com.chorus.pagefactory.authentication;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Factory Class
 * Application Access Login Logout
 */


public class ApplicationAccess {

    @FindBy(id = "txtUserID")
    public WebElement UsernameField;

    @FindBy(id = "txtPassword")
    public WebElement PasswordField;

    @FindBy(id = "sub")
    public WebElement LoginButton;

    @FindBy(xpath = "//span[text()='Log off']")
    public WebElement LogOfflink;
    
}
