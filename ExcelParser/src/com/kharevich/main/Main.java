package com.kharevich.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import jxl.LabelCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, BiffException {
		FileInputStream file = new FileInputStream(new File("master2003.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook(file);

		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();
		Set<Integer> type = new HashSet<Integer>();
		rowIterator.next();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
			System.out.println(row.getCell(1).getStringCellValue());
		}

		
	}

}
