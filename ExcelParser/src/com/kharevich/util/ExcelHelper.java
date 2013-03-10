package com.kharevich.util;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;

public class ExcelHelper {

	private static Map<String, Integer> status = new HashMap<String, Integer>();
	{
		status.put("резерв", 0);
		status.put("дней", 100);
		status.put("дня", 100);
		status.put("день", 100);
	};

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

	public static int getStatus(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			String s = cell.getStringCellValue().toLowerCase();
			for (Entry<String, Integer> pair : status.entrySet()) {
				if (s.contains(pair.getKey())) {
					System.out.println("ok");
					return pair.getValue();
				}
			}
			System.out.println("err"+s);
			break;
		case Cell.CELL_TYPE_NUMERIC:
			cell.getNumericCellValue();

		}
		return 0;
	}
}
