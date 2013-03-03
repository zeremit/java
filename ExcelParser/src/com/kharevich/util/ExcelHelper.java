package com.kharevich.util;

import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.Cell;

public class ExcelHelper {
	public static String getString(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_NUMERIC:
			DecimalFormat df = new DecimalFormat("#");
			df.setDecimalSeparatorAlwaysShown(false);
			return df.format(cell.getNumericCellValue());

		}
		return "";

	}
}
