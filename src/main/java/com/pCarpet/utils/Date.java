package com.pCarpet.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Date {

	
	public static List<String> formatDateHour(String oldDate) {
		
		List<String> lDate = new ArrayList<>();
		
		
		StringTokenizer st=new StringTokenizer(oldDate," ");
	
		
		
		
		while(st.hasMoreTokens()) {
			String tk=st.nextToken();
			lDate.add(tk);
		}
			
		
		return lDate;
		
	}
	
}
