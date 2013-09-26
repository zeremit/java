package com.kharevich.util;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.util.StringUtil;

import antlr.StringUtils;

public class ExcelHelper {
	
	private static final Pattern digitalPattern = Pattern.compile("\\d+");

	private static Map<String, Integer> status = new HashMap<String, Integer>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6244173495815534740L;

	{
		put("резерв", 0);
		put("дней", 10);
		put("дня", 10);
		put("день", 10);
	}};

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
					return pair.getValue()*extractNumber(s);
				}
			}
			break;
		case Cell.CELL_TYPE_NUMERIC:
			return (int) cell.getNumericCellValue();

		}
		return 0;
	}
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	public static int getStatus(String cell) {
		if(isInteger(cell)){
			return Integer.parseInt(cell);
		}else{
			String s = cell.toLowerCase();
			for (Entry<String, Integer> pair : status.entrySet()) {
				if (s.contains(pair.getKey())) {
					return pair.getValue()*extractNumber(s);
				}
			}
		}
		return 0;
	}
	
	private static int extractNumber(String s){
		Matcher m = digitalPattern.matcher(s); 
		while (m.find()) {
		   return Integer.valueOf(m.group());
		}
		return 1;
	}
}
