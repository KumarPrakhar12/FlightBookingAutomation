package utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;

public class ExcelReader {

public static Object[][] getData(String path,String sheetName){

try{

FileInputStream file=new FileInputStream(path);

Workbook wb=WorkbookFactory.create(file);

Sheet sheet=wb.getSheet(sheetName);

int rows=sheet.getPhysicalNumberOfRows();

int cols=sheet.getRow(0).getPhysicalNumberOfCells();

Object[][] data=new Object[rows-1][cols];

for(int i=1;i<rows;i++){

for(int j=0;j<cols;j++){

data[i-1][j]=sheet.getRow(i).getCell(j).toString();

}

}

return data;

}

catch(Exception e){

return null;

}

}

}