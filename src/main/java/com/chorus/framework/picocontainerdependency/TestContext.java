package com.chorus.framework.picocontainerdependency;

import com.chorus.framework.controllers.FileReaderController;
import com.chorus.framework.controllers.PageFactoryController;
import com.chorus.framework.controllers.WebDriverController;
import com.chorus.framework.webelementutility.WebElementUtil;

public class TestContext {

    private WebDriverController webDriverController;

    private PageFactoryController pageFactoryController;

    private FileReaderController fileReaderController;
    
    private WebElementUtil webElementUtil;

    public TestContext() {

        webDriverController = new WebDriverController();
        pageFactoryController = new PageFactoryController(webDriverController.getDriver()); 
        fileReaderController = new FileReaderController();
        webElementUtil = new WebElementUtil(webDriverController.getDriver());
    }

    public WebDriverController getWebDriverController() {

        return webDriverController;
    }

    public PageFactoryController getPageFactoryController() {

        return pageFactoryController;
    }

    public FileReaderController getFileReaderController() {

        return fileReaderController;
    }

    public WebElementUtil getWebElementUtil() {
        
        return webElementUtil;
    }
    
}
