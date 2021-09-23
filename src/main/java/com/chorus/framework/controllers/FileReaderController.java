package com.chorus.framework.controllers;

import com.chorus.framework.dataprovider.ExcelReader;
import com.chorus.framework.dataprovider.PropertiesReader;

/**
 * @author p.a.kumar.banerjee
 */

public class FileReaderController {

    private static FileReaderController inputFileController = new FileReaderController();

    private static PropertiesReader propertiesReader;

    private static ExcelReader excelReader;
    
    public static FileReaderController getInstance() {
        
        return inputFileController;
    }

    public PropertiesReader getPropertiesReader() {

        if(propertiesReader==null)
        propertiesReader = new PropertiesReader();
        return propertiesReader;
    }

    public ExcelReader getExcelReader() {

        if(excelReader==null)
        excelReader = new ExcelReader();
        return excelReader;
    }
}
