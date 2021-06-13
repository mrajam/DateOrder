package com.test;

import java.util.Date;

public class LogDataDTO {
	public int day;
	public int month;
	public int year;
	public int hours;
	public int minutes;
	public Date logDate;
	public String actualLog;
	
	public LogDataDTO(int day, int month, int year, int hours, int minutes, Date logDate, String actualLog) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.hours = hours;
		this.minutes = minutes;
		this.logDate = logDate;
		this.actualLog = actualLog;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public Date getLogDate() {
		return logDate;
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	public String getActualLog() {
		return actualLog;
	}
	public void setActualLog(String actualLog) {
		this.actualLog = actualLog;
	}

}
