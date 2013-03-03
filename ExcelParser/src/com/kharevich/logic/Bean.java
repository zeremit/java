package com.kharevich.logic;

import java.lang.reflect.Field;

public class Bean {

	public String toParams()  {
		String prefix = "<property name=\"";
		String middle = "\" value=\"";
		String postfix = "\"/>";
		Field[] field = this.getClass().getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		for (Field t : field) {
			try {
				sb.append(prefix).append(t.getName()).append(middle)
						.append(t.get(this)).append(postfix).append("\n");
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}
