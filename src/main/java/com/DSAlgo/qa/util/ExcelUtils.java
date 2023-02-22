package com.DSAlgo.qa.util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {

    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;

    public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

        String[][] tabArray = null;
        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int totalRows = ExcelWSheet.getLastRowNum();
            int totalCols = ExcelWSheet.getRow(0).getLastCellNum();
            tabArray = new String[totalRows][totalCols];

            for (int i = 0; i < totalRows; i++) {
                for (int j = 0; j < totalCols; j++) {

                    tabArray[i][j] = ExcelWSheet.getRow(i + 1).getCell(j).toString();

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }

        return (tabArray);
    }

}
