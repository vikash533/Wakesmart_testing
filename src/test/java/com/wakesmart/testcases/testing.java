package com.wakesmart.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class testing {

	public static void main(String[] args) {
		
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("M/dd/yyyy h:mm a");
		String str = formatter.format(date);
		String strrr =str.substring(0, 9);
		System.out.println(strrr);
	}

}
