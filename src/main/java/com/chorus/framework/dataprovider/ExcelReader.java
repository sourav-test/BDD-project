package com.chorus.framework.dataprovider;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author p.a.kumar.banerjee
 */

public class ExcelReader {

    private static String sheetdirectory = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData";

    /**
     * Read testdata from Excel Workbook (DCOMAutomationTestData.xlsx)
     * 
     * @param Excel Workbook sheetname
     * @return List
     */
    
    public List<HashMap<String, String>> GetTestData(String sheetname)
    {
        List<HashMap<String, String>> data = new ArrayList<>();
        try
        {
            FileInputStream testdatarepo = new FileInputStream(sheetdirectory+"\\DCOMAutomationTestData.xlsx");
            XSSFWorkbook excelworkbook = new XSSFWorkbook(testdatarepo);
            XSSFSheet excelsheet = excelworkbook.getSheet(sheetname);
            Row columnnamerow = excelsheet.getRow(0);
            for(int row = 1; row<excelsheet.getPhysicalNumberOfRows(); row++)
            {
                Row currentRow = excelsheet.getRow(row);
                HashMap<String, String> currentRowData = new HashMap<>();
                for(int cell = 0; cell<currentRow.getPhysicalNumberOfCells(); cell++)
                {
                    Cell currentCell = currentRow.getCell(cell);
                    currentRowData.put(columnnamerow.getCell(cell).getStringCellValue(), currentCell.getStringCellValue()); 
                }
                data.add(currentRowData);
            }
            excelworkbook.close();
            testdatarepo.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return data;
    }
}