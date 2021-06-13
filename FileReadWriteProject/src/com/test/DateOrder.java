package com.test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class DateOrder {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, ParseException {
		
		File file = new File("C:\\Users\\rubhi\\Desktop\\test.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		ArrayList<LogDataDTO> logDtoList = new ArrayList<LogDataDTO>();
		ArrayList<String> finalFilteredLogs = new ArrayList<String>();
		String logType = "L: WARN";
		String User = "Raja";
		String startDateStr = "2021-05-24 00:30";
		String endDateStr = "2021-05-24 01:20";
		if(startDateStr != null && startDateStr!="" && endDateStr != null && endDateStr!="") {
			java.util.Date ip_StartDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startDateStr);
			java.util.Date ip_EndDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(endDateStr);
				while ((st = br.readLine()) != null) {
					if(st.contains(logType)) {
					String newsubstring = st.substring(0, 16);
					java.util.Date logDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(newsubstring);
					int date = logDate.getDate();
					int month = logDate.getMonth();
					int year = logDate.getYear();
					int hours = logDate.getHours();
					int minutes = logDate.getMinutes();
					String actualLog = st;
					LogDataDTO logDataDto = new LogDataDTO(date, month, year, hours, minutes, logDate, actualLog);
					logDtoList.add(logDataDto);
				}
			}
			finalFilteredLogs = filterLogsWithDate(ip_StartDate, ip_EndDate, logDtoList);
		}else {
			while ((st = br.readLine()) != null) {
				if(st.contains(logType)) {
					String newsubstring = st.substring(0, 16);
					java.util.Date logDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(newsubstring);
					int date = logDate.getDate();
					int month = logDate.getMonth();
					int year = logDate.getYear();
					int hours = logDate.getHours();
					int minutes = logDate.getMinutes();
					String actualLog = st;
					LogDataDTO logDataDto = new LogDataDTO(date, month, year, hours, minutes, logDate, actualLog);
					logDtoList.add(logDataDto);
				}
			}
			finalFilteredLogs = filterLogsWithType(logDtoList);
		}
		//print for reference
		printLogs(finalFilteredLogs);
	}
	
	/**
	 * @param ip_StartDate
	 * @param ip_EndDate
	 * @param logDtoList
	 * @return filteredList
	 * To filter logs with Type,Start date & End date
	 */
	public static ArrayList<String> filterLogsWithDate(Date ip_StartDate, Date ip_EndDate, ArrayList<LogDataDTO> logDtoList) {
		ArrayList<String> filteredList = new ArrayList<String>();
		for(int i=0;i<logDtoList.size();i++) {
			if(logDtoList.get(i).getLogDate().compareTo(ip_StartDate) >=0 && logDtoList.get(i).getLogDate().compareTo(ip_EndDate) <= 0) {
				filteredList.add(logDtoList.get(i).getActualLog());
			}
		}
		return filteredList;
	}
	/**
	 * @param logDtoList
	 * @return filteredList
	 * To filter logs with type alone
	 */
	public static ArrayList<String> filterLogsWithType(ArrayList<LogDataDTO> logDtoList){
		ArrayList<String> filteredList = new ArrayList<String>();
		for(int i=0;i<logDtoList.size();i++) {
				filteredList.add(logDtoList.get(i).getActualLog());
		}
		return filteredList;
	}
	/**
	 * @param filteredList
	 * To print the logs in console
	 */
	public static void printLogs(ArrayList<String> filteredList) {
		for(int i=0;i<filteredList.size();i++) {
			System.out.println(filteredList.get(i));
		}
	}
	
}
