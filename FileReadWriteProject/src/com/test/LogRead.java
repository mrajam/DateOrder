package com.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogRead {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\rubhi\\Desktop\\test.txt");
		String startTime = "2021-05-22 02";
		String endTime = "2021-05-24 04";
		boolean validationFlag = true;
		String[] startDateSplited = startTime.split("-");
		String[] endDateSplited = endTime.split("-");
		int startDate = Integer.parseInt(startDateSplited[2]);
		int endDate = Integer.parseInt(endDateSplited[2]);
		int startMonth = Integer.parseInt(startDateSplited[1]);
		int endMonth = Integer.parseInt(endDateSplited[1]);
		if((startMonth == endMonth) && (startDate>endDate)) {
			validationFlag = false;
		}
		if((startMonth <=  endMonth) && validationFlag) {
			List<String> dayWiseLogs = new ArrayList<String>();
			int numberOfDays = 0;
			String st;
			if(startMonth == endMonth) {
				numberOfDays = (endDate-startDate)+1;
			}
			System.out.println("Number of days : "+numberOfDays);
			for(int i=0;i<numberOfDays;i++) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String valueToAdd = startDateSplited[0]+"-"+startDateSplited[1]+"-"+startDate;
				while ((st = br.readLine()) != null) {
					if (st.contains(valueToAdd)) {
						dayWiseLogs.add(st);
					}
				}
				startDate = startDate + 1;
			}
			System.out.println("------------------------");
			if(dayWiseLogs.size() > 0) {
				for (int i = 0; i < dayWiseLogs.size(); i++) {
					System.out.println(dayWiseLogs.get(i));
				}
			}
			System.out.println("------------------------");
			
		}

		
	}

}
