package com.acti.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib {
	XSSFWorkbook wb;

	public ExcelLib(String excelPath)
	{
		try {
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	public int getRowCount(int sheetNum) {
		return wb.getSheetAt(sheetNum).getLastRowNum() + 1;
	}

	public String getCellData(int sheetNum, int row, int cell) {
		
		return wb.getSheetAt(sheetNum).getRow(row).getCell(cell).toString();

	}

}
